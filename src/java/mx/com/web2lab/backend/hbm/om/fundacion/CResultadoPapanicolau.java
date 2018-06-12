package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CResultadoPapanicolau implements Serializable {

    /** identifier field */
    private java.lang.Integer cresultadoPapanicolau;

    /** nullable persistent field */
    private java.lang.String sresultadoPapanicolau;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CResultadoPapanicolau(java.lang.Integer cresultadoPapanicolau, java.lang.String sresultadoPapanicolau, Set bpacientecuestionarios) {
        this.cresultadoPapanicolau = cresultadoPapanicolau;
        this.sresultadoPapanicolau = sresultadoPapanicolau;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CResultadoPapanicolau() {
    }

    /** minimal constructor */
    public CResultadoPapanicolau(java.lang.Integer cresultadoPapanicolau, Set bpacientecuestionarios) {
        this.cresultadoPapanicolau = cresultadoPapanicolau;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCresultadoPapanicolau() {
        return this.cresultadoPapanicolau;
    }

    public void setCresultadoPapanicolau(java.lang.Integer cresultadoPapanicolau) {
        this.cresultadoPapanicolau = cresultadoPapanicolau;
    }

    public java.lang.String getSresultadoPapanicolau() {
        return this.sresultadoPapanicolau;
    }

    public void setSresultadoPapanicolau(java.lang.String sresultadoPapanicolau) {
        this.sresultadoPapanicolau = sresultadoPapanicolau;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cresultadoPapanicolau", getCresultadoPapanicolau())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CResultadoPapanicolau) ) return false;
        CResultadoPapanicolau castOther = (CResultadoPapanicolau) other;
        return new EqualsBuilder()
            .append(this.getCresultadoPapanicolau(), castOther.getCresultadoPapanicolau())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCresultadoPapanicolau())
            .toHashCode();
    }

}
