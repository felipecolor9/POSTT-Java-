
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
			stm = con.prepareStatement("INSERT INTO users(nome_completo, usuario_conta, usuario_senha) values(?,?,?)");
			stm.setString(1, u.getCompleteName());
			stm.setString(2, u.getUsername());
			stm.setString(3, u.getPassword());
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
			stm = con.prepareStatement("UPDATE users SET nome_completo=?, usuario_conta=?, usuario_senha=?");
			stm.setString(1, u.getCompleteName());
			stm.setString(2, u.getUsername());
			stm.setString(3, u.getPassword());
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
			stm.setInt(1, u.getId());
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
				u.setId(rs.getInt("id"));
				u.setCompleteName(rs.getString("nome_completo"));
				u.setUsername(rs.getString("usuario_conta"));
				u.setPassword(rs.getString("usuario_senha"));
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
			u.setId(rs.getInt("id"));
			u.setCompleteName(rs.getString("nome_completo"));
			u.setUsername(rs.getString("usuario_conta"));
			u.setPassword(rs.getString("usuario_senha"));
		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante leitura da tabela: ", e);
		} finally {
			ConnectionFactory.closeConnection(con, stm, rs);
		}
		return u;
	}

	public int findId(String username) {
		int id = 0;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = con.prepareStatement("SELECT id FROM users WHERE usuario_conta=?");
			stm.setString(1, username);
			rs = stm.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante busca por id: ", e);
		} finally {
			ConnectionFactory.closeConnection(con, stm, rs);
		}
		return id;
	}

}