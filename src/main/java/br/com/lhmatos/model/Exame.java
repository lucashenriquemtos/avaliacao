package br.com.lhmatos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exame {

	@NonNull
	private Integer cdExame;
	private String nmExame;
	@NonNull
	private Boolean icAtivo;
	private String dsDetalheExame;
	private String dsDetalheExame1;
}
