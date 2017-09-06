package com.ceaweb.dao;

import java.util.List;

import com.ceaweb.model.DataCategoria;

/**
 * 
 * @author crismetal
 *
 */
public interface IDataCategoriaDAO extends IDAO<DataCategoria> {

	List<DataCategoria> getJornada() throws Exception;
	List<DataCategoria> getTipoIdentificacion() throws Exception;
	List<DataCategoria> getGenero() throws Exception;
	List<DataCategoria> getEstadoCivil() throws Exception;
	List<DataCategoria> getLugarOrigen() throws Exception;
	List<DataCategoria> getEstrato() throws Exception;
	List<DataCategoria> getRegimenSalud() throws Exception;
	List<DataCategoria> getNivelFormacion() throws Exception;
	List<DataCategoria> getOcupacion() throws Exception;
	List<DataCategoria> getDiscapacidad() throws Exception;
	List<DataCategoria> buscarCiudadPorNombre(String nombre) throws Exception;
}
