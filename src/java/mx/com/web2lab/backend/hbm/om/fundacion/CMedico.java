package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMedico implements Serializable {

    /** identifier field */
    private java.lang.Long cmedico;

    /** persistent field */
    private java.lang.String snombre;

    /** persistent field */
    private java.lang.String sappaterno;

    /** nullable persistent field */
    private java.lang.String sapmaterno;

    /** nullable persistent field */
    private java.util.Date dnacimiento;

    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** nullable persistent field */
    private java.lang.String scolonia;

    /** nullable persistent field */
    private java.lang.String sdelegmuni;

    /** nullable persistent field */
    private int scodigopostal;

    /** nullable persistent field */
    private java.lang.String stelefono;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private int cusuario;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int usexo;

    /** nullable persistent field */
    private java.lang.String scorreoelectro;

    /** nullable persistent field */
    private java.lang.String sciudad;
    
    /** full constructor */
    public CMedico(java.lang.Long cmedico, java.lang.String snombre, java.lang.String sappaterno, java.lang.String sapmaterno, java.util.Date dnacimiento, java.lang.String sdireccion, java.lang.String scolonia, java.lang.String sdelegmuni, int scodigopostal, java.lang.String stelefono, boolean bregistroactivo, int cusuario, java.util.Date dregistro, int usexo, java.lang.String scorreoelectro, java.lang.String sciudad) {
        this.cmedico = cmedico;
        this.snombre = snombre;
        this.sappaterno = sappaterno;
        this.sapmaterno = sapmaterno;
        this.dnacimiento = dnacimiento;
        this.sdireccion = sdireccion;
        this.scolonia = scolonia;
        this.sdelegmuni = sdelegmuni;
        this.scodigopostal = scodigopostal;
        this.stelefono = stelefono;
        this.bregistroactivo = bregistroactivo;
        this.cusuario = cusuario;
        this.dregistro = dregistro;
        this.usexo = usexo;
        this.scorreoelectro = scorreoelectro;
        this.sciudad = sciudad;        
    }

    /** default constructor */
    public CMedico() {
    }

    /** minimal constructor */
    public CMedico(java.lang.Long cmedico, java.lang.String snombre, java.lang.String sappaterno, int cusuario) {
        this.cmedico = cmedico;
        this.snombre = snombre;
        this.sappaterno = sappaterno;
        this.cusuario = cusuario;
    }

    public java.lang.Long getCmedico() {
        return this.cmedico;
    }

    public void setCmedico(java.lang.Long cmedico) {
        this.cmedico = cmedico;
    }

    public java.lang.String getSnombre() {
        return this.snombre;
    }

    public void setSnombre(java.lang.String snombre) {
        this.snombre = snombre;
    }

    public java.lang.String getSappaterno() {
        return this.sappaterno;
    }

    public void setSappaterno(java.lang.String sappaterno) {
        this.sappaterno = sappaterno;
    }

    public java.lang.String getSapmaterno() {
        return this.sapmaterno;
    }

    public void setSapmaterno(java.lang.String sapmaterno) {
        this.sapmaterno = sapmaterno;
    }

    public java.util.Date getDnacimiento() {
        return this.dnacimiento;
    }

    public void setDnacimiento(java.util.Date dnacimiento) {
        this.dnacimiento = dnacimiento;
    }

    public java.lang.String getSdireccion() {
        return this.sdireccion;
    }

    public void setSdireccion(java.lang.String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public java.lang.String getScolonia() {
        return this.scolonia;
    }

    public void setScolonia(java.lang.String scolonia) {
        this.scolonia = scolonia;
    }

    public java.lang.String getSdelegmuni() {
        return this.sdelegmuni;
    }

    public void setSdelegmuni(java.lang.String sdelegmuni) {
        this.sdelegmuni = sdelegmuni;
    }

    public int getScodigopostal() {
        return this.scodigopostal;
    }

    public void setScodigopostal(int scodigopostal) {
        this.scodigopostal = scodigopostal;
    }

    public java.lang.String getStelefono() {
        return this.stelefono;
    }

    public void setStelefono(java.lang.String stelefono) {
        this.stelefono = stelefono;
    }

    public boolean isBregistroactivo() {
        return this.bregistroactivo;
    }

    public void setBregistroactivo(boolean bregistroactivo) {
        this.bregistroactivo = bregistroactivo;
    }

    public int getCusuario() {
        return this.cusuario;
    }

    public void setCusuario(int cusuario) {
        this.cusuario = cusuario;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getUsexo() {
        return this.usexo;
    }

    public void setUsexo(int usexo) {
        this.usexo = usexo;
    }

    public java.lang.String getScorreoelectro() {
        return this.scorreoelectro;
    }

    public void setScorreoelectro(java.lang.String scorreoelectro) {
        this.scorreoelectro = scorreoelectro;
    }

    public java.lang.String getSciudad() {
        return this.sciudad;
    }

    public void setSciudad(java.lang.String sciudad) {
        this.sciudad = sciudad;
    }
        
    public String toString() {
        return new ToStringBuilder(this)
            .append("cmedico", getCmedico())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMedico) ) return false;
        CMedico castOther = (CMedico) other;
        return new EqualsBuilder()
            .append(this.getCmedico(), castOther.getCmedico())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmedico())
            .toHashCode();
    }
}
