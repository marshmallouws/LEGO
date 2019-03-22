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
            Højde:
            <input type="number" name="height" min="1" max="100"> <br>
            Bredde:
            <input type="number" name="width" min="5" max="100"><br>
            Længde:
            <input type="number" name="length" min="5" max="100"> <br>
            <input type="submit" value="Køb LEGO-hus">
        </form> <br>

        <form name="oldorders" action="FrontController" method="Post">
            <input type="hidden" name="command" value="oldorders">
            <input type="submit" value="Se gamle ordrer">
        </form>


    </body>
</html>
