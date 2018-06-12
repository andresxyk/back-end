package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CPromocionMarketing implements Serializable {

    /** identifier field */
    private java.lang.Integer cpromocionenviomarketing;

    /** nullable persistent field */
    private java.lang.String ssubject;

    /** nullable persistent field */
    private java.lang.String shtmlpromocion;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.util.Date dregistromodi;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private Set tpacientemarketings;

    /** full constructor */
    public CPromocionMarketing(java.lang.Integer cpromocionenviomarketing, java.lang.String ssubject, java.lang.String shtmlpromocion, java.util.Date dregistro, java.util.Date dregistromodi, mx.com.web2lab.backend.hbm.om.ap.CConvenio cConvenio, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cEstadoRegistro, Set tpacientemarketings) {
        this.cpromocionenviomarketing = cpromocionenviomarketing;
        this.ssubject = ssubject;
        this.shtmlpromocion = shtmlpromocion;
        this.dregistro = dregistro;
        this.dregistromodi = dregistromodi;
        this.cconvenio = cconvenio;
        this.cestadoregistro = cestadoregistro;
        this.tpacientemarketings = tpacientemarketings;
    }

    /** default constructor */
    public CPromocionMarketing() {
    }

    /** minimal constructor */
    public CPromocionMarketing(java.lang.Integer cpromocionenviomarketing, mx.com.web2lab.backend.hbm.om.ap.CConvenio cConvenio, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cEstadoRegistro, Set tpacientemarketings) {
        this.cpromocionenviomarketing = cpromocionenviomarketing;
        this.cconvenio = cconvenio;
        this.cestadoregistro = cestadoregistro;
        this.tpacientemarketings = tpacientemarketings;
    }

    public java.lang.Integer getCpromocionenviomarketing() {
        return this.cpromocionenviomarketing;
    }

    public void setCpromocionenviomarketing(java.lang.Integer cpromocionenviomarketing) {
        this.cpromocionenviomarketing = cpromocionenviomarketing;
    }

    public java.lang.String getSsubject() {
        return this.ssubject;
    }

    public void setSsubject(java.lang.String ssubject) {
        this.ssubject = ssubject;
    }

    public java.lang.String getShtmlpromocion() {
        return this.shtmlpromocion;
    }

    public void setShtmlpromocion(java.lang.String shtmlpromocion) {
        this.shtmlpromocion = shtmlpromocion;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.util.Date getDregistromodi() {
        return this.dregistromodi;
    }

    public void setDregistromodi(java.util.Date dregistromodi) {
        this.dregistromodi = dregistromodi;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CConvenio getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.cconvenio = cconvenio;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.util.Set getTpacientemarketings() {
        return this.tpacientemarketings;
    }

    public void setTpacientemarketings(java.util.Set tpacientemarketings) {
        this.tpacientemarketings = tpacientemarketings;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cpromocionenviomarketing", getCpromocionenviomarketing())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CPromocionMarketing) ) return false;
        CPromocionMarketing castOther = (CPromocionMarketing) other;
        return new EqualsBuilder()
            .append(this.getCpromocionenviomarketing(), castOther.getCpromocionenviomarketing())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCpromocionenviomarketing())
            .toHashCode();
    }

}
