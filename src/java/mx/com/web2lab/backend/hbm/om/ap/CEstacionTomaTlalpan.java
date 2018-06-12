package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CEstacionTomaTlalpan implements Serializable {

    /** identifier field */
    private int cestaciontomatlalpan;

    /** identifier field */
    private int csucursal;

    /** identifier field */
    private java.lang.String sestacion;

    /** identifier field */
    private java.lang.String sestaciontomatlalpan;

    /** full constructor */
    public CEstacionTomaTlalpan(int cestaciontomatlalpan, int csucursal, java.lang.String sestacion, java.lang.String sestaciontomatlalpan) {
        this.cestaciontomatlalpan = cestaciontomatlalpan;
        this.csucursal = csucursal;
        this.sestacion = sestacion;
        this.sestaciontomatlalpan = sestaciontomatlalpan;
    }

    /** default constructor */
    public CEstacionTomaTlalpan() {
    }

    public int getCestaciontomatlalpan() {
        return this.cestaciontomatlalpan;
    }

    public void setCestaciontomatlalpan(int cestaciontomatlalpan) {
        this.cestaciontomatlalpan = cestaciontomatlalpan;
    }

    public int getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(int csucursal) {
        this.csucursal = csucursal;
    }

    public java.lang.String getSestacion() {
        return this.sestacion;
    }

    public void setSestacion(java.lang.String sestacion) {
        this.sestacion = sestacion;
    }

    public java.lang.String getSestaciontomatlalpan() {
        return this.sestaciontomatlalpan;
    }

    public void setSestaciontomatlalpan(java.lang.String sestaciontomatlalpan) {
        this.sestaciontomatlalpan = sestaciontomatlalpan;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cestaciontomatlalpan", getCestaciontomatlalpan())
            .append("csucursal", getCsucursal())
            .append("sestacion", getSestacion())
            .append("sestaciontomatlalpan", getSestaciontomatlalpan())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CEstacionTomaTlalpan) ) return false;
        CEstacionTomaTlalpan castOther = (CEstacionTomaTlalpan) other;
        return new EqualsBuilder()
            .append(this.getCestaciontomatlalpan(), castOther.getCestaciontomatlalpan())
            .append(this.getCsucursal(), castOther.getCsucursal())
            .append(this.getSestacion(), castOther.getSestacion())
            .append(this.getSestaciontomatlalpan(), castOther.getSestaciontomatlalpan())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCestaciontomatlalpan())
            .append(getCsucursal())
            .append(getSestacion())
            .append(getSestaciontomatlalpan())
            .toHashCode();
    }

}
