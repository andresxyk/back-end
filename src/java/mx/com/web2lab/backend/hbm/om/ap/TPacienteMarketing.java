package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TPacienteMarketing implements Serializable {

    /** identifier field */
    private java.lang.Integer kpacientemarketing;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int userId;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CPromocionMarketing cpromocionmarketing;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente;

    /** full constructor */
    public TPacienteMarketing(java.lang.Integer kpacientemarketing, java.util.Date dregistro, int userId, mx.com.web2lab.backend.hbm.om.ap.CPromocionMarketing cpromocionmarketing, mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente) {
        this.kpacientemarketing = kpacientemarketing;
        this.dregistro = dregistro;
        this.userId = userId;
        this.cpromocionmarketing = cpromocionmarketing;
        this.tpaciente = tpaciente;
    }

    /** default constructor */
    public TPacienteMarketing() {
    }

    /** minimal constructor */
    public TPacienteMarketing(java.lang.Integer kpacientemarketing, int userId, mx.com.web2lab.backend.hbm.om.ap.CPromocionMarketing cpromocionmarketing, mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente) {
        this.kpacientemarketing = kpacientemarketing;
        this.userId = userId;
        this.cpromocionmarketing = cpromocionmarketing;
        this.tpaciente = tpaciente;
    }

    public java.lang.Integer getKpacientemarketing() {
        return this.kpacientemarketing;
    }

    public void setKpacientemarketing(java.lang.Integer kpacientemarketing) {
        this.kpacientemarketing = kpacientemarketing;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CPromocionMarketing getCpromocionmarketing() {
        return this.cpromocionmarketing;
    }

    public void setCpromocionmarketing(mx.com.web2lab.backend.hbm.om.ap.CPromocionMarketing cpromocionmarketing) {
        this.cpromocionmarketing = cpromocionmarketing;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TPaciente getTpaciente() {
        return this.tpaciente;
    }

    public void setTpaciente(mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente) {
        this.tpaciente = tpaciente;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kpacientemarketing", getKpacientemarketing())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TPacienteMarketing) ) return false;
        TPacienteMarketing castOther = (TPacienteMarketing) other;
        return new EqualsBuilder()
            .append(this.getKpacientemarketing(), castOther.getKpacientemarketing())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKpacientemarketing())
            .toHashCode();
    }

}
