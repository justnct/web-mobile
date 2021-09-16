<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.laptrinhjavaweb.util.SecurityUtils"%>
<c:url var="addProduct" value="/api/product" />
<c:url var="chitietURL" value="/khach-hang/chi-tiet-san-pham" />


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


<!-- Product Details Section Begin -->
<section class="product-details spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="product__details__pic">
					<div class="product__details__pic__item">
						<img class="product__details__pic__item--large"
							src="<c:url value='/template/web/img/web/product/${product.nameImg}'/>"
							alt="">
					</div>
					<div class="product__details__pic__slider owl-carousel">
						<img data-imgbigurl="img/product/details/product-details-2.jpg"
							src="<c:url value='/template/web/img/web/product/${img1}'/>"
							alt=""> <img
							data-imgbigurl="img/product/details/product-details-3.jpg"
							src="<c:url value='/template/web/img/web/product/${img2}'/>"
							alt=""> <img
							data-imgbigurl="img/product/details/product-details-5.jpg"
							src="<c:url value='/template/web/img/web/product/${img3}'/>"
							alt=""> <img
							data-imgbigurl="img/product/details/product-details-4.jpg"
							src="<c:url value='/template/web/img/web/product/${img4}'/>"
							alt="">
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="product__details__text">
					<h3>${product.name}</h3>
					<div class="product__details__rating">
						<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star-half-o"></i><span>(18 reviews)</span>
					</div>
					<div class="product__details__price">${product.converterPrice}</div>
					<p>${product.des}</p>
					<div class="product__details__quantity">
						<div class="quantity">
							<div class="pro-qty">
								<input id="quantity" type="text" value="1">
							</div>
						</div>
					</div>
					<button id="addCart" type="button" class="primary-btn">THÊM
						VÀO GIỎ HÀNG</button>
					
				</div>
			</div>
			<div class="col-lg-12">
				<div class="product__details__tab">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Mô
								tả</a></li>
						<!-- <li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#tabs-2" role="tab" aria-selected="false">Thông tin</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#tabs-3" role="tab" aria-selected="false">Reviews<span>(1)</span></a>
						</li> -->
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tabs-1" role="tabpanel">
							<div class="product__details__tab__desc">
								<h6>Chi tiết sản phẩm</h6>
								<p>${product.des}</p>
							</div>
						</div>
						<div class="tab-pane" id="tabs-2" role="tabpanel">
							<div class="product__details__tab__desc">
								<h6>Thông tin sản phẩm</h6>
								<p>Sản phẩm vip lắm á</p>
							</div>
						</div>
						<div class="tab-pane" id="tabs-3" role="tabpanel">
							<div class="product__details__tab__desc">
								<h6>Bình luận</h6>
								<p>Gút chóp ơ mây ding.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Product Details Section End -->

<!-- Related Product Section Begin -->

<!-- Related Product Section End -->

<!-- Footer Section Begin -->

<script type="text/javascript">
	$('#addCart').click(function(e) {
		e.preventDefault();
		var data = {};
		var name1 = 'id';
		var value1 = '${product.id}';
		var name2 = 'count';
		var value2 = document.getElementById("quantity").value;
		if (value2 == 0) {
			alert("Số lượng phải lớn hơn 0")
		} else {
			data["" + name1 + ""] = value1;
			data["" + name2 + ""] = value2;
			addProduct(data);
		}

	});

	function addProduct(data) {
		$
				.ajax({
					url : '${addProduct}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						var spanCart = document.getElementById("span_cart").innerText;
						var quantity = document.getElementById("quantity").value;
						var currentCart = Number(spanCart) + Number(quantity);
						document.getElementById("span_cart").textContent = currentCart;
						alert("Sản phẩm đã được thêm vào giỏ...")
					},
					error : function(error) {
					}
				});
	}
</script>

</body>
</html>