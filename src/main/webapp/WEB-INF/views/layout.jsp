<%--
  Created by IntelliJ IDEA.
  User: vasek
  Date: 03.01.19
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Java Enterprise Edition</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <jsp:include page="./menu/main-top-menu.jsp" />
    <% final Object title =  request.getAttribute( "title" ); %>
    <h1><%=title%></h1>
</div>
<jsp:include page="./footer/main-footer.jsp" />
</body>
</html>
