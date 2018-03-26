package ru.ejb.impl;

import ru.beans.TableItem;
import ru.ejb.BusinessLogicService;
import ru.ejb.DataDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class BusinessLogicServiceImpl implements BusinessLogicService {

    @EJB
    private DataDao dataDao;

    @Override
    public TableItem get(int id) {
        try {
            return dataDao.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TableItem> list() {
        try {
            return dataDao.list();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
