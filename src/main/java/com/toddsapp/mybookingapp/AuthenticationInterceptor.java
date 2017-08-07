package com.toddsapp.mybookingapp;

import com.toddsapp.mybookingapp.controllers.AbstractController;
import com.toddsapp.mybookingapp.models.Admin;
import com.toddsapp.mybookingapp.models.data.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by margareticloud on 8/3/17.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

        @Autowired
        AdminDao adminDao;

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

            // Authentication white list; add all publicly visible pages here
            List<String> nonAuthPages = Arrays.asList("admin/login", "admin/signup", "/shows");

            // Require sign-in for auth pages
            if ( !nonAuthPages.contains(request.getRequestURI()) ) {

                Integer adminId = (Integer) request.getSession().getAttribute(AbstractController.adminSessionKey);

                if (adminId != null) {
                    Admin admin = adminDao.findOne(adminId);

                    if (admin != null)
                        return true;
                }

                response.sendRedirect("admin/login");
                return false;
            }

            return true;
        }

    }
