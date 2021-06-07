<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<script
	src="<c:url value='/template/web/pagging/jquery.twbsPagination.js' />"
	type="text/javascript"></script>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->



</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Humberger Begin -->
	<div class="humberger__menu__overlay"></div>
	<div class="humberger__menu__wrapper">
		<div class="humberger__menu__logo">
			<a href="#"><img src="img/logo.png" alt=""></a>
		</div>
		<div class="humberger__menu__cart">
			<ul>
				<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
				<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
			</ul>
			<div class="header__cart__price">
				item: <span>$150.00</span>
			</div>
		</div>
		<div class="humberger__menu__widget">
			<div class="header__top__right__language">
				<img src="img/language.png" alt="">
				<div>English</div>
				<span class="arrow_carrot-down"></span>
				<ul>
					<li><a href="#">Spanish</a></li>
					<li><a href="#">English</a></li>
				</ul>
			</div>
			<div class="header__top__right__auth">
				<a href="#"><i class="fa fa-user"></i> Login</a>
			</div>
		</div>
		<nav class="humberger__menu__nav mobile-menu">
			<ul>
				<li class="active"><a href="./index.html">Home</a></li>
				<li><a href="./shop-grid.html">Shop</a></li>
				<li><a href="#">Pages</a>
					<ul class="header__menu__dropdown">
						<li><a href="./shop-details.html">Shop Details</a></li>
						<li><a href="./shoping-cart.html">Shoping Cart</a></li>
						<li><a href="./checkout.html">Check Out</a></li>
						<li><a href="./blog-details.html">Blog Details</a></li>
					</ul></li>
				<li><a href="./blog.html">Blog</a></li>
				<li><a href="./contact.html">Contact</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
		<div class="header__top__right__social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-pinterest-p"></i></a>
		</div>
		<div class="humberger__menu__contact">
			<ul>
				<li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
				<li>Free Shipping for all Order of $99</li>
			</ul>
		</div>
	</div>
	<!-- Humberger End -->

	<!-- Header Section Begin -->

	<!-- Header Section End -->

	<!-- Hero Section Begin -->
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
	<!-- Hero Section End -->

	<!-- Breadcrumb Section Begin -->
	<!-- <section class="breadcrumb-section set-bg"
		data-setbg="img/breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Organi Shop</h2>
						<div class="breadcrumb__option">
							<a href="./index.html">Home</a> <span>Shop</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> -->
	<!-- Breadcrumb Section End -->

	<!-- Product Section Begin -->
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
													<span>${item.price}</span>
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
										<a href="${chitiet}">
											<div class="product__discount__item">
												<div class="product__discount__item__pic set-bg"
													data-setbg="<c:url value='/template/web/img/web/product/${item.nameImg}'/>"
													alt="">
													<div class="product__discount__percent">-${item.discount}%</div>
													<ul class="product__item__pic__hover">
														<li><a href="#"><i class="fa fa-heart"></i></a></li>
														<li><a href="#"><i class="fa fa-retweet"></i></a></li>
														<li><a href="${chitiet}"><i class="fa fa-shopping-cart"></i></a></li>
													</ul>
												</div>
												<div class="product__discount__item__text">
													<span>${item.name}</span>
													<div class="product__item__price">
														${item.discountPrice} VND <span> ${item.price} VND</span>
													</div>
												</div>
											</div>
											</a>
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
						<c:forEach var="item" items="${listProduct}">
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
											<a href="#">${item.name}</a>
										</h6>
										<h5>${item.price}VND</h5>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<!--phan trang-->
				<!-- <div class="product__pagination">
						<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#"><i
							class="fa fa-long-arrow-right"></i></a>
					</div> -->

			</div>
		</div>
		</div>
	</section>
	<nav aria-label="Page navigation">
		<ul id="pagination" class="pagination"></ul>
	</nav>

	<!-- Product Section End -->

	<!-- Footer Section Begin -->


	<script>
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 35,
            visiblePages: 10,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        })
        });
    });
</script>

</body>
</html>