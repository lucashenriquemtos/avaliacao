package br.com.lhmatos.action;

import br.com.lhmatos.dto.ExameRealizadoDTO;
import br.com.lhmatos.webservice.ExameRealizadoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.time.LocalDate;
import java.util.List;

public class ExameRealizadoAction extends ActionSupport {

	private ExameRealizadoServiceImpl exameRealizadoService;
	private ExameRealizadoDTO exameRealizadoDTO;
	private List<ExameRealizadoDTO> examesRealizados;
	private LocalDate startDate;
	private LocalDate endDate;

	public void setExameRealizadoService(ExameRealizadoServiceImpl exameRealizadoService) {
		this.exameRealizadoService = exameRealizadoService;
	}

	public ExameRealizadoDTO getExameRealizadoDTO() {
		return exameRealizadoDTO;
	}

	public void setExameRealizadoDTO(ExameRealizadoDTO exameRealizadoDTO) {
		this.exameRealizadoDTO = exameRealizadoDTO;
	}

	public List<ExameRealizadoDTO> getExamesRealizados() {
		return examesRealizados;
	}

	public void setExamesRealizados(List<ExameRealizadoDTO> examesRealizados) {
		this.examesRealizados = examesRealizados;
	}

	public String input() {
		exameRealizadoDTO = new ExameRealizadoDTO();
		return INPUT;
	}

	public String create() {
		try {
			ExameRealizadoDTO createdExameRealizadoDTO = exameRealizadoService.create(exameRealizadoDTO);
			if (createdExameRealizadoDTO != null) {
				addActionMessage("Exame realizado criado com sucesso!");
				return SUCCESS;
			} else {
				addActionError("Não foi possível criar o exame realizado. Verifique os dados e tente novamente.");
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao criar o exame realizado. Por favor, tente novamente mais tarde.");
			return ERROR;
		}
	}

	public String edit() {
		try {
			exameRealizadoDTO = exameRealizadoService.findById(String.valueOf(exameRealizadoDTO.getCdExame()));
			if (exameRealizadoDTO != null) {
				return SUCCESS;
			} else {
				addActionError("Exame realizado não encontrado.");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao carregar os dados do exame realizado. Por favor, tente novamente mais tarde.");
			return ERROR;
		}
	}

	public String update() {
		try {
			ExameRealizadoDTO updatedExameRealizadoDTO = exameRealizadoService.update(exameRealizadoDTO);
			if (updatedExameRealizadoDTO != null) {
				addActionMessage("Exame realizado atualizado com sucesso!");
				return SUCCESS;
			} else {
				addActionError("Não foi possível atualizar o exame realizado. Verifique os dados e tente novamente.");
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao atualizar o exame realizado. Por favor, tente novamente mais tarde.");
			return ERROR;
		}
	}

	public String delete() {
		try {
			boolean deleted = exameRealizadoService.delete(String.valueOf(exameRealizadoDTO.getCdExame()));
			if (deleted) {
				addActionMessage("Exame realizado excluído com sucesso!");
				return SUCCESS;
			} else {
				addActionError("Não foi possível excluir o exame realizado. Verifique os dados e tente novamente.");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao excluir o exame realizado. Por favor, tente novamente mais tarde.");
			return ERROR;
		}
	}

	public String search() {
		try {
			examesRealizados = exameRealizadoService.findExamesRealizadosBetweenDates(startDate, endDate);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao buscar os exames realizados. Por favor, tente novamente mais tarde.");
			return ERROR;
		}
	}
}
