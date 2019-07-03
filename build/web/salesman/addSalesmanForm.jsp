<%-- 
    Document   : addStudentForm
    Created on : Jul 1, 2019, 9:30:40 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="../css/style.css">
        <link type="text/css" rel="stylesheet" href="../css/add-salesman-style.css">
        <title>Add Salesman</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>Salesmen</h2>
            </div>
        </div>

        <div id="container">
            <h3>Add Salesman</h3>
        </div>
        <form action="../Salesman" method="POST">
            <input type="hidden" name="command" value="ADD"/>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="sname"></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><input type="text" name="scity"></td>
                </tr>
                <tr>
                    <td>Commission:</td>
                    <td><input type="text" name="scomm"></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Add" class="save"></td>
                </tr>
            </table>
        </form>

        <br/>
        <a href="../Salesman">Back to List</a>
    </body>
</html>
