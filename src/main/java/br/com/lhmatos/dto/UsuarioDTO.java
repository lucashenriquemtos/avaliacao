package br.com.lhmatos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDTO {

	private String nmLogin;
	private String dsSenha;
	private Integer qtTempoInatividade;
}
