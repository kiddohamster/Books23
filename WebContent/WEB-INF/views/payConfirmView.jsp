<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Xác nhận đơn hàng</title>
 </head>
 
 <body>
 
    <jsp:include page="_background.jsp"></jsp:include>
    <jsp:include page="_accountStatus.jsp"></jsp:include>
    <div style="margin-top:-50px;">
    <p style="color: red;">${errorString}</p>
    	<h2>${confirm}</h2>
    	<p>Tổng giá đơn hàng: ${total} VND</p>
    	<p>Địa chỉ nhận: ${loginedUser.address}</p>
    	<p>Số điện thoại: ${loginedUser.phone}</p>
    	<p>Điểm tích lũy cộng thêm: ${point}</p>
    	<p>Sử dụng điểm tích lũy: ${pointUse}</p>
    </div>
    <br><br><br>
 </body>
</html>