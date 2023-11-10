<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${test}
	<h1>로그인 폼</h1>
	<form action="${contextPath}/login/login4" method="post">
		아이디 : <input type="text" name="userId"><br>
		이름 : <input type="text" name="name"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>