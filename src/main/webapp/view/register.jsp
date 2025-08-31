<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .register-container {
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            width: 400px;
        }
        .register-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .input-group {
            margin-bottom: 15px;
            display: flex;
            align-items: center;
        }
        .input-group span {
            padding: 10px;
            background: #eee;
            border: 1px solid #ccc;
            border-right: none;
        }
        .input-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
        }
        .btn {
            width: 100%;
            padding: 10px;
            background: #28a745;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background: #218838;
        }
        .alert {
            color: red;
            margin-bottom: 15px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Tạo tài khoản mới</h2>
        
        <c:if test="${alert != null}">
            <div class="alert">${alert}</div>
        </c:if>

        <form action="register" method="post">
            <div class="input-group">
                <span><i class="fa fa-user"></i></span>
                <input type="text" name="username" placeholder="Tài khoản" required>
            </div>
            <div class="input-group">
                <span><i class="fa fa-lock"></i></span>
                <input type="password" name="password" placeholder="Mật khẩu" required>
            </div>
            <div class="input-group">
                <span><i class="fa fa-envelope"></i></span>
                <input type="email" name="email" placeholder="Email" required>
            </div>
            <div class="input-group">
                <span><i class="fa fa-id-card"></i></span>
                <input type="text" name="fullname" placeholder="Họ và tên" required>
            </div>
            <div class="input-group">
                <span><i class="fa fa-phone"></i></span>
                <input type="text" name="phone" placeholder="Số điện thoại" required>
            </div>

            <button type="submit" class="btn">Đăng ký</button>
        </form>
    </div>
</body>
</html>
