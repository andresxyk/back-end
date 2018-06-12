package mx.com.web2lab.backend.hbm.om.ap.medico;

import java.io.Serializable;
import java.util.Set;

import mx.com.web2lab.backend.hbm.om.ap.CEspecialidad;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.CMarca;
import mx.com.web2lab.backend.hbm.om.ap.CSexo;
import mx.com.web2lab.backend.hbm.om.ap.CZonaMedico;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMedico implements Serializable {

    /** identifier field */
    private java.lang.Integer cmedico;

    /** nullable persistent field */
    private int cclave;

    /** nullable persistent field */
    private java.lang.String snombre;

    /** nullable persistent field */
    private java.lang.String sapellidopaterno;

    /** nullable persistent field */
    private java.lang.String sapellidomaterno;

    /** nullable persistent field */
    private java.lang.String srfc;

    /** nullable persistent field */
    private java.lang.String semail;

    /** nullable persistent field */
    private java.util.Date dnacimiento;

    /** nullable persistent field */
    private boolean bregistrado;

    /** nullable persistent field */
    private int cformapagomedico;

    /** nullable persistent field */
    private java.lang.String shorariovisita;

    /** nullable persistent field */
    private java.lang.String scurp;

    /** nullable persistent field */
    private int ucategoriamedico;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CSexo csexo;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CZonaMedico czonamedico;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEspecialidad cespecialidad;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca;

    /** persistent field */
    private Set cdireccionmedicos;

    /** persistent field */
    private Set tordensucursals;
    
    /** persistent field */
    private Set tordensucursalcotizacions;

    /** persistent field */
    private Set emedicopaquetes;

    /** persistent field */
    private Set tregalomedicos;
    
    /** full constructor */
    public CMedico(java.lang.Integer cmedico, int cclave, java.lang.String snombre, java.lang.String sapellidopaterno, java.lang.String sapellidomaterno, java.lang.String srfc, java.lang.String semail, java.util.Date dnacimiento, boolean bregistrado, int cformapagomedico, java.lang.String shorariovisita, java.lang.String scurp, int ucategoriamedico, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.CSexo csexo, mx.com.web2lab.backend.hbm.om.ap.CZonaMedico czonamedico, mx.com.web2lab.backend.hbm.om.ap.CEspecialidad cespecialidad, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set cdireccionmedicos, Set tordensucursals, Set tordensucursalcotizacions, Set emedicopaquetes, Set tregalomedicos) {
        this.cmedico = cmedico;
        this.cclave = cclave;
        this.snombre = snombre;
        this.sapellidopaterno = sapellidopaterno;
        this.sapellidomaterno = sapellidomaterno;
        this.srfc = srfc;
        this.semail = semail;
        this.dnacimiento = dnacimiento;
        this.bregistrado = bregistrado;
        this.cformapagomedico = cformapagomedico;
        this.shorariovisita = shorariovisita;
        this.scurp = scurp;
        this.ucategoriamedico = ucategoriamedico;
        this.cestadoregistro = cestadoregistro;
        this.csexo = csexo;
        this.czonamedico = czonamedico;
        this.cespecialidad = cespecialidad;
        this.cmarca = cmarca;
        this.cdireccionmedicos = cdireccionmedicos;
        this.tordensucursals = tordensucursals;
        this.tordensucursalcotizacions = tordensucursalcotizacions;
        this.emedicopaquetes = emedicopaquetes;
        this.tregalomedicos = tregalomedicos;
    }

    /** default constructor */
    public CMedico() {
    }

    /** minimal constructor */
    public CMedico(java.lang.Integer cmedico, mx.com.web2lab.backend.hbm.om.ap.CSexo csexo, mx.com.web2lab.backend.hbm.om.ap.CZonaMedico czonamedico, mx.com.web2lab.backend.hbm.om.ap.CEspecialidad cespecialidad, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set cdireccionmedicos, Set tordensucursals, Set tordensucursalcotizacions, Set emedicopaquetes, Set tregalomedicos) {
        this.cmedico = cmedico;
        this.csexo = csexo;
        this.czonamedico = czonamedico;
        this.cespecialidad = cespecialidad;
        this.cestadoregistro = cestadoregistro;
        this.cmarca = cmarca;
        this.cdireccionmedicos = cdireccionmedicos;
        this.tordensucursals = tordensucursals;
        this.tordensucursalcotizacions = tordensucursalcotizacions;
        this.emedicopaquetes = emedicopaquetes;
        this.tregalomedicos = tregalomedicos;
    }

    public java.lang.Integer getCmedico() {
        return this.cmedico;
    }

    public void setCmedico(java.lang.Integer cmedico) {
        this.cmedico = cmedico;
    }

    public int getCclave() {
        return this.cclave;
    }

    public void setCclave(int cclave) {
        this.cclave = cclave;
    }

    public java.lang.String getSnombre() {
        return this.snombre;
    }

    public void setSnombre(java.lang.String snombre) {
        this.snombre = snombre;
    }

    public java.lang.String getSapellidopaterno() {
        return this.sapellidopaterno;
    }

    public void setSapellidopaterno(java.lang.String sapellidopaterno) {
        this.sapellidopaterno = sapellidopaterno;
    }

    public java.lang.String getSapellidomaterno() {
        return this.sapellidomaterno;
    }

    public void setSapellidomaterno(java.lang.String sapellidomaterno) {
        this.sapellidomaterno = sapellidomaterno;
    }

    public java.lang.String getSrfc() {
        return this.srfc;
    }

    public void setSrfc(java.lang.String srfc) {
        this.srfc = srfc;
    }

    public java.lang.String getSemail() {
        return this.semail;
    }

    public void setSemail(java.lang.String semail) {
        this.semail = semail;
    }

    public java.util.Date getDnacimiento() {
        return this.dnacimiento;
    }

    public void setDnacimiento(java.util.Date dnacimiento) {
        this.dnacimiento = dnacimiento;
    }

    public boolean isBregistrado() {
        return this.bregistrado;
    }

    public boolean getBregistrado() {
        return this.bregistrado;
    }
    
    public void setBregistrado(boolean bregistrado) {
        this.bregistrado = bregistrado;
    }

    public int getCformapagomedico() {
        return this.cformapagomedico;
    }

    public void setCformapagomedico(int cformapagomedico) {
        this.cformapagomedico = cformapagomedico;
    }
        
    public java.lang.String getShorariovisita() {
        return this.shorariovisita;
    }

    public void setShorariovisita(java.lang.String shorariovisita) {
        this.shorariovisita = shorariovisita;
    }

    public java.lang.String getScurp() {
        return this.scurp;
    }

    public void setScurp(java.lang.String scurp) {
        this.scurp = scurp;
    }

    public int getUcategoriamedico() {
        return this.ucategoriamedico;
    }

    public void setUcategoriamedico(int ucategoriamedico) {
        this.ucategoriamedico = ucategoriamedico;
    }    
    
    public mx.com.web2lab.backend.hbm.om.ap.CSexo getCsexo() {
        return this.csexo;
    }

    public void setCsexo(mx.com.web2lab.backend.hbm.om.ap.CSexo csexo) {
        this.csexo = csexo;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CZonaMedico getCzonamedico() {
        return this.czonamedico;
    }

    public void setCzonamedico(mx.com.web2lab.backend.hbm.om.ap.CZonaMedico czonamedico) {
        this.czonamedico = czonamedico;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEspecialidad getCespecialidad() {
        return this.cespecialidad;
    }

    public void setCespecialidad(mx.com.web2lab.backend.hbm.om.ap.CEspecialidad cespecialidad) {
        this.cespecialidad = cespecialidad;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CMarca getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca) {
        this.cmarca = cmarca;
    }

    public java.util.Set getCdireccionmedicos() {
        return this.cdireccionmedicos;
    }

    public void setCdireccionmedicos(java.util.Set cdireccionmedicos) {
        this.cdireccionmedicos = cdireccionmedicos;
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
    
    public java.util.Set getTregalomedicos() {
        return this.tregalomedicos;
    }

    public void setTregalomedicos(java.util.Set tregalomedicos) {
        this.tregalomedicos = tregalomedicos;
    }    

    public void setTordensucursalcotizacions(java.util.Set tordensucursalcotizacions) {
        this.tordensucursalcotizacions = tordensucursalcotizacions;
    }
    
    public java.util.Set getEmedicopaquetes() {
        return this.emedicopaquetes;
    }

    public void setEmedicopaquetes(java.util.Set emedicopaquetes) {
        this.emedicopaquetes = emedicopaquetes;
    }
    
    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmedico", getCmedico())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMedico) ) return false;
        CMedico castOther = (CMedico) other;
        return new EqualsBuilder()
            .append(this.getCmedico(), castOther.getCmedico())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmedico())
            .toHashCode();
    }

}
