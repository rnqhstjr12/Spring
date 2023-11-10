<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과창</title>
</head>
<body>
	<h1>결과화면</h1>
	아이디 : ${userId }<br>
	이름 : ${name }<br>
	<hr>
	아이디 : ${info.userId }<br>
	이름 : ${info.name }<br>
	<hr>
</body>
</html>