<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Post</title>
</head>
<style type="text/css">

.container{
	margin: -210px 0px 0px -300px;
	height : 420px;
	width : 600px;
	position:absolute;
  	left:50%;
    top:50%;
    display: flex;
	flex-direction: column;
	flex-wrap: nowrap;
	align-items: stretch;
/* border: 1px solid black; */
	/* display: inline-flex; */
}

.div_shape{
	display : flex;
	border: 1px solid #D5D5D5; 
	border-radius: 10px; 
	margin-bottom: 10px;
}

.div_shape_title{
	display : flex;
	flex-direction: row; 
	justify-content:center;
	align-content: center;
	align-items: center;
	font-size: 15pt;
}

.title_input{
	border: 0px; 
	height: 30px; 
	width: 400px; 
	margin-left: 20px; 
	outline: none;
	font-size:14px;
}

.content_textarea{
	border: 0px; 
	height: 280px; 
	width: 550px; 
	outline: none;
	font-size:14px;
	resize: none;
}
</style>
<body>

<div class="container">



<c:choose>
	<c:when test="${postDetail != null}">
		
		<form action="/postmodify" id="post_modify_frm" method="post">
		
			<input type="hidden" name="post_seq" value="${postDetail.post_seq}"/>
		
			<div id="post_date_div" style="height: 40px; align-items: center;" class="div_shape">
				<label for="post_date_div" style="margin-left: 20px; width: 100px; border-right: 1px solid black" >κ²μμΌμ</label>
				<input type="text" readonly="readonly" class="title_input" id="post_date" name="date" value="${fn:substring(postDetail.date, 0, 10)}" />
			</div>
			
			
			<div id="post_writer_div" style="height: 40px; align-items: center;" class="div_shape">
				<label for="post_writer_div" style="margin-left: 20px; width: 100px;  border-right: 1px solid black" > κ²μμ</label>
				<input type="text" class="title_input" readonly="readonly" id="name" name="name" value="${postDetail.name}" />
			</div>
			
			
			<div id="title_div" style="height: 40px; align-items: center;" class="div_shape">
				<label for="title_div" style="margin-left: 20px;  width: 100px; border-right: 1px solid black;" >μ λͺ©</label>
				<input type="text" class="title_input" id="title" name="title" value="${postDetail.title}" >
			</div>
			
			
			<div style="height: 320px; align-items: center; justify-content: center;" class="div_shape">
				<textarea class="content_textarea" id="content" name="content"><c:out value="${postDetail.content}"/></textarea>
			</div>
			
			
			<div style="height: 40px; display : flex; flex-direction: row-reverse;">
				<input type="button" id="save_btn" value="μ μ₯νκΈ°" style="height: 30px; margin-left: 5px;" onclick="save_btn_onclick()">
				<input type="button" value="λͺ©λ‘" style="height: 30px;" onclick="location.href='/postlist'">
			</div>
		</form>
	</c:when>
	
	<c:otherwise>
		<form action="/putuppost" id="post_write_frm" method="post">
				<div id="post_letter_div" style="height: 80px; align-items: center;" class="div_shape_title">
					<label for="post_letter_div" >&lt;κ²μν λ±λ‘ &gt;</label>
				</div>
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy-MM-DD"/></c:set> 
				
				
				<div id="post_date_div" style="height: 40px; align-items: center;" class="div_shape">
					<label for="post_date_div" style="margin-left: 20px; width: 100px; border-right: 1px solid black" >κ²μμΌμ</label>
					<input type="text" readonly="readonly" class="title_input" id="post_date" name="post_date" value="<c:out value="${sysYear}"/>"/>
				</div>
				
				
				<div id="post_writer_div" style="height: 40px; align-items: center;" class="div_shape">
					<label for="post_writer_div" style="margin-left: 20px; width: 100px;  border-right: 1px solid black" > κ²μμ</label>
					<input type="text" class="title_input" readonly="readonly" id="name" name="name" value="${memberInfo.name}"/>
				</div>
				
				
				<div id="title_div" style="height: 40px; align-items: center;" class="div_shape">
					<label for="title_div" style="margin-left: 20px;  width: 100px; border-right: 1px solid black;" >μ λͺ©</label>
					<input type="text" maxlength="30" class="title_input" id="title" name="title" >
				</div>
				
				
				<div style="height: 320px; align-items: center; justify-content: center;" class="div_shape">
					<textarea class="content_textarea" id="content" name="content"></textarea>
				</div>
				
				
				<div style="height: 40px; display : flex; flex-direction: row-reverse;">
					<input type="button" value="μ μ₯νκΈ°" style="height: 30px; margin-left: 5px;" onclick="new_post_btn_onclick()">
					<input type="button" value="λͺ©λ‘" style="height: 30px;" onclick="location.href='/postlist'">
				</div>
		</form>
	</c:otherwise>
</c:choose>

</div>


<script type="text/javascript">
	
	//λ‘κ·ΈμΈ μ λ³΄κ° μμΌλ©΄ λ‘κ·ΈμΈ νλ©΄μΌλ‘
	if("${memberInfo}"== "" ){
		
		location.href='/';
	}
	
	//μμ  ν¬μ€νΈ alert
	if("${modifyYn}" == "Y"){
		
		alert("κ²μκΈ μμ μ΄ μλ£λμμ΅λλ€.");
		<% session.removeAttribute("modifyYn");%>
	}
	
	//μμ±μκ° λ‘κ·ΈμΈν κ³μ κ³Ό λ€λ₯΄λ©΄
	if( "${postDetail.id}" !== "" && "${postDetail.id}" !== "${memberInfo.id}") {
	
		document.getElementById('title').readOnly = true;
		document.getElementById('content').readOnly = true;
		document.getElementById('save_btn').style.display = 'none'; 
	}

	
	save_btn_onclick = function(){
		
		document.forms["post_modify_frm"].submit();
	}
	
	
	if("${memberInfo}"== "" ){
		location.href='/';
	}

	function new_post_btn_onclick() {
		
		let title = document.getElementById("title").value;
		let content = document.getElementById("content").value;
		
		if(title == ""){
			alert("μ λͺ©μ νμΈνμΈμ.");
			return;
		}
		
		if(content == ""){
			alert("λ΄μ©μ νμΈνμΈμ.");
			return;
		}
		
		document.forms["post_write_frm"].submit();
	}
</script>
</body>
</html>