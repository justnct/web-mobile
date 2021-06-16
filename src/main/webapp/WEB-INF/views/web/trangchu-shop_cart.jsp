<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="deleteProduct" value="/api/removeproduct" />
<c:url var="deleteAllProduct" value="/api/removeAllProduct" />
<c:url var="cuahang" value="/khach-hang/gio-hang" />
<c:url var="trangchu" value="/khach-hang/trang-chu" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
</head>


<body>
	

	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table">
						<table>
							<thead>
								<tr>
									<th>Hình ảnh</th>
									<th>Sản phẩm</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Thành tiền</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${listProduct}">
									<tr>
										<td class="shoping__cart__price"><img
										src='<c:url value='/template/web/img/web/product/${item.nameImg}'/>'
										width="80px" height="80px"></td>
										<td class="shoping__cart__product">
											<h5>${item.name}</h5></td>
										<td class="shoping__cart__total">${item.converterPrice}</td>
										<td class="shoping__cart__quantity">
											<div class="quantity">
												<div class="pro-qty">
													<input type="text" value="1">
												</div>
											</div>
										</td>
										<td class="shoping__cart__total">${item.converterPrice}</td>
										<td class="shoping__cart__item__close"><span id="btn"
											onclick="deleteProduct(${item.id})" value="1"
											class="icon_close"></span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__btns">
						<button id="back" class="primary-btn cart-btn">TIẾP TỤC
							MUA HÀNG</button>
						<button id="btnThanhToan"
							class="primary-btn cart-btn cart-btn-right">THANH TOÁN</button>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="shoping__continue">
						<div class="shoping__discount">
							<h5>Mã giảm giá</h5>
							<form action="#">
								<input type="text" placeholder="Nhập mã giảm giá của bạn">
								<button type="submit" class="site-btn">SỬ DỤNG ĐIỂM</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="shoping__checkout">
						<h5>Tổng tiền</h5>
						<ul>
							<li>Tổng cộng <span>${totalPrice}</span></li>
							<li>Thành tiền <span>${totalPrice}</span></li>
						</ul>
						<a href="#" class="primary-btn">THANH TOÁN</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Shoping Cart Section End -->

	<!-- Footer Section Begin -->
	<script type="text/javascript">
		function deleteProduct(data) {
			$.ajax({
				url : '${deleteProduct}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${cuahang}";
				},
				error : function(error) {
					window.location.href = "${cuahang}";
				}
			});
		}
		
		$('#btnThanhToan').click(function (e) {
			alert("Xác nhận thanh toán đơn hàng có giá trị ${totalPrice} !!!");
			var data = {};
		 	deleteAllProduct(data);
		});
		
		function deleteAllProduct(data) {
			$.ajax({
				url : '${deleteAllProduct}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${cuahang}";
				},
				error : function(error) {
					window.location.href = "${cuahang}";
				}
			});
		}
		
		$('#back').click(function (e) {
			window.location.href = "${trangchu}";
		});
		
		
	</script>
</body>
</html>