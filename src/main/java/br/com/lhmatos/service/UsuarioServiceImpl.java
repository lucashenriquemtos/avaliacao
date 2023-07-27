package br.com.lhmatos.service;

import br.com.lhmatos.dao.UsuarioDAO;
import br.com.lhmatos.dto.UsuarioDTO;
import br.com.lhmatos.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

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
	public UsuarioDTO findById(String id) {
		Usuario usuario = usuarioDAO.findById(id);
		return Optional.ofNullable(usuario)
				.map(UsuarioDTO::fromUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario com o ID: " + id + " não encontrado."));
	}

	@Override
	public UsuarioDTO update(UsuarioDTO usuarioDTO) {
		Usuario updatedUsuario = usuarioDAO.update(usuarioDTO.toUsuario());
		if (updatedUsuario == null) {
			throw new RuntimeException("A atualização do usuário falhou");
		}
		return UsuarioDTO.fromUsuario(updatedUsuario);
	}

	@Override
	public boolean deleteByLogin(String login) {
		UsuarioDTO usuario = this.findById(login);
		if (usuario == null) {
			throw new RuntimeException("Usuário com id " + login + " não existe");
		}
		return usuarioDAO.delete(login);
	}

	public void login(String username, String password) {
		Optional<Usuario> usuario = usuarioDAO.findByUsername(username);
		if (!usuario.isPresent()) {
			throw new IllegalArgumentException("Usuário não encontrado");
		}

		if (!BCrypt.checkpw(password, usuario.get().getDsSenha())) {
			throw new IllegalArgumentException("Senha incorreta");
		}
	}
}
