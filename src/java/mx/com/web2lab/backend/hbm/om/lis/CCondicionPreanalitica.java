package mx.com.web2lab.backend.hbm.om.lis;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CCondicionPreanalitica implements Serializable {

    /** identifier field */
    private java.lang.Integer ccondicionpreanalitica;

    /** nullable persistent field */
    private java.lang.String scondicionpreanalitica;

    /** full constructor */
    public CCondicionPreanalitica(java.lang.Integer ccondicionpreanalitica, java.lang.String scondicionpreanalitica) {
        this.ccondicionpreanalitica = ccondicionpreanalitica;
        this.scondicionpreanalitica = scondicionpreanalitica;
    }

    /** default constructor */
    public CCondicionPreanalitica() {
    }

    /** minimal constructor */
    public CCondicionPreanalitica(java.lang.Integer ccondicionpreanalitica) {
        this.ccondicionpreanalitica = ccondicionpreanalitica;
    }

    public java.lang.Integer getCcondicionpreanalitica() {
        return this.ccondicionpreanalitica;
    }

    public void setCcondicionpreanalitica(java.lang.Integer ccondicionpreanalitica) {
        this.ccondicionpreanalitica = ccondicionpreanalitica;
    }

    public java.lang.String getScondicionpreanalitica() {
        return this.scondicionpreanalitica;
    }

    public void setScondicionpreanalitica(java.lang.String scondicionpreanalitica) {
        this.scondicionpreanalitica = scondicionpreanalitica;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccondicionpreanalitica", getCcondicionpreanalitica())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CCondicionPreanalitica) ) return false;
        CCondicionPreanalitica castOther = (CCondicionPreanalitica) other;
        return new EqualsBuilder()
            .append(this.getCcondicionpreanalitica(), castOther.getCcondicionpreanalitica())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcondicionpreanalitica())
            .toHashCode();
    }

}
