package br.com.lhmatos.service;

public interface BaseService<T> {
	T create(T dto);
	T read(String id);
	T update(T dto);
	boolean delete(String id);
}
