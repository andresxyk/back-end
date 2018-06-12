package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class STipoResultado implements Serializable {

    /** identifier field */
    private java.lang.Integer ctiporesultado;

    /** nullable persistent field */
    private java.lang.String stiporesultado;

    /** persistent field */
    private Set bordenresultados;

    /** persistent field */
    private Set dordinallaboratorios;

    /** persistent field */
    private Set dmensajelaboratorios;

    /** full constructor */
    public STipoResultado(java.lang.Integer ctiporesultado, java.lang.String stiporesultado, Set bordenresultados, Set dordinallaboratorios, Set dmensajelaboratorios) {
        this.ctiporesultado = ctiporesultado;
        this.stiporesultado = stiporesultado;
        this.bordenresultados = bordenresultados;
        this.dordinallaboratorios = dordinallaboratorios;
        this.dmensajelaboratorios = dmensajelaboratorios;
    }

    /** default constructor */
    public STipoResultado() {
    }

    /** minimal constructor */
    public STipoResultado(java.lang.Integer ctiporesultado, Set bordenresultados, Set dordinallaboratorios, Set dmensajelaboratorios) {
        this.ctiporesultado = ctiporesultado;
        this.bordenresultados = bordenresultados;
        this.dordinallaboratorios = dordinallaboratorios;
        this.dmensajelaboratorios = dmensajelaboratorios;
    }

    public java.lang.Integer getCtiporesultado() {
        return this.ctiporesultado;
    }

    public void setCtiporesultado(java.lang.Integer ctiporesultado) {
        this.ctiporesultado = ctiporesultado;
    }

    public java.lang.String getStiporesultado() {
        return this.stiporesultado;
    }

    public void setStiporesultado(java.lang.String stiporesultado) {
        this.stiporesultado = stiporesultado;
    }

    public java.util.Set getBordenresultados() {
        return this.bordenresultados;
    }

    public void setBordenresultados(java.util.Set bordenresultados) {
        this.bordenresultados = bordenresultados;
    }

    public java.util.Set getDordinallaboratorios() {
        return this.dordinallaboratorios;
    }

    public void setDordinallaboratorios(java.util.Set dordinallaboratorios) {
        this.dordinallaboratorios = dordinallaboratorios;
    }

    public java.util.Set getDmensajelaboratorios() {
        return this.dmensajelaboratorios;
    }

    public void setDmensajelaboratorios(java.util.Set dmensajelaboratorios) {
        this.dmensajelaboratorios = dmensajelaboratorios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctiporesultado", getCtiporesultado())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof STipoResultado) ) return false;
        STipoResultado castOther = (STipoResultado) other;
        return new EqualsBuilder()
            .append(this.getCtiporesultado(), castOther.getCtiporesultado())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtiporesultado())
            .toHashCode();
    }

}
