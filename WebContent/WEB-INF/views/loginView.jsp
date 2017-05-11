<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
 </head>
 
 <style>
 	.box {
 		background-image: url(img/box1.png);
 		background-repeat: no-repeat;
 		background-size: 100%;
 		width: 757px;
 		height: 500px;
 		margin-left: 300px;
 		margin-top: -50px;
 	}
 	
 	input[type=submit]{
	    font-family: azuki;
	    font-size: 25px;
	}
 </style>
 
 <body>
 
    <jsp:include page="_background.jsp"></jsp:include>
    <jsp:include page="_accountStatus.jsp"></jsp:include>
    
    <div class="box">
    	<center>
	    	<br><br>
		    <h1>Đăng nhập</h1>
		 
		    <p style="color: red;">${errorString}</p>
		 
		    <form method="POST" action="doLogin">
		       <table border="0">
		          <tr>
		             <td width="130">Tài khoản:</td>
		             <td><input type="text" name="userName" value= "${user.userName}" size="35"/> </td>
		          </tr>
		          <tr>
		             <td>Mật khẩu:</td>
		             <td><input type="password" name="password" value= "${user.password}" size="35"/> </td>
		          </tr>
		       </table>
		       <br>
		       <input type="submit" value= "Xác nhận" />
	           <a href="${pageContext.request.contextPath}/">Hủy</a>
		    </form>
	    </center>
 	</div>
 	<br><br><br>
 </body>
</html>