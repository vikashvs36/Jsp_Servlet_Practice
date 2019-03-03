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



> ServletRequest Interface 

Defines an object to provide client request information to a servlet such as content type, content length, parameter
names and values, header informations, attributes etc. The servlet container creates a ServletRequest object and passes
it as an argument to the servlet's service method.

It has many methods. Some methods are given below :

i).     public String getParameter(String name)
ii).    public String[] getParameterValues(String name)
iii).   public int getContentLength()
iv).    public String getContentType()
v).     public int getServerPort()
vi).    public abstract String getServerName()
like that.

After run the project you can hit the url : 
'http://localhost:8080/login?username=Vikash&password=Singh'



> RequestDispatcher interface

Defines an object that receives requests from the client and sends them to any resource (such as a servlet, HTML file,
or JSP file) on the server. The servlet container creates the RequestDispatcher object, which is used as a wrapper 
around a server resource located at a particular path or given by a particular name.

Method : 
public void forward(ServletRequest request, ServletResponse response)
public void include(ServletRequest request, ServletResponse response)

If you want to go from servlet to another servlet then you can use :-

    req.getRequestDispatcher("servlet_url-pattern").forward(req, resp);       
Note : It will send on post method by default, where you want to go

you can set attributes and get it on dispatcher page.
request.setAttribute("error","Username or Password is incorrect");      // set attribute on servlet page
String error= (String) request.getAttribute("error");                   // get attribute on jsp page



> SendRedirect in servlet

If you want to go from servlet to another URL like "https://www.google.com/?gws_rd=ssl"

    resp.sendRedirect("https://www.google.com/?gws_rd=ssl");            
Note : It will send on Get method by default, where you want to go



> Attribute in Servlet

An attribute in servlet is an object that can be set, get or removed from one of the following scopes:

1.  request scope
2.  session scope
3.  application scope

i). request scope :
means for that particular action only you are keeping the values. In this if you call another action or redirects 
to another JSP , it gets removed. Its generally use when we need to of a submitted form. 

Ex:- set request scoped attribute

    req.setAttribute("name", "request scoped attribute");


ii). session scope : 
It means through the application (till the session gets expired). Your can keep the values in session 
no matter how many JPSs you are visiting of that application. It remains there in session until you close your browser.
A session is created by the web container. So the session’s lifespan lives as long as the user interacts with 
your application or when session.invalidate() is called. 

Ex:- set session scoped attribute

        HttpSession session = req.getSession();
        session.setAttribute("name", "session scoped attribute");

iii). application scope :
Application Scope or global scope is associated with your web application. This scope lives as long as the web 
application is deployed. 

Ex:- set application scoped attribute

        req.getServletContext().setAttribute("name", "application scoped attribute");

Attribute specific methods of ServletRequest, HttpSession and ServletContext interface
There are following 4 attribute specific methods. They are as follows:
1. public void setAttribute(String name,Object object):sets the given object in the application scope.
2. public Object getAttribute(String name):Returns the attribute for the specified name.
3. public Enumeration getInitParameterNames():Returns the names of the context's initialization parameters as 
an Enumeration of String objects.
4. public void removeAttribute(String name):Removes the attribute with the given name from the servlet context.



