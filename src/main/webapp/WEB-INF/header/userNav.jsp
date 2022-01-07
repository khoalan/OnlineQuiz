<%--
  Created by IntelliJ IDEA.
  User: khoal
  Date: 12/31/2021
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Nav</title>
<%--    <style>--%>
<%--        body {background-color: powderblue;}--%>
<%--        h1   {color: blue;}--%>
<%--        p    {color: red;}--%>
<%--    </style>--%>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--        <span class="navbar-toggler-icon"></span>--%>
        <%--    </button>--%>
        <div class=" navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/onlinequiz/user">Home</a >
            </div>
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/onlinequiz/user">Login</a>
            </div>
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/onlinequiz/register">Register</a>
            </div>
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/onlinequiz/feedback">Feedback</a>
            </div>
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/onlinequiz/contactus">Contact Us</a>
            </div>
        </div>
    </nav>
</div>

</body>
</html>
