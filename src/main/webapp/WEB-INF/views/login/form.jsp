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
	if( "${loginSucYn}" !== "" ){
		
		alert("${loginSucYn}");
		history.back();
	}
	
	// 회원가입 성공 알림
/* 	if("${signupSucYn}"=="Y"){
		
		alert("정상적으로 처리되었습니다..");
	} */
	
/* 	window.onpageshow = function (event) {
		if (!event.persisted) {
			// 회원가입 성공 알림
			if("${signupSucYn}"=="Y"){
				
				alert("정상적으로 처리되었습니다.");
			}
		}
	} */
	login_button_onclick = function(){
		
		let id = document.getElementById("id").value;
		let password = document.getElementById("password").value;
		
		if(id == ""){
			alert("아이디를 입력해주세요.");
			return;
		}
		
		if(password == ""){
			alert("패스워드를 입력해주세요.");
			return;
		}
		
		
		document.forms["login_frm"].submit();
	}
	
	</script>
<meta charset="UTF-8">
<title>로그인</title>
</head>
	<body>
	<h1>로그인</h1>
	<form action="process" id="login_frm" method="post">
		<p> 아이디 <input type="text" name="id" id= "id" /></p>
		<p> 패스워드 <input type="password" name="password" id= "password"/></p>
		<p><input type="button" value="로그인" onclick="login_button_onclick()"/>
		<input type="button" value="회원가입" onclick="location.href='signup'"/></p>
	</form>

	</body>
</html>