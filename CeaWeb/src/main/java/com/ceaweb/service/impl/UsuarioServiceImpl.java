package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IUsuarioDAO;
import com.ceaweb.model.Usuario;
import com.ceaweb.service.IUsuarioService;

@Named
@RequestScoped
public class UsuarioServiceImpl implements IUsuarioService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUsuarioDAO UsuarioDAO;

	@Override
	public void registrar(Usuario entidad) throws Exception {
		
		UsuarioDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(Usuario entidad) throws Exception {
		
		UsuarioDAO.modificar(entidad);
		
	}

	@Override
	public List<Usuario> listarTodos() throws Exception {
		
		return UsuarioDAO.listarTodos();
	}

	@Override
	public Usuario listarPorId(Usuario entidad) throws Exception {
		
		return UsuarioDAO.listarPorId(entidad);
	}

	@Override
	public Usuario iniciarSesion(String identificacion, String clave) throws Exception {
		
		return UsuarioDAO.iniciarSesion(identificacion, clave);
	}

}
