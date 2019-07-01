<%-- 
    Document   : cookiePersonalizedForm
    Created on : Jun 30, 2019, 12:02:41 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personalized Form</title>
    </head>
    <%
        String username = "No username";
        String language = "Java";
        Cookie [] cookies = request.getCookies();
        System.out.println("$$$$$$$"+cookies);
        if(cookies !=null){
            for(Cookie c:cookies){
                System.out.println("cookies is "+c);
                System.out.println("cookie name = "+c.getName()+" with value="+c.getValue());
                if(c.getName().equals("app.language")){
                    language = c.getValue();
                }
                if(c.getName().equals("app.username")){
                    username = c.getValue();
                }
                    
            }
        }
    %>
    <body>
        Hello <%=username%>!!
        <br/>
        Your favorite language is <%=language%>
    </body>
</html>
