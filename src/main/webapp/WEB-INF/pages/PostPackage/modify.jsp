<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/31/2022
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<a href="${pageContext.request.contextPath}/userprofile">Back To Profile</a>

<body style="background-color: ${sessionScope.user.getTheme()}">
<form action="${pageContext.request.contextPath}/modifyPost">
    <input type="hidden" name="postId" value="${post.postId}">
    <img src="${post.imageUrl}">
    <br><br>
    <textarea name="title" rows="2" cols="10">
        ${post.title}
    </textarea>
    <br><br>
    <textarea name="comment" rows="7" cols="50">
        ${post.comment}
    </textarea>
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
