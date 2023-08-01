package br.com.lhmatos.action;

import br.com.lhmatos.dto.UsuarioDTO;
import br.com.lhmatos.webservice.UsuarioServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UsuarioAction extends ActionSupport {

	private UsuarioServiceImpl usuarioService;
	private UsuarioDTO usuarioDTO;


	public void setUsuarioService(UsuarioServiceImpl usuarioService) {
		this.usuarioService = usuarioService;
	}

	// Getters and setters
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public String create() {
		try {
			usuarioService.create(usuarioDTO);
			return SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
			return ERROR;
		}
	}

	public String execute() {

		return SUCCESS;
	}

}
