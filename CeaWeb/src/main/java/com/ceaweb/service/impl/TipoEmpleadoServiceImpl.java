package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.ITipoEmpleadoDAO;
import com.ceaweb.model.TipoEmpleado;
import com.ceaweb.service.ITipoEmpleadoService;

@Named
@RequestScoped
public class TipoEmpleadoServiceImpl implements ITipoEmpleadoService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ITipoEmpleadoDAO TipoEmpleadoDAO;

	@Override
	public void registrar(TipoEmpleado entidad) throws Exception {
		
		TipoEmpleadoDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(TipoEmpleado entidad) throws Exception {
		
		TipoEmpleadoDAO.modificar(entidad);
		
	}

	@Override
	public List<TipoEmpleado> listarTodos() throws Exception {
		
		return TipoEmpleadoDAO.listarTodos();
	}

	@Override
	public TipoEmpleado listarPorId(TipoEmpleado entidad) throws Exception {
		
		return TipoEmpleadoDAO.listarPorId(entidad);
	}

}
