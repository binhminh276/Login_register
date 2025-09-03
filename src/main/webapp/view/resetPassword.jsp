<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt lại mật khẩu</title>
    <link rel="stylesheet" href="path/to/bootstrap.css">
</head>
<body>
    <div class="container" style="max-width: 500px; margin-top: 50px;">
        <h2>Đặt lại mật khẩu</h2>

        <c:if test="${message != null}">
            <div class="alert alert-info">${message}</div>
        </c:if>

        <form action="reset-password" method="post">
            <input type="hidden" name="token" value="${param.token}" />

            <div class="form-group">
                <label for="newPassword">Mật khẩu mới:</label>
                <input type="password" name="newPassword" id="newPassword" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-success">Xác nhận</button>
        </form>
    </div>
</body>
</html>