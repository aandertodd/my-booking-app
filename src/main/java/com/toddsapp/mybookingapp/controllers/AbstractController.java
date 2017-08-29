package com.toddsapp.mybookingapp.controllers;

/**
 * Created by margareticloud on 7/28/17.
 */


import com.toddsapp.mybookingapp.models.Admin;
import com.toddsapp.mybookingapp.models.data.AdminDao;
import com.toddsapp.mybookingapp.models.data.ShowsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
//import com.toddsapp.mybookingapp.models.data.AbstractEntity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by LaunchCode
 */
public abstract class AbstractController {

    @Autowired
    protected AdminDao adminDao;

    @Autowired
    protected ShowsDao showsDao;

    public Boolean isApproved(){
        return false;}

    public static final String adminSessionKey = "admin_id";

    protected Admin getAdminFromSession(HttpSession session) {

        Integer adminId = (Integer) session.getAttribute(adminSessionKey);
        return adminId == null ? null : adminDao.findOne(adminId);
    }

    protected void setAdminInSession(HttpSession session, Admin admin) {
        session.setAttribute(adminSessionKey, admin.getAid());
    }

//    @ModelAttribute("adminId")
//    public Integer getAdminIdFromSession(HttpServletRequest request) {
//        return (Integer) request.getSession().getAttribute(adminSessionKey);
//    }

    @ModelAttribute("admin")
    public Admin getAdminForModel(HttpServletRequest request){
        return getAdminFromSession(request.getSession());
    }
}