<%-- 
    Document   : SalesmanUpdate
    Created on : Jul 3, 2019, 4:48:38 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <link type="text/css" rel="stylesheet" href="css/add-salesman-style.css">
        <title>Update Salesman</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>Salesmen</h2>
            </div>
        </div>

        <div id="container">
            <h3>Update Salesman</h3>
        </div>
        <form action="Salesman" method="GET">
            <input type="hidden" name="command" value="UPDATE"/>
            <input type="hidden" name="id" value="${salesman.scode}"/>
            <table>
                <tr>
                    <td><label>Name:</label></td>
                    <td><input type="text" name="sname" value="${salesman.sname}"></td>
                </tr>
                <tr>
                    <td><label>City:</label></td>
                    <td><input type="text" name="scity" value="${salesman.scity}"></td>
                </tr>
                <tr>
                    <td><label>Commission:</label></td>
                    <td><input type="text" name="scomm" value="${salesman.scomm}"></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Update" class="save"></td>
                </tr>
            </table>
        </form>

        <br/>
        <a href="Salesman">Back to List</a>
    </body>
</html>
