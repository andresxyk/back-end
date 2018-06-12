package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BOrdenExamenFundacion implements Serializable {

    /** identifier field */
    private java.lang.Long kordenexamenfundacion;

    /** nullable persistent field */
    private java.util.Date dpromesa;

    /** nullable persistent field */
    private java.math.BigDecimal msubtotal;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuento;

    /** nullable persistent field */
    private java.math.BigDecimal mtotal;

    /** nullable persistent field */
    private int umuestra;

    /** nullable persistent field */
    private int cestado;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private int cusuario;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.lang.String sobservacion;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion cexamenfundacion;

    /** full constructor */
    public BOrdenExamenFundacion(java.util.Date dpromesa, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuento, java.math.BigDecimal mtotal, int umuestra, int cestado, boolean bregistroactivo, int cusuario, java.util.Date dregistro, java.lang.String sobservacion, mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion, mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion cexamenfundacion) {
        this.dpromesa = dpromesa;
        this.msubtotal = msubtotal;
        this.mdescuento = mdescuento;
        this.mtotal = mtotal;
        this.umuestra = umuestra;
        this.cestado = cestado;
        this.bregistroactivo = bregistroactivo;
        this.cusuario = cusuario;
        this.dregistro = dregistro;
        this.sobservacion = sobservacion;
        this.bordenfundacion = bordenfundacion;
        this.cexamenfundacion = cexamenfundacion;
    }

    /** default constructor */
    public BOrdenExamenFundacion() {
    }

    /** minimal constructor */
    public BOrdenExamenFundacion(int cusuario, mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion, mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion cexamenfundacion) {
        this.cusuario = cusuario;
        this.bordenfundacion = bordenfundacion;
        this.cexamenfundacion = cexamenfundacion;
    }

    public java.lang.Long getKordenexamenfundacion() {
        return this.kordenexamenfundacion;
    }

    public void setKordenexamenfundacion(java.lang.Long kordenexamenfundacion) {
        this.kordenexamenfundacion = kordenexamenfundacion;
    }

    public java.util.Date getDpromesa() {
        return this.dpromesa;
    }

    public void setDpromesa(java.util.Date dpromesa) {
        this.dpromesa = dpromesa;
    }

    public java.math.BigDecimal getMsubtotal() {
        return this.msubtotal;
    }

    public void setMsubtotal(java.math.BigDecimal msubtotal) {
        this.msubtotal = msubtotal;
    }

    public java.math.BigDecimal getMdescuento() {
        return this.mdescuento;
    }

    public void setMdescuento(java.math.BigDecimal mdescuento) {
        this.mdescuento = mdescuento;
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

    public java.lang.String getSobservacion() {
        return this.sobservacion;
    }

    public void setSobservacion(java.lang.String sobservacion) {
        this.sobservacion = sobservacion;
    }
    
    public mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion getBordenfundacion() {
        return this.bordenfundacion;
    }

    public void setBordenfundacion(mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion) {
        this.bordenfundacion = bordenfundacion;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion getCexamenfundacion() {
        return this.cexamenfundacion;
    }

    public void setCexamenfundacion(mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion cexamenfundacion) {
        this.cexamenfundacion = cexamenfundacion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kordenexamenfundacion", getKordenexamenfundacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BOrdenExamenFundacion) ) return false;
        BOrdenExamenFundacion castOther = (BOrdenExamenFundacion) other;
        return new EqualsBuilder()
            .append(this.getKordenexamenfundacion(), castOther.getKordenexamenfundacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordenexamenfundacion())
            .toHashCode();
    }

}
