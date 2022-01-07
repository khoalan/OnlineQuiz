<%--
  Created by IntelliJ IDEA.
  User: khoal
  Date: 12/31/2021
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

</head>
<body>
<%@ include file="../header/nav.jsp" %>
<div class="container text-center">

    <h1 >Welcome to Online Quiz Application</h1>
    <h3><a href="${pageContext.request.contextPath}/onlinequiz/login">Log in!</a></h3>
    <h3><a href="${pageContext.request.contextPath}onlinequiz/register">Create a new account!</a></h3>
    <img src="https://blog.malwarebytes.com/wp-content/uploads/2018/12/shutterstock_1214717467-900x506.jpg" alt="">
</div>
</body>
</html>
