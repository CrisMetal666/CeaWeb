package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.ITipoCategoriaDAO;
import com.ceaweb.model.TipoCategoria;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class TipoCategoriaDAOImpl implements ITipoCategoriaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(TipoCategoria entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(TipoCategoria entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TipoCategoria> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from TipoCategoria c");
		
		List<TipoCategoria> lista = (List<TipoCategoria>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TipoCategoria listarPorId(TipoCategoria entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<TipoCategoria> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from TipoCategoria c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<TipoCategoria>) query.getResultList();
		
		TipoCategoria TipoCategoria = new TipoCategoria();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			TipoCategoria = lista.get(0);
		}
		
		return TipoCategoria;
	}

}