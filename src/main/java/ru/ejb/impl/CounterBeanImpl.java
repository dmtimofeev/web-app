package ru.ejb.impl;

import ru.ejb.CounterBean;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.transaction.Transactional;

/**
 * @author ian
 * CounterBean is a simple singleton session bean that records the number
 * of hits to a web page.
 * <p>
 * Enterprise JavaBeans (EJB) - это управляемый компонент, принадлежащий стороне сервера для модульного конструирования промышленного приложения
 */
@Singleton
public class CounterBeanImpl implements CounterBean {
    private int hits = 1;

    // Increment and return the number of hits
    @Transactional(value = Transactional.TxType.REQUIRED)
    public int getHits() {
        return hits++;
    }
}
