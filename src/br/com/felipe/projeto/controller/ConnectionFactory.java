
package br.com.felipe.projeto.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public ConnectionFactory() {}
	static Connection connection = null;	

	private static final String DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/PostitWebsite";
	private static final String USER = "root";
	private static final String PASS = "5922";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVE);
			return connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Falha ao obter conexão: ", e);
		}
	}

	public static String statusConnection(Connection con) {
		if (con != null) {
			return "Conectado";
		} else {
			return "Não conectado";
		}
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException("Falha ao fechar conexão: ", e);
			}
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stm) {
		closeConnection(con);
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				throw new RuntimeException("Falha ao fechar 'statement': ",e);
			}
		}
	}
	public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs) {
		closeConnection(con, stm);
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException("Falha ao fechar 'Result set': ",e);
			}
		}
	}
}
