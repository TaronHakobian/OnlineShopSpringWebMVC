<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="canvas" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.shop.database.DB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: ${sessionScope.user.getTheme()}">
<a href="/home">Home</a><br>

Author:
${author.firstname} ${author.lastname}
<br>
Mail: ${author.email}
<br>
<form action="${pageContext.request.contextPath}/posts">
    <input type="hidden" name="userId" value="${author.userId}">
    <input type="submit" value="view ${author.firstname}'s posts">
</form>
<br>
----------------------------------------<br>
<c:out value="${post.title}"/>
<br>
<img src="${post.imageUrl}">
<br>
<c:out value="${post.comment}"/>
<br>

<c:choose>
    <c:when test="${sessionScope.user.getFavoritePosts().contains(post)}">
        <form action="${pageContext.request.contextPath}/unSavePost" method="post">
            <input type="hidden" name="postId" value="${post.postId}">
            <input type="hidden" name="authorId" value="${author.userId}">
            <input type="submit" value="UnSave">
        </form>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/savePost" method="post">
            <input type="hidden" name="postId" value="${post.postId}">
            <input type="hidden" name="authorId" value="${author.userId}">
            <input type="submit" value="Save">
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
