package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IEstadoDAO;
import com.ceaweb.model.Estado;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class EstadoDAOImpl implements IEstadoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(Estado entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(Estado entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Estado> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from Estado c");
		
		List<Estado> lista = (List<Estado>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Estado listarPorId(Estado entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<Estado> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from Estado c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<Estado>) query.getResultList();
		
		Estado Estado = new Estado();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			Estado = lista.get(0);
		}
		
		return Estado;
	}

}