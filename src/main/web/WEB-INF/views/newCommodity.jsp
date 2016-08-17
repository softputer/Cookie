<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 17.08.16
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form modelAttribute="commodity" action="newCommodity" method="post">
        <form:input path="name" type="text" placeholder="commodity name"/>
        <form:input path="price" placeholder="price" type="text"/>
        <button>save commodity</button>
    </form:form>

</body>
</html>
