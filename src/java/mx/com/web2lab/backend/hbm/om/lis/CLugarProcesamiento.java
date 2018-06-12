package mx.com.web2lab.backend.hbm.om.lis;

import java.io.Serializable;
import java.util.Set;

import mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CLugarProcesamiento implements Serializable {

    /** identifier field */
    private java.lang.Integer clugarprocesamiento;

    /** nullable persistent field */
    private java.lang.String slugarprocesamiento;

    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** nullable persistent field */
    private boolean blaboratorio;

    /** nullable persistent field */
    private boolean bgabinetes;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal;

    /** persistent field */
    private Set tordenexamensucursals;

    /** persistent field */
    private Set eexamenlugarprocesamientos;

    /** full constructor */
    public CLugarProcesamiento(java.lang.Integer clugarprocesamiento, java.lang.String slugarprocesamiento, java.lang.String sdireccion, boolean blaboratorio, boolean bgabinetes, mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, Set tordenexamensucursals, Set eexamenlugarprocesamientos) {
        this.clugarprocesamiento = clugarprocesamiento;
        this.slugarprocesamiento = slugarprocesamiento;
        this.sdireccion = sdireccion;
        this.blaboratorio = blaboratorio;
        this.bgabinetes = bgabinetes;
        this.ccodigopostal = ccodigopostal;
        this.tordenexamensucursals = tordenexamensucursals;
        this.eexamenlugarprocesamientos = eexamenlugarprocesamientos;
    }

    /** default constructor */
    public CLugarProcesamiento() {
    }

    /** minimal constructor */
    public CLugarProcesamiento(java.lang.Integer clugarprocesamiento, mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, Set tordenexamensucursals, Set eexamenlugarprocesamientos) {
        this.clugarprocesamiento = clugarprocesamiento;
        this.ccodigopostal = ccodigopostal;
        this.tordenexamensucursals = tordenexamensucursals;
        this.eexamenlugarprocesamientos = eexamenlugarprocesamientos;
    }

    public java.lang.Integer getClugarprocesamiento() {
        return this.clugarprocesamiento;
    }

    public void setClugarprocesamiento(java.lang.Integer clugarprocesamiento) {
        this.clugarprocesamiento = clugarprocesamiento;
    }

    public java.lang.String getSlugarprocesamiento() {
        return this.slugarprocesamiento;
    }

    public void setSlugarprocesamiento(java.lang.String slugarprocesamiento) {
        this.slugarprocesamiento = slugarprocesamiento;
    }

    public java.lang.String getSdireccion() {
        return this.sdireccion;
    }

    public void setSdireccion(java.lang.String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public boolean isBlaboratorio() {
        return this.blaboratorio;
    }

    public void setBlaboratorio(boolean blaboratorio) {
        this.blaboratorio = blaboratorio;
    }

    public boolean isBgabinetes() {
        return this.bgabinetes;
    }

    public void setBgabinetes(boolean bgabinetes) {
        this.bgabinetes = bgabinetes;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal getCcodigopostal() {
        return this.ccodigopostal;
    }

    public void setCcodigopostal(mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal) {
        this.ccodigopostal = ccodigopostal;
    }

    public java.util.Set getTordenexamensucursals() {
        return this.tordenexamensucursals;
    }

    public void setTordenexamensucursals(java.util.Set tordenexamensucursals) {
        this.tordenexamensucursals = tordenexamensucursals;
    }

    public java.util.Set getEexamenlugarprocesamientos() {
        return this.eexamenlugarprocesamientos;
    }

    public void setEexamenlugarprocesamientos(java.util.Set eexamenlugarprocesamientos) {
        this.eexamenlugarprocesamientos = eexamenlugarprocesamientos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("clugarprocesamiento", getClugarprocesamiento())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CLugarProcesamiento) ) return false;
        CLugarProcesamiento castOther = (CLugarProcesamiento) other;
        return new EqualsBuilder()
            .append(this.getClugarprocesamiento(), castOther.getClugarprocesamiento())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getClugarprocesamiento())
            .toHashCode();
    }

}
