package login_register.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import login_register.UserService;
import login_register.UserServiceImpl;

@WebServlet("/reset-password")
public class ResetPasswordController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = request.getParameter("token");
        String newPassword = request.getParameter("newPassword");

        boolean success = userService.resetPassword(token, newPassword);

        if (success) {
            request.setAttribute("message", "Mật khẩu đã được cập nhật thành công.");
        } else {
            request.setAttribute("message", "Liên kết không hợp lệ hoặc đã hết hạn.");
        }

        response.sendRedirect(request.getContextPath() + "/view/resetPassword.jsp");
    }
}