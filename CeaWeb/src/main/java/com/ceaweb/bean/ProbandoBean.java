package com.ceaweb.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ceaweb.model.Cea;
import com.ceaweb.model.DataCategoria;
import com.ceaweb.service.ICeaService;

@Named
@ViewScoped
public class ProbandoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public void saludar() {
		System.out.println("------Saludando ---------");
	}

	@Inject
	private ICeaService service;

	public void pruebaInsert() throws Exception {

		Cea c = new Cea();

		DataCategoria dc = new DataCategoria();
		dc.setId(1);

		c.setIdcategoriaCiudad(dc);
		c.setNombre("Cea1 yeah!!!");
		c.setNit("nit2");
		c.setTelefono("tel1");
		c.setDireccion("direccion1");
		c.setUrlLogo("logo1");
		c.setResolucionMineducacion("min1");
		c.setResolucionMintransporte("min1");
		c.setConsecutivoMatricula(1);

		service.registrar(c);
	}

	public void pruebaModificar() throws Exception {

		Cea c = new Cea();

		DataCategoria dc = new DataCategoria();
		dc.setId(1);

		c.setId(1);
		c.setIdcategoriaCiudad(dc);
		c.setNombre("Cea1 yeah!!!");
		c.setNit("nit1");
		c.setTelefono("tel1");
		c.setDireccion("direccion1");
		c.setUrlLogo("logo1");
		c.setResolucionMineducacion("min1");
		c.setResolucionMintransporte("min1");
		c.setConsecutivoMatricula(1);

		service.modificar(c);
	}

	public void pruebaListarTodos() throws Exception {

		service.listarTodos().forEach(x -> System.out.println("------>" + x));
	}

	public void pruebaListarPorId() throws Exception {
		Cea c = new Cea();
		c.setId(1);

		System.out.println(service.listarPorId(c));

	}

}
