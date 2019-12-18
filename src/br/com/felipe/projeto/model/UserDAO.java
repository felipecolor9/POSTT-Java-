
package br.com.felipe.projeto.model;

import br.com.felipe.projeto.controller.ConnectionFactory;
import br.com.felipe.projeto.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements DAO<User> {

	@Override
	public boolean save(User u) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("INSERT INTO users(conta_usuario, conta_senha) values(?,?)");
			stm.setString(1, u.getUsername());
			stm.setString(2, u.getPassword());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante adição: ", e);		
		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}
		return true;
	}

	@Override
	public boolean update(User u) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("UPDATE users SET conta_usuario=?, conta_senha=?");
			stm.setString(1, u.getUsername());
			stm.setString(2, u.getPassword());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante modificação: ", e);
		
		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}
		return true;
	}

	@Override
	public boolean delete(User u) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("DELETE FROM users WHERE id=?");
			stm.setInt(1,u.getCod());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante exclusão: ", e);
		
		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}
		return true;
	}

	@Override
	public ArrayList<User> findAll() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<>();

		try {
			stm = con.prepareStatement("SELECT * FROM users");
			rs = stm.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setCod(rs.getInt("id"));
				u.setUsername(rs.getString("conta_usuario"));
				u.setPassword(rs.getString("conta_senha"));
				userList.add(u);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante leitura da tabela: ", e);
		} finally {
			ConnectionFactory.closeConnection(con, stm, rs);
		}
		return userList;
	}

	@Override
	public User findbyID(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		User u = new User();

		try {
			stm = con.prepareStatement("SELECT FROM users WHERE id=?");
			stm.setInt(1, id);
			rs = stm.executeQuery();
			u.setCod(rs.getInt("id"));
			u.setUsername(rs.getString("conta_usuario"));
			u.setPassword(rs.getString("conta_senha"));
		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante leitura da tabela: ", e);
		} finally {
			ConnectionFactory.closeConnection(con, stm, rs);
		}
		return u;
	}

}