<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	 
	/************************************************************************
	  * 설명 : 로그인 폼
	  * 작성자 : 서지숙
	  * 작성일 : 2023-01-02
	  * 변경일 : 
	************************************************************************/
	
	// 로그인 실패 알림
	if("${loginSucYn}"=="N"){
		
		alert("로그인에 실패했습니다. 다시시도해주세요.");
	}
	
	alert("${loginSucYn}");
	// 회원가입 성공 알림
	if("${signupSucYn}"=="Y"){
		
		alert("회원가입에 성공했습니다.");
	}
	
	</script>
<meta charset="UTF-8">
<title>로그인하기</title>
</head>
	<body>
	<h1>Login</h1>
	<form action="process" id="login-frm" method="post">
		<p> ID <input type="text" name="id" /></p>
		<p> PASSWORD <input type="password" name="password" /></p>
		<p><input type="submit" value="로그인" /></p>
		<p><input type="button" value="회원가입" onclick="location.href='signup'"/></p>
		<p><input type="text" value="${loginSucYn}"/></p>
	</form>


	</body>
</html>