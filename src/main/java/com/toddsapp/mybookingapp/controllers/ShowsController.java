package com.toddsapp.mybookingapp.controllers;

import com.toddsapp.mybookingapp.models.Shows;
import com.toddsapp.mybookingapp.models.data.AdminDao;
import com.toddsapp.mybookingapp.models.data.ShowsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by margareticloud on 7/25/17.
 */
@Controller
@RequestMapping("shows")
public class ShowsController {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private ShowsDao showsDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("shows", showsDao.findAll());
        model.addAttribute("title", "All Shows");
        return "shows/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayNewShow(Model model) {

        model.addAttribute("title", "Add Show");
        model.addAttribute(new Shows());
        return "shows/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addShow(Model model, @ModelAttribute @Valid Shows newShow, Errors errors){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Show");
            return "shows/add";
        }

        showsDao.save(newShow);
        return "redirect:";
    }

    @RequestMapping(value = "delete")
    public String displayDeleteShow(Model model){
        model.addAttribute("shows", showsDao.findAll());
        model.addAttribute("title", "Delete Show");

        return "shows/delete";
    }
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deleteShow(@RequestParam int[] ids){

        for (int id : ids){
            showsDao.delete(id);
        }

        return "redirect:";
    }
}

