package br.com.lhmatos.model;

import lombok.Data;

@Data
public class Usuario {

	private final String nmLogin;
	private final String dsSenha;
	private final Integer qtTempoInatividade;
}
