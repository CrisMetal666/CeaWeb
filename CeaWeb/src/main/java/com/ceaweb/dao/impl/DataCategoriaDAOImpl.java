package com.ceaweb.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ceaweb.dao.IDataCategoriaDAO;
import com.ceaweb.model.DataCategoria;
import com.ceaweb.model.Usuario;

/**
 * 
 * @author crismetal
 *
 */

@Stateless
public class DataCategoriaDAOImpl implements IDataCategoriaDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "CeaWebDS")
	private EntityManager entityManager;

	@Override
	public void registrar(DataCategoria entidad) throws Exception {

		entityManager.persist(entidad);

	}

	@Override
	public void modificar(DataCategoria entidad) throws Exception {

		entityManager.merge(entidad);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> listarTodos() throws Exception {

		Query query = entityManager.createQuery("from DataCategoria c");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public DataCategoria listarPorId(DataCategoria entidad) throws Exception {

		// creamos una lista para no tener problemas con NullPointerException
		List<DataCategoria> lista = new ArrayList<>();

		Query query = entityManager.createQuery("from DataCategoria c where c.id = ?1");
		query.setParameter(1, entidad.getId());

		lista = (List<DataCategoria>) query.getResultList();

		DataCategoria dataCategoria = new DataCategoria();

		// Nos aseguramos que exista un valor para retornar
		if (lista != null && !lista.isEmpty()) {
			dataCategoria = lista.get(0);
		}
		
		System.out.println("dao impl "+ dataCategoria);

		return dataCategoria;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getJornada() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 1");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getTipoIdentificacion() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 2");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getGenero() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 3");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getEstadoCivil() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 4");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getLugarOrigen() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 5");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getEstrato() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 6");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getRegimenSalud() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 7");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getNivelFormacion() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 8");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getOcupacion() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 9");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> getDiscapacidad() throws Exception {
		Query query = entityManager.createQuery("from DataCategoria d where d.idtipoCategoria.id = 10");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataCategoria> buscarCiudadPorNombre(String nombre)  throws Exception {

		String sql = "SELECT * FROM ceaweb.data_categoria where nombre like ?1 and idtipo_categoria = 5;";

		Query query = entityManager.createNativeQuery(sql, DataCategoria.class);

		query.setParameter(1, "%-%" + nombre + "%");

		List<DataCategoria> lista = (List<DataCategoria>) query.getResultList();

		return lista;
	}

}