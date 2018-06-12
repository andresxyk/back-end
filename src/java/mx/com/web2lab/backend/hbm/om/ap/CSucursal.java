package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CSucursal implements Serializable {

    /** identifier field */
    private java.lang.Integer csucursal;

    /** nullable persistent field */
    private java.lang.String ssucursal;

    /** nullable persistent field */
    private java.lang.String snombresucursal;

    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca;

    /** persistent field */
    private Set elistasucursals;

    /** persistent field */
    private Set tordensucursalsbycsucursalentrega;

    /** persistent field */
    private Set tordensucursalsbycsucursal;

    /** persistent field */
    private Set tordensucursalcotizacions;

    /** persistent field */
    private Set tgastosucursals;

    /** persistent field */
    private Set tcortecajas;

    /** persistent field */
    private Set tordensucursalfacs;
    
    /** full constructor */
    public CSucursal(java.lang.Integer csucursal, java.lang.String ssucursal, java.lang.String snombresucursal, java.lang.String sdireccion, mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set elistasucursals, Set tordensucursalsbycsucursalentrega, Set tordensucursalsbycsucursal, Set tordensucursalcotizacions , Set tgastosucursals, Set tcortecajas, Set tordensucursalfacs) {
        this.csucursal = csucursal;
        this.ssucursal = ssucursal;
        this.snombresucursal = snombresucursal;
        this.sdireccion = sdireccion;
        this.ccodigopostal = ccodigopostal;
        this.cmarca = cmarca;
        this.elistasucursals = elistasucursals;
        this.tordensucursalsbycsucursalentrega = tordensucursalsbycsucursalentrega;
        this.tordensucursalsbycsucursal = tordensucursalsbycsucursal;
        this.tordensucursalcotizacions = tordensucursalcotizacions;
        this.tgastosucursals = tgastosucursals;
        this.tcortecajas = tcortecajas;
        this.tordensucursalfacs = tordensucursalfacs;
    }

    /** default constructor */
    public CSucursal() {
    }

    /** minimal constructor */
    public CSucursal(java.lang.Integer csucursal, mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set elistasucursals, Set tordensucursalsbycsucursalentrega, Set tordensucursalsbycsucursal, Set tordensucursalcotizacions, Set tgastosucursals, Set tcortecajas, Set tordensucursalfacs) {
        this.csucursal = csucursal;
        this.ccodigopostal = ccodigopostal;
        this.cmarca = cmarca;
        this.elistasucursals = elistasucursals;
        this.tordensucursalsbycsucursalentrega = tordensucursalsbycsucursalentrega;
        this.tordensucursalsbycsucursal = tordensucursalsbycsucursal;
        this.tordensucursalcotizacions = tordensucursalcotizacions;
        this.tgastosucursals = tgastosucursals;
        this.tcortecajas = tcortecajas;
        this.tordensucursalfacs = tordensucursalfacs;
    }

    public java.lang.Integer getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(java.lang.Integer csucursal) {
        this.csucursal = csucursal;
    }

    public java.lang.String getSsucursal() {
        return this.ssucursal;
    }

    public void setSsucursal(java.lang.String ssucursal) {
        this.ssucursal = ssucursal;
    }

    public java.lang.String getSnombresucursal() {
        return this.snombresucursal;
    }

    public void setSnombresucursal(java.lang.String snombresucursal) {
        this.snombresucursal = snombresucursal;
    }

    public java.lang.String getSdireccion() {
        return this.sdireccion;
    }

    public void setSdireccion(java.lang.String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal getCcodigopostal() {
        return this.ccodigopostal;
    }

    public void setCcodigopostal(mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal) {
        this.ccodigopostal = ccodigopostal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CMarca getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca) {
        this.cmarca = cmarca;
    }

    public java.util.Set getElistasucursals() {
        return this.elistasucursals;
    }

    public void setElistasucursals(java.util.Set elistasucursals) {
        this.elistasucursals = elistasucursals;
    }
    public java.util.Set getTordensucursalsbycsucursalentrega() {
        return this.tordensucursalsbycsucursalentrega;
    }

    public void setTordensucursalsbycsucursalentrega(java.util.Set tordensucursalsbycsucursalentrega) {
        this.tordensucursalsbycsucursalentrega = tordensucursalsbycsucursalentrega;
    }

    public java.util.Set getTordensucursalsbycsucursal() {
        return this.tordensucursalsbycsucursal;
    }

    public void setTordensucursalsbycsucursal(java.util.Set tordensucursalsbycsucursal) {
        this.tordensucursalsbycsucursal = tordensucursalsbycsucursal;
    }

    public java.util.Set getTordensucursalcotizacions() {
        return this.tordensucursalcotizacions;
    }

    public void setTordensucursalcotizacions(java.util.Set tordensucursalcotizacions) {
        this.tordensucursalcotizacions = tordensucursalcotizacions;
    }
    
    public java.util.Set getTgastosucursals() {
        return this.tgastosucursals;
    }

    public void setTgastosucursals(java.util.Set tgastosucursals) {
        this.tgastosucursals = tgastosucursals;
    }

    public java.util.Set getTcortecajas() {
        return this.tcortecajas;
    }

    public void setTcortecajas(java.util.Set tcortecajas) {
        this.tcortecajas = tcortecajas;
    }

    public java.util.Set getTordensucursalfacs() {
        return this.tordensucursalfacs;
    }

    public void setTordensucursalfacs(java.util.Set tordensucursalfacs) {
        this.tordensucursalfacs = tordensucursalfacs;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("csucursal", getCsucursal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CSucursal) ) return false;
        CSucursal castOther = (CSucursal) other;
        return new EqualsBuilder()
            .append(this.getCsucursal(), castOther.getCsucursal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCsucursal())
            .toHashCode();
    }

}
