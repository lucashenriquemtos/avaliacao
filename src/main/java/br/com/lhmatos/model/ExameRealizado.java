package br.com.lhmatos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExameRealizado {
	private Integer cdFuncionario;
	private Integer cdExame;
	private LocalDate dtRealizacao;
}
