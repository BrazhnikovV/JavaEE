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
                final Object categoryObject = request.getAttribute( FieldConf.PRODUCT );
                final Product product = (Product) categoryObject;
                final Object title =  request.getAttribute( "title" );
            %>
            <h1><%=title%></h1>
        </div>
        <div class="col-md-12">
            <form action="product-save" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">ID</label>
                    <input type="text" value="<%= product.getId() %>" class="form-control" readonly id="exampleInputEmail1" name="id" aria-describedby="emailHelp" placeholder="Enter ID">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputText">Name</label>
                    <input type="text" name="name" value="<%= product.getName() %>" class="form-control is-invalid" id="exampleInputText" aria-describedby="emailHelp" placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label for="exampleInputDescription">Description</label>
                    <input type="text" name="description" value="<%= product.getDescription() %>" class="form-control is-invalid" id="exampleInputDescription" aria-describedby="emailHelp" placeholder="Enter name">
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../footer/main-footer.jsp" />
</body>
</html>

