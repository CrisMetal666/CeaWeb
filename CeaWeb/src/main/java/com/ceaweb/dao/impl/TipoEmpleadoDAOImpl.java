package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.ITipoEmpleadoDAO;
import com.ceaweb.model.TipoEmpleado;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class TipoEmpleadoDAOImpl implements ITipoEmpleadoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(TipoEmpleado entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(TipoEmpleado entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TipoEmpleado> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from TipoEmpleado c");
		
		List<TipoEmpleado> lista = (List<TipoEmpleado>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TipoEmpleado listarPorId(TipoEmpleado entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<TipoEmpleado> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from TipoEmpleado c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<TipoEmpleado>) query.getResultList();
		
		TipoEmpleado TipoEmpleado = new TipoEmpleado();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			TipoEmpleado = lista.get(0);
		}
		
		return TipoEmpleado;
	}

}