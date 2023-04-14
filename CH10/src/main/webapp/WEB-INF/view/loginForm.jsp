<%--
  Created by IntelliJ IDEA.
  User: asitw
  Date: 2023-04-14
  Time: 오전 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
  <label><spring:message code="rememberEmail"/> </label>
  <form:checkbox path="rememberEmail" />
</p>
<input type="submit" value="<spring:message code="login.btn"/> " />
</body>
</html>
