package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TOrdenSucursalCotizacion implements Serializable {

    /** identifier field */
    private java.lang.Integer kordensucursalcotizacion;

    /** persistent field */
    private int kordensucursal;

    /** nullable persistent field */
    private java.lang.String ssucursal;

    /** nullable persistent field */
    private java.lang.String smedico;

    /** nullable persistent field */
    private java.math.BigDecimal msubtotal;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentopromocion;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentoempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentomedico;

    /** nullable persistent field */
    private java.math.BigDecimal mfacturaempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mpagopaciente;

    /** nullable persistent field */
    private java.math.BigDecimal miva;

    /** nullable persistent field */
    private short piva;

    /** nullable persistent field */
    private java.math.BigDecimal mtotal;

    /** persistent field */
    private java.math.BigDecimal userId;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.lang.String sobservacion;

    /** persistent field */
    private int cconvenio;

    /** persistent field */
    private java.math.BigDecimal userIdChange;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal;
   
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca;
        
    /** persistent field */
    private Set tordenexamensucursalcotizacions;

    
    
    /** full constructor */
    public TOrdenSucursalCotizacion(java.lang.Integer kordensucursalcotizacion, int kordensucursal, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, java.lang.String ssucursal, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal, mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico, java.lang.String smedico, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuentopromocion, java.math.BigDecimal mdescuentoempresa, java.math.BigDecimal mdescuentomedico, java.math.BigDecimal mfacturaempresa, java.math.BigDecimal mpagopaciente, java.math.BigDecimal miva, short piva, java.math.BigDecimal mtotal, java.math.BigDecimal userId,  mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, java.util.Date dregistro, java.lang.String sobservacion, int cconvenio, java.math.BigDecimal userIdChange, mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente, Set tordenexamensucursalcotizacions) {
        this.kordensucursalcotizacion = kordensucursalcotizacion;
        this.kordensucursal = kordensucursal;
        this.cmarca = cmarca;
        this.ssucursal = ssucursal;
        this.csucursal = csucursal;
        this.cmedico = cmedico;
        this.smedico = smedico;
        this.msubtotal = msubtotal;
        this.mdescuentopromocion = mdescuentopromocion;
        this.mdescuentoempresa = mdescuentoempresa;
        this.mdescuentomedico = mdescuentomedico;
        this.mfacturaempresa = mfacturaempresa;
        this.mpagopaciente = mpagopaciente;
        this.miva = miva;
        this.piva = piva;
        this.mtotal = mtotal;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.dregistro = dregistro;
        this.sobservacion = sobservacion;
        this.cconvenio = cconvenio;
        this.userIdChange = userIdChange;
        this.tpaciente = tpaciente;
        this.tordenexamensucursalcotizacions = tordenexamensucursalcotizacions;
    }

    /** default constructor */
    public TOrdenSucursalCotizacion() {
    }

    /** minimal constructor */
    public TOrdenSucursalCotizacion(java.lang.Integer kordensucursalcotizacion, int kordensucursal, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal, mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico, java.math.BigDecimal userId, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, int cconvenio, java.math.BigDecimal userIdChange, mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente, Set tordenexamensucursalcotizacions) {
        this.kordensucursalcotizacion = kordensucursalcotizacion;
        this.kordensucursal = kordensucursal;
        this.csucursal = csucursal;
        this.cmedico = cmedico;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.cconvenio = cconvenio;
        this.userIdChange = userIdChange;
        this.tpaciente = tpaciente;
        this.tordenexamensucursalcotizacions = tordenexamensucursalcotizacions;
    }

    public java.lang.Integer getKordensucursalcotizacion() {
        return this.kordensucursalcotizacion;
    }

    public void setKordensucursalcotizacion(java.lang.Integer kordensucursalcotizacion) {
        this.kordensucursalcotizacion = kordensucursalcotizacion;
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

    public java.lang.String getSsucursal() {
        return this.ssucursal;
    }

    public void setSsucursal(java.lang.String ssucursal) {
        this.ssucursal = ssucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CSucursal getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal) {
        this.csucursal = csucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.medico.CMedico getCmedico() {
        return this.cmedico;
    }

    public void setCmedico(mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico) {
        this.cmedico = cmedico;
    }

    public java.lang.String getSmedico() {
        return this.smedico;
    }

    public void setSmedico(java.lang.String smedico) {
        this.smedico = smedico;
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

    public java.math.BigDecimal getMdescuentomedico() {
        return this.mdescuentomedico;
    }

    public void setMdescuentomedico(java.math.BigDecimal mdescuentomedico) {
        this.mdescuentomedico = mdescuentomedico;
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

    public short getPiva() {
        return this.piva;
    }

    public void setPiva(short piva) {
        this.piva = piva;
    }

    public java.math.BigDecimal getMtotal() {
        return this.mtotal;
    }

    public void setMtotal(java.math.BigDecimal mtotal) {
        this.mtotal = mtotal;
    }

    public java.math.BigDecimal getUserId() {
        return this.userId;
    }

    public void setUserId(java.math.BigDecimal userId) {
        this.userId = userId;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.lang.String getSobservacion() {
        return this.sobservacion;
    }

    public void setSobservacion(java.lang.String sobservacion) {
        this.sobservacion = sobservacion;
    }

    public int getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(int cconvenio) {
        this.cconvenio = cconvenio;
    }

    public java.math.BigDecimal getUserIdChange() {
        return this.userIdChange;
    }

    public void setUserIdChange(java.math.BigDecimal userIdChange) {
        this.userIdChange = userIdChange;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TPaciente getTpaciente() {
        return this.tpaciente;
    }

    public void setTpaciente(mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente) {
        this.tpaciente = tpaciente;
    }

    public java.util.Set getTordenexamensucursalcotizacions() {
        return this.tordenexamensucursalcotizacions;
    }

    public void setTordenexamensucursalcotizacions(java.util.Set tordenexamensucursalcotizacions) {
        this.tordenexamensucursalcotizacions = tordenexamensucursalcotizacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kordensucursalcotizacion", getKordensucursalcotizacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TOrdenSucursalCotizacion) ) return false;
        TOrdenSucursalCotizacion castOther = (TOrdenSucursalCotizacion) other;
        return new EqualsBuilder()
            .append(this.getKordensucursalcotizacion(), castOther.getKordensucursalcotizacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordensucursalcotizacion())
            .toHashCode();
    }

}
