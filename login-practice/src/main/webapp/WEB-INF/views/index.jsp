<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1>
	<h2>${name}</h2>
	<c:forEach items="${list}" var="item">
		<c:if test='${item ne "1"}'>
			<div>${item}</div>
		</c:if>
	</c:forEach>
	<a href="/login">로그인페이지로 이동</a>
</body>
</html>








