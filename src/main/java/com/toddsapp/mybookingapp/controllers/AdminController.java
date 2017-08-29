package com.toddsapp.mybookingapp.controllers;

/**
 * Created by margareticloud on 7/28/17.
 */


import com.toddsapp.mybookingapp.models.Admin;
import com.toddsapp.mybookingapp.models.Shows;
import com.toddsapp.mybookingapp.models.forms.Login;
import com.toddsapp.mybookingapp.models.forms.Signup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController extends AbstractController {

    @RequestMapping(value="index")
    public String index(Model model, HttpServletRequest request){
        model.addAttribute("title", "Unapproved Shows");
        model.addAttribute("shows", showsDao.findAll());
        getAdminFromSession(request.getSession());

        return "admin/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String index(@RequestParam int[] ids){

        for (int id : ids) {
            showsDao.delete(id);

        }

        return "redirect:/shows";
    }



    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute(new Signup());
        model.addAttribute("title", "Sign up");
        return "admin/signup";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signup(Model model, @ModelAttribute @Valid Signup form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Sign up");
            return "admin/signup";
        }

        Admin existingAdmin = adminDao.findByAdminName(form.getAdminName());

        if (existingAdmin != null) {
            model.addAttribute("title", "Sign up");
            errors.rejectValue("adminName", "adminName.alreadyexists", "That Admin name is taken");
            return "admin/signup";
        }

        Admin newAdmin = new Admin(form.getAdminName(), form.getPassword());
        adminDao.save(newAdmin);
        setAdminInSession(request.getSession(), newAdmin);

        return "redirect:/admin/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new Login());
        model.addAttribute("title", "Log In");
        return "admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute @Valid Login form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "admin/login";
        }

        Admin admin = adminDao.findByAdminName(form.getAdminName());
        String password = form.getPassword();

        if (!admin.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Wrong password");
            return "admin/login";
        }

        setAdminInSession(request.getSession(), admin);

        return "redirect:/admin/index";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/shows";
    }
}
