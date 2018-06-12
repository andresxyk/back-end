package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CEspecialidad implements Serializable {

    /** identifier field */
    private java.lang.Integer cespecialidad;

    /** nullable persistent field */
    private java.lang.String sespecialidad;

    /** persistent field */
    private Set cmedicos;

    /** full constructor */
    public CEspecialidad(java.lang.Integer cespecialidad, java.lang.String sespecialidad, Set cmedicos) {
        this.cespecialidad = cespecialidad;
        this.sespecialidad = sespecialidad;
        this.cmedicos = cmedicos;
    }

    /** default constructor */
    public CEspecialidad() {
    }

    /** minimal constructor */
    public CEspecialidad(java.lang.Integer cespecialidad, Set cmedicos) {
        this.cespecialidad = cespecialidad;
        this.cmedicos = cmedicos;
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

    public java.util.Set getCmedicos() {
        return this.cmedicos;
    }

    public void setCmedicos(java.util.Set cmedicos) {
        this.cmedicos = cmedicos;
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
