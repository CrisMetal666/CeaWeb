/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceaweb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crismetal
 */
@Entity
@Table(name = "cargo_extra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargoExtra.findAll", query = "SELECT c FROM CargoExtra c")
    , @NamedQuery(name = "CargoExtra.findById", query = "SELECT c FROM CargoExtra c WHERE c.id = :id")
    , @NamedQuery(name = "CargoExtra.findByNombre", query = "SELECT c FROM CargoExtra c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CargoExtra.findByValor", query = "SELECT c FROM CargoExtra c WHERE c.valor = :valor")
    , @NamedQuery(name = "CargoExtra.findByEdadMin", query = "SELECT c FROM CargoExtra c WHERE c.edadMin = :edadMin")
    , @NamedQuery(name = "CargoExtra.findByEdadMax", query = "SELECT c FROM CargoExtra c WHERE c.edadMax = :edadMax")
    , @NamedQuery(name = "CargoExtra.findByGenero", query = "SELECT c FROM CargoExtra c WHERE c.genero = :genero")
    , @NamedQuery(name = "CargoExtra.findByCategoria", query = "SELECT c FROM CargoExtra c WHERE c.categoria = :categoria")})
public class CargoExtra implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "valor")
    private int valor;
    
    @Basic(optional = false)
    @Column(name = "edad_min")
    private int edadMin;
    
    @Basic(optional = false)
    @Column(name = "edad_max")
    private int edadMax;
    
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;
    
    @JoinColumn(name = "idtipo_cargo_extra", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private TipoCargoExtra idtipoCargoExtra;

    public CargoExtra() {
    }

    public CargoExtra(Integer id) {
        this.id = id;
    }

    public CargoExtra(Integer id, String nombre, int valor, int edadMin, int edadMax, String genero, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.genero = genero;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    public int getEdadMax() {
        return edadMax;
    }

    public void setEdadMax(int edadMax) {
        this.edadMax = edadMax;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public TipoCargoExtra getIdtipoCargoExtra() {
        return idtipoCargoExtra;
    }

    public void setIdtipoCargoExtra(TipoCargoExtra idtipoCargoExtra) {
        this.idtipoCargoExtra = idtipoCargoExtra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoExtra)) {
            return false;
        }
        CargoExtra other = (CargoExtra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.CargoExtra[ id=" + id + " ]";
    }
    
}
