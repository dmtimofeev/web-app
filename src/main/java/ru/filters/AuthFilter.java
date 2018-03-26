package ru.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter используется чтобы:
 * - перенаправить запрос пользователя на другую страницу;
 * - блокировать доступ к определенному сайту, если пользователь не имеет прав;
 * - для записи информации Log.
 * - для кодирования вебсайта (encoding)
 * - открыть и закрыть соединение  к Database и подготовить транзакцию JDBC (JDBC Transaction)
 * - пр.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if (req.getServletPath().contains("login.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            String authInfo = (String) req.getSession().getAttribute("myAuth");
            if (!req.getRequestURI().contains("login.do") && authInfo != null) {
                if (authInfo.equals("i_am_not_a_hacker")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.setStatus(403);
                }
            } else {
                String hacker = req.getParameter("hacker_ф");
                if (hacker != null) {
                    req.getSession().setAttribute("myAuth", hacker.equals("no") ? "i_am_not_a_hacker" : "i_am_a_hacker");
                    response.sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/index.jsp");
                } else {
                    response.sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/login.jsp");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
