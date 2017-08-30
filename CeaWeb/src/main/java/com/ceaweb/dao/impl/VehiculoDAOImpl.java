package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IVehiculoDAO;
import com.ceaweb.model.Vehiculo;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class VehiculoDAOImpl implements IVehiculoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(Vehiculo entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(Vehiculo entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Vehiculo> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from Vehiculo c");
		
		List<Vehiculo> lista = (List<Vehiculo>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Vehiculo listarPorId(Vehiculo entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<Vehiculo> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from Vehiculo c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<Vehiculo>) query.getResultList();
		
		Vehiculo Vehiculo = new Vehiculo();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			Vehiculo = lista.get(0);
		}
		
		return Vehiculo;
	}

}