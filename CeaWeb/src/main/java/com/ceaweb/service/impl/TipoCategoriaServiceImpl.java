package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.ITipoCategoriaDAO;
import com.ceaweb.model.TipoCategoria;
import com.ceaweb.service.ITipoCategoriaService;

@Named
@RequestScoped
public class TipoCategoriaServiceImpl implements ITipoCategoriaService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ITipoCategoriaDAO TipoCategoriaDAO;

	@Override
	public void registrar(TipoCategoria entidad) throws Exception {
		
		TipoCategoriaDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(TipoCategoria entidad) throws Exception {
		
		TipoCategoriaDAO.modificar(entidad);
		
	}

	@Override
	public List<TipoCategoria> listarTodos() throws Exception {
		
		return TipoCategoriaDAO.listarTodos();
	}

	@Override
	public TipoCategoria listarPorId(TipoCategoria entidad) throws Exception {
		
		return TipoCategoriaDAO.listarPorId(entidad);
	}

}
