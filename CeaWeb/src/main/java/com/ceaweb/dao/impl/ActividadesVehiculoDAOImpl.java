package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IActividadesVehiculoDAO;
import com.ceaweb.model.ActividadesVehiculo;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class ActividadesVehiculoDAOImpl implements IActividadesVehiculoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(ActividadesVehiculo entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(ActividadesVehiculo entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ActividadesVehiculo> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from ActividadesVehiculo c");
		
		List<ActividadesVehiculo> lista = (List<ActividadesVehiculo>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ActividadesVehiculo listarPorId(ActividadesVehiculo entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<ActividadesVehiculo> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from ActividadesVehiculo c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<ActividadesVehiculo>) query.getResultList();
		
		ActividadesVehiculo ActividadesVehiculo = new ActividadesVehiculo();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			ActividadesVehiculo = lista.get(0);
		}
		
		return ActividadesVehiculo;
	}


}
