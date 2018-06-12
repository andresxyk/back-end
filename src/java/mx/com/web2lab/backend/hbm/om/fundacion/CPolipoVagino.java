package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CPolipoVagino implements Serializable {

    /** identifier field */
    private java.lang.Integer cpolipovagino;

    /** nullable persistent field */
    private java.lang.String spolipovagino;

    /** full constructor */
    public CPolipoVagino(java.lang.Integer cpolipovagino, java.lang.String spolipovagino) {
        this.cpolipovagino = cpolipovagino;
        this.spolipovagino = spolipovagino;
    }

    /** default constructor */
    public CPolipoVagino() {
    }

    /** minimal constructor */
    public CPolipoVagino(java.lang.Integer cpolipovagino) {
        this.cpolipovagino = cpolipovagino;
    }

    public java.lang.Integer getCpolipovagino() {
        return this.cpolipovagino;
    }

    public void setCpolipovagino(java.lang.Integer cpolipovagino) {
        this.cpolipovagino = cpolipovagino;
    }

    public java.lang.String getSpolipovagino() {
        return this.spolipovagino;
    }

    public void setSpolipovagino(java.lang.String spolipovagino) {
        this.spolipovagino = spolipovagino;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cpolipovagino", getCpolipovagino())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CPolipoVagino) ) return false;
        CPolipoVagino castOther = (CPolipoVagino) other;
        return new EqualsBuilder()
            .append(this.getCpolipovagino(), castOther.getCpolipovagino())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCpolipovagino())
            .toHashCode();
    }

}
