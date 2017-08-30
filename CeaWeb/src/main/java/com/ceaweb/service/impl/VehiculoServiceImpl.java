package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IVehiculoDAO;
import com.ceaweb.model.Vehiculo;
import com.ceaweb.service.IVehiculoService;

@Named
@RequestScoped
public class VehiculoServiceImpl implements IVehiculoService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IVehiculoDAO VehiculoDAO;

	@Override
	public void registrar(Vehiculo entidad) throws Exception {
		
		VehiculoDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(Vehiculo entidad) throws Exception {
		
		VehiculoDAO.modificar(entidad);
		
	}

	@Override
	public List<Vehiculo> listarTodos() throws Exception {
		
		return VehiculoDAO.listarTodos();
	}

	@Override
	public Vehiculo listarPorId(Vehiculo entidad) throws Exception {
		
		return VehiculoDAO.listarPorId(entidad);
	}

}
