package com.ceaweb.service;

import com.ceaweb.model.Usuario;

public interface IUsuarioService extends IService<Usuario> {
	Usuario iniciarSesion(String identificacion, String clave) throws Exception;
}
