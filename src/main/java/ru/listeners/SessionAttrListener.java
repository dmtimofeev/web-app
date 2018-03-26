package ru.listeners;

import ru.beans.DBConnectionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by DmSeTimofeev on 23.03.2018.
 */
@WebListener
public class SessionAttrListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("Session attribute added: sessionId - " + se.getSession().getId() + ", " + se.getName() + ": " + se.getValue().toString());
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("Session attribute removed: sessionId - " + se.getSession().getId() + ", " + se.getName() + ": " + se.getValue().toString());
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
    }

}
