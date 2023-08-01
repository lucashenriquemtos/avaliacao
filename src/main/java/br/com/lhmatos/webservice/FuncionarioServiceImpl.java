package br.com.lhmatos.webservice;

import br.com.lhmatos.dao.FuncionarioDAO;
import br.com.lhmatos.dto.FuncionarioDTO;
import br.com.lhmatos.model.Funcionario;
import jakarta.jws.WebService;

import java.util.Optional;

@WebService
public class FuncionarioServiceImpl implements FuncionarioService {

	private FuncionarioDAO funcionarioDAO;
	public FuncionarioServiceImpl() { }

	public FuncionarioServiceImpl(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}
	@Override
	public FuncionarioDTO create(FuncionarioDTO dto) {
		try {

			Funcionario funcionario = dto.toFuncionario();
			Funcionario createdFuncionario = funcionarioDAO.create(funcionario);
			if (createdFuncionario != null) {
				return FuncionarioDTO.fromFuncionario(createdFuncionario);
			}
		} catch (Exception e) {
			e.printStackTrace();

			throw new RuntimeException("Erro ao criar funcionário");
		}
		return null;
	}

	@Override
	public FuncionarioDTO findById(String id) {
		try {
			Optional<Funcionario> funcionario = funcionarioDAO.findById(id);
			if (funcionario.isPresent()){
				return FuncionarioDTO.fromFuncionario(funcionario.get());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar funcionário por ID");
		}
		return null;
	}

	@Override
	public FuncionarioDTO update(FuncionarioDTO dto) {
		try {

			Funcionario funcionario = dto.toFuncionario();
			Funcionario updatedFuncionario = funcionarioDAO.update(funcionario);
			if (updatedFuncionario != null) {
				return FuncionarioDTO.fromFuncionario(updatedFuncionario);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao atualizar funcionário");
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		try {
			return funcionarioDAO.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao excluir funcionário");
		}
	}
}
