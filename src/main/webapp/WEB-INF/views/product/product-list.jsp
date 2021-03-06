<%@ page import="ru.brazhnikov.enterprise.config.FieldConf" %>
<%@ page import="ru.brazhnikov.enterprise.entity.Product" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: vasek
  Date: 03.01.19
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../menu/main-top-menu.jsp" />
    <div class="row">
        <div class="col-md-12">
            <%
                final Object productsObject = request.getAttribute( FieldConf.PRODUCTS );
                final Collection<Product> products = (Collection<Product>) productsObject;
                final Object title =  request.getAttribute( "title" );
            %>
            <h1><%=title%></h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <% int index = 1; %>
                <tbody>
                    <% for ( final Product product : products ) { %>
                        <tr>
                            <td scope="row"><%= index %></td>
                            <td><%= product.getId() %></td>
                            <td><%= product.getName() %></td>
                            <td><%= product.getDescription() %></td>
                            <td><a href="product-edit?id=<%= product.getId() %>">edit</a></td>
                            <td><a href="product-delete?id=<%= product.getId() %>">delete</a></td>
                        </tr>
                        <% index++; %>
                    <% } %>
                </tbody>
            </table>
        </div>
        <div class="col-md-12">
            <form action="product-create">
                <button type="submit" class="btn btn-primary">Create product</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../footer/main-footer.jsp" />
</body>
</html>

