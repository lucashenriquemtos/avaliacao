package br.com.lhmatos.action;

import br.com.lhmatos.dto.FuncionarioDTO;
import br.com.lhmatos.webservice.FuncionarioService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;

public class FuncionarioAction extends ActionSupport {


	@Setter
	private FuncionarioService funcionarioService;

	private FuncionarioDTO funcionarioDTO;

	private int cdFuncionario;
	private String nmFuncionario;

	public String create() {
		try {
			FuncionarioDTO createdFuncionarioDTO = funcionarioService.create(funcionarioDTO);
			if (createdFuncionarioDTO != null) {
				addActionMessage("Funcionário criado com sucesso!");
				return SUCCESS;
			} else {
				addActionError("Não foi possível criar o funcionário.");
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao criar o funcionário.");
			return INPUT;
		}
	}

	public String edit() {
		try {
			funcionarioDTO = funcionarioService.findById(String.valueOf(funcionarioDTO.getCdFuncionario()));
			if (funcionarioDTO != null) {
				return SUCCESS;
			} else {
				addActionError("Funcionário não encontrado.");
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao buscar o funcionário.");
			return INPUT;
		}
	}

	public String update() {
		try {
			FuncionarioDTO updatedFuncionarioDTO = funcionarioService.update(funcionarioDTO);
			if (updatedFuncionarioDTO != null) {
				addActionMessage("Funcionário atualizado com sucesso!");
				return SUCCESS;
			} else {
				addActionError("Não foi possível atualizar o funcionário.");
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao atualizar o funcionário.");
			return INPUT;
		}
	}

	public String delete() {
		try {
			boolean deleted = funcionarioService.delete(String.valueOf(funcionarioDTO.getCdFuncionario()));
			if (deleted) {
				addActionMessage("Funcionário excluído com sucesso!");
				return SUCCESS;
			} else {
				addActionError("Não foi possível excluir o funcionário.");
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocorreu um erro ao excluir o funcionário.");
			return INPUT;
		}
	}


	public FuncionarioDTO getFuncionarioDTO() {
		return funcionarioDTO;
	}

	public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
		this.funcionarioDTO = funcionarioDTO;
	}



	public int getCdFuncionario() {
		return cdFuncionario;
	}

	public void setCdFuncionario(int cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}

	public String getNmFuncionario() {
		return nmFuncionario;
	}

	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}
}
