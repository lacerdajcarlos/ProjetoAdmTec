package livraria.servlet;

import java.sql.Connection;
//Metodo
import java.sql.*;
import java.util.Properties;

public class TestBD {
	// The JDBC Connector Class.
	private static final String dbClassName = "com.mysql.jdbc.Driver";

	// Connection string. emotherearth is the database the program
	// is connecting to. You can include user and password after this
	// by adding (say) ?user=paulr&password=paulr. Not recommended!

	private static final String CONNECTION = "jdbc:mysql://localhost/DB_LIVRARIA";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(dbClassName);
		// Class.forName(xxx) loads the jdbc classes and
		// creates a drivermanager class factory
		Class.forName(dbClassName);

		// Properties for user and password. Here the user and password are both 'paulr'
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "123456");

		// Now try to connect
		Connection c = DriverManager.getConnection(CONNECTION, p);

		System.out.println("Conectado!");
		c.close();
	}
}