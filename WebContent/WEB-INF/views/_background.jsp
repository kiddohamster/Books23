<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css">
	html, body {
		width: auto;
		height: auto;
	}
	
	.home a {
	    display: block;
	    float: left;
	    background-image: url(img/book.png);
	    background-repeat: no-repeat;
	    background-size: 100%;
	    width: 376px;
	  	height: 230px;
	}
	
	.cart a {
		display: block;
		float: right;
	    background-image: url(img/cart.png);
	    background-repeat: no-repeat;
	    background-size: 120px 120px;
	    width: 120px;
	  	height: 120px;
	  	margin-top: -8px;
	  	margin-right: -8px;
	}
	
	body {
		background-image: url(img/cat.png), url(img/bar.png), url(img/head1.png);
		background-position: top right, 0px 230px, center top;
		background-color: , , white;
		background-attachment: , , fixed;
		background-repeat: no-repeat, no-repeat, no-repeat;
		background-size: 50% auto, 100% auto, 100% auto;
	}
	
	.searchform {
		float: initial;
		margin-top: 8px;
		width: 350px;
		height: 350px;
	}
	.searchform input[type=text] {
		font-size: 30px;
		font-family: azuki;
		width:350px;
		height:36px;
		border:0px;
		background:#ffffff;
		float:left;
		margin:0px;padding:3px;
	}
	
	.searchsubmit {
		float: left;
		margin-top: -40px;
		margin-left: 360px;
	}
	
</style>
<div class="home">
    <a href="${pageContext.request.contextPath}/"></a>
</div>

<div class="cart">
    <a href="${pageContext.request.contextPath}/cart"></a>
</div>

<div id="search" style="width:auto;">
	<form class="searchform" method="GET" action="search">
		<input class="searchinput" type="text" name="s" value="" />
		<input class="searchsubmit" type="image" src="img/searchbutton.png"  width="148" height="38" alt="Submit" value="Search" />
	</form>
</div>


