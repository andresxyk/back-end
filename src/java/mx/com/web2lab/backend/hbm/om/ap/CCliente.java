package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CCliente implements Serializable {

    /** identifier field */
    private java.lang.Integer ccliente;

    /** nullable persistent field */
    private java.lang.String srazonsocial;

    /** nullable persistent field */
    private java.lang.String srfc;

    /** nullable persistent field */
    private java.lang.String smnemonico;
    
    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** nullable persistent field */
    private java.lang.String sobservaciones;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int czonaventa;

    /** persistent field */
    private int cmarca;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CTipoCliente ctipocliente;

    /** persistent field */
    private int cgirocliente;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CTipoPersona ctipopersona;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private Set cconvenios;

    /** full constructor */
    public CCliente(java.lang.Integer ccliente, java.lang.String srazonsocial, java.lang.String srfc, java.lang.String sdireccion, java.lang.String sobservaciones, java.math.BigDecimal userid, java.util.Date dregistro, java.lang.String smnemonico, mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, mx.com.web2lab.backend.hbm.om.ap.CTipoCliente ctipocliente, mx.com.web2lab.backend.hbm.om.ap.CTipoPersona ctipopersona, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, int cgirocliente,int czonaventa,int cmarca, Set cconvenios) {
        this.ccliente = ccliente;
        this.srazonsocial = srazonsocial;
        this.srfc = srfc;
        this.sdireccion = sdireccion;
        this.sobservaciones = sobservaciones;
        this.userid = userid;
        this.dregistro = dregistro;
        this.smnemonico = smnemonico;
        this.czonaventa = czonaventa;
        this.cmarca = cmarca;
        this.ccodigopostal = ccodigopostal;
        this.ctipocliente = ctipocliente;
        this.ctipopersona = ctipopersona;
        this.cestadoregistro = cestadoregistro;
        this.cgirocliente = cgirocliente;
        this.cconvenios = cconvenios;
    }

    
    /** default constructor */
    public CCliente() {
    }

    /** minimal constructor */
    public CCliente(java.lang.Integer ccliente, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, mx.com.web2lab.backend.hbm.om.ap.CTipoCliente ctipocliente, mx.com.web2lab.backend.hbm.om.ap.CTipoPersona ctipopersona, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, int cgirocliente,int czonaventa,int cmarca, Set cconvenios) {
        this.ccliente = ccliente;
        this.userid = userid;
        this.ccodigopostal = ccodigopostal;
        this.ctipocliente = ctipocliente;
        this.ctipopersona = ctipopersona;
        this.cestadoregistro = cestadoregistro;
        this.cgirocliente = cgirocliente;
        this.czonaventa = czonaventa;
        this.cmarca = cmarca;
        this.cconvenios = cconvenios;
    }

    public java.lang.Integer getCcliente() {
        return this.ccliente;
    }

    public void setCcliente(java.lang.Integer ccliente) {
        this.ccliente = ccliente;
    }

    public java.lang.String getSrazonsocial() {
        return this.srazonsocial;
    }

    public void setSrazonsocial(java.lang.String srazonsocial) {
        this.srazonsocial = srazonsocial;
    }

    public java.lang.String getSrfc() {
        return this.srfc;
    }

    public void setSrfc(java.lang.String srfc) {
        this.srfc = srfc;
    }

    public java.lang.String getSmnemonico() {
        return this.smnemonico;
    }

    public void setSmnemonico(java.lang.String smnemonico) {
        this.smnemonico = smnemonico;
    }
    
    public java.lang.String getSdireccion() {
        return this.sdireccion;
    }

    public void setSdireccion(java.lang.String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public java.lang.String getSobservaciones() {
        return this.sobservaciones;
    }

    public void setSobservaciones(java.lang.String sobservaciones) {
        this.sobservaciones = sobservaciones;
    }

    public java.math.BigDecimal getUserid() {
        return this.userid;
    }

    public void setUserid(java.math.BigDecimal userid) {
        this.userid = userid;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal getCcodigopostal() {
        return this.ccodigopostal;
    }

    public void setCcodigopostal(mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal) {
        this.ccodigopostal = ccodigopostal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CTipoCliente getCtipocliente() {
        return this.ctipocliente;
    }

    public void setCtipocliente(mx.com.web2lab.backend.hbm.om.ap.CTipoCliente ctipocliente) {
        this.ctipocliente = ctipocliente;
    }

    public int getCgirocliente() {
        return this.cgirocliente;
    }

    public void setCgirocliente(int cgirocliente) {
        this.cgirocliente = cgirocliente;
    }

    public int getCzonaventa() {
        return this.czonaventa;
    }

    public void setCzonaventa(int czonaventa) {
        this.czonaventa = czonaventa;
    }

    public int getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(int cmarca) {
        this.cmarca = cmarca;
    }
    
    public mx.com.web2lab.backend.hbm.om.ap.CTipoPersona getCtipopersona() {
        return this.ctipopersona;
    }

    public void setCtipopersona(mx.com.web2lab.backend.hbm.om.ap.CTipoPersona ctipopersona) {
    	
        this.ctipopersona = ctipopersona;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.util.Set getCconvenios() {
        return this.cconvenios;
    }

    public void setCconvenios(java.util.Set cconvenios) {
        this.cconvenios = cconvenios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccliente", getCcliente())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CCliente) ) return false;
        CCliente castOther = (CCliente) other;
        return new EqualsBuilder()
            .append(this.getCcliente(), castOther.getCcliente())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcliente())
            .toHashCode();
    }

}
