package com.ceaweb.dao;

import java.util.List;

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
	
	/**
	 * 
	 * Buscara las personas que tengan los nombres, apellidos o numero de identificacion especificad
	 * 
	 * @param busqueda valor con el cual se quiere buscar concordancia con nombres, apellidos o identificacion
	 * @param idcea valor que indica a que Cea pertenece la persona que se desea buscar
	 * 
	 * @return lista de persona que cumplan con las condiciones
	 * 
	 * @throws Exception
	 */
	List<Persona> buscarPorNombreApellidoIdentificacion(String busqueda, int idcea) throws Exception ;
}
