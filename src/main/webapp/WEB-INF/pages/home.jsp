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
<form method="get" action="/searchByUsername">
    <label>
        SearchByUsername <input type="text" name="searchByUsername"/><br>
        <input type="submit" value="search"/>
    </label>
</form>
<c:choose>
    <c:when test="${user != null}">
        <a href="${pageContext.request.contextPath}/userprofile" class="user-name">${user.username}</a>
    </c:when>
    <c:otherwise>
        <a href="${pageContext.request.contextPath}/login" class="log-in">Log in</a>
        <a href="${pageContext.request.contextPath}/signup" class="sign-up">Sign up</a>
    </c:otherwise>
</c:choose>
<c:forEach var="post" items="${DB.posts}">
    <div class="post">
        <img alt="image" src="${post.imageUrl}"/>
        <h3>${post.title}</h3>
    </div>
</c:forEach>
</body>
</html>
