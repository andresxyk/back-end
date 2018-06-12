package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SGenero implements Serializable {

    /** identifier field */
    private java.lang.Integer cgenero;

    /** persistent field */
    private java.lang.String sgenero;

    /** persistent field */
    private java.lang.String smnemonico;

    /** persistent field */
    private Set cexamens;

    /** persistent field */
    private Set bpacientes;

    /** persistent field */
    private Set dlimitelaboratorios;

    /** full constructor */
    public SGenero(java.lang.Integer cgenero, java.lang.String sgenero, java.lang.String smnemonico, Set cexamens, Set bpacientes, Set dlimitelaboratorios) {
        this.cgenero = cgenero;
        this.sgenero = sgenero;
        this.smnemonico = smnemonico;
        this.cexamens = cexamens;
        this.bpacientes = bpacientes;
        this.dlimitelaboratorios = dlimitelaboratorios;
    }

    /** default constructor */
    public SGenero() {
    }

    public java.lang.Integer getCgenero() {
        return this.cgenero;
    }

    public void setCgenero(java.lang.Integer cgenero) {
        this.cgenero = cgenero;
    }

    public java.lang.String getSgenero() {
        return this.sgenero;
    }

    public void setSgenero(java.lang.String sgenero) {
        this.sgenero = sgenero;
    }

    public java.lang.String getSmnemonico() {
        return this.smnemonico;
    }

    public void setSmnemonico(java.lang.String smnemonico) {
        this.smnemonico = smnemonico;
    }

    public java.util.Set getCexamens() {
        return this.cexamens;
    }

    public void setCexamens(java.util.Set cexamens) {
        this.cexamens = cexamens;
    }

    public java.util.Set getBpacientes() {
        return this.bpacientes;
    }

    public void setBpacientes(java.util.Set bpacientes) {
        this.bpacientes = bpacientes;
    }

    public java.util.Set getDlimitelaboratorios() {
        return this.dlimitelaboratorios;
    }

    public void setDlimitelaboratorios(java.util.Set dlimitelaboratorios) {
        this.dlimitelaboratorios = dlimitelaboratorios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cgenero", getCgenero())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SGenero) ) return false;
        SGenero castOther = (SGenero) other;
        return new EqualsBuilder()
            .append(this.getCgenero(), castOther.getCgenero())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCgenero())
            .toHashCode();
    }

}
