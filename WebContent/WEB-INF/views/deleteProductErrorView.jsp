<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Xóa lỗi!</title>
 </head>
 
 <body>
 
    <jsp:include page="_background.jsp"></jsp:include>
    <jsp:include page="_accountStatus.jsp"></jsp:include>
    
    <h3>XÓA LỖI!</h3>
    
    <p style="color: red;">${errorString}</p>
    
    <br><br><br>
 </body>
</html>