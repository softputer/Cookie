
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
    <sec:authorize access="!isAuthenticated()">
        <a href="registration">registration</a>
    </sec:authorize>
    <br>
    <a href="loginpage">login</a>
    <br>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="newCommodity">add commodity</a>
        <br>
            <a href="newShop">new shop</a>
        <br>
        <a href="admin">admin page</a>
        <br>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a href="profile">profile</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <form:form action="logout" method="post">
            <button>logout</button>
        </form:form>
    </sec:authorize>
    <br>
    <c:forEach var="commodity" items="${commodities}">
        ${commodity.name} ${commodity.price}
        <c:forEach var="shop" items="${commodity.shops}">
            ${shop.name}
        </c:forEach>


        <sec:authorize access="isAuthenticated()">
            <a href="/intoBasket/${commodity.id}">into basket</a>
        </sec:authorize>



        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a href="deleteCommodity/${commodity.id}">delete</a>
        </sec:authorize>
        <br>
    </c:forEach>
</body>
</html>
