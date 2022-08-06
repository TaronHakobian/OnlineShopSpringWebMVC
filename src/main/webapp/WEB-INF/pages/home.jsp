<%--
  Created by IntelliJ IDEA.
  User: sargis
  Date: 19.07.22
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.shop.database.DB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shop</title>
    <style>
        body {
            width: 600px;
            margin: 0 auto;
        }

        .post {
            width: 600px;
            height: 300px;
            display: flex;
            margin-top: 10px;
        }

        .post img {
            width: 200px;
            height: 200px;
        }

        .post h3 {
            margin: 0 0 0 20px;
        }

        .log-in {
            margin: 0 0 0 20px;
        }

        .sign-up {
            margin: 0 0 0 20px;
        }

        a.user-name {
            color: #2da1c1;
            font-size: medium;
            text-decoration: none;
            float: right;
        }

        a.user-name:hover {
            color: #f90;
            text-decoration: underline;
        }
    </style>
</head>
<body style="background-color: ${sessionScope.user.getTheme()}">
<form method="get" action="${pageContext.request.contextPath}/search">
    <input type="text" name="searchContent">
    <input type="submit" value="Search"><br>
</form>
<br>

<form action="${pageContext.request.contextPath}/category">
    <input type="submit" name="Category" value="Jobs">
    <input type="submit" name="Category" value="Vehicle">
    <input type="submit" name="Category" value="Accessories">
    <input type="submit" name="Category" value="Cloths">
</form>
<br><br>
----------------------------------------------------------------
<c:choose>
    <c:when test="${sessionScope.user!=null}">
        <a href="${pageContext.request.contextPath}/userprofile" class="user-name">${sessionScope.user.username}</a><br>
    </c:when>
    <c:otherwise>
        <a href="${pageContext.request.contextPath}/login" class="log-in">Log in</a>
        <a href="${pageContext.request.contextPath}/signup" class="sign-up">Sign up</a><br><br>
    </c:otherwise>
</c:choose>


<c:forEach var="post" items="${posts}">
    <form action="${pageContext.request.contextPath}/post">
        <input type="hidden" name="postId" value="${post.postId}">
        <input type="hidden" name="authorId" value="${post.authorId}">
        <h3>${post.title}</h3>
        <img alt="image" src="${post.imageUrl}"/>
        <input type="submit" value="view">
    </form>
    <br>
    -------------------------------------------------------------------
</c:forEach>

</body>
</html>
