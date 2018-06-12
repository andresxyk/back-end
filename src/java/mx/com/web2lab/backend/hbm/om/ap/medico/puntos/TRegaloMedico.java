package mx.com.web2lab.backend.hbm.om.ap.medico.puntos;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TRegaloMedico implements Serializable {

    /** identifier field */
    private java.lang.Integer kregalomedico;

    /** nullable persistent field */
    private int cclave;

    /** nullable persistent field */
    private int upuntosutilizados;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.util.Date dentregaregalo;

    /** persistent field */
    private int cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.medico.puntos.CRegalo cregalo;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico;

    /** full constructor */
    public TRegaloMedico(java.lang.Integer kregalomedico, int cclave, int upuntosutilizados, java.util.Date dregistro, java.util.Date dentregaregalo, int cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.medico.puntos.CRegalo cregalo, mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico) {
        this.kregalomedico = kregalomedico;
        this.cclave = cclave;
        this.upuntosutilizados = upuntosutilizados;
        this.dregistro = dregistro;
        this.dentregaregalo = dentregaregalo;
        this.cestadoregistro = cestadoregistro;
        this.cregalo = cregalo;
        this.cmedico = cmedico;
    }

    /** default constructor */
    public TRegaloMedico() {
    }

    /** minimal constructor */
    public TRegaloMedico(java.lang.Integer kregalomedico, int cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.medico.puntos.CRegalo cregalo, mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico) {
        this.kregalomedico = kregalomedico;
        this.cestadoregistro = cestadoregistro;
        this.cregalo = cregalo;
        this.cmedico = cmedico;
    }

    public java.lang.Integer getKregalomedico() {
        return this.kregalomedico;
    }

    public void setKregalomedico(java.lang.Integer kregalomedico) {
        this.kregalomedico = kregalomedico;
    }

    public int getCclave() {
        return this.cclave;
    }

    public void setCclave(int cclave) {
        this.cclave = cclave;
    }

    public int getUpuntosutilizados() {
        return this.upuntosutilizados;
    }

    public void setUpuntosutilizados(int upuntosutilizados) {
        this.upuntosutilizados = upuntosutilizados;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.util.Date getDentregaregalo() {
        return this.dentregaregalo;
    }

    public void setDentregaregalo(java.util.Date dentregaregalo) {
        this.dentregaregalo = dentregaregalo;
    }

    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.medico.puntos.CRegalo getCregalo() {
        return this.cregalo;
    }

    public void setCregalo(mx.com.web2lab.backend.hbm.om.ap.medico.puntos.CRegalo cRegalo) {
        this.cregalo = cregalo;
    }

    public mx.com.web2lab.backend.hbm.om.ap.medico.CMedico getCmedico() {
        return this.cmedico;
    }

    public void setCmedico(mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cMedico) {
        this.cmedico = cmedico;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kregalomedico", getKregalomedico())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TRegaloMedico) ) return false;
        TRegaloMedico castOther = (TRegaloMedico) other;
        return new EqualsBuilder()
            .append(this.getKregalomedico(), castOther.getKregalomedico())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKregalomedico())
            .toHashCode();
    }

}
