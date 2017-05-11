<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 	<head>
    	<meta charset="UTF-8">
    	<title>Kho sách</title>
 	</head>
 	<body>
 
    	<jsp:include page="_background.jsp"></jsp:include>
    	<jsp:include page="_accountStatus.jsp"></jsp:include>
 		<div style="margin-top: -70px; font-size:20px;">
	    	<h1>KHO SÁCH</h1>
 			<a href="createProduct" >Thêm sách</a>
 			<br>
			<p style="color: red;">${errorString}</p>
			<table border="1" cellpadding="5" cellspacing="1" >
	       		<tr>
	       			<th>Hình đại diện</th>
					<th>ID</th>
				    <th>Tên</th>
				    <th>Giá</th>
				    <th>Tác giả</th>
				    <th>Danh mục</th>
				    <th>Giới thiệu chung</th>
				    <th>Số lượng</th>
				    <th>Đánh giá (★)</th>
				    <th>Thời gian thêm</th>
				    <th>Chỉnh sửa</th>
				    <th>Xóa</th>
	       		</tr>
	       		<c:forEach items="${productList}" var="product" >
	          		<tr align="center">
		          		<td><img src="${product.imageUrl}" width="40" height="60"></td>
		             	<td>${product.code}</td>
		           		<td>${product.name}</td>
		           		<td>${product.price}</td>
		           		<td>${product.author}</td>
		           		<td>${product.category}</td>
		           		<td>${product.info}</td>
		           		<td>${product.quantity}</td>
		           		<td>${product.rating}</td>
		           		<td>${product.addTime}</td>
		           		<td>
		              		<a href="editProduct?code=${product.code}">Chỉnh sửa</a>
		           		</td>
		           		<td>
		              		<a href="deleteProduct?code=${product.code}">Xóa</a>
		           		</td>
	       			</tr>
	   			</c:forEach>
	  		</table>
 		</div>
 		<br><br><br>
 	</body>
</html>