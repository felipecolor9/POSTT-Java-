package br.com.felipe.projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.felipe.projeto.controller.ConnectionFactory;

public class PostitDAO implements DAO<Postit> {

	@Override
	public boolean save(Postit p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("INSERT INTO postits (fk_id_usuario, postit_nome, postit_conteudo) values (?,?,?)");
			stm.setInt(1, p.getIdUser());
			stm.setString(2, p.getName());
			stm.setString(3, p.getDesc());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante adição: ", e);
		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}
		return true;
	}

	@Override
	public boolean update(Postit p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("UPDATE postit SET postit_nome=?, postit_conteudo=?");
			stm.setString(1, p.getName());
			stm.setString(2, p.getDesc());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante modificação: ", e);

		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}
		return true;
	}

	@Override
	public boolean delete(Postit p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("DELETE FROM WHERE id=?");
			stm.setInt(1, p.getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante exclusão: ", e);

		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}
		return true;
	}

	@Override
	public ArrayList<Postit> findAll() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Postit> postList = new ArrayList<>();

		try {
			stm = con.prepareStatement("SELECT * FROM postits");
			rs = stm.executeQuery();

			while (rs.next()) {
				Postit p = new Postit();
				p.setId(rs.getInt("id"));
				p.setIdUser(rs.getInt("fk_id_usuario"));
				p.setName(rs.getString("postit_nome"));
				p.setDesc(rs.getString("postit_conteudo"));
				postList.add(p);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante leitura da tabela: ", e);
		} finally {
			ConnectionFactory.closeConnection(con, stm, rs);
		}
		return postList;
	}

	@Override
	public Postit findbyID(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		Postit p = new Postit();

		try {
			stm = con.prepareStatement("SELECT FROM postits WHERE id=?");
			stm.setInt(1, id);
			rs = stm.executeQuery();
			p.setId(rs.getInt("id"));
			p.setIdUser(rs.getInt("fk_id_usuario"));
			p.setName(rs.getString("postit_nome"));
			p.setDesc(rs.getString("postit_conteudo"));
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante leitura da tabela: ", e);
		} finally {
			ConnectionFactory.closeConnection(con, stm, rs);
		}
		return p;
	}

	public ArrayList<Postit> findbyUserID(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Postit> list = new ArrayList<>();

		try {
			stm = con.prepareStatement("SELECT * FROM postits WHERE fk_id_usuario=?");
			stm.setInt(1, id);
			rs = stm.executeQuery();

			while (rs.next()) {
				
				Postit p = new Postit();
				p.setId(rs.getInt("id"));
				p.setIdUser(rs.getInt("fk_id_usuario"));
				p.setName(rs.getString("postit_nome"));
				p.setDesc(rs.getString("postit_conteudo"));
				list.add(p);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro interno do banco durante leitura da tabela: ", e);
		} finally {
			ConnectionFactory.closeConnection(con, stm, rs);
		}
		return list;
	}
}
