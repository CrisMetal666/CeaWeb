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

import org.omnifaces.util.Faces;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.ceaweb.model.Cea;
import com.ceaweb.model.DataCategoria;
import com.ceaweb.model.Persona;
import com.ceaweb.service.IDataCategoriaService;
import com.ceaweb.service.IPersonaService;

@Named
@ViewScoped
public class ActualizarPersonaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	IPersonaService personaService;
	@Inject
	private IDataCategoriaService dataCategoriaService;
	private Persona persona;
	private List<Persona> lstPersonas;
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
	private Cea cea;
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

	private boolean visible;

	@PostConstruct
	public void init() {
		
		crearMensaje();

		try {
			// este valor se reemplazara con la que se guarde en la sesion cuando se logee
			// el usuario
			cea = new Cea(1);
			visible = false;
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
	 * recibe la informacion enviado por este mismo bean (ActualizarPersonaBean) y
	 * muestra el mensaje
	 * 
	 * @see ActualizarPersonaBean.guardar
	 */
	private void crearMensaje() {

		String mensaje[] = Faces.getFlashAttribute("mensaje");

		if (mensaje == null) return;
		
		String titulo = "";
		FacesMessage.Severity severidad = null;
		
		if(mensaje[0] == null) {
			titulo = "Satifactorio";
			severidad = FacesMessage.SEVERITY_INFO;
		}else {
			titulo = "Advertencia";
			severidad = FacesMessage.SEVERITY_WARN;
		}

		FacesMessage message = new FacesMessage(severidad, titulo, mensaje[1]);
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		RequestContext.getCurrentInstance().update("mensajes");
		
//		Ajax.update("form");

	}

	/**
	 * Se inicializan todos los atributos usados por la vista
	 */
	public void limpiarControles() {

		persona = new Persona();
		lstPersonas = new ArrayList<>();
		visible = false;
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
	 * Busca la persona que coincida con el texto descrito por el usuario
	 */
	public List<Persona> buscarPersona(String text) {

		try {

			lstPersonas = personaService.buscarPorNombreApellidoIdentificacion(text, cea.getId());

			if (lstPersonas.isEmpty() || lstPersonas == null) {

				// agregamos un elemento a la lista para que le muestre el mensaje al usuario
				Persona per = new Persona();
				per.setNombres("No hay similitud");

				lstPersonas.add(per);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lstPersonas;
	}

	/**
	 * Se ejecuta cuando seleccionan un item del autocomplete buscar
	 * 
	 */
	public void onItemSelect(SelectEvent event) {

		visible = true;
		Persona per = new Persona( Integer.parseInt(event.getObject().toString()));
		
		per.setIdcea(new Cea(1));

		try {
			persona = personaService.listarPorId(per);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

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

		// llenar las listas que usan los autocomplete para que omnifaces pueda trabajar
		// correctamente

		lstLugarOrigen = new ArrayList<>();
		lstDocumentoExpedicion = new ArrayList<>();

		lstLugarOrigen.add(lugarOrigen);
		lstDocumentoExpedicion.add(documentoExpedicion);
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
	 * metodo que actualiza la persona
	 */
	public String guardar() {

		// El id del Cea sera obtenido de la informacion guardada de la sesion
		Cea cea = new Cea(1);
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

			personaService.modificar(persona);

			limpiarControles();

			// Por problemas con el manejo del wizar y hacer update a la vista
			// creamos el mensaje que mostrara el bean al inicializarlo
			// el index 0 sera null si la actualizacion fue satifactoria de lo contrario se
			// le
			// inicializa cualquier valor
			String mensaje[] = { null, "La información fue actualizada exitosamente" };
			Faces.setFlashAttribute("mensaje", mensaje);

		} catch (Exception e) {
			String mensaje[] = { "", "Ha ocurrido un error, intentelo de nuevo, si el problema "
					+ "continua contactese con el administrador" };
			Faces.setFlashAttribute("mensaje", mensaje);
			e.printStackTrace();
		}
		
		return "actualizarPersona?faces-redirect=true";

	}

	/**
	 * necesario para reiniciar los formularios cuando el usuario quiera cancelar
	 */
	public String cancelar() {

		return "actualizarPersona?faces-redirect=true";
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

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
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

	public DataCategoria getDocumentoExpedicion() {
		return documentoExpedicion;
	}

	public void setDocumentoExpedicion(DataCategoria documentoExpedicion) {
		this.documentoExpedicion = documentoExpedicion;
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

	public List<DataCategoria> getLstDocumentoExpedicion() {
		return lstDocumentoExpedicion;
	}

	public void setLstDocumentoExpedicion(List<DataCategoria> lstDocumentoExpedicion) {
		this.lstDocumentoExpedicion = lstDocumentoExpedicion;
	}

	public boolean[] getMulticulturalidad() {
		return multiculturalidad;
	}

	public void setMulticulturalidad(boolean[] multiculturalidad) {
		this.multiculturalidad = multiculturalidad;
	}

}
