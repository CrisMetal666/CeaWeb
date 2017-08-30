package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.ITipoCargoExtraDAO;
import com.ceaweb.model.TipoCargoExtra;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class TipoCargoExtraDAOImpl implements ITipoCargoExtraDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(TipoCargoExtra entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(TipoCargoExtra entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TipoCargoExtra> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from TipoCargoExtra c");
		
		List<TipoCargoExtra> lista = (List<TipoCargoExtra>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TipoCargoExtra listarPorId(TipoCargoExtra entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<TipoCargoExtra> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from TipoCargoExtra c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<TipoCargoExtra>) query.getResultList();
		
		TipoCargoExtra TipoCargoExtra = new TipoCargoExtra();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			TipoCargoExtra = lista.get(0);
		}
		
		return TipoCargoExtra;
	}

}