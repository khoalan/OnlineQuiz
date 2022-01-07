<%--
  Created by IntelliJ IDEA.
  User: khoal
  Date: 1/1/2022
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="../header/userNav.jsp" %>
    <div class="container text-center">
        <form action="${pageContext.request.contextPath}/onlinequiz/logout" method="get" >
            <p>Hello ${user}</p>
            <button type="submit">Log out</button>
        </form>
    </div>
        <div class="container">
            <div class="row">
                <c:forEach items ="${quizTopics}" var = "topic">
                    <div class="col text-center card" style="background-color: bisque; margin: 3px">
                        <img src="${topic.topicImageUrl}" class="card-img-top" style="transform: scale(0.7); "></img>
                        <div class="card-body">
                            <h5 class="card-title">Topic: ${topic.topicName} </h5>
                            <h6 class="card-text">Difficulty: ${topic.topicDifficulty}</h6>
                            <form action="quiz/${topic.topicId}" method="get" >
<%--                                <a class="btn" href="${pageContext.request.contextPath}/onlinequiz/quiz/${topic.topicId}">Take quiz</a>--%>
                                <button type="submit" class="btn btn-primary">Take quiz</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="container">
            <h5>History submission</h5>
            <p>1.${historySubmission.get(0).quizTopic.getTopicName()} </p>
            <p>Start: ${historySubmission.get(0).getStartTime()}, end: ${historySubmission.get(0).getEndTime()}, ${historySubmission.get(0).getIsPass()}</p>
            <p>2.${historySubmission.get(1).quizTopic.getTopicName()} </p>
            <p>Start: ${historySubmission.get(1).getStartTime()}, end: ${historySubmission.get(1).getEndTime()}, ${historySubmission.get(1).getIsPass()}</p>
            <p>3.${historySubmission.get(2).quizTopic.getTopicName()} </p>
            <p>Start: ${historySubmission.get(2).getStartTime()}, end: ${historySubmission.get(2).getEndTime()}, ${historySubmission.get(2).getIsPass()}</p>
        </div>

</body>
</html>
