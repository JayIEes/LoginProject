<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Post</title>
</head>
<style type="text/css">

.post_table {
	margin:-220px 0px 0px -350px;
	height : 300px;
	width : 700px;
	position:absolute;
    left:50%;
    top:50%;
	/* display: flex; */
	/* flex-direction: row;
	flex-wrap: nowrap; */
	/* justify-content: space-between; */
	border-top: 1px solid #444444;
    border-collapse: collapse;
}

tr, td{
	/* border: 1px solid black; */
	border-bottom: 1px solid #444444;
    padding: 5px;
    text-align: center;
}


.item2{
	width: 400px;
}

.paging_num_div{
	display: flex; 
	flex-direction: row; 
	justify-content: center; 
	padding-top: 15px;
}

.post_button{
	display: flex; 
	flex-direction: row-reverse; 
	/* padding-top: 15px; */
}

.paging_num{
	padding-left: 10px; 
	padding-right:10px;
}
</style>
<body>


<form action="/search" id="search_frm" method="get">
<table class="post_table">
	<thead>
			<tr>
				<td style="width: 80px;"><c:out value="${memberInfo.name}"/> 님</td>
				<td colspan="3" style="width: 150px;">
					<select name = "condition" id = "condition">
						<option value="writer">게시자</option>
						<option value="title">제목</option>
					</select>
					
					<input type="text" name="searchword" id="searchword">
					<input type="button" value="검색" name="search_btn" id="search_btn" onclick="search_btn_onclick()"> 
					<input type="button" value="새로등록하기" name="post_btn" id="post_btn" onclick="location.href='/postwrite'"> 
					<input type="button" value ="로그아웃" onclick="signout_onlick()">
				</td>
			</tr>
		<tr>
			<td style="width: 5px;">No.</td>
			<td style="width: 80px;">게시일자</td>
			<td style="width: 80px;">게시자</td>
			<td style="width: 300px;">제목</td>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(postList)!=0}">
				<c:forEach var="item" items="${postList}" varStatus="status">
					<tr style="height: 35px;" onclick="post_list_onclick(${item.post_seq})" onmouseover="post_list_onmouseover(this)" onmouseout="post_list_onmouseout(this)" >
						<td><c:out value="${status.count}" /></td>
						<td><c:out value="${fn:substring(item.date, 0, 10)}"/></td>
						<td><c:out value="${item.name}"/></td>
						<td style="text-align: left;"><c:out value="${item.title}"/></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>

		<tr style="border-bottom: 0px;">
			<td colspan="5" style="border-bottom: 0px;">
				<div class="paging_num_div"> 
					<div>
						<img src="../images/WEB-INF/images/next_btn.png" alt="이전" title="처음페이지"
							width="20px" height="20px"/>
					</div>
					<div>&lt;</div>  
					<div class="paging_num">1 2 3 </div>
					<div>&gt;&gt;</div>
				</div>
			</td>
		</tr>
		
	</tbody>
</table>
</form>
<script type="text/javascript">


	//로그인 정보가 없으면 로그인 화면으로
	if("${memberInfo}"== "" ){
		
		location.href='/';
	}
	
	
	//게시판 등록 완료 alert
	if("${postuploaded}" == "Y"){
	
		alert("게시글이 등록되었습니다.");
		<% session.removeAttribute("postuploaded");%>
	}
	
	
	//검색 후 selected 남게
	if("${condition}" != ""){
		var condition = document.getElementById("condition");
		
		if("${condition}"=="writer"){
			condition[0].selected = true;
		}else{
			condition[1].selected = true;
		}
	}
	
	
	//검색 후 검색어 input box에 남게
	if("${searchword}" != ""){
		
		document.getElementById("searchword").value = "${searchword}";
	}
	
	
	/*
	 * 로그아웃 버튼 클릭 시
	 */
	signout_onlick = function(){
		
		location.href = '/signout';
	}
	
	
	/*
	 * 게시글 한 행 클릭 시
	 */
	post_list_onclick = function(post_seq){
		var str =  '/post/'+post_seq;
		location.href = str;
	}
	
	
	/*
	 * 게시글 한 행 마우스 오버 시
	 */
	 post_list_onmouseover = function(target){
		var tbody = target.parentNode;
		var trs = tbody.getElementsByTagName('tr');
		
		var backColor = "#ffffff";
		var textColor = "#000000";
		var orgBColor = "#EBF7FF";
		var orgTColor = "#000000";
		
	    var no = "";
	    var no1 = "";
	 
	    for ( var i = 0; i < trs.length; i++ ) {
	        if ( trs[i] != target ) {
	            trs[i].style.backgroundColor = backColor;
	            trs[i].style.color = textColor;
	        } else {
	            trs[i].style.backgroundColor = orgBColor;
	            trs[i].style.color = orgTColor;
	            var td = trs[i].getElementsByTagName('td');
	            no = td[0].innerText;
	            no1 = td[1].innerText;
	        }
	    }
		
	}
	
	
	/*
	 * 게시글 한 행 마우스 아웃 시
	 */	
	 post_list_onmouseout = function(target){
			
		 var tbody = target.parentNode;
		var trs = tbody.getElementsByTagName('tr');
			
		var backColor = "#ffffff";
		var textColor = "#000000";
		var orgBColor = "#FFFFFF";
		var orgTColor = "#000000";
			
		var no = "";
		var no1 = "";
		 
		    for ( var i = 0; i < trs.length; i++ ) {
		        if ( trs[i] != target ) {
		            trs[i].style.backgroundColor = backColor;
		            trs[i].style.color = textColor;
		        } else {
		            trs[i].style.backgroundColor = orgBColor;
		            trs[i].style.color = orgTColor;
		            var td = trs[i].getElementsByTagName('td');
		            no = td[0].innerText;
		            no1 = td[1].innerText;
		        }
		    }		 
		 
	 }
	
	
	/*
	 * 검색 버튼 클릭시
	 */	 
	 search_btn_onclick = function(){
		 
		 let searchword = document.getElementById("searchword").value;
		 
		 if(searchword = ""){
			 
			 alert("검색어를 입력해주세요.");
			 return;
		 }
		 
		 document.forms["search_frm"].submit();
	 }
	

</script>
</body>
</html>