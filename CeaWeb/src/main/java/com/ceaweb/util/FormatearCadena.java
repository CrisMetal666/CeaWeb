package com.ceaweb.util;

import java.util.ArrayList;
import java.util.List;

import com.ceaweb.model.DataCategoria;
import com.ceaweb.model.Persona;

/**
 * 
 * @author crismetal
 * 
 * Clase encargada de arreglar el formato a cadenas
 *
 */
public class FormatearCadena {

	/**
	 * 
	 * Se encarga de quitar el texto no deseado del objeto DataCategoria en el atributo nombre
	 *
	 * @param lista es la coleccion que se desea formatear
	 * 
	 * @return listaParceada
	 */
	public List<DataCategoria> formatearListaDataCategoria(List<DataCategoria> lista){

		List<DataCategoria> listaParceada = new ArrayList<>();
		
		lista.forEach(item -> {
			
			String cadenaParceada = formatearCadena(item.getNombre());
			
			item.setNombre(cadenaParceada);
			
			listaParceada.add(item);
			
		});
		
		return listaParceada;
	}
	
	/**
	 * 
	 * Quitamos el texto no deaso de las ciudades en los campos lugar de nacimiento y
	 * expedicion de documento
	 * 
	 * @param per objeto al que se desea parsear el texto
	 * 
	 * @return Persona con datos parseados
	 */
	public Persona formatearPersona(Persona per) {
		
		String lugarOrigen = formatearCadena(per.getLugarOrigen().getNombre());
		String documentoExpedicion = formatearCadena(per.getDocumentoExpedicion().getNombre());
		
		per.getLugarOrigen().setNombre(lugarOrigen);
		per.getDocumentoExpedicion().setNombre(documentoExpedicion);
		
		return per;
	}
	
	/**
	 * quitara el texto no deseado del nombre de la ciudad
	 * 
	 * @param dataCategoria objeto al que se desea formatear el nombre de la ciudad
	 * 
	 * @return objeto formateado
	 */
	public DataCategoria formatearDataCategoria(DataCategoria dataCategoria) {
		
		String nombreCiudad = formatearCadena(dataCategoria.getNombre());
		
		dataCategoria.setNombre(nombreCiudad);
		
		return dataCategoria;
	}
	
	/**
	 * Se encarga de quitar el texto de las cadenas (ciudades) deseeadas
	 * 
	 * @param cadena cadena sin formatear
	 * 
	 * @return cadena formatear
	 */
	private String formatearCadena(String cadena) {
		
		//Array que almacena todos los substring que esten separados por un espacio
		String palabras[] = cadena.split(" ");
		
		String cadenaParceada = "";
		
		//iniciamos desde la posicion 1 porque no deseamos la primera palabra
		for(int i = 1; i < palabras.length; i++) {
			
			cadenaParceada += palabras[i] + " ";
		}
		
		return cadenaParceada;
	}
}
