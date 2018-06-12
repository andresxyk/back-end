package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SFuncion implements Serializable {

    /** identifier field */
    private java.lang.Long cfuncion;

    /** nullable persistent field */
    private java.lang.String sfuncion;

    /** nullable persistent field */
    private int ctipo;

    /** full constructor */
    public SFuncion(java.lang.Long cfuncion, java.lang.String sfuncion, int ctipo) {
        this.cfuncion = cfuncion;
        this.sfuncion = sfuncion;
        this.ctipo = ctipo;
    }

    /** default constructor */
    public SFuncion() {
    }

    /** minimal constructor */
    public SFuncion(java.lang.Long cfuncion) {
        this.cfuncion = cfuncion;
    }

    public java.lang.Long getCfuncion() {
        return this.cfuncion;
    }

    public void setCfuncion(java.lang.Long cfuncion) {
        this.cfuncion = cfuncion;
    }

    public java.lang.String getSfuncion() {
        return this.sfuncion;
    }

    public void setSfuncion(java.lang.String sfuncion) {
        this.sfuncion = sfuncion;
    }

    public int getCtipo() {
        return this.ctipo;
    }

    public void setCtipo(int ctipo) {
        this.ctipo = ctipo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cfuncion", getCfuncion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SFuncion) ) return false;
        SFuncion castOther = (SFuncion) other;
        return new EqualsBuilder()
            .append(this.getCfuncion(), castOther.getCfuncion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCfuncion())
            .toHashCode();
    }

}
