package com.ceaweb.util;

import java.util.ArrayList;
import java.util.List;

import com.ceaweb.model.DataCategoria;

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
	public static List<DataCategoria> formatearCadena(List<DataCategoria> lista){

		List<DataCategoria> listaParceada = new ArrayList<>();
		
		lista.forEach(item -> {
			
			//Array que almacena todos los substring que esten separados por un espacio
			String palabras[] = item.getNombre().split(" ");
			
			String cadenaParceada = "";
			
			//iniciamos desde la posicion 1 porque no deseamos la primera palabra
			for(int i = 1; i < palabras.length; i++) {
				
				cadenaParceada += palabras[i] + " ";
			}
			
			item.setNombre(cadenaParceada);
			
			listaParceada.add(item);
			
		});
		
		return listaParceada;
	}
}
