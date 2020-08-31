<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>네이버 예약하기</title>
	
	<!-- favicon 적용  -->
	<link rel="shortcut icon" href="img/favicon.ico" style="user-select: auto;">
	<link rel="icon" href="img/favicon.ico" style="user-select: auto;">
	
	<!-- css files -->
	<link rel="stylesheet" href="css/reservationStyle.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>
<header>
	<img src = "img/favicon.ico">
	<div>예약하기</div>
</header>

<!-- 프로모션 영역  -->
<div class = "promotion">
</div>

<!-- 카테고리 탭 영역  -->
<div class = "tabCategory">
	<!-- <div class = "categoryBtnBox"> -->
		<div class = "categoryBtn">전체 리스트</div>
		<div class = "categoryBtn">전시</div>
		<div class = "categoryBtn">뮤지컬</div>
		<div class = "categoryBtn">콘서트</div>
		<div class = "categoryBtn">클래식</div>
		<div class = "categoryBtn">연극</div>
	<!-- </div> -->
</div>
<br>

<!-- 총 개수 보이기 -->
<div id = "counts">
</div>
<br>

<!-- 전체 리스트 -->
<%-- <c:forEach items="${list}" var="product">
	<img alt = "poster" src = "${product.save_file_name}" ><br>
	${product.description}<br>
	${product.place_name}<br>
	${product.content}<br><br>
</c:forEach>
<br>

<c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
	<a href="main?start=${pageIndex}">${status.index +1}</a>&nbsp; &nbsp;
</c:forEach>
<br> --%>

<!-- 카테고리 별 보기 -->
<div class="productList">
</div>
<br>

<div class = "seeMore">
	<span>더보기</span>
</div>
<br>

<div class = "gotoTop">
	<a href="#">↑ TOP</a>
</div>

<!-- 템플릿 -->
<script id="promotionArea" type="promotion-template">
	<img class = "promotionImg" alt = "promotion" src = "{save_file_name}" >
</script>
	
<script id="tabcontent" type="product-template">
	<img alt = "poster" src = "{save_file_name}" > <br>
	<div class = "lettersInProduct">
		<h3>{description}</h3>
		<h4>{place_name}</h4> 
    	<div style="border-bottom: 1px solid #e7e8eb; width: 90%; margin: 0 auto;"></div>
    	<p style="color: gray;">{content}</p>
	</div>
</script>

<script id="countArea" type="count-template">
	바로 예매 가능한 행사가 <span style= "color: red">{count}개</span> 있습니다
</script>

</body>
	<script type="text/javascript" src="js/productJS.js?v=<%=System.currentTimeMillis() %>"></script>
	<script type="text/javascript" src="js/promotionJS.js?v=<%=System.currentTimeMillis() %>"></script>
</html>