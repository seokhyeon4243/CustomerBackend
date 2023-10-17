<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사용자 관리</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function deleteUser(userId){
		var result = confirm(userId +" 사용자를 정말로 삭제하시겠습니까?");
		if(result) {
			location.href = "deleteUser.do/"+userId;
		}
	}
</script>

</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 목록</h2>
		<table class="table table-bordered table table-hover"> 
			<thead> 
				<tr> 
					<th>아이디</th> 
					<th>이름</th> 
					<th>이메일</th>
					<th>나이</th>
					<th>생성날짜</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr> 
		</thead> 
		<tbody> 
			<c:forEach var="customuser" items="${customUserList}">
				<tr>
					<td>
					 	<a href="getCustomUser.do?id=${customuser.id}">${customuser.id}</a>
					 </td>
					<td>${customuser.name}</td>
					<td>${customuser.email}</td>
					<td>${customuser.age}</td>
					<td>${customuser.entryDate}</td>
					<td>
					     <a href="updateUserForm.do?id=${user.userId}">수정</a>
					</td>
					<td><a href="#" onclick="deleteUser('${user.userId}')">삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<a href="insertUserForm.do">사용자 등록</a>
				</td>
			</tr>
		</tbody> 
	</table>
	</div>
</body>
</html>

































