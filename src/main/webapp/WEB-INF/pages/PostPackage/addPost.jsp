<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/30/2022
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.shop.database.DB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body style="background-color: ${sessionScope.user.getTheme()}">
<a href="${pageContext.request.contextPath}/userprofile">Back To Profile</a>
<br>

-----------------${category}-----------------
<form action="${pageContext.request.contextPath}/addPost/create" method="post">
    <input type="hidden" name="category" value="${category}">
    Title: <input type="text" name="title" required><br><br>
    Url: <input type="text" name="url"><br><br>
    Comment:<input type="text" name="comment" required><br><br>
    <input type="submit" value="submit"><br><br>
</form>

</body>
</html>
