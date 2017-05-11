<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa</title>
 </head>
 
 <style>
 	input {
 		font-family: azuki;
 		font-size: 25px;
 	}
 </style>
 
 <body>
 
    <jsp:include page="_background.jsp"></jsp:include>
    <jsp:include page="_accountStatus.jsp"></jsp:include>
 	<div style="margin-top: -70px;">
	    <h2>CHỈNH SỬA</h2>
	 
	    <p style="color: red;">${errorString}</p>
	 
	    <c:if test="${not empty product}">
	       <form method="POST" action="doEditProduct">
	          <input type="hidden" name="code" value="${product.code}" />
	          <table border="0">
	             <tr>
	                <td>ID: </td>
	                <td style="color:red;">${product.code}</td>
	             </tr>
	             <tr>
	                <td>Tên: </td>
	                <td><input type="text" name="name" value="${product.name}" size="50" /></td>
	             </tr>
	             <tr>
	                <td>Giá: </td>
	                <td><input type="text" name="price" value="${product.price}" size="50" /></td>
	             </tr>
	             <tr>
	                <td>Tác giả: </td>
	                <td><input type="text" name="author" value="${product.author}" size="50" /></td>
	             </tr>
	             <tr>
	                <td>Danh mục: </td>
	                <td><input type="text" name="category" value="${product.category}" size="50" /></td>
	             </tr>
	             <tr>
	                <td>Giới thiệu chung: </td>
	                <td><textarea name="info" cols="40" rows="5">${product.info}</textarea></td>
	             </tr>
	             <tr>
	                <td>Số lượng: </td>
	                <td><input type="text" name="quantity" value="${product.quantity}" size="50" /></td>
	             </tr>
	             <tr>
	          	 	<td>Link hình đại diện: </td>
	          	 	<td><input type="text" name="imageUrl" value="${product.imageUrl}" size="50" /></td>
	          	 </tr>
	             <tr>
	                <td colspan = "2">
	                <br>
	                    <input type="submit" value="Xác nhận" />
	                    <a href="${pageContext.request.contextPath}/productList">Hủy</a>
	                </td>
	             </tr>
	          </table>
	       </form>
	    </c:if>
 	</div>
 	<br><br><br>
 </body>
</html>