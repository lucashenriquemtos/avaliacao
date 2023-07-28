package br.com.lhmatos.dao;

import br.com.lhmatos.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		Optional<Funcionario> funcionarioOptional = Optional.empty();
		String sql = "SELECT * FROM funcionario WHERE cd_funcionario = ?";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Funcionario funcionario = new Funcionario(
						rs.getInt("cd_funcionario"),
						rs.getString("nm_funcionario")
				);
				funcionarioOptional = Optional.of(funcionario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return funcionarioOptional;
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
