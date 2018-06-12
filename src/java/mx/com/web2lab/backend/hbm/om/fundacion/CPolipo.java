package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CPolipo implements Serializable {

    /** identifier field */
    private java.lang.Integer cpolipo;

    /** nullable persistent field */
    private java.lang.String spolipo;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CPolipo(java.lang.Integer cpolipo, java.lang.String spolipo, Set bpacientecuestionarios) {
        this.cpolipo = cpolipo;
        this.spolipo = spolipo;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CPolipo() {
    }

    /** minimal constructor */
    public CPolipo(java.lang.Integer cpolipo, Set bpacientecuestionarios) {
        this.cpolipo = cpolipo;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCpolipo() {
        return this.cpolipo;
    }

    public void setCpolipo(java.lang.Integer cpolipo) {
        this.cpolipo = cpolipo;
    }

    public java.lang.String getSpolipo() {
        return this.spolipo;
    }

    public void setSpolipo(java.lang.String spolipo) {
        this.spolipo = spolipo;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cpolipo", getCpolipo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CPolipo) ) return false;
        CPolipo castOther = (CPolipo) other;
        return new EqualsBuilder()
            .append(this.getCpolipo(), castOther.getCpolipo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCpolipo())
            .toHashCode();
    }

}
