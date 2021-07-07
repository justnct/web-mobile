<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="registerAPI" value="/api/register" />
<c:url var="loginURL" value="/dang-nhap" />
<c:url var="sigupURL" value="/dang-ky" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Tạo tài khoản!</h1>
							</div>
							<form:form id="formSubmit" modelAttribute="model">
								<!--  <div class="form-group row"> -->
								<c:if test="${param.duplicated != null}">
									<div id="asd" class="alert alert-danger">Tài khoản đã tồn
										tại</div>
								</c:if>
								<div class="col-25">
									<label for="fullName">Họ và tên</label>
								</div>
								<div class="form-group row">
									<form:input path="fullName"
										cssClass="form-control form-control-user" />
								</div>
								<div class="col-25">
									<label for="userName">Tên tài khoản</label>
								</div>
								<div class="form-group row">
									<form:input path="userName"
										cssClass="form-control form-control-user" />
								</div>
								<div class="col-25">
									<label for="password">Mật khẩu</label>
								</div>
								<div class="form-group row">
									<form:password path="password"
										cssClass="form-control form-control-user" />
								</div>
								<button class="btn btn-primary btn-user btn-block"
									id="btnRegister">Đăng ký tài khoản</button>
							</form:form>
							<hr>
							<div class="text-center">
								<a class="small" href="#">Quên mật khẩu?</a>
							</div>
							<div class="text-center">
								<a class="small" href="<c:url value='/dang-nhap'/>">Đã có
									tài khoản? Đăng nhập!</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		$('#btnRegister').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			register(data);
		});

		function register(data) {
			$.ajax({
				url : '${registerAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					 if (result.userName == "") {
						window.location.href = "${signupURL}?duplicated";
					} else {
						window.location.href = "${loginURL}";
					} 
				},
				error : function(error) {
				}
			});
		}
	</script>

</body>

</html>