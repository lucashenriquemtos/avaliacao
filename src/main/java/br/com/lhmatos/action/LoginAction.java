package br.com.lhmatos.action;

import br.com.lhmatos.dto.UsuarioDTO;
import br.com.lhmatos.webservice.UsuarioServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;
import java.util.Optional;

public class LoginAction extends ActionSupport implements SessionAware {

	private UsuarioServiceImpl usuarioService;
	private String login;
	private String password;
	private Map<String, Object> session;

	public void setUsuarioService(UsuarioServiceImpl usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String execute() {
		try {
			Optional<UsuarioDTO> usuarioDTO = usuarioService.login(login, password);

			if (usuarioDTO.isPresent()) {
				session.put("usuarioLogado", usuarioDTO.get());
				return SUCCESS;
			}
		} catch (IllegalArgumentException ex) {
			addActionError(getText("error.login"));
		}

		return INPUT;
	}

	public String logout() {
		session.remove("usuarioLogado");
		return SUCCESS;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
