package com.ceaweb.dao;

import com.ceaweb.model.Usuario;

/**
 * 
 * @author crismetal
 *
 */
public interface IUsuarioDAO extends IDAO<Usuario> {

	Usuario iniciarSesion(String identificacion, String clave) throws Exception ;
}
