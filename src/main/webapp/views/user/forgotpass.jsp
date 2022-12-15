<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	color: #1b1a1a;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
}

.form-control {
	box-shadow: none;
	border-color: #ddd;
}

.form-control:focus {
	border-color: #46a5d3;
}

.login-form {
	width: 350px;
	margin: 0 auto;
	padding: 30px 0;
}

.login-form form {
	color: #434343;
	border-radius: 1px;
	margin-bottom: 15px;
	background: #fff;
	border: 1px solid #f3f3f3;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.login-form h4 {
	text-align: center;
	font-size: 22px;
	margin-bottom: 20px;
}

.login-form .avatar {
	color: #fff;
	margin: 0 auto 30px;
	text-align: center;
	width: 100px;
	height: 100px;
	border-radius: 50%;
	z-index: 9;
	background: #46a5d3;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}

.login-form .avatar i {
	font-size: 62px;
}

.login-form .form-group {
	margin-bottom: 20px;
}

.login-form .form-control, .login-form .btn {
	min-height: 40px;
	border-radius: 2px;
	transition: all 0.5s;
}

.login-form .close {
	position: absolute;
	top: 15px;
	right: 15px;
}

.login-form .btn {
	background: #46a5d3;
	border: none;
	line-height: normal;
}

.login-form .btn:hover, .login-form .btn:focus {
	background: #0271a9;
}

.login-form .checkbox-inline {
	float: left;
}

.login-form input[type="checkbox"] {
	margin-top: 2px;
}

.login-form .forgot-link {
	float: right;
}

.login-form .small {
	font-size: 13px;
}

.login-form a {
	color: #46a5d3;
}
</style>
</head>
<body>
	<div class="login-form">

		<div class="avatar">
			<i class="material-icons">&#xE7FF;</i>
		</div>
		<h4 class="modal-title">Forgot password</h4>
		<div class="form-group">
			<input type="email" class="form-control" name="email"
				placeholder="Email" id="email" required="required">
		</div>
		<div class="form-group tm-text-right">
			<button type="submit" id="sendBtn" style="background-color: #2475be" class="btn btn-primary">Send
				Email</button>
		</div>
		<h5 style="color: red" id="messageReturn"></h5>

	</div>
	<script>
		$('#sendBtn').click(function() {
			$('#messageReturn').text('');
			var email = $('#email').val();
			var formData = {'#email' : email};
			$.ajax({
				url : 'forgotpass',
				type : 'POST',
				data : formData
			}).then(function(data) {
				$('#messageReturn').text('Your password has been reset');
				setTimeout(function() {
					window.location.href = 'http://localhost:8080/AsmJava4/index';
				}, 5 * 1000);
			}).fail(function(error) {
				$('#messageReturn').text('Your email is incorrect, try again');
			});
		});
	</script>
</body>
</html>