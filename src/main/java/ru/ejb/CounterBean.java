package ru.ejb;

import javax.ejb.Remote;

/**
 *
 * @author ian
 * CounterBean is a simple singleton session bean that records the number
 * of hits to a web page.
 *
 * Enterprise JavaBeans (EJB) - это управляемый компонент, принадлежащий стороне сервера для модульного конструирования промышленного приложения
 */
@Remote
public interface CounterBean {
    // Increment and return the number of hits
    int getHits();
}
