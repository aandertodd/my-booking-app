package com.toddsapp.mybookingapp.controllers;

import com.toddsapp.mybookingapp.models.Shows;
import com.toddsapp.mybookingapp.models.Venue;
import com.toddsapp.mybookingapp.models.data.AdminDao;
import com.toddsapp.mybookingapp.models.data.ShowsDao;
import com.toddsapp.mybookingapp.models.data.VenueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by margareticloud on 7/25/17.
 */
@Controller
@RequestMapping("shows")
public class ShowsController extends AbstractController {

    @RequestMapping(value = "")
    public String index(Model model) {
        
        model.addAttribute("title", "All Shows");
        model.addAttribute("shows", showsDao.findAll());

        return "shows/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayNewShow(Model model) {

        model.addAttribute("title", "Add Show");
        model.addAttribute(new Shows());
        model.addAttribute("venues", venueDao.findAll());
        return "shows/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addShow(Model model, @ModelAttribute @Valid Shows newShow, Errors errors,
                          @RequestParam int venueId, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Show");
            model.addAttribute("venues", venueDao.findAll());
            return "shows/add";
        }
        getAdminFromSession(request.getSession());
        Venue venue = venueDao.findOne(venueId);
        newShow.setVenue(venue);
        showsDao.save(newShow);
        return "redirect:/shows";
    }

    @RequestMapping(value = "venue", method = RequestMethod.GET)
    public String venue(Model model, @RequestParam int id) {

        Venue venue = venueDao.findOne(id);
        List<Shows> shows = venue.getShows();
        model.addAttribute("shows", shows);
        model.addAttribute("title", "Venues: " + venue.getName());
        return "shows/index";

    }
}

