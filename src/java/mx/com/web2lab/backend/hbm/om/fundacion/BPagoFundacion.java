package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BPagoFundacion implements Serializable {

    /** identifier field */
    private java.lang.Integer kpagofundacion;

    /** persistent field */
    private java.util.Date dfechapago;

    /** persistent field */
    private java.math.BigDecimal mpago;

    /** nullable persistent field */
    private java.math.BigDecimal macuenta;

    /** nullable persistent field */
    private java.math.BigDecimal madeuda;

    /** nullable persistent field */
    private int cestado;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private int cusuario;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.BCorteCajaFundacion bcortecajafundacion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion;

    /** full constructor */
    public BPagoFundacion(java.util.Date dfechapago, java.math.BigDecimal mpago, java.math.BigDecimal macuenta, java.math.BigDecimal madeuda, int cestado, boolean bregistroactivo, int cusuario, java.util.Date dregistro, mx.com.web2lab.backend.hbm.om.fundacion.BCorteCajaFundacion bcortecajafundacion, mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion) {
        this.dfechapago = dfechapago;
        this.mpago = mpago;
        this.macuenta = macuenta;
        this.madeuda = madeuda;
        this.cestado = cestado;
        this.bregistroactivo = bregistroactivo;
        this.cusuario = cusuario;
        this.dregistro = dregistro;
        this.bcortecajafundacion = bcortecajafundacion;
        this.bordenfundacion = bordenfundacion;
    }

    /** default constructor */
    public BPagoFundacion() {
    }

    /** minimal constructor */
    public BPagoFundacion(java.util.Date dfechapago, java.math.BigDecimal mpago, int cusuario, mx.com.web2lab.backend.hbm.om.fundacion.BCorteCajaFundacion bcortecajafundacion, mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion) {
        this.dfechapago = dfechapago;
        this.mpago = mpago;
        this.cusuario = cusuario;
        this.bcortecajafundacion = bcortecajafundacion;
        this.bordenfundacion = bordenfundacion;
    }

    public java.lang.Integer getKpagofundacion() {
        return this.kpagofundacion;
    }

    public void setKpagofundacion(java.lang.Integer kpagofundacion) {
        this.kpagofundacion = kpagofundacion;
    }

    public java.util.Date getDfechapago() {
        return this.dfechapago;
    }

    public void setDfechapago(java.util.Date dfechapago) {
        this.dfechapago = dfechapago;
    }

    public java.math.BigDecimal getMpago() {
        return this.mpago;
    }

    public void setMpago(java.math.BigDecimal mpago) {
        this.mpago = mpago;
    }

    public java.math.BigDecimal getMacuenta() {
        return this.macuenta;
    }

    public void setMacuenta(java.math.BigDecimal macuenta) {
        this.macuenta = macuenta;
    }

    public java.math.BigDecimal getMadeuda() {
        return this.madeuda;
    }

    public void setMadeuda(java.math.BigDecimal madeuda) {
        this.madeuda = madeuda;
    }

    public int getCestado() {
        return this.cestado;
    }

    public void setCestado(int cestado) {
        this.cestado = cestado;
    }

    public boolean isBregistroactivo() {
        return this.bregistroactivo;
    }

    public void setBregistroactivo(boolean bregistroactivo) {
        this.bregistroactivo = bregistroactivo;
    }

    public int getCusuario() {
        return this.cusuario;
    }

    public void setCusuario(int cusuario) {
        this.cusuario = cusuario;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.BCorteCajaFundacion getBcortecajafundacion() {
        return this.bcortecajafundacion;
    }

    public void setBcortecajafundacion(mx.com.web2lab.backend.hbm.om.fundacion.BCorteCajaFundacion bcortecajafundacion) {
        this.bcortecajafundacion = bcortecajafundacion;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion getBordenfundacion() {
        return this.bordenfundacion;
    }

    public void setBordenfundacion(mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion) {
        this.bordenfundacion = bordenfundacion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kpagofundacion", getKpagofundacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BPagoFundacion) ) return false;
        BPagoFundacion castOther = (BPagoFundacion) other;
        return new EqualsBuilder()
            .append(this.getKpagofundacion(), castOther.getKpagofundacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKpagofundacion())
            .toHashCode();
    }

}
