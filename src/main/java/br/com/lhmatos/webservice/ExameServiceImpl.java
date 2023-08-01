package br.com.lhmatos.webservice;

import br.com.lhmatos.dao.ExameDAO;
import br.com.lhmatos.dto.ExameDTO;
import br.com.lhmatos.model.Exame;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebService
public class ExameServiceImpl implements ExameService {

	private ExameDAO exameDAO = new ExameDAO();

	public ExameServiceImpl() { }

	public ExameServiceImpl(ExameDAO exameDAO) { this.exameDAO = exameDAO; }

	@Override
	public ExameDTO create(ExameDTO dto) {
		try {
			Exame exame = dto.toExame();
			Exame createdExame = exameDAO.create(exame);
			if(createdExame != null) {
				return ExameDTO.fromExame(createdExame);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ExameDTO findById(String id) {
		try {
			Optional<Exame> exameOptional = exameDAO.findById(id);
			if(exameOptional.isPresent()) {
				return ExameDTO.fromExame(exameOptional.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ExameDTO update(ExameDTO dto) {
		try {
			Exame exame = dto.toExame();
			Exame updatedExame = exameDAO.update(exame);
			if(updatedExame != null) {
				return ExameDTO.fromExame(updatedExame);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteByLogin(String id) {
		try {
			return exameDAO.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ExameDTO> findByCdOrNmOrIc(String cdExame, String nmExame, boolean icAtivo) {
		List<ExameDTO> exameDTOs = new ArrayList<>();
		List<Exame> exames = exameDAO.findByCdOrNmOrIc(cdExame, nmExame, icAtivo);

		for (Exame exame : exames) {
			exameDTOs.add(ExameDTO.fromExame(exame));
		}

		return exameDTOs;
	}
}
