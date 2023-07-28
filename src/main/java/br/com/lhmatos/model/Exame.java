package br.com.lhmatos.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Exame {

	@NonNull
	private Integer cdExame;
	private String nmExame;
	@NonNull
	private Boolean icAtivo;
	private String dsDetalheExame;
	private String dsDetalheExame1;
}
