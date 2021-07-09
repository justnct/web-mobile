<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="addLike" value="/addLike" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<section class="hero"
		style="display: flex; justify-content: center; align-items: center;">

		<div class="hero__search">
			<div class="hero__search__form">
				<form method="get" action="search">
					<div class="hero__search__categories">
						Tất cả sản phẩm <span class="arrow_carrot-down"></span>
					</div>
					<input type="text" placeholder="Bạn cần tìm gì ?" name="keyword">
					<button type="submit" class="site-btn">Tìm kiếm</button>
				</form>
			</div>
		</div>


	</section>
	<section class="featured spad">

		<div class="container">

			<div class="row">

				<c:forEach var="item" items="${xiaomi}">
					<c:url var="chitiet" value="/khach-hang/chi-tiet-san-pham">
						<c:param name="id" value="${item.id}" />
					</c:url>
					<div class="col-lg-4 col-md-6 col-sm-6">
						<div class="product__item">
							<div class="product__item__pic set-bg"
								data-setbg='<c:url value='/template/web/img/web/product/${item.nameImg}'/>'
								alt="">
								<ul class="product__item__pic__hover">
									<li><i class="fa fa-heart" onclick="addLike(${item.id})"></i></li>
									<li><a href="#"><i class="fa fa-retweet"></i></a></li>
									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
								</ul>
							</div>
							<div class="product__item__text">
								<h6>
									<a href="${chitiet}">${item.name}</a>
								</h6>
								<h5>${item.converterPrice}</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<script type="text/javascript">
	function addLike(id) {
		var data ={};
		var name1 = 'id';
		var value1 = id;
		data[""+name1+""] = value1;
		$.ajax({
            url: '${addLike}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	alert("Đã thêm vào sản phẩm yêu thích")
            },
            error: function (error) {
            	alert("Đã thêm vào sản phẩm yêu thích")
            }
        });
	}
	</script>
</body>
</html>