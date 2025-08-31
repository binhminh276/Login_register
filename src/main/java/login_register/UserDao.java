package login_register;

public interface UserDao {
	 User get(String username, String password);
	 void insert(User user);
	 boolean checkExistEmail(String email);
	 boolean checkExistUsername(String username);
	 boolean checkExistPhone(String phone);


}
