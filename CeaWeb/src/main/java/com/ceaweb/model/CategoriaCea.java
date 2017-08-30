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
@Table(name = "categoria_cea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaCea.findAll", query = "SELECT c FROM CategoriaCea c")
    , @NamedQuery(name = "CategoriaCea.findById", query = "SELECT c FROM CategoriaCea c WHERE c.id = :id")
    , @NamedQuery(name = "CategoriaCea.findByCategoriaCea", query = "SELECT c FROM CategoriaCea c WHERE c.categoriaCea = :categoriaCea")
    , @NamedQuery(name = "CategoriaCea.findByHorasTotal", query = "SELECT c FROM CategoriaCea c WHERE c.horasTotal = :horasTotal")
    , @NamedQuery(name = "CategoriaCea.findByHorasTeoria", query = "SELECT c FROM CategoriaCea c WHERE c.horasTeoria = :horasTeoria")
    , @NamedQuery(name = "CategoriaCea.findByHorasPractica", query = "SELECT c FROM CategoriaCea c WHERE c.horasPractica = :horasPractica")
    , @NamedQuery(name = "CategoriaCea.findByHorasTaller", query = "SELECT c FROM CategoriaCea c WHERE c.horasTaller = :horasTaller")
    , @NamedQuery(name = "CategoriaCea.findByValorServicioActual", query = "SELECT c FROM CategoriaCea c WHERE c.valorServicioActual = :valorServicioActual")})
public class CategoriaCea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "categoria_cea")
    private String categoriaCea;
    
    @Basic(optional = false)
    @Column(name = "horas_total")
    private int horasTotal;
    
    @Basic(optional = false)
    @Column(name = "horas_teoria")
    private int horasTeoria;
    
    @Basic(optional = false)
    @Column(name = "horas_practica")
    private int horasPractica;
    
    @Basic(optional = false)
    @Column(name = "horas_taller")
    private int horasTaller;
    
    @Basic(optional = false)
    @Column(name = "valor_servicio_actual")
    private int valorServicioActual;
    
    @JoinColumn(name = "idcea", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Cea idcea;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategoriaCea")
    private List<CertificadosCea> certificadosCeaList;

    public CategoriaCea() {
    }

    public CategoriaCea(Integer id) {
        this.id = id;
    }

    public CategoriaCea(Integer id, String categoriaCea, int horasTotal, int horasTeoria, int horasPractica, int horasTaller, int valorServicioActual) {
        this.id = id;
        this.categoriaCea = categoriaCea;
        this.horasTotal = horasTotal;
        this.horasTeoria = horasTeoria;
        this.horasPractica = horasPractica;
        this.horasTaller = horasTaller;
        this.valorServicioActual = valorServicioActual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoriaCea() {
        return categoriaCea;
    }

    public void setCategoriaCea(String categoriaCea) {
        this.categoriaCea = categoriaCea;
    }

    public int getHorasTotal() {
        return horasTotal;
    }

    public void setHorasTotal(int horasTotal) {
        this.horasTotal = horasTotal;
    }

    public int getHorasTeoria() {
        return horasTeoria;
    }

    public void setHorasTeoria(int horasTeoria) {
        this.horasTeoria = horasTeoria;
    }

    public int getHorasPractica() {
        return horasPractica;
    }

    public void setHorasPractica(int horasPractica) {
        this.horasPractica = horasPractica;
    }

    public int getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(int horasTaller) {
        this.horasTaller = horasTaller;
    }

    public int getValorServicioActual() {
        return valorServicioActual;
    }

    public void setValorServicioActual(int valorServicioActual) {
        this.valorServicioActual = valorServicioActual;
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
        if (!(object instanceof CategoriaCea)) {
            return false;
        }
        CategoriaCea other = (CategoriaCea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.CategoriaCea[ id=" + id + " ]";
    }
    
}
