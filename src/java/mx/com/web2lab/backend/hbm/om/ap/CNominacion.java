package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CNominacion implements Serializable {

    /** identifier field */
    private java.lang.Integer knominacion;

    /** nullable persistent field */
    private java.lang.String snominacion;

    /** persistent field */
    private Set tcortecajaarqueos;

    /** full constructor */
    public CNominacion(java.lang.Integer knominacion, java.lang.String snominacion, Set tcortecajaarqueos) {
        this.knominacion = knominacion;
        this.snominacion = snominacion;
        this.tcortecajaarqueos = tcortecajaarqueos;
    }

    /** default constructor */
    public CNominacion() {
    }

    /** minimal constructor */
    public CNominacion(java.lang.Integer knominacion, Set tcortecajaarqueos) {
        this.knominacion = knominacion;
        this.tcortecajaarqueos = tcortecajaarqueos;
    }

    public java.lang.Integer getKnominacion() {
        return this.knominacion;
    }

    public void setKnominacion(java.lang.Integer knominacion) {
        this.knominacion = knominacion;
    }

    public java.lang.String getSnominacion() {
        return this.snominacion;
    }

    public void setSnominacion(java.lang.String snominacion) {
        this.snominacion = snominacion;
    }

    public java.util.Set getTcortecajaarqueos() {
        return this.tcortecajaarqueos;
    }

    public void setTcortecajaarqueos(java.util.Set tcortecajaarqueos) {
        this.tcortecajaarqueos = tcortecajaarqueos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("knominacion", getKnominacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CNominacion) ) return false;
        CNominacion castOther = (CNominacion) other;
        return new EqualsBuilder()
            .append(this.getKnominacion(), castOther.getKnominacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKnominacion())
            .toHashCode();
    }

}
