package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IGestorDAO;
import com.ceaweb.model.Gestor;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class GestorDAOImpl implements IGestorDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(Gestor entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(Gestor entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Gestor> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from Gestor c");
		
		List<Gestor> lista = (List<Gestor>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Gestor listarPorId(Gestor entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<Gestor> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from Gestor c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<Gestor>) query.getResultList();
		
		Gestor Gestor = new Gestor();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			Gestor = lista.get(0);
		}
		
		return Gestor;
	}

}