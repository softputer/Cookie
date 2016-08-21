<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 17.08.16
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    my profile
    <c:forEach var="commodity" items="${commodities}">
        ${commodity.name} ${commodity.price}
        <a href="getOrder/${commodity.id}">get order</a>
        <a href="deleteCookie/${commodity.id}">delete form basked</a>
        <br>
    </c:forEach>

    <form:form action="/sendImage?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data" >
        <input type="file" name="image">
        <button>Submit</button>
    </form:form>
    <br>
    <img src="${user.avatar}?lastmod=12345678"/>
</body>
</html>
