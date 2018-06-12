package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTipoConvenio implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipoconvenio;

    /** nullable persistent field */
    private java.lang.String cdescripciontipoconvenio;

    /** persistent field */
    private Set cconvenios;

    /** full constructor */
    public CTipoConvenio(java.lang.Integer ctipoconvenio, java.lang.String cdescripciontipoconvenio, Set cconvenios) {
        this.ctipoconvenio = ctipoconvenio;
        this.cdescripciontipoconvenio = cdescripciontipoconvenio;
        this.cconvenios = cconvenios;
    }

    /** default constructor */
    public CTipoConvenio() {
    }

    /** minimal constructor */
    public CTipoConvenio(java.lang.Integer ctipoconvenio, Set cconvenios) {
        this.ctipoconvenio = ctipoconvenio;
        this.cconvenios = cconvenios;
    }

    public java.lang.Integer getCtipoconvenio() {
        return this.ctipoconvenio;
    }

    public void setCtipoconvenio(java.lang.Integer ctipoconvenio) {
        this.ctipoconvenio = ctipoconvenio;
    }

    public java.lang.String getCdescripciontipoconvenio() {
        return this.cdescripciontipoconvenio;
    }

    public void setCdescripciontipoconvenio(java.lang.String cdescripciontipoconvenio) {
        this.cdescripciontipoconvenio = cdescripciontipoconvenio;
    }

    public java.util.Set getCconvenios() {
        return this.cconvenios;
    }

    public void setCconvenios(java.util.Set cconvenios) {
        this.cconvenios = cconvenios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipoconvenio", getCtipoconvenio())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTipoConvenio) ) return false;
        CTipoConvenio castOther = (CTipoConvenio) other;
        return new EqualsBuilder()
            .append(this.getCtipoconvenio(), castOther.getCtipoconvenio())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipoconvenio())
            .toHashCode();
    }

}
