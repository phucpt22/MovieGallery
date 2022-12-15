<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${video.title}</title>
<%@ include file="/common/head.jsp"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<h2 class="col-12 tm-text-primary">Chi tiết video:
				${video.title}</h2>
		</div>
		<div class="row tm-mb-90">
			<div class="col-xl-8 col-lg-7 col-md-6 col-sm-12" name="videoDetail">
				<iframe id="tm-video" style="height: 100%"
					src="https://www.youtube.com/embed/${video.href}"></iframe>
			</div>
			<div class="col-xl-4 col-lg-5 col-md-6 col-sm-12"
				style="min-height: 500px !important">
				<div class="tm-bg-gray tm-video-details">
					<div class="mb-4">
						<h3 class="tm-text-gray-dark mb-3">Thông tin khác:</h3>
					</div>
					<p class="mb-4">${video.description}</p>
					<c:if test="${not empty sessionScope.currentUser}">
						<div class="text-center mb-5" name="likeUn">
							<button  id="likeOrUnLikeBtn" class="btn btn-primary tm-btn-big">
								<c:choose>
									<c:when test="${flagLikeBtn == true}">Unlike</c:when>
									<c:otherwise>Like</c:otherwise>
								</c:choose>
							</button>
						</div>
						<div class="text-center mb-5">
							<a href="#" class="btn btn-primary tm-btn-big"> Share</a>
						</div>
					</c:if>
					<div class="mb-4 d-flex flex-wrap">
						<div class="mr-4 mb-2">
							<span class="tm-text-gray-dark">Resolution: </span><span
								class="tm-text-primary">1920x1080</span>
						</div>
						<div class="mr-4 mb-2">
							<span class="tm-text-gray-dark">Format: </span><span
								class="tm-text-primary">MP4</span>
						</div>
						<div>
							<span class="tm-text-gray-dark">Duration: </span><span
								class="tm-text-primary">00:00:20</span>
						</div>
						<input id="videoIdHdn" type="hidden" value="${video.href}">
					</div>
				</div>
			</div>
		</div>
		<!-- row -->
		<!-- <div class="row tm-mb-90">
			<div
				class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
				<a href="javascript:void(0);"
					class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
				<div class="tm-paging d-flex">
					<a href="javascript:void(0);" class="active tm-paging-link">1</a> <a
						href="javascript:void(0);" class="tm-paging-link">2</a> <a
						href="javascript:void(0);" class="tm-paging-link">3</a> <a
						href="javascript:void(0);" class="tm-paging-link">4</a>
				</div>
				<a href="javascript:void(0);" class="btn btn-primary tm-btn-next">Next
					Page</a>
			</div>
		</div> -->
	</div>
	<!-- container-fluid, tm-container-content -->
	<script>
		$("#likeOrUnLikeBtn").click(function(){
			var videoId = $('#videoIdHdn').val();
			$.ajax({
				url: 'video?action=like&id=' + videoId
			}).done(function(data){
				var text = $('#likeOrUnLikeBtn').text();
				if(text.indexOf('Like') != -1){
					/* $("#likeOrUnLikeBtn").attr('value', 'Unlike'); */
					$('#likeOrUnLikeBtn').text('Unlike');
				}else{
					/* $("#likeOrUnLikeBtn").attr('value', 'Like'); */
					$('#likeOrUnLikeBtn').text('Like');
				}
			}).fail(function(error){
				alert('Loi!! Thu lai!');
			});
		});
	</script>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>