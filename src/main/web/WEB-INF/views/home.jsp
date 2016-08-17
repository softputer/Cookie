
<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 17.08.16
  Time: 11:00
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

    <sec:authentication property="name"/>
    <br>
    <a href="registration">registration</a>
    <br>
    <a href="loginpage">login</a>
    <br>
    <a href="newCommodity">add commodity</a>
    <br>
    <a href="addIntoBasket">my basket</a>
    <br>
    <form:form action="logout" method="post">
        <button>logout</button>
    </form:form>
    <br>
    <c:forEach var="commodity" items="${commodities}">
        ${commodity.name} ${commodity.price}
        <sec:authorize access="isAuthenticated()">
            <a href="intoBasket/${commodity.id}">into basket</a>
        </sec:authorize>
        <br>
    </c:forEach>
    <%--${cookie.hitCounter.value}--%>
</body>
</html>
