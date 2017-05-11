<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
  	<head>
     	<meta charset="UTF-8">
     	<title>Giỏ hàng</title>
  	</head>
  	
  	<style>
  		input[type=range] {
		    /*removes default webkit styles*/
		    -webkit-appearance: none;
		    
		    /*fix for FF unable to apply focus style bug */
		    border: 1px solid black;
		    
		    /*required for proper track sizing in FF*/
		    width: 200px;
		}
		input[type=range]::-webkit-slider-runnable-track {
		    width: 200px;
		    height: 5px;
		    background: black;
		    border: none;
		    border-radius: 3px;
		}
		input[type=range]::-webkit-slider-thumb {
		    -webkit-appearance: none;
		    border: none;
		    height: 16px;
		    width: 16px;
		    border-radius: 50%;
		    background: goldenrod;
		    margin-top: -4px;
		}
		input[type=range]:focus {
		    outline: none;
		}
		input[type=range]:focus::-webkit-slider-runnable-track {
		    background: #ccc;
		}
		
		input[type=range]::-moz-range-track {
		    width: 200px;
		    height: 5px;
		    background: black;
		    border: none;
		    border-radius: 3px;
		}
		input[type=range]::-moz-range-thumb {
		    border: none;
		    height: 16px;
		    width: 16px;
		    border-radius: 50%;
		    background: goldenrod;
		}
		
		/*hide the outline behind the border*/
		input[type=range]:-moz-focusring{
		    outline: 1px solid white;
		    outline-offset: -1px;
		}
		
		input[type=range]::-ms-track {
		    width: 200px;
		    height: 5px;
		    
		    /*remove bg colour from the track, we'll use ms-fill-lower and ms-fill-upper instead */
		    background: transparent;
		    
		    /*leave room for the larger thumb to overflow with a transparent border */
		    border-color: transparent;
		    border-width: 6px 0;
		
		    /*remove default tick marks*/
		    color: transparent;
		}
		input[type=range]::-ms-fill-lower {
		    background: #777;
		    border-radius: 10px;
		}
		input[type=range]::-ms-fill-upper {
		    background: black;
		    border-radius: 10px;
		}
		input[type=range]::-ms-thumb {
		    border: none;
		    height: 16px;
		    width: 16px;
		    border-radius: 50%;
		    background: goldenrod;
		}
		input[type=range]:focus::-ms-fill-lower {
		    background: #888;
		}
		input[type=range]:focus::-ms-fill-upper {
		    background: #ccc;
		}
  		
  		.box {
	 		background-image: url(img/box1.png);
	 		background-repeat: no-repeat;
	 		background-size: 100% 100%;
	 		width: 300px;
	 		height: 400px;
	 	}
	 	
	 	input[type=submit]{
		    font-family: azuki;
		    font-size: 40px;
		}
  	</style>
  	
  	<body>
 
     	<jsp:include page="_background.jsp"></jsp:include>
     	<jsp:include page="_accountStatus.jsp"></jsp:include>
     	<p style="color: red;">${errorString}</p>
     	<form method="POST" action="pay">
     	<table border="0">
     	<tr>
     		<td align=center>
     		
	     		<div class="box">
	     			<h2><u>TỔNG GIÁ</u></h2>
	     			<h3>${total}<br>VND</h3>
	     			<h5>Sử dụng điểm tích lũy: </h5>
	     			<input id="slider" name="pointUse" type ="range" min ="0" max="${pointCapable}" step ="1000" value ="0" onchange="printValue('slider','rangeValue')"/> 
	     			<input id="rangeValue" size="3" type="text" value="0" readonly/>
	     			<br><br>
	     			<input type="submit" value="Thanh toán">
	     		</div>
     		
     		</td>
     		<td align=center width=100% height=100%>
			<table border="1" cellpadding="5" cellspacing="1">
	       		<tr>
	       			<th>Hình đại diện</th>
				    <th width=400>Tên</th>
				    <th>Số lượng</th>
				    <th>Giá 1 cuốn (VND)</th>
				    <th>Xóa</th>
	       		</tr>
	       		<c:forEach items="${cartList}" var="cartBook" >
	          		<tr align="center">
		          		<td><img src="${cartBook.bookImageUrl}" width="80" height="120"></td>
		           		<td>${cartBook.bookName}</td>
		           		<td>${cartBook.bookQuantity}</td>
		           		<td>${cartBook.bookPrice}</td>
		           		<td>
		              		<a href="deleteFromCart?code=${cartBook.bookCode}">Xóa</a>
		           		</td>
	       			</tr>
	   			</c:forEach>
	  		</table>
	  		</td>
  		</tr>
  		</table>
  		</form>
  		<script>
	  		function printValue(sliderID, textbox) {
	  	        var x = document.getElementById(textbox);
	  	        var y = document.getElementById(sliderID);
	  	        x.value = y.value;
	  	    }
  		</script>
		<br><br><br>
  	</body>
</html>