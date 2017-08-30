package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IInstructorDAO;
import com.ceaweb.model.Instructor;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class InstructorDAOImpl implements IInstructorDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(Instructor entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(Instructor entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Instructor> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from Instructor c");
		
		List<Instructor> lista = (List<Instructor>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Instructor listarPorId(Instructor entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<Instructor> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from Instructor c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<Instructor>) query.getResultList();
		
		Instructor Instructor = new Instructor();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			Instructor = lista.get(0);
		}
		
		return Instructor;
	}

}