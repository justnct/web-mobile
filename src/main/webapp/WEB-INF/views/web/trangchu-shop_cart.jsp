<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="addProduct" value="/api/product" />


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
	<!-- Page Preloder -->
	<!--  <div id="preloder">
        <div class="loader"></div>
    </div>

    Humberger Begin
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
            <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <img src="img/language.png" alt="">
                <div>English</div>
                <span class="arrow_carrot-down"></span>
                <ul>
                    <li><a href="#">Spanis</a></li>
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
                    </ul>
                </li>
                <li><a href="./blog.html">Blog</a></li>
                <li><a href="./contact.html">Contact</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                <li>Free Shipping for all Order of $99</li>
            </ul>
        </div>
    </div>
    Humberger End

    Header Section Begin
    
    Header Section End

    Hero Section Begin
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <ul>
                            <li><a href="#">Fresh Meat</a></li>
                            <li><a href="#">Vegetables</a></li>
                            <li><a href="#">Fruit & Nut Gifts</a></li>
                            <li><a href="#">Fresh Berries</a></li>
                            <li><a href="#">Ocean Foods</a></li>
                            <li><a href="#">Butter & Eggs</a></li>
                            <li><a href="#">Fastfood</a></li>
                            <li><a href="#">Fresh Onion</a></li>
                            <li><a href="#">Papayaya & Crisps</a></li>
                            <li><a href="#">Oatmeal</a></li>
                            <li><a href="#">Fresh Bananas</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    Hero Section End

    Breadcrumb Section Begin
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Shopping Cart</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
	<!-- Breadcrumb Section End -->

	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table">
						<table>
							<thead>
								<tr>
									<th class="shoping__product">Sản phẩm</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Thành tiền</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${listProduct}">
									<tr>
										<td class="shoping__cart__item"><img
											src="img/cart/cart-1.jpg" alt="">
											<h5>${item.name}</h5></td>
										<td class="shoping__cart__price">${item.converterPrice}</td>
										<td class="shoping__cart__quantity">
											<div class="quantity">
												<div class="pro-qty">
													<input type="text" value="1">
												</div>
											</div>
										</td>
										<td class="shoping__cart__total">${item.converterPrice}</td>
										<td class="shoping__cart__item__close"><span id="btn"
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
						<a href="<c:url value='/khach-hang/trang-chu'/>"
							class="primary-btn cart-btn">TIẾP TỤC MUA HÀNG</a> <a href="#"
							class="primary-btn cart-btn cart-btn-right"><span
							class="icon_loading"></span> Cập nhật giỏ hàng</a>
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
		$('#btn').click(function(e) {
			e.preventDefault();
			var data = {};
			var name = 'id';
			var value = '${item.id}';
			data["" + name + ""] = value;
			deleteProduct(data);
		});

		function deleteProduct(data) {
			$.ajax({
				url : '${addProduct}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "/khach-hang/gio-hang";
				},
				error : function(error) {
					/* window.location.href = "/khach-hang/cua-hang"; */
				}
			});
		}
	</script>
</body>
</html>