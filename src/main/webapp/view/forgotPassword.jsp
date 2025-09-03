<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<link rel="stylesheet" href="path/to/bootstrap.css">
<!-- Thêm nếu cần -->
</head>
<body>
	<div class="container" style="max-width: 500px; margin-top: 50px;">
		<h2>Quên mật khẩu</h2>
		<p>Vui lòng nhập địa chỉ email bạn đã đăng ký. Chúng tôi sẽ gửi
			liên kết để đặt lại mật khẩu.</p>

		<c:if test="${message != null}">
			<div class="alert alert-info">${message}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/forgotPassword"
			method="post">
			<input type="email" name="email" required> <input
				type="submit" value="Gửi yêu cầu">

		</form>

		<div style="margin-top: 20px;">
			<a href="login.jsp">← Quay lại trang đăng nhập</a>
		</div>
	</div>
</body>
</html>