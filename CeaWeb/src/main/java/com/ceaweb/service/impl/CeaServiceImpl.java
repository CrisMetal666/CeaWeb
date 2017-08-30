package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.ICeaDAO;
import com.ceaweb.model.Cea;
import com.ceaweb.service.ICeaService;

@Named
@RequestScoped
public class CeaServiceImpl implements ICeaService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICeaDAO ceaDAO;

	@Override
	public void registrar(Cea entidad) throws Exception {
		
		ceaDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(Cea entidad) throws Exception {
		
		ceaDAO.modificar(entidad);
		
	}

	@Override
	public List<Cea> listarTodos() throws Exception {
		
		return ceaDAO.listarTodos();
	}

	@Override
	public Cea listarPorId(Cea entidad) throws Exception {
		
		return ceaDAO.listarPorId(entidad);
	}

}
