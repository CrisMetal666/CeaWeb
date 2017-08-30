package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.ICertificadosCeaDAO;
import com.ceaweb.model.CertificadosCea;
import com.ceaweb.service.ICertificadosCeaService;

@Named
@RequestScoped
public class CertificadosCeaServiceImpl implements ICertificadosCeaService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICertificadosCeaDAO CertificadosCeaDAO;

	@Override
	public void registrar(CertificadosCea entidad) throws Exception {
		
		CertificadosCeaDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(CertificadosCea entidad) throws Exception {
		
		CertificadosCeaDAO.modificar(entidad);
		
	}

	@Override
	public List<CertificadosCea> listarTodos() throws Exception {
		
		return CertificadosCeaDAO.listarTodos();
	}

	@Override
	public CertificadosCea listarPorId(CertificadosCea entidad) throws Exception {
		
		return CertificadosCeaDAO.listarPorId(entidad);
	}

}
