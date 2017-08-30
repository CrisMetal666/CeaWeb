package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IGestorDAO;
import com.ceaweb.model.Gestor;
import com.ceaweb.service.IGestorService;

@Named
@RequestScoped
public class GestorServiceImpl implements IGestorService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IGestorDAO GestorDAO;

	@Override
	public void registrar(Gestor entidad) throws Exception {
		
		GestorDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(Gestor entidad) throws Exception {
		
		GestorDAO.modificar(entidad);
		
	}

	@Override
	public List<Gestor> listarTodos() throws Exception {
		
		return GestorDAO.listarTodos();
	}

	@Override
	public Gestor listarPorId(Gestor entidad) throws Exception {
		
		return GestorDAO.listarPorId(entidad);
	}

}
