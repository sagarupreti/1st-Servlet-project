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

/**
 *
 * @author ideapad-520S
 */
@WebServlet(name = "admincontact",urlPatterns = {"/admin/contact/*"})
public class AdminContactController extends Controller {

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Secured Page</h1>");
    }
    
    
}
