package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CListaCorporativa implements Serializable {

    /** identifier field */
    private java.lang.Integer clistacorporativa;

    /** nullable persistent field */
    private java.lang.String sdescripcionlista;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca;

    /** persistent field */
    private Set elistacorporativadetalles;

    /** persistent field */
    private Set clistapublicos;

    /** persistent field */
    private Set econvenios;

    /** full constructor */
    public CListaCorporativa(java.lang.Integer clistacorporativa, java.lang.String sdescripcionlista, java.util.Date dregistro, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set elistacorporativadetalles, Set clistapublicos, Set econvenios) {
        this.clistacorporativa = clistacorporativa;
        this.sdescripcionlista = sdescripcionlista;
        this.dregistro = dregistro;
        this.userid = userid;
        this.cmarca = cmarca;
        this.elistacorporativadetalles = elistacorporativadetalles;
        this.clistapublicos = clistapublicos;
        this.econvenios = econvenios;
    }

    /** default constructor */
    public CListaCorporativa() {
    }

    /** minimal constructor */
    public CListaCorporativa(java.lang.Integer clistacorporativa, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set elistacorporativadetalles, Set clistapublicos, Set econvenios) {
        this.clistacorporativa = clistacorporativa;
        this.userid = userid;
        this.cmarca = cmarca;
        this.elistacorporativadetalles = elistacorporativadetalles;
        this.clistapublicos = clistapublicos;
        this.econvenios = econvenios;
    }

    public java.lang.Integer getClistacorporativa() {
        return this.clistacorporativa;
    }

    public void setClistacorporativa(java.lang.Integer clistacorporativa) {
        this.clistacorporativa = clistacorporativa;
    }

    public java.lang.String getSdescripcionlista() {
        return this.sdescripcionlista;
    }

    public void setSdescripcionlista(java.lang.String sdescripcionlista) {
        this.sdescripcionlista = sdescripcionlista;
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

    public mx.com.web2lab.backend.hbm.om.ap.CMarca getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca) {
        this.cmarca = cmarca;
    }

    public java.util.Set getElistacorporativadetalles() {
        return this.elistacorporativadetalles;
    }

    public void setElistacorporativadetalles(java.util.Set elistacorporativadetalles) {
        this.elistacorporativadetalles = elistacorporativadetalles;
    }

    public java.util.Set getClistapublicos() {
        return this.clistapublicos;
    }

    public void setClistapublicos(java.util.Set clistapublicos) {
        this.clistapublicos = clistapublicos;
    }

    public java.util.Set getEconvenios() {
        return this.econvenios;
    }

    public void setEconvenios(java.util.Set econvenios) {
        this.econvenios = econvenios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("clistacorporativa", getClistacorporativa())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CListaCorporativa) ) return false;
        CListaCorporativa castOther = (CListaCorporativa) other;
        return new EqualsBuilder()
            .append(this.getClistacorporativa(), castOther.getClistacorporativa())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getClistacorporativa())
            .toHashCode();
    }

}
