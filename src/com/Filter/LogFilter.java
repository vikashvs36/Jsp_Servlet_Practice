package com.Filter;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Get init parameter
        String testParam = filterConfig.getInitParameter("test_param");

        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Get the IP address of client machine.
        String ipAddress = servletRequest.getRemoteAddr();

        // Log the IP address.
        System.out.println("IP : "+ ipAddress);

        // Pass request back down the filter chain
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("filter is invoked after..");
    }

    @Override
    public void destroy() {
        //destroy() method is invoked
        System.out.println("destroy() method is invoked");
    }
}
