package ru.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is a simple example of an HTTP Servlet. It responds to the GET method of
 * the HTTP protocol.
 */
@WebServlet("/bl/greeting")
public class GreetingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html lang=\"en\">"
                    + "<head><title>Servlet: Hello, "+request.getParameter("username")+"</title></head>");

            // then write the data of the response
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<img src=\"../images/duke.waving.gif\" "
                    + "alt=\"Duke waving his hand\">"
                    + "<form method=\"get\">"
                    + "<h2>Hello, my name is Duke. What's yours?</h2>"
                    + "<input title=\"My name is: \" type=\"text\" "
                    + "name=\"username\" size=\"25\"/>"
                    + "<p></p>"
                    + "<input type=\"submit\" value=\"Submit\"/>"
                    + "<input type=\"reset\" value=\"Reset\"/>"
                    + "</form>");

            out.println("</body></html>");
        }
    }
}