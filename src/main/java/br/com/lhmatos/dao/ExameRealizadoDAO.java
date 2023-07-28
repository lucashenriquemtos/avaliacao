package br.com.lhmatos.dao;

import br.com.lhmatos.model.ExameRealizado;

import java.util.Optional;

public class ExameRealizadoDAO extends BaseDAO<ExameRealizado> {
	@Override
	public ExameRealizado create(ExameRealizado exameRealizado) {
		return null;
	}

	@Override
	public Optional<ExameRealizado> findById(String id) {
		return Optional.empty();
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
