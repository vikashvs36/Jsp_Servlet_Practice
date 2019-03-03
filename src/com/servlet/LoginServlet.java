package com.servlet;

import com.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

    LoginService loginService;

    public LoginServlet(){
        loginService=new LoginService();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Fetch client request information using getParameter() method of ServletRequest interface.
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        // Create a reference variable of RequestDispatcher
        RequestDispatcher rd;

        // Validate username or password is valid or not.
        if (loginService.login(username, password)){
            System.out.println("Login Successfully.");

            // you can put here Either jsp file path or servlet url-pattern
            rd=req.getRequestDispatcher("jsp/welcome.jsp");
            rd.forward(req,resp);                               // forward the given page
        }
        else {
            System.out.println("Username or Password is incorrect.");

            // you can put here Either jsp file path or servlet url-pattern
            rd=req.getRequestDispatcher("index.jsp");
            // you can set attributes and get it on dispatcher page.
            req.setAttribute("error","Username or Password is incorrect");
            rd.include(req,resp);                               // Include the given page
        }

    }
}
