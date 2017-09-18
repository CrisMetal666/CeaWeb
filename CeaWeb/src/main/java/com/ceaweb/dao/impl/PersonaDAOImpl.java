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

	/**
	 * Traer los datos basicos de la persona (informacion con datos primitivos o wrappers)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Persona listarPorId(Persona entidad) throws Exception {

		// creamos una lista para no tener problemas con NullPointerException
		List<Persona> lista = new ArrayList<>();

		Query query = entityManager.createQuery("from Persona c where c.id = ?1");
		query.setParameter(1, entidad.getId());

		lista = (List<Persona>) query.getResultList();

		Persona persona = null;

		// Nos aseguramos que exista un valor para retornar
		if (lista != null && !lista.isEmpty()) {
			persona = lista.get(0);
			
			//Traemos los datos Lazy
			persona.getTipoDocumento().getId();
			persona.getGenero().getId();
			persona.getEstadoCivil().getId();
			persona.getLugarOrigen().getId();
			persona.getDocumentoExpedicion().getId();
			persona.getEstrato().getId();
			persona.getRegimenSalud().getId();
			persona.getNivelFormacion().getId();
			persona.getOcupacion().getId();
			persona.getDiscapacidad().getId();
		}

		return persona;
	}

	/**
	 *
	 *trae la informacion del usuario con todos sus objetos
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Persona buscarPorIdentificacion(Persona per) throws Exception {

		// creamos una lista para no tener problemas con NullPointerException
		List<Persona> lista = new ArrayList<>();

		Query query = entityManager.createQuery("from Persona p where p.identificacion = ?1 and p.idcea.id = ?2");
		query.setParameter(1, per.getIdentificacion());
		query.setParameter(2, per.getIdcea().getId());

		lista = (List<Persona>) query.getResultList();

		Persona persona = null;

		// Nos aseguramos que exista un valor para retornar
		if (lista != null && !lista.isEmpty()) {
			persona = lista.get(0);
			
			persona.getTipoDocumento().getId();
			persona.getGenero().getId();
			persona.getEstadoCivil().getId();
			persona.getLugarOrigen().getId();
			persona.getDocumentoExpedicion().getId();
			persona.getEstrato().getId();
			persona.getRegimenSalud().getId();
			persona.getNivelFormacion().getId();
			persona.getOcupacion().getId();
			persona.getDiscapacidad().getId();
			
		}

		return persona;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Persona> buscarPorNombreApellidoIdentificacion(String busqueda, int idcea) throws Exception {

		List<Persona> lista = new ArrayList<>();

		String sql = "select * from persona as p where concat(p.nombres, ' ', p.apellidos) like ?1 " + 
				"or p.identificacion like ?2 and p.idcea = ?3";
		
		Query query = entityManager.createNativeQuery(sql, Persona.class);
		query.setParameter(1, "%" + busqueda + "%");
		query.setParameter(2, "%" + busqueda + "%");
		query.setParameter(3, idcea);

		lista = (List<Persona>) query.getResultList();

		return lista;
	}

}