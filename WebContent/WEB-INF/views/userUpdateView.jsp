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
    		<h3>${loginedUser.userName}</h3>
    		<br>
    		<div>
    			<center>
    				<a href="${pageContext.request.contextPath}/userInfo" style="color: black; font-size: 25px"><u>Thông tin cá nhân</u></a><br>
    				<a href="${pageContext.request.contextPath}/userInfo" style="color: black; font-size: 25px"><u>Lịch sử mua hàng</u></a><br>
    				<div class="point" align=left>Điểm tích lũy: ${loginedUser.point}</div>
    			</center>
    		</div>
    	</center>
 	</div>
 	
 	<div class="box2">
 		<center>
 			<form method="POST" action="doUserUpdate">
				<table border="0">
				<br>
					<tr>
						<td width="180">Họ và tên (*): </td>
						<td width="450"><input type="text" name="fullName" value= "${user.fullName}" size="35"/></td>
					</tr>
					<tr>
						<td>Email (*): </td>
						<td><input type="email" name="email" value= "${user.email}" size="35"/></td>
					</tr>
					<tr>
						<td>Địa chỉ (*): </td>
						<td><input type="text" name="address" value= "${user.address}" size="35"/></td>
					</tr>
					<tr>
						<td>Số điện thoại (*): </td>
						<td><input type='tel' pattern='\d{10,11}' name="phone" value= "${user.phone}" size="35"/></td>
					</tr>
					<tr>
						<td>Ngân hàng: </td>
						<td><input type="text" name="bank" value= "${user.bank}" size="35"/></td>
					</tr>
					<tr>
						<td>Thẻ tín dụng: </td>
						<td><input type="text" pattern='\d{10,}' name="creditCard" value= "${user.creditCard}" size="35"/></td>
					</tr>
				</table>
				<p style="color: red;">${errorString}</p>
				<div style="padding-top:1cm;">
					<input type="submit" value="Xác nhận" />
		            <a href="${pageContext.request.contextPath}/userInfo">Hủy</a>
				</div>
			</form>
		</center>
 	</div>
 	<br><br><br>
 </body>
</html>