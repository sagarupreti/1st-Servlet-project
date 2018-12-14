/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.listener;

import com.cibt.web.util.Mailer;
import java.util.Date;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ideapad-520S
 */
@WebListener
public class SiteTrackListener implements
        ServletRequestListener {
    private boolean sentMail=false;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request=
                (HttpServletRequest)sre.getServletRequest();
        System.out.println("------------------------------------");
        System.out.println("IP Address:" + request.getRemoteAddr());
        System.out.println("Access Date:" + new Date());
        System.out.println("Request Method:" + request.getMethod());
        System.out.println("Request URL:" + request.getRequestURI());
        System.out.println("----------------------------------------");
        if(!sentMail){
            String msg="IP Address:" + request.getRemoteAddr()+
                    "\r\nAccess Date:" + new Date()+
                    "\r\nRequest Method:" + request.getMethod()+
                    "\r\nRequest URL:" + request.getRequestURI();
            new Mailer()
                    .setTo("uprsagar@gmail.com")
                    .setFrom("sagarup@icloud.com")
                    .setSubject("Server Access Log")
                    .setHost("smtp.wlink.com.np")
                    .setPort("25")
                    .setBody(msg)
                    .send();
            sentMail=true;
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
  
    }
    
    
}
