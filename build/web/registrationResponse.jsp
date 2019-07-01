<%-- 
    Document   : loginResponse
    Created on : Jun 29, 2019, 11:03:32 AM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Response</title>
    </head>
    <body>
        <jsp:include page="header.html"/>
        <p><b>Using <\%=request.getParameter(String)%></b></p>
        Welcome <%=request.getParameter("username")%> with password <%=request.getParameter("password")%>
        <br/><br/>
        <p><b>Using \${param.username}</b></p>
        Welcome ${param.username} with password ${param.password} and role ${param.role}!!
        <br/><br/>
        Your favorite language is ${param.language}.
        <br/><br/>
        <%String[] sports = request.getParameterValues("sport");%>
        Your sports are<br/>
        <ul>
            <%
                if (sports != null) {
                    for (String s : sports) {
                        out.print("<li>" + s + "</li>");
                    }
                } else {
                    out.print("You did not select any sports");
                }

            %>
        </ul>
        <br/>
        <a href='cookiePersonalizedForm.jsp'>Personalized From</a>

        <a href='registrationForm.html'>Go Back</a>
        <%            
            String username = request.getParameter("username");
            if (!username.equals("")) {
                Cookie cookie = new Cookie("app.username", username);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
            }
            String language = request.getParameter("language");
            if (language!=null) {
                Cookie cookieLang = new Cookie("app.language", language);
                cookieLang.setMaxAge(60 * 60);
                response.addCookie(cookieLang);
            }
        %>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
