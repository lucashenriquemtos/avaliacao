package br.com.lhmatos.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

	private String nmLogin;
	private String dsSenha;
	private Integer qtTempoInatividade;
}
