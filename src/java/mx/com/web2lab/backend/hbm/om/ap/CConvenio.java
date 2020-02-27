package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CConvenio implements Serializable {

    /** identifier field */
    private java.lang.Integer cconvenio;

    /** nullable persistent field */
    private java.lang.String sconvenio;

    /** nullable persistent field */
    private java.util.Date dregistro;
    
    /** persistent field */
    private java.math.BigDecimal useridchange;
    
    /** persistent field */
    private java.math.BigDecimal userid;
    
    /** nullable persistent field */
    private java.lang.String spassword;

    /** nullable persistent field */
    private java.lang.String spasswordconsulta;

    /** nullable persistent field */
    private java.lang.String scorreoelectronico;

    /** nullable persistent field 
    private java.lang.String snemonico; */
    
    /** identifier field */
    private java.lang.Integer cagrupacion;
    
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CTipoConvenio ctipoconvenio;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CCliente ccliente;

    /** persistent field */
    private Set tordenexamensucursals;

    /** persistent field */
    private Set econvenioperfils;
    
    /** persistent field */
    private Set econveniodetalles;

    /** persistent field */
    private Set econvenioclasificacions;

    /** persistent field */
    private Set econvenios;

    /** persistent field */
    private Set cpromocionmarketings;

    /** persistent field */
    private Set tordensucursalfacs;

    /** full constructor */
//    public CConvenio(java.lang.Integer cconvenio, java.lang.String sconvenio, java.util.Date dregistro, java.math.BigDecimal userid,  java.math.BigDecimal useridchange , String spassword, String spasswordconsulta, String scorreoelectronico,String snemonico ,mx.com.web2lab.backend.hbm.om.ap.CTipoConvenio ctipoconvenio, mx.com.web2lab.backend.hbm.om.ap.CCliente ccliente, Set tordenexamensucursals, Set econvenioperfils, Set econveniodetalles, Set econvenioclasificacions, Set econvenios, Set cpromocionmarketings, Set tordensucursalfacs) {
    public CConvenio(java.lang.Integer cconvenio, java.lang.String sconvenio, java.util.Date dregistro, java.math.BigDecimal userid,  java.math.BigDecimal useridchange , String spassword, String spasswordconsulta, String scorreoelectronico, Integer cagrupacion,mx.com.web2lab.backend.hbm.om.ap.CTipoConvenio ctipoconvenio, mx.com.web2lab.backend.hbm.om.ap.CCliente ccliente, Set tordenexamensucursals, Set econvenioperfils, Set econveniodetalles, Set econvenioclasificacions, Set econvenios, Set cpromocionmarketings, Set tordensucursalfacs) {    
        this.cconvenio = cconvenio;
        this.sconvenio = sconvenio;
        this.dregistro = dregistro;
        this.userid = userid;
        this.useridchange = useridchange;
        this.spassword = spassword;
        this.spasswordconsulta = spasswordconsulta;        
//        this.snemonico = snemonico;
        this.scorreoelectronico = scorreoelectronico;
        this.cagrupacion = cagrupacion;
        this.ctipoconvenio = ctipoconvenio;
        this.ccliente = ccliente;
        this.tordenexamensucursals = tordenexamensucursals;
        this.econvenioperfils = econvenioperfils;
        this.econveniodetalles = econveniodetalles;
        this.econvenioclasificacions = econvenioclasificacions;
        this.econvenios = econvenios;
        this.cpromocionmarketings = cpromocionmarketings;
        this.tordensucursalfacs = tordensucursalfacs;
    }

    /** default constructor */
    public CConvenio() {
    }

    /** minimal constructor */
    public CConvenio(java.lang.Integer cconvenio, mx.com.web2lab.backend.hbm.om.ap.CTipoConvenio ctipoconvenio, mx.com.web2lab.backend.hbm.om.ap.CCliente ccliente, Set tordenexamensucursals, Set econvenioperfils, Set econveniodetalles, Set econvenioclasificacions, Set econvenios, Set cpromocionmarketings, Set tordensucursalfacs) {
        this.cconvenio = cconvenio;
        this.ctipoconvenio = ctipoconvenio;
        this.ccliente = ccliente;
        this.tordenexamensucursals = tordenexamensucursals;
        this.econvenioperfils = econvenioperfils;
        this.econveniodetalles = econveniodetalles;
        this.econvenioclasificacions = econvenioclasificacions;
        this.econvenios = econvenios;
        this.cpromocionmarketings = cpromocionmarketings;
        this.tordensucursalfacs = tordensucursalfacs;
    }

    public java.lang.Integer getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(java.lang.Integer cconvenio) {
        this.cconvenio = cconvenio;
    }

    public java.lang.String getSconvenio() {
        return this.sconvenio;
    }

    public void setSconvenio(java.lang.String sconvenio) {
        this.sconvenio = sconvenio;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
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

    public java.lang.String getSpassword() {
        return this.spassword;
    }

    public void setSpassword(java.lang.String spassword) {
        this.spassword = spassword;
    }
    
    public java.lang.String getSpasswordconsulta() {
        return this.spasswordconsulta;
    }

    public void setSpasswordconsulta(java.lang.String spasswordconsulta) {
        this.spasswordconsulta = spasswordconsulta;
    }

//    public java.lang.String getSnemonico() {
//        return this.snemonico;
//    }
//
//    public void setSnemonico(java.lang.String snemonico) {
//        this.snemonico = snemonico;
//    }
    
    public java.lang.String getScorreoelectronico() {
        return this.scorreoelectronico;
    }

    public void setScorreoelectronico(java.lang.String scorreoelectronico) {
        this.scorreoelectronico = scorreoelectronico;
    }
    
    public java.lang.Integer getCagrupacion() {
        return this.cagrupacion;
    }

    public void setCagrupacion(java.lang.Integer cagrupacion) {
        this.cagrupacion = cagrupacion;
    }
    
    public mx.com.web2lab.backend.hbm.om.ap.CTipoConvenio getCtipoconvenio() {
        return this.ctipoconvenio;
    }

    public void setCtipoconvenio(mx.com.web2lab.backend.hbm.om.ap.CTipoConvenio ctipoconvenio) {
        this.ctipoconvenio = ctipoconvenio;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CCliente getCcliente() {
        return this.ccliente;
    }

    public void setCcliente(mx.com.web2lab.backend.hbm.om.ap.CCliente ccliente) {
        this.ccliente = ccliente;
    }

    public java.util.Set getTordenexamensucursals() {
        return this.tordenexamensucursals;
    }

    public void setTordenexamensucursals(java.util.Set tordenexamensucursals) {
        this.tordenexamensucursals = tordenexamensucursals;
    }

    public java.util.Set getEconvenioperfils() {
        return this.econvenioperfils;
    }

    public void setEconvenioperfils(java.util.Set econvenioperfils) {
        this.econvenioperfils = econvenioperfils;
    }

    public java.util.Set getEconveniodetalles() {
        return this.econveniodetalles;
    }

    public void setEconveniodetalles(java.util.Set econveniodetalles) {
        this.econveniodetalles = econveniodetalles;
    }

    public java.util.Set getEconvenioclasificacions() {
        return this.econvenioclasificacions;
    }

    public void setEconvenioclasificacions(java.util.Set econvenioclasificacions) {
        this.econvenioclasificacions = econvenioclasificacions;
    }

    public java.util.Set getEconvenios() {
        return this.econvenios;
    }

    public void setEconvenios(java.util.Set econvenios) {
        this.econvenios = econvenios;
    }

    public java.util.Set getCpromocionmarketings() {
        return this.cpromocionmarketings;
    }

    public void setCpromocionmarketings(java.util.Set cpromocionmarketings) {
        this.cpromocionmarketings = cpromocionmarketings;
    }    

    public java.util.Set getTordensucursalfacs() {
        return this.tordensucursalfacs;
    }

    public void setTordensucursalfacs(java.util.Set tordensucursalfacs) {
        this.tordensucursalfacs = tordensucursalfacs;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("cconvenio", getCconvenio())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CConvenio) ) return false;
        CConvenio castOther = (CConvenio) other;
        return new EqualsBuilder()
            .append(this.getCconvenio(), castOther.getCconvenio())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCconvenio())
            .toHashCode();
    }

}
