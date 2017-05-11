<%@page import="books23.beans.UserAccount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
			<table border="1" cellpadding="5" cellspacing="1" >
	       		<tr>
					<th>Tên sách</th>
				    <th>Số lượng</th>
				    <th>Giá</th>
	       		</tr>
	       		<c:forEach items="${billList}" var="book" >
	          		<tr align="center">
		             	<td><a href="Book?code=${book.bookCode}">${book.bookName}</a></td>
		           		<td>${book.bookQuantity}</td>
		           		<td>${book.bookPrice}</td>
	       			</tr>
	   			</c:forEach>
	  		</table><br>
		</center>
		<p style="padding-left: 20px;">Địa chỉ nhận: ${address}</p>
		<p style="padding-left: 20px;">Tổng giá: ${total}</p>
		<p style="padding-left: 20px;">Điểm tích lũy cộng thêm: ${point}</p>
		<p style="padding-left: 20px;">Sử dụng điểm tích lũy: ${pointUse}</p>
 	</div>
 	<br><br><br>
 </body>
</html>