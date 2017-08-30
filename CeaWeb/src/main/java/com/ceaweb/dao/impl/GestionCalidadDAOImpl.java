package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IGestionCalidadDAO;
import com.ceaweb.model.GestionCalidad;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class GestionCalidadDAOImpl implements IGestionCalidadDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(GestionCalidad entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(GestionCalidad entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<GestionCalidad> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from GestionCalidad c");
		
		List<GestionCalidad> lista = (List<GestionCalidad>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public GestionCalidad listarPorId(GestionCalidad entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<GestionCalidad> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from GestionCalidad c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<GestionCalidad>) query.getResultList();
		
		GestionCalidad GestionCalidad = new GestionCalidad();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			GestionCalidad = lista.get(0);
		}
		
		return GestionCalidad;
	}

}