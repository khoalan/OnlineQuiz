<%--
  Created by IntelliJ IDEA.
  User: khoal
  Date: 1/2/2022
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <style>
        .rating-css {
            height: 100px;
            width: 450px;
            background: white;
            border: 4px solid white;
        }
        .rating-css div {
            color: #ffe400;
            font-size: 30px;
            font-family: sans-serif;
            font-weight: 800;
            text-align: center;
            text-transform: uppercase;
        }
        .rating-css input {
            display: none;
        }
        .rating-css input + label {
            font-size: 30px;
            text-shadow: 1px 1px 0 #ffe400;
            cursor: pointer;
        }
        .rating-css input:checked + label ~ label {
            color: #838383;
        }
        .rating-css label:active {
            transform: scale(0.8);
            transition: 0.3s ease;
        }
    </style>
</head>
<body>
    <%@ include file="../header/userNav.jsp" %>
    <div class="container">
        <form action="/onlinequiz/feedback" method="post">

            <div class="form-group">
                <label for="exampleFormControlSelect1">Select quiz topic</label>
                <select class="form-control" id="exampleFormControlSelect1" name="topicId">
                    <option value="1">HTML</option>
                    <option value="2">JavaScript</option>
                    <option value="3">Python</option>
                </select>
            </div>
            <div class="form-group">
                <label>Rate the quiz!</label>
                <div class="rating-css">
                    <div class="star-icon">
                        <input type="radio" name="rating1" id="rating1" value="1">
                        <label for="rating1" class="fa fa-star" ></label>
                        <input type="radio" name="rating1" id="rating2" value="2">
                        <label for="rating2" class="fa fa-star"></label>
                        <input type="radio" name="rating1" id="rating3" value="3">
                        <label for="rating3" class="fa fa-star"></label>
                        <input type="radio" name="rating1" id="rating4" value="4">
                        <label for="rating4" class="fa fa-star"></label>
                        <input type="radio" name="rating1" id="rating5" value="5">
                        <label for="rating5" class="fa fa-star"></label>
                    </div>
                </div>
                <%--                <label for="exampleFormControlSelect2">Rating</label>--%>
<%--                <select multiple class="form-control" id="exampleFormControlSelect2" name="rating">--%>
<%--                    <option value="1">1</option>--%>
<%--                    <option value="2">2</option>--%>
<%--                    <option value="3">3</option>--%>
<%--                    <option value="4">4</option>--%>
<%--                    <option value="5">5</option>--%>
<%--                </select>--%>
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Comments</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="comment"></textarea>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-info">Submit</button>
            </div>
        </form>
    </div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ionicons/6.0.0/esm/ionicons.min.js" integrity="sha512-EmbXlzmS4lTfNxBz7xWacOcWYBw42KAzHTbtuVQvCPrR+fTeHHMB2dnxKqxhwqSqrK8foPW/LZOnHof4DCDHMw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</html>
