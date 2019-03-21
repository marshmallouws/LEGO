<%-- 
    Document   : Customer
    Created on : 21-Mar-2019, 19:29:07
    Author     : Annika
--%>

<%@page import="functionlayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <% User u = (User) session.getAttribute("user");
            out.print(u.getEmail());
            %></h1>

        <form name="order" action="FrontController" method="POST">
            <input type="hidden" name="command" value="order">
            Højde:<br>
            <input type="number" name="height">
            Bredde:<br>
            <input type="number" name="width">
            Dybde:<br>
            <input type="number" name="depth">
            <input type="submit" value="submit">
        </form>



    </body>
</html>
