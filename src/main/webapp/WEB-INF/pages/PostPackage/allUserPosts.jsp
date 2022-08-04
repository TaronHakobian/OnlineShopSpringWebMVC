<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: ${sessionScope.user.getTheme()}">
<a href="${pageContext.request.contextPath}/home">Home</a><br><br>

Author:
${author.firstname} ${author.lastname}
<br>
Mail: ${author.email}<br>
<form action="${pageContext.request.contextPath}/userprofile/saveUser" method="post">
    <input type="hidden" name="userId" value="${author.userId}">
    <input type="submit" value="Save">
</form>
<br>
--------------------------------------------------------------
<br>
<c:forEach var="post" items="${author.posts}">
    <c:out value="${post.title}"/><br>
    <img src="${post.imageUrl}"/><br>
    <c:out value="${post.comment}"/><br>
    ------------------------------------<br>
</c:forEach>
</body>
</html>
