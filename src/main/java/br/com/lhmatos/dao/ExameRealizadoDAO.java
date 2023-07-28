package br.com.lhmatos.dao;

import br.com.lhmatos.model.ExameRealizado;

import java.sql.*;
import java.util.Optional;

public class ExameRealizadoDAO extends BaseDAO<ExameRealizado> {
	@Override
	public ExameRealizado create(ExameRealizado exameRealizado) {
		if (isExameRealizadoExistente(exameRealizado.getCdFuncionario(), exameRealizado.getCdExame())) {
			throw new IllegalArgumentException("Não é possível cadastrar o exame, pois ele já foi realizado pelo funcionário.");
		}

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
		String sql = "UPDATE exame_realizado SET dt_realizacao = ? WHERE cd_funcionario = ? AND cd_exame = ?";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setDate(1, Date.valueOf(exameRealizado.getDtRealizacao()));
			stmt.setInt(2, exameRealizado.getCdFuncionario());
			stmt.setInt(3, exameRealizado.getCdExame());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return exameRealizado;
	}

	@Override
	public boolean delete(String id) {
		throw new UnsupportedOperationException("Essa operação não é suportada.");
	}

	public boolean deleteByFuncionarioAndExame(Integer cdFuncionario, Integer cdExame) {
		String sql = "DELETE FROM exame_realizado WHERE cd_funcionario = ? AND cd_exame = ?";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, cdFuncionario);
			stmt.setInt(2, cdExame);
			int affectedRows = stmt.executeUpdate();

			if (affectedRows > 0) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean isExameRealizadoExistente(Integer cdFuncionario, Integer cdExame) {
		String sql = "SELECT COUNT(*) FROM exame_realizado WHERE cd_funcionario = ? AND cd_exame = ?";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, cdFuncionario);
			stmt.setInt(2, cdExame);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					return true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
