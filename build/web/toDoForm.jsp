<%-- 
    Document   : ToDoForm
    Created on : Jun 29, 2019, 12:11:50 PM
    Author     : anastasios
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.html"/>
        <!--Step 1: create form-->
        <form action="toDoForm.jsp">
            Add new item:&nbsp;<input type="text" name="item"/>&nbsp;
            <input type="submit" value="Add"/>
        </form>

        <!--Step 2: add item to List-->
        <%
            //get the toDoList from the session
            List<String> toDoList = (List<String>) session.getAttribute("toDoList");

            //create the list if it doesn't exist.
            if (toDoList == null) {
                toDoList = new ArrayList();
                session.setAttribute("toDoList", toDoList);
            }
            //see if there is data from form
            String item = request.getParameter("item");
            if (item != null && !item.equals("")) {
                toDoList.add(item);
                response.sendRedirect("toDoForm.jsp");
            }
        %>
        <hr>
        <!--Step 3: Print list of items-->
        <h4>Items Added</h4>
        <%
            if (!toDoList.isEmpty()) {
                out.print("<ol>");
                for (String i : toDoList) {
                    out.print("<li>" + i + "</li>");
                }
                out.print("</ol>");
            }
        %>
        <br/><br/>
        <!--Reset Session-->
        <%
            if (request.getParameter("reset") != null) {
                session.invalidate();
                response.sendRedirect("index.jsp");
                return;
            }
        %>


        <form action="toDoForm.jsp">
            <input type="submit" name="reset" value="Reset Session"/>
        </form>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
