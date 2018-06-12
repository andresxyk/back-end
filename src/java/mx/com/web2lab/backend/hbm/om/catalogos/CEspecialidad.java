package mx.com.web2lab.backend.hbm.om.catalogos;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CEspecialidad implements Serializable {

    /** identifier field */
    private java.lang.Integer cespecialidad;

    /** persistent field */
    private java.lang.String sespecialidad;

    /** persistent field */
    private Set dexamens;

    /** full constructor */
    public CEspecialidad(java.lang.Integer cespecialidad, java.lang.String sespecialidad, Set dexamens) {
        this.cespecialidad = cespecialidad;
        this.sespecialidad = sespecialidad;
        this.dexamens = dexamens;
    }

    /** default constructor */
    public CEspecialidad() {
    }

    public java.lang.Integer getCespecialidad() {
        return this.cespecialidad;
    }

    public void setCespecialidad(java.lang.Integer cespecialidad) {
        this.cespecialidad = cespecialidad;
    }

    public java.lang.String getSespecialidad() {
        return this.sespecialidad;
    }

    public void setSespecialidad(java.lang.String sespecialidad) {
        this.sespecialidad = sespecialidad;
    }

    public java.util.Set getDexamens() {
        return this.dexamens;
    }

    public void setDexamens(java.util.Set dexamens) {
        this.dexamens = dexamens;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cespecialidad", getCespecialidad())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CEspecialidad) ) return false;
        CEspecialidad castOther = (CEspecialidad) other;
        return new EqualsBuilder()
            .append(this.getCespecialidad(), castOther.getCespecialidad())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCespecialidad())
            .toHashCode();
    }

}
