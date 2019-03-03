package com.servlet.ScopeDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "Set Scope Demo", urlPatterns = "/get-attributes")
public class GetAttribute_Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------get() method invoked");
        display(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------post() method invoked");
        display(req, resp);
    }

    // That is own method to use doGet() and doPost() method both.
    private void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ---------------Get Attribute---------------------------

        // get request scoped attribute
        String requestScope = (String)req.getAttribute("name");

        // get session scoped attribute
        HttpSession session = req.getSession();
        String sessionScope = (String)session.getAttribute("name");

        // get application scoped attribute
        String applicationScope = (String)req.getServletContext().getAttribute("name");


        // print response
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html><body>");
        out.write("<h2>Servlet attributes example: applicationScope, sessionScope and requestScope</h2>");
        out.write("<p>requestScope: " + requestScope + "</p>");
        out.write("<p>sessionScope: " + sessionScope + "</p>");
        out.write("<p>applicationScope: " + applicationScope + "</p>");
    }
}
