package mx.com.web2lab.backend.hbm.om.lis;

import java.io.Serializable;
import java.util.Set;

import mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial;
import mx.com.web2lab.backend.hbm.om.ap.CTipoComercial;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CExamen implements Serializable {

    /** identifier field */
    private java.lang.Integer cexamen;

    /** nullable persistent field */
    private java.lang.String sexamen;

    /** nullable persistent field */
    private boolean blistapublico;

    /** persistent field */
    private short uvolumenmaximo;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CTipoComercial ctipocomercial;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial cclasificacioncomercial;
    
    /** persistent field */
    private Set eperfilexamens;

    /** persistent field */
    private Set tordenexamensucursals;

    /** persistent field */
    private Set emedicodetalles;

    /** persistent field */
    private Set elistacorporativadetalles;

    /** persistent field */
    private Set econveniodetalles;

    /** persistent field */
    private Set eexamenlugarprocesamientos;

    /** persistent field */
    private Set tordenexamensucursalfacs;

    /** full constructor */
    public CExamen(java.lang.Integer cexamen, java.lang.String sexamen, boolean blistapublico, short uvolumenmaximo, mx.com.web2lab.backend.hbm.om.ap.CTipoComercial ctipocomercial, mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial cclasificacioncomercial, Set eperfilexamens, Set tordenexamensucursals, Set emedicodetalles, Set elistacorporativadetalles, Set econveniodetalles, Set eexamenlugarprocesamientos, Set tordenexamensucursalfacs) {
        this.cexamen = cexamen;
        this.sexamen = sexamen;
        this.blistapublico = blistapublico;
        this.uvolumenmaximo = uvolumenmaximo;
        this.ctipocomercial = ctipocomercial;
        this.cclasificacioncomercial = cclasificacioncomercial;
        this.eperfilexamens = eperfilexamens;
        this.tordenexamensucursals = tordenexamensucursals;
        this.emedicodetalles = emedicodetalles;
        this.elistacorporativadetalles = elistacorporativadetalles;
        this.econveniodetalles = econveniodetalles;
        this.eexamenlugarprocesamientos = eexamenlugarprocesamientos;
        this.tordenexamensucursalfacs = tordenexamensucursalfacs;
    }    

    /** default constructor */
    public CExamen() {
    }

    /** minimal constructor */
    public CExamen(java.lang.Integer cexamen, boolean blistapublico, mx.com.web2lab.backend.hbm.om.ap.CTipoComercial ctipocomercial, mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial cclasificacioncomercial, Set eperfilexamens, Set tordenexamensucursals, Set emedicodetalles, Set elistacorporativadetalles, Set econveniodetalles, Set eexamenlugarprocesamientos, Set tordenexamensucursalfacs) {
        this.cexamen = cexamen;
        this.blistapublico = blistapublico;
        this.ctipocomercial = ctipocomercial;
        this.cclasificacioncomercial = cclasificacioncomercial;
        this.eperfilexamens = eperfilexamens;
        this.tordenexamensucursals = tordenexamensucursals;
        this.emedicodetalles = emedicodetalles;
        this.elistacorporativadetalles = elistacorporativadetalles;
        this.econveniodetalles = econveniodetalles;
        this.eexamenlugarprocesamientos = eexamenlugarprocesamientos;
        this.tordenexamensucursalfacs = tordenexamensucursalfacs;
    }

    public java.lang.Integer getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(java.lang.Integer cexamen) {
        this.cexamen = cexamen;
    }

    public java.lang.String getSexamen() {
        return this.sexamen;
    }

    public void setSexamen(java.lang.String sexamen) {
        this.sexamen = sexamen;
    }

    public boolean isBlistapublico() {
        return this.blistapublico;
    }

    public void setBlistapublico(boolean blistapublico) {
        this.blistapublico = blistapublico;        
    }
    
    public short getUvolumenmaximo() {
        return this.uvolumenmaximo;
    }

    public void setUvolumenmaximo(short uvolumenmaximo) {
        this.uvolumenmaximo = uvolumenmaximo;
    }
    
    public mx.com.web2lab.backend.hbm.om.ap.CTipoComercial getCtipocomercial() {
        return this.ctipocomercial;
    }

    public void setCtipocomercial(mx.com.web2lab.backend.hbm.om.ap.CTipoComercial ctipocomercial) {
        this.ctipocomercial = ctipocomercial;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial getCclasificacioncomercial() {
        return this.cclasificacioncomercial;
    }

    public void setCclasificacioncomercial(mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial cclasificacioncomercial) {
        this.cclasificacioncomercial = cclasificacioncomercial;
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

    public java.util.Set getEmedicodetalles() {
        return this.emedicodetalles;
    }

    public void setEmedicodetalles(java.util.Set emedicodetalles) {
        this.emedicodetalles = emedicodetalles;
    }

    public java.util.Set getElistacorporativadetalles() {
        return this.elistacorporativadetalles;
    }

    public void setElistacorporativadetalles(java.util.Set elistacorporativadetalles) {
        this.elistacorporativadetalles = elistacorporativadetalles;
    }

    public java.util.Set getEconveniodetalles() {
        return this.econveniodetalles;
    }

    public void setEconveniodetalles(java.util.Set econveniodetalles) {
        this.econveniodetalles = econveniodetalles;
    }

    public java.util.Set getEexamenlugarprocesamientos() {
        return this.eexamenlugarprocesamientos;
    }

    public void setEexamenlugarprocesamientos(java.util.Set eexamenlugarprocesamientos) {
        this.eexamenlugarprocesamientos = eexamenlugarprocesamientos;
    }

    public java.util.Set getTordenexamensucursalfacs() {
        return this.tordenexamensucursalfacs;
    }

    public void setTordenexamensucursalfacs(java.util.Set tordenexamensucursalfacs) {
        this.tordenexamensucursalfacs = tordenexamensucursalfacs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cexamen", getCexamen())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CExamen) ) return false;
        CExamen castOther = (CExamen) other;
        return new EqualsBuilder()
            .append(this.getCexamen(), castOther.getCexamen())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCexamen())
            .toHashCode();
    }

}
