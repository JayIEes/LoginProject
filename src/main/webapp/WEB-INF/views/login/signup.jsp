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
	
		<p> 아이디 <input type="text" name="id" id="id" onkeydown="idDupReset()"/>
		<input type="button" value="중복검사" onclick="idDupChk()"/>
		<label for="id" id="idDupYn"></label><br></p>
		
		<p> 패스워드 <input type="password" name="password" id="password"/></p>
		
		<p> 이름 <input type="text" name="name" id="name" /></p>
		
		<p> 생년월일 <input type="text" name="birthday" id="birthday"/></p>
		
		<p> 성별<input type="radio" name="gender" id="male" value="M"/><label for="male">남성</label>
			<input type="radio" name="gender" id="female" value="F"/><label for="female">여성</label>
		</p>
		<p>
			<input type="button" value="회원가입" onclick="register_onclick()"/>
			<input type="button" value="로그인" onclick="location.href='/'"/>
		</p>
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
	
	
	/*
	 * 회원가입 버튼 클릭 시
	 */
	register_onclick = function(){
	
		let id = document.getElementById("id").value;
		let password = document.getElementById("password").value;
		let name = document.getElementById("name").value;
		let birthday = document.getElementById("birthday").value;
		let gender = "";
		
		if(document.querySelector('input[name="gender"]:checked')){
			gender = document.querySelector('input[name="gender"]:checked').value;
		}
		
		if(!idChk){
			
			alert("아이디 중복체크를 해주세요.");
			return;
		}
		

		// Creating Our XMLHttpRequest object 
	    var xhr = new XMLHttpRequest();
	    
		//POST 방식
		
	    // Making our connection
	    var url = '/signupprocess';
	    xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    let str = "id="+id+"&password="+password+"&name="+name+"&birthday="+birthday+"&gender="+gender+"";
	 
		xhr.send(str);
		
	    // function execute after request is successful 
	    xhr.onreadystatechange = function () {
	        if (this.readyState == 4 && this.status == 200) {
	        	
	        	if(this.response == "Y"){ //회원가입 성공
	        		
	        		location.href="/signupcomplete";
	        	}else if(this.response == "N"){
	        		
	        		alert("회원가입에 실패했습니다.");
	        		location.href="/signup";
	        	}else{
	        		
	        		alert(this.response);
	        		return;
	        	}//else
	        	
	        }
	        
	    }//xhr.onreadystatechange
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
	
	
</script>
</body>
</html>