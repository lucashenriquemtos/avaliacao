package br.com.lhmatos.webservice;

import br.com.lhmatos.dto.ExameRealizadoDTO;

import java.time.LocalDate;
import java.util.List;

public interface ExameRealizadoService extends BaseService<ExameRealizadoDTO> {
	boolean deleteByFuncionarioAndExame(Integer cdFuncionario, Integer cdExame);
	List<ExameRealizadoDTO> findExamesRealizadosBetweenDates(LocalDate startDate, LocalDate endDate);
}
