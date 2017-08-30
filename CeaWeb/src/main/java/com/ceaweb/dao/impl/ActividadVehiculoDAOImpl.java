package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IActividadVehiculoDAO;
import com.ceaweb.model.ActividadVehiculo;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class ActividadVehiculoDAOImpl implements IActividadVehiculoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(ActividadVehiculo entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(ActividadVehiculo entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ActividadVehiculo> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from ActividadVehiculo c");
		
		List<ActividadVehiculo> lista = (List<ActividadVehiculo>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ActividadVehiculo listarPorId(ActividadVehiculo entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<ActividadVehiculo> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from ActividadVehiculo c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<ActividadVehiculo>) query.getResultList();
		
		ActividadVehiculo ActividadVehiculo = new ActividadVehiculo();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			ActividadVehiculo = lista.get(0);
		}
		
		return ActividadVehiculo;
	}

}
