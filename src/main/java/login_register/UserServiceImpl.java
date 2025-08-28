package login_register;

public class UserServiceImpl {

	private UserDao userDao = new UserDaoImpl();

    public User login(String username, String password) {
        return userDao.get(username, password); 
    }
}
