package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.ICategoriaCeaDAO;
import com.ceaweb.model.CategoriaCea;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class CategoriaCeaDAOImpl implements ICategoriaCeaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(CategoriaCea entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(CategoriaCea entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CategoriaCea> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from CategoriaCea c");
		
		List<CategoriaCea> lista = (List<CategoriaCea>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public CategoriaCea listarPorId(CategoriaCea entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<CategoriaCea> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from CategoriaCea c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<CategoriaCea>) query.getResultList();
		
		CategoriaCea CategoriaCea = new CategoriaCea();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			CategoriaCea = lista.get(0);
		}
		
		return CategoriaCea;
	}

}