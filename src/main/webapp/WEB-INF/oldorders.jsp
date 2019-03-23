<%-- 
    Document   : oldorders
    Created on : 21-Mar-2019, 23:31:54
    Author     : Annika
--%>

<%@page import="functionlayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="functionlayer.Order"%>
<%@page import="functionlayer.LogicFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    User user = (User) session.getAttribute("user");
    ArrayList<Order> orders = LogicFacade.getOrders(user); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tidligere ordrer</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Dato</th>
                <th>Højde</th>
                <th>Længde</th>
                <th>Bredde</th>
                <th>Status</th>
            </tr>
            
            <%
              for(Order o: orders) {  
            %>
            
            <tr>
                <td><% out.print(o.getId()); %></td>
                <td><% out.print(o.getDate()); %></td>
                <td><% out.print(o.getHeight()); %></td>
                <td><% out.print(o.getLength()); %></td>
                <td><% out.print(o.getWidth()); %></td>
                <td><% out.print(o.getStatus()); %></td>
            </tr>
            <% } %>
            
        </table>
        
    </body>
</html>
