<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
</head>
<body>

<form:form method="post" modelAttribute="loginCommand">
    <form:errors/>
    <p>
        <label for="email"><spring:message code="email" />: </label>
        <form:input path="email" />
        <form:errors path="email" />
    </p>

    <p>
        <label for="password"><spring:message code="password" /> : </label>
        <form:password path="password" />
        <form:errors path="password" />
    </p>

    <p>
        <label>이메일 기억하기</label>
        <form:checkbox path="rememberEmail" />
    </p>

    <input type="submit" value="<spring:message code="login.btn" />" />
    </form:form>
</body>
</html>