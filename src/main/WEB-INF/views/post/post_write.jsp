<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Post</title>
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
	width: 500px; 
	margin-left: 20px; 
	outline: none;
	font-size:14px;
}

.content_textarea{
	border: 0px; 
	height: 280px; 
	width: 550px; 
	margin-left: 20px; 
	outline: none;
	font-size:13px;
	resize: none;
}
</style>
</head>
<body>
<form action="putuppost" id="post_frm" method="post">
<div class="container">
	<div id="post_letter_div" style="height: 80px; align-items: center;" class="div_shape_title">
		<label for="post_letter_div" >&lt; 게시글 등록 &gt;</label>
	</div>
	<div id="title_div" style="height: 40px; align-items: center;" class="div_shape">
		<label for="title_div" style="margin-left: 20px;" >제목  :</label>
		<input type="text"  maxlength="35" class="title_input" id="title" name="title">
	</div>
	<div style="height: 320px; align-items: center; justify-content: center;" class="div_shape">
		<textarea class="content_textarea" id="content" name="content"></textarea>
	</div>
	<div style="height: 40px; display : flex; flex-direction: row-reverse;">
		<input type="button" value="등록" style="height: 30px;" onclick="button_click()">
	</div>
</div>
</form>

<script type="text/javascript">

if("${memberInfo}"== "" ){
	location.href='/form';
}

function button_click() {
	document.forms["post_frm"].submit();
}
</script>
</body>
</html>