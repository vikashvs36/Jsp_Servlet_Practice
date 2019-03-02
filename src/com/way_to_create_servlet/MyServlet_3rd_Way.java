package com.way_to_create_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*
* an abstract class that implements the Servlet interface and is specially designed to handle HTTP requests.
* There is no any abstract method in this class.
*
* */

// If you use annotation, deployment descriptor (web.xml file) is not required but you should have to use tomcat 7 or more than 7 version.
// @WebServlet annotation is used to map the servlet with the specified name and urlPatterns.
@WebServlet(name = "MyServlet_3rd_Way", urlPatterns = "/httpServlet")
public class MyServlet_3rd_Way extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() method of HttpServlet class is called.");
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost() method of HttpServlet class is called.");
    }
}
