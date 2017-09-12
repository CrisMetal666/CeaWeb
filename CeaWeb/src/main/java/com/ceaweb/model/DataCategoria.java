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
@Table(name = "data_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataCategoria.findAll", query = "SELECT d FROM DataCategoria d")
    , @NamedQuery(name = "DataCategoria.findById", query = "SELECT d FROM DataCategoria d WHERE d.id = :id")
    , @NamedQuery(name = "DataCategoria.findByNombre", query = "SELECT d FROM DataCategoria d WHERE d.nombre = :nombre")})
public class DataCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugarOrigen")
    private List<Persona> personaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero")
    private List<Persona> personaList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCivil")
    private List<Persona> personaList2;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estrato")
    private List<Persona> personaList3;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regimenSalud")
    private List<Persona> personaList4;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ocupacion")
    private List<Persona> personaList5;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discapacidad")
    private List<Persona> personaList6;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelFormacion")
    private List<Persona> personaList7;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private List<Persona> personaList8;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoVehiculoCategoria")
    private List<Vehiculo> vehiculoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoIdentificacion")
    private List<Empleado> empleadoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idescolaridad")
    private List<Empleado> empleadoList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJornadaCategoria")
    private List<CertificadosCea> certificadosCeaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtramiteCategoria")
    private List<CertificadosCea> certificadosCeaList1;
    
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Estado idestado;
    
    @JoinColumn(name = "idtipo_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private TipoCategoria idtipoCategoria;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategoriaCiudad")
    private List<Cea> ceaList;

    public DataCategoria() {
    }

    public DataCategoria(Integer id) {
        this.id = id;
    }

    public DataCategoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Persona> getPersonaList1() {
        return personaList1;
    }

    public void setPersonaList1(List<Persona> personaList1) {
        this.personaList1 = personaList1;
    }

    @XmlTransient
    public List<Persona> getPersonaList2() {
        return personaList2;
    }

    public void setPersonaList2(List<Persona> personaList2) {
        this.personaList2 = personaList2;
    }

    @XmlTransient
    public List<Persona> getPersonaList3() {
        return personaList3;
    }

    public void setPersonaList3(List<Persona> personaList3) {
        this.personaList3 = personaList3;
    }

    @XmlTransient
    public List<Persona> getPersonaList4() {
        return personaList4;
    }

    public void setPersonaList4(List<Persona> personaList4) {
        this.personaList4 = personaList4;
    }

    @XmlTransient
    public List<Persona> getPersonaList5() {
        return personaList5;
    }

    public void setPersonaList5(List<Persona> personaList5) {
        this.personaList5 = personaList5;
    }

    @XmlTransient
    public List<Persona> getPersonaList6() {
        return personaList6;
    }

    public void setPersonaList6(List<Persona> personaList6) {
        this.personaList6 = personaList6;
    }

    @XmlTransient
    public List<Persona> getPersonaList7() {
        return personaList7;
    }

    public void setPersonaList7(List<Persona> personaList7) {
        this.personaList7 = personaList7;
    }

    @XmlTransient
    public List<Persona> getPersonaList8() {
        return personaList8;
    }

    public void setPersonaList8(List<Persona> personaList8) {
        this.personaList8 = personaList8;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList1() {
        return empleadoList1;
    }

    public void setEmpleadoList1(List<Empleado> empleadoList1) {
        this.empleadoList1 = empleadoList1;
    }

    @XmlTransient
    public List<CertificadosCea> getCertificadosCeaList() {
        return certificadosCeaList;
    }

    public void setCertificadosCeaList(List<CertificadosCea> certificadosCeaList) {
        this.certificadosCeaList = certificadosCeaList;
    }

    @XmlTransient
    public List<CertificadosCea> getCertificadosCeaList1() {
        return certificadosCeaList1;
    }

    public void setCertificadosCeaList1(List<CertificadosCea> certificadosCeaList1) {
        this.certificadosCeaList1 = certificadosCeaList1;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    public TipoCategoria getIdtipoCategoria() {
        return idtipoCategoria;
    }

    public void setIdtipoCategoria(TipoCategoria idtipoCategoria) {
        this.idtipoCategoria = idtipoCategoria;
    }

    @XmlTransient
    public List<Cea> getCeaList() {
        return ceaList;
    }

    public void setCeaList(List<Cea> ceaList) {
        this.ceaList = ceaList;
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
        if (!(object instanceof DataCategoria)) {
            return false;
        }
        DataCategoria other = (DataCategoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return nombre;
	}

  
    
}
