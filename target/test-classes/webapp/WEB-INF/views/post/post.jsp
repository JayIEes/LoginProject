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


<table class="post_table">
	<thead>
		<tr>
			<td colspan="5" style="height : 60px; text-align: center;">POST</td>
		</tr>
		<tr>
			<td style="width: 15px;">No.</td>
			<td style="width: 25px;">Title</td>
			<td style="width: 150px;">Content</td>
			<td style="width: 30px;">date</td>
			<td style="width: 15px;">Writer</td>
		</tr>
	</thead>
	<tbody>
		
		<c:choose>
			<c:when test="${fn:length(postList)!=0}">
				<c:forEach var="item" items="${postList}" varStatus="status">
				<tr>
					<td><c:out value="${status.count}" /></td>
					<td><c:out value="${fn:substring(item.title, 0, 5)}"/></td>
					<td style="text-align: left;"><c:out value="${fn:substring(item.content, 0, 10)}"/></td>
					<td><c:out value="${fn:substring(item.date, 0, 10)}"/></td>
					<td><c:out value="${item.id}"/></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">조회된 글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
		<tr>

		<tr style="border-bottom: 0px;">
			<td colspan="5" style="border-bottom: 0px;">
				<div class="paging_num_div"> 
					<div>&lt;&lt;</div>  
					<div class="paging_num">1 2 3 </div>
					<div>&gt;&gt;</div>
				</div>
			</td>
		</tr>
		<tr style="border-bottom: 0px;">
			<td colspan="5" style="border-bottom: 0px;">
				<div class="post_button"> 
					<input type="button" value ="게시글 등록" onclick="location.href='/postwrite'">
				</div>
			</td>
		</tr>
		<tr style="border-bottom: 0px;">
			<td colspan="5" style="border-bottom: 0px;">
				<div class="post_button"> 
					<input type="button" value ="로그아웃" onclick="signOut()">
				</div>
			</td>
		</tr>
	</tbody>
</table>
<script type="text/javascript">

var a = "${postList}";
a = new Array(a);
console.log(a);



if("${memberInfo}"== "" ){
	location.href='/form';
}

function signOut(){
	location.href='/signout';
}

</script>
</body>
</html>