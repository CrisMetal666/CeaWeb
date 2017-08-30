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
@Table(name = "gestion_calidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionCalidad.findAll", query = "SELECT g FROM GestionCalidad g")
    , @NamedQuery(name = "GestionCalidad.findById", query = "SELECT g FROM GestionCalidad g WHERE g.id = :id")
    , @NamedQuery(name = "GestionCalidad.findByNombreFormato", query = "SELECT g FROM GestionCalidad g WHERE g.nombreFormato = :nombreFormato")
    , @NamedQuery(name = "GestionCalidad.findByCodigo", query = "SELECT g FROM GestionCalidad g WHERE g.codigo = :codigo")
    , @NamedQuery(name = "GestionCalidad.findByVigencia", query = "SELECT g FROM GestionCalidad g WHERE g.vigencia = :vigencia")
    , @NamedQuery(name = "GestionCalidad.findByVersion", query = "SELECT g FROM GestionCalidad g WHERE g.version = :version")
    , @NamedQuery(name = "GestionCalidad.findByUrlFormato", query = "SELECT g FROM GestionCalidad g WHERE g.urlFormato = :urlFormato")})
public class GestionCalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nombre_formato")
    private String nombreFormato;
    
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    
    @Basic(optional = false)
    @Column(name = "vigencia")
    private String vigencia;
    
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    
    @Basic(optional = false)
    @Column(name = "url_formato")
    private String urlFormato;
    
    @JoinColumn(name = "idcea", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Cea idcea;
    
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Estado idestado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgestionCalidad")
    private List<CertificadosCea> certificadosCeaList;

    public GestionCalidad() {
    }

    public GestionCalidad(Integer id) {
        this.id = id;
    }

    public GestionCalidad(Integer id, String nombreFormato, String codigo, String vigencia, int version, String urlFormato) {
        this.id = id;
        this.nombreFormato = nombreFormato;
        this.codigo = codigo;
        this.vigencia = vigencia;
        this.version = version;
        this.urlFormato = urlFormato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreFormato() {
        return nombreFormato;
    }

    public void setNombreFormato(String nombreFormato) {
        this.nombreFormato = nombreFormato;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUrlFormato() {
        return urlFormato;
    }

    public void setUrlFormato(String urlFormato) {
        this.urlFormato = urlFormato;
    }

    public Cea getIdcea() {
        return idcea;
    }

    public void setIdcea(Cea idcea) {
        this.idcea = idcea;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
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
        if (!(object instanceof GestionCalidad)) {
            return false;
        }
        GestionCalidad other = (GestionCalidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.GestionCalidad[ id=" + id + " ]";
    }
    
}
