package com.way_to_create_servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
*
* Servlet interface needs to be implemented for create servlet. It provides 5 methods.
* 3 Methods are life cycle methods that are used to initialize the servlet, to service the requests, and to destroy the servlet.
* And 2 non-life cycle methods.
*
* */


// If you use annotation, deployment descriptor (web.xml file) is not required but you should have to use tomcat 7 or more than 7 version.
// @WebServlet annotation is used to map the servlet with the specified name and urlPatterns.
@WebServlet(name = "MyServlet_1st_Way", urlPatterns = "/servletInterface")
public class MyServlet_1st_Way implements Servlet {

    // Init() method is used to initializes the servlet and invoked by the web container only once.
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init method of Servlet interface is called.");
    }

    // Returns a ServletConfig object, which contains initialization and startup parameters for this servlet. The ServletConfig object returned is the one passed to the init method.
    // Implementations of this interface are responsible for storing the ServletConfig object so that this method can return it. The GenericServlet class, which implements this interface, already does this.
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // service() method is used to provides response for the incoming request by user and It's invoked at each request by the web container.
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service method of Servlet interface is called.");
    }

    // getServletInfo() method is used to get information about servlet like writer, version etc.
    @Override
    public String getServletInfo() {
        return null;
    }

    // destroy() is used to invoked only once and it indicates that servlet is being destroyed.
    @Override
    public void destroy() {
        System.out.println("Destroy method of Servlet interface is callled.");
    }
}
