package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TPaciente implements Serializable {

    /** identifier field */
    private java.lang.Integer kpaciente;

    /** nullable persistent field */
    private java.lang.String snombre;

    /** nullable persistent field */
    private java.lang.String sapellidopaterno;

    /** nullable persistent field */
    private java.lang.String sapellidomaterno;

    /** nullable persistent field */
    private int bsexo;

    /** nullable persistent field */
    private java.util.Date dnacimiento;

    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** nullable persistent field */
    private java.lang.String scorreoelectronico;

    /** nullable persistent field */
    private java.lang.String stelefono;

    /** nullable persistent field */
    private java.lang.String scelular;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private java.math.BigDecimal useridchange;

    /** nullable persistent field */
    private int uopcionenviocorreo;
    
    /** nullable persistent field */
    private java.lang.String spassword;

    /** nullable persistent field */
    private int uvisitaece;

    /** nullable persistent field */
    private java.lang.String spasswordenvio;

    private int utipopaciente;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca;

    /** persistent field */
    private Set tpacientedatoscomplementos;

    /** persistent field */
    private Set tordensucursals;

    /** persistent field */
    private Set tordensucursalcotizacions;

    /** persistent field */
    private Set tpacientemarketings;
    
    /** full constructor */
    public TPaciente(java.lang.Integer kpaciente, java.lang.String snombre, java.lang.String sapellidopaterno, java.lang.String sapellidomaterno, int bsexo, java.util.Date dnacimiento, java.lang.String sdireccion, java.lang.String scorreoelectronico, java.lang.String stelefono, java.lang.String scelular, java.math.BigDecimal userid, java.util.Date dregistro , java.math.BigDecimal useridchange , int uopcionenviocorreo , java.lang.String spassword ,int uvisitaece , java.lang.String spasswordenvio, int utipopaciente  , mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set tpacientedatoscomplementos, Set tordensucursals, Set tordensucursalcotizacions, Set tpacientemarketings) {
        this.kpaciente = kpaciente;
        this.snombre = snombre;
        this.sapellidopaterno = sapellidopaterno;
        this.sapellidomaterno = sapellidomaterno;
        this.bsexo = bsexo;
        this.dnacimiento = dnacimiento;
        this.sdireccion = sdireccion;
        this.scorreoelectronico = scorreoelectronico;
        this.stelefono = stelefono;
        this.scelular = scelular;
        this.userid = userid;
        this.dregistro = dregistro;
        this.useridchange = useridchange;
        this.uopcionenviocorreo = uopcionenviocorreo;
        this.spassword = spassword;
        this.spasswordenvio = spasswordenvio;
        this.utipopaciente = utipopaciente;
        this.ccodigopostal = ccodigopostal;
        this.cestadoregistro = cestadoregistro;
        this.cmarca = cmarca;
        this.tpacientedatoscomplementos = tpacientedatoscomplementos;
        this.tordensucursals = tordensucursals;
        this.tordensucursalcotizacions = tordensucursalcotizacions;
        this.tpacientemarketings = tpacientemarketings;
        this.uvisitaece = uvisitaece;
    }

    /** default constructor */
    public TPaciente() {
    }

    /** minimal constructor */
    public TPaciente(java.lang.Integer kpaciente, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set tpacientedatoscomplementos, Set tordensucursals, Set tpacientemarketings) {
        this.kpaciente = kpaciente;
        this.userid = userid;
        this.ccodigopostal = ccodigopostal;
        this.cestadoregistro = cestadoregistro;
        this.cmarca = cmarca;
        this.tpacientedatoscomplementos = tpacientedatoscomplementos;
        this.tordensucursals = tordensucursals;
        this.tpacientemarketings = tpacientemarketings;
    }

    public java.lang.Integer getKpaciente() {
        return this.kpaciente;
    }

    public void setKpaciente(java.lang.Integer kpaciente) {
        this.kpaciente = kpaciente;
    }

    public java.lang.String getSnombre() {
        return this.snombre;
    }

    public void setSnombre(java.lang.String snombre) {
        this.snombre = snombre;
    }

    public java.lang.String getSapellidopaterno() {
        return this.sapellidopaterno;
    }

    public void setSapellidopaterno(java.lang.String sapellidopaterno) {
        this.sapellidopaterno = sapellidopaterno;
    }

    public java.lang.String getSapellidomaterno() {
        return this.sapellidomaterno;
    }

    public void setSapellidomaterno(java.lang.String sapellidomaterno) {
        this.sapellidomaterno = sapellidomaterno;
    }

    public int isBsexo() {
        return this.bsexo;
    }

    public void setBsexo(int bsexo) {
        this.bsexo = bsexo;
    }

    public java.util.Date getDnacimiento() {
        return this.dnacimiento;
    }

    public void setDnacimiento(java.util.Date dnacimiento) {
        this.dnacimiento = dnacimiento;
    }

    public java.lang.String getSdireccion() {
        return this.sdireccion;
    }

    public void setSdireccion(java.lang.String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public java.lang.String getScorreoelectronico() {
        return this.scorreoelectronico;
    }

    public void setScorreoelectronico(java.lang.String scorreoelectronico) {
        this.scorreoelectronico = scorreoelectronico;
    }

    public java.lang.String getStelefono() {
        return this.stelefono;
    }

    public void setStelefono(java.lang.String stelefono) {
        this.stelefono = stelefono;
    }

    public java.lang.String getScelular() {
        return this.scelular;
    }

    public void setScelular(java.lang.String scelular) {
        this.scelular = scelular;
    }

    public java.math.BigDecimal getUserid() {
        return this.userid;
    }

    public void setUserid(java.math.BigDecimal userid) {
        this.userid = userid;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.math.BigDecimal getUseridchange() {
        return this.useridchange;
    }

    public void setUseridchange(java.math.BigDecimal useridchange) {
        this.useridchange = useridchange;
    }

    public int getUopcionenviocorreo() {
        return this.uopcionenviocorreo;
    }

    public void setUopcionenviocorreo(int uopcionenviocorreo) {
        this.uopcionenviocorreo = uopcionenviocorreo;
    }
    
    public java.lang.String getSpassword() {
        return this.spassword;
    }

    public void setSpassword(java.lang.String spassword) {
        this.spassword = spassword;
    }
    
    public int getUvisitaece() {
        return this.uvisitaece;
    }

    public void setUvisitaece(int uvisitaece) {
        this.uvisitaece = uvisitaece;
    }
    
    public int getUtipopaciente() {
        return this.utipopaciente;
    }

    public void setUtipopaciente(int utipopaciente) {
        this.utipopaciente = utipopaciente;
    }


    public java.lang.String getSpasswordenvio() {
        return this.spasswordenvio;
    }

    public void setSpasswordenvio(java.lang.String spasswordenvio) {
        this.spasswordenvio = spasswordenvio;
    }
    
    public mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal getCcodigopostal() {
        return this.ccodigopostal;
    }

    public void setCcodigopostal(mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal) {
        this.ccodigopostal = ccodigopostal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CMarca getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca) {
        this.cmarca = cmarca;
    }

    public java.util.Set getTpacientedatoscomplementos() {
        return this.tpacientedatoscomplementos;
    }

    public void setTpacientedatoscomplementos(java.util.Set tpacientedatoscomplementos) {
        this.tpacientedatoscomplementos = tpacientedatoscomplementos;
    }

    public java.util.Set getTordensucursals() {
        return this.tordensucursals;
    }

    public void setTordensucursals(java.util.Set tordenSucursals) {
        this.tordensucursals = tordensucursals;
    }

    public java.util.Set getTordensucursalcotizacions() {
        return this.tordensucursalcotizacions;
    }

    public void setTordensucursalcotizacions(java.util.Set tordensucursalcotizacions) {
        this.tordensucursalcotizacions = tordensucursalcotizacions;
    }

    public java.util.Set getTpacientemarketings() {
        return this.tpacientemarketings;
    }

    public void setTpacientemarketings(java.util.Set tpacientemarketings) {
        this.tpacientemarketings = tpacientemarketings;
    }

    
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("kpaciente", getKpaciente())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TPaciente) ) return false;
        TPaciente castOther = (TPaciente) other;
        return new EqualsBuilder()
            .append(this.getKpaciente(), castOther.getKpaciente())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKpaciente())
            .toHashCode();
    }

}
