package com.toddsapp.mybookingapp.controllers;
import com.toddsapp.mybookingapp.models.Shows;
import com.toddsapp.mybookingapp.models.Venue;
import com.toddsapp.mybookingapp.models.data.VenueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by margareticloud on 8/7/17.
 */

@Controller
@RequestMapping("venue")
public class VenueController extends ShowsController {

    @Autowired
    private VenueDao venueDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("venues", "venue");
        model.addAttribute("venues", venueDao.findAll());
        return "venue/index";
    }

    @RequestMapping(value="new", method=RequestMethod.GET)
    public String add(Model model){

        model.addAttribute("title", "New Venue");
        model.addAttribute(new Venue());
        return "venue/new";
    }

    @RequestMapping(value="new", method=RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Venue venue, Errors errors){

        if (errors.hasErrors()){
            model.addAttribute("title", "New Venue");
            return "venue/new";
        }
        else {
            venueDao.save(venue);
            return "redirect:/venue";
        }
    }

}