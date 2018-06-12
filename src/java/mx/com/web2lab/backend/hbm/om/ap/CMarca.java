package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMarca implements Serializable {

    /** identifier field */
    private java.lang.Integer cmarca;

    /** nullable persistent field */
    private java.lang.String smarca;

    /** persistent field */
    private Set cmedicos;

    /** persistent field */
    private Set cperfils;

    /** persistent field */
    private Set csucursals;

    /** persistent field */
    private Set tordensucursals;

    /** persistent field */
    private Set tordensucursalcotizacions;

    /** persistent field */
    private Set clistacorporativas;

    /** persistent field */
    private Set tpacientes;

    /** persistent field */
    private Set tordensucursalfacs;

    /** persistent field */
    private Set econvenios;
    
    
    /** full constructor */
    public CMarca(java.lang.Integer cmarca, java.lang.String smarca, Set cmedicos, Set cperfils, Set csucursals, Set econvenios, Set tordensucursals , Set tordensucursalcotizacions, Set clistacorporativas, Set tpacientes, Set tordensucursalfacs) {
        this.cmarca = cmarca;
        this.smarca = smarca;
        this.cmedicos = cmedicos;
        this.cperfils = cperfils;
        this.csucursals = csucursals;
        this.econvenios = econvenios;
        this.tordensucursals = tordensucursals;
        this.tordensucursalcotizacions = tordensucursalcotizacions;
        this.clistacorporativas = clistacorporativas;
        this.clistacorporativas = clistacorporativas;
        this.tordensucursalfacs = tordensucursalfacs;
    }

    /** default constructor */
    public CMarca() {
    }

    /** minimal constructor */
    public CMarca(java.lang.Integer cmarca, Set cmedicos, Set cperfils, Set csucursals, Set tordensucursals, Set tordensucursalcotizacions, Set clistacorporativas, Set tpacientes, Set tordensucursalfacs) {
        this.cmarca = cmarca;
        this.cmedicos = cmedicos;
        this.cperfils = cperfils;
        this.csucursals = csucursals;
        this.tordensucursals = tordensucursals;
        this.tordensucursalcotizacions = tordensucursalcotizacions;
        this.clistacorporativas = clistacorporativas;
        this.tpacientes = tpacientes;
        this.tordensucursalfacs = tordensucursalfacs;
    }

    public java.lang.Integer getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(java.lang.Integer cmarca) {
        this.cmarca = cmarca;
    }

    public java.lang.String getSmarca() {
        return this.smarca;
    }

    public void setSmarca(java.lang.String smarca) {
        this.smarca = smarca;
    }

    public java.util.Set getCmedicos() {
        return this.cmedicos;
    }

    public void setCmedicos(java.util.Set cmedicos) {
        this.cmedicos = cmedicos;
    }

    public java.util.Set getCperfils() {
        return this.cperfils;
    }

    public void setCperfils(java.util.Set cperfils) {
        this.cperfils = cperfils;
    }

    public java.util.Set getCsucursals() {
        return this.csucursals;
    }

    public void setCsucursals(java.util.Set csucursals) {
        this.csucursals = csucursals;
    }

    public java.util.Set getEconvenios() {
        return this.econvenios;
    }

    public void setEconvenios(java.util.Set econvenios) {
        this.econvenios = econvenios;
    }
        
    public java.util.Set getTordensucursals() {
        return this.tordensucursals;
    }

    public void setTordensucursals(java.util.Set tordensucursals) {
        this.tordensucursals = tordensucursals;
    }

    public java.util.Set getTordensucursalcotizacions() {
        return this.tordensucursalcotizacions;
    }

    public void setTordensucursalcotizacions(java.util.Set tordensucursalcotizacions) {
        this.tordensucursalcotizacions = tordensucursalcotizacions;
    }
    
    public java.util.Set getClistacorporativas() {
        return this.clistacorporativas;
    }

    public void setClistacorporativas(java.util.Set clistacorporativas) {
        this.clistacorporativas = clistacorporativas;
    }

    public java.util.Set getTpacientes() {
        return this.tpacientes;
    }

    public void setTpacientes(java.util.Set tpacientes) {
        this.tpacientes = tpacientes;
    }

    public java.util.Set getTordensucursalfacs() {
        return this.tordensucursalfacs;
    }

    public void setTordensucursalfacs(java.util.Set tordensucursalfacs) {
        this.tordensucursalfacs = tordensucursalfacs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmarca", getCmarca())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMarca) ) return false;
        CMarca castOther = (CMarca) other;
        return new EqualsBuilder()
            .append(this.getCmarca(), castOther.getCmarca())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmarca())
            .toHashCode();
    }

}
