<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    h1 {
        text-align: center;
    }
</style>
<body style="background-color: ${sessionScope.user.getTheme()}">

<a href="${pageContext.request.contextPath}/home">Home</a>
<br>
<c:if test="${superCategory!=null}">
    <a href="${pageContext.request.contextPath}/category?Category=${superCategory}">Back To ${superCategory}</a>
</c:if>

<h1>${category}</h1>
<br>

<form action="${pageContext.request.contextPath}/subCategory">
    <c:forEach var="subSector" items="${subSectors}">
        <input type="submit" name="subcategory" value="${subSector}">
    </c:forEach>
</form>
----------------------------------------------<br>

<c:forEach var="post" items="${posts}">
    <form class="post1" action="${pageContext.request.contextPath}/post">
        <input type="hidden" name="postId" value="${post.postId}">
        <input type="hidden" name="authorId" value="${post.authorId}">
        <h3>${post.title}</h3>
        <img alt="image" src="${post.imageUrl}"/><br>
        <input type="submit" value="view"><br>
    </form>
    <br>
    -------------------------------------------------------------------<br>
</c:forEach>


</body>
</html>
