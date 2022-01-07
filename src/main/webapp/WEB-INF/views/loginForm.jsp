<%--
  Created by IntelliJ IDEA.
  User: khoal
  Date: 1/1/2022
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <%@ include file="../header/nav.jsp" %>
    <div class="container text-center" style="width: 400px">
        <div class="login-form">
            <form action="/onlinequiz/login" method="POST">
                <h2 class="text-center">Log in</h2>
                <div class="form-group">
                    <input type="text" class="form-control" required="required" name="userName">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" required="required" name="userPassword">
                </div>
                <div class="form-group">
                    <p2>${errorMsg}</p2>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Log in</button>
                </div>
            </form>

        </div>
    </div>
    <div class="container text-center" >
    <img src="https://blog.malwarebytes.com/wp-content/uploads/2018/12/shutterstock_1214717467-900x506.jpg" alt="">
    </div>

</body>

</html>
