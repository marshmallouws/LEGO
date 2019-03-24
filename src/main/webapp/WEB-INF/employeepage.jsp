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

        <div class="list"><br>
            <input type="text" id="myInput" onkeyup="myFunction()" placeholder="søg efter id">
            <table class="table" id="myTable">
                <thead>
                <th>Id</th>
                <th>Brugerid</th>
                <th>Dato</th>
                <th>Højde</th>
                <th>Længde</th>
                <th>Bredde</th>
                <th>Status</th>
                <th>Ændre status</th>
                </thead>
                <tbody>
                    <%
                        for (Order o : orders) {
                    %>

                    <tr>
                        <td>
                            <a href="FrontController?height=<%= o.getHeight()%>&length=<%=o.getLength()%>&width=<%= o.getWidth()%>&ordernumber=<%= o.getId()%>&command=pieceslist">
                                <%=o.getId()%></a>
                        </td>
                        <td><%= o.getUser().getId()%></td>
                        <td><%= o.getDate()%></td>
                        <td><%= o.getHeight()%></td>
                        <td><%= o.getLength()%></td>
                        <td><%= o.getWidth()%></td>

                        <td>
                            <a href="FrontController?orderid=<%= o.getId()%>&command=changestatus&status=<%=o.getStatus()%>">
                                <%= o.getStatus()%></a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>

            </table>
        </div>
        <script>
            function myFunction() {
                // Declare variables 
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");

                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[0];
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        </script>
    </body>
</html>
