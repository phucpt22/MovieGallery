<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ASM JAVA 4_SERVLET</title>
<%@ include file="/common/head.jsp"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<h2 class="col-6 tm-text-primary" style="color:#2475be">Danh sách các video:</h2>
			<div class="col-6 d-flex justify-content-end align-items-center">
				
			</div>
		</div>
		<div class="row tm-mb-90 tm-gallery">
			<c:forEach items="${videos}" var="video">
				<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
					<figure class="effect-ming tm-video-item">
						<img src="<c:url value='${video.poster}'/>"
							alt="Image" class="img-fluid">
						<figcaption
							class="d-flex align-items-center justify-content-center" name="click">
							<h2>View more</h2>
							<a
								href="<c:url value='/video?action=watching&id=${video.href}'/>">View
								more</a>
						</figcaption>
					</figure>
					<div>
						<h5 class="tm-text-secondary"
							style="white-space: nowrap; overflow: hidden;">
							${video.title}</h5>
					</div>
					<div class="d-flex justify-content-between tm-text-gray">
						<span class="tm-text-gray-light">${video.shares} <i
							class="fa-solid fa-share-from-square"></i></span> <span>${video.views}
							<i class="fa-solid fa-eye"></i>
						</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- row -->
		<div class="row tm-mb-90">
			<div
				class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
				<c:if test="${currentPage == 1}">
					<a href="javascript:void(0);"
					class="btn btn-primary tm-btn-prev mb-2 disabled" style="background-color:#2475be">Previous</a>
				</c:if>
				<c:if test="${currentPage > 1}">
					<a href="index?page=${currentPage -1}"
					class="btn btn-primary tm-btn-prev mb-2" style="">Previous</a>
				</c:if>
				<div class="tm-paging d-flex" >
					<c:forEach varStatus="i" begin="1" end="${maxPage}">
						<a href="index?page=${i.index}"class="active tm-paging-link ${currentPage == i.index ? 'active' : ''}">${i.index}</a>
					</c:forEach>
				</div>
				<c:if test="${currentPage == maxPage }">
					<a href="javascript:void(0);" class="btn btn-primary tm-btn-next disabled">Next
					Page</a>
				</c:if>
				<c:if test="${currentPage < maxPage }">
					<a href="index?page=${currentPage + 1}" class="btn btn-primary tm-btn-next">Next
					Page</a>
				</c:if>
			</div>
		</div>  
	</div>
	<!-- container-fluid, tm-container-content -->

	<%@ include file="/common/footer.jsp"%>
</body>
</html>