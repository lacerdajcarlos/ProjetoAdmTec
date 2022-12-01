package livraria.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConexao() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectando ao banco de dados.");
			return DriverManager.getConnection("jdbc:mysql://localhost/DB_LIVRARIA","root","123456");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}

	}

}
