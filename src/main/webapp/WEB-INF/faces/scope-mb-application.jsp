<%@ page import="ru.brazhnikov.enterprise.controller.scope.ScopeManagedBeanRequest" %>
<%@ page import="ru.brazhnikov.enterprise.controller.scope.ScopeManagedBeanApplication" %><%--
  Created by IntelliJ IDEA.
  User: vasek
  Date: 03.01.19
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<% final ScopeManagedBeanApplication smba = new ScopeManagedBeanApplication(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><%=smba.title%></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../views/menu/main-top-menu.jsp" />
    <div class="row">
        <div class="col-md-12">
            <h1><%=smba.title%></h1>
            <p><b>timestamp :</b><%=smba.timestamp()%></p>
            <p><b>hashCode :</b><%=smba.hashCode()%></p>
        </div>
        <div class="col-md-12">
            <form action="scope-mb-request">
                <button type="submit" class="btn btn-primary">Refresh</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../views/footer/main-footer.jsp" />
</body>
</html>

