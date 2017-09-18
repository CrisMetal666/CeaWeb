package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IDataCategoriaDAO;
import com.ceaweb.model.DataCategoria;
import com.ceaweb.service.IDataCategoriaService;
import com.ceaweb.util.FormatearCadena;

@Named
@RequestScoped
public class DataCategoriaServiceImpl implements IDataCategoriaService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IDataCategoriaDAO DataCategoriaDAO;
	/**
	 * acomodara los nombres de las ciudades
	 */
	private FormatearCadena formatearCadena;
	
	@PostConstruct
	public void init() {
		formatearCadena = new FormatearCadena();
	}

	@Override
	public void registrar(DataCategoria entidad) throws Exception {
		
		DataCategoriaDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(DataCategoria entidad) throws Exception {
		
		DataCategoriaDAO.modificar(entidad);
		
	}

	@Override
	public List<DataCategoria> listarTodos() throws Exception {
		
		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.listarTodos());
	}

	@Override
	public DataCategoria listarPorId(DataCategoria entidad) throws Exception {
		
		return DataCategoriaDAO.listarPorId(entidad);
	}

	@Override
	public List<DataCategoria> getJornada() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getJornada());
	}

	@Override
	public List<DataCategoria> getTipoIdentificacion() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getTipoIdentificacion());
	}

	@Override
	public List<DataCategoria> getGenero() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getGenero());
	}

	@Override
	public List<DataCategoria> getEstadoCivil() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getEstadoCivil());
	}

	@Override
	public List<DataCategoria> getLugarOrigen() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getLugarOrigen());
	}

	@Override
	public List<DataCategoria> getEstrato() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getEstrato());
	}

	@Override
	public List<DataCategoria> getRegimenSalud() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getRegimenSalud());
	}

	@Override
	public List<DataCategoria> getNivelFormacion() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getNivelFormacion());
	}

	@Override
	public List<DataCategoria> getOcupacion() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getOcupacion());
	}

	@Override
	public List<DataCategoria> getDiscapacidad() throws Exception {

		return formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.getDiscapacidad());
	}

	@Override
	public List<DataCategoria> buscarCiudadPorNombre(String nombre) throws Exception {
		
		List<DataCategoria> lista = DataCategoriaDAO.buscarCiudadPorNombre(nombre);
		
		if(lista == null || lista.isEmpty()) {
			
			// Agregamos un item a la lista con un mensaje q diga al usuario q no hay registros
			DataCategoria dataCategoria = new DataCategoria();
			dataCategoria.setNombre("No hay registros");
			dataCategoria.setId(-1);
			
			lista.add(dataCategoria);
			
		}else {
			lista = formatearCadena.formatearListaDataCategoria(DataCategoriaDAO.buscarCiudadPorNombre(nombre));
		}
		
		return lista;
	}

}
