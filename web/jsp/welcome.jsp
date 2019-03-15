<%--
  Created by IntelliJ IDEA.
  User: vikashvs36
  Date: 3/3/19
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body>
<%
    String msg= (String) request.getAttribute("msg");
    if (msg != null) {
%>
<div class="alert alert-primary" role="alert">
    <h1><%= msg%></h1>
</div>
<% } %>

<%--Get username from session, if user will be persists or login--%>
<%
    String username=(String) session.getAttribute("username");
    if(username != null){
%>
<h3>Hello <%= username%>,</h3>

<a href="/logout">Logout</a>
<%}else{%>
    <%response.sendRedirect("/login");%>
<%}%>

</body>
</html>
