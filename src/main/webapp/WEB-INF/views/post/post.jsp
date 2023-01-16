<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<td colspan="3" style="height : 60px; text-align: center;">POST</td>
		</tr>
		<tr>
			<td style="width: 20px;">Title</td>
			<td style="width: 200px;">Content</td>
			<td style="width: 20px;">Writer</td>
		</tr>
	</thead>
	<tbody>
			<tr>
			<td>testtetsetets</td>
<!-- 			<td style="height: 10px;">testtetsetets</td> -->
			<td>testtetsetets</td>
			<td>testtetsetets</td>
		</tr>
		<tr>
			<td>testtetsetets</td>
			<td>testtetsetets</td>
			<td>testtetsetets</td>
		</tr>

		<tr style="border-bottom: 0px;">
			<td colspan="3" style="border-bottom: 0px;">
				<div class="paging_num_div"> 
					<div>&lt;&lt;</div>  
					<div class="paging_num">1 2 3 </div>
					<div>&gt;&gt;</div>
				</div>
			</td>
		</tr>
		<tr style="border-bottom: 0px;">
			<td colspan="3" style="border-bottom: 0px;">
				<div class="post_button"> 
					<input type="button" value ="게시글 등록" onclick="location.href='/postwrite'">
				</div>
			</td>
		</tr>
	</tbody>
</table>
<script type="text/javascript">
/* let postCount = 10;
let totalCount = 0; */
/* let page = 5;
let countPage = 10;
 
let startPage = ((page - 1) / countPage) * countPage + 1;
 
let endPage = startPage + countPage - 1; */

</script>
</body>
</html>