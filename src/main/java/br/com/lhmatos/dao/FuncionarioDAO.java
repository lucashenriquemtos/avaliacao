package br.com.lhmatos.dao;

import br.com.lhmatos.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class FuncionarioDAO extends BaseDAO<Funcionario> {
	@Override
	public Funcionario create(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario(cd_funcionario, nm_funcionario) VALUES (?,?)";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, funcionario.getCdFuncionario());
			stmt.setString(2, funcionario.getNmFuncionario());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return funcionario;
	}

	@Override
	public Optional<Funcionario> findById(String id) {
		return Optional.empty();
	}

	@Override
	public Funcionario update(Funcionario funcionario) {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}
}
