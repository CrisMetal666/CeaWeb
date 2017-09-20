package com.ceaweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.ceaweb.model.Cea;
import com.ceaweb.model.DataCategoria;
import com.ceaweb.model.Persona;
import com.ceaweb.service.IDataCategoriaService;
import com.ceaweb.service.IPersonaService;

/**
 * 
 * @author crismetal
 * 
 *         Bean escargado de controlar la vista registrarPersona encargada de
 *         registrar personas
 *
 */
@Named
@ViewScoped
public class RegistrarPersonaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IDataCategoriaService dataCategoriaService;
	@Inject
	private IPersonaService personaService;
	private Persona persona;
	private Cea cea;
	private DataCategoria tipoDocumento;
	private DataCategoria genero;
	private DataCategoria estadoCivil;
	private DataCategoria lugarOrigen;
	private DataCategoria documentoExpedicion;
	private DataCategoria estrato;
	private DataCategoria regimenSalud;
	private DataCategoria nivelFormacion;
	private DataCategoria ocupacion;
	private DataCategoria discapacidad;
	private List<DataCategoria> lstTipoDocumento;
	private List<DataCategoria> lstGenero;
	private List<DataCategoria> lstEstadoCivil;
	private List<DataCategoria> lstLugarOrigen;
	private List<DataCategoria> lstEstrato;
	private List<DataCategoria> lstRegimenSalud;
	private List<DataCategoria> lstNivelFormacion;
	private List<DataCategoria> lstOcupacion;
	private List<DataCategoria> lstDiscapacidad;
	private List<DataCategoria> lstDocumentoExpedicion;
	/**
	 * Guardara los item seleccionados en el checkbox en el siguiente orden index -
	 * valor 0 - indigena 1 - afrodecendiente 2 - desplazado 3 - poblacion frontera
	 * 4 - cabeza de familia 5 - reinsertado 6 - poblacion room
	 */
	private boolean multiculturalidad[];

	@PostConstruct
	public void init() {
		
		try {
			// se reemplazara con la informacion que se guardara en la sesion
			cea = new Cea(1);
			lstTipoDocumento = dataCategoriaService.getTipoIdentificacion();
			lstGenero = dataCategoriaService.getGenero();
			lstEstadoCivil = dataCategoriaService.getEstadoCivil();
			lstEstrato = dataCategoriaService.getEstrato();
			lstRegimenSalud = dataCategoriaService.getRegimenSalud();
			lstNivelFormacion = dataCategoriaService.getNivelFormacion();
			lstOcupacion = dataCategoriaService.getOcupacion();
			lstDiscapacidad = dataCategoriaService.getDiscapacidad();
		} catch (Exception e) {

		}

		limpiarControles();
		
	}

	/**
	 * Se inicializan todos los atributos usados por la vista
	 */
	public void limpiarControles() {

		persona = new Persona();
		tipoDocumento = new DataCategoria();
		genero = new DataCategoria();
		estadoCivil = new DataCategoria();
		lugarOrigen = new DataCategoria();
		documentoExpedicion = new DataCategoria();
		estrato = new DataCategoria();
		regimenSalud = new DataCategoria();
		nivelFormacion = new DataCategoria();
		ocupacion = new DataCategoria();
		discapacidad = new DataCategoria();
		multiculturalidad = new boolean[7];
		lstLugarOrigen = new ArrayList<>();
		lstDocumentoExpedicion = new ArrayList<>();

	}

	/**
	 * Encargado de hacer la busqueda de la ciudad que contenga la cadena
	 * especifcada por el usuario
	 */
	public List<DataCategoria> buscarLugarOrigen(String text) {

		try {
			lstLugarOrigen = dataCategoriaService.buscarCiudadPorNombre(text);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lstLugarOrigen;
	}

	/**
	 * Encargado de hacer la busqueda de la expedicion del documento que contenga la
	 * cadena especifcada por el usuario
	 */
	public List<DataCategoria> buscarDocumentoExpedicion(String text) {

		try {
			lstDocumentoExpedicion = dataCategoriaService.buscarCiudadPorNombre(text);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lstDocumentoExpedicion;
	}

	/**
	 * metodo que registra al usuario
	 */
	public void guardar() {

		persona.setIdcea(cea);

		// Por ahora enviamos datos duros
		persona.setUrlFirma("url_firma");
		persona.setUrlFoto("url_foto");

		// Datos personales
		persona.setTipoDocumento(tipoDocumento);
		persona.setGenero(genero);
		persona.setEstadoCivil(estadoCivil);
		persona.setLugarOrigen(lugarOrigen);
		persona.setEstrato(estrato);
		persona.setRegimenSalud(regimenSalud);
		persona.setNivelFormacion(nivelFormacion);
		persona.setOcupacion(ocupacion);
		persona.setDiscapacidad(discapacidad);
		persona.setDocumentoExpedicion(documentoExpedicion);

		// datos multiculturalidad
		/*
		 * Comparo si la posicion en el array es verdadero, si lo es envio un X y si es
		 * falso envio una cadena vacia
		 */
		persona.setIndigena(multiculturalidad[0] ? "X" : "");
		persona.setAfrodecendiente(multiculturalidad[1] ? "X" : "");
		persona.setDesplazado(multiculturalidad[2] ? "X" : "");
		persona.setPoblacionFrontera(multiculturalidad[3] ? "X" : "");
		persona.setCabezaFamilia(multiculturalidad[4] ? "X" : "");
		persona.setReinsertado(multiculturalidad[5] ? "X" : "");
		persona.setPoblacionRoom(multiculturalidad[6] ? "X" : "");

		try {

			String mensaje = null;

			if (persona.getId() != null && persona.getId() > 0) {

				personaService.modificar(persona);

				mensaje = "La información fue modificada exitosamente";

			} else {
				
				personaService.registrar(persona);

				mensaje = "La información fue registrada exitosamente";

			}

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Satisfactorio", mensaje);
			FacesContext.getCurrentInstance().addMessage(null, message);

			limpiarControles();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Verificara con la cedula de la persona si ya existe en el sistema, de ser
	 * asi, se mostrara toda la informacion en la vista para que sea actualizado
	 */
	public void verificarExistencia() {

		persona.setIdcea(cea);

		/*
		 * Creamos otro objecto persona para q la informacion que este guardado en el
		 * atributo persona no se pierda si la consulta de la persona devuelva un null
		 */
		Persona per = null;

		try {
			per = personaService.buscarPorIdentificacion(persona);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (per == null) {
			persona.setId(null);
			return;
		}
			

		persona = per;

		// llenamos los objetos para mostrarlos en la vista al usuario
		tipoDocumento = persona.getTipoDocumento();
		genero = persona.getGenero();
		estadoCivil = persona.getEstadoCivil();
		lugarOrigen = persona.getLugarOrigen();
		documentoExpedicion = persona.getDocumentoExpedicion();
		estrato = persona.getEstrato();
		regimenSalud = persona.getRegimenSalud();
		nivelFormacion = persona.getNivelFormacion();
		ocupacion = persona.getOcupacion();
		discapacidad = persona.getDiscapacidad();

		/*
		 * index - valor 0 - indigena 1 - afrodecendiente 2 - desplazado 3 - poblacion
		 * frontera 4 - cabeza de familia 5 - reinsertado 6 - poblacion room
		 */
		multiculturalidad[0] = persona.getIndigena().trim().equals("") ? false : true;
		multiculturalidad[1] = persona.getAfrodecendiente().trim().equals("") ? false : true;
		multiculturalidad[2] = persona.getDesplazado().trim().equals("") ? false : true;
		multiculturalidad[3] = persona.getPoblacionFrontera().trim().equals("") ? false : true;
		multiculturalidad[4] = persona.getCabezaFamilia().trim().equals("") ? false : true;
		multiculturalidad[5] = persona.getReinsertado().trim().equals("") ? false : true;
		multiculturalidad[6] = persona.getPoblacionRoom().trim().equals("") ? false : true;

		/*
		 * llenar las listas que usan los autocomplete para que omnifaces pueda trabajar
		 * correctamente
		 */
		lstLugarOrigen = new ArrayList<>();
		lstDocumentoExpedicion = new ArrayList<>();

		lstLugarOrigen.add(lugarOrigen);
		lstDocumentoExpedicion.add(documentoExpedicion);

		RequestContext.getCurrentInstance().update("formulario");
	}

	/*
	 * Getters & Setters
	 */
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public DataCategoria getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(DataCategoria tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public DataCategoria getGenero() {
		return genero;
	}

	public void setGenero(DataCategoria genero) {
		this.genero = genero;
	}

	public DataCategoria getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(DataCategoria estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public DataCategoria getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(DataCategoria lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public DataCategoria getEstrato() {
		return estrato;
	}

	public void setEstrato(DataCategoria estrato) {
		this.estrato = estrato;
	}

	public DataCategoria getRegimenSalud() {
		return regimenSalud;
	}

	public void setRegimenSalud(DataCategoria regimenSalud) {
		this.regimenSalud = regimenSalud;
	}

	public DataCategoria getNivelFormacion() {
		return nivelFormacion;
	}

	public void setNivelFormacion(DataCategoria nivelFormacion) {
		this.nivelFormacion = nivelFormacion;
	}

	public DataCategoria getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(DataCategoria ocupacion) {
		this.ocupacion = ocupacion;
	}

	public DataCategoria getDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(DataCategoria discapacidad) {
		this.discapacidad = discapacidad;
	}

	public List<DataCategoria> getLstTipoDocumento() {
		return lstTipoDocumento;
	}

	public void setLstTipoDocumento(List<DataCategoria> lstTipoDocumento) {
		this.lstTipoDocumento = lstTipoDocumento;
	}

	public List<DataCategoria> getLstGenero() {
		return lstGenero;
	}

	public void setLstGenero(List<DataCategoria> lstGenero) {
		this.lstGenero = lstGenero;
	}

	public List<DataCategoria> getLstEstadoCivil() {
		return lstEstadoCivil;
	}

	public void setLstEstadoCivil(List<DataCategoria> lstEstadoCivil) {
		this.lstEstadoCivil = lstEstadoCivil;
	}

	public List<DataCategoria> getLstLugarOrigen() {
		return lstLugarOrigen;
	}

	public void setLstLugarOrigen(List<DataCategoria> lstLugarOrigen) {
		this.lstLugarOrigen = lstLugarOrigen;
	}

	public List<DataCategoria> getLstEstrato() {
		return lstEstrato;
	}

	public void setLstEstrato(List<DataCategoria> lstEstrato) {
		this.lstEstrato = lstEstrato;
	}

	public List<DataCategoria> getLstRegimenSalud() {
		return lstRegimenSalud;
	}

	public void setLstRegimenSalud(List<DataCategoria> lstRegimenSalud) {
		this.lstRegimenSalud = lstRegimenSalud;
	}

	public List<DataCategoria> getLstNivelFormacion() {
		return lstNivelFormacion;
	}

	public void setLstNivelFormacion(List<DataCategoria> lstNivelFormacion) {
		this.lstNivelFormacion = lstNivelFormacion;
	}

	public List<DataCategoria> getLstOcupacion() {
		return lstOcupacion;
	}

	public void setLstOcupacion(List<DataCategoria> lstOcupacion) {
		this.lstOcupacion = lstOcupacion;
	}

	public List<DataCategoria> getLstDiscapacidad() {
		return lstDiscapacidad;
	}

	public void setLstDiscapacidad(List<DataCategoria> lstDiscapacidad) {
		this.lstDiscapacidad = lstDiscapacidad;
	}

	public boolean[] getMulticulturalidad() {
		return multiculturalidad;
	}

	public void setMulticulturalidad(boolean[] multiculturalidad) {
		this.multiculturalidad = multiculturalidad;
	}

	public DataCategoria getDocumentoExpedicion() {
		return documentoExpedicion;
	}

	public void setDocumentoExpedicion(DataCategoria documentoExpedicion) {
		this.documentoExpedicion = documentoExpedicion;
	}

	public List<DataCategoria> getLstDocumentoExpedicion() {
		return lstDocumentoExpedicion;
	}

	public void setLstDocumentoExpedicion(List<DataCategoria> lstDocumentoExpedicion) {
		this.lstDocumentoExpedicion = lstDocumentoExpedicion;
	}

}
