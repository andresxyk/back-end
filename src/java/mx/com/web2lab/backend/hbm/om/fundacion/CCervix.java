package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CCervix implements Serializable {

    /** identifier field */
    private java.lang.Integer ccervix;

    /** nullable persistent field */
    private java.lang.String scervix;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CCervix(java.lang.Integer ccervix, java.lang.String scervix, Set bpacientecuestionarios) {
        this.ccervix = ccervix;
        this.scervix = scervix;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CCervix() {
    }

    /** minimal constructor */
    public CCervix(java.lang.Integer ccervix, Set bpacientecuestionarios) {
        this.ccervix = ccervix;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCcervix() {
        return this.ccervix;
    }

    public void setCcervix(java.lang.Integer ccervix) {
        this.ccervix = ccervix;
    }

    public java.lang.String getScervix() {
        return this.scervix;
    }

    public void setScervix(java.lang.String scervix) {
        this.scervix = scervix;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccervix", getCcervix())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CCervix) ) return false;
        CCervix castOther = (CCervix) other;
        return new EqualsBuilder()
            .append(this.getCcervix(), castOther.getCcervix())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcervix())
            .toHashCode();
    }

}
