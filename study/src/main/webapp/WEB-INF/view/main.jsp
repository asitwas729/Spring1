<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-04-07
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 로그인 안한 경우 --%>
<c:if test="${empty authInfo}">
    환영합니다.
    <a href="<c:url value='/register/step1'/>">[회원가입하러 가기]</a>
    <a href="<c:url value='/login'/>">[로그인하러 가기]</a>
</c:if>

<%-- 로그인 한 경우 --%>
<c:if test="${!empty authInfo}">
    ${authInfo.name}님, 환영합니다.

    <a href="<c:url value='/logout'/>">[로그아웃]</a>
</c:if>

</body>
</html>
