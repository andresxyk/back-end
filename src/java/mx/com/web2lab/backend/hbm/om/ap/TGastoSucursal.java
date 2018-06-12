package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TGastoSucursal implements Serializable {

    /** identifier field */
    private java.lang.Integer kgastosucursal;

    /** nullable persistent field */
    private java.lang.String sgastosucursal;

    /** nullable persistent field */
    private java.math.BigDecimal msubtotalgasto;

    /** nullable persistent field */
    private java.math.BigDecimal mivagasto;

    /** nullable persistent field */
    private java.math.BigDecimal mtotalgasto;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja;

    /** full constructor */
    public TGastoSucursal(java.lang.Integer kgastosucursal, java.lang.String sgastosucursal, java.math.BigDecimal msubtotalgasto, java.math.BigDecimal mivagasto, java.math.BigDecimal mtotalgasto, java.math.BigDecimal userid, java.util.Date dregistro, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal, mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja) {
        this.kgastosucursal = kgastosucursal;
        this.sgastosucursal = sgastosucursal;
        this.msubtotalgasto = msubtotalgasto;
        this.mivagasto = mivagasto;
        this.mtotalgasto = mtotalgasto;
        this.userid = userid;
        this.dregistro = dregistro;
        this.cestadoregistro = cestadoregistro;
        this.csucursal = csucursal;
        this.tcortecaja = tcortecaja;
    }

    /** default constructor */
    public TGastoSucursal() {
    }

    /** minimal constructor */
    public TGastoSucursal(java.lang.Integer kgastosucursal, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal, mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja) {
        this.kgastosucursal = kgastosucursal;
        this.userid = userid;
        this.cestadoregistro = cestadoregistro;
        this.csucursal = csucursal;
        this.tcortecaja = tcortecaja;
    }

    public java.lang.Integer getKgastosucursal() {
        return this.kgastosucursal;
    }

    public void setKgastosucursal(java.lang.Integer kgastosucursal) {
        this.kgastosucursal = kgastosucursal;
    }

    public java.lang.String getSgastosucursal() {
        return this.sgastosucursal;
    }

    public void setSgastosucursal(java.lang.String sgastosucursal) {
        this.sgastosucursal = sgastosucursal;
    }

    public java.math.BigDecimal getMsubtotalgasto() {
        return this.msubtotalgasto;
    }

    public void setMsubtotalgasto(java.math.BigDecimal msubtotalgasto) {
        this.msubtotalgasto = msubtotalgasto;
    }

    public java.math.BigDecimal getMivagasto() {
        return this.mivagasto;
    }

    public void setMivagasto(java.math.BigDecimal mivagasto) {
        this.mivagasto = mivagasto;
    }

    public java.math.BigDecimal getMtotalgasto() {
        return this.mtotalgasto;
    }

    public void setMtotalgasto(java.math.BigDecimal mtotalgasto) {
        this.mtotalgasto = mtotalgasto;
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

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CSucursal getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal) {
        this.csucursal = csucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TCorteCaja getTcortecaja() {
        return this.tcortecaja;
    }

    public void setTcortecaja(mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja) {
        this.tcortecaja = tcortecaja;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kgastosucursal", getKgastosucursal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TGastoSucursal) ) return false;
        TGastoSucursal castOther = (TGastoSucursal) other;
        return new EqualsBuilder()
            .append(this.getKgastosucursal(), castOther.getKgastosucursal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKgastosucursal())
            .toHashCode();
    }

}
