package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TOrdenSucursal implements Serializable {

    /** identifier field */
    private java.lang.Integer kordensucursal;

    /** nullable persistent field */
    private int uorden;

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
    private java.math.BigDecimal userid;

    /** nullable persistent field */
    private java.util.Date dresultadoentrega;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.util.Date dcierre;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** nullable persistent field */
    private java.lang.String sobservacion;

    /** nullable persistent field */
    private int cconvenio;
    
    /** nullable persistent field */
    private int cordensolicitada;

    /** nullable persistent field */
    private int bautorizacionverresultadosmedico;

    /** persistent field */
    private java.math.BigDecimal useridchange;

    /** nullable persistent field */
    private java.lang.String sentregaresultadosa;

    /** nullable persistent field */
    private java.lang.String spassword;
    
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursalbycsucursalentrega;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursalbycsucursal;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca;

    /** persistent field */
    private Set tordenexamensucursals;

    /** persistent field */
    private Set tpagopacientes;
       
    /** full constructor */
    public TOrdenSucursal(java.lang.Integer kordensucursal, int uorden, java.lang.String ssucursal, java.lang.String smedico, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuentopromocion, java.math.BigDecimal mdescuentoempresa, java.math.BigDecimal mdescuentomedico, java.math.BigDecimal mfacturaempresa, java.math.BigDecimal mpagopaciente, java.math.BigDecimal miva, short piva, java.math.BigDecimal mtotal, java.math.BigDecimal userid, java.util.Date dresultadoentrega, java.util.Date dregistro, java.util.Date dcierre, boolean bregistroactivo, java.lang.String sobservacion,int cconvenio,int cordensolicitada,int bautorizacionverresultadosmedico, String sentregaresultadosa, String spassword, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro , java.math.BigDecimal useridchange , mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursalbycsucursalentrega, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursalbycsucursal, mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set tordenexamensucursals, Set tpagopacientes) {
        this.kordensucursal = kordensucursal;
        this.uorden = uorden;
        this.ssucursal = ssucursal;
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
        this.userid = userid;
        this.useridchange = useridchange;
        this.dresultadoentrega = dresultadoentrega;
        this.dregistro = dregistro;
        this.dcierre = dcierre;
        this.bregistroactivo = bregistroactivo;
        this.sobservacion = sobservacion;
        this.sentregaresultadosa = sentregaresultadosa;
        this.spassword = spassword;
        this.cconvenio = cconvenio;
        this.cordensolicitada = cordensolicitada;
        this.bautorizacionverresultadosmedico = bautorizacionverresultadosmedico;        
        this.cestadoregistro = cestadoregistro;
        this.cmedico = cmedico;
        this.csucursalbycsucursalentrega = csucursalbycsucursalentrega;
        this.csucursalbycsucursal = csucursalbycsucursal;
        this.tpaciente = tpaciente;
        this.cmarca = cmarca;
        this.tordenexamensucursals = tordenexamensucursals;
        this.tpagopacientes = tpagopacientes;
    }

    /** default constructor */
    public TOrdenSucursal() {
    }

    /** minimal constructor */
    public TOrdenSucursal(java.lang.Integer kordensucursal, java.math.BigDecimal userid, java.math.BigDecimal useridchange, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursalbycsucursalentrega, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursalbycsucursal, mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set tordenexamensucursals, Set tpagopacientes) {
        this.kordensucursal = kordensucursal;
        this.userid = userid;
        this.useridchange = useridchange;
        this.cestadoregistro = cestadoregistro;
        this.cmedico = cmedico;
        this.csucursalbycsucursalentrega = csucursalbycsucursalentrega;
        this.csucursalbycsucursal = csucursalbycsucursal;
        this.tpaciente = tpaciente;
        this.cmarca = cmarca;
        this.tordenexamensucursals = tordenexamensucursals;
        this.tpagopacientes = tpagopacientes;
    }

    public java.lang.Integer getKordensucursal() {
        return this.kordensucursal;
    }

    public void setKordensucursal(java.lang.Integer kordensucursal) {
        this.kordensucursal = kordensucursal;
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

    public java.math.BigDecimal getUserid() {
        return this.userid;
    }

    public void setUserid(java.math.BigDecimal userid) {
        this.userid = userid;
    }

    public java.math.BigDecimal getUseridchange() {
        return this.useridchange;
    }

    public void setUseridchange(java.math.BigDecimal useridchange) {
        this.useridchange = useridchange;
    }
    
    public java.util.Date getDresultadoentrega() {
        return this.dresultadoentrega;
    }

    public void setDresultadoentrega(java.util.Date dresultadoentrega) {
        this.dresultadoentrega = dresultadoentrega;
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

    public boolean isBregistroactivo() {
        return this.bregistroactivo;
    }

    public void setBregistroactivo(boolean bregistroactivo) {
        this.bregistroactivo = bregistroactivo;
    }

    public java.lang.String getSpassword() {
        return this.spassword;
    }

    public void setSpassword(java.lang.String spassword) {
        this.spassword = spassword;
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
    
    public int getCordensolicitada() {
        return this.cordensolicitada;
    }

    public void setCordensolicitada(int cordensolicitada) {
        this.cordensolicitada = cordensolicitada;
    }

    public java.lang.String getSentregaresultadosa() {
        return this.sentregaresultadosa;
    }

    public void setSentregaresultadosa(java.lang.String sentregaresultadosa) {
        this.sentregaresultadosa = sentregaresultadosa;
    }

    public int getBautorizacionverresultadosmedico() {
        return this.bautorizacionverresultadosmedico;
    }

    public void setBautorizacionverresultadosmedico(int bautorizacionverresultadosmedico) {
        this.bautorizacionverresultadosmedico = bautorizacionverresultadosmedico;
    }
        
    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.medico.CMedico getCmedico() {
        return this.cmedico;
    }

    public void setCmedico(mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico) {
        this.cmedico = cmedico;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CSucursal getCsucursalbycsucursalentrega() {
        return this.csucursalbycsucursalentrega;
    }

    public void setCsucursalbycsucursalentrega(mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursalbycsucursalentrega) {
        this.csucursalbycsucursalentrega = csucursalbycsucursalentrega;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CSucursal getCsucursalbycsucursal() {
        return this.csucursalbycsucursal;
    }

    public void setCsucursalbycsucursal(mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursalbycsucursal) {
        this.csucursalbycsucursal = csucursalbycsucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TPaciente getTpaciente() {
        return this.tpaciente;
    }

    public void setTpaciente(mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente) {
        this.tpaciente = tpaciente;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CMarca getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca) {
        this.cmarca = cmarca;
    }

    public java.util.Set getTordenexamensucursals() {
        return this.tordenexamensucursals;
    }

    public void setTordenexamensucursals(java.util.Set tordenexamensucursals) {
        this.tordenexamensucursals = tordenexamensucursals;
    }

    public java.util.Set getTpagopacientes() {
        return this.tpagopacientes;
    }

    public void setTpagopacientes(java.util.Set tpagopacientes) {
        this.tpagopacientes = tpagopacientes;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("kordensucursal", getKordensucursal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TOrdenSucursal) ) return false;
        TOrdenSucursal castOther = (TOrdenSucursal) other;
        return new EqualsBuilder()
            .append(this.getKordensucursal(), castOther.getKordensucursal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordensucursal())
            .toHashCode();
    }

}
