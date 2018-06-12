package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTipoPagoFactura implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipopago;

    /** nullable persistent field */
    private java.lang.String stipopago;


    /** persistent field */
    private Set tpagofacturas;
    
    /** full constructor */
    public CTipoPagoFactura(java.lang.Integer ctipopago, java.lang.String stipopago, Set tpagofacturas) {
        this.ctipopago = ctipopago;
        this.stipopago = stipopago;
        this.tpagofacturas = tpagofacturas;
    }

    /** default constructor */
    public CTipoPagoFactura() {
    }

    /** minimal constructor */
    public CTipoPagoFactura(java.lang.Integer ctipopago, Set tpagofacturas) {
        this.ctipopago = ctipopago;
        this.tpagofacturas = tpagofacturas;
    }

    public java.lang.Integer getCtipopago() {
        return this.ctipopago;
    }

    public void setCtipopago(java.lang.Integer ctipopago) {
        this.ctipopago = ctipopago;
    }

    public java.lang.String getStipopago() {
        return this.stipopago;
    }

    public void setStipopago(java.lang.String stipopago) {
        this.stipopago = stipopago;
    }

    public java.util.Set getTpagofacturas() {
        return this.tpagofacturas;
    }

    public void setTpagofacturas(java.util.Set tpagofacturas) {
        this.tpagofacturas = tpagofacturas;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipopago", getCtipopago())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTipoPagoFactura) ) return false;
        CTipoPagoFactura castOther = (CTipoPagoFactura) other;
        return new EqualsBuilder()
            .append(this.getCtipopago(), castOther.getCtipopago())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipopago())
            .toHashCode();
    }

}
