package com.ceaweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ceaweb.model.DataCategoria;

@Named
@ViewScoped
public class IndexBean implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private String txtBuscar;
//	 @Inject
//	 private IDataCategoriaService service;
	 private List<DataCategoria> lista;
	 private boolean visible;
	 private int idMunicipio;
	
	 public IndexBean() {
	 txtBuscar = "";
	 visible = false;
	 idMunicipio = 0;
	// service = new DataCategoriaServiceImpl();
	 lista = new ArrayList<>();
	 }
	
	 public void buscar() {
	
	 if(txtBuscar.length() < 4) {
	 visible = false;
	 return;
	 }
	
	 try {
	 visible = true;
	 //lista = service.buscarPorNombre(txtBuscar);
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	
	 public void seleccionar() {
	
	 visible = false;
	
	 lista.forEach(item -> {
	
	 if(item.getId() == idMunicipio) {
	
	 txtBuscar = item.getNombre();
	
	 }
	 });
	 }
	
	 /*
	 * Getters & Setters
	 */
	 public String getTxtBuscar() {
	 return txtBuscar;
	 }
	
	 public void setTxtBuscar(String txtBuscar) {
	 this.txtBuscar = txtBuscar;
	 }
	
	 public List<DataCategoria> getLista() {
	 return lista;
	 }
	
	 public void setLista(List<DataCategoria> lista) {
	 this.lista = lista;
	 }
	
	 public boolean isVisible() {
	 return visible;
	 }
	
	 public void setVisible(boolean visible) {
	 this.visible = visible;
	 }
	
	 public int getIdMunicipio() {
	 return idMunicipio;
	 }
	
	 public void setIdMunicipio(int idMunicipio) {
	 this.idMunicipio = idMunicipio;
	 }
	
	

}
