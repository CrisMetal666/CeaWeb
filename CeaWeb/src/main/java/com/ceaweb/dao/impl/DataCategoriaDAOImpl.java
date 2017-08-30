package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IDataCategoriaDAO;
import com.ceaweb.model.DataCategoria;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class DataCategoriaDAOImpl implements IDataCategoriaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(DataCategoria entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(DataCategoria entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from DataCategoria c");
		
		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public DataCategoria listarPorId(DataCategoria entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<DataCategoria> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from DataCategoria c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<DataCategoria>) query.getResultList();
		
		DataCategoria DataCategoria = new DataCategoria();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			DataCategoria = lista.get(0);
		}
		
		return DataCategoria;
	}

}