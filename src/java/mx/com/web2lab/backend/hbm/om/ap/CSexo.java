package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CSexo implements Serializable {

    /** identifier field */
    private java.lang.Integer csexo;

    /** nullable persistent field */
    private java.lang.String ssexo;

    /** persistent field */
    private Set cmedicos;

    /** full constructor */
    public CSexo(java.lang.Integer csexo, java.lang.String ssexo, Set cmedicos) {
        this.csexo = csexo;
        this.ssexo = ssexo;
        this.cmedicos = cmedicos;
    }

    /** default constructor */
    public CSexo() {
    }

    /** minimal constructor */
    public CSexo(java.lang.Integer csexo, Set cmedicos) {
        this.csexo = csexo;
        this.cmedicos = cmedicos;
    }

    public java.lang.Integer getCsexo() {
        return this.csexo;
    }

    public void setCsexo(java.lang.Integer csexo) {
        this.csexo = csexo;
    }

    public java.lang.String getSsexo() {
        return this.ssexo;
    }

    public void setSsexo(java.lang.String ssexo) {
        this.ssexo = ssexo;
    }

    public java.util.Set getCmedicos() {
        return this.cmedicos;
    }

    public void setCmedicos(java.util.Set cmedicos) {
        this.cmedicos = cmedicos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("csexo", getCsexo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CSexo) ) return false;
        CSexo castOther = (CSexo) other;
        return new EqualsBuilder()
            .append(this.getCsexo(), castOther.getCsexo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCsexo())
            .toHashCode();
    }

}
