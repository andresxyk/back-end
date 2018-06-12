package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CExamenConvenioSinonimo implements Serializable {

    /** identifier field */
    private java.lang.Integer cexamenconveniosinonimo;

    /** persistent field */
    private int cexamen;

    /** nullable persistent field */
    private java.lang.String sclavesinonimo;

    /** nullable persistent field */
    private java.lang.String snombresinonimo;

    /** persistent field */
    private int cconvenio;

    /** full constructor */
    public CExamenConvenioSinonimo(java.lang.Integer cexamenconveniosinonimo, int cexamen, java.lang.String sclavesinonimo, java.lang.String snombresinonimo, int cconvenio) {
        this.cexamenconveniosinonimo = cexamenconveniosinonimo;
        this.cexamen = cexamen;
        this.sclavesinonimo = sclavesinonimo;
        this.snombresinonimo = snombresinonimo;
        this.cconvenio = cconvenio;
    }

    /** default constructor */
    public CExamenConvenioSinonimo() {
    }

    /** minimal constructor */
    public CExamenConvenioSinonimo(java.lang.Integer cexamenconveniosinonimo, int cexamen, int cconvenio) {
        this.cexamenconveniosinonimo = cexamenconveniosinonimo;
        this.cexamen = cexamen;
        this.cconvenio = cconvenio;
    }

    public java.lang.Integer getCexamenconveniosinonimo() {
        return this.cexamenconveniosinonimo;
    }

    public void setCexamenconveniosinonimo(java.lang.Integer cexamenconveniosinonimo) {
        this.cexamenconveniosinonimo = cexamenconveniosinonimo;
    }

    public int getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(int cexamen) {
        this.cexamen = cexamen;
    }

    public java.lang.String getSclavesinonimo() {
        return this.sclavesinonimo;
    }

    public void setSclavesinonimo(java.lang.String sclavesinonimo) {
        this.sclavesinonimo = sclavesinonimo;
    }

    public java.lang.String getSnombresinonimo() {
        return this.snombresinonimo;
    }

    public void setSnombresinonimo(java.lang.String snombresinonimo) {
        this.snombresinonimo = snombresinonimo;
    }

    public int getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(int cconvenio) {
        this.cconvenio = cconvenio;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cexamenconveniosinonimo", getCexamenconveniosinonimo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CExamenConvenioSinonimo) ) return false;
        CExamenConvenioSinonimo castOther = (CExamenConvenioSinonimo) other;
        return new EqualsBuilder()
            .append(this.getCexamenconveniosinonimo(), castOther.getCexamenconveniosinonimo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCexamenconveniosinonimo())
            .toHashCode();
    }

}
