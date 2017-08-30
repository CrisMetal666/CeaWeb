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
@Table(name = "tipo_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstado.findAll", query = "SELECT t FROM TipoEstado t")
    , @NamedQuery(name = "TipoEstado.findById", query = "SELECT t FROM TipoEstado t WHERE t.id = :id")
    , @NamedQuery(name = "TipoEstado.findByTipoEstado", query = "SELECT t FROM TipoEstado t WHERE t.tipoEstado = :tipoEstado")
    , @NamedQuery(name = "TipoEstado.findByDescripcion", query = "SELECT t FROM TipoEstado t WHERE t.descripcion = :descripcion")})
public class TipoEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "tipo_estado")
    private String tipoEstado;
    
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoEstado")
    private List<Estado> estadoList;

    public TipoEstado() {
    }

    public TipoEstado(Integer id) {
        this.id = id;
    }

    public TipoEstado(Integer id, String tipoEstado, String descripcion) {
        this.id = id;
        this.tipoEstado = tipoEstado;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
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
        if (!(object instanceof TipoEstado)) {
            return false;
        }
        TipoEstado other = (TipoEstado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.TipoEstado[ id=" + id + " ]";
    }
    
}
