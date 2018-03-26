package ru.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String servletPath = req.getServletPath();

        // Разрешить request продвигаться дальше. 
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("#INFO " + new Date()
                + " - ServletPath :" + servletPath
                + ", URL =" + req.getRequestURL()
                + ", Execution time (ms) = " + (System.currentTimeMillis() - startTime));
    }

    @Override
    public void destroy() {

    }
}
