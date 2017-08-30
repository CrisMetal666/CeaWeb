package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.ITipoEstadoDAO;
import com.ceaweb.model.TipoEstado;
import com.ceaweb.service.ITipoEstadoService;

@Named
@RequestScoped
public class TipoEstadoServiceImpl implements ITipoEstadoService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ITipoEstadoDAO TipoEstadoDAO;

	@Override
	public void registrar(TipoEstado entidad) throws Exception {
		
		TipoEstadoDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(TipoEstado entidad) throws Exception {
		
		TipoEstadoDAO.modificar(entidad);
		
	}

	@Override
	public List<TipoEstado> listarTodos() throws Exception {
		
		return TipoEstadoDAO.listarTodos();
	}

	@Override
	public TipoEstado listarPorId(TipoEstado entidad) throws Exception {
		
		return TipoEstadoDAO.listarPorId(entidad);
	}

}
