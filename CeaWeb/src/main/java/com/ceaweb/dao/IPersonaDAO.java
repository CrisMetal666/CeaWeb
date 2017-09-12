package com.ceaweb.dao;

import com.ceaweb.model.Persona;

/**
 * 
 * @author crismetal
 *
 */
public interface IPersonaDAO extends IDAO<Persona> {

	/**
	 * 
	 * Se encargara de buscar la persona que tenga la identificacion especificada y
	 * en el Cea correspondiente
	 * 
	 * @param per llevara la informacion necesaria para la busqueda (identificacion y Cea)
	 * 
	 * @return persona que cumpla con las condiciones
	 */
	Persona buscarPorIdentificacion(Persona per) throws Exception ;
}
