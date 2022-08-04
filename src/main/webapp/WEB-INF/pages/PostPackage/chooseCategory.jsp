<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/30/2022
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.shop.database.DB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: ${sessionScope.user.getTheme()}">
<a href="${pageContext.request.contextPath}/userprofile">Back To Profile</a>
<br>

Vehicle :
<form action="${pageContext.request.contextPath}/addPost/" method="post">
    <input type="submit" name="Car" value="Car">
    <input type="submit" name="Bike" value="Bike">
    <input type="submit" name="Bus" value="Bus">
</form>
<br><br>
<br><br>
Cloth :
<form action="${pageContext.request.contextPath}/addPost/" method="post">
    <input type="submit" name="Shoes" value="Shoes">
    <input type="submit" name="Clothing" value="Clothing">
    <input type="submit" name="Underwear" value="Underwear">
</form>
<br><br>
<br><br>
Accessories :
<form action="${pageContext.request.contextPath}/addPost/" method="post">
    <input type="submit" name="Jewellery" value="Jewellery">
    <input type="submit" name="Watches" value="Watches">
</form>
<br><br>
<br><br>
Jobs :
<form action="${pageContext.request.contextPath}/addPost/" method="post">
    <input type="submit" name="ProgrammingAndDevelopment" value="ProgrammingAndDevelopment">
    <input type="submit" name="ScienceAndEngineering" value="ScienceAndEngineering">
    <input type="submit" name="MediaAndDesign" value="MediaAndDesign">
</form>
<br><br>
<br><br>
</body>
</html>
