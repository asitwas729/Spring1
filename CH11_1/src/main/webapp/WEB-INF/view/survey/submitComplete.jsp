<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Survey</title>
</head>
<body>
<h2>응답내용</h2>
<ul>
  <c:forEach var="response" items="${ansData.responses}" varStatus="status">
    <li>${status.index + 1}번 문항 : ${response}</li>
  </c:forEach>
</ul>
<p>응답자 위치 : ${ansData.res.location}</p>
<p>응답자 나이 : ${ansData.res.age}</p>
</body>
</html>