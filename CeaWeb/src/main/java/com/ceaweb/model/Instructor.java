/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceaweb.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crismetal
 */
@Entity
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findById", query = "SELECT i FROM Instructor i WHERE i.id = :id")
    , @NamedQuery(name = "Instructor.findByLicenciaInstructor", query = "SELECT i FROM Instructor i WHERE i.licenciaInstructor = :licenciaInstructor")
    , @NamedQuery(name = "Instructor.findByLicenciaInstructorVen", query = "SELECT i FROM Instructor i WHERE i.licenciaInstructorVen = :licenciaInstructorVen")
    , @NamedQuery(name = "Instructor.findByLicenciaVencimiento", query = "SELECT i FROM Instructor i WHERE i.licenciaVencimiento = :licenciaVencimiento")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "licencia_instructor")
    private String licenciaInstructor;
    
    @Basic(optional = false)
    @Column(name = "licencia_instructor_ven")
    @Temporal(TemporalType.DATE)
    private Date licenciaInstructorVen;
    
    @Basic(optional = false)
    @Column(name = "licencia_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date licenciaVencimiento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idintructor")
    private List<Vehiculo> vehiculoList;
    
    @JoinColumn(name = "idempleado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Empleado idempleado;
    
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Estado idestado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idintructor")
    private List<CertificadosCea> certificadosCeaList;

    public Instructor() {
    }

    public Instructor(Integer id) {
        this.id = id;
    }

    public Instructor(Integer id, String licenciaInstructor, Date licenciaInstructorVen, Date licenciaVencimiento) {
        this.id = id;
        this.licenciaInstructor = licenciaInstructor;
        this.licenciaInstructorVen = licenciaInstructorVen;
        this.licenciaVencimiento = licenciaVencimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicenciaInstructor() {
        return licenciaInstructor;
    }

    public void setLicenciaInstructor(String licenciaInstructor) {
        this.licenciaInstructor = licenciaInstructor;
    }

    public Date getLicenciaInstructorVen() {
        return licenciaInstructorVen;
    }

    public void setLicenciaInstructorVen(Date licenciaInstructorVen) {
        this.licenciaInstructorVen = licenciaInstructorVen;
    }

    public Date getLicenciaVencimiento() {
        return licenciaVencimiento;
    }

    public void setLicenciaVencimiento(Date licenciaVencimiento) {
        this.licenciaVencimiento = licenciaVencimiento;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
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
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.Instructor[ id=" + id + " ]";
    }
    
}
