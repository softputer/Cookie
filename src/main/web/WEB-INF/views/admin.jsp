<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 19.08.16
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="user" items="${users}">
    ${user.username} ${user.email}
        <br>
        <c:forEach var="commodity" items="${user.commodities}">
            ${commodity.name}
            <a href="delete/${user.id}/${commodity.id}">delete</a>
        </c:forEach>
    </c:forEach>
</body>
</html>
