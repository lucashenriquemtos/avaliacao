package br.com.lhmatos.service;

import br.com.lhmatos.dao.UsuarioDAO;
import br.com.lhmatos.dto.UsuarioDTO;
import br.com.lhmatos.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioDAO usuarioDAO;

	public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public UsuarioDTO create(UsuarioDTO usuarioDTO) {

		if (usuarioDTO.getQtTempoInatividade() < 1 || usuarioDTO.getQtTempoInatividade() > 90) {
			throw new IllegalArgumentException("O tempo de inatividade deve ser entre 1 e 90 minutos");
		}

		String hashedPassword = BCrypt.hashpw(usuarioDTO.getDsSenha(), BCrypt.gensalt());
		usuarioDTO.setDsSenha(hashedPassword);

		Usuario usuario = usuarioDTO.toUsuario();
		usuario = usuarioDAO.create(usuario);

		if (usuario == null) {
			throw new RuntimeException("Não foi possível criar o usuário");
		}

		UsuarioDTO createdUsuarioDTO = UsuarioDTO.fromUsuario(usuario);
		return createdUsuarioDTO;
	}

	@Override
	public UsuarioDTO read(String id) {
		return null;
	}

	@Override
	public UsuarioDTO update(UsuarioDTO usuarioDTO) {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}
}
