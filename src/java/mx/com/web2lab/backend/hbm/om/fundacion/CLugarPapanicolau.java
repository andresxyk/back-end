package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CLugarPapanicolau implements Serializable {

    /** identifier field */
    private java.lang.Integer clugarPapanicolau;

    /** nullable persistent field */
    private java.lang.String slugarPapanicolau;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CLugarPapanicolau(java.lang.Integer clugarPapanicolau, java.lang.String slugarPapanicolau, Set bpacientecuestionarios) {
        this.clugarPapanicolau = clugarPapanicolau;
        this.slugarPapanicolau = slugarPapanicolau;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CLugarPapanicolau() {
    }

    /** minimal constructor */
    public CLugarPapanicolau(java.lang.Integer clugarPapanicolau, Set bpacientecuestionarios) {
        this.clugarPapanicolau = clugarPapanicolau;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getClugarPapanicolau() {
        return this.clugarPapanicolau;
    }

    public void setClugarPapanicolau(java.lang.Integer clugarPapanicolau) {
        this.clugarPapanicolau = clugarPapanicolau;
    }

    public java.lang.String getSlugarPapanicolau() {
        return this.slugarPapanicolau;
    }

    public void setSlugarPapanicolau(java.lang.String slugarPapanicolau) {
        this.slugarPapanicolau = slugarPapanicolau;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("clugarPapanicolau", getClugarPapanicolau())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CLugarPapanicolau) ) return false;
        CLugarPapanicolau castOther = (CLugarPapanicolau) other;
        return new EqualsBuilder()
            .append(this.getClugarPapanicolau(), castOther.getClugarPapanicolau())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getClugarPapanicolau())
            .toHashCode();
    }

}
