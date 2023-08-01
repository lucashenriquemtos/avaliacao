package br.com.lhmatos.webservice;

import br.com.lhmatos.dao.ExameRealizadoDAO;
import br.com.lhmatos.dto.ExameRealizadoDTO;
import br.com.lhmatos.model.ExameRealizado;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.time.LocalDate;
import java.util.List;

@WebService
public class ExameRealizadoServiceImpl implements ExameRealizadoService {

	private ExameRealizadoDAO exameRealizadoDAO = new ExameRealizadoDAO();

	@Override
	@WebMethod
	public ExameRealizadoDTO create(ExameRealizadoDTO dto) {
		try {
			ExameRealizado exameRealizado = dto.toExameRealizado();
			ExameRealizado createdExameRealizado = exameRealizadoDAO.create(exameRealizado);
			if (createdExameRealizado != null) {
				return ExameRealizadoDTO.fromExameRealizado(createdExameRealizado);
			} else {
				throw new RuntimeException("Erro ao cadastrar exame realizado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao cadastrar exame realizado: " + e.getMessage());
		}
	}

	@WebMethod
	@Override
	public ExameRealizadoDTO findById(String id) {
		throw new UnsupportedOperationException("Essa operação não é suportada.");
	}

	@Override
	@WebMethod
	public ExameRealizadoDTO update(ExameRealizadoDTO dto) {
		try {
			ExameRealizado exameRealizado = dto.toExameRealizado();
			ExameRealizado updatedExameRealizado = exameRealizadoDAO.update(exameRealizado);
			if (updatedExameRealizado != null) {
				return ExameRealizadoDTO.fromExameRealizado(updatedExameRealizado);
			} else {
				throw new RuntimeException("Erro ao atualizar exame realizado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao atualizar exame realizado: " + e.getMessage());
		}
	}

	@Override
	@WebMethod
	public boolean delete(String id) {
		throw new UnsupportedOperationException("Essa operação não é suportada.");
	}

	@WebMethod
	@Override
	public boolean deleteByFuncionarioAndExame(Integer cdFuncionario, Integer cdExame) {
		try {
			return exameRealizadoDAO.deleteByFuncionarioAndExame(cdFuncionario, cdExame);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao excluir exame realizado.");
		}
	}

	@WebMethod
	@Override
	public List<ExameRealizadoDTO> findExamesRealizadosBetweenDates(LocalDate startDate, LocalDate endDate) {
		try {
			List<ExameRealizado> examesRealizados = exameRealizadoDAO.findExamesRealizadosBetweenDates(startDate, endDate);
			return ExameRealizadoDTO.fromListExameRealizado(examesRealizados);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar exames realizados.");
		}
	}
}