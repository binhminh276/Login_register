package login_register;

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
}
