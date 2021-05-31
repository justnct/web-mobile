<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<footer class="footer spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="footer__about">
						<div class="footer__about__logo">
							<a href="./index.html"><img src="img/logo.png" alt=""></a>
						</div>
						<ul>
							<li>Address: Đâu đó ở quận Thủ Đức</li>
							<li>Phone: 0372996571</li>
							<li>Email: T&Tshop@gmail.com</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
					<div class="footer__widget">
						<h6>Liên kết hữu ích</h6>
						<ul>
							<li><a href="#">Thông Tin Chúng Tôi</a></li>
							<li><a href="#">Thông Tin Shop Chúng Tôi</a></li>
							<li><a href="#">Mua Sắm An Toàn</a></li>
							<li><a href="#">Thông Tin Giao Hàng</a></li>
							<li><a href="#">Chính Sách Bảo Mật</a></li>
						</ul>
						<ul>
							<li><a href="#">Dịch Vụ Của Chúng Tôi</a></li>
							<li><a href="#">Liên Hệ</a></li>
							<li><a href="#">Sự Đổi Mới</a></li>

						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-12">
					<div class="footer__widget">
						<h6>Tham gia bản tin của chúng tôi ngay bây giờ</h6>
						<p>Nhận thông tin cập nhật qua email về cửa hàng mới nhất của
							chúng tôi và đặc biệt các đề nghị.</p>
						<form action="#">
							<input type="text" placeholder="Nhập email...">
							<button type="submit" class="site-btn">Đăng ký</button>
						</form>
						<div class="footer__widget__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-instagram"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-pinterest"></i></a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</footer>
	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="<c:url value='/template/web/js/jquery-3.3.1.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
	<script
		src="<c:url value='/template/web/js/jquery.nice-select.min.js'/>s"></script>
	<script src="<c:url value='/template/web/js/jquery-ui.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/jquery.slicknav.js'/>"></script>
	<script src="<c:url value='/template/web/js/mixitup.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>
	<script src="<c:url value='/template/web/js/main.js'/>"></script>
</body>
</html>