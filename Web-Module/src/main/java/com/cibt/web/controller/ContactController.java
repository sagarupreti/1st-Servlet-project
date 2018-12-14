/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.controller;

import com.cibt.web.util.Mailer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author ideapad-520S
 */
@WebServlet(name = "contact",urlPatterns = "/contact")
public class ContactController extends Controller {
  
     @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        view("contact/index", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest reqest, 
            HttpServletResponse response) throws ServletException, IOException {
        
     new Mailer().setTo("uprsagar@gmail.com")
                .setFrom(reqest.getParameter("email"))
                .setHost("smtp.wlink.com.np")
                .setPort("25")
                .setSubject(reqest.getParameter("subject"))
                .setBody(reqest.getParameter("message"))
                .send();
     response.getWriter().println("<h1>Mail sent Successfully</h1>");
     
     
    }
    
}
