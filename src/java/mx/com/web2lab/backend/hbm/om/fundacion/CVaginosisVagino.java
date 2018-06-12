package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CVaginosisVagino implements Serializable {

    /** identifier field */
    private java.lang.Integer cvaginosisvagino;

    /** nullable persistent field */
    private java.lang.String svaginosisvagino;

    /** full constructor */
    public CVaginosisVagino(java.lang.Integer cvaginosisvagino, java.lang.String svaginosisvagino) {
        this.cvaginosisvagino = cvaginosisvagino;
        this.svaginosisvagino = svaginosisvagino;
    }

    /** default constructor */
    public CVaginosisVagino() {
    }

    /** minimal constructor */
    public CVaginosisVagino(java.lang.Integer cvaginosisvagino) {
        this.cvaginosisvagino = cvaginosisvagino;
    }

    public java.lang.Integer getCvaginosisvagino() {
        return this.cvaginosisvagino;
    }

    public void setCvaginosisvagino(java.lang.Integer cvaginosisvagino) {
        this.cvaginosisvagino = cvaginosisvagino;
    }

    public java.lang.String getSvaginosisvagino() {
        return this.svaginosisvagino;
    }

    public void setSvaginosisvagino(java.lang.String svaginosisvagino) {
        this.svaginosisvagino = svaginosisvagino;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cvaginosisvagino", getCvaginosisvagino())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CVaginosisVagino) ) return false;
        CVaginosisVagino castOther = (CVaginosisVagino) other;
        return new EqualsBuilder()
            .append(this.getCvaginosisvagino(), castOther.getCvaginosisvagino())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCvaginosisvagino())
            .toHashCode();
    }

}
