package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DExamenFundacion implements Serializable {

    /** identifier field */
    private java.lang.Integer kexamenfundacion;

    /** nullable persistent field */
    private java.math.BigDecimal mprecio;

    /** nullable persistent field */
    private int cestado;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private int cusuario;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int csucursal;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion cexamenfundacion;

    /** full constructor */
    public DExamenFundacion(java.lang.Integer kexamenfundacion, java.math.BigDecimal mprecio, int cestado, boolean bregistroactivo, int cusuario, java.util.Date dregistro, int csucursal, mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion cexamenfundacion) {
        this.kexamenfundacion = kexamenfundacion;
        this.mprecio = mprecio;
        this.cestado = cestado;
        this.bregistroactivo = bregistroactivo;
        this.cusuario = cusuario;
        this.dregistro = dregistro;
        this.cexamenfundacion = cexamenfundacion;
        this.csucursal = csucursal;
    }

    /** default constructor */
    public DExamenFundacion() {
    }

    /** minimal constructor */
    public DExamenFundacion(java.lang.Integer kexamenfundacion, int cusuario, mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion cexamenfundacion) {
        this.kexamenfundacion = kexamenfundacion;
        this.cusuario = cusuario;
        this.cexamenfundacion = cexamenfundacion;
    }

    public java.lang.Integer getKexamenfundacion() {
        return this.kexamenfundacion;
    }

    public void setKexamenfundacion(java.lang.Integer kexamenfundacion) {
        this.kexamenfundacion = kexamenfundacion;
    }

    public java.math.BigDecimal getMprecio() {
        return this.mprecio;
    }

    public void setMprecio(java.math.BigDecimal mprecio) {
        this.mprecio = mprecio;
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

    public int getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(int csucursal) {
        this.csucursal = csucursal;
    }
    
    public mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion getCexamenfundacion() {
        return this.cexamenfundacion;
    }

    public void setCexamenfundacion(mx.com.web2lab.backend.hbm.om.fundacion.CExamenFundacion cexamenfundacion) {
        this.cexamenfundacion = cexamenfundacion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kexamenfundacion", getKexamenfundacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DExamenFundacion) ) return false;
        DExamenFundacion castOther = (DExamenFundacion) other;
        return new EqualsBuilder()
            .append(this.getKexamenfundacion(), castOther.getKexamenfundacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKexamenfundacion())
            .toHashCode();
    }

}
