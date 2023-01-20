<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<script type="text/javascript">
	
	/************************************************************************
	 * 설명 : 회원가입 폼
	 * 작성자 : 서지숙
	 * 작성일 : 2023-01-05
	 * 변경일 : 
	************************************************************************/
	
	//아이디 중복체크 flag
	let idChk = false;
	
	
	// 회원가입 실패 알림
	if(document.getElementById("signupError").value =="N"){
		
		alert("회원가입에 실패했습니다. 다시시도해주세요.");
	}

	
	// 회원가입 버튼 onclick
	function register_onclick(){
		
		const regex = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|]+$/;
	 	const regex1 = /^[0-9|]+$/;
		let name = document.getElementById("name").value;
		let birthday = document.getElementById("birthday").value;
		let id = document.getElementById("id").value;
		let password = document.getElementById("password").value;
		
		
		if(name == ""){
			
			alert("이름은 필수 입력 사항입니다.");
			return;
		}
		
		
		if(!regex.test(name)){
			
			alert("올바른 이름을 입력해주세요.");
			return;
		}
		
		
	 	if(birthday == ""){
			
	 		alert("생년월일은 필수 입력 사항입니다.");
			return;
		}
		
	 	
		if(birthday.length !== 8){
			
			alert("생년월일은 예시)19930102 처럼 입력해주세요.");
			return;
		}
		
		
		if(!regex1.test(birthday)){
		
			alert("올바른 생년월일을 입력해주세요.");
			return;
		}
		
		
		if(id == ""){
			
			alert("아이디는 필수 입력 사항입니다.");
			return;
		}
		
		
		if(password == ""){
			
			alert("비밀번호는 필수 입력 사항입니다.");
			return;
		}
		
		
		if(!idChk){
			
			alert("아이디 중복체크를 해주세요.");
			return;
		}
		
		//회원가입 submit
		document.forms["signup-frm"].submit();
	}
	
	
	//AJAX로 아이디 중복체크
	function idDupChk(){
		
		let inputId = document.getElementById("id").value;
		
		// Creating Our XMLHttpRequest object 
	    var xhr = new XMLHttpRequest();
	
	    // Making our connection  
	    var url = '/signupform?id='+inputId;
	    xhr.open("GET", url,true);
	
	    // function execute after request is successful 
	    xhr.onreadystatechange = function () {
	        if (this.readyState == 4 && this.status == 200) {
	        	
	        	if(this.responseText == ""){
	        		
	        		idChk = true;
	        		document.getElementById("idDupYn").innerHTML = "사용가능한 아이디입니다.";
	        		document.getElementById("idDupYn").style.color = "#0000FF";
	        	}else{
	        		
	        		idChk = false;
	        		document.getElementById("idDupYn").innerHTML = "사용 불가능한 아이디입니다.";
	        		document.getElementById("idDupYn").style.color = "#FF0000";
	        	}
	        	
	        }
	        
	    }
	    // Sending our request 
	    xhr.send();
	}
	
	
	
	function idDupReset(){
		idChk = false;
		document.getElementById("idDupYn").innerHTML = "";
	}
	
	</script>
</head>

<body>
	<h1>Sign Up</h1>
	<form action="signupComplete" id="signup-frm" method="post">
		<input type="hidden" id="signupError" value="${signupSucYn}"/>
	
		<p> 이름 <input type="text" name="name" id="name" value="김정봉" /></p>
		<p> 생년월일 <input type="text" name="birthday" id="birthday" value="19920105"/></p>
		
		<p> 아이디 <input type="text" name="id" id="id" value="test" onkeydown="idDupReset()"/>
		<label for="id" id="idDupYn"></label><br>
		<input type="button" value="중복체크" onclick="idDupChk()"/></p>
		
		<p> 비밀번호 <input type="password" name="password" id="password" value="4567"/></p>
		<p><input type="button" value="회원가입" onclick="register_onclick()"/></p>
	</form>
	
</body>
</html>