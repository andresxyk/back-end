package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CReporteExcelFac implements Serializable {

    /** identifier field */
    private java.lang.Integer creporteexcelfac;

    /** nullable persistent field */
    private java.lang.String sdescripcion;

    /** nullable persistent field */
    private java.lang.String sreporteexcelfac;

    /** nullable persistent field */
    private java.lang.String svariables;

    /** full constructor */
    public CReporteExcelFac(java.lang.Integer creporteexcelfac, java.lang.String sdescripcion, java.lang.String sreporteexcelfac, java.lang.String svariables) {
        this.creporteexcelfac = creporteexcelfac;
        this.sdescripcion = sdescripcion;
        this.sreporteexcelfac = sreporteexcelfac;
        this.svariables = svariables;
    }

    /** default constructor */
    public CReporteExcelFac() {
    }

    /** minimal constructor */
    public CReporteExcelFac(java.lang.Integer creporteexcelfac) {
        this.creporteexcelfac = creporteexcelfac;
    }

    public java.lang.Integer getCreporteexcelfac() {
        return this.creporteexcelfac;
    }

    public void setCreporteexcelfac(java.lang.Integer creporteexcelfac) {
        this.creporteexcelfac = creporteexcelfac;
    }

    public java.lang.String getSdescripcion() {
        return this.sdescripcion;
    }

    public void setSdescripcion(java.lang.String sdescripcion) {
        this.sdescripcion = sdescripcion;
    }

    public java.lang.String getSreporteexcelfac() {
        return this.sreporteexcelfac;
    }

    public void setSreporteexcelfac(java.lang.String sreporteexcelfac) {
        this.sreporteexcelfac = sreporteexcelfac;
    }

    public java.lang.String getSvariables() {
        return this.svariables;
    }

    public void setSvariables(java.lang.String svariables) {
        this.svariables = svariables;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("creporteexcelfac", getCreporteexcelfac())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CReporteExcelFac) ) return false;
        CReporteExcelFac castOther = (CReporteExcelFac) other;
        return new EqualsBuilder()
            .append(this.getCreporteexcelfac(), castOther.getCreporteexcelfac())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCreporteexcelfac())
            .toHashCode();
    }

}
