<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="userURL" value="/quan-tri/danh-sach-user" />
<c:url var="editProductURL" value="/quan-tri/chinh-sua-sp" />
<c:url var="registerAPI" value="/api/register" />
<!DOCTYPE html>
<html>

<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<!-- Begin Page Content -->
	<div class="container-fluid">
	<h2>Thêm tài khoản</h2>
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}">${message}</div>
		</c:if>
		<div class="container">

			<form:form role="form" id="formSubmit" modelAttribute="model">
				<div class="row">
					<div class="col-25">
						<label for="fullName">Họ và tên</label>
					</div>
					<div class="col-75">
						<form:input path="fullName" />
					</div>
					<div class="col-25">
						<label for="userName">Tên tài khoản</label>
					</div>
					<div class="col-75">
						<form:input path="userName" />
					</div>
					<div class="col-25">
						<label for="password">Mật khẩu</label>
					</div>
					<div class="col-75">
						<form:password path="password" />
					</div>
					
					<form:hidden path="id" id="id" />
					<div class="col-25">
						<button class="btn btn-info" type="button" id="btnAddSP">
							<i class="ace-icon fa fa-check bigger-110"></i>Thêm tài khoản
						</button>
					</div>
					<div class="col-75">
						<button class="btn btn-info" type="reset" id="btnHuy">
							<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
						</button>

					</div>
				</div>
			</form:form>
		</div>
	</div>

	<script type="text/javascript">
		$('#btnAddSP').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			addProduct(data);
		});

		function addProduct(data) {
			$.ajax({
						url : '${registerAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${userURL}?id=" + result.id
							+ "&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${userURL}?id=" + result.id
							+ "&message=error_system";
						}
					});
		}
		
		$('#btnHuy').click(function(e) {
			e.preventDefault();
			window.location.href = "${userURL}";
				
		});

	</script>
</body>
</html>