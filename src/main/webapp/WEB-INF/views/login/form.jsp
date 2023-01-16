<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인하기</title>
</head>
	<body>
	<h1>Login</h1>
	<form action="process" id="login-frm" method="post">
		<p> ID <input type="text" name="id" /></p>
		<p> PASSWORD <input type="password" name="password" /></p>
		<p><input type="submit" value="로그인" /></p>
	</form>
<script th:inline="javascript">
if("${loginSucYn}"=="N"){
	alert("로그인에 실패했습니다. 다시시도해주세요.");
}
</script>
	</body>
</html>