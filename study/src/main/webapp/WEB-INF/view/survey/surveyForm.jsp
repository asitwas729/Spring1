<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
  <title>Survey</title>
</head>
<body>
<h2>설문조사</h2>
<form:form action="SurveyCommand.java" method="post">
  <form:errors />
  <p>
    1. 당신의 희망 분야는? <br/>
    <label for="Q1">
      <input type="radio" name="responses[0]" value="서버">서버개발자
    </label>
    <label for="Q1">
      <input type="radio" name="responses[0]" value="프론트">프론트개발자
    </label>
    <label for="Q1">
      <input type="radio" name="responses[0]" value="풀스택">풀스택개발자
    </label>
    <form:input path="Q1" />
    <form:errors path="Q1" />
  </p>
  <p>
    2. 가장 많이 사용하는 개발도구는? <br/>
    <label for="Q2">
      <input type="radio" name="responses[1]" value="Eclipse">Eclipse
    </label>
    <label for="Q2">
      <input type="radio" name="responses[1]" value="IntelliJ">IntelliJ
    </label>
    <label for="Q2">
      <input type="radio" name="responses[1]" value="VSCode">VSCode
    </label>
    <form:input path="Q2" />
    <form:errors path="Q2" />
  </p>
  <p>
    3. 하고 싶은 말 <br/>
    <label for="Q3">
      <input type="text" name="responses[2]" />
    </label>
    <form:input path="Q3" />
    <form:errors path="Q3" />
  </p>
  <p>
    <label for="RespondentName">
      응답자 이름 <input type="text" name="res.name" />
    </label>
    <form:input path="RespondentName" />
    <form:errors path="RespondentName" />
  </p>
  <p>
    <label for="RespondentAge">
      응답자 나이 <input type="text" name="res.age" />
    </label>
    <form:input path="RespondentAge" />
    <form:errors path="RespondentAge" />
  </p>

  <input type="submit" value="전송" />
</form:form>
</body>
</html>