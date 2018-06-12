package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EListaCorporativaDetalle implements Serializable {

    /** identifier field */
    private java.lang.Integer kliscorpdetalle;

    /** nullable persistent field */
    private java.math.BigDecimal mprecio;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** nullable persistent field */
    private java.math.BigDecimal mpreciosiniva;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa;

    /** persistent field */
    private Set elistapublicodetalles;

    /** full constructor */
    public EListaCorporativaDetalle(java.lang.Integer kliscorpdetalle, java.math.BigDecimal mprecio, java.util.Date dregistro, java.math.BigDecimal userid, java.math.BigDecimal mpreciosiniva, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa, Set elistapublicodetalles) {
        this.kliscorpdetalle = kliscorpdetalle;
        this.mprecio = mprecio;
        this.mpreciosiniva = mpreciosiniva;
        this.dregistro = dregistro;
        this.userid = userid;
        this.cexamen = cexamen;
        this.clistacorporativa = clistacorporativa;
        this.elistapublicodetalles = elistapublicodetalles;
    }

    /** default constructor */
    public EListaCorporativaDetalle() {
    }

    /** minimal constructor */
    public EListaCorporativaDetalle(java.lang.Integer kliscorpdetalle, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa, Set elistapublicodetalles) {
        this.kliscorpdetalle = kliscorpdetalle;
        this.userid = userid;
        this.cexamen = cexamen;
        this.clistacorporativa = clistacorporativa;
        this.elistapublicodetalles = elistapublicodetalles;
    }

    public java.lang.Integer getKliscorpdetalle() {
        return this.kliscorpdetalle;
    }

    public void setKliscorpdetalle(java.lang.Integer kliscorpdetalle) {
        this.kliscorpdetalle = kliscorpdetalle;
    }

    public java.math.BigDecimal getMpreciosiniva() {
        return this.mpreciosiniva;
    }

    public void setMpreciosiniva(java.math.BigDecimal mpreciosiniva) {
        this.mpreciosiniva = mpreciosiniva;
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

    public java.math.BigDecimal getMprecio() {
        return this.mprecio;
    }

    public void setMprecio(java.math.BigDecimal mprecio) {
        this.mprecio = mprecio;
    }
    
    public void setUserid(java.math.BigDecimal userid) {
        this.userid = userid;
    }

    public mx.com.web2lab.backend.hbm.om.lis.CExamen getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen) {
        this.cexamen = cexamen;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa getClistacorporativa() {
        return this.clistacorporativa;
    }

    public void setClistacorporativa(mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa clistacorporativa) {
        this.clistacorporativa = clistacorporativa;
    }

    public java.util.Set getElistapublicodetalles() {
        return this.elistapublicodetalles;
    }

    public void setElistapublicodetalles(java.util.Set elistapublicodetalles) {
        this.elistapublicodetalles = elistapublicodetalles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kliscorpdetalle", getKliscorpdetalle())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EListaCorporativaDetalle) ) return false;
        EListaCorporativaDetalle castOther = (EListaCorporativaDetalle) other;
        return new EqualsBuilder()
            .append(this.getKliscorpdetalle(), castOther.getKliscorpdetalle())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKliscorpdetalle())
            .toHashCode();
    }

}
