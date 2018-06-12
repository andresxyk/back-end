package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CIndicacionTomador implements Serializable {

    /** identifier field */
    private java.lang.Integer cindicaciontomador;

    /** nullable persistent field */
    private java.lang.String sindicaciontomador;

    /** full constructor */
    public CIndicacionTomador(java.lang.Integer cindicaciontomador, java.lang.String sindicaciontomador) {
        this.cindicaciontomador = cindicaciontomador;
        this.sindicaciontomador = sindicaciontomador;
    }

    /** default constructor */
    public CIndicacionTomador() {
    }

    /** minimal constructor */
    public CIndicacionTomador(java.lang.Integer cindicaciontomador) {
        this.cindicaciontomador = cindicaciontomador;
    }

    public java.lang.Integer getCindicaciontomador() {
        return this.cindicaciontomador;
    }

    public void setCindicaciontomador(java.lang.Integer cindicaciontomador) {
        this.cindicaciontomador = cindicaciontomador;
    }

    public java.lang.String getSindicaciontomador() {
        return this.sindicaciontomador;
    }

    public void setSindicaciontomador(java.lang.String sindicaciontomador) {
        this.sindicaciontomador = sindicaciontomador;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cindicaciontomador", getCindicaciontomador())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CIndicacionTomador) ) return false;
        CIndicacionTomador castOther = (CIndicacionTomador) other;
        return new EqualsBuilder()
            .append(this.getCindicaciontomador(), castOther.getCindicaciontomador())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCindicaciontomador())
            .toHashCode();
    }

}
