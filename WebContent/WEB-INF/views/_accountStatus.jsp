<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
	<head>
		<style>
			.logined {
				float: right;
				margin-top: -135px;
				margin-right: 5px;
			}
			
			.register {
				float: right;
				margin-top: -118px;
				margin-right: 5px;
			}
			
			.login {
				float: right;
				margin-top: -118px;
				margin-right: 132px;
			}
			
			@font-face {
			    font-family: azuki;
			    src: url(font/UTMAzuki.woff);
			    font-weight: bold;
			}
			
			div {
			    font-family: azuki;
			    font-size: 25px;
			}
		</style>
	</head>
	
	<body>
		<c:choose>
			<c:when test="${loginedUser == null}">
				<form action="${pageContext.request.contextPath}/register">
				    <input class="register" type="image" src="img/register.png" width="120" height="38" alt="Submit" value="Register" />
				</form>
				
				<form action="${pageContext.request.contextPath}/login">
				    <input class="login" type="image" src="img/login.png" width="139" height="38" alt="Submit" value="Login" />
				</form>
			</c:when>
			
			<c:otherwise>
				<form class="logined">
				    <div>
					    <a href="${pageContext.request.contextPath}/userInfo" style="color:white; font-size: 35px">${loginedUser.userName}</a> 
					    <font size="20" color="white">/</font> 
					    
					    	<a href="${pageContext.request.contextPath}/doLogOut" style="color:white; font-size: 35px">Đăng xuất</a>
					    
				    </div>
				</form>
			</c:otherwise>
		</c:choose>
	</body>
</html>