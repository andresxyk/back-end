package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TCorteCaja implements Serializable {

    /** identifier field */
    private java.lang.Integer kcortecaja;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private int ucortecajasucursal;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal;

    /** persistent field */
    private Set tpagopacientes;

    /** persistent field */
    private Set tgastosucursals;

    /** persistent field */
    private Set tcortecajaarqueos;

    /** full constructor */
    public TCorteCaja(java.lang.Integer kcortecaja, java.util.Date dregistro, int ucortecajasucursal, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal, Set tpagopacientes, Set tgastosucursals, Set tcortecajaarqueos) {
        this.kcortecaja = kcortecaja;
        this.dregistro = dregistro;
        this.ucortecajasucursal = ucortecajasucursal;
        this.csucursal = csucursal;
        this.tpagopacientes = tpagopacientes;
        this.tgastosucursals = tgastosucursals;
        this.tcortecajaarqueos = tcortecajaarqueos;
    }

    /** default constructor */
    public TCorteCaja() {
    }

    /** minimal constructor */
    public TCorteCaja(java.lang.Integer kcortecaja, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal, Set tpagopacientes, Set tgastosucursals, Set tcortecajaarqueos) {
        this.kcortecaja = kcortecaja;
        this.csucursal = csucursal;
        this.tpagopacientes = tpagopacientes;
        this.tgastosucursals = tgastosucursals;
        this.tcortecajaarqueos = tcortecajaarqueos;
    }

    public java.lang.Integer getKcortecaja() {
        return this.kcortecaja;
    }

    public void setKcortecaja(java.lang.Integer kcortecaja) {
        this.kcortecaja = kcortecaja;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getUcortecajasucursal() {
        return this.ucortecajasucursal;
    }

    public void setUcortecajasucursal(int ucortecajasucursal) {
        this.ucortecajasucursal = ucortecajasucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CSucursal getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal) {
        this.csucursal = csucursal;
    }

    public java.util.Set getTpagopacientes() {
        return this.tpagopacientes;
    }

    public void setTpagopacientes(java.util.Set tpagopacientes) {
        this.tpagopacientes = tpagopacientes;
    }

    public java.util.Set getTgastosucursals() {
        return this.tgastosucursals;
    }

    public void setTgastosucursals(java.util.Set tgastosucursals) {
        this.tgastosucursals = tgastosucursals;
    }

    public java.util.Set getTcortecajaarqueos() {
        return this.tcortecajaarqueos;
    }

    public void setTcortecajaarqueos(java.util.Set tcortecajaarqueos) {
        this.tcortecajaarqueos = tcortecajaarqueos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kcortecaja", getKcortecaja())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TCorteCaja) ) return false;
        TCorteCaja castOther = (TCorteCaja) other;
        return new EqualsBuilder()
            .append(this.getKcortecaja(), castOther.getKcortecaja())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKcortecaja())
            .toHashCode();
    }

}
