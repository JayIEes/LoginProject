<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>signup done</h1>
	<input type="hidden" id="signupError" value="${signupSucYn}"/>
<script type="text/javascript">

console.log(document.getElementById("signupError").value);
</script>
</body>
</html>
