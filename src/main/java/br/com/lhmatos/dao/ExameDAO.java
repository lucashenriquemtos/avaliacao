package br.com.lhmatos.dao;

import br.com.lhmatos.model.Exame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ExameDAO extends BaseDAO<Exame> {

	@Override
	public Exame create(Exame exame) {
		String sql = "INSERT INTO exame (cd_exame, nm_exame, ic_ativo, ds_detalhe_exame, ds_detalhe_exame1) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, exame.getCdExame());
			stmt.setString(2, exame.getNmExame());
			stmt.setBoolean(3, exame.getIcAtivo());
			stmt.setString(4, exame.getDsDetalheExame());
			stmt.setString(5, exame.getDsDetalheExame1());
			stmt.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return exame;
	}

	@Override
	public Optional<Exame> findById(String id) {
		Optional<Exame> exameOptional = Optional.empty();
		String sql = "SELECT * FROM exame WHERE cd_exame = ?";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Exame exame = new Exame(
						rs.getInt("cd_exame"),
						rs.getString("nm_exame"),
						rs.getBoolean("ic_ativo"),
						rs.getString("ds_detalhe_exame"),
						rs.getString("ds_detalhe_exame1")
				);
				exameOptional = Optional.of(exame);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return exameOptional;
	}

	@Override
	public Exame update(Exame exame) {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}
}
