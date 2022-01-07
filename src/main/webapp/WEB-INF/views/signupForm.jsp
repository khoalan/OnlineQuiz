<%--
  Created by IntelliJ IDEA.
  User: khoal
  Date: 12/31/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>SignUp</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src ="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
    <%@ include file="../header/nav.jsp" %>
    <div class="container text-center">
        <div>
            <h2>User Registration - Sign Up</h2>
        </div>
        <form:form action="/onlinequiz/process_register" method="post" modelAttribute="user" id="registrationForm" style="max-width: 700px; margin: 0 auto;" >
            <div class="m-3">

                <div class="form-group row">
                    <form:label path="userName" class="col-4 col-form-label">User Name: </form:label>
                    <div class="col-8">
                        <form:input path="userName" type="text" class="form-control" id="userName"/>
                        <div class="form-group">
                            <p2 style="color: red">${errorMsgName}</p2>
                        </div>
                    </div>
                    <form:errors path="userName" style="color:red;"/>

                </div>
                <div class="form-group row">
                    <form:label path="userPassword" class="col-4 col-form-label">Password: </form:label>
                    <div class="col-8 ">
                        <form:input path="userPassword" type="password" class="form-control" id="userPassword"/>
                    </div>
                    <form:errors path="userPassword" style="color:red;"/>
                </div>

                <div class="form-group row">
                    <form:label path="email"  class="col-4 col-form-label">E-mail: </form:label>
                    <div class="col-8">
                        <form:input type="email" path="email" class="form-control" id="userEmail"/>
                        <div class="form-group">
                            <p2 style="color: red">${errorMsgEmail}</p2>
                        </div>
                    </div>
                    <form:errors path="email" style="color:red;"/>

                </div>

                <div>
                    <button type="submit" class="btn btn-primary" onClick="return empty()">Sign Up</button>
                </div>
            </div>
        </form:form>
    </div>
</body>

</html>
