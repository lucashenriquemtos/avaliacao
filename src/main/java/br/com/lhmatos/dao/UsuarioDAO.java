package br.com.lhmatos.dao;

import br.com.lhmatos.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends BaseDAO<Usuario> {

	@Override
	public Usuario create(Usuario usuario) {
		String sql = "INSERT INTO usuario (nm_login, ds_senha, qt_tempo_inatividade) VALUES (?, ?, ?)";
		try (Connection conn = getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNmLogin());
			stmt.setString(2, usuario.getDsSenha());
			stmt.setInt(3, usuario.getQtTempoInatividade());
			int affectedRows = stmt.executeUpdate();
			if (affectedRows > 0) {
				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario findById(String id) {
		String sql = "SELECT * FROM usuario WHERE nm_login = ?";
		try (Connection conn = getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Usuario(rs.getString("nm_login"), rs.getString("ds_senha"), rs.getInt("qt_tempo_inatividade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario findByLogin(String id) {
		String sql = "SELECT * FROM usuario WHERE nm_login = ?";
		try (Connection conn = getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Usuario(rs.getString("nm_login"), rs.getString("ds_senha"), rs.getInt("qt_tempo_inatividade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario update(Usuario usuario) {
		String sql = "UPDATE usuario SET ds_senha = ?, qt_tempo_inatividade = ? WHERE nm_login = ?";
		try (Connection conn = getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, usuario.getDsSenha());
			stmt.setInt(2, usuario.getQtTempoInatividade());
			stmt.setString(3, usuario.getNmLogin());
			int affectedRows = stmt.executeUpdate();
			if (affectedRows > 0) {
				return usuario;
			}
		} catch (SQLException e) {
			// Tratamento de exceções
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(String nmLogin) {
		String sql = "DELETE FROM usuario WHERE nm_login = ?";
		try (Connection conn = getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nmLogin);
			int affectedRows = stmt.executeUpdate();
			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
