package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CZonaMedico implements Serializable {

    /** identifier field */
    private java.lang.Integer czona;

    /** nullable persistent field */
    private int zona;

    /** persistent field */
    private Set cmedicos;

    /** full constructor */
    public CZonaMedico(java.lang.Integer czona, int zona, Set cmedicos) {
        this.czona = czona;
        this.zona = zona;
        this.cmedicos = cmedicos;
    }

    /** default constructor */
    public CZonaMedico() {
    }

    /** minimal constructor */
    public CZonaMedico(java.lang.Integer czona, Set cmedicos) {
        this.czona = czona;
        this.cmedicos = cmedicos;
    }

    public java.lang.Integer getCzona() {
        return this.czona;
    }

    public void setCzona(java.lang.Integer czona) {
        this.czona = czona;
    }

    public int getZona() {
        return this.zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public java.util.Set getCmedicos() {
        return this.cmedicos;
    }

    public void setCmedicos(java.util.Set cmedicos) {
        this.cmedicos = cmedicos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("czona", getCzona())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CZonaMedico) ) return false;
        CZonaMedico castOther = (CZonaMedico) other;
        return new EqualsBuilder()
            .append(this.getCzona(), castOther.getCzona())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCzona())
            .toHashCode();
    }

}
