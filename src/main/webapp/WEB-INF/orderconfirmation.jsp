<%-- 
    Document   : orderconfirmation
    Created on : 22-Mar-2019, 20:26:44
    Author     : Annika
--%>

<%@page import="java.util.HashMap"%>
<%@page import="functionlayer.Order"%>
<%@page import="functionlayer.LogicFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  Order order = (Order) session.getAttribute("order");
    HashMap<String, HashMap<String, Integer>> h = LogicFacade.calculate(order.getHeight(), order.getLength(), order.getWidth());%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orderbekræftelse</title>
    </head>
    <body>
        <h1>Ordre nummer <%=order.getId()%> er nu gennemført</h1>

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
        <br>
        <form name="back" action="FrontController">
            <input type="hidden" name="command" value="back">
            <input type="submit" value="tilbage til forside">
        </form>
    </body>
</html>
