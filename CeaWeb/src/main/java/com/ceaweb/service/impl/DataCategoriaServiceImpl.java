package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IDataCategoriaDAO;
import com.ceaweb.model.DataCategoria;
import com.ceaweb.service.IDataCategoriaService;

@Named
@RequestScoped
public class DataCategoriaServiceImpl implements IDataCategoriaService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IDataCategoriaDAO DataCategoriaDAO;

	@Override
	public void registrar(DataCategoria entidad) throws Exception {
		
		DataCategoriaDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(DataCategoria entidad) throws Exception {
		
		DataCategoriaDAO.modificar(entidad);
		
	}

	@Override
	public List<DataCategoria> listarTodos() throws Exception {
		
		return DataCategoriaDAO.listarTodos();
	}

	@Override
	public DataCategoria listarPorId(DataCategoria entidad) throws Exception {
		
		return DataCategoriaDAO.listarPorId(entidad);
	}

}
