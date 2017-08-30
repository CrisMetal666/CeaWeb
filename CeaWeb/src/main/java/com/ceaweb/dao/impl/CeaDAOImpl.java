package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.ICeaDAO;
import com.ceaweb.model.Cea;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class CeaDAOImpl implements ICeaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(Cea entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(Cea entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cea> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from Cea c");
		
		List<Cea> lista = (List<Cea>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Cea listarPorId(Cea entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<Cea> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from Cea c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<Cea>) query.getResultList();
		
		Cea cea = new Cea();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			cea = lista.get(0);
		}
		
		return cea;
	}

}
