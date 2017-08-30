package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IActividadVehiculoDAO;
import com.ceaweb.model.ActividadVehiculo;
import com.ceaweb.service.IActividadVehiculoService;

@Named
@RequestScoped
public class ActividadVehiculoServiceImpl implements IActividadVehiculoService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IActividadVehiculoDAO ActividadVehiculoDAO;

	@Override
	public void registrar(ActividadVehiculo entidad) throws Exception {
		
		ActividadVehiculoDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(ActividadVehiculo entidad) throws Exception {
		
		ActividadVehiculoDAO.modificar(entidad);
		
	}

	@Override
	public List<ActividadVehiculo> listarTodos() throws Exception {
		
		return ActividadVehiculoDAO.listarTodos();
	}

	@Override
	public ActividadVehiculo listarPorId(ActividadVehiculo entidad) throws Exception {
		
		return ActividadVehiculoDAO.listarPorId(entidad);
	}

}
