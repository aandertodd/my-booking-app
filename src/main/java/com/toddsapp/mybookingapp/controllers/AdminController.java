package com.toddsapp.mybookingapp.controllers;

import com.toddsapp.mybookingapp.models.Admin;
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
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private ShowsDao showsDao;

    @RequestMapping(value = "login")
    public String index(Model model) {

        model.addAttribute("title", "Admin Login");
        return "admin/login";
    }
//    @RequestMapping(value = "login", method=RequestMethod.POST)
//    public String loginAdmin(Model model @ModelAttribute @Valid loginAdmin, Errors errors){
//
//        if (errors.hasErrors()){
//            model.addAttribute("title", "Log in");
//            return "admin/login";
//        }
//
//        return "redirect:";
//    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newAdmin(Model model) {

        model.addAttribute("title", "Sign up");
        model.addAttribute(new Admin());
        return "admin/signup";
    }

    @RequestMapping(value = "signup:", method = RequestMethod.POST)
    public String addNewAdmin(Model model, @ModelAttribute @Valid Admin newAdmin, Errors errors,
                           @RequestParam int adminId){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Sign up");

            return "admin/signup";
        }

   //     newAdmin.setId(adminId);
//        adminDao.save(newAdmin);
        return "redirect:/shows";
    }
}