package br.com.lhmatos.dto;

import br.com.lhmatos.model.ExameRealizado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExameRealizadoDTO {
	private Integer cdFuncionario;
	private Integer cdExame;
	private LocalDate dtRealizacao;

	public ExameRealizado toExameRealizado() {
		return new ExameRealizado(cdFuncionario, cdExame, dtRealizacao);
	}

	public static ExameRealizadoDTO fromExameRealizado(ExameRealizado exameRealizado) {
		return new ExameRealizadoDTO(
				exameRealizado.getCdFuncionario(),
				exameRealizado.getCdExame(),
				exameRealizado.getDtRealizacao()
		);
	}

	public static List<ExameRealizadoDTO> fromListExameRealizado(List<ExameRealizado> examesRealizados) {
		List<ExameRealizadoDTO> dtos = new ArrayList<>();
		for (ExameRealizado exameRealizado : examesRealizados) {
			dtos.add(fromExameRealizado(exameRealizado));
		}
		return dtos;
	}
}