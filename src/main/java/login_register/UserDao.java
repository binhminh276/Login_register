package login_register;

import java.sql.Timestamp;

public interface UserDao {
	 User get(String username, String password);
	 User findByEmail(String email);
	 void insert(User user);
	 boolean checkExistEmail(String email);
	 boolean checkExistUsername(String username);
	 boolean checkExistPhone(String phone);
	 User findByResetToken(String token);
	 boolean updatePassword(int userId, String newPassword);
	 boolean saveResetToken(int userId, String token, Timestamp expiry);
}
