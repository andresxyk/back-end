package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TCorteCajaArqueo implements Serializable {

    /** identifier field */
    private java.lang.Integer kcortecajaarqueo;

    /** nullable persistent field */
    private int uvolumencantidad;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CNominacion cnominacion;

    /** full constructor */
    public TCorteCajaArqueo(java.lang.Integer kcortecajaarqueo, int uvolumencantidad, mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja, mx.com.web2lab.backend.hbm.om.ap.CNominacion cnominacion) {
        this.kcortecajaarqueo = kcortecajaarqueo;
        this.uvolumencantidad = uvolumencantidad;
        this.tcortecaja = tcortecaja;
        this.cnominacion = cnominacion;
    }

    /** default constructor */
    public TCorteCajaArqueo() {
    }

    /** minimal constructor */
    public TCorteCajaArqueo(java.lang.Integer kcortecajaarqueo, mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja, mx.com.web2lab.backend.hbm.om.ap.CNominacion cnominacion) {
        this.kcortecajaarqueo = kcortecajaarqueo;
        this.tcortecaja = tcortecaja;
        this.cnominacion = cnominacion;
    }

    public java.lang.Integer getKcortecajaarqueo() {
        return this.kcortecajaarqueo;
    }

    public void setKcortecajaarqueo(java.lang.Integer kcortecajaarqueo) {
        this.kcortecajaarqueo = kcortecajaarqueo;
    }

    public int getUvolumencantidad() {
        return this.uvolumencantidad;
    }

    public void setUvolumencantidad(int uvolumencantidad) {
        this.uvolumencantidad = uvolumencantidad;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TCorteCaja getTcortecaja() {
        return this.tcortecaja;
    }

    public void setTcortecaja(mx.com.web2lab.backend.hbm.om.ap.TCorteCaja tcortecaja) {
        this.tcortecaja = tcortecaja;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CNominacion getCnominacion() {
        return this.cnominacion;
    }

    public void setCnominacion(mx.com.web2lab.backend.hbm.om.ap.CNominacion cnominacion) {
        this.cnominacion = cnominacion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kcortecajaarqueo", getKcortecajaarqueo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TCorteCajaArqueo) ) return false;
        TCorteCajaArqueo castOther = (TCorteCajaArqueo) other;
        return new EqualsBuilder()
            .append(this.getKcortecajaarqueo(), castOther.getKcortecajaarqueo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKcortecajaarqueo())
            .toHashCode();
    }

}
