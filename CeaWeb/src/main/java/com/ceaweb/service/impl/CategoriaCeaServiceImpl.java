package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.ICategoriaCeaDAO;
import com.ceaweb.model.CategoriaCea;
import com.ceaweb.service.ICategoriaCeaService;

@Named
@RequestScoped
public class CategoriaCeaServiceImpl implements ICategoriaCeaService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICategoriaCeaDAO CategoriaCeaDAO;

	@Override
	public void registrar(CategoriaCea entidad) throws Exception {
		
		CategoriaCeaDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(CategoriaCea entidad) throws Exception {
		
		CategoriaCeaDAO.modificar(entidad);
		
	}

	@Override
	public List<CategoriaCea> listarTodos() throws Exception {
		
		return CategoriaCeaDAO.listarTodos();
	}

	@Override
	public CategoriaCea listarPorId(CategoriaCea entidad) throws Exception {
		
		return CategoriaCeaDAO.listarPorId(entidad);
	}

}
