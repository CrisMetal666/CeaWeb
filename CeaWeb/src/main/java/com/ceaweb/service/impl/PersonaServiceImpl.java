package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IPersonaDAO;
import com.ceaweb.model.Persona;
import com.ceaweb.service.IPersonaService;
import com.ceaweb.util.FormatearCadena;

@Named
@RequestScoped
public class PersonaServiceImpl implements IPersonaService, Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private IPersonaDAO PersonaDAO;

	@Override
	public void registrar(Persona entidad) throws Exception {

		PersonaDAO.registrar(entidad);

	}

	@Override
	public void modificar(Persona entidad) throws Exception {

		PersonaDAO.modificar(entidad);

	}

	@Override
	public List<Persona> listarTodos() throws Exception {

		return PersonaDAO.listarTodos();
	}

	@Override
	public Persona listarPorId(Persona entidad) throws Exception {

		Persona persona = PersonaDAO.listarPorId(entidad);

		FormatearCadena formatearCadena = new FormatearCadena();

		if (persona != null) {

			persona = formatearCadena.formatearPersona(persona);
		}

		return persona;
	}

	@Override
	public Persona buscarPorIdentificacion(Persona per) throws Exception {

		Persona persona = PersonaDAO.buscarPorIdentificacion(per);

		FormatearCadena formatearCadena = new FormatearCadena();

		if (persona != null) {

			persona = formatearCadena.formatearPersona(persona);
		}

		return persona;
	}

	@Override
	public List<Persona> buscarPorNombreApellidoIdentificacion(String busqueda, int idcea) throws Exception {

		return PersonaDAO.buscarPorNombreApellidoIdentificacion(busqueda, idcea);
	}

}
