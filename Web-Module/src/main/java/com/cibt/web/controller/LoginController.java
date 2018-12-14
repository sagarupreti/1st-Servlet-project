/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author ideapad-520S
 */
@WebServlet(name = "login",urlPatterns = "/login")
public class LoginController extends Controller {
    
     @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(session.getAttribute("loggedin")!=null){
        response.sendRedirect(request.getContextPath()
                    +"/admin");
        }else{
        view("login/index", request, response);
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
       String userName=request.getParameter("username");
       String password=request.getParameter("password");
       if(userName.equals("admin") &&
               password.equals("admin1234")){
            HttpSession session=request.getSession(true);
            session.setAttribute("loggedin",true);
            response.sendRedirect(request.getContextPath()
                    +"/admin");
       }else{
           response.sendRedirect(request.getContextPath()
                    +"/login?error");
       }
       
    }
    
    
}
