package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CEstadoRegistro implements Serializable {

    /** identifier field */
    private java.lang.Integer cestadoregistro;

    /** nullable persistent field */
    private java.lang.String sestadoregistro;

    /** nullable persistent field */
    private java.lang.String snombretabla;

    /** persistent field */
    private Set cdireccionmedicos;

    /** persistent field */
    private Set eperfilexamens;

    /** persistent field */
    private Set tordenexamensucursals;

    /** persistent field */
    private Set tordensucursals;

    /** persistent field */
    private Set emedicopaquetes;

    /** persistent field */
    private Set tpagopacientes;

    /** persistent field */
    private Set tgastosucursals;

    /** persistent field */
    private Set cclientes;

    /** persistent field */
    private Set tpacientes;

    /** persistent field */
    private Set tfacturaempresas;

    /** persistent field */
    private Set econvenios;

    /** persistent field */
    private Set tfacturaempresadetalles;

    /** persistent field */
    private Set cpromocionmarketings;
    
    /** persistent field */
    private Set tordenexamensucursalfacs;

    /** persistent field */
    private Set tordensucursalfacs;

    /** persistent field */
    private Set tordensucursalcotizacions;

    /** full constructor */
    public CEstadoRegistro(java.lang.Integer cestadoregistro, java.lang.String sestadoregistro, java.lang.String snombretabla, Set cdireccionmedicos, Set eperfilexamens, Set tordenexamensucursals, Set tordensucursals, Set tordensucursalcotizacions, Set emedicopaquetes, Set tpagopacientes, Set tgastosucursals, Set cclientes, Set tpacientes, Set tfacturaempresas, Set econvenios, Set tfacturaempresadetalles, Set cpromocionmarketings, Set tordenexamensucursalfacs, Set tordensucursalfacs) {
        this.cestadoregistro = cestadoregistro;
        this.sestadoregistro = sestadoregistro;
        this.snombretabla = snombretabla;
        this.cdireccionmedicos = cdireccionmedicos;
        this.eperfilexamens = eperfilexamens;
        this.tordenexamensucursals = tordenexamensucursals;
        this.tordensucursals = tordensucursals;
        this.tordensucursalcotizacions = tordensucursalcotizacions;
        this.emedicopaquetes = emedicopaquetes;
        this.tpagopacientes = tpagopacientes;
        this.tgastosucursals = tgastosucursals;
        this.cclientes = cclientes;
        this.tpacientes = tpacientes;
        this.tfacturaempresas = tfacturaempresas;
        this.econvenios = econvenios;
        this.tfacturaempresadetalles = tfacturaempresadetalles;
        this.cpromocionmarketings = cpromocionmarketings;
        this.tordenexamensucursalfacs = tordenexamensucursalfacs;
        this.tordensucursalfacs = tordensucursalfacs;
    }

    /** default constructor */
    public CEstadoRegistro() {
    }

    /** minimal constructor */
    public CEstadoRegistro(java.lang.Integer cestadoregistro, Set cdireccionmedicos, Set eperfilexamens, Set tordenexamensucursals, Set tordensucursals, Set tordensucursalcotizacions, Set emedicopaquetes, Set tpagopacientes, Set tgastosucursals, Set cclientes, Set tpacientes, Set tfacturaempresas, Set econvenios, Set tfacturaempresadetalles, Set cpromocionmarketings, Set tordenexamensucursalfacs, Set tordensucursalfacs) {
        this.cestadoregistro = cestadoregistro;
        this.cdireccionmedicos = cdireccionmedicos;
        this.eperfilexamens = eperfilexamens;
        this.tordenexamensucursals = tordenexamensucursals;
        this.tordensucursals = tordensucursals;
        this.tordensucursalcotizacions = tordensucursalcotizacions;
        this.emedicopaquetes = emedicopaquetes;
        this.tpagopacientes = tpagopacientes;
        this.tgastosucursals = tgastosucursals;
        this.cclientes = cclientes;
        this.tpacientes = tpacientes;
        this.tfacturaempresas = tfacturaempresas;
        this.econvenios = econvenios;
        this.tfacturaempresadetalles = tfacturaempresadetalles;
        this.cpromocionmarketings = cpromocionmarketings;
        this.tordenexamensucursalfacs = tordenexamensucursalfacs;
        this.tordensucursalfacs = tordensucursalfacs;
    }

    public java.lang.Integer getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(java.lang.Integer cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.lang.String getSestadoregistro() {
        return this.sestadoregistro;
    }

    public void setSestadoregistro(java.lang.String sestadoregistro) {
        this.sestadoregistro = sestadoregistro;
    }

    public java.lang.String getSnombretabla() {
        return this.snombretabla;
    }

    public void setSnombretabla(java.lang.String snombretabla) {
        this.snombretabla = snombretabla;
    }

    public java.util.Set getCdireccionmedicos() {
        return this.cdireccionmedicos;
    }

    public void setCdireccionmedicos(java.util.Set cdireccionmedicos) {
        this.cdireccionmedicos = cdireccionmedicos;
    }

    public java.util.Set getEperfilexamens() {
        return this.eperfilexamens;
    }

    public void setEperfilexamens(java.util.Set eperfilexamens) {
        this.eperfilexamens = eperfilexamens;
    }

    public java.util.Set getTordenexamensucursals() {
        return this.tordenexamensucursals;
    }

    public void setTordenexamensucursals(java.util.Set tordenexamensucursals) {
        this.tordenexamensucursals = tordenexamensucursals;
    }

    public java.util.Set getTordensucursals() {
        return this.tordensucursals;
    }

    public void setTordensucursals(java.util.Set tordensucursals) {
        this.tordensucursals = tordensucursals;
    }

    public java.util.Set getEmedicopaquetes() {
        return this.emedicopaquetes;
    }

    public void setEmedicopaquetes(java.util.Set emedicopaquetes) {
        this.emedicopaquetes = emedicopaquetes;
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

    public java.util.Set getCclientes() {
        return this.cclientes;
    }

    public void setCclientes(java.util.Set cclientes) {
        this.cclientes = cclientes;
    }

    public java.util.Set getTpacientes() {
        return this.tpacientes;
    }

    public void setTpacientes(java.util.Set tpacientes) {
        this.tpacientes = tpacientes;
    }

    public java.util.Set getTfacturaempresas() {
        return this.tfacturaempresas;
    }

    public void setTfacturaempresas(java.util.Set tfacturaempresas) {
        this.tfacturaempresas = tfacturaempresas;
    }

    public java.util.Set getEconvenios() {
        return this.econvenios;
    }

    public void setEconvenios(java.util.Set econvenios) {
        this.econvenios = econvenios;
    }

    public java.util.Set getTfacturaempresadetalles() {
        return this.tfacturaempresadetalles;
    }

    public void setTfacturaempresadetalles(java.util.Set tfacturaempresadetalles) {
        this.tfacturaempresadetalles = tfacturaempresadetalles;
    }

    public java.util.Set getCpromocionmarketings() {
        return this.cpromocionmarketings;
    }

    public void setCpromocionmarketings(java.util.Set cpromocionmarketings) {
        this.cpromocionmarketings = cpromocionmarketings;
    }

    public java.util.Set getTordenexamensucursalfacs() {
        return this.tordenexamensucursalfacs;
    }

    public void setTordenexamensucursalfacs(java.util.Set tordenexamensucursalfacs) {
        this.tordenexamensucursalfacs = tordenexamensucursalfacs;
    }

    public java.util.Set getTordensucursalfacs() {
        return this.tordensucursalfacs;
    }

    public void setTordensucursalfacs(java.util.Set tordensucursalfacs) {
        this.tordensucursalfacs = tordensucursalfacs;
    }
    
    public java.util.Set getTordensucursalcotizacions() {
        return this.tordensucursalcotizacions;
    }

    public void setTordensucursalcotizacions(java.util.Set tordensucursalcotizacions) {
        this.tordensucursalcotizacions = tordensucursalcotizacions;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("cestadoregistro", getCestadoregistro())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CEstadoRegistro) ) return false;
        CEstadoRegistro castOther = (CEstadoRegistro) other;
        return new EqualsBuilder()
            .append(this.getCestadoregistro(), castOther.getCestadoregistro())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCestadoregistro())
            .toHashCode();
    }

}
