package com.ceaweb.service;

import com.ceaweb.model.Persona;

public interface IPersonaService extends IService<Persona> {

	Persona buscarPorIdentificacion(Persona per) throws Exception ;
}
