package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EListaPublicoDetalle implements Serializable {

    /** identifier field */
    private java.lang.Integer klispublicodetalle;

    /** nullable persistent field */
    private java.math.BigDecimal pprecio;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CListaPublico clistapublico;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.EListaCorporativaDetalle elistacorporativadetalle;

    /** full constructor */
    public EListaPublicoDetalle(java.lang.Integer klispublicodetalle, java.math.BigDecimal pprecio, java.util.Date dregistro, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CListaPublico clistapublico, mx.com.web2lab.backend.hbm.om.ap.EListaCorporativaDetalle elistacorporativadetalle) {
        this.klispublicodetalle = klispublicodetalle;
        this.pprecio = pprecio;
        this.dregistro = dregistro;
        this.userid = userid;
        this.clistapublico = clistapublico;
        this.elistacorporativadetalle = elistacorporativadetalle;
    }

    /** default constructor */
    public EListaPublicoDetalle() {
    }

    /** minimal constructor */
    public EListaPublicoDetalle(java.lang.Integer klispublicodetalle, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CListaPublico clistapublico, mx.com.web2lab.backend.hbm.om.ap.EListaCorporativaDetalle elistacorporativadetalle) {
        this.klispublicodetalle = klispublicodetalle;
        this.userid = userid;
        this.clistapublico = clistapublico;
        this.elistacorporativadetalle = elistacorporativadetalle;
      }

    public java.lang.Integer getKlispublicodetalle() {
        return this.klispublicodetalle;
    }

    public void setKlispublicodetalle(java.lang.Integer klispublicodetalle) {
        this.klispublicodetalle = klispublicodetalle;
    }

    public java.math.BigDecimal getPprecio() {
        return this.pprecio;
    }

    public void setPprecio(java.math.BigDecimal pprecio) {
        this.pprecio = pprecio;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.math.BigDecimal getUserid() {
        return this.userid;
    }

    public void setUserid(java.math.BigDecimal userid) {
        this.userid = userid;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CListaPublico getClistapublico() {
        return this.clistapublico;
    }

    public void setClistapublico(mx.com.web2lab.backend.hbm.om.ap.CListaPublico clistapublico) {
        this.clistapublico = clistapublico;
    }

    public mx.com.web2lab.backend.hbm.om.ap.EListaCorporativaDetalle getElistacorporativadetalle() {
        return this.elistacorporativadetalle;
    }

    public void setElistacorporativadetalle(mx.com.web2lab.backend.hbm.om.ap.EListaCorporativaDetalle elistacorporativadetalle) {
        this.elistacorporativadetalle = elistacorporativadetalle;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("klispublicodetalle", getKlispublicodetalle())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EListaPublicoDetalle) ) return false;
        EListaPublicoDetalle castOther = (EListaPublicoDetalle) other;
        return new EqualsBuilder()
            .append(this.getKlispublicodetalle(), castOther.getKlispublicodetalle())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKlispublicodetalle())
            .toHashCode();
    }

}
