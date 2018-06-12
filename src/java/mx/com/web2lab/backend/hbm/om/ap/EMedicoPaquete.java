package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EMedicoPaquete implements Serializable {

    /** identifier field */
    private java.lang.Integer kmedicopaquete;

    /** nullable persistent field */
    private java.lang.String smedicopaquete;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico;

    /** persistent field */
    private Set emedicodetalles;

    /** full constructor */
    public EMedicoPaquete(java.lang.Integer kmedicopaquete, java.lang.String smedicopaquete, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico, Set emedicodetalles) {
        this.kmedicopaquete = kmedicopaquete;
        this.smedicopaquete = smedicopaquete;
        this.userid = userid;
        this.cestadoregistro = cestadoregistro;
        this.cmedico = cmedico;
        this.emedicodetalles = emedicodetalles;
    }

    /** default constructor */
    public EMedicoPaquete() {
    }

    /** minimal constructor */
    public EMedicoPaquete(java.lang.Integer kmedicopaquete, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico, Set emedicodetalles) {
        this.kmedicopaquete = kmedicopaquete;
        this.userid = userid;
        this.cestadoregistro = cestadoregistro;
        this.cmedico = cmedico;
        this.emedicodetalles = emedicodetalles;
    }

    public java.lang.Integer getKmedicopaquete() {
        return this.kmedicopaquete;
    }

    public void setKmedicopaquete(java.lang.Integer kmedicopaquete) {
        this.kmedicopaquete = kmedicopaquete;
    }

    public java.lang.String getSmedicopaquete() {
        return this.smedicopaquete;
    }

    public void setSmedicopaquete(java.lang.String smedicopaquete) {
        this.smedicopaquete = smedicopaquete;
    }

    public java.math.BigDecimal getUserid() {
        return this.userid;
    }

    public void setUserid(java.math.BigDecimal userid) {
        this.userid = userid;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.medico.CMedico getCmedico() {
        return this.cmedico;
    }

    public void setCmedico(mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico) {
        this.cmedico = cmedico;
    }

    public java.util.Set getEmedicodetalles() {
        return this.emedicodetalles;
    }

    public void setEmedicodetalles(java.util.Set emedicodetalles) {
        this.emedicodetalles = emedicodetalles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kmedicopaquete", getKmedicopaquete())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EMedicoPaquete) ) return false;
        EMedicoPaquete castOther = (EMedicoPaquete) other;
        return new EqualsBuilder()
            .append(this.getKmedicopaquete(), castOther.getKmedicopaquete())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKmedicopaquete())
            .toHashCode();
    }

}
