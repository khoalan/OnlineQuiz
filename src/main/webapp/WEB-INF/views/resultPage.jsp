<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: khoal
  Date: 1/1/2022
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="../header/userNav.jsp" %>
    <div class="container" style="margin-bottom: 50px">
        <h5>Results:</h5>
        <form action="/onlinequiz/result" method="get">
            <p>User name: ${submission.getUser().getUserName()}</p>
            <p>Quiz topic: ${submission.getQuizTopic().getTopicName()}</p>
            <p>Start time: ${submission.getStartTime()}</p>
            <p>End time: ${submission.getEndTime()}</p>
            <p>Correct answer: ${correctNum}/10 </p>
            <p>You are: ${submission.getIsPass()}</p>
            <div style="background-color: beige">
                <c:forEach var = "ch" items = "${choiceList}" varStatus="loopCounter">
            <ul>
                    <c:if test = "${(loopCounter.index) % 4 == 0 }">
                        </br>
                        <p>${Math.ceil((loopCounter.index)/4) + 1} ${ch.getQuestion().getQuestionDetail()}</p>
                    </c:if>
                      <c:if test =  "${resultList.get(loopCounter.index/4).getSelectedAnswer() == ch.getChoiceId() && ch.getIsAnswer() == 1}">

                          <li style="color: green">${ch.getChoiceDetail()}   -----Correct answer!.</li>
                      </c:if>
                        <c:if test =  "${resultList.get(loopCounter.index/4).getSelectedAnswer() == ch.getChoiceId() && ch.getIsAnswer() == 0}">

                            <li style="color: red">${ch.getChoiceDetail()}   -----Wrong answer!. </li>
                        </c:if>
                        <c:if test =  "${resultList.get(loopCounter.index/4).getSelectedAnswer() != ch.getChoiceId() && ch.getIsAnswer() == 1}">
                            <li style="color: blue">${ch.getChoiceDetail()}  <--</li>
                        </c:if>
                        <c:if test =  "${resultList.get(loopCounter.index/4).getSelectedAnswer() != ch.getChoiceId() && ch.getIsAnswer() == 0}">
                            <li>${ch.getChoiceDetail()}</li>
                        </c:if>
            </ul>
                </c:forEach>
            </div>
        </form>

        <form action="/onlinequiz/user" method="get">
            <button type="submit" class="btn btn-info">Take another quiz!</button>
        </form>
    </div>
</body>
</html>
