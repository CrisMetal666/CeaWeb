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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findById", query = "SELECT e FROM Estado e WHERE e.id = :id")
    , @NamedQuery(name = "Estado.findByNombre", query = "SELECT e FROM Estado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estado.findByDescripcion", query = "SELECT e FROM Estado e WHERE e.descripcion = :descripcion")})
public class Estado implements Serializable {

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
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinColumn(name = "idtipo_estado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private TipoEstado idtipoEstado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<GestionCalidad> gestionCalidadList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<Vehiculo> vehiculoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<Instructor> instructorList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<Empleado> empleadoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<CertificadosCea> certificadosCeaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<DataCategoria> dataCategoriaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<Usuario> usuarioList;

    public Estado() {
    }

    public Estado(Integer id) {
        this.id = id;
    }

    public Estado(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoEstado getIdtipoEstado() {
        return idtipoEstado;
    }

    public void setIdtipoEstado(TipoEstado idtipoEstado) {
        this.idtipoEstado = idtipoEstado;
    }

    @XmlTransient
    public List<GestionCalidad> getGestionCalidadList() {
        return gestionCalidadList;
    }

    public void setGestionCalidadList(List<GestionCalidad> gestionCalidadList) {
        this.gestionCalidadList = gestionCalidadList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<CertificadosCea> getCertificadosCeaList() {
        return certificadosCeaList;
    }

    public void setCertificadosCeaList(List<CertificadosCea> certificadosCeaList) {
        this.certificadosCeaList = certificadosCeaList;
    }

    @XmlTransient
    public List<DataCategoria> getDataCategoriaList() {
        return dataCategoriaList;
    }

    public void setDataCategoriaList(List<DataCategoria> dataCategoriaList) {
        this.dataCategoriaList = dataCategoriaList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.Estado[ id=" + id + " ]";
    }
    
}
