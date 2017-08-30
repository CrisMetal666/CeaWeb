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
@Table(name = "certificados_cea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CertificadosCea.findAll", query = "SELECT c FROM CertificadosCea c")
    , @NamedQuery(name = "CertificadosCea.findById", query = "SELECT c FROM CertificadosCea c WHERE c.id = :id")
    , @NamedQuery(name = "CertificadosCea.findByConsecutivo", query = "SELECT c FROM CertificadosCea c WHERE c.consecutivo = :consecutivo")
    , @NamedQuery(name = "CertificadosCea.findByFechaIngreso", query = "SELECT c FROM CertificadosCea c WHERE c.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "CertificadosCea.findByFechaCertificacion", query = "SELECT c FROM CertificadosCea c WHERE c.fechaCertificacion = :fechaCertificacion")
    , @NamedQuery(name = "CertificadosCea.findBySolicitudRunt", query = "SELECT c FROM CertificadosCea c WHERE c.solicitudRunt = :solicitudRunt")
    , @NamedQuery(name = "CertificadosCea.findByCertificacoRunt", query = "SELECT c FROM CertificadosCea c WHERE c.certificacoRunt = :certificacoRunt")
    , @NamedQuery(name = "CertificadosCea.findByObservaciones", query = "SELECT c FROM CertificadosCea c WHERE c.observaciones = :observaciones")
    , @NamedQuery(name = "CertificadosCea.findByValorServicio", query = "SELECT c FROM CertificadosCea c WHERE c.valorServicio = :valorServicio")
    , @NamedQuery(name = "CertificadosCea.findByCuota1", query = "SELECT c FROM CertificadosCea c WHERE c.cuota1 = :cuota1")
    , @NamedQuery(name = "CertificadosCea.findByCouta2", query = "SELECT c FROM CertificadosCea c WHERE c.couta2 = :couta2")
    , @NamedQuery(name = "CertificadosCea.findByRecaudo", query = "SELECT c FROM CertificadosCea c WHERE c.recaudo = :recaudo")
    , @NamedQuery(name = "CertificadosCea.findBySicov", query = "SELECT c FROM CertificadosCea c WHERE c.sicov = :sicov")
    , @NamedQuery(name = "CertificadosCea.findByAnsv", query = "SELECT c FROM CertificadosCea c WHERE c.ansv = :ansv")})
