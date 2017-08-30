package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IEstadoDAO;
import com.ceaweb.model.Estado;
import com.ceaweb.service.IEstadoService;

@Named
@RequestScoped
public class EstadoServiceImpl implements IEstadoService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IEstadoDAO EstadoDAO;

	@Override
	public void registrar(Estado entidad) throws Exception {
		
		EstadoDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(Estado entidad) throws Exception {
		
		EstadoDAO.modificar(entidad);
		
	}

	@Override
	public List<Estado> listarTodos() throws Exception {
		
		return EstadoDAO.listarTodos();
	}

	@Override
	public Estado listarPorId(Estado entidad) throws Exception {
		
		return EstadoDAO.listarPorId(entidad);
	}

}
