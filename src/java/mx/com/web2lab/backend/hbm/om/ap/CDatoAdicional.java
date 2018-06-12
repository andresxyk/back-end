package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CDatoAdicional implements Serializable {

    /** identifier field */
    private java.lang.Integer cdatoadicional;

    /** nullable persistent field */
    private java.lang.Integer cconvenio;

    /** nullable persistent field */
    private java.lang.String stipodatoadicional;

    /** nullable persistent field */
    private java.lang.String sdatoadicional;

    /** nullable persistent field */
    private java.lang.String sniveldatoadicional;

    /** persistent field */
    private boolean bobligatorio;

    /** persistent field */
    private Set tDatoAdicionals;

    /** full constructor */
    public CDatoAdicional(java.lang.Integer cdatoadicional,java.lang.Integer cconvenio, java.lang.String stipodatoadicional, java.lang.String sdatoadicional, java.lang.String sniveldatoadicional, boolean bobligatorio, Set tDatoAdicionals) {
        this.cdatoadicional = cdatoadicional;
        this.cconvenio = cconvenio;
        this.stipodatoadicional = stipodatoadicional;
        this.sdatoadicional = sdatoadicional;
        this.sniveldatoadicional = sniveldatoadicional;
        this.bobligatorio = bobligatorio;
        this.tDatoAdicionals = tDatoAdicionals;
    }

    /** default constructor */
    public CDatoAdicional() {
    }

    /** minimal constructor */
    public CDatoAdicional(java.lang.Integer cdatoadicional, boolean bobligatorio, Set tDatoAdicionals) {
        this.cdatoadicional = cdatoadicional;
        this.bobligatorio = bobligatorio;
        this.tDatoAdicionals = tDatoAdicionals;
    }

    public java.lang.Integer getCdatoadicional() {
        return this.cdatoadicional;
    }

    public void setCdatoadicional(java.lang.Integer cdatoadicional) {
        this.cdatoadicional = cdatoadicional;
    }

    public  java.lang.Integer getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio( java.lang.Integer cconvenio) {
        this.cconvenio = cconvenio;
    }

    public java.lang.String getStipodatoadicional() {
        return this.stipodatoadicional;
    }

    public void setStipodatoadicional(java.lang.String stipodatoadicional) {
        this.stipodatoadicional = stipodatoadicional;
    }

    public java.lang.String getSdatoadicional() {
        return this.sdatoadicional;
    }

    public void setSdatoadicional(java.lang.String sdatoadicional) {
        this.sdatoadicional = sdatoadicional;
    }

    public java.lang.String getSniveldatoadicional() {
        return this.sniveldatoadicional;
    }

    public void setSniveldatoadicional(java.lang.String sniveldatoadicional) {
        this.sniveldatoadicional = sniveldatoadicional;
    }

    public boolean isBobligatorio() {
        return this.bobligatorio;
    }

    public void setBobligatorio(boolean bobligatorio) {
        this.bobligatorio = bobligatorio;
    }

    public java.util.Set getTDatoAdicionals() {
        return this.tDatoAdicionals;
    }

    public void setTDatoAdicionals(java.util.Set tDatoAdicionals) {
        this.tDatoAdicionals = tDatoAdicionals;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cdatoadicional", getCdatoadicional())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CDatoAdicional) ) return false;
        CDatoAdicional castOther = (CDatoAdicional) other;
        return new EqualsBuilder()
            .append(this.getCdatoadicional(), castOther.getCdatoadicional())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCdatoadicional())
            .toHashCode();
    }

}
