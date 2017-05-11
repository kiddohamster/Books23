<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Kết quả tìm kiếm</title>
		<link rel="stylesheet" href="swiper/swiper.min.css">
	</head>
	
	<style type="text/css">
		table { page-break-inside:auto }
   		tr    { page-break-inside:avoid; page-break-after:auto }
   
		.box {
	 		background-image: url(img/box1.png);
	 		background-repeat: no-repeat;
	 		background-size: 100% 100%;
	 		width: auto;
	 		height: 500px;
	 		margin-top: -70px;
	 	}
	 	
	 	h3 {
	 		margin-top: 20px;
	 		margin-left: 20px;
	 	}
	 	
	    .swiper-container {
		    width: 100%;
		    height: 400px;
		}
		
		.swiper-slide {
			width: 200px;
		}
	</style>
	
	<body>
 
		<jsp:include page="_background.jsp"></jsp:include>
		<jsp:include page="_accountStatus.jsp"></jsp:include>
 		
 		<div class="box">
 			<h3><u>Kết quả tìm kiếm</u>: "<%=request.getParameter("s")%>"</h3>
 			<center>
 				<!-- Slider main container -->
					<div class="swiper-container">
					    <!-- Additional required wrapper -->
					    <div class="swiper-wrapper">
					        <!-- Slides -->
					        <c:forEach items="${searchResult}" var="book" >
					        <div class="swiper-slide">
					        	<table>
					        		<tr>
				        			<td align=center width=180 height=270>
				        			<form method="post" action="Book?code=${book.code}">
				        				<input type="image" src="${book.imageUrl}" alt="submit" width="180" height="270">
				        			</form>
				        			</td>
					        		</tr>
					        		<tr>
					        			<td align=center style="font-size:20px;" width="180"><a href="Book?code=${book.code}" style="color: black;">${book.name}</a></td>
					        		</tr>
					        	</table>
					        </div>
					        </c:forEach>
					    </div>
					    <!-- If we need pagination -->
					    <div class="swiper-pagination"></div>
					    
					    <!-- If we need navigation buttons -->
					    <div class="swiper-button-prev"></div>
					    <div class="swiper-button-next"></div>
					    
					    <!-- If we need scrollbar -->
					    <!-- <div class="swiper-scrollbar"></div> -->
					</div>
 			</center>
 		</div>
 		<script src="swiper/swiper.min.js"></script>
     	
     	<script>        
	  		var mySwiper = new Swiper ('.swiper-container', {
		    	// Optional parameters
		    	direction: 'horizontal',
		    	loop: false,
		    
		   	 	// If we need pagination
		    	pagination: '.swiper-pagination',
		    
		    	// Navigation arrows
		    	nextButton: '.swiper-button-next',
		    	prevButton: '.swiper-button-prev',
		    
		    	// And if we need scrollbar
		    	//scrollbar: '.swiper-scrollbar',
		    	scrollbarHide: true,
		    	slidesPerView: '5',
		    	slidesPerGroup: '5',
	  	        paginationClickable: true,
	  	        spaceBetween: -50,
	  	      	//grabCursor: true
	  		})
	  	</script>
	  	<br><br><br>
	</body>
</html>