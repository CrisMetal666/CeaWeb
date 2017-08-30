package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.ICargoExtraDAO;
import com.ceaweb.model.CargoExtra;
import com.ceaweb.service.ICargoExtraService;

@Named
@RequestScoped
public class CargoExtraServiceImpl implements ICargoExtraService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICargoExtraDAO CargoExtraDAO;

	@Override
	public void registrar(CargoExtra entidad) throws Exception {
		
		CargoExtraDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(CargoExtra entidad) throws Exception {
		
		CargoExtraDAO.modificar(entidad);
		
	}

	@Override
	public List<CargoExtra> listarTodos() throws Exception {
		
		return CargoExtraDAO.listarTodos();
	}

	@Override
	public CargoExtra listarPorId(CargoExtra entidad) throws Exception {
		
		return CargoExtraDAO.listarPorId(entidad);
	}

}
