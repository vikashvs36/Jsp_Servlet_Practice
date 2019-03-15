package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create RequestDispatcher object
        RequestDispatcher rd=null;

        // Create Session Object
        HttpSession session=request.getSession(false);

        String username=null;
        if(session != null){
            // We can get username from Session s
            username=(String) session.getAttribute("username");

            if(username != null){
                rd=request.getRequestDispatcher("jsp/welcome.jsp");
                rd.forward(request,response);
            }else {
                response.sendRedirect("/login");
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
