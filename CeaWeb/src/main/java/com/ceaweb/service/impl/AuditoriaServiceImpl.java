package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IAuditoriaDAO;
import com.ceaweb.model.Auditoria;
import com.ceaweb.service.IAuditoriaService;

@Named
@RequestScoped
public class AuditoriaServiceImpl implements IAuditoriaService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IAuditoriaDAO AuditoriaDAO;

	@Override
	public void registrar(Auditoria entidad) throws Exception {
		
		AuditoriaDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(Auditoria entidad) throws Exception {
		
		AuditoriaDAO.modificar(entidad);
		
	}

	@Override
	public List<Auditoria> listarTodos() throws Exception {
		
		return AuditoriaDAO.listarTodos();
	}

	@Override
	public Auditoria listarPorId(Auditoria entidad) throws Exception {
		
		return AuditoriaDAO.listarPorId(entidad);
	}

}
