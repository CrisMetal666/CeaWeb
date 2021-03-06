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
@Table(name = "tipo_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCategoria.findAll", query = "SELECT t FROM TipoCategoria t")
    , @NamedQuery(name = "TipoCategoria.findById", query = "SELECT t FROM TipoCategoria t WHERE t.id = :id")
    , @NamedQuery(name = "TipoCategoria.findByNombre", query = "SELECT t FROM TipoCategoria t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoCategoria.findByDescripcion", query = "SELECT t FROM TipoCategoria t WHERE t.descripcion = :descripcion")})
public class TipoCategoria implements Serializable {

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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoCategoria")
    private List<DataCategoria> dataCategoriaList;

    public TipoCategoria() {
    }

    public TipoCategoria(Integer id) {
        this.id = id;
    }

    public TipoCategoria(Integer id, String nombre, String descripcion) {
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

    @XmlTransient
    public List<DataCategoria> getDataCategoriaList() {
        return dataCategoriaList;
    }

    public void setDataCategoriaList(List<DataCategoria> dataCategoriaList) {
        this.dataCategoriaList = dataCategoriaList;
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
        if (!(object instanceof TipoCategoria)) {
            return false;
        }
        TipoCategoria other = (TipoCategoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.TipoCategoria[ id=" + id + " ]";
    }
    
}
