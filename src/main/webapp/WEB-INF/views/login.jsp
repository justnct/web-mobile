<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<%-- <body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">	
							Tài khoản hoặc tên đăng nhập sai
					</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">	
							Bạn không có quyền truy cập
					</div>
				</c:if>
				<form action="j_spring_security_check" id="formLogin" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu">
					</div>
					<button type="submit" class="btn btn-primary" >Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
	
	
	
	
</body> --%>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Đăng nhập</h1>
									</div>

									<div class="main-div">
										<c:if test="${param.incorrectAccount != null}">
											<div class="alert alert-danger">Tài khoản hoặc tên đăng
												nhập sai</div>
										</c:if>
										<c:if test="${param.accessDenied != null}">
											<div class="alert alert-danger">Bạn không có quyền truy
												cập</div>
										</c:if>
										<form action="j_spring_security_check" id="formLogin"
											method="post">
											<div class="form-group">
												<input type="text" class="form-control" id="userName"
													name="j_username" placeholder="Tên đăng nhập">
											</div>

											<div class="form-group">
												<input type="password" class="form-control" id="password"
													name="j_password" placeholder="Mật khẩu">
											</div>
											<button type="submit" class="btn btn-primary btn-user btn-block">Đăng
												nhập</button>
										</form>
										<hr>
										<div class="text-center">
											<a class="small" href="forgot-password.html">Forgot
												Password?</a>
										</div>
										<div class="text-center">
											<a class="small" href="register.html">Create an Account!</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>
</body>

</html>