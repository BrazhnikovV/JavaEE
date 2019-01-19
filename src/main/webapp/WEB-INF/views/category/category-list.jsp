<%@ page import="ru.brazhnikov.enterprise.config.FieldConf" %>
<%@ page import="ru.brazhnikov.enterprise.entity.Category" %>
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
                final Object categoriesObject = request.getAttribute( FieldConf.CATEGORIES );
                final Collection<Category> categories = (Collection<Category>) categoriesObject;
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
                        <th scope="col"></th>
                    </tr>
                </thead>
                <% int index = 1; %>
                <tbody>
                    <% for ( final Category category : categories ) { %>
                        <tr>
                            <td scope="row"><%= index %></td>
                            <td><%= category.getId() %></td>
                            <td><%= category.getName() %></td>
                            <td><%= category.getDescription() %></td>
                            <td><a href="category-edit?id=<%= category.getId() %>">edit</a></td>
                            <td><a href="category-delete?id=<%= category.getId() %>">delete</a></td>
                        </tr>
                        <% index++; %>
                    <% } %>
                </tbody>
            </table>
        </div>
        <div class="col-md-12">
            <form action="category-create">
                <button type="submit" class="btn btn-primary">Create category</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../footer/main-footer.jsp" />
</body>
</html>

