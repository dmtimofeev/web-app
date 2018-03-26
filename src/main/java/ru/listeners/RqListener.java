package ru.listeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by DmSeTimofeev on 23.03.2018.
 * Interface for receiving notification events about requests coming into and going out of scope of a web application.
 */
public class RqListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("ServletRequest destroyed. Remote IP=" + servletRequest.getRemoteAddr());
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println();
        System.out.println("ServletRequest initialized. Remote IP=" + servletRequest.getRemoteAddr() + " to " + ((HttpServletRequest)servletRequest).getRequestURI());
    }
}
