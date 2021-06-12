<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="productURL" value="/quan-tri/danh-sach-sp" />
<c:url var="editProductURL" value="/quan-tri/chinh-sua-sp" />
<c:url var="productAPI" value="/apiad/product" />
<!DOCTYPE html>
<html>

<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<!-- Begin Page Content -->
	<div class="container-fluid">
	<h2>Cập nhật sản phẩm</h2>
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}">${message}</div>
		</c:if>
		<div class="container">

			<form:form role="form" id="formSubmit" modelAttribute="model">
				<div class="row">
					<div class="col-25">
						<label for="name">Tên điện thoại</label>
					</div>
					<div class="col-75">
						<form:input path="name" />
					</div>
					<div class="col-25">
						<label for="discount">Giảm giá (%)</label>
					</div>
					<div class="col-75">
						<form:input path="discount" />
					</div>
					<div class="col-25">
						<label for="discountPrice">Giá trước giảm giá (VND)</label>
					</div>
					<div class="col-75">
						<form:input path="discountPrice" />
					</div>
					<div class="col-25">
						<label for="price">Giá (VND)</label>
					</div>
					<div class="col-75">
						<form:input path="price" />
					</div>
					<div class="col-25">
						<label for="isChoice">Sản phẩm được chọn</label>
					</div>
					<div class="col-75">
						<form:input path="isChoice" />
					</div>
					<div class="col-25">
						<label for="salest">Sản phẩm bán chạy</label>
					</div>
					<div class="col-75">
						<form:input path="salest" />
					</div>

					<div class="col-25">
						<label for="nameImg">Hình ảnh</label>
					</div>
					<div class="col-75">
						<input onchange="readURL(this);" type="file" class="col-xs-10 col-sm-5" id="uploadFile"
							name="uploadFile" value="${model.nameImg}" />
						<img class="col-xs-10 col-sm-5" id="nameImg"
							name="nameImg" />
					</div>
					<!-- <div class="col-25">
						<label for="smallImg">Hình ảnh nhỏ</label>
					</div>
					<div class="col-75">
						<input type="file" class="col-xs-10 col-sm-5" id="nameLittleImg"
							name="nameLittleImg" />
					</div> -->
				</div>
				<div class="row">
					<div class="col-25">
						<label for="des">Mô tả</label>
					</div>
					<div class="col-75">
						<form:textarea rows="5" path="des" />
					</div>
					<form:hidden path="id" id="id_product" />
					<div class="col-25">
						<button class="btn btn-info" type="button" id="btnUpdateSP">
							<i class="ace-icon fa fa-check bigger-110"></i>Cập nhật
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
		$('#btnUpdateSP').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			var id = $('#id_product').val();
			/* if (id == "") {
				addProduct(data);
			} else { */
				updateProduct(data);
		/* 	} */
		});

		function updateProduct(data) {
			$.ajax({
				url : '${productAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${productURL}?id=" + result.id
							+ "&message=update_success";
				},
				error : function(error) {
					window.location.href = "${editProductURL}?id=" + result.id
					+ "&message=error_system";
				}
			});
		}
		
		$('#btnHuy').click(function(e) {
			e.preventDefault();
			window.location.href = "${productURL}";
				
		});
		
		
		
	</script>
</body>
</html>