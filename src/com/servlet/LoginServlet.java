package com.servlet;

import com.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

    LoginService loginService;

    public LoginServlet(){
        loginService=new LoginService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Create Session Object
        HttpSession httpSession = req.getSession();

        String username=null;
        if(httpSession != null) { username = (String) httpSession.getAttribute("username");}

        RequestDispatcher rd;

        if (username != null){
            resp.sendRedirect("/home");
        }else {
            rd=req.getRequestDispatcher("jsp/login.jsp");
            rd.forward(req,resp);
        }


    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Create Session Object
        HttpSession httpSession = req.getSession();

        // Fetch client request information using getParameter() method of ServletRequest interface.
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        // Create a reference variable of RequestDispatcher
        RequestDispatcher rd;

        // Validate username or password is valid or not.
        if (loginService.login(username, password)){
            System.out.println("Login Successfully.");

            // Set Attributes in the session object.
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);

            // you can put here Either jsp file path or servlet url-pattern
//            req.setAttribute("msg","Login Successful!");
            resp.sendRedirect("/home");
        }
        else {
            System.out.println("Username or Password is incorrect.");

            // you can put here Either jsp file path or servlet url-pattern
            rd=req.getRequestDispatcher("jsp/login.jsp");
            // you can set attributes and get it on dispatcher page.
            req.setAttribute("error","Username or Password is incorrect");
            rd.include(req,resp);                               // Include the given page
        }

    }
}
