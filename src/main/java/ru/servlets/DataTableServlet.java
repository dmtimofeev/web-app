package ru.servlets;

import ru.beans.TableItem;
import ru.ejb.BusinessLogicService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is a simple example of an HTTP Servlet.  It responds to the GET
 * method of the HTTP protocol.
 */
public class DataTableServlet extends HttpServlet {
    @EJB
    private BusinessLogicService businessLogicService;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<TableItem> list = businessLogicService.list();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (request.getParameter("username") != null) {
            request.setAttribute("username", request.getParameter("username"));
        }

        Random rnd = new Random();
        int count = rnd.nextInt(20);
        List<TableItem> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(new TableItem(i, "Имя " + (i + 1), rnd.nextInt(100), rnd.nextDouble() * 10));
        }

        request.setAttribute("data", data);

        getServletContext().getRequestDispatcher("/WEB-INF/dataTable.jsp").forward(request, response);
    }
}