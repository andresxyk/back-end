package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMucosaAtroficaVagino implements Serializable {

    /** identifier field */
    private java.lang.Integer cmucosaatroficavagino;

    /** nullable persistent field */
    private java.lang.String smucosaatroficavagino;

    /** full constructor */
    public CMucosaAtroficaVagino(java.lang.Integer cmucosaatroficavagino, java.lang.String smucosaatroficavagino) {
        this.cmucosaatroficavagino = cmucosaatroficavagino;
        this.smucosaatroficavagino = smucosaatroficavagino;
    }

    /** default constructor */
    public CMucosaAtroficaVagino() {
    }

    /** minimal constructor */
    public CMucosaAtroficaVagino(java.lang.Integer cmucosaatroficavagino) {
        this.cmucosaatroficavagino = cmucosaatroficavagino;
    }

    public java.lang.Integer getCmucosaatroficavagino() {
        return this.cmucosaatroficavagino;
    }

    public void setCmucosaatroficavagino(java.lang.Integer cmucosaatroficavagino) {
        this.cmucosaatroficavagino = cmucosaatroficavagino;
    }

    public java.lang.String getSmucosaatroficavagino() {
        return this.smucosaatroficavagino;
    }

    public void setSmucosaatroficavagino(java.lang.String smucosaatroficavagino) {
        this.smucosaatroficavagino = smucosaatroficavagino;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmucosaatroficavagino", getCmucosaatroficavagino())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMucosaAtroficaVagino) ) return false;
        CMucosaAtroficaVagino castOther = (CMucosaAtroficaVagino) other;
        return new EqualsBuilder()
            .append(this.getCmucosaatroficavagino(), castOther.getCmucosaatroficavagino())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmucosaatroficavagino())
            .toHashCode();
    }

}
