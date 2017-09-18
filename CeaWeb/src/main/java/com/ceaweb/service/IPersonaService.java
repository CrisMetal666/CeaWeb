package com.ceaweb.service;

import java.util.List;

import com.ceaweb.model.Persona;

public interface IPersonaService extends IService<Persona> {

	Persona buscarPorIdentificacion(Persona per) throws Exception ;
	List<Persona> buscarPorNombreApellidoIdentificacion(String busqueda, int idcea) throws Exception ;
}
