package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TDatoAdicional implements Serializable {

    /** identifier field */
    private java.lang.Integer kdatoadicional;

    /** nullable persistent field */
    private int kordensucursal;

    /** persistent field */
    private int kfactura;

    /** nullable persistent field */
    private java.lang.String svalor;

    /** nullable persistent field */
    private int kpaciente;

    /** persistent field */
    private java.lang.Integer cdatoadicional;

    /** full constructor */
    public TDatoAdicional(java.lang.Integer kdatoadicional, int kordensucursal, int kfactura, java.lang.String svalor, int kpaciente, java.lang.Integer cdatoadicional) {
        this.kdatoadicional = kdatoadicional;
        this.kordensucursal = kordensucursal;
        this.kfactura = kfactura;
        this.svalor = svalor;
        this.kpaciente = kpaciente;
        this.cdatoadicional = cdatoadicional;
    }

    /** default constructor */
    public TDatoAdicional() {
    }

    /** minimal constructor */
    public TDatoAdicional(java.lang.Integer kdatoadicional, int kfactura,java.lang.Integer cdatoadicional) {
        this.kdatoadicional = kdatoadicional;
        this.kfactura = kfactura;
        this.cdatoadicional = cdatoadicional;
    }

    public java.lang.Integer getKdatoadicional() {
        return this.kdatoadicional;
    }

    public void setKdatoadicional(java.lang.Integer kdatoadicional) {
        this.kdatoadicional = kdatoadicional;
    }

    public int getKordensucursal() {
        return this.kordensucursal;
    }

    public void setKordensucursal(int kordensucursal) {
        this.kordensucursal = kordensucursal;
    }

    public int getKfactura() {
        return this.kfactura;
    }

    public void setKfactura(int kfactura) {
        this.kfactura = kfactura;
    }

    public java.lang.String getSvalor() {
        return this.svalor;
    }

    public void setSvalor(java.lang.String svalor) {
        this.svalor = svalor;
    }

    public int getKpaciente() {
        return this.kpaciente;
    }

    public void setKpaciente(int kpaciente) {
        this.kpaciente = kpaciente;
    }

    public  java.lang.Integer getCDatoAdicional() {
        return this.cdatoadicional;
    }

    public void setCDatoAdicional(java.lang.Integer cdatoadicional) {
        this.cdatoadicional = cdatoadicional;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kdatoadicional", getKdatoadicional())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TDatoAdicional) ) return false;
        TDatoAdicional castOther = (TDatoAdicional) other;
        return new EqualsBuilder()
            .append(this.getKdatoadicional(), castOther.getKdatoadicional())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKdatoadicional())
            .toHashCode();
    }

}
