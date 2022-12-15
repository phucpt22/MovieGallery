<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | DataTables</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<c:url value='templates/admin/plugins/fontawesome-free/css/all.min.css'/>">
<!-- DataTables -->
<link rel="stylesheet"
	href="<c:url value='templates/admin/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='templates/admin/plugins/datatables-responsive/css/responsive.bootstrap4.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='templates/admin/plugins/datatables-buttons/css/buttons.bootstrap4.min.css'/>">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value='templates/admin/dist/css/adminlte.min.css'/>">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->


		<!-- Right navbar links -->

		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="admin" class="brand-link"> <img
				src="<c:url value='templates/admin/img/logo.png'/>"
				alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
				style="opacity: .8"> <span
				class="brand-text font-weight-light">Admin PTP</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img src="<c:url value='templates/admin/img/user.png'/>"
							class="img-circle elevation-2" alt="User Image">
					</div>
					<div class="info">
						<a href="#" class="d-block">${sessionScope.currentUser.username}</a>
					</div>
				</div>

				<!-- SidebarSearch Form -->
				<div class="form-inline">
					<div class="input-group" data-widget="sidebar-search">
						<input class="form-control form-control-sidebar" type="search"
							placeholder="Search" aria-label="Search">
						<div class="input-group-append">
							<button class="btn btn-sidebar">
								<i class="fas fa-search fa-fw"></i>
							</button>
						</div>
					</div>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<li class="nav-item"><a href="<c:url value='admin'/>"
							class="nav-link"> <i class="nav-icon fas fa-tachometer-alt"></i>
								<p>
									Home <i class="right fas fa-angle-left"></i>
								</p>
						</a></li>
						<li class="nav-item menu-open"><a href="#"
							class="nav-link active"> <i
								class="nav-icon fas fa-tachometer-alt"></i>
								<p>
									Video <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a
									href="<c:url value='admin/video?action=view'/>"
									class="nav-link active"> <i class="far fa-circle nav-icon"></i>
										<p>Overview</p>
								</a></li>
								<li class="nav-item"><a
									href="<c:url value='admin/video?action=add'/>" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>New or Edit</p>
								</a></li>
							</ul></li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>DataTables</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">DataTables</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">Danh sách video:</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table id="example1" class="table table-bordered table-hover">
										<thead>
											<tr>
												<!-- <th>Id</th> -->
												<th>Title</th>
												<th>Description</th>
												<th>Link</th>
												<th>Poster</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${videos}" var="item">
												<tr>
													<%-- <td>${item.id}</td> --%>
													<td>${item.title}</td>
													<td>${item.description}</td>
													<td> <a href="<c:url value='video?action=watching&id=${item.href}'/>">${item.href}</a></td>
													<td>
														<img alt="" src="${item.poster}" width="150px" height="150px">
													</td>
													<td>
													<button type="button" class="btn btn-block btn-warning">Edit</button>
													<button type="button" class="btn btn-block btn-danger">Delete</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- /.card-body -->
				</div>
				<!-- /.card -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 10.10.10.10
			</div>
			<strong>Copyright &copy; 2022-2022 <a
				href="https://adminlte.io">Admin PTP</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script
		src="<c:url value='templates/admin/plugins/jquery/jquery.min.js'/>"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<c:url value='templates/admin/plugins/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- DataTables  & Plugins -->
	<script
		src="<c:url value='templates/admin/plugins/datatables/jquery.dataTables.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/datatables-responsive/js/dataTables.responsive.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/datatables-responsive/js/responsive.bootstrap4.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/datatables-buttons/js/dataTables.buttons.min.j'/>s"></script>
	<script
		src="<c:url value='templates/admin/plugins/datatables-buttons/js/buttons.bootstrap4.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/jszip/jszip.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/pdfmake/pdfmake.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/pdfmake/vfs_fonts.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/datatables-buttons/js/buttons.html5.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/datatables-buttons/js/buttons.print.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/plugins/datatables-buttons/js/buttons.colVis.min.js'/>"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value='templates/admin/dist/js/adminlte.min.js'/>"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value='templates/admin/dist/js/demo.js'/>"></script>
	<!-- Page specific script -->
	<script>
		$(function() {
			$("#example1").DataTable(
					{
						"responsive" : true,
						"lengthChange" : false,
						"autoWidth" : false,
						"buttons" : [ "copy", "csv", "excel", "pdf", "print",
								"colvis" ]
					}).buttons().container().appendTo(
					'#example1_wrapper .col-md-6:eq(0)');
		});
	</script>
</body>
</html>