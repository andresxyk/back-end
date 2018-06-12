package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EConvenio implements Serializable {

    /** identifier field */
    private java.lang.Integer kconvenio;

    /** nullable persistent field */
    private java.util.Date dinicio;

    /** nullable persistent field */
    private java.util.Date dtermino;

    /** nullable persistent field */
    private java.math.BigDecimal pcopago;

    /** nullable persistent field */
    private java.math.BigDecimal mcopago;
    
    /** nullable persistent field */
    private boolean bcopagopaciente;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CVigencia cvigencia;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca;
    
    /** persistent field */
    private Set tfacturaempresas;

    /** persistent field */
    private Set tfacturaempresadetalles;

    /** full constructor */
    public EConvenio(java.lang.Integer kconvenio, java.util.Date dinicio, java.util.Date dtermino, java.math.BigDecimal pcopago, java.math.BigDecimal mcopago, boolean bcopagopaciente, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.CVigencia cvigencia, mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set tfacturaempresas, Set tfacturaempresadetalles) {
        this.kconvenio = kconvenio;
        this.dinicio = dinicio;
        this.dtermino = dtermino;
        this.pcopago = pcopago;
        this.mcopago = mcopago;
        this.bcopagopaciente = bcopagopaciente;
        this.cestadoregistro = cestadoregistro;
        this.cvigencia = cvigencia;
        this.clistacorporativa = clistacorporativa;
        this.cconvenio = cconvenio;
        this.cmarca = cmarca;
        this.tfacturaempresas = tfacturaempresas;
        this.tfacturaempresadetalles = tfacturaempresadetalles;
    }

    /** default constructor */
    public EConvenio() {
    }

    public java.lang.Integer getKconvenio() {
        return this.kconvenio;
    }

    public void setKconvenio(java.lang.Integer kconvenio) {
        this.kconvenio = kconvenio;
    }

    public java.util.Date getDinicio() {
        return this.dinicio;
    }

    public void setDinicio(java.util.Date dinicio) {
        this.dinicio = dinicio;
    }

    public java.util.Date getDtermino() {
        return this.dtermino;
    }

    public void setDtermino(java.util.Date dtermino) {
        this.dtermino = dtermino;
    }
    
    public java.math.BigDecimal getPcopago() {
        return this.pcopago;
    }

    public void setPcopago(java.math.BigDecimal pcopago) {
        this.pcopago = pcopago;
    }

    public java.math.BigDecimal getMcopago() {
        return this.mcopago;
    }

    public void setMcopago(java.math.BigDecimal mcopago) {
        this.mcopago = mcopago;
    }    
    
    public boolean isBcopagopaciente() {
        return this.bcopagopaciente;
    }

    public void setBcopagopaciente(boolean bcopagopaciente) {
        this.bcopagopaciente = bcopagopaciente;
    }
    
    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CVigencia getCvigencia() {
        return this.cvigencia;
    }

    public void setCvigencia(mx.com.web2lab.backend.hbm.om.ap.CVigencia cvigencia) {
        this.cvigencia = cvigencia;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CMarca getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca) {
        this.cmarca = cmarca;
    }
    
    public mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa getClistacorporativa() {
        return this.clistacorporativa;
    }

    public void setClistacorporativa(mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa) {
        this.clistacorporativa = clistacorporativa;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CConvenio getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.cconvenio = cconvenio;
    }

    public java.util.Set getTfacturaempresas() {
        return this.tfacturaempresas;
    }

    public void setTfacturaempresas(java.util.Set tfacturaempresas) {
        this.tfacturaempresas = tfacturaempresas;
    }

    public java.util.Set getTfacturaempresadetalles() {
        return this.tfacturaempresadetalles;
    }

    public void setTfacturaempresadetalles(java.util.Set tfacturaempresadetalles) {
        this.tfacturaempresadetalles = tfacturaempresadetalles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kconvenio", getKconvenio())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EConvenio) ) return false;
        EConvenio castOther = (EConvenio) other;
        return new EqualsBuilder()
            .append(this.getKconvenio(), castOther.getKconvenio())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKconvenio())
            .toHashCode();
    }

}
