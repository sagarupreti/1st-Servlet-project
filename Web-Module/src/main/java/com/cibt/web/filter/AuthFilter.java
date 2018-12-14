/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ideapad-520S
 */
@WebFilter(filterName = "auth", urlPatterns = {"/admin/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    
    @Override
    public void doFilter(ServletRequest req, 
            ServletResponse resp, 
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=
                (HttpServletRequest)req;
        HttpServletResponse response=
                (HttpServletResponse)resp;
        HttpSession session=request.getSession(false);
        if(session.getAttribute("loggedin")==null){
        response.sendRedirect(request.getContextPath()
                    +"/login");
        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
    
    
}
