package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TOrdenExamenSucursal implements Serializable {

    /** identifier field */
    private java.lang.Integer kordenexamensucursal;

    /** nullable persistent field */
    private java.lang.String sexamen;

    /** nullable persistent field */
    private java.math.BigDecimal msubtotal;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentopromocion;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentoempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentomedico;

    /** nullable persistent field */
    private java.math.BigDecimal mfacturaempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mpagopaciente;

    /** nullable persistent field */
    private java.math.BigDecimal miva;

    /** nullable persistent field */
    private java.math.BigDecimal mtotal;

    /** identifier field */
    private int umuestra;    
    
    /** persistent field */
    private java.math.BigDecimal userid;

    /** nullable persistent field */
    private java.util.Date dresultadoentrega;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private int kpromocion;

    /** nullable persistent field */
    private java.lang.String smotivocancelacion;

    /** persistent field */
    private short uvolumenexamen;

    /** nullable persistent field */
    private java.util.Date dtomamuestrainicio;

    /** nullable persistent field */
    private java.util.Date dtomamuestratermino;
    
    /** nullable persistent field */
    private java.lang.String slogin_name;    
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil;    
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento clugarprocesamiento;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal tordensucursal;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio;

    /** persistent field */
    private Set tfacturaempresadetalles;
    
    /** full constructor */
    public TOrdenExamenSucursal(java.lang.Integer kordenexamensucursal, java.lang.String sexamen, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuentopromocion, java.math.BigDecimal mdescuentoempresa, java.math.BigDecimal mdescuentomedico, java.math.BigDecimal mfacturaempresa, java.math.BigDecimal mpagopaciente, java.math.BigDecimal miva, java.math.BigDecimal mtotal, int umuestra, java.math.BigDecimal userid,  java.util.Date  dresultadoentrega, java.util.Date dregistro, int kpromocion, java.lang.String smotivocancelacion, short uvolumenexamen, java.util.Date  dtomamuestrainicio, java.util.Date  dtomamuestratermino, String slogin_name, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento clugarprocesamiento, mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal tordensucursal, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio, mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil, Set tfacturaempresadetalles) {
        this.kordenexamensucursal = kordenexamensucursal;
        this.sexamen = sexamen;
        this.msubtotal = msubtotal;
        this.mdescuentopromocion = mdescuentopromocion;
        this.mdescuentoempresa = mdescuentoempresa;
        this.mdescuentomedico = mdescuentomedico;
        this.mfacturaempresa = mfacturaempresa;
        this.mpagopaciente = mpagopaciente;
        this.miva = miva;
        this.mtotal = mtotal;
        this.umuestra = umuestra;
        this.userid = userid;
        this.dresultadoentrega = dresultadoentrega;
        this.dregistro = dregistro;
        this.kpromocion = kpromocion;
        this.smotivocancelacion = smotivocancelacion;
        this.uvolumenexamen = uvolumenexamen;
        this.dtomamuestrainicio = dtomamuestrainicio;
        this.dtomamuestratermino = dtomamuestratermino;
        this.slogin_name = slogin_name;
        this.cexamen = cexamen;
        this.cestadoregistro = cestadoregistro;
        this.clugarprocesamiento = clugarprocesamiento;
        this.tordensucursal = tordensucursal;
        this.cconvenio = cconvenio;
        this.cperfil = cperfil;
        this.tfacturaempresadetalles = tfacturaempresadetalles;
    }

    /** default constructor */
    public TOrdenExamenSucursal() {
    }

    /** minimal constructor */
    public TOrdenExamenSucursal(java.lang.Integer kordenexamensucursal, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento clugarprocesamiento, mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal tordensucursal, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio, Set tfacturaempresadetalles) {
        this.kordenexamensucursal = kordenexamensucursal;
        this.userid = userid;
        this.cexamen = cexamen;
        this.cestadoregistro = cestadoregistro;
        this.clugarprocesamiento = clugarprocesamiento;
        this.tordensucursal = tordensucursal;
        this.cconvenio = cconvenio;
        this.tfacturaempresadetalles = tfacturaempresadetalles;
    }

    public java.lang.Integer getKordenexamensucursal() {
        return this.kordenexamensucursal;
    }

    public void setKordenexamensucursal(java.lang.Integer kordenexamensucursal) {
        this.kordenexamensucursal = kordenexamensucursal;
    }

    public java.lang.String getSexamen() {
        return this.sexamen;
    }

    public void setSexamen(java.lang.String sexamen) {
        this.sexamen = sexamen;
    }

    public java.math.BigDecimal getMsubtotal() {
        return this.msubtotal;
    }

    public void setMsubtotal(java.math.BigDecimal msubtotal) {
        this.msubtotal = msubtotal;
    }

    public java.math.BigDecimal getMdescuentopromocion() {
        return this.mdescuentopromocion;
    }

    public void setMdescuentopromocion(java.math.BigDecimal mdescuentopromocion) {
        this.mdescuentopromocion = mdescuentopromocion;
    }

    public java.math.BigDecimal getMdescuentoempresa() {
        return this.mdescuentoempresa;
    }

    public void setMdescuentoempresa(java.math.BigDecimal mdescuentoempresa) {
        this.mdescuentoempresa = mdescuentoempresa;
    }

    public java.math.BigDecimal getMdescuentomedico() {
        return this.mdescuentomedico;
    }

    public void setMdescuentomedico(java.math.BigDecimal mdescuentomedico) {
        this.mdescuentomedico = mdescuentomedico;
    }

    public java.math.BigDecimal getMfacturaempresa() {
        return this.mfacturaempresa;
    }

    public void setMfacturaempresa(java.math.BigDecimal mfacturaempresa) {
        this.mfacturaempresa = mfacturaempresa;
    }

    public java.math.BigDecimal getMpagopaciente() {
        return this.mpagopaciente;
    }

    public void setMpagopaciente(java.math.BigDecimal mpagopaciente) {
        this.mpagopaciente = mpagopaciente;
    }

    public java.math.BigDecimal getMiva() {
        return this.miva;
    }

    public void setMiva(java.math.BigDecimal miva) {
        this.miva = miva;
    }

    public java.math.BigDecimal getMtotal() {
        return this.mtotal;
    }

    public void setMtotal(java.math.BigDecimal mtotal) {
        this.mtotal = mtotal;
    }

    public int getUmuestra() {
        return this.umuestra;
    }

    public void setUmuestra(int umuestra) {
        this.umuestra = umuestra;
    }    
    
    public java.math.BigDecimal getUserid() {
        return this.userid;
    }

    public void setUserid(java.math.BigDecimal userid) {
        this.userid = userid;
    }

    public  java.util.Date  getDresultadoentrega() {
        return this.dresultadoentrega;
    }

    public void setDresultadoentrega( java.util.Date  dresultadoentrega) {
        this.dresultadoentrega = dresultadoentrega;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getKpromocion() {
        return this.kpromocion;
    }

    public void setKpromocion(int kpromocion) {
        this.kpromocion = kpromocion;
    }

    public java.lang.String getSmotivocancelacion() {
        return this.smotivocancelacion;
    }

    public void setSmotivocancelacion(java.lang.String smotivocancelacion) {
        this.smotivocancelacion = smotivocancelacion;
    }

    public short getUvolumenexamen() {
        return this.uvolumenexamen;
    }

    public void setUvolumenexamen(short uvolumenexamen) {
        this.uvolumenexamen = uvolumenexamen;
    }
    
    public java.util.Date getDtomamuestrainicio() {
        return this.dtomamuestrainicio;
    }

    public void setDtomamuestrainicio(java.util.Date dtomamuestrainicio) {
        this.dtomamuestrainicio = dtomamuestrainicio;
    }
    
    public java.util.Date getDtomamuestratermino() {
        return this.dtomamuestratermino;
    }

    public void setDtomamuestratermino(java.util.Date dtomamuestratermino) {
        this.dtomamuestratermino = dtomamuestratermino;
    }

    public java.lang.String getSlogin_name() {
        return this.slogin_name;
    }

    public void setSlogin_name(java.lang.String slogin_name) {
        this.slogin_name = slogin_name;
    }

       
    public mx.com.web2lab.backend.hbm.om.ap.CPerfil getCperfil() {
        return this.cperfil;
    }

    public void setCperfil(mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil) {
        this.cperfil = cperfil;
    }
    
    public mx.com.web2lab.backend.hbm.om.lis.CExamen getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen) {
        this.cexamen = cexamen;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento getClugarprocesamiento() {
        return this.clugarprocesamiento;
    }

    public void setClugarprocesamiento(mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento clugarprocesamiento) {
        this.clugarprocesamiento = clugarprocesamiento;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal getTordensucursal() {
        return this.tordensucursal;
    }

    public void setTordensucursal(mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal tordensucursal) {
        this.tordensucursal = tordensucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CConvenio getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.cconvenio = cconvenio;
    }

    public java.util.Set getTfacturaempresadetalles() {
        return this.tfacturaempresadetalles;
    }

    public void setTfacturaempresadetalles(java.util.Set tfacturaempresadetalles) {
        this.tfacturaempresadetalles = tfacturaempresadetalles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kordenexamensucursal", getKordenexamensucursal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TOrdenExamenSucursal) ) return false;
        TOrdenExamenSucursal castOther = (TOrdenExamenSucursal) other;
        return new EqualsBuilder()
            .append(this.getKordenexamensucursal(), castOther.getKordenexamensucursal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordenexamensucursal())
            .toHashCode();
    }

}
