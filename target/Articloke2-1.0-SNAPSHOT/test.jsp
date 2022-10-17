<%-- 
    Document   : test.jsp
    Created on : 28-Sep-2022, 15:11:16
    Author     : tucuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${sessionScope.user.username}
    </body>
</html>
