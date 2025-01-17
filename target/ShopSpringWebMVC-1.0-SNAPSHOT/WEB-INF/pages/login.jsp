<%--
  Created by IntelliJ IDEA.
  User: sargis
  Date: 19.07.22
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            width: 600px;
            margin: 0 auto;
        }
        .error {
            color: red;
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
    </style>
</head>
<body>
<c:if test="${param['error'] != null}">
    <p class="error">Invalid username or password</p>
</c:if>
<a href="${pageContext.request.contextPath}/home" class="home">Home</a>
<form method="post">
    <label>
        Username <input type="text" name="username"/><br>
    </label>
    <label>
        Password <input type="password" name="password"/>
    </label>
    <input type="submit" value="LogIn"/>
</form>

</body>
</html>
