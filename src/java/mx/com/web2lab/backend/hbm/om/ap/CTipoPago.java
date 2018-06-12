package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTipoPago implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipopago;

    /** nullable persistent field */
    private java.lang.String stipopago;

    /** nullable persistent field */
    private java.lang.String utipopagofactura;
        
    /** persistent field */
    private Set tpagopacientes;
    
    /** full constructor */
    public CTipoPago(java.lang.Integer ctipopago, java.lang.String stipopago, java.lang.String utipopagofactura, Set tpagopacientes) {
        this.ctipopago = ctipopago;
        this.stipopago = stipopago;
        this.utipopagofactura = utipopagofactura;
        this.tpagopacientes = tpagopacientes;
    }

    /** default constructor */
    public CTipoPago() {
    }

    /** minimal constructor */
    public CTipoPago(java.lang.Integer ctipopago, Set tpagopacientes) {
        this.ctipopago = ctipopago;
        this.tpagopacientes = tpagopacientes;
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

    public java.lang.String getUtipopagofactura() {
        return this.utipopagofactura;
    }

    public void setUtipopagofactura(java.lang.String utipopagofactura) {
        this.utipopagofactura = utipopagofactura;
    }
    
    public java.util.Set getTpagopacientes() {
        return this.tpagopacientes;
    }

    public void setTpagopacientes(java.util.Set tpagopacientes) {
        this.tpagopacientes = tpagopacientes;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipopago", getCtipopago())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTipoPago) ) return false;
        CTipoPago castOther = (CTipoPago) other;
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
