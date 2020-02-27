package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CZonaVenta implements Serializable {

    /** identifier field */
    private java.lang.Integer czonaventa;

    /** nullable persistent field */
    private java.lang.String szonaventa;

    /** nullable persistent field */
    private java.lang.String sejecutivoventas;

    /** full constructor */
    public CZonaVenta(java.lang.Integer czonaventa,String szonaventa, String sejecutivoventas) {
        this.czonaventa = czonaventa;
        this.szonaventa = szonaventa;
        this.sejecutivoventas = sejecutivoventas;
    }

    /** default constructor */
    public CZonaVenta() {
    }

    /** minimal constructor */
    public CZonaVenta(java.lang.Integer czonaventa,String szonaventa) {
        this.czonaventa = czonaventa;
        this.szonaventa = szonaventa;
    }

    public java.lang.Integer getCzonaventa() {
        return this.czonaventa;
    }

    public void setCzonaventa(java.lang.Integer czonaventa) {
        this.czonaventa = czonaventa;
    }

    public java.lang.String getSzonaventa() {
        return this.szonaventa;
    }

    public void setSzonaventa(java.lang.String szonaventa) {
        this.szonaventa = szonaventa;
    }

    public java.lang.String getSejecutivoventas() {
        return this.sejecutivoventas;
    }

    public void setSejecutivoventas(java.lang.String sejecutivoventas) {
        this.sejecutivoventas = sejecutivoventas;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("czonaventa", getCzonaventa())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CZonaVenta) ) return false;
        CZonaVenta castOther = (CZonaVenta) other;
        return new EqualsBuilder()
            .append(this.getCzonaventa(), castOther.getCzonaventa())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCzonaventa())
            .toHashCode();
    }

}
