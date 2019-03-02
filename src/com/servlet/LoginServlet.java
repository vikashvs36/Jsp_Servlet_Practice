package com.servlet;

import com.service.LoginService;

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

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Fetch client request information using getParameter() method of ServletRequest interface.
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        // Validate username or password is valid or not.
        if (loginService.login(username, password)){ System.out.println("Login Successfully."); }
        else { System.out.println("Username or Password is incorrect."); }

    }
}
