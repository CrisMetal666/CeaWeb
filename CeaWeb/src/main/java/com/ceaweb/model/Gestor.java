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
@Table(name = "gestor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestor.findAll", query = "SELECT g FROM Gestor g")
    , @NamedQuery(name = "Gestor.findById", query = "SELECT g FROM Gestor g WHERE g.id = :id")
    , @NamedQuery(name = "Gestor.findByNombreGestor", query = "SELECT g FROM Gestor g WHERE g.nombreGestor = :nombreGestor")
    , @NamedQuery(name = "Gestor.findByIdentificacion", query = "SELECT g FROM Gestor g WHERE g.identificacion = :identificacion")
    , @NamedQuery(name = "Gestor.findByTelefono", query = "SELECT g FROM Gestor g WHERE g.telefono = :telefono")})
public class Gestor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nombre_gestor")
    private String nombreGestor;
    
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    
    @JoinColumn(name = "idcea", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Cea idcea;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgestor")
    private List<CertificadosCea> certificadosCeaList;

    public Gestor() {
    }

    public Gestor(Integer id) {
        this.id = id;
    }

    public Gestor(Integer id, String nombreGestor, String identificacion, String telefono) {
        this.id = id;
        this.nombreGestor = nombreGestor;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreGestor() {
        return nombreGestor;
    }

    public void setNombreGestor(String nombreGestor) {
        this.nombreGestor = nombreGestor;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cea getIdcea() {
        return idcea;
    }

    public void setIdcea(Cea idcea) {
        this.idcea = idcea;
    }

    @XmlTransient
    public List<CertificadosCea> getCertificadosCeaList() {
        return certificadosCeaList;
    }

    public void setCertificadosCeaList(List<CertificadosCea> certificadosCeaList) {
        this.certificadosCeaList = certificadosCeaList;
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
        if (!(object instanceof Gestor)) {
            return false;
        }
        Gestor other = (Gestor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.Gestor[ id=" + id + " ]";
    }
    
}
