package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//@WebServlet(name = "ServletConfigExample", urlPatterns = "/servlet_config")
public class ServletConfigExample extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set content type
        response.setContentType("text/html");

        // Create obj of PrintWriter to print anything
        PrintWriter out=response.getWriter();

        // Get the object of ServletConfig
        ServletConfig configObj=getServletConfig();

        // How to get Servlet name
        String servletName=configObj.getServletName();
        out.println("ServletName : "+servletName);

        // Not call the servletConfig's methods
        String username=configObj.getInitParameter("username");

        // You can print using PrintWriter object
        out.println("<br>You are login as : "+username);

        out.print("<form action=\"servlet_config\" method=\"POST\">");
        out.print("<input type=\"submit\" value=\"Get All Config Obj\"/> ");
        out.print("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set content type
        response.setContentType("text/html");

        // Create obj of PrintWriter to print anything
        PrintWriter out=response.getWriter();

        ServletConfig configObj=getServletConfig();
        Enumeration<String> alValues=configObj.getInitParameterNames();
        String str;
        while (alValues.hasMoreElements()){
            str=alValues.nextElement();
            out.println("<br>Param Name: <b>"+str+"</b>");
            out.println("value : "+configObj.getInitParameter(str));
        }

        // To print anything to using PrintWriter object
        out.println("<br>Click here to go to home : <a href='/servlet_config'>Home</a>");

    }
}
