package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TPagoPaciente implements Serializable {

    /** identifier field */
    private java.lang.Integer kpagopaciente;

    /** nullable persistent field */
    private java.math.BigDecimal mpagopacientetotal;

    /** nullable persistent field */
    private java.math.BigDecimal manticipo;

    /** nullable persistent field */
    private java.math.BigDecimal mpagopacienteparcial;

    /** nullable persistent field */
    private java.math.BigDecimal mdevolucionpaciente;

    /** nullable persistent field */
    private java.math.BigDecimal msaldo;

    /** nullable persistent field */
    private int userid;

    /** nullable persistent field */
    private java.util.Date dregistro;
    
    private String sdigitostarjeta;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CTipoPago ctipopago;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal tordensucursal;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja;

    /** full constructor */
    public TPagoPaciente(java.lang.Integer kpagopaciente, java.math.BigDecimal mpagopacientetotal, java.math.BigDecimal manticipo, java.math.BigDecimal mpagopacienteparcial, java.math.BigDecimal mdevolucionpaciente, java.math.BigDecimal msaldo, int userid, java.util.Date dregistro, String sdigitostarjeta, mx.com.web2lab.backend.hbm.om.ap.CTipoPago ctipopago, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal tordensucursal, mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja) {
        this.kpagopaciente = kpagopaciente;
        this.mpagopacientetotal = mpagopacientetotal;
        this.manticipo = manticipo;
        this.mpagopacienteparcial = mpagopacienteparcial;
        this.mdevolucionpaciente = mdevolucionpaciente;
        this.msaldo = msaldo;
        this.userid = userid;
        this.dregistro = dregistro;
        this.sdigitostarjeta = sdigitostarjeta;
        this.ctipopago = ctipopago;
        this.cestadoregistro = cestadoregistro;
        this.tordensucursal = tordensucursal;
        this.tcortecaja = tcortecaja;
    }

    /** default constructor */
    public TPagoPaciente() {
    }

    /** minimal constructor */
    public TPagoPaciente(java.lang.Integer kpagopaciente, mx.com.web2lab.backend.hbm.om.ap.CTipoPago ctipopago, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal tordensucursal, mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja) {
        this.kpagopaciente = kpagopaciente;
        this.ctipopago = ctipopago;
        this.cestadoregistro = cestadoregistro;
        this.tordensucursal = tordensucursal;
        this.tcortecaja = tcortecaja;
    }

    public java.lang.Integer getKpagopaciente() {
        return this.kpagopaciente;
    }

    public void setKpagopaciente(java.lang.Integer kpagopaciente) {
        this.kpagopaciente = kpagopaciente;
    }

    public java.math.BigDecimal getMpagopacientetotal() {
        return this.mpagopacientetotal;
    }

    public void setMpagopacientetotal(java.math.BigDecimal mpagopacientetotal) {
        this.mpagopacientetotal = mpagopacientetotal;
    }

    public java.math.BigDecimal getManticipo() {
        return this.manticipo;
    }

    public void setManticipo(java.math.BigDecimal manticipo) {
        this.manticipo = manticipo;
    }

    public java.math.BigDecimal getMpagopacienteparcial() {
        return this.mpagopacienteparcial;
    }

    public void setMpagopacienteparcial(java.math.BigDecimal mpagopacienteparcial) {
        this.mpagopacienteparcial = mpagopacienteparcial;
    }

    public java.math.BigDecimal getMdevolucionpaciente() {
        return this.mdevolucionpaciente;
    }

    public void setMdevolucionpaciente(java.math.BigDecimal mdevolucionpaciente) {
        this.mdevolucionpaciente = mdevolucionpaciente;
    }

    public java.math.BigDecimal getMsaldo() {
        return this.msaldo;
    }

    public void setMsaldo(java.math.BigDecimal msaldo) {
        this.msaldo = msaldo;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }
    
    public java.lang.String getSdigitostarjeta() {
        return this.sdigitostarjeta;
    }

    public void setSdigitostarjeta(java.lang.String sdigitostarjeta) {
        this.sdigitostarjeta = sdigitostarjeta;
    }
    

    public mx.com.web2lab.backend.hbm.om.ap.CTipoPago getCtipopago() {
        return this.ctipopago;
    }

    public void setCtipopago(mx.com.web2lab.backend.hbm.om.ap.CTipoPago ctipopago) {
        this.ctipopago = ctipopago;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal getTordensucursal() {
        return this.tordensucursal;
    }

    public void setTordensucursal(mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal tordensucursal) {
        this.tordensucursal = tordensucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TCorteCaja getTcortecaja() {
        return this.tcortecaja;
    }

    public void setTcortecaja(mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja) {
        this.tcortecaja = tcortecaja;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kpagopaciente", getKpagopaciente())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TPagoPaciente) ) return false;
        TPagoPaciente castOther = (TPagoPaciente) other;
        return new EqualsBuilder()
            .append(this.getKpagopaciente(), castOther.getKpagopaciente())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKpagopaciente())
            .toHashCode();
    }

}
