package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.ICargoExtraDAO;
import com.ceaweb.model.CargoExtra;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class CargoExtraDAOImpl implements ICargoExtraDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(CargoExtra entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(CargoExtra entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CargoExtra> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from CargoExtra c");
		
		List<CargoExtra> lista = (List<CargoExtra>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public CargoExtra listarPorId(CargoExtra entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<CargoExtra> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from CargoExtra c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<CargoExtra>) query.getResultList();
		
		CargoExtra CargoExtra = new CargoExtra();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			CargoExtra = lista.get(0);
		}
		
		return CargoExtra;
	}

}