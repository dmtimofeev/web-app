package ru.ejb.impl;

import ru.beans.TableItem;
import ru.ejb.DataDao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.sql.*;
import java.util.List;

@Stateful
public class DataDaoImpl implements DataDao {

    /**
     * Параметры соединения с БД
     */
    private static final String DB_URL = "jdbc:h2:mem:demodb";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
    private static final String CREATE_USER_TABLE =
            "CREATE TABLE USER " +
                    "(ID INTEGER NOT NULL, " +
                    "NAME VARCHAR(255), " +
                    "DATE_BIRTH DATE, " +
                    "PRIMARY KEY (ID))";
    private static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM USER";
    private static final String INSERT_USER_QUERY = "INSERT INTO USER VALUES(?, ?, ?)";
    private static final String UPDATE_USER_QUERY = "UPDATE USER SET NAME = ?, DATE_BIRTH = ? WHERE ID = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM USER WHERE NAME LIKE ?";

    /**
     * Данные для множественной вставки в таблицу USER
     */
    private static final int[] BATCH_INSERT_IDS = {2, 3};
    private static final String[] BATCH_INSERT_NAMES = {"Абырвалг", "Darth Vader"};
    private static final Date[] BATCH_INSERT_BIRTH_DATES = {Date.valueOf("1983-05-24"), Date.valueOf("2017-11-30")};
    private static final int BATCH_INSERT_ROW_COUNT = 2;

    @PostConstruct
    private void init() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement;
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            int recordCount;

            statement = connection.createStatement();
            statement.execute(CREATE_USER_TABLE);
            statement.close();

            // вставка одной таблицы
            preparedStatement = connection.prepareStatement(INSERT_USER_QUERY);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Вагон Героев");
            preparedStatement.setDate(3, Date.valueOf("1987-01-27"));
            preparedStatement.execute();

            // Проверяем, сколько строк было добавлено
            recordCount = preparedStatement.getUpdateCount();
            preparedStatement.close();

            // Делаем множественную вставку
            preparedStatement = connection.prepareStatement(INSERT_USER_QUERY);
            for (int i = 0; i < BATCH_INSERT_ROW_COUNT; i++) {
                preparedStatement.setInt(1, BATCH_INSERT_IDS[i]);
                preparedStatement.setString(2, BATCH_INSERT_NAMES[i]);
                preparedStatement.setDate(3, BATCH_INSERT_BIRTH_DATES[i]);
                preparedStatement.addBatch();
            }
            int[] batchRecordCount = preparedStatement.executeBatch();
            // Проверяем, сколько строк было добавлено
            recordCount = 0;
            for (int oneRecordCount : batchRecordCount) {
                if (oneRecordCount >= 0) {
                    recordCount += oneRecordCount;
                }
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TableItem get(int id) throws SQLException {

        return null;
    }

    @Override
    public List<TableItem> list() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        Statement statement;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * from USER");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
        return null;
    }
}
