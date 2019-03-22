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
<%  Order order = (Order)session.getAttribute("order");
    HashMap<String, Integer> h = LogicFacade.calculate(order.getHeight(), order.getLength(), order.getWidth()); %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Din ordre er gennemført</h1>
        
        <table>
            <tr>
                <th>2x4</th>
                <th>2x2</th>
                <th>2x1</th>
            </tr>
            <tr>
                <th> <% out.print(h.get("2x4")); %> </th>
                <th> <% out.print(h.get("2x2")); %> </th>
                <th> <% out.print(h.get("2x1")); %> </th>
            </tr>
        </table>
    </body>
</html>
