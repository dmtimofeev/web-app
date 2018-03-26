package ru.filters;

import ru.ejb.CounterBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet Filters are pluggable java components that we can use to intercept and process requests before they are sent to servlets and response
 * after servlet code is finished and before container sends the response back to the client.
 * <p>
 * Some common tasks that we can do with servlet filters are:
 * - Logging request parameters to log files.
 * - Authentication and autherization of request for resources.
 * - Formatting of request body or header before sending it to servlet.
 * - Compressing the response data sent to the client.
 * - Alter response by adding some cookies, header information etc.
 */
@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {

    @Inject
    private CounterBean counterBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

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
                + ", Execution time (ms) = " + (System.currentTimeMillis() - startTime)
                + ", req count = " + counterBean.getHits());
    }

    @Override
    public void destroy() {

    }
}
