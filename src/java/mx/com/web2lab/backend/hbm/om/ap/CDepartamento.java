package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CDepartamento implements Serializable {

    /** identifier field */
    private java.lang.Integer cdepartamento;

    /** nullable persistent field */
    private java.lang.String sdepartamento;

    /** full constructor */
    public CDepartamento(java.lang.Integer cdepartamento, java.lang.String sdepartamento) {
        this.cdepartamento = cdepartamento;
        this.sdepartamento = sdepartamento;
    }

    /** default constructor */
    public CDepartamento() {
    }

    /** minimal constructor */
    public CDepartamento(java.lang.Integer cdepartamento) {
        this.cdepartamento = cdepartamento;
    }

    public java.lang.Integer getCdepartamento() {
        return this.cdepartamento;
    }

    public void setCdepartamento(java.lang.Integer cdepartamento) {
        this.cdepartamento = cdepartamento;
    }

    public java.lang.String getSdepartamento() {
        return this.sdepartamento;
    }

    public void setSdepartamento(java.lang.String sdepartamento) {
        this.sdepartamento = sdepartamento;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cdepartamento", getCdepartamento())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CDepartamento) ) return false;
        CDepartamento castOther = (CDepartamento) other;
        return new EqualsBuilder()
            .append(this.getCdepartamento(), castOther.getCdepartamento())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCdepartamento())
            .toHashCode();
    }

}
