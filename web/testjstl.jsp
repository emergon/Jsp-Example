<%-- 
    Document   : testjstl
    Created on : Jun 30, 2019, 1:21:03 PM
    Author     : anastasios
--%>

<%@page import="java.util.*,entities.Salesman" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="stuff" value="<%=java.time.LocalDate.now()%>"/>
        <h1>Hello World! Time is ${stuff}</h1>
        <br/>
        <h4>Display for each loop with jstl</h4>
        <%
            String[] foods = {"pizza", "pastitsio", "fish", "meat"};
            pageContext.setAttribute("myFoods", foods);
        %>
        <ul>
            <c:forEach items="${myFoods}" var="food">
                <li>${food}</li>
                </c:forEach>
        </ul>

        <h4>Display for each table with salesmen</h4>
        <%
            List<Salesman> salesmenList = new ArrayList();
            salesmenList.add(new Salesman(1, "Andy", "Athens", 0.14));
            salesmenList.add(new Salesman(1, "Tasos", "Lamia", 0.15));
            salesmenList.add(new Salesman(1, "Maria", "Patra", 0.12));
            salesmenList.add(new Salesman(1, "Polina", "Zurich", 0.24));
            pageContext.setAttribute("salesmen", salesmenList);
        %>
        <table border="1">
            <tr><th>Scode</th><th>Sname</th><th>Scity</th><th>Scomm</th><th>Comm Type</th></tr>
                    <c:forEach items="${salesmen}" var="salesman">
                <tr>
                    <td>${salesman.scode}</td>
                    <td>${salesman.sname}</td>
                    <td>${salesman.scity}</td>
                    <td>${salesman.scomm}</td>
                    <td>
                        <c:if test="${salesman.scomm>0.12}">Big Commission</c:if>
                        <c:if test="${salesman.scomm<=0.12}">Small Commission</c:if>
                        </td>
                        <td>
                        <c:choose>
                            <c:when test="${salesman.scity=='Athens'}">
                                in Greece
                            </c:when>
                            <c:when test="${salesman.scity=='Patra'}">
                                in Greece
                            </c:when>

                            <c:when test="${salesman.scity=='Lamia'}">
                                in Greece
                            </c:when>
                            <c:otherwise>
                                not in Greece
                            </c:otherwise>
                        </c:choose>
                                
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
