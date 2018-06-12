package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CPerfil implements Serializable {

    /** identifier field */
    private java.lang.Integer cperfil;

    /** nullable persistent field */
    private java.lang.String sperfil;
    
    /** nullable persistent field */
    private boolean blistapublico;

    /** persistent field */
//    private int ctipoperfil;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca;

    /** persistent field */
    private Set eperfilexamens;

    /** persistent field */
    private Set tordenexamensucursals;
    
    /** full constructor */
    public CPerfil(java.lang.Integer cperfil, java.lang.String sperfil, boolean blistapublico, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set eperfilexamens, Set tordenexamensucursals) {
        this.cperfil = cperfil;
        this.sperfil = sperfil;
        this.blistapublico = blistapublico;
        this.cmarca = cmarca;
        this.eperfilexamens = eperfilexamens;
        this.tordenexamensucursals = tordenexamensucursals;
    }

    /** default constructor */
    public CPerfil() {
    }

    /** minimal constructor */
    public CPerfil(java.lang.Integer cperfil, boolean blistapublico, mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca, Set eperfilexamens) {
        this.cperfil = cperfil;
        this.blistapublico = blistapublico;
        this.cmarca = cmarca;
        this.eperfilexamens = eperfilexamens;
    }

    public java.lang.Integer getCperfil() {
        return this.cperfil;
    }

    public void setCperfil(java.lang.Integer cperfil) {
        this.cperfil = cperfil;
    }

    public java.lang.String getSperfil() {
        return this.sperfil;
    }

    public void setSperfil(java.lang.String sperfil) {
        this.sperfil = sperfil;
    }

    public boolean isBlistapublico() {
        return this.blistapublico;
    }

    public void setBlistapublico(boolean blistapublico) {
        this.blistapublico = blistapublico;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CMarca getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(mx.com.web2lab.backend.hbm.om.ap.CMarca cmarca) {
        this.cmarca = cmarca;
    }

    public java.util.Set getEperfilexamens() {
        return this.eperfilexamens;
    }

    public void setEperfilexamens(java.util.Set eperfilexamens) {
        this.eperfilexamens = eperfilexamens;
    }

    public java.util.Set getTordenexamensucursals() {
        return this.tordenexamensucursals;
    }

    public void setTordenexamensucursals(java.util.Set tordenexamensucursals) {
        this.tordenexamensucursals = tordenexamensucursals;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("cperfil", getCperfil())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CPerfil) ) return false;
        CPerfil castOther = (CPerfil) other;
        return new EqualsBuilder()
            .append(this.getCperfil(), castOther.getCperfil())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCperfil())
            .toHashCode();
    }

}
