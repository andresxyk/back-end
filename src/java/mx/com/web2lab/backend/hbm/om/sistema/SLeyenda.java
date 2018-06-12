package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SLeyenda implements Serializable {

    /** identifier field */
    private java.lang.Integer cleyenda;

    /** persistent field */
    private java.lang.String sleyenda;

    /** persistent field */
    private Set bordenleyendas;

    /** full constructor */
    public SLeyenda(java.lang.Integer cleyenda, java.lang.String sleyenda, Set bordenleyendas) {
        this.cleyenda = cleyenda;
        this.sleyenda = sleyenda;
        this.bordenleyendas = bordenleyendas;
    }

    /** default constructor */
    public SLeyenda() {
    }

    public java.lang.Integer getCleyenda() {
        return this.cleyenda;
    }

    public void setCleyenda(java.lang.Integer cleyenda) {
        this.cleyenda = cleyenda;
    }

    public java.lang.String getSleyenda() {
        return this.sleyenda;
    }

    public void setSleyenda(java.lang.String sleyenda) {
        this.sleyenda = sleyenda;
    }

    public java.util.Set getBordenleyendas() {
        return this.bordenleyendas;
    }

    public void setBordenleyendas(java.util.Set bordenleyendas) {
        this.bordenleyendas = bordenleyendas;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cleyenda", getCleyenda())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SLeyenda) ) return false;
        SLeyenda castOther = (SLeyenda) other;
        return new EqualsBuilder()
            .append(this.getCleyenda(), castOther.getCleyenda())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCleyenda())
            .toHashCode();
    }

}
