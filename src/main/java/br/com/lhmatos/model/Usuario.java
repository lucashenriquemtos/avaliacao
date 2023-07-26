package br.com.lhmatos.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	private String nmLogin;
	private String dsSenha;

	@Min(1)
	@Max(90)
	private Integer qtTempoInatividade;


}
