package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IEmpleadoDAO;
import com.ceaweb.model.Empleado;
import com.ceaweb.service.IEmpleadoService;

@Named
@RequestScoped
public class EmpleadoServiceImpl implements IEmpleadoService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IEmpleadoDAO EmpleadoDAO;

	@Override
	public void registrar(Empleado entidad) throws Exception {
		
		EmpleadoDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(Empleado entidad) throws Exception {
		
		EmpleadoDAO.modificar(entidad);
		
	}

	@Override
	public List<Empleado> listarTodos() throws Exception {
		
		return EmpleadoDAO.listarTodos();
	}

	@Override
	public Empleado listarPorId(Empleado entidad) throws Exception {
		
		return EmpleadoDAO.listarPorId(entidad);
	}

}
