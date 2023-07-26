package br.com.lhmatos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO<T> {

	private static final String URL = "jdbc:mysql://localhost:3306/avaliacao?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysecretpassword";

	protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	public abstract T create(T t);

	public abstract T getById(String id);

	public abstract T update(T t);

	public abstract boolean delete(String id);

	public boolean testConnection() {
		try (Connection connection = getConnection()) {
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
