package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CVigencia implements Serializable {

    /** identifier field */
    private java.lang.Integer cvigencia;

    /** nullable persistent field */
    private java.util.Date dinicio;

    /** nullable persistent field */
    private java.util.Date dtermino;

    /** persistent field */
    private Set econvenios;

    /** full constructor */
    public CVigencia(java.lang.Integer cvigencia, java.util.Date dinicio, java.util.Date dtermino, Set econvenios) {
        this.cvigencia = cvigencia;
        this.dinicio = dinicio;
        this.dtermino = dtermino;
        this.econvenios = econvenios;
    }

    /** default constructor */
    public CVigencia() {
    }

    /** minimal constructor */
    public CVigencia(java.lang.Integer cvigencia, Set econvenios) {
        this.cvigencia = cvigencia;
        this.econvenios = econvenios;
    }

    public java.lang.Integer getCvigencia() {
        return this.cvigencia;
    }

    public void setCvigencia(java.lang.Integer cvigencia) {
        this.cvigencia = cvigencia;
    }

    public java.util.Date getDinicio() {
        return this.dinicio;
    }

    public void setDinicio(java.util.Date dinicio) {
        this.dinicio = dinicio;
    }

    public java.util.Date getDtermino() {
        return this.dtermino;
    }

    public void setDtermino(java.util.Date dtermino) {
        this.dtermino = dtermino;
    }

    public java.util.Set getEconvenios() {
        return this.econvenios;
    }

    public void setEconvenios(java.util.Set econvenios) {
        this.econvenios = econvenios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cvigencia", getCvigencia())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CVigencia) ) return false;
        CVigencia castOther = (CVigencia) other;
        return new EqualsBuilder()
            .append(this.getCvigencia(), castOther.getCvigencia())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCvigencia())
            .toHashCode();
    }

}
