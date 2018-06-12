package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CReferenciaDireccion implements Serializable {

    /** identifier field */
    private java.lang.Integer creferenciadireccion;

    /** nullable persistent field */
    private java.lang.String sreferenciadireccion;

    /** persistent field */
    private Set cdireccionmedicos;

    /** full constructor */
    public CReferenciaDireccion(java.lang.Integer creferenciadireccion, java.lang.String sreferenciadireccion, Set cdireccionmedicos) {
        this.creferenciadireccion = creferenciadireccion;
        this.sreferenciadireccion = sreferenciadireccion;
        this.cdireccionmedicos = cdireccionmedicos;
    }

    /** default constructor */
    public CReferenciaDireccion() {
    }

    /** minimal constructor */
    public CReferenciaDireccion(java.lang.Integer creferenciadireccion, Set cdireccionmedicos) {
        this.creferenciadireccion = creferenciadireccion;
        this.cdireccionmedicos = cdireccionmedicos;
    }

    public java.lang.Integer getCreferenciadireccion() {
        return this.creferenciadireccion;
    }

    public void setCreferenciadireccion(java.lang.Integer creferenciadireccion) {
        this.creferenciadireccion = creferenciadireccion;
    }

    public java.lang.String getSreferenciadireccion() {
        return this.sreferenciadireccion;
    }

    public void setSreferenciadireccion(java.lang.String sreferenciadireccion) {
        this.sreferenciadireccion = sreferenciadireccion;
    }

    public java.util.Set getCdireccionmedicos() {
        return this.cdireccionmedicos;
    }

    public void setCdireccionmedicos(java.util.Set cdireccionmedicos) {
        this.cdireccionmedicos = cdireccionmedicos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("creferenciadireccion", getCreferenciadireccion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CReferenciaDireccion) ) return false;
        CReferenciaDireccion castOther = (CReferenciaDireccion) other;
        return new EqualsBuilder()
            .append(this.getCreferenciadireccion(), castOther.getCreferenciadireccion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCreferenciadireccion())
            .toHashCode();
    }

}
