<%--
  Created by IntelliJ IDEA.
  User: sargis
  Date: 19.07.22
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
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
        a.home {
            color: #2da1c1;
            font-size: medium;
            text-decoration: none;
            float: right;
        }

        a.home:hover {
            color: #f90;
            text-decoration: underline;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/home" class="home">Home</a>
<%--<c:if test="${param['error'] != null}">--%>
<%--    <p class="error">Invalid username or password</p>--%>
<%--</c:if>--%>
<c:if test="${msg != null}">
    <p class="error">${msg}</p>
</c:if>
<form method="post">
    <label>
        FirstName <input type="text" name="firstname"/><br>
    </label>
    <label>
        LastName <input type="text" name="lastname"/><br>
    </label>
    <label>
        Username <input type="text" name="username"/><br>
    </label>
    <label>
        Email <input type="text" name="email"/><br>
    </label>
    <label>
        Password <input type="password" name="password"/><br>
        <p>password must contain <br>
            at least one lowercase,<br>
            uppercase, numeric, special[@#$%] <br>
            symbol and should be
            between 8-20 characters
        </p>
    </label>
    <input type="submit" value="SignUp"/>
</form>
</body>
</html>
