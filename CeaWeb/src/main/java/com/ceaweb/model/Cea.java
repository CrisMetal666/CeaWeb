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
@Table(name = "cea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cea.findAll", query = "SELECT c FROM Cea c")
    , @NamedQuery(name = "Cea.findById", query = "SELECT c FROM Cea c WHERE c.id = :id")
    , @NamedQuery(name = "Cea.findByNombre", query = "SELECT c FROM Cea c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cea.findByNit", query = "SELECT c FROM Cea c WHERE c.nit = :nit")
    , @NamedQuery(name = "Cea.findByTelefono", query = "SELECT c FROM Cea c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Cea.findByDireccion", query = "SELECT c FROM Cea c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Cea.findByUrlLogo", query = "SELECT c FROM Cea c WHERE c.urlLogo = :urlLogo")
    , @NamedQuery(name = "Cea.findByResolucionMintransporte", query = "SELECT c FROM Cea c WHERE c.resolucionMintransporte = :resolucionMintransporte")
    , @NamedQuery(name = "Cea.findByResolucionMineducacion", query = "SELECT c FROM Cea c WHERE c.resolucionMineducacion = :resolucionMineducacion")
    , @NamedQuery(name = "Cea.findByConsecutivoMatricula", query = "SELECT c FROM Cea c WHERE c.consecutivoMatricula = :consecutivoMatricula")})
public class Cea implements Serializable {

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
    @Column(name = "nit")
    private String nit;
    
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    
    @Basic(optional = false)
    @Column(name = "url_logo")
    private String urlLogo;
    
    @Basic(optional = false)
    @Column(name = "resolucion_mintransporte")
    private String resolucionMintransporte;
    
    @Basic(optional = false)
    @Column(name = "resolucion_mineducacion")
    private String resolucionMineducacion;
    
    @Basic(optional = false)
    @Column(name = "consecutivo_matricula")
    private int consecutivoMatricula;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcea")
    private List<Persona> personaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcea")
    private List<CategoriaCea> categoriaCeaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcea")
    private List<GestionCalidad> gestionCalidadList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcea")
    private List<Gestor> gestorList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcea")
    private List<Vehiculo> vehiculoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcea")
    private List<TipoEmpleado> tipoEmpleadoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcea")
    private List<Empleado> empleadoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcea")
    private List<CertificadosCea> certificadosCeaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcea")
    private List<Auditoria> auditoriaList;
    
    @JoinColumn(name = "idcategoria_ciudad", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria idcategoriaCiudad;

    public Cea() {
    }

    public Cea(Integer id) {
        this.id = id;
    }

    public Cea(Integer id, String nombre, String nit, String telefono, String direccion, String urlLogo, String resolucionMintransporte, String resolucionMineducacion, int consecutivoMatricula) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.urlLogo = urlLogo;
        this.resolucionMintransporte = resolucionMintransporte;
        this.resolucionMineducacion = resolucionMineducacion;
        this.consecutivoMatricula = consecutivoMatricula;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getResolucionMintransporte() {
        return resolucionMintransporte;
    }

    public void setResolucionMintransporte(String resolucionMintransporte) {
        this.resolucionMintransporte = resolucionMintransporte;
    }

    public String getResolucionMineducacion() {
        return resolucionMineducacion;
    }

    public void setResolucionMineducacion(String resolucionMineducacion) {
        this.resolucionMineducacion = resolucionMineducacion;
    }

    public int getConsecutivoMatricula() {
        return consecutivoMatricula;
    }

    public void setConsecutivoMatricula(int consecutivoMatricula) {
        this.consecutivoMatricula = consecutivoMatricula;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<CategoriaCea> getCategoriaCeaList() {
        return categoriaCeaList;
    }

    public void setCategoriaCeaList(List<CategoriaCea> categoriaCeaList) {
        this.categoriaCeaList = categoriaCeaList;
    }

    @XmlTransient
    public List<GestionCalidad> getGestionCalidadList() {
        return gestionCalidadList;
    }

    public void setGestionCalidadList(List<GestionCalidad> gestionCalidadList) {
        this.gestionCalidadList = gestionCalidadList;
    }

    @XmlTransient
    public List<Gestor> getGestorList() {
        return gestorList;
    }

    public void setGestorList(List<Gestor> gestorList) {
        this.gestorList = gestorList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<TipoEmpleado> getTipoEmpleadoList() {
        return tipoEmpleadoList;
    }

    public void setTipoEmpleadoList(List<TipoEmpleado> tipoEmpleadoList) {
        this.tipoEmpleadoList = tipoEmpleadoList;
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
    public List<Auditoria> getAuditoriaList() {
        return auditoriaList;
    }

    public void setAuditoriaList(List<Auditoria> auditoriaList) {
        this.auditoriaList = auditoriaList;
    }

    public DataCategoria getIdcategoriaCiudad() {
        return idcategoriaCiudad;
    }

    public void setIdcategoriaCiudad(DataCategoria idcategoriaCiudad) {
        this.idcategoriaCiudad = idcategoriaCiudad;
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
        if (!(object instanceof Cea)) {
            return false;
        }
        Cea other = (Cea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.Cea[ id=" + id + " ]";
    }
    
}
