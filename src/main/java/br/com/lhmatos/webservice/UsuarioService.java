package br.com.lhmatos.webservice;

import br.com.lhmatos.dto.UsuarioDTO;

import java.util.Optional;

public interface UsuarioService extends BaseService<UsuarioDTO> {
	Optional<UsuarioDTO> login(String username, String password);
}
