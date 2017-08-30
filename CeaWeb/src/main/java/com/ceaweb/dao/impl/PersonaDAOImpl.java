package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IPersonaDAO;
import com.ceaweb.model.Persona;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class PersonaDAOImpl implements IPersonaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(Persona entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(Persona entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Persona> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from Persona c");
		
		List<Persona> lista = (List<Persona>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Persona listarPorId(Persona entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<Persona> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from Persona c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<Persona>) query.getResultList();
		
		Persona Persona = new Persona();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			Persona = lista.get(0);
		}
		
		return Persona;
	}

}