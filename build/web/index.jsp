<%-- 
    Document   : index
    Created on : Jun 28, 2019, 7:23:14 PM
    Author     : anastasios
--%>
<%@page language="java" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="test.JspUtils" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>JSP</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="header.html"/>
        <%--This is an jsp expression--%>
        <p><font color="#FF0000" size="6"><%="I am a developer"%></font></p>
        <p>The time is<%=java.time.LocalDateTime.now()%></p>
        <br/>
        multiplication of 5*4 = <%=5 * 4%>
        <br/>
        Turn to uppercase: <%="Hello".concat(" SIR").toLowerCase()%>
        <br/>
        Is 45 less than 60? <%=45 < 60%>
        <%--Here we begin the scriptlets--%>
        <%
            out.print("<p>Scriptlet</p>");
            for (int i = 0; i < 10; i++) {
                out.println("number is " + i + "<br/>");
            }
        %>
        <%--Here we begin the jsp declarations--%>
        <%!
            String sayHello(String name) {
                return "Hello " + name;
            }
        %>
        <%=sayHello("Maria")%>

        <%--Call method from class--%>
        <p>Calling method from class JspUtils</p>
        <%=JspUtils.changeToLowerCase("This is my name: Tasos")%>

        <%--Built-in objects--%>
        <p>Built-in objects</p>
        <%=request.getHeader("User-Agent")%>
        <%=request.getLocalAddr()%>

        <ul>
            <li><a href="registrationForm.html">Registration Form/I18N Form</a></li>
            <li><a href="toDoForm.jsp">ToDo Form</a></li>
            <li><a href="testjstl.jsp">Test Jstl</a></li>
            <li><a href="Salesman">View Salesmen</a></li>
        </ul>
        <jsp:include page="footer.jsp"/>
    </body>
</html>