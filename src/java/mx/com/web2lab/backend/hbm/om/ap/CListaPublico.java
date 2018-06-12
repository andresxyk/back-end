package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CListaPublico implements Serializable {

    /** identifier field */
    private java.lang.Integer clistapublico;

    /** nullable persistent field */
    private java.lang.String sdescripcionpaquete;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa;

    /** persistent field */
    private Set elistasucursals;

    /** persistent field */
    private Set elistapublicodetalles;

    /** full constructor */
    public CListaPublico(java.lang.Integer clistapublico, java.lang.String sdescripcionpaquete, java.util.Date dregistro, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa, Set elistasucursals, Set elistapublicodetalles) {
        this.clistapublico = clistapublico;
        this.sdescripcionpaquete = sdescripcionpaquete;
        this.dregistro = dregistro;
        this.userid = userid;
        this.clistacorporativa = clistacorporativa;
        this.elistasucursals = elistasucursals;
        this.elistapublicodetalles = elistapublicodetalles;
    }

    /** default constructor */
    public CListaPublico() {
    }

    /** minimal constructor */
    public CListaPublico(java.lang.Integer clistapublico, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa, Set elistasucursals, Set elistapublicodetalles) {
        this.clistapublico = clistapublico;
        this.userid = userid;
        this.clistacorporativa = clistacorporativa;
        this.elistasucursals = elistasucursals;
        this.elistapublicodetalles = elistapublicodetalles;
    }

    public java.lang.Integer getClistapublico() {
        return this.clistapublico;
    }

    public void setClistapublico(java.lang.Integer clistapublico) {
        this.clistapublico = clistapublico;
    }

    public java.lang.String getSdescripcionpaquete() {
        return this.sdescripcionpaquete;
    }

    public void setSdescripcionpaquete(java.lang.String sdescripcionpaquete) {
        this.sdescripcionpaquete = sdescripcionpaquete;
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

    public mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa getClistacorporativa() {
        return this.clistacorporativa;
    }

    public void setClistacorporativa(mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa) {
        this.clistacorporativa = clistacorporativa;
    }

    public java.util.Set getElistasucursals() {
        return this.elistasucursals;
    }

    public void setElistasucursals(java.util.Set elistasucursals) {
        this.elistasucursals = elistasucursals;
    }

    public java.util.Set getElistapublicodetalles() {
        return this.elistapublicodetalles;
    }

    public void setElistapublicodetalles(java.util.Set elistapublicodetalles) {
        this.elistapublicodetalles = elistapublicodetalles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("clistapublico", getClistapublico())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CListaPublico) ) return false;
        CListaPublico castOther = (CListaPublico) other;
        return new EqualsBuilder()
            .append(this.getClistapublico(), castOther.getClistapublico())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getClistapublico())
            .toHashCode();
    }

}
