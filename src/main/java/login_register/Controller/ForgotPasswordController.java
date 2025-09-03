package login_register.Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login_register.UserService;
import login_register.UserServiceImpl;

@WebServlet("/forgotPassword")

public class ForgotPasswordController extends HttpServlet {
	private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        boolean success = userService.sendResetPasswordEmail(email);

        if (success) {
            request.setAttribute("message", "Liên kết đặt lại mật khẩu đã được gửi đến email.");
        } else {
            request.setAttribute("message", "Email không tồn tại trong hệ thống.");
        }

        response.sendRedirect(request.getContextPath() + "/view/forgotPassword.jsp");
    }

}
