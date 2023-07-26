package br.com.lhmatos.dao;

import br.com.lhmatos.dto.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends BaseDAO<UsuarioDTO> {

	@Override
	public UsuarioDTO create(UsuarioDTO usuarioDTO) {
		String sql = "INSERT INTO usuario (nm_login, ds_senha, qt_tempo_inatividade) VALUES (?, ?, ?)";
		try (Connection conn = getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, usuarioDTO.getNmLogin());
			stmt.setString(2, usuarioDTO.getDsSenha());
			stmt.setInt(3, usuarioDTO.getQtTempoInatividade());
			int affectedRows = stmt.executeUpdate();
			if (affectedRows > 0) {
				return usuarioDTO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object read(String id) {
		return null;
	}

	@Override
	public Object update(Object o) {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}
}
