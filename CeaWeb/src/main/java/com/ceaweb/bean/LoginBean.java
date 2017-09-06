package com.ceaweb.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.ceaweb.model.Usuario;
import com.ceaweb.service.IUsuarioService;

/**
 * 
 * @author crismetal
 *
 */
@Named
@RequestScoped
public class LoginBean implements Serializable{

	@Inject
	private IUsuarioService usuarioService;
	private static final long serialVersionUID = 1L;
	private String txtIdentificacion;
	private String txtClave;
	
	/**
	 * 
	 * Se encarga de verificar los usuarios del sistema
	 * 
	 * @return la url donde aloja la pagina principal para los usuarios logeados
	 */
	public String login() {
		
		String redireccion = null;
		Usuario usuario = null;
		
		try {
			
			// traemos un usuario con la identificacion y claves dadas
			usuario = usuarioService.iniciarSesion(txtIdentificacion, txtClave);
			
			if(usuario != null) {
				
				// almacenamos en la sesion de JSF, la informacion del usuario logeado
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
				
				redireccion = "view/persona/registrarPersona?faces-redirect=true";
				
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario o contraseña incorrecto"));
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return redireccion;
	}
	
	/*
	 * Getters and Setters
	 */
	public String getTxtIdentificacion() {
		return txtIdentificacion;
	}
	public void setTxtIdentificacion(String txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
	}
	public String getTxtClave() {
		return txtClave;
	}
	public void setTxtClave(String txtClave) {
		this.txtClave = txtClave;
	}
}
