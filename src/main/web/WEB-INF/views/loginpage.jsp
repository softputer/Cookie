<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  UserInfo: koko
  Date: 08.08.16
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    loginpage
    <form:form action="/loginprocesing" method="post">
        <input name="username">
        <input name="password">
        <button>butt</button>
    </form:form>

</body>
</html>
