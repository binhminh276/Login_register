package login_register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
	@Override
    public User get(String username, String password) {
        String sql = "SELECT * FROM [User] WHERE Username = ? AND Password = ?";
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("ID"));
                    user.setEmail(rs.getString("Email"));
                    user.setUserName(rs.getString("Username"));
                    user.setPassWord(rs.getString("Password"));
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
