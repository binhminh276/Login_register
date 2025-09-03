package login_register.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private final String serverName = "localhost";
	private final String dbName = "Web";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "123456";

	public Connection getConnection() throws Exception {

		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber
				+ ";encrypt=true;trustServerCertificate=true" + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";encrypt=true;trustServerCertificate=true"
		+";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);

	}
}
