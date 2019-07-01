<%-- 
    Document   : viewSalesmen
    Created on : Jun 30, 2019, 11:35:38 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Salesmen</title>
        <link type="text/css" rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <jsp:include page="../header.html"/>
        <hr>
        <div id="wrapper">
            <div id="header">
                <h2>Salesmen</h2>
            </div>
        </div>
        <div id="container">
            <div id="content">
                
                <!--Add the button Add Salesman-->
                <input type="button" value="Add Salesman" 
                       onclick="window.location.href='addSalesmanForm.jsp';return false;
                       class='add-button'"/>
                
                <table>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Commission</th>
                    </tr>
                    <c:forEach items="${salesmen}" var="salesman">
                        <tr>
                            <td>${salesman.scode}</td>
                            <td>${salesman.sname}</td>
                            <td>${salesman.scity}</td>
                            <td>${salesman.scomm}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <hr>
        <jsp:include page="../footer.jsp"/>

    </body>
</html>
