<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<h2>Đăng nhập</h2>
		<c:if test="${alert != null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>

		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" name="username" placeholder="Tên đăng nhập"
						class="form-control" required>
				</div>
			</label>
		</section>

		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="password" name="password" placeholder="Mật khẩu"
						class="form-control" required>
				</div>
			</label>
		</section>

		<section>
			<button type="submit" class="btn btn-primary">Đăng nhập</button>
		</section>
	</form>

</body>
</html>