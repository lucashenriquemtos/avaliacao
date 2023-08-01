package br.com.lhmatos.dto;

import br.com.lhmatos.model.Funcionario;
import lombok.Data;

@Data
public class FuncionarioDTO {
	private int cdFuncionario;
	private String nmFuncionario;

	public Funcionario toFuncionario() {
		Funcionario funcionario = new Funcionario(cdFuncionario, nmFuncionario);
		return funcionario;
	}

	public static FuncionarioDTO fromFuncionario(Funcionario funcionario) {
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setCdFuncionario(funcionario.getCdFuncionario());
		dto.setNmFuncionario(funcionario.getNmFuncionario());
		return dto;
	}
}
