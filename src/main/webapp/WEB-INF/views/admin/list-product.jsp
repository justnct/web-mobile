<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="productAPI" value="/apiad/product" />
<c:url var="productURL" value="/quan-tri/danh-sach-sp" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Danh sách sản phẩm</title>



</head>

<body id="page-top">

	<!-- Begin Page Content -->
	<div class="container-fluid">
	<c:if test="${not empty message}">
			<div class="alert alert-${alert}">${message}</div>
		</c:if>
	<div style="float: right">		
		<c:url var="createProductURL" value="/quan-tri/them-sp" />
		<a href='${createProductURL}'>
			<button
				style="border-radius: 5px; border-color: white; "
				title="Thêm sản phẩm">
				<i class="fas fa-plus-circle" style="font-size: 30px; color: green"></i>
			</button>
		</a> &nbsp;
		<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
			style="border-radius: 5px; border-color: white; " title="Xóa sản phẩm">
			<i class="fas fa-trash" style="font-size: 30px; color: red"></i>
		</button>
		</div>
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Danh sách sản phẩm</h1>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th><input type="checkbox" id="checkAll"></th>
								<th>Tên điện thoại</th>
								<th>Hình ảnh</th>
								<th>Giảm giá (%)</th>
								<th>Giá trước giảm giá (VND)</th>
								<th>Giá (VND)</th>
								<th>SP được chọn</th>
								<th>SP bán chạy</th>
								<th>Mô tả</th>
								<th>Thao tác (Cập nhật)</th>

							</tr>
						</thead>
						<tfoot>
							<tr>
							<th></th>
								<th>Tên điện thoại</th>
								<th>Hình ảnh</th>
								<th>Giảm giá (%)</th>
								<th>Giá trước giảm giá (VND)</th>
								<th>Giá (VND)</th>
								<th>SP được chọn</th>
								<th>SP bán chạy</th>
								<th>Mô tả</th>
								<th>Thao tác(Cập nhật)</th>
							</tr>
						</tfoot>
						<tbody>

							<c:forEach var="item" items="${listProduct}">
								<tr>
									<td><input type="checkbox" id="checkbox_${item.id}"
										value="${item.id}"></td>
									<td>${item.name}</td>
									<td><img
										src='<c:url value='/template/web/img/web/product/${item.nameImg}'/>'
										width="80px" height="80px"></td>
									<td>${item.discount}</td>
									<td>${item.discountPrice}</td>
									<td>${item.price}</td>
									<td>${item.isChoice}</td>
									<td>${item.salest}</td>
									<td>${item.des}</td>
									<td><c:url var="updateProductURL"
											value="/quan-tri/chinh-sua-sp">
											<c:param name="id" value="${item.id}"></c:param>
										</c:url> <a href="${updateProductURL}">
											<button style="border-radius: 5px; border-color: white;"
												title="Cập nhật sản phẩm">
												<i class="fas fa-edit" style="font-size: 30px; color: blue"></i>
											</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

	</div>
	<!-- End of Main Content -->
	<script type="text/javascript">
		function warningBeforeDelete() {
			swal({
				  title: "Xác nhận xóa",
				  text: "Bạn có chắc chắn muốn xóa hay không",
				  type: "warning",
				  showCancelButton: true,
				  confirmButtonClass: "btn-danger",
				  confirmButtonText: "Xóa ngay!",
				  cancelButtonText: "Thoát",
				  closeOnConfirm: false,
				  closeOnCancel: false
				}).then(function(isConfirm) {
				  if (isConfirm) {
						var ids = $('tbody input[type=checkbox]:checked').map(function () {
				            return $(this).val();
				        }).get();
						deleteProduct(ids);
				  }else {
					    swal("Cancelled", "Thoát)", "error");
				  }
				});
		}
		function deleteProduct(data) {
			$.ajax({
						url : '${productAPI}',
						type : 'DELETE',
						contentType : 'application/json',
						data : JSON.stringify(data),
						success : function(result) {						 
							 window.location.href = "${productURL}?page=1&message=delete_success"; 
						},
						error : function(error) {
							 window.location.href = "${productURL}?page=1&message=error_system"; 
						}
					});
		}
	</script>
</body>

</html>