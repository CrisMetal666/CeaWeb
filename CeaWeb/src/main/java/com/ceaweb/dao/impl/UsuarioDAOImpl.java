package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IUsuarioDAO;
import com.ceaweb.model.Usuario;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class UsuarioDAOImpl implements IUsuarioDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(Usuario entidad) throws Exception {
		
		entityManager.persist(entidad);
		
	}

	@Override
	public void modificar(Usuario entidad) throws Exception {
		
		entityManager.merge(entidad);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos() throws Exception {
		
		Query query = entityManager.createQuery("from Usuario c");
		
		List<Usuario> lista = (List<Usuario>) query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Usuario listarPorId(Usuario entidad) throws Exception {
		
		// creamos una lista para no tener problemas con NullPointerException
		List<Usuario> lista = new ArrayList<>();
		
		Query query = entityManager.createQuery("from Usuario c where c.id = ?1");
		query.setParameter(1, entidad.getId());
		
		lista = (List<Usuario>) query.getResultList();
		
		Usuario Usuario = new Usuario();
		
		// Nos aseguramos que exista un valor para retornar 
		if(lista != null && !lista.isEmpty()){
			Usuario = lista.get(0);
		}
		
		return Usuario;
	}

}