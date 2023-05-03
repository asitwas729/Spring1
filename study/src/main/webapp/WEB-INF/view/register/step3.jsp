<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
<h2>Step3 - 회원가입완료</h2>
<p>회원 가입을 완료하였습니다.</p>
<p>
    <spring:message code="register.done" arguments="${registerRequest.name}"/>
</p>
<a href="<c:url value='/main'/>">[<spring:message code="go.main"/> ]</a>
</body>
</html>