package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IGestionCalidadDAO;
import com.ceaweb.model.GestionCalidad;
import com.ceaweb.service.IGestionCalidadService;

@Named
@RequestScoped
public class GestionCalidadServiceImpl implements IGestionCalidadService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IGestionCalidadDAO GestionCalidadDAO;

	@Override
	public void registrar(GestionCalidad entidad) throws Exception {
		
		GestionCalidadDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(GestionCalidad entidad) throws Exception {
		
		GestionCalidadDAO.modificar(entidad);
		
	}

	@Override
	public List<GestionCalidad> listarTodos() throws Exception {
		
		return GestionCalidadDAO.listarTodos();
	}

	@Override
	public GestionCalidad listarPorId(GestionCalidad entidad) throws Exception {
		
		return GestionCalidadDAO.listarPorId(entidad);
	}

}
