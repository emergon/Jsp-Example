<%-- 
    Document   : i18n_test
    Created on : Jun 30, 2019, 6:17:16 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="theLocale" value="${not empty param.theLocale?param.theLocale:contextPage.request.locale}" scope="session"/>
<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="properties.mylabel"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        session.setAttribute("firstName", request.getAttribute("firstName"));
        session.setAttribute("lastName", request.getAttribute("lastName"));
        out.print(session.getAttribute("firstName"));
    %>
    
    
    <body>
        
        <a href="i18n_test.jsp?theLocale=en_GB">English(GB)</a>
        |
        <a href="i18n_test.jsp?theLocale=gr_GR">Greek(GR)</a>
        <hr>
        <fmt:message key="label.greeting"/>
        <br/><br/>
        <fmt:message key="label.firstName"/>${f}
        <br/><br/>
        <fmt:message key="label.lastName"/><%=session.getAttribute("lastName")%>
        <br/><br/>
        <fmt:message key="label.welcome"/>
        <hr>
        Locale selected: ${theLocale}
    </body>
</html>
