<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T&T Shop</title>
<link rel="stylesheet"
	href="<c:url value='/template/web/css/bootstrap.min.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/font-awesome.min.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/elegant-icons.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/nice-select.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/jquery-ui.min.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/owl.carousel.min.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/slicknav.min.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/style.css' />" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src='<c:url value='/template/web/pagging/jquery.twbsPagination.js'/>'
	type="text/javascript"></script>
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<section class="hero hero-normal">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>Tất cả sản phẩm</span>
						</div>
						<ul>
							<c:forEach var="item" items="${list}">
								<li><a href="#">Điện thoại ${item.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">
								<div class="hero__search__categories">
									Tất cả sản phẩm <span class="arrow_carrot-down"></span>
								</div>
								<input type="text" placeholder="Bạn cần tìm gì ?">
								<button type="submit" class="site-btn">Tìm kiếm</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-phone"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5>0372996572</h5>
								<span>Hỗ trợ 24/24</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-5">
					<div class="sidebar">
						<div class="sidebar__item"></div>
						<div class="sidebar__item">
							<h4>Giá</h4>
							<div class="price-range-wrap">
								<div
									class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
									data-min="200" data-max="2000">
									<div class="ui-slider-range ui-corner-all ui-widget-header"></div>
									<span tabindex="0"
										class="ui-slider-handle ui-corner-all ui-state-default"></span>
									<span tabindex="0"
										class="ui-slider-handle ui-corner-all ui-state-default"></span>
								</div>
								<div class="range-slider">
									<div class="price-input">
										<input type="text" id="minamount"> <input type="text"
											id="maxamount">
									</div>
								</div>
							</div>
						</div>
						<div class="sidebar__item sidebar__item__color--option">
							<h4>Màu</h4>
							<div class="sidebar__item__color sidebar__item__color--white">
								<label for="white"> Trắng <input type="radio" id="white">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--gray">
								<label for="gray"> Xám <input type="radio" id="gray">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--red">
								<label for="red"> Đỏ <input type="radio" id="red">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--black">
								<label for="black"> Đen <input type="radio" id="black">
								</label>
							</div>
							<div class="sidebar__item__color sidebar__item__color--blue">
								<label for="blue"> Xanh <input type="radio" id="blue">
								</label>
							</div>

						</div>
						<div class="sidebar__item">
							<h4>Kích cỡ điện thoại</h4>
							<div class="sidebar__item__size">
								<label for="large"> Cỡ lớn <input type="radio"
									id="large">
								</label>
							</div>
							<div class="sidebar__item__size">
								<label for="medium"> Trung bình <input type="radio"
									id="medium">
								</label>
							</div>
							<div class="sidebar__item__size">
								<label for="small"> Cỡ nhỏ <input type="radio"
									id="small">
								</label>
							</div>

						</div>
						<div class="sidebar__item">
							<div class="latest-product__text">
								<h4>Sản phẩm cũ đã mua</h4>
								<div class="latest-product__slider owl-carousel">
									<div class="latest-prdouct__slider__item">
										<c:forEach var="item" items="${listSalest}">
											<c:url var="chitiet" value="/khach-hang/chi-tiet-san-pham">
												<c:param name="id" value="${item.id}" />
											</c:url>
											<a href="${chitiet}" class="latest-product__item">
												<div class="product__item__pic set-bg"
													data-setbg="<c:url value='/template/web/img/web/product/${item.nameImg}'/>"
													alt=""></div>
												<div class="latest-product__item__text">
													<h6>${item.name}</h6>
													<span>${item.converterPrice}</span>
												</div>
											</a>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-9 col-md-7">
					<div class="product__discount">
						<div class="section-title product__discount__title">
							<h2>Giảm giá</h2>
						</div>
						<div class="row">
							<div class="product__discount__slider owl-carousel">
								<c:forEach var="item" items="${listDiscount}">
									<c:url var="chitiet" value="/khach-hang/chi-tiet-san-pham">
										<c:param name="id" value="${item.id}" />
									</c:url>
									<div class="col-lg-4">
										<div class="product__discount__item">
											<div class="product__discount__item__pic set-bg"
												data-setbg="<c:url value='/template/web/img/web/product/${item.nameImg}'/>"
												alt="">
												<div class="product__discount__percent">-${item.discount}%</div>
												<ul class="product__item__pic__hover">
													<li><a href="#"><i class="fa fa-heart"></i></a></li>
													<li><a href="#"><i class="fa fa-retweet"></i></a></li>
													<li><a href="${chitiet}"><i
															class="fa fa-shopping-cart"></i></a></li>
												</ul>
											</div>
											<div class="product__discount__item__text">
												<span>${item.name}</span>
												<div class="product__item__price">
													${item.converterPrice} <span>
														${item.converterDisPrice}</span>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>

					</div>
					<div class="filter__item">
						<div class="row">
							<div class="col-lg-4 col-md-5">
								<div class="filter__sort">
									<span>Sắp xếp theo</span> <select>
										<option value="0">Mặc định</option>
									</select>
								</div>
							</div>
							<div class="col-lg-4 col-md-4">
								<div class="filter__found">
									<h6>
										Tổng số sản phẩm <span> ${countProduct}</span>
									</h6>
								</div>
							</div>
							<div class="col-lg-4 col-md-3">
								<div class="filter__option">
									<span class="icon_grid-2x2"></span> <span class="icon_ul"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<c:forEach var="item" items="${listProduct123}">
							<c:url var="chitiet" value="/khach-hang/chi-tiet-san-pham">
								<c:param name="id" value="${item.id}" />
							</c:url>
							<div class="col-lg-4 col-md-6 col-sm-6">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg='<c:url value='/template/web/img/web/product/${item.nameImg}'/>'
										alt="">
										<ul class="product__item__pic__hover">
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
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
				<!-- <div class="product__pagination">
					<nav aria-label="Page navigation">
						<ul class="pagination" id="pagination"></ul>
					</nav>
				</div> -->
			</div>
		</div>

	</section>
	<nav aria-label="Page navigation">
		<ul class="pagination" id="pagination">
		</ul>
		<input type="hidden" value="" id="page" name="page" /> <input
			type="hidden" value="" id="limit" name="limit" />
	</nav>

	<%@ include file="/common/web/footer.jsp"%>

	<script type="text/javascript">
		
	var totalPages = ${totalPage};
	var currentPage = ${page};
	$(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
            		$('#limit').val(9);
					$('#page').val(page);
				}
            }
        });
    });
	</script>
</body>
</html>