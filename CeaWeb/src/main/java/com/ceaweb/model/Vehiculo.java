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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findById", query = "SELECT v FROM Vehiculo v WHERE v.id = :id")
    , @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa")
    , @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculo.findByFechaVenSoat", query = "SELECT v FROM Vehiculo v WHERE v.fechaVenSoat = :fechaVenSoat")
    , @NamedQuery(name = "Vehiculo.findByFechaVenRtm", query = "SELECT v FROM Vehiculo v WHERE v.fechaVenRtm = :fechaVenRtm")
    , @NamedQuery(name = "Vehiculo.findByFechaMatricula", query = "SELECT v FROM Vehiculo v WHERE v.fechaMatricula = :fechaMatricula")
    , @NamedQuery(name = "Vehiculo.findByFechaIngreso", query = "SELECT v FROM Vehiculo v WHERE v.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Vehiculo.findByFechaSalida", query = "SELECT v FROM Vehiculo v WHERE v.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Vehiculo.findByFechaVenServicio", query = "SELECT v FROM Vehiculo v WHERE v.fechaVenServicio = :fechaVenServicio")
    , @NamedQuery(name = "Vehiculo.findByVin", query = "SELECT v FROM Vehiculo v WHERE v.vin = :vin")
    , @NamedQuery(name = "Vehiculo.findByNumeroMotor", query = "SELECT v FROM Vehiculo v WHERE v.numeroMotor = :numeroMotor")
    , @NamedQuery(name = "Vehiculo.findByNumeroChasis", query = "SELECT v FROM Vehiculo v WHERE v.numeroChasis = :numeroChasis")
    , @NamedQuery(name = "Vehiculo.findByKmCambioAceite", query = "SELECT v FROM Vehiculo v WHERE v.kmCambioAceite = :kmCambioAceite")
    , @NamedQuery(name = "Vehiculo.findByProximoCambioAceite", query = "SELECT v FROM Vehiculo v WHERE v.proximoCambioAceite = :proximoCambioAceite")
    , @NamedQuery(name = "Vehiculo.findByKmProximoCambioCorrea", query = "SELECT v FROM Vehiculo v WHERE v.kmProximoCambioCorrea = :kmProximoCambioCorrea")
    , @NamedQuery(name = "Vehiculo.findByKmActual", query = "SELECT v FROM Vehiculo v WHERE v.kmActual = :kmActual")
    , @NamedQuery(name = "Vehiculo.findByUrlFoto", query = "SELECT v FROM Vehiculo v WHERE v.urlFoto = :urlFoto")
    , @NamedQuery(name = "Vehiculo.findByUrlSoat", query = "SELECT v FROM Vehiculo v WHERE v.urlSoat = :urlSoat")
    , @NamedQuery(name = "Vehiculo.findByUrlRtm", query = "SELECT v FROM Vehiculo v WHERE v.urlRtm = :urlRtm")
    , @NamedQuery(name = "Vehiculo.findByUrlTarjetaPropiedad", query = "SELECT v FROM Vehiculo v WHERE v.urlTarjetaPropiedad = :urlTarjetaPropiedad")
    , @NamedQuery(name = "Vehiculo.findByUrlTarjetaServicio", query = "SELECT v FROM Vehiculo v WHERE v.urlTarjetaServicio = :urlTarjetaServicio")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    
    @Basic(optional = false)
    @Column(name = "modelo")
    private int modelo;
    
    @Basic(optional = false)
    @Column(name = "fecha_ven_soat")
    @Temporal(TemporalType.DATE)
    private Date fechaVenSoat;
    
    @Basic(optional = false)
    @Column(name = "fecha_ven_rtm")
    @Temporal(TemporalType.DATE)
    private Date fechaVenRtm;
    
    @Basic(optional = false)
    @Column(name = "fecha_matricula")
    @Temporal(TemporalType.DATE)
    private Date fechaMatricula;
    
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @Basic(optional = false)
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    
    @Basic(optional = false)
    @Column(name = "fecha_ven_servicio")
    @Temporal(TemporalType.DATE)
    private Date fechaVenServicio;
    
    @Basic(optional = false)
    @Column(name = "vin")
    private String vin;
    
    @Basic(optional = false)
    @Column(name = "numero_motor")
    private String numeroMotor;
    
    @Basic(optional = false)
    @Column(name = "numero_chasis")
    private String numeroChasis;
    
    @Basic(optional = false)
    @Column(name = "km_cambio_aceite")
    private int kmCambioAceite;
    
    @Basic(optional = false)
    @Column(name = "proximo_cambio_aceite")
    private int proximoCambioAceite;
    
    @Basic(optional = false)
    @Column(name = "km_proximo_cambio_correa")
    private int kmProximoCambioCorrea;
    
    @Basic(optional = false)
    @Column(name = "km_actual")
    private int kmActual;
    
    @Basic(optional = false)
    @Column(name = "url_foto")
    private String urlFoto;
    
    @Basic(optional = false)
    @Column(name = "url_soat")
    private String urlSoat;
    
    @Basic(optional = false)
    @Column(name = "url_rtm")
    private String urlRtm;
    
    @Basic(optional = false)
    @Column(name = "url_tarjeta_propiedad")
    private String urlTarjetaPropiedad;
    
    @Basic(optional = false)
    @Column(name = "url_tarjeta_servicio")
    private String urlTarjetaServicio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvehiculo")
    private List<ActividadesVehiculo> actividadesVehiculoList;
    
    @JoinColumn(name = "idcea", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Cea idcea;
    
    @JoinColumn(name = "idtipo_vehiculo_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria idtipoVehiculoCategoria;
    
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Estado idestado;
    
    @JoinColumn(name = "idintructor", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Instructor idintructor;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvehiculo")
    private List<CertificadosCea> certificadosCeaList;

    public Vehiculo() {
    }

    public Vehiculo(Integer id) {
        this.id = id;
    }

    public Vehiculo(Integer id, String placa, String marca, int modelo, Date fechaVenSoat, Date fechaVenRtm, Date fechaMatricula, Date fechaIngreso, Date fechaSalida, Date fechaVenServicio, String vin, String numeroMotor, String numeroChasis, int kmCambioAceite, int proximoCambioAceite, int kmProximoCambioCorrea, int kmActual, String urlFoto, String urlSoat, String urlRtm, String urlTarjetaPropiedad, String urlTarjetaServicio) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaVenSoat = fechaVenSoat;
        this.fechaVenRtm = fechaVenRtm;
        this.fechaMatricula = fechaMatricula;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.fechaVenServicio = fechaVenServicio;
        this.vin = vin;
        this.numeroMotor = numeroMotor;
        this.numeroChasis = numeroChasis;
        this.kmCambioAceite = kmCambioAceite;
        this.proximoCambioAceite = proximoCambioAceite;
        this.kmProximoCambioCorrea = kmProximoCambioCorrea;
        this.kmActual = kmActual;
        this.urlFoto = urlFoto;
        this.urlSoat = urlSoat;
        this.urlRtm = urlRtm;
        this.urlTarjetaPropiedad = urlTarjetaPropiedad;
        this.urlTarjetaServicio = urlTarjetaServicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public Date getFechaVenSoat() {
        return fechaVenSoat;
    }

    public void setFechaVenSoat(Date fechaVenSoat) {
        this.fechaVenSoat = fechaVenSoat;
    }

    public Date getFechaVenRtm() {
        return fechaVenRtm;
    }

    public void setFechaVenRtm(Date fechaVenRtm) {
        this.fechaVenRtm = fechaVenRtm;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaVenServicio() {
        return fechaVenServicio;
    }

    public void setFechaVenServicio(Date fechaVenServicio) {
        this.fechaVenServicio = fechaVenServicio;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public int getKmCambioAceite() {
        return kmCambioAceite;
    }

    public void setKmCambioAceite(int kmCambioAceite) {
        this.kmCambioAceite = kmCambioAceite;
    }

    public int getProximoCambioAceite() {
        return proximoCambioAceite;
    }

    public void setProximoCambioAceite(int proximoCambioAceite) {
        this.proximoCambioAceite = proximoCambioAceite;
    }

    public int getKmProximoCambioCorrea() {
        return kmProximoCambioCorrea;
    }

    public void setKmProximoCambioCorrea(int kmProximoCambioCorrea) {
        this.kmProximoCambioCorrea = kmProximoCambioCorrea;
    }

    public int getKmActual() {
        return kmActual;
    }

    public void setKmActual(int kmActual) {
        this.kmActual = kmActual;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlSoat() {
        return urlSoat;
    }

    public void setUrlSoat(String urlSoat) {
        this.urlSoat = urlSoat;
    }

    public String getUrlRtm() {
        return urlRtm;
    }

    public void setUrlRtm(String urlRtm) {
        this.urlRtm = urlRtm;
    }

    public String getUrlTarjetaPropiedad() {
        return urlTarjetaPropiedad;
    }

    public void setUrlTarjetaPropiedad(String urlTarjetaPropiedad) {
        this.urlTarjetaPropiedad = urlTarjetaPropiedad;
    }

    public String getUrlTarjetaServicio() {
        return urlTarjetaServicio;
    }

    public void setUrlTarjetaServicio(String urlTarjetaServicio) {
        this.urlTarjetaServicio = urlTarjetaServicio;
    }

    @XmlTransient
    public List<ActividadesVehiculo> getActividadesVehiculoList() {
        return actividadesVehiculoList;
    }

    public void setActividadesVehiculoList(List<ActividadesVehiculo> actividadesVehiculoList) {
        this.actividadesVehiculoList = actividadesVehiculoList;
    }

    public Cea getIdcea() {
        return idcea;
    }

    public void setIdcea(Cea idcea) {
        this.idcea = idcea;
    }

    public DataCategoria getIdtipoVehiculoCategoria() {
        return idtipoVehiculoCategoria;
    }

    public void setIdtipoVehiculoCategoria(DataCategoria idtipoVehiculoCategoria) {
        this.idtipoVehiculoCategoria = idtipoVehiculoCategoria;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    public Instructor getIdintructor() {
        return idintructor;
    }

    public void setIdintructor(Instructor idintructor) {
        this.idintructor = idintructor;
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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceaweb.Vehiculo[ id=" + id + " ]";
    }
    
}
