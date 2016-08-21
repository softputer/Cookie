<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 19.08.16
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form modelAttribute="shop" action="newShop" method="post">
        <form:input path="name" placeholder="shop name"/>
        <form:input path="adress" placeolder="adress"/>
        <button>save shop</button>
    </form:form>

</body>
</html>
