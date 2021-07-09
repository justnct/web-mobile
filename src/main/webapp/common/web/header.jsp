<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T&T Shop</title>
</head>
<body>
	<header class="header">
		<div class="header__top" style="background: #7fad39; font-weight: 500">
			<div class="container" >
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="header__top__left">
							<ul>
								<li><i class="fa fa-envelope"></i>Cửa hàng T&T</li>
								<li>Chuyên bán điện thoại xịn hơn người yêu cũ của bạn </li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right">
							<div class="header__top__right__social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-linkedin"></i></a> <a href="#"><i
									class="fa fa-pinterest-p"></i></a>
							</div>
							<div class="header__top__right__language">
								<img src="img/language.png" alt="">
								<div>Việt Nam</div>
								<span class="arrow_carrot-down"></span>
								<ul>
									<li><a href="#">Việt Nam</a></li>
									<li><a href="#">English</a></li>
								</ul>
							</div>
							<div class="header__top__right__auth">
								<security:authorize access="isAnonymous()">
									<a href="<c:url value='/dang-nhap'/>"><i class="fa fa-user"></i>
										Đăng nhập</a>
								</security:authorize>
								<security:authorize access="isAuthenticated()">
									<a class="nav-link" href="<c:url value='/thoat'/>">Chào,
											<%=SecurityUtils.getPrincipal().getFullName()%>.Thoát</a>
								</security:authorize>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="./index.html"><img src="img/logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li class="active"><a
								href="<c:url value='/khach-hang/trang-chu?nameBrand=all'/>">Trang chủ</a></li>
							<li><a href="<c:url value='/khach-hang/cua-hang?page=1&limit=9&sort=normal'/>">Cửa
									hàng</a></li>
							<li><a href="<c:url value='/khach-hang/gio-hang'/>">Giỏ
									hàng</a></li>
							<li><a href="<c:url value='/khach-hang/lien-he'/>">Liên
									hệ</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
							<li><a href="<c:url value='/khach-hang/yeu-thich'/>"><i class="fa fa-heart"></i> <span>${amountLike}</span></a></li>
							<li><a href="<c:url value='/khach-hang/gio-hang'/>"><i class="fa fa-shopping-bag"></i> <span>${count}</span></a></li>
						</ul>
						<div class="header__cart__price">
							Tổng tiền: <span>${totalPrice}</span>
						</div>
					</div>
				</div>
			</div>
			<div class="humberger__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>

</body>
</html>