package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.ICertificadosCeaDAO;
import com.ceaweb.model.CertificadosCea;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class CertificadosCeaDAOImpl implements ICertificadosCeaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(CertificadosCea entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(CertificadosCea entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CertificadosCea> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from CertificadosCea c");
		
		List<CertificadosCea> lista = (List<CertificadosCea>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public CertificadosCea listarPorId(CertificadosCea entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<CertificadosCea> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from CertificadosCea c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<CertificadosCea>) query.getResultList();
		
		CertificadosCea CertificadosCea = new CertificadosCea();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			CertificadosCea = lista.get(0);
		}
		
		return CertificadosCea;
	}

}