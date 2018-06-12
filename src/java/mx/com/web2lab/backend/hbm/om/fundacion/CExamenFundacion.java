package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CExamenFundacion implements Serializable {

    /** identifier field */
    private java.lang.Integer cexamenfundacion;

    /** nullable persistent field */
    private java.lang.String sexamenfundacion;

    /** nullable persistent field */
    private int udiasproceso;

    /** persistent field */
    private Set bordenexamenfundacions;

    /** persistent field */
    private Set dexamenfundacions;

    /** full constructor */
    public CExamenFundacion(java.lang.Integer cexamenfundacion, java.lang.String sexamenfundacion, int udiasproceso, Set bordenexamenfundacions, Set dexamenfundacions) {
        this.cexamenfundacion = cexamenfundacion;
        this.sexamenfundacion = sexamenfundacion;
        this.udiasproceso = udiasproceso;        
        this.bordenexamenfundacions = bordenexamenfundacions;
        this.dexamenfundacions = dexamenfundacions;
    }

    /** default constructor */
    public CExamenFundacion() {
    }

    /** minimal constructor */
    public CExamenFundacion(java.lang.Integer cexamenfundacion, int udiasproceso, Set bordenexamenfundacions, Set dexamenfundacions) {
        this.cexamenfundacion = cexamenfundacion;
        this.udiasproceso = udiasproceso;
        this.bordenexamenfundacions = bordenexamenfundacions;
        this.dexamenfundacions = dexamenfundacions;
    }

    public java.lang.Integer getCexamenfundacion() {
        return this.cexamenfundacion;
    }

    public void setCexamenfundacion(java.lang.Integer cexamenfundacion) {
        this.cexamenfundacion = cexamenfundacion;
    }

    public java.lang.String getSexamenfundacion() {
        return this.sexamenfundacion;
    }

    public void setSexamenfundacion(java.lang.String sexamenfundacion) {
        this.sexamenfundacion = sexamenfundacion;
    }

    public int getUdiasproceso() {
        return this.udiasproceso;
    }

    public void setUdiasproceso(int udiasproceso) {
        this.udiasproceso = udiasproceso;
    }
    
    public java.util.Set getBordenexamenfundacions() {
        return this.bordenexamenfundacions;
    }

    public void setBordenexamenfundacions(java.util.Set bordenexamenfundacions) {
        this.bordenexamenfundacions = bordenexamenfundacions;
    }

    public java.util.Set getDexamenfundacions() {
        return this.dexamenfundacions;
    }

    public void setDexamenfundacions(java.util.Set dexamenfundacions) {
        this.dexamenfundacions = dexamenfundacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cexamenfundacion", getCexamenfundacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CExamenFundacion) ) return false;
        CExamenFundacion castOther = (CExamenFundacion) other;
        return new EqualsBuilder()
            .append(this.getCexamenfundacion(), castOther.getCexamenfundacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCexamenfundacion())
            .toHashCode();
    }

}
