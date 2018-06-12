package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TOrdenFacturaSucursal implements Serializable {

    /** identifier field */
    private java.lang.Integer kordenfacturasucursal;

    /** persistent field */
    private int kordensucursal;

    /** nullable persistent field */
    private int cfactura;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private java.math.BigDecimal userId;

    /** persistent field */
    private int cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TDatoFactura tdatofactura;

    /** full constructor */
    public TOrdenFacturaSucursal(java.lang.Integer kordenfacturasucursal, int kordensucursal, int cfactura, java.util.Date dregistro, java.math.BigDecimal userId, int cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.TDatoFactura tdatofactura) {
        this.kordenfacturasucursal = kordenfacturasucursal;
        this.kordensucursal = kordensucursal;
        this.cfactura = cfactura;
        this.dregistro = dregistro;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.tdatofactura = tdatofactura;
    }

    /** default constructor */
    public TOrdenFacturaSucursal() {
    }

    /** minimal constructor */
    public TOrdenFacturaSucursal(java.lang.Integer kordenfacturasucursal, int kordensucursal, java.math.BigDecimal userId, int cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.TDatoFactura tdatofactura) {
        this.kordenfacturasucursal = kordenfacturasucursal;
        this.kordensucursal = kordensucursal;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.tdatofactura = tdatofactura;
    }

    public java.lang.Integer getKordenfacturasucursal() {
        return this.kordenfacturasucursal;
    }

    public void setKordenfacturasucursal(java.lang.Integer kordenfacturasucursal) {
        this.kordenfacturasucursal = kordenfacturasucursal;
    }

    public int getKordensucursal() {
        return this.kordensucursal;
    }

    public void setKordensucursal(int kordensucursal) {
        this.kordensucursal = kordensucursal;
    }

    public int getCfactura() {
        return this.cfactura;
    }

    public void setCfactura(int cfactura) {
        this.cfactura = cfactura;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.math.BigDecimal getUserid() {
        return this.userId;
    }

    public void setUserid(java.math.BigDecimal userId) {
        this.userId = userId;
    }

    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TDatoFactura getTdatofactura() {
        return this.tdatofactura;
    }

    public void setTdatofactura(mx.com.web2lab.backend.hbm.om.ap.TDatoFactura tdatofactura) {
        this.tdatofactura = tdatofactura;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kordenfacturasucursal", getKordenfacturasucursal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TOrdenFacturaSucursal) ) return false;
        TOrdenFacturaSucursal castOther = (TOrdenFacturaSucursal) other;
        return new EqualsBuilder()
            .append(this.getKordenfacturasucursal(), castOther.getKordenfacturasucursal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordenfacturasucursal())
            .toHashCode();
    }
}
