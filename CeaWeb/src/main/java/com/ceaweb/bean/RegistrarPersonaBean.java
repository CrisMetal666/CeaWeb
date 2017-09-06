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

import com.ceaweb.model.Cea;
import com.ceaweb.model.DataCategoria;
import com.ceaweb.model.Persona;
import com.ceaweb.service.IDataCategoriaService;
import com.ceaweb.service.IPersonaService;

/**
 * 
 * @author crismetal
 * 
 * Bean escargado de controlar la vista registrarPersona encargada de registrar personas
 *
 */
@Named
@ViewScoped
public class RegistrarPersonaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDataCategoriaService dataCategoriaService;
	@Inject
	private IPersonaService personaService;
	private Persona persona;
	private DataCategoria tipoDocumento;
	private DataCategoria genero;
	private DataCategoria estadoCivil;
	private DataCategoria lugarOrigen = new DataCategoria();;
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
	/**
	 * Guardara los item seleccionados en el checkbox en el siguiente orden
	 * index - valor 
	 * 0 - indigena
	 * 1 - afrodecendiente
	 * 2 - desplazado
	 * 3 - poblacion frontera
	 * 4 - cabeza de familia
	 * 5 - reinsertado
	 * 6 - poblacion room
	 */
	private boolean multiculturalidad[];
	
	@PostConstruct
	public void init() {
		
		try {
			lstTipoDocumento = dataCategoriaService.getTipoIdentificacion();
			lstGenero = dataCategoriaService.getGenero();
			lstEstadoCivil = dataCategoriaService.getEstadoCivil();
			lstEstrato = dataCategoriaService.getEstrato();
			lstRegimenSalud = dataCategoriaService.getRegimenSalud();
			lstNivelFormacion = dataCategoriaService.getNivelFormacion();
			lstOcupacion = dataCategoriaService.getOcupacion();
			lstDiscapacidad = dataCategoriaService.getDiscapacidad();
		}catch(Exception e) {
			
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
		estrato = new DataCategoria();
		regimenSalud = new DataCategoria();
		nivelFormacion = new DataCategoria();
		ocupacion = new DataCategoria();
		discapacidad = new DataCategoria();
		multiculturalidad = new boolean[7];
		lstLugarOrigen = new ArrayList<>();
		
	}
	
	
	/**
	 * Encargado de hacer la busqueda de la ciudad que contenga la cadena especifcada por el usuario
	 */
	public List<DataCategoria> buscar(String text) {

		try {
			lstLugarOrigen = dataCategoriaService.buscarCiudadPorNombre(text);
			
			//Guardamos la lista en la sesion para poder aceder a ella en el converter (DataCategoriaConverter)
			if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lstCiudades") == null) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lstCiudades", lstLugarOrigen);
			}else {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().replace("lstCiudades", lstLugarOrigen);
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstLugarOrigen;
	}
	
	public void guardar() {
		
		//El id del Cea sera obtenido de la informacion guardada de la sesion
		Cea cea = new Cea(1);
		persona.setIdcea(cea);
		
		//Por ahora enviamos datos duros
		persona.setUrlFirma("url_firma");
		persona.setUrlFoto("url_foto");
		
		//Datos personales
		persona.setTipoDocumento(tipoDocumento);
		persona.setGenero(genero);
		persona.setEstadoCivil(estadoCivil);
		persona.setLugarOrigen(lugarOrigen);
		persona.setEstrato(estrato);
		persona.setRegimenSalud(regimenSalud);
		persona.setNivelFormacion(nivelFormacion);
		persona.setOcupacion(ocupacion);
		persona.setDiscapacidad(discapacidad);
		
		//datos multiculturalidad
		/*
		 * Comparo si la posicion en el array es verdadero, si lo es envio un X y si es falso envio
		 * una cadena vacia 
		 */		
		persona.setIndigena(multiculturalidad[0] ? "X" : "");
		persona.setAfrodecendiente(multiculturalidad[1] ? "X" : "");
		persona.setDesplazado(multiculturalidad[2] ? "X" : "");
		persona.setPoblacionFrontera(multiculturalidad[3] ? "X" : "");
		persona.setCabezaFamilia(multiculturalidad[4] ? "X" : "");
		persona.setReinsertado(multiculturalidad[5] ? "X" : "");
		persona.setPoblacionRoom(multiculturalidad[6] ? "X" : "");
		
		try {
			
			personaService.registrar(persona);
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Satifactorio", "La información fue registrada exitosamente");
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			limpiarControles();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
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


	
	
	
}
