package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IAuditoriaDAO;
import com.ceaweb.model.Auditoria;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class AuditoriaDAOImpl implements IAuditoriaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(Auditoria entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(Auditoria entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Auditoria> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from Auditoria c");
		
		List<Auditoria> lista = (List<Auditoria>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Auditoria listarPorId(Auditoria entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<Auditoria> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from Auditoria c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<Auditoria>) query.getResultList();
		
		Auditoria Auditoria = new Auditoria();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			Auditoria = lista.get(0);
		}
		
		return Auditoria;
	}

}