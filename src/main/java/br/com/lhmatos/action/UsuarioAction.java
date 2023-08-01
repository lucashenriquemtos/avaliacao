package br.com.lhmatos.action;

import br.com.lhmatos.dto.UsuarioDTO;
import br.com.lhmatos.webservice.UsuarioServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class UsuarioAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

	private UsuarioServiceImpl usuarioService;
	private UsuarioDTO usuarioDTO;
	private String id;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> session;

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsuarioService(UsuarioServiceImpl usuarioService) {
		this.usuarioService = usuarioService;
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

	public String success() {
		try {
			usuarioDTO = usuarioService.findById(id);

			addActionMessage("Operação realizada com sucesso!");
			return SUCCESS;
		} catch (Exception e) {

			addActionError(e.getMessage());
			return ERROR;
		}
	}

	public String input() {
		usuarioDTO = new UsuarioDTO();
		return INPUT;
	}

	public String edit() {
		try {
			usuarioDTO = usuarioService.findById(usuarioDTO.getNmLogin());
			return SUCCESS;
		} catch (RuntimeException e) {
			addActionError(e.getMessage());
			return ERROR;
		}
	}

	public String delete() {
		try {
			usuarioService.delete(usuarioDTO.getNmLogin());
			return SUCCESS;
		} catch (RuntimeException e) {
			addActionError(e.getMessage());
			return ERROR;
		}
	}


	public String update() {
		UsuarioDTO updatedUsuarioDTO = usuarioService.update(usuarioDTO);
		if (updatedUsuarioDTO == null) {
			addActionError("A atualização do usuário falhou");
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
