package br.com.lhmatos.webservice;

import br.com.lhmatos.dto.ExameDTO;

import java.util.List;

public interface ExameService extends BaseService<ExameDTO> {
	List<ExameDTO> findByCdOrNmOrIc(String cdExame, String nmExame, boolean icAtivo);
}

