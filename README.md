# Jsp_Servlet_Practice
Simple project to get knowlage of JSP and Servlet.



> Welcome-file-list in web.xml

If you want to show first web page as welcome file then you can write code in web.xml which is given below. 
  
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
    

    
> Way to Create a Servlet

There are three ways to create the servlet.

    1. By implementing the Servlet interface
    2. By inheriting the GenericServlet class
    3. By inheriting the HttpServlet class


1. By implementing the Servlet interface

Servlet interface needs to be implemented for create servlet. It provides 5 methods. 3 life cycle methods that are used
to initialize the servlet, to service the requests, and to destroy the servlet and 2 non-life cycle methods.
There is five abstract method in this interface.

Methods :
 
Life cycle methods
i).     public void init(ServletConfig config)
ii).    public void service(ServletRequest request,ServletResponse response)
iii).   public void destroy()

Non-life cycle methods
iv).    public ServletConfig getServletConfig()
v).     public String getServletInfo()


2. By inheriting the GenericServlet 

GenericServlet is an abstract class so you need have to extends GenericServlet class and it can handle any type of 
request so it is protocol-independent. It has only one abstract method.

Method :

i) public void service(ServletRequest servletRequest, ServletResponse servletResponse)


3. By inheriting the HttpServlet class

HttpServlet is an abstract class that implements the Servlet interface and is specially designed to handle HTTP 
requests. There is no any abstract method in this class.



> Create the Servlet using deployment descriptor (web.xml file)

The deployment descriptor is an xml file, from which Web Container gets the information about the servet to be invoked.

    <servlet>
            <servlet-name>DemoServlet</servlet-name>
            <servlet-class>com.way_to_create_servlet.DemoServlet</servlet-class>
        </servlet>
    
        <servlet-mapping>
            <servlet-name>DemoServlet</servlet-name>
            <url-pattern>/demoServlet</url-pattern>
        </servlet-mapping>

