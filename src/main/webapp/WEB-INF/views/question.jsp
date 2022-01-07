<%--
  Created by IntelliJ IDEA.
  User: khoal
  Date: 1/1/2022
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="../header/userNav.jsp" %>

    <div class="container" style="margin-top: 50px;">

        <div class="row col-8">
            <form class=" bg-white px-4" action="/onlinequiz/question?index=${index}" method="post">
                <p class="fw-bold">${index}. ${questionList.get(0).questionDetail}</p>

                <c:forEach items="${choiceList}" var="choice" >

                <div class="form-check" style="background-color: blanchedalmond; width: 1100px;height: 30px; margin-bottom: 5px">
<%--                    <input  type="radio" name="input" value="${choice.choiceId}" ${resultList.get(0).getSelectedAnswer() == choice.choiceId ? 'checked':''} />--%>
                    <input class="form-check-input" type="radio" name="input" id="radioExample1" value="${choice.choiceId}" ${resultList.get(0).getSelectedAnswer() == choice.choiceId ? 'checked':''}/>
                    <label class="form-check-label">${choice.choiceDetail}
                    </label>
                </div>

                </c:forEach>

                <c:if test = "${index != 1}">
                    <button type="submit" class="btn btn-primary" id="previous" name = "action" value = "previous">Previous</button>
                </c:if>
                <c:if test = "${index != 10}">
                    <button type="submit" class="btn btn-primary" id="next" name = "action" value = "next">Next</button>
                </c:if>
            </br>
            </br>
                <button type="submit" class="btn btn-primary" id="submitAll" name = "action" value = ${notFinish > 1 ?"notFinish":"finish"} onclick="return submitConfirm()" >Submit</button>
            </form>
        </div>
    </div>
</body>
<script>

        var submitAllEl = document.getElementById('submitAll');
        var inputEl = document.getElementsByName('input');
        console.log(submitAllEl.value);
        function submitConfirm() {

            if (inputEl[0].checked == false && inputEl[1].checked == false && inputEl[2].checked == false && inputEl[3].checked == false){
                return confirm('You did not answer all the question ! Are you sure to submit?' );

            } else if (submitAllEl.value == "notFinish"){
                return confirm('You did not answer all the question ! Are you sure to submit?' );

            } else {
                return confirm('Confirm submit?');
            }
        }
</script>
</html>

<%--    <div class="container content">--%>
<%--        <form action="/onlinequiz/question?index=${index}" method="post" >--%>

<%--&lt;%&ndash;            <input type="hidden" name="questionLeft" value="${questionLeft}">&ndash;%&gt;--%>
<%--                <p>${index}. ${questionList.get(0).questionDetail}<p>--%>
<%--                 <br/>--%>
<%--                <c:forEach items="${choiceList}" var="choice" >--%>
<%--                    <input  type="radio" name="input" value="${choice.choiceId}" ${resultList.get(0).getSelectedAnswer() == choice.choiceId ? 'checked':''} />${choice.choiceDetail}--%>
<%--                <br/>--%>
<%--                 </c:forEach>--%>
<%--                    <c:if test = "${index != 1}">--%>
<%--                        <button type="submit" class="btn btn-primary" id="previous" name = "action" value = "previous">Previous</button>--%>
<%--                    </c:if>--%>
<%--                    <c:if test = "${index != 3}">--%>
<%--                        <button type="submit" class="btn btn-primary" id="next" name = "action" value = "next">Next</button>--%>
<%--                    </c:if>--%>
<%--                    <c:if test = "${index == 3}">--%>
<%--                    <button type="submit" class="btn btn-primary" id="submitAll" name = "action" value = ${notFinish == 1 ?"notFinish":"finish"} onclick="return submitConfirm()" >Submit</button>                    --%>
<%--                </c:if>--%>
<%--        </form>--%>

<%--        <div class="container">--%>

<%--        </div>--%>

<%--    </div>--%>


