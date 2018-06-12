package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TOrdenSucursalFac implements Serializable {

    /** identifier field */
    private java.lang.Integer kordensucursalfac;

    /** nullable persistent field */
    private int uorden;

    /** nullable persistent field */
    private java.lang.String ssucursal;

    /** persistent field */
    private int kviajefac;

    /** persistent field */
    private java.math.BigDecimal userId;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.util.Date dcierre;

    /** nullable persistent field */
    private java.math.BigDecimal msubtotal;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentopromocion;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentoempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mfacturaempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mpagopaciente;

    /** nullable persistent field */
    private java.math.BigDecimal miva;
    
    /** nullable persistent field */
    private boolean bestadoactivo;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentomedico;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura; 

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal; 

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio; 

    /** persistent field */
    private int kordensucursal; 

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private Set tordenexamensucursalfacs;

    /** full constructor */
    public TOrdenSucursalFac(java.lang.Integer kordensucursalfac, int uorden, java.lang.String ssucursal, int kviajefac, java.math.BigDecimal userId, java.util.Date dregistro, java.util.Date dcierre, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuentopromocion, java.math.BigDecimal mdescuentoempresa, java.math.BigDecimal mfacturaempresa, java.math.BigDecimal mpagopaciente, java.math.BigDecimal miva , boolean bestadoactivo, java.math.BigDecimal mdescuentomedico, mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio, int
    		kordensucursal, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, Set tordenexamensucursalfacs) {
        this.kordensucursalfac = kordensucursalfac;
        this.uorden = uorden;
        this.ssucursal = ssucursal;
        this.kviajefac = kviajefac;
        this.userId = userId;
        this.dregistro = dregistro;
        this.dcierre = dcierre;
        this.msubtotal = msubtotal;
        this.mdescuentopromocion = mdescuentopromocion;
        this.mdescuentoempresa = mdescuentoempresa;
        this.mfacturaempresa = mfacturaempresa;
        this.mpagopaciente = mpagopaciente;
        this.miva = miva;
        this.bestadoactivo = bestadoactivo;
        this.mdescuentomedico = mdescuentomedico;
        this.tfactura = tfactura;
        this.csucursal = csucursal;
        this.cconvenio = cconvenio;
        this.kordensucursal = kordensucursal;
        this.cmarca = cmarca;
        this.cestadoregistro = cestadoregistro;
        this.tordenexamensucursalfacs = tordenexamensucursalfacs;
    }

    /** default constructor */
    public TOrdenSucursalFac() {
    }

    /** minimal constructor */
    public TOrdenSucursalFac(java.lang.Integer kordensucursalfac, int kviajefac, java.math.BigDecimal userId, mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio, int kordensucursal, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, Set tordenexamensucursalfacs) {
        this.kordensucursalfac = kordensucursalfac;
        this.kviajefac = kviajefac;
        this.userId = userId;
        this.tfactura = tfactura;
        this.csucursal = csucursal;
        this.cconvenio = cconvenio;
        this.kordensucursal = kordensucursal;
        this.cmarca = cmarca;
        this.cestadoregistro = cestadoregistro;
        this.tordenexamensucursalfacs = tordenexamensucursalfacs;
    }

    public java.lang.Integer getKordensucursalfac() {
        return this.kordensucursalfac;
    }

    public void setKordensucursalfac(java.lang.Integer kordensucursalfac) {
        this.kordensucursalfac = kordensucursalfac;
    }

    public int getUorden() {
        return this.uorden;
    }

    public void setUorden(int uorden) {
        this.uorden = uorden;
    }

    public java.lang.String getSsucursal() {
        return this.ssucursal;
    }

    public void setSsucursal(java.lang.String ssucursal) {
        this.ssucursal = ssucursal;
    }

    public int getKviajefac() {
        return this.kviajefac;
    }

    public void setKviajefac(int kviajefac) {
        this.kviajefac = kviajefac;
    }

    public java.math.BigDecimal getUserId() {
        return this.userId;
    }

    public void setUserId(java.math.BigDecimal userId) {
        this.userId = userId;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.util.Date getDcierre() {
        return this.dcierre;
    }

    public void setDcierre(java.util.Date dcierre) {
        this.dcierre = dcierre;
    }

    public java.math.BigDecimal getMsubtotal() {
        return this.msubtotal;
    }

    public void setMsubtotal(java.math.BigDecimal msubtotal) {
        this.msubtotal = msubtotal;
    }

    public java.math.BigDecimal getMdescuentopromocion() {
        return this.mdescuentopromocion;
    }

    public void setMdescuentopromocion(java.math.BigDecimal mdescuentopromocion) {
        this.mdescuentopromocion = mdescuentopromocion;
    }

    public java.math.BigDecimal getMdescuentoempresa() {
        return this.mdescuentoempresa;
    }

    public void setMdescuentoempresa(java.math.BigDecimal mdescuentoempresa) {
        this.mdescuentoempresa = mdescuentoempresa;
    }

    public java.math.BigDecimal getMfacturaempresa() {
        return this.mfacturaempresa;
    }

    public void setMfacturaempresa(java.math.BigDecimal mfacturaempresa) {
        this.mfacturaempresa = mfacturaempresa;
    }

    public java.math.BigDecimal getMpagopaciente() {
        return this.mpagopaciente;
    }

    public void setMpagopaciente(java.math.BigDecimal mpagopaciente) {
        this.mpagopaciente = mpagopaciente;
    }
    
    public java.math.BigDecimal getMiva() {
        return this.miva;
    }

    public void setMiva(java.math.BigDecimal miva) {
        this.miva = miva;
    }
   
    public boolean isBestadoactivo() {
        return this.bestadoactivo;
    }

    public void setBestadoactivo(boolean bestadoactivo) {
        this.bestadoactivo = bestadoactivo;
    }

    public java.math.BigDecimal getMdescuentomedico() {
        return this.mdescuentomedico;
    }

    public void setMdescuentomedico(java.math.BigDecimal mdescuentomedico) {
        this.mdescuentomedico = mdescuentomedico;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TFactura getTfactura() {
        return this.tfactura;
    }

    public void setTfactura(mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura) {
        this.tfactura = tfactura;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CSucursal getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal) {
        this.csucursal = csucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CConvenio getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.cconvenio = cconvenio;
    }

    public int getKordensucursal() {
        return this.kordensucursal;
    }

    public void setKordensucursal(int kordensucursal) {
        this.kordensucursal = kordensucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CMarca getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca) {
        this.cmarca = cmarca;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.util.Set getTordenexamensucursalfacs() {
        return this.tordenexamensucursalfacs;
    }

    public void setTordenexamensucursalfacs(java.util.Set tordenexamensucursalfacs) {
        this.tordenexamensucursalfacs = tordenexamensucursalfacs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kordensucursalfac", getKordensucursalfac())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TOrdenSucursalFac) ) return false;
        TOrdenSucursalFac castOther = (TOrdenSucursalFac) other;
        return new EqualsBuilder()
            .append(this.getKordensucursalfac(), castOther.getKordensucursalfac())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordensucursalfac())
            .toHashCode();
    }

}
