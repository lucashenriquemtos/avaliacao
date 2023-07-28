package br.com.lhmatos.dao;

import br.com.lhmatos.model.ExameRealizado;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class ExameRealizadoDAO extends BaseDAO<ExameRealizado> {
	@Override
	public ExameRealizado create(ExameRealizado exameRealizado) {
		String sql = "INSERT INTO exame_realizado(cd_funcionario, cd_exame, dt_realizacao) VALUES (?, ?, ?)";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, exameRealizado.getCdFuncionario());
			stmt.setInt(2, exameRealizado.getCdExame());
			stmt.setDate(3, Date.valueOf(exameRealizado.getDtRealizacao()));
			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return exameRealizado;
	}

	@Override
	public Optional<ExameRealizado> findById(String id) {
		throw new UnsupportedOperationException("Essa operação não é suportada.");
	}

	@Override
	public ExameRealizado update(ExameRealizado exameRealizado) {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}
}
