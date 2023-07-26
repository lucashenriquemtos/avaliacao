package br.com.lhmatos.service;

public interface BaseService<T> {
	T create(T dto);
	T findById(String id);
	T update(T dto);
	boolean deleteByLogin(String id);
}
