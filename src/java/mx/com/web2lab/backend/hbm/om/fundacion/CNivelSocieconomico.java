package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CNivelSocieconomico implements Serializable {

    /** identifier field */
    private java.lang.Integer cnivelsocieconomico;

    /** nullable persistent field */
    private java.lang.String snivelsocieconomico;

    /** persistent field */
    private Set dexamenfundacions;

    /** persistent field */
    private Set bpacientefundacions;

    /** full constructor */
    public CNivelSocieconomico(java.lang.Integer cnivelsocieconomico, java.lang.String snivelsocieconomico, Set dexamenfundacions, Set bpacientefundacions) {
        this.cnivelsocieconomico = cnivelsocieconomico;
        this.snivelsocieconomico = snivelsocieconomico;
        this.dexamenfundacions = dexamenfundacions;
        this.bpacientefundacions = bpacientefundacions;
    }

    /** default constructor */
    public CNivelSocieconomico() {
    }

    /** minimal constructor */
    public CNivelSocieconomico(java.lang.Integer cnivelsocieconomico, Set dexamenfundacions, Set bpacientefundacions) {
        this.cnivelsocieconomico = cnivelsocieconomico;
        this.dexamenfundacions = dexamenfundacions;
        this.bpacientefundacions = bpacientefundacions;
    }

    public java.lang.Integer getCnivelsocieconomico() {
        return this.cnivelsocieconomico;
    }

    public void setCnivelsocieconomico(java.lang.Integer cnivelsocieconomico) {
        this.cnivelsocieconomico = cnivelsocieconomico;
    }

    public java.lang.String getSnivelsocieconomico() {
        return this.snivelsocieconomico;
    }

    public void setSnivelsocieconomico(java.lang.String snivelsocieconomico) {
        this.snivelsocieconomico = snivelsocieconomico;
    }

    public java.util.Set getDexamenfundacions() {
        return this.dexamenfundacions;
    }

    public void setDexamenfundacions(java.util.Set dexamenfundacions) {
        this.dexamenfundacions = dexamenfundacions;
    }

    public java.util.Set getBpacientefundacions() {
        return this.bpacientefundacions;
    }

    public void setBpacientefundacions(java.util.Set bpacientefundacions) {
        this.bpacientefundacions = bpacientefundacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cnivelsocieconomico", getCnivelsocieconomico())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CNivelSocieconomico) ) return false;
        CNivelSocieconomico castOther = (CNivelSocieconomico) other;
        return new EqualsBuilder()
            .append(this.getCnivelsocieconomico(), castOther.getCnivelsocieconomico())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCnivelsocieconomico())
            .toHashCode();
    }

}
