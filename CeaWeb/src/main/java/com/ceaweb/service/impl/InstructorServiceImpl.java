package com.ceaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ceaweb.dao.IInstructorDAO;
import com.ceaweb.model.Instructor;
import com.ceaweb.service.IInstructorService;

@Named
@RequestScoped
public class InstructorServiceImpl implements IInstructorService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IInstructorDAO InstructorDAO;

	@Override
	public void registrar(Instructor entidad) throws Exception {
		
		InstructorDAO.registrar(entidad);
		
	}

	@Override
	public void modificar(Instructor entidad) throws Exception {
		
		InstructorDAO.modificar(entidad);
		
	}

	@Override
	public List<Instructor> listarTodos() throws Exception {
		
		return InstructorDAO.listarTodos();
	}

	@Override
	public Instructor listarPorId(Instructor entidad) throws Exception {
		
		return InstructorDAO.listarPorId(entidad);
	}

}
