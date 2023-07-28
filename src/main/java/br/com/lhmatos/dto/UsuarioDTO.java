package br.com.lhmatos.dto;

import br.com.lhmatos.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private String nmLogin;
	private String dsSenha;
	private Integer qtTempoInatividade;

	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNmLogin(this.nmLogin);
		usuario.setDsSenha(this.dsSenha);
		usuario.setQtTempoInatividade(this.qtTempoInatividade);
		return usuario;
	}

	public static UsuarioDTO fromUsuario(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNmLogin(usuario.getNmLogin());
		dto.setDsSenha(usuario.getDsSenha());
		dto.setQtTempoInatividade(usuario.getQtTempoInatividade());
		return dto;
	}



}
