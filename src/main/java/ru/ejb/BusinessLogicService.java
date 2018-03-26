package ru.ejb;

import ru.beans.TableItem;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface BusinessLogicService {
    TableItem get(int id) throws SQLException;

    List<TableItem> list() throws SQLException;
}
