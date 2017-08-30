/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceaweb.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crismetal
 */
@Entity
@Table(name = "actividades_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadesVehiculo.findAll", query = "SELECT a FROM ActividadesVehiculo a")
    , @NamedQuery(name = "ActividadesVehiculo.findById", query = "SELECT a FROM ActividadesVehiculo a WHERE a.id = :id")
    , @NamedQuery(name = "ActividadesVehiculo.findByFechaActividad", query = "SELECT a FROM ActividadesVehiculo a WHERE a.fechaActividad = :fechaActividad")
    , @NamedQuery(name = "ActividadesVehiculo.findByDescripcion", query = "SELECT a FROM ActividadesVehiculo a WHERE a.descripcion = :descripcion")})
public class ActividadesVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "fecha_actividad")
    @Temporal(TemporalType.DATE)
    private Date fechaActividad;
    
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinColumn(name = "idactividad_vehiculo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private ActividadVehiculo idactividadVehiculo;
    
    @JoinColumn(name = "idvehiculo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Vehiculo idvehiculo;

    public ActividadesVehiculo() {
    }

    public ActividadesVehiculo(Integer id) {
        this.id = id;
    }

    public ActividadesVehiculo(Integer id, Date fechaActividad, String descripcion) {
        this.id = id;
        this.fechaActividad = fechaActividad;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaActividad() {
        return fechaActividad;
    }

    public void setFechaActividad(Date fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ActividadVehiculo getIdactividadVehiculo() {
        return idactividadVehiculo;
    }

    public void setIdactividadVehiculo(ActividadVehiculo idactividadVehiculo) {
        this.idactividadVehiculo = idactividadVehiculo;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
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
        if (!(object instanceof ActividadesVehiculo)) {
            return false;
        }
        ActividadesVehiculo other = (ActividadesVehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.ActividadesVehiculo[ id=" + id + " ]";
    }
    
}
