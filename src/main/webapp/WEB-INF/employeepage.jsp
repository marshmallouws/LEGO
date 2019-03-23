<%-- 
    Document   : employee
    Created on : 23-Mar-2019, 18:49:26
    Author     : Annika
--%>

<%@page import="functionlayer.LogicFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="functionlayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ArrayList<Order> orders = LogicFacade.getAllOrders();%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Medarbejder side</h1>
        <table>
            <thead>
            <th>Id</th>
            <th>Brugerid</th>
            <th>Dato</th>
            <th>Højde</th>
            <th>Længde</th>
            <th>Bredde</th>
            <th>Status</th>
        </thead>
        <tbody>

            <%
                for (Order o : orders) {
            %>

            <tr>
                <td>
                    <a href="FrontController?height=<%= o.getHeight()%>&length=<%=o.getLength()%>&width=<%= o.getWidth()%>&ordernumber=<%= o.getId()%>&command=pieceslist">
                        <%out.print(o.getId()); %></a>
                </td>
                <td><%= o.getUser().getId() %></td>
                <td><%= o.getDate() %></td>
                <td><%= o.getHeight() %></td>
                <td><%= o.getLength() %></td>
                <td><%= o.getWidth() %></td>
                <td><%= o.getStatus() %></td>
            </tr>
            <% }%>
        </tbody>
    </table>

</body>
</html>
