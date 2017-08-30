package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IEmpleadoDAO;
import com.ceaweb.model.Empleado;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class EmpleadoDAOImpl implements IEmpleadoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(Empleado entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(Empleado entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Empleado> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from Empleado c");
		
		List<Empleado> lista = (List<Empleado>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Empleado listarPorId(Empleado entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<Empleado> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from Empleado c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<Empleado>) query.getResultList();
		
		Empleado Empleado = new Empleado();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			Empleado = lista.get(0);
		}
		
		return Empleado;
	}

}