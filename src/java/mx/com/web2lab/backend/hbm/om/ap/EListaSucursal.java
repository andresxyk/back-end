package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EListaSucursal implements Serializable {

    /** identifier field */
    private java.lang.Integer klistasucursal;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private java.math.BigDecimal userid;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CListaPublico clistapublico;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal;

    /** full constructor */
    public EListaSucursal(java.lang.Integer klistasucursal, java.util.Date dregistro, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CListaPublico clistapublico, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal) {
        this.klistasucursal = klistasucursal;
        this.dregistro = dregistro;
        this.userid = userid;
        this.clistapublico = clistapublico;
        this.csucursal = csucursal;
    }

    /** default constructor */
    public EListaSucursal() {
    }

    /** minimal constructor */
    public EListaSucursal(java.lang.Integer klistasucursal, java.math.BigDecimal userid, mx.com.web2lab.backend.hbm.om.ap.CListaPublico clistapublico, mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal) {
        this.klistasucursal = klistasucursal;
        this.userid = userid;
        this.clistapublico = clistapublico;
        this.csucursal = csucursal;    }

    public java.lang.Integer getKlistasucursal() {
        return this.klistasucursal;
    }

    public void setKlistasucursal(java.lang.Integer klistasucursal) {
        this.klistasucursal = klistasucursal;
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

    public mx.com.web2lab.backend.hbm.om.ap.CListaPublico getClistapublico() {
        return this.clistapublico;
    }

    public void setClistapublico(mx.com.web2lab.backend.hbm.om.ap.CListaPublico clistapublico) {
        this.clistapublico = clistapublico;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CSucursal getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(mx.com.web2lab.backend.hbm.om.ap.CSucursal csucursal) {
        this.csucursal = csucursal;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("klistasucursal", getKlistasucursal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EListaSucursal) ) return false;
        EListaSucursal castOther = (EListaSucursal) other;
        return new EqualsBuilder()
            .append(this.getKlistasucursal(), castOther.getKlistasucursal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKlistasucursal())
            .toHashCode();
    }

}
