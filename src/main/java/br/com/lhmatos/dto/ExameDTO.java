package br.com.lhmatos.dto;

import br.com.lhmatos.model.Exame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExameDTO {

	@NonNull
	private Integer cdExame;
	private String nmExame;
	@NonNull
	private Boolean icAtivo;
	private String dsDetalheExame;
	private String dsDetalheExame1;

	public Exame toExame() {
		Exame exame = new Exame(cdExame, nmExame, icAtivo, dsDetalheExame, dsDetalheExame1);
		return exame;
	}

	public static ExameDTO fromExame(Exame exame) {
		ExameDTO dto = new ExameDTO();
		dto.setCdExame(exame.getCdExame());
		dto.setNmExame(exame.getNmExame());
		dto.setIcAtivo(exame.getIcAtivo());
		dto.setDsDetalheExame(exame.getDsDetalheExame());
		dto.setDsDetalheExame1(exame.getDsDetalheExame1());
		return dto;
	}
}

