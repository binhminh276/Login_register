package login_register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public User get(String username, String password) {
		String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
		try (Connection conn = new DBConnection().getConnection(); 
		     PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("email"));
					user.setUserName(rs.getString("username"));
					user.setFullName(rs.getString("fullname"));
					user.setPassWord(rs.getString("password"));
					user.setAvatar(rs.getString("avatar"));
					user.setRoleid(rs.getInt("roleid"));
					user.setPhone(rs.getString("phone"));
					user.setCreatedDate(rs.getDate("createdDate"));
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(User user) {
		String sql = "INSERT INTO Users(email, username, fullname, password, avatar, roleid, phone, createdDate) VALUES (?,?,?,?,?,?,?,?)";
		try (Connection conn = new DBConnection().getConnection();
			     PreparedStatement ps = conn.prepareStatement(sql)) {

			    ps.setString(1, user.getEmail());
			    ps.setString(2, user.getUserName());
			    ps.setString(3, user.getFullName());
			    ps.setString(4, user.getPassWord());
			    ps.setString(5, user.getAvatar());
			    ps.setInt(6, user.getRoleid());
			    ps.setString(7, user.getPhone());

			    if (user.getCreatedDate() != null) {
			        ps.setDate(8, new java.sql.Date(user.getCreatedDate().getTime()));
			    } else {
			        ps.setDate(8, new java.sql.Date(System.currentTimeMillis())); // fallback
			    }

			    ps.executeUpdate();
			} catch (Exception e) {
			    e.printStackTrace();
			}


	}

	@Override
	public boolean checkExistEmail(String email) {
		String query = "SELECT 1 FROM Users WHERE email = ?";
		try (Connection conn = new DBConnection().getConnection(); 
		     PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		String query = "SELECT 1 FROM Users WHERE username = ?";
		try (Connection conn = new DBConnection().getConnection(); 
		     PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		String query = "SELECT 1 FROM Users WHERE phone = ?";
		try (Connection conn = new DBConnection().getConnection(); 
		     PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, phone);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
