package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.ITipoEstadoDAO;
import com.ceaweb.model.TipoEstado;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class TipoEstadoDAOImpl implements ITipoEstadoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(TipoEstado entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(TipoEstado entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TipoEstado> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from TipoEstado c");
		
		List<TipoEstado> lista = (List<TipoEstado>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TipoEstado listarPorId(TipoEstado entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<TipoEstado> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from TipoEstado c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<TipoEstado>) query.getResultList();
		
		TipoEstado TipoEstado = new TipoEstado();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			TipoEstado = lista.get(0);
		}
		
		return TipoEstado;
	}

}