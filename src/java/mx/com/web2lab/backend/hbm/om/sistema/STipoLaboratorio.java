package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class STipoLaboratorio implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipolaboratorio;

    /** nullable persistent field */
    private java.lang.String stipolaboratorio;

    /** persistent field */
    private Set claboratorios;

    /** full constructor */
    public STipoLaboratorio(java.lang.Integer ctipolaboratorio, java.lang.String stipolaboratorio, Set claboratorios) {
        this.ctipolaboratorio = ctipolaboratorio;
        this.stipolaboratorio = stipolaboratorio;
        this.claboratorios = claboratorios;
    }

    /** default constructor */
    public STipoLaboratorio() {
    }

    /** minimal constructor */
    public STipoLaboratorio(java.lang.Integer ctipolaboratorio, Set claboratorios) {
        this.ctipolaboratorio = ctipolaboratorio;
        this.claboratorios = claboratorios;
    }

    public java.lang.Integer getCtipolaboratorio() {
        return this.ctipolaboratorio;
    }

    public void setCtipolaboratorio(java.lang.Integer ctipolaboratorio) {
        this.ctipolaboratorio = ctipolaboratorio;
    }

    public java.lang.String getStipolaboratorio() {
        return this.stipolaboratorio;
    }

    public void setStipolaboratorio(java.lang.String stipolaboratorio) {
        this.stipolaboratorio = stipolaboratorio;
    }

    public java.util.Set getClaboratorios() {
        return this.claboratorios;
    }

    public void setClaboratorios(java.util.Set claboratorios) {
        this.claboratorios = claboratorios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipolaboratorio", getCtipolaboratorio())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof STipoLaboratorio) ) return false;
        STipoLaboratorio castOther = (STipoLaboratorio) other;
        return new EqualsBuilder()
            .append(this.getCtipolaboratorio(), castOther.getCtipolaboratorio())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipolaboratorio())
            .toHashCode();
    }

}
