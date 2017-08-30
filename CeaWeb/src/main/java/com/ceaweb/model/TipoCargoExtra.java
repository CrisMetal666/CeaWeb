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
@Table(name = "tipo_cargo_extra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCargoExtra.findAll", query = "SELECT t FROM TipoCargoExtra t")
    , @NamedQuery(name = "TipoCargoExtra.findById", query = "SELECT t FROM TipoCargoExtra t WHERE t.id = :id")
    , @NamedQuery(name = "TipoCargoExtra.findByTipoCargo", query = "SELECT t FROM TipoCargoExtra t WHERE t.tipoCargo = :tipoCargo")})
public class TipoCargoExtra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "tipo_cargo")
    private String tipoCargo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoCargoExtra")
    private List<CargoExtra> cargoExtraList;

    public TipoCargoExtra() {
    }

    public TipoCargoExtra(Integer id) {
        this.id = id;
    }

    public TipoCargoExtra(Integer id, String tipoCargo) {
        this.id = id;
        this.tipoCargo = tipoCargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    @XmlTransient
    public List<CargoExtra> getCargoExtraList() {
        return cargoExtraList;
    }

    public void setCargoExtraList(List<CargoExtra> cargoExtraList) {
        this.cargoExtraList = cargoExtraList;
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
        if (!(object instanceof TipoCargoExtra)) {
            return false;
        }
        TipoCargoExtra other = (TipoCargoExtra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.TipoCargoExtra[ id=" + id + " ]";
    }
    
}
