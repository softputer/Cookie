<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 17.08.16
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>

<form:form modelAttribute="user" action="registration" method="post" cssStyle="text-align: center; margin-top: 20%">
    <form:input path="username" placeholder="username"/>
    <br>
    <form:input path="phone" type="text" placeholder="phone"/>
    <br>
    <form:input path="email" type="email" placeholder="email"/>
    <br>
    <form:input path="password" type="password" placeholder="password"/>
    <br>
    <button>Sing up</button>
</form:form>

</body>
<head>
    <title>Title</title>
</head>
</html>