public class CertificadosCea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "consecutivo")
    private int consecutivo;
    
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @Basic(optional = false)
    @Column(name = "fecha_certificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCertificacion;
    
    @Basic(optional = false)
    @Column(name = "solicitud_runt")
    private String solicitudRunt;
    
    @Basic(optional = false)
    @Column(name = "certificaco_runt")
    private String certificacoRunt;
    
    @Basic(optional = false)
    @Column(name = "observaciones")
    private String observaciones;
    
    @Basic(optional = false)
    @Column(name = "valor_servicio")
    private int valorServicio;
    
    @Basic(optional = false)
    @Column(name = "cuota1")
    private int cuota1;
    
    @Basic(optional = false)
    @Column(name = "couta2")
    private int couta2;
    
    @Basic(optional = false)
    @Column(name = "recaudo")
    private int recaudo;
    
    @Basic(optional = false)
    @Column(name = "sicov")
    private int sicov;
    
    @Basic(optional = false)
    @Column(name = "ansv")
    private int ansv;
    
    @JoinColumn(name = "idcea", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Cea idcea;
    
    @JoinColumn(name = "idcategoria_cea", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private CategoriaCea idcategoriaCea;
    
    @JoinColumn(name = "id_jornada_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria idJornadaCategoria;
    
    @JoinColumn(name = "idtramite_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria idtramiteCategoria;
    
    @JoinColumn(name = "idempleado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Empleado idempleado;
    
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Estado idestado;
    
    @JoinColumn(name = "idgestion_calidad", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private GestionCalidad idgestionCalidad;
    
    @JoinColumn(name = "idgestor", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Gestor idgestor;
    
    @JoinColumn(name = "idintructor", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Instructor idintructor;
    
    @JoinColumn(name = "idpersona", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Persona idpersona;
    
    @JoinColumn(name = "idvehiculo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Vehiculo idvehiculo;

    public CertificadosCea() {
    }

    public CertificadosCea(Integer id) {
        this.id = id;
    }

    public CertificadosCea(Integer id, int consecutivo, Date fechaIngreso, Date fechaCertificacion, String solicitudRunt, String certificacoRunt, String observaciones, int valorServicio, int cuota1, int couta2, int recaudo, int sicov, int ansv) {
        this.id = id;
        this.consecutivo = consecutivo;
        this.fechaIngreso = fechaIngreso;
        this.fechaCertificacion = fechaCertificacion;
        this.solicitudRunt = solicitudRunt;
        this.certificacoRunt = certificacoRunt;
        this.observaciones = observaciones;
        this.valorServicio = valorServicio;
        this.cuota1 = cuota1;
        this.couta2 = couta2;
        this.recaudo = recaudo;
        this.sicov = sicov;
        this.ansv = ansv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaCertificacion() {
        return fechaCertificacion;
    }

    public void setFechaCertificacion(Date fechaCertificacion) {
        this.fechaCertificacion = fechaCertificacion;
    }

    public String getSolicitudRunt() {
        return solicitudRunt;
    }

    public void setSolicitudRunt(String solicitudRunt) {
        this.solicitudRunt = solicitudRunt;
    }

    public String getCertificacoRunt() {
        return certificacoRunt;
    }

    public void setCertificacoRunt(String certificacoRunt) {
        this.certificacoRunt = certificacoRunt;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(int valorServicio) {
        this.valorServicio = valorServicio;
    }

    public int getCuota1() {
        return cuota1;
    }

    public void setCuota1(int cuota1) {
        this.cuota1 = cuota1;
    }

    public int getCouta2() {
        return couta2;
    }

    public void setCouta2(int couta2) {
        this.couta2 = couta2;
    }

    public int getRecaudo() {
        return recaudo;
    }

    public void setRecaudo(int recaudo) {
        this.recaudo = recaudo;
    }

    public int getSicov() {
        return sicov;
    }

    public void setSicov(int sicov) {
        this.sicov = sicov;
    }

    public int getAnsv() {
        return ansv;
    }

    public void setAnsv(int ansv) {
        this.ansv = ansv;
    }

    public Cea getIdcea() {
        return idcea;
    }

    public void setIdcea(Cea idcea) {
        this.idcea = idcea;
    }

    public CategoriaCea getIdcategoriaCea() {
        return idcategoriaCea;
    }

    public void setIdcategoriaCea(CategoriaCea idcategoriaCea) {
        this.idcategoriaCea = idcategoriaCea;
    }

    public DataCategoria getIdJornadaCategoria() {
        return idJornadaCategoria;
    }

    public void setIdJornadaCategoria(DataCategoria idJornadaCategoria) {
        this.idJornadaCategoria = idJornadaCategoria;
    }

    public DataCategoria getIdtramiteCategoria() {
        return idtramiteCategoria;
    }

    public void setIdtramiteCategoria(DataCategoria idtramiteCategoria) {
        this.idtramiteCategoria = idtramiteCategoria;
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

    public GestionCalidad getIdgestionCalidad() {
        return idgestionCalidad;
    }

    public void setIdgestionCalidad(GestionCalidad idgestionCalidad) {
        this.idgestionCalidad = idgestionCalidad;
    }

    public Gestor getIdgestor() {
        return idgestor;
    }

    public void setIdgestor(Gestor idgestor) {
        this.idgestor = idgestor;
    }

    public Instructor getIdintructor() {
        return idintructor;
    }

    public void setIdintructor(Instructor idintructor) {
        this.idintructor = idintructor;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
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
        if (!(object instanceof CertificadosCea)) {
            return false;
        }
        CertificadosCea other = (CertificadosCea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.CertificadosCea[ id=" + id + " ]";
    }
    
}
