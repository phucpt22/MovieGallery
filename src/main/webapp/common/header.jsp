<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/common/head.jsp"%>
</head>
<body>
	<div id="loader-wrapper">
		<div id="loader"></div>

		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>

	</div>
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbar-brand" href="<c:url value='index'/>"> <i
				class="fa-solid fa-camera-movie"></i> ASM_JAVA4
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
					<c:choose>
						<c:when test="${not empty sessionScope.currentUser}">
							<li class="nav-item"><a style="color:#2475be" class="nav-link nav-link-1 active"
								aria-current="page" href="index">Chào!
									${sessionScope.currentUser.username}</a></li>
							<li class="nav-item"><a class="nav-link nav-link-1"
								href="favorites">Bộ sưu tập</a></li>
							<li class="nav-item"><a name="History" class="nav-link nav-link-2"
								href="history">Lịch sử</a></li>
							<li class="nav-item"><a class="nav-link nav-link-3"
								href="logout">Đăng xuất</a></li>
							<li class="nav-item"><a class="nav-link nav-link-3"
								href="admin">Thống kê</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link nav-link-2"
								href="login">Đăng nhập</a></li>
							<li class="nav-item"><a class="nav-link nav-link-3"
								href="register">Đăng ký</a></li>
							<li class="nav-item"><a class="nav-link nav-link-4"
								href="forgotpass">Quên mật khẩu</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="tm-hero d-flex justify-content-center align-items-center" style="height: 500px" data-parallax="scroll" 
	data-image-src="<c:url value='/templates/user/img/banner.jpg'/>">
       
    </div>
</body>
</html>