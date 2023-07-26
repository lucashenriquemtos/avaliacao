package br.com.lhmatos;

import br.com.lhmatos.dao.UsuarioDAO;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.testConnection()) {
			System.out.println("A conexão com o banco de dados foi estabelecida com sucesso!");
		} else {
			System.out.println("Não foi possível estabelecer uma conexão com o banco de dados.");
		}
	}
}