<%-- 
    Document   : pieceslist
    Created on : 23-Mar-2019, 12:23:16
    Author     : Annika
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% HashMap<String, HashMap<String, Integer>> h = (HashMap)session.getAttribute("pieces"); %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stykliste</title>
    </head>
    <body>
        <h1>Ordre nummer <% out.print(request.getParameter("ordernumber"));%></h1>
        <table>
            <tr>
                <th>type</th>
                <th>side 1</th>
                <th>side 2</th>
                <th>side 3</th>
                <th>side 4</th>
            </tr>
            <tr>
                <th>2x4</th>
                <td><%= h.get("side1").get("2x4")%></td>
                <td><%= h.get("side2").get("2x4")%></td>
                <td><%= h.get("side3").get("2x4")%></td>
                <td><%= h.get("side4").get("2x4")%></td>
            </tr>
            <tr>
                <th>2x2</th>
                <td><%= h.get("side1").get("2x2")%></td>
                <td><%= h.get("side2").get("2x2")%></td>
                <td><%= h.get("side3").get("2x2")%></td>
                <td><%= h.get("side4").get("2x2")%></td>
            </tr>
            <tr>
                <th>2x1</th>
                <td><%= h.get("side1").get("2x1")%></td>
                <td><%= h.get("side2").get("2x1")%></td>
                <td><%= h.get("side3").get("2x1")%></td>
                <td><%= h.get("side4").get("2x1")%></td>
            </tr>
        </table>
    </body>
</html>
