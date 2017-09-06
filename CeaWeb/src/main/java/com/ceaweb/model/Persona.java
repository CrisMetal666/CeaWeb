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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id")
    , @NamedQuery(name = "Persona.findByIdentificacion", query = "SELECT p FROM Persona p WHERE p.identificacion = :identificacion")
    , @NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Persona.findByApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Persona.findByIndigena", query = "SELECT p FROM Persona p WHERE p.indigena = :indigena")
    , @NamedQuery(name = "Persona.findByAfrodecendiente", query = "SELECT p FROM Persona p WHERE p.afrodecendiente = :afrodecendiente")
    , @NamedQuery(name = "Persona.findByDesplazado", query = "SELECT p FROM Persona p WHERE p.desplazado = :desplazado")
    , @NamedQuery(name = "Persona.findByPoblacionFrontera", query = "SELECT p FROM Persona p WHERE p.poblacionFrontera = :poblacionFrontera")
    , @NamedQuery(name = "Persona.findByCabezaFamilia", query = "SELECT p FROM Persona p WHERE p.cabezaFamilia = :cabezaFamilia")
    , @NamedQuery(name = "Persona.findByReinsertado", query = "SELECT p FROM Persona p WHERE p.reinsertado = :reinsertado")
    , @NamedQuery(name = "Persona.findByPoblacionRoom", query = "SELECT p FROM Persona p WHERE p.poblacionRoom = :poblacionRoom")
    , @NamedQuery(name = "Persona.findByUrlFoto", query = "SELECT p FROM Persona p WHERE p.urlFoto = :urlFoto")
    , @NamedQuery(name = "Persona.findByRh", query = "SELECT p FROM Persona p WHERE p.rh = :rh")
    , @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email")
    , @NamedQuery(name = "Persona.findByUrlFirma", query = "SELECT p FROM Persona p WHERE p.urlFirma = :urlFirma")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Basic(optional = false)
    @Column(name = "indigena")
    private String indigena;
    
    @Basic(optional = false)
    @Column(name = "afrodecendiente")
    private String afrodecendiente;
    
    @Basic(optional = false)
    @Column(name = "desplazado")
    private String desplazado;
    
    @Basic(optional = false)
    @Column(name = "poblacion_frontera")
    private String poblacionFrontera;
    
    @Basic(optional = false)
    @Column(name = "cabeza_familia")
    private String cabezaFamilia;
    
    @Basic(optional = false)
    @Column(name = "reinsertado")
    private String reinsertado;
    
    @Basic(optional = false)
    @Column(name = "poblacion_room")
    private String poblacionRoom;
    
    //@Basic(optional = true)
    @Column(name = "url_foto", nullable = true)
    private String urlFoto;
    
    @Basic(optional = false)
    @Column(name = "rh")
    private String rh;
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    //@Basic(optional = true)
    @Column(name = "url_firma", nullable = true)
    private String urlFirma;
    
    @JoinColumn(name = "idcea", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Cea idcea;
    
    @JoinColumn(name = "lugar_origen", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria lugarOrigen;
    
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria genero;
    
    @JoinColumn(name = "estado_civil", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria estadoCivil;
    
    @JoinColumn(name = "estrato", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria estrato;
    
    @JoinColumn(name = "regimen_salud", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria regimenSalud;
    
    @JoinColumn(name = "ocupacion", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria ocupacion;
    
    @JoinColumn(name = "discapacidad", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria discapacidad;
    
    @JoinColumn(name = "nivel_formacion", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria nivelFormacion;
    
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private DataCategoria tipoDocumento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private List<CertificadosCea> certificadosCeaList;

    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(Integer id, String identificacion, String nombres, String apellidos, Date fechaNacimiento, String indigena, String afrodecendiente, String desplazado, String poblacionFrontera, String cabezaFamilia, String reinsertado, String poblacionRoom, String urlFoto, String rh, String email, String urlFirma) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.indigena = indigena;
        this.afrodecendiente = afrodecendiente;
        this.desplazado = desplazado;
        this.poblacionFrontera = poblacionFrontera;
        this.cabezaFamilia = cabezaFamilia;
        this.reinsertado = reinsertado;
        this.poblacionRoom = poblacionRoom;
        this.urlFoto = urlFoto;
        this.rh = rh;
        this.email = email;
        this.urlFirma = urlFirma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIndigena() {
        return indigena;
    }

    public void setIndigena(String indigena) {
        this.indigena = indigena;
    }

    public String getAfrodecendiente() {
        return afrodecendiente;
    }

    public void setAfrodecendiente(String afrodecendiente) {
        this.afrodecendiente = afrodecendiente;
    }

    public String getDesplazado() {
        return desplazado;
    }

    public void setDesplazado(String desplazado) {
        this.desplazado = desplazado;
    }

    public String getPoblacionFrontera() {
        return poblacionFrontera;
    }

    public void setPoblacionFrontera(String poblacionFrontera) {
        this.poblacionFrontera = poblacionFrontera;
    }

    public String getCabezaFamilia() {
        return cabezaFamilia;
    }

    public void setCabezaFamilia(String cabezaFamilia) {
        this.cabezaFamilia = cabezaFamilia;
    }

    public String getReinsertado() {
        return reinsertado;
    }

    public void setReinsertado(String reinsertado) {
        this.reinsertado = reinsertado;
    }

    public String getPoblacionRoom() {
        return poblacionRoom;
    }

    public void setPoblacionRoom(String poblacionRoom) {
        this.poblacionRoom = poblacionRoom;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlFirma() {
        return urlFirma;
    }

    public void setUrlFirma(String urlFirma) {
        this.urlFirma = urlFirma;
    }

    public Cea getIdcea() {
        return idcea;
    }

    public void setIdcea(Cea idcea) {
        this.idcea = idcea;
    }

    public DataCategoria getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(DataCategoria lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public DataCategoria getGenero() {
        return genero;
    }

    public void setGenero(DataCategoria genero) {
        this.genero = genero;
    }

    public DataCategoria getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(DataCategoria estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public DataCategoria getEstrato() {
        return estrato;
    }

    public void setEstrato(DataCategoria estrato) {
        this.estrato = estrato;
    }

    public DataCategoria getRegimenSalud() {
        return regimenSalud;
    }

    public void setRegimenSalud(DataCategoria regimenSalud) {
        this.regimenSalud = regimenSalud;
    }

    public DataCategoria getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(DataCategoria ocupacion) {
        this.ocupacion = ocupacion;
    }

    public DataCategoria getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(DataCategoria discapacidad) {
        this.discapacidad = discapacidad;
    }

    public DataCategoria getNivelFormacion() {
        return nivelFormacion;
    }

    public void setNivelFormacion(DataCategoria nivelFormacion) {
        this.nivelFormacion = nivelFormacion;
    }

    public DataCategoria getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(DataCategoria tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Persona [id=" + id + ", identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos="
				+ apellidos + ", fechaNacimiento=" + fechaNacimiento + ", indigena=" + indigena + ", afrodecendiente="
				+ afrodecendiente + ", desplazado=" + desplazado + ", poblacionFrontera=" + poblacionFrontera
				+ ", cabezaFamilia=" + cabezaFamilia + ", reinsertado=" + reinsertado + ", poblacionRoom="
				+ poblacionRoom + ", urlFoto=" + urlFoto + ", rh=" + rh + ", email=" + email + ", urlFirma=" + urlFirma
				+ ", idcea=" + idcea.getId() + ", lugarOrigen=" + lugarOrigen.getId() + ", genero=" + genero.getId() + ", estadoCivil="
				+ estadoCivil.getId() + ", estrato=" + estrato.getId() + ", regimenSalud=" + regimenSalud.getId() + ", ocupacion=" + ocupacion.getId()
				+ ", discapacidad=" + discapacidad + ", nivelFormacion=" + nivelFormacion + ", tipoDocumento="
				+ tipoDocumento.getId() +  "]";
	}

    
    
}
