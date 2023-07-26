package br.com.lhmatos.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;


@Data
public class Usuario {

	private final String nmLogin;
	private final String dsSenha;

	@Min(1)
	@Max(90)
	private final Integer qtTempoInatividade;
}
