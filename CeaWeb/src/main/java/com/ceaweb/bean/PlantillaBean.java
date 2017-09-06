package com.ceaweb.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.ceaweb.model.Usuario;

/**
 * 
 * @author crismetal
 *
 */
@Named
@RequestScoped
public class PlantillaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public void verificarSesion() {
		
//		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//		
//		try {
//			// Obtenemos el usuario registrado en la session
//			Usuario usuario = (Usuario)context.getSessionMap().get("usuario");
//			
//			if(usuario == null) {
//				context.redirect("/CeaWeb/login.xhtml");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}

}
