<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/4/2022
  Time: 12:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/userprofile">Back</a><br>
---------------------------------------------------------------------<br>
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

<c:forEach var="user" items="${users}">
    Author:
    ${user.firstname} ${user.lastname}
    <br>
    Mail: ${user.email}
    <br>
    <form action="${pageContext.request.contextPath}/posts">
        <input type="hidden" name="userId" value="${user.userId}">
        <input type="submit" value="view ${user.firstname}'s posts">
    </form>
</c:forEach>


</body>
</html>
