<%-- 
    Document   : pieceslist
    Created on : 23-Mar-2019, 12:23:16
    Author     : Annika
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% HashMap<String, Integer> h = (HashMap)session.getAttribute("pieces"); %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ordre nummer <% out.print(request.getParameter("ordernumber"));%></h1>
        <table>
            <tr>
                <th>2x4</th>
                <th>2x2</th>
                <th>2x1</th>
            </tr>
            <tr>
                <th> <% out.print(h.get("2x4")); %> </th>
                <th> <% out.print(h.get("2x2")); %> </th>
                <th> <% out.print(h.get("2x1"));%> </th>
            </tr>
        </table>
    </body>
</html>
