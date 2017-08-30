/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceaweb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crismetal
 */
@Entity
@Table(name = "actividad_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadVehiculo.findAll", query = "SELECT a FROM ActividadVehiculo a")
    , @NamedQuery(name = "ActividadVehiculo.findById", query = "SELECT a FROM ActividadVehiculo a WHERE a.id = :id")
    , @NamedQuery(name = "ActividadVehiculo.findByNombre", query = "SELECT a FROM ActividadVehiculo a WHERE a.nombre = :nombre")})
public class ActividadVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactividadVehiculo")
    private List<ActividadesVehiculo> actividadesVehiculoList;

    public ActividadVehiculo() {
    }

    public ActividadVehiculo(Integer id) {
        this.id = id;
    }

    public ActividadVehiculo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @XmlTransient
    public List<ActividadesVehiculo> getActividadesVehiculoList() {
        return actividadesVehiculoList;
    }

    public void setActividadesVehiculoList(List<ActividadesVehiculo> actividadesVehiculoList) {
        this.actividadesVehiculoList = actividadesVehiculoList;
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
        if (!(object instanceof ActividadVehiculo)) {
            return false;
        }
        ActividadVehiculo other = (ActividadVehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.ActividadVehiculo[ id=" + id + " ]";
    }
    
}
