package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IActividadesVehiculoDAO;
import com.ceaweb.model.ActividadesVehiculo;
import com.ceaweb.service.IActividadesVehiculoService;

@Named
@RequestScoped
public class ActividadesVehiculoServiceImpl implements IActividadesVehiculoService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IActividadesVehiculoDAO ActividadesVehiculoDAO;

	@Override
	public void registrar(ActividadesVehiculo entidad) throws Exception {
		
		ActividadesVehiculoDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(ActividadesVehiculo entidad) throws Exception {
		
		ActividadesVehiculoDAO.modificar(entidad);
		
	}

	@Override
	public List<ActividadesVehiculo> listarTodos() throws Exception {
		
		return ActividadesVehiculoDAO.listarTodos();
	}

	@Override
	public ActividadesVehiculo listarPorId(ActividadesVehiculo entidad) throws Exception {
		
		return ActividadesVehiculoDAO.listarPorId(entidad);
	}

}
