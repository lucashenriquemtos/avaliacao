package br.com.lhmatos.action;

import br.com.lhmatos.dto.ExameDTO;
import br.com.lhmatos.webservice.ExameServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ExameAction extends ActionSupport {

	private ExameServiceImpl exameService;
	private ExameDTO exameDTO;
	private List<ExameDTO> exames;

	public void setExameService(ExameServiceImpl exameService) {
		this.exameService = exameService;
	}

	public ExameDTO getExameDTO() {
		return exameDTO;
	}

	public void setExameDTO(ExameDTO exameDTO) {
		this.exameDTO = exameDTO;
	}

	public List<ExameDTO> getExames() {
		return exames;
	}

	public void setExames(List<ExameDTO> exames) {
		this.exames = exames;
	}

	public String input() {
		exameDTO = new ExameDTO();
		return INPUT;
	}

	public String create() {
		try {
			ExameDTO createdExameDTO = exameService.create(exameDTO);
			if (createdExameDTO != null) {
				addActionMessage("Exame criado com sucesso!");
				return SUCCESS;
			} else {
				addActionError("Não foi possível criar o exame. Verifique os dados e tente novamente.");
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao criar o exame. Por favor, tente novamente mais tarde.");
			return ERROR;
		}
	}

	public String edit() {
		try {
			exameDTO = exameService.findById(exameDTO.getCdExame().toString());
			if (exameDTO != null) {
				return SUCCESS;
			} else {
				addActionError("Exame não encontrado.");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao carregar os dados do exame. Por favor, tente novamente mais tarde.");
			return ERROR;
		}
	}

	public String update() {
		try {
			ExameDTO updatedExameDTO = exameService.update(exameDTO);
			if (updatedExameDTO != null) {
				addActionMessage("Exame atualizado com sucesso!");
				return SUCCESS;
			} else {
				addActionError("Não foi possível atualizar o exame. Verifique os dados e tente novamente.");
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao atualizar o exame. Por favor, tente novamente mais tarde.");
			return ERROR;
		}
	}

	public String delete() {
		try {
			boolean deleted = exameService.deleteByLogin(exameDTO.getCdExame().toString());
			if (deleted) {
				addActionMessage("Exame excluído com sucesso!");
				return SUCCESS;
			} else {
				addActionError("Não foi possível excluir o exame. Verifique os dados e tente novamente.");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao excluir o exame. Por favor, tente novamente mais tarde.");
			return ERROR;
		}
	}
}
