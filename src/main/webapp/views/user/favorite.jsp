<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ASM JAVA 4_SERVLET_Favorites</title>
<%@ include file="/common/head.jsp"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<h2 class="col-6 tm-text-primary">Danh sách các video yêu thích:</h2>
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
							class="d-flex align-items-center justify-content-center">
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

	</div>

	<%@ include file="/common/footer.jsp"%>
</body>
</html>