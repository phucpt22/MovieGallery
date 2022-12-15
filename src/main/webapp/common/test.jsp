<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<c:forEach items="${videos}" var="video">
		<ol class="carousel-indicators">
			<li class="carousel-item">
			<img src="<c:url value='${video.poster}'/>">		
		</ol>
		</c:forEach>
	</div>
</body>
</html>