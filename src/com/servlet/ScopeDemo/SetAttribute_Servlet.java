package com.servlet.ScopeDemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(description = "Set Scope Demo", urlPatterns = "/set-attributes")
public class SetAttribute_Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // RequestDispatcher to use forward on the jsp or servlet
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("jsp/scope.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------------");
        // ---------------Set Attribute---------------------------

        String name= req.getParameter("name");

        if (name != null ){
            // set request scoped attribute
            req.setAttribute("name", name);         // It will show only next page but in the case of sendRedirect it gets removed

            // set session scoped attribute
            HttpSession session = req.getSession();
            session.setAttribute("name", name);     // It will show only same browser but in case another browser it also gets removed.

            // set application scoped attribute
            ServletContext context=req.getServletContext();     // It will show until application is deployed
            context.setAttribute("name", name);
            // Or you can dirrect write like that given below line to create application scope
            //req.getServletContext().setAttribute("name", "application scoped attribute");

            // send redirect to other URL. You can give any URL like "https://www.google.com/?gws_rd=ssl"
//            resp.sendRedirect("http://localhost:8080/get-attributes");            // Note : It will send on Get method where you want to go

            // send redirect to other servlet
            req.getRequestDispatcher("get-attributes").forward(req, resp);       // Note : It will send on post method where you want to go
        }
    }
}
