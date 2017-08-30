package com.ceaweb.service;

import java.util.List;

/**
 * 
 * @author crismetal
 * 
 * Service generico con operaciones basicas (CRUD)
 *
 * @param <T> tipo de Objecto de la entidad
 */
public interface IService<T> {

	void registrar(T entidad) throws Exception;	
	void modificar(T entidad) throws Exception;
	List<T> listarTodos() throws Exception;
	T listarPorId(T entidad) throws Exception;
}

