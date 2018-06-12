package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EConvenioPerfil implements Serializable {

    /** identifier field */
    private java.lang.Integer kconvenioperfil;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio;

    /** full constructor */
    public EConvenioPerfil(java.lang.Integer kconvenioperfil, mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.kconvenioperfil = kconvenioperfil;
        this.cperfil = cperfil;
        this.cconvenio = cconvenio;
    }

    /** default constructor */
    public EConvenioPerfil() {
    }

    public java.lang.Integer getKconvenioperfil() {
        return this.kconvenioperfil;
    }

    public void setKconvenioperfil(java.lang.Integer kconvenioperfil) {
        this.kconvenioperfil = kconvenioperfil;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CPerfil getCperfil() {
        return this.cperfil;
    }

    public void setCperfil(mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil) {
        this.cperfil = cperfil;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CConvenio getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.cconvenio = cconvenio;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kconvenioperfil", getKconvenioperfil())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EConvenioPerfil) ) return false;
        EConvenioPerfil castOther = (EConvenioPerfil) other;
        return new EqualsBuilder()
            .append(this.getKconvenioperfil(), castOther.getKconvenioperfil())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKconvenioperfil())
            .toHashCode();
    }

}
