<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

</head>

<body>
	<h1>회원가입</h1>
	<form action="signupprocess" id="signup_frm" method="post">
		<%-- <input type="hidden" id="signupError" value="${signupSucYn}"/> --%>
	
		<p> 아이디 <input type="text" name="id" id="id" onkeydown="idDupReset()"/>
		<input type="button" value="중복검사" onclick="idDupChk()"/>
		<label for="id" id="idDupYn"></label><br></p>
		
		<p> 패스워드 <input type="password" name="password" id="password"/></p>
		
		<p> 이름 <input type="text" name="name" id="name" /></p>
		
		<p> 생년월일 <input type="text" name="birthday" id="birthday"/></p>
		
		<p> 성별<input type="radio" name="gender" id="male" value="M"/><label for="male">남성</label>
		<input type="radio" name="gender" id="female" value="F"/><label for="female">여성</label>
		</p>
		<p><input type="button" value="회원가입" onclick="register_onclick()"/></p>
	</form>
		<script type="text/javascript">
	
	/************************************************************************
	 * 설명 : 회원가입 폼
	 * 작성자 : 서지숙
	 * 작성일 : 2023-01-05
	 * 변경일 : 
	************************************************************************/
	
	//아이디 중복체크 초기화
	let idChk = false;
	//idDupReset();
	
	/*
	 * 회원가입 서버체크 후 중복체크 여부 리셋
	 */
 	window.onpageshow = function(event){
			//alert(window.performance.navigation.type);
/* 		if(event.persisted){
			console.log("뒤로가기");
			idDupReset();
		}else{
			console.log("새로고침");
			idDupReset();
		} */
 		idDupReset();
	}
	
	if("${signupSucYn}"=="Y"){
		
		alert("정상적으로 처리되었습니다.");
		location.href="/";
		
	}
	/*
	 * 회원가입 서버체크 메세지
	 */
	if("${msg}" !== ""){
		alert("${msg}");
		history.back();
	}	
	
	
	/*
	 * 회원가입 버튼 클릭 시
	 */
	 register_onclick = function(){
		/* const regex = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|]+$/;
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
		} */
		
		if(!idChk){
			
			alert("아이디 중복체크를 해주세요.");
			return;
		}
		
		//회원가입 submit
		document.forms["signup_frm"].submit();
	};
	
	
	/*
	 * 아이디 중복체크
	 */
	 idDupChk = function(){
		
		let inputId = document.getElementById("id").value;
		
		if(inputId == ""){
			
			alert("아이디를 입력해주세요.");
			return;
		}
		
		if(inputId.length  < 8 ){
			
			alert("아이디는 8자리 이상으로 입력해주세요.");
			return;
		}
		
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
	        		document.getElementById("idDupYn").innerHTML = "   사용 가능한 아이디입니다.";
	        		document.getElementById("idDupYn").style.color = "#0000FF";
	        	}else{
	        		
	        		idChk = false;
	        		document.getElementById("idDupYn").innerHTML = "   이미 사용된 아이디입니다.";
	        		document.getElementById("idDupYn").style.color = "#FF0000";
	        	}
	        	
	        }
	        
	    }
	    // Sending our request 
	    xhr.send();
	};
	
	
	
	/*
	 * 아이디 변경 시 중복체크 여부 리셋
	 */
	 idDupReset = function(){
		idChk = false;
		document.getElementById("idDupYn").innerHTML = "";
	};
	
	//아이디 중복체크 초기화
	//let idChk = false;
	
	</script>
</body>
</html>