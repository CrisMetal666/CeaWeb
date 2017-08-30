package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.ITipoCargoExtraDAO;
import com.ceaweb.model.TipoCargoExtra;
import com.ceaweb.service.ITipoCargoExtraService;

@Named
@RequestScoped
public class TipoCargoExtraServiceImpl implements ITipoCargoExtraService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ITipoCargoExtraDAO TipoCargoExtraDAO;

	@Override
	public void registrar(TipoCargoExtra entidad) throws Exception {
		
		TipoCargoExtraDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(TipoCargoExtra entidad) throws Exception {
		
		TipoCargoExtraDAO.modificar(entidad);
		
	}

	@Override
	public List<TipoCargoExtra> listarTodos() throws Exception {
		
		return TipoCargoExtraDAO.listarTodos();
	}

	@Override
	public TipoCargoExtra listarPorId(TipoCargoExtra entidad) throws Exception {
		
		return TipoCargoExtraDAO.listarPorId(entidad);
	}

}
