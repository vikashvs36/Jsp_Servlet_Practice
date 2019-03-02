package com.way_to_create_servlet;


import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/*
*
*  GenericServlet is an abstract class so you need have to extends GenericServlet class.
*  GenericServlet class can handle any type of request so it is protocol-independent.
*  It has only one abstract method called service().
*
* */


// If you use annotation, deployment descriptor (web.xml file) is not required but you should have to use tomcat 7 or more than 7 version.
// @WebServlet annotation is used to map the servlet with the specified name and urlPatterns.
@WebServlet(name = "MyServlet_2nd_Way", urlPatterns = "/genericServlet")
public class MyServlet_2nd_Way extends GenericServlet {

    // service() method is used to provides service for all incoming request and its invoked at each time when user requests for a servlet.
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service method of GenericServlet class is Called.");
    }
}
