<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="homeAPI" value="/api/homeList" />
<c:url var="trangchu" value="/khach-hang/trang-chu" />


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Trang Chủ</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

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
				Tổng tiền: <span>$150.00</span>
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
				<li><a href="#">Shop</a></li>
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
	<section class="hero">
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
								<button type="submit" class="site-btn">TÌM KIẾM</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-phone"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5>0372996571</h5>
								<span>Hoạt động 24/24</span>
							</div>
						</div>
					</div>
					<div class="hero__item set-bg"
						data-setbg="<c:url value='/template/web/img/web/bg_green.jpg' />">
						<div class="hero__text">
							<span>CỬA HÀNG ĐIỆN THOẠI</span>
							<h2>
								Chuyên điện thoại cảm ứng <br /> Bảo hành trọn đời - Hơi bị
								chiến
							</h2>
							<p>Có Tiền Mua Thì Có Điện Thoại Bán</p>
							<a href="<c:url value='/khach-hang/cua-hang'/>"
								class="primary-btn">MUA LIỀN ĐI</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- Categories Section Begin -->
	<!-- Categories Section End -->

	<!-- Featured Section Begin -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Sản Phẩm Nổi Bật</h2>
					</div>
					<div class="featured__controls">
						<ul>
							<li data-filter="all"><a href="/khach-hang/trang-chu?nameBrand=all">All</a></li>
							<c:forEach var="item" items="${list}">
								<c:url var="chitiet" value="/khach-hang/trang-chu">
									<c:param name="nameBrand" value="${item.name}" />
								</c:url>
								<li data-filter=".${item.name}"><a href="${chitiet}">${item.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>


			<div class="row featured__filter">
				<c:forEach var="item" items="${listBest}">
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
					</a>
				</c:forEach>
			</div>

		</div>
		</div>
	</section>
	<!-- Featured Section End -->

	<!-- Banner Begin -->
	<div class="banner">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="img/banner/banner-1.jpg" alt="">
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="img/banner/banner-2.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Banner End -->

	<!-- Latest Product Section Begin -->
	<section class="latest-product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Sản Phẩm Nổi Bật</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<c:forEach var="item" items="${listNewest}">
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
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Sản Phẩm Được Chọn</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<c:forEach var="item" items="${listIsChoice}">
									<c:url var="chitiet" value="/khach-hang/chi-tiet-san-pham">
										<c:param name="id" value="${item.id}" />
									</c:url>
									<a href="#" class="latest-product__item">
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
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Sản Phẩm Bán Chạy</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<c:forEach var="item" items="${listSalest}">
									<c:url var="chitiet" value="/khach-hang/chi-tiet-san-pham">
										<c:param name="id" value="${item.id}" />
									</c:url>
									<a href="#" class="latest-product__item">
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
	</section>
	<!-- Latest Product Section End -->

	<!-- Blog Section Begin -->
	<!-- Blog Section End -->

	<!-- Footer Section Begin -->


</body>


</html>