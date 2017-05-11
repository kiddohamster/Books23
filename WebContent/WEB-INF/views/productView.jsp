<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.name}</title>
</head>

<style>
	.box {
 		background-image: url(img/box1.png);
 		background-repeat: no-repeat;
 		background-size: 100% 100%;
 		width: 250px;
 		height: 350px;
 		margin-top: -180px;
	 }
	 	
	 .box1 {
 		background-image: url(img/box1.png);
 		background-repeat: no-repeat;
 		background-size: 100% 100%;
 		width: 600px;
 		height: 500px;
	 }
	 
	 .box2 {
 		background-image: url(img/box1.png);
 		background-repeat: no-repeat;
 		background-size: 100% 100%;
 		width: 300px;
 		height: 520px;
	 }
	 
	input {
		font-family: azuki;
		font-size: 25px;
	}
</style>

<body>

	<jsp:include page="_background.jsp"></jsp:include>
	<jsp:include page="_accountStatus.jsp"></jsp:include>
	<p style="color: red;">${errorString}</p>
	<form method="POST" action="addToCart?code=${product.code}">
	<table border="0" style="margin-top:-50px;">
		<tr>
			<td width="320px" height="480px" align=center>
				<div class="box">
					<img src="${product.imageUrl}" width=200 height=300 style="padding-top:25px;">
				</div>
			</td>
			<td>
				<div class="box1" style="padding-top:25px;">
					<h2 align=center style="margin-top:-15px; font-size:40px;">${product.name}</h2>
				<center>
					<table border="0" style="margin-top:-100px;">
						<tr>
							<td style="font-size: 25px; font-style: italic;" width=160px>Tác giả:</td>
							<td style="font-size: 25px; color: #1c3295; font-weight: bold;">${product.author}</td>
							<br>
						</tr>
						<tr>
							<td height="20px"></td>
						</tr>
						<tr>
							<td style="font-size: 25px; font-style: italic;">Giá:</td>
							<td style="font-size: 25px; color: #1c3293; font-family: azuki;">${product.price}
								vnđ</td>
							<br>
						</tr>
						<tr>
							<td height="20px"></td>
						</tr>
						<tr>
							<td style="font-size: 25px; font-style: italic;">Thể loại:</td>
							<td style="font-size: 25px; color: #1c3293;">${product.category}</td>
							<br>
						</tr>
						<tr>
							<td height="20px"></td>
						</tr>
						<tr>
							<td style="font-size: 25px; font-style: italic;">Số lượng:</td>
							<td><input type="number" name="quantity"
								value="1" min="1" style="width:50px;">
						</tr>
					</table>
					<input type="image" src="img/add-to-cart.png" alt="submit" width="200px" height="50px" style="margin-top:90px;"/></a>
				</center>
				</div> <br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			</td>
			<td>
				<div class="box2" style="margin-top:-145px;">
					<table>
						<tr>
							<td style="padding-left:1cm;"><h3><u>Mô tả:</u></h3></td>
						</tr>
						<tr>
							<td style="font-size: 20px;">${product.info}</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	</form>

</body>
</html>