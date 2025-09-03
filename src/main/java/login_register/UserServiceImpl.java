package login_register;

import java.sql.Timestamp;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public User login(String username, String password) {
        return userDao.get(username, password);
    }

    @Override
    public boolean register(User user) {
        try {
            userDao.insert(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }
    
    @Override
    public boolean sendResetPasswordEmail(String email) {
        User user = userDao.findByEmail(email);
        if (user == null) return false;

        String token = UUID.randomUUID().toString();
        Timestamp expiry = new Timestamp(System.currentTimeMillis() + 15 * 60 * 1000); // 15 phút

        boolean saved = userDao.saveResetToken(user.getId(), token, expiry);
        if (!saved) return false;

        String resetLink = "http://localhost:8080/login_register/view/resetPassword.jsp?token=" + token;
        String subject = "Đặt lại mật khẩu";
        String body = "Nhấn vào liên kết sau để đặt lại mật khẩu: " + resetLink;

        return EmailUtil.sendEmail(email, subject, body);
    }
    
    @Override
    public boolean resetPassword(String token, String newPassword) {
        User user = userDao.findByResetToken(token);
        if (user == null) return false;
        return userDao.updatePassword(user.getId(), newPassword);
    }
}
