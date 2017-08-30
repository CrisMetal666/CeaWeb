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
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findById", query = "SELECT a FROM Auditoria a WHERE a.id = :id")
    , @NamedQuery(name = "Auditoria.findByTablaReferencia", query = "SELECT a FROM Auditoria a WHERE a.tablaReferencia = :tablaReferencia")
    , @NamedQuery(name = "Auditoria.findByCampoReferencia", query = "SELECT a FROM Auditoria a WHERE a.campoReferencia = :campoReferencia")
    , @NamedQuery(name = "Auditoria.findByValorActual", query = "SELECT a FROM Auditoria a WHERE a.valorActual = :valorActual")
    , @NamedQuery(name = "Auditoria.findByValorNuevo", query = "SELECT a FROM Auditoria a WHERE a.valorNuevo = :valorNuevo")
    , @NamedQuery(name = "Auditoria.findByFechaCambio", query = "SELECT a FROM Auditoria a WHERE a.fechaCambio = :fechaCambio")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "tabla_referencia")
    private String tablaReferencia;
    
    @Basic(optional = false)
    @Column(name = "campo_referencia")
    private String campoReferencia;
    
    @Basic(optional = false)
    @Column(name = "valor_actual")
    private String valorActual;
    
    @Basic(optional = false)
    @Column(name = "valor_nuevo")
    private String valorNuevo;
    
    @Basic(optional = false)
    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.DATE)
    private Date fechaCambio;
    
    @JoinColumn(name = "idcea", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Cea idcea;

    public Auditoria() {
    }

    public Auditoria(Integer id) {
        this.id = id;
    }

    public Auditoria(Integer id, String tablaReferencia, String campoReferencia, String valorActual, String valorNuevo, Date fechaCambio) {
        this.id = id;
        this.tablaReferencia = tablaReferencia;
        this.campoReferencia = campoReferencia;
        this.valorActual = valorActual;
        this.valorNuevo = valorNuevo;
        this.fechaCambio = fechaCambio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTablaReferencia() {
        return tablaReferencia;
    }

    public void setTablaReferencia(String tablaReferencia) {
        this.tablaReferencia = tablaReferencia;
    }

    public String getCampoReferencia() {
        return campoReferencia;
    }

    public void setCampoReferencia(String campoReferencia) {
        this.campoReferencia = campoReferencia;
    }

    public String getValorActual() {
        return valorActual;
    }

    public void setValorActual(String valorActual) {
        this.valorActual = valorActual;
    }

    public String getValorNuevo() {
        return valorNuevo;
    }

    public void setValorNuevo(String valorNuevo) {
        this.valorNuevo = valorNuevo;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Cea getIdcea() {
        return idcea;
    }

    public void setIdcea(Cea idcea) {
        this.idcea = idcea;
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
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.Auditoria[ id=" + id + " ]";
    }
    
}
