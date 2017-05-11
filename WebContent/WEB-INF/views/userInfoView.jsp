<%@page import="books23.beans.UserAccount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Trang cá nhân</title>
 </head>
 
 <style>
 	.box1 {
 		background-image: url(img/box1.png);
 		background-repeat: no-repeat;
 		background-size: 100% 100%;
 		width: 300px;
 		height: 550px;
 		margin-left: 150px;
 		margin-top: -50px;
 	}
 	
 	.box2 {
 		background-image: url(img/box1.png);
 		background-repeat: no-repeat;
 		background-size: 100% 100%;
 		width: 757px;
 		height: 550px;
 		margin-left: 450px;
 		margin-top: -550px;
 	}
 	
 	h3 {
 		margin-top: -35px;
 	}
 	
 	.point {
 		font-size: 18px;
 		margin-top: 120px;
 		margin-left: 10px;
 	}
 	
 	input {
 		font-size: 25px;
		font-family: azuki;
 	}
 </style>
 
 <body>
 
    <jsp:include page="_background.jsp"></jsp:include>
    <jsp:include page="_accountStatus.jsp"></jsp:include>
    
 	<div class="box1">
    	<center>
    	<br>
    		<form method="POST" action="avatarUpdate">
    		<table border="2">
    			<tr>
    				<td height="200" width="200" align=center><input type="image" src="${user.avatarUrl}" alt="submit" height="200" width="200"></td>
    			</tr>
    		</table>
    		</form>
    		<br>
    		<h3>${user.userName}</h3>
    		<br>
    		<div>
    			<center>
    				<% 
    					if (((UserAccount)session.getAttribute("loginedUser")).getUserName().equals("admin")) {
    				%>
    				<a href="${pageContext.request.contextPath}/productList" style="color: black; font-size: 25px"><u>Kho sách</u></a><br>
    				<a href="${pageContext.request.contextPath}/createProduct" style="color: black; font-size: 25px"><u>Thêm sách</u></a>
    				<%
    					} else {
    				%>
    				<a href="${pageContext.request.contextPath}/userInfo" style="color: black; font-size: 25px"><u>Thông tin cá nhân</u></a><br>
    				<a href="${pageContext.request.contextPath}/history" style="color: black; font-size: 25px"><u>Lịch sử mua hàng</u></a><br>
    				<div class="point" align=left>Điểm tích lũy: ${user.point}</div>
    				<%
    					}
    				%>
    			</center>
    		</div>
    	</center>
 	</div>
 	
 	<div class="box2">
 		<center>
 			<% 
    			if (!((UserAccount)session.getAttribute("loginedUser")).getUserName().equals("admin")) {
    		%>
 			<br>
			<table border="0">
				<tr>
					<td width="180">Họ và tên: </td>
					<td width="450">${user.fullName}</td>
				</tr>
				<tr>
					<td>Email: </td>
					<td>${user.email}</td>
				</tr>
				<tr>
					<td>Địa chỉ: </td>
					<td>${user.address}</td>
				</tr>
				<tr>
					<td>Số điện thoại: </td>
					<td>${user.phone}</td>
				</tr>
				<tr>
					<td>Ngân hàng: </td>
					<td>${user.bank}</td>
				</tr>
				<tr>
					<td>Thẻ tín dụng: </td>
					<td>${user.creditCard}</td>
				</tr>
			</table>
			<div style="margin-top:245px;">
				<a href="${pageContext.request.contextPath}/userUpdate" style="color: black; font-size:35px;"><u>Cập nhật</u></a>
				<a href="${pageContext.request.contextPath}/passwordUpdate" style="color: black; font-size:35px; padding-left:2cm;"><u>Đổi mật khẩu</u></a>
			</div>
			<%
				} 
			%>
		</center>
 	</div>
 	<br><br><br>
 </body>
</html>