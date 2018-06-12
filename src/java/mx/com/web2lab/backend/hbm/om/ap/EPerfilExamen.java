package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EPerfilExamen implements Serializable {

    /** identifier field */
    private java.lang.Integer kperfilexamen;

    /** nullable persistent field */
    private java.math.BigDecimal pdescuento;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil;

    /** full constructor */
    public EPerfilExamen(java.lang.Integer kperfilexamen, java.math.BigDecimal pdescuento, java.math.BigDecimal userid, java.util.Date dregistro, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil) {
        this.kperfilexamen = kperfilexamen;
        this.pdescuento = pdescuento;
        this.userid = userid;
        this.dregistro = dregistro;
        this.cexamen = cexamen;
        this.cestadoregistro = cestadoregistro;
        this.cperfil = cperfil;
    }

    /** default constructor */
    public EPerfilExamen() {
    }

    /** minimal constructor */
    public EPerfilExamen(java.lang.Integer kperfilexamen, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil) {
        this.kperfilexamen = kperfilexamen;
        this.userid = userid;
        this.cexamen = cexamen;
        this.cestadoregistro = cestadoregistro;
        this.cperfil = cperfil;
    }

    public java.lang.Integer getKperfilexamen() {
        return this.kperfilexamen;
    }

    public void setKperfilexamen(java.lang.Integer kperfilexamen) {
        this.kperfilexamen = kperfilexamen;
    }

    public java.math.BigDecimal getPdescuento() {
        return this.pdescuento;
    }

    public void setPdescuento(java.math.BigDecimal pdescuento) {
        this.pdescuento = pdescuento;
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

    public mx.com.web2lab.backend.hbm.om.lis.CExamen getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen) {
        this.cexamen = cexamen;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CPerfil getCperfil() {
        return this.cperfil;
    }

    public void setCperfil(mx.com.web2lab.backend.hbm.om.ap.CPerfil cperfil) {
        this.cperfil = cperfil;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kperfilexamen", getKperfilexamen())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EPerfilExamen) ) return false;
        EPerfilExamen castOther = (EPerfilExamen) other;
        return new EqualsBuilder()
            .append(this.getKperfilexamen(), castOther.getKperfilexamen())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKperfilexamen())
            .toHashCode();
    }

}
