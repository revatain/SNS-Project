<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form id="form1">
		<div><input id="id" type="text" name="id" placeholder="아이디" /></div>
		<div><input id="pw" type="password" name="pw" placeholder="비밀번호" /></div>
		<div><button type="button" onclick="login()" >로그인</button></div>
	</form>
</body>
<script>

	const login = () => {
		
	    const form1 = new FormData(document.getElementById("form1"));
		const data = Object.fromEntries(form1.entries());
		
		$.ajax({
			url: "/login",
			type: "POST",
			contentType: 'application/json; charset=utf-8',
			data: data
		}).done(function(result) {
			console.log(result);
			const resDTO = JSON.parse(result);
			// 통신 성공 200
			if(resDTO.code == 0){
				alert(resDTO.message);
				location.href="/index";
			} else {
				alert(resDTO.message);
			}
		}).fail(function(error) {
			// 통신 실패 404 / 500
			alert(error);
		});
		
	}

</script>
</html>








