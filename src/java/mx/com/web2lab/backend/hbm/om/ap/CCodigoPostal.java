package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CCodigoPostal implements Serializable {

    /** identifier field */
    private java.lang.Integer ccodigopostal;

    /** nullable persistent field */
    private java.lang.String cpostal;

    /** nullable persistent field */
    private java.lang.String casentamiento;

    /** nullable persistent field */
    private java.lang.String sestado;

    /** nullable persistent field */
    private java.lang.String sciudad;

    /** nullable persistent field */
    private java.lang.String sdelegacionmunicipio;

    /** nullable persistent field */
    private java.lang.String sasentamiento;

    /** nullable persistent field */
    private java.lang.String scolonia;

    /** nullable persistent field */
    private boolean bregistrosepo;

    /** persistent field */
    private Set cdireccionmedicos;

    /** persistent field */
    private Set csucursals;

    /** persistent field */
    private Set clugarprocesamientos;

    /** persistent field */
    private Set cclientes;

    /** persistent field */
    private Set tpacientes;

    /** full constructor */
    public CCodigoPostal(java.lang.Integer ccodigopostal, java.lang.String cpostal, java.lang.String casentamiento, java.lang.String sestado, java.lang.String sciudad, java.lang.String sdelegacionmunicipio, java.lang.String sasentamiento, java.lang.String scolonia, boolean bregistrosepo, Set cdireccionmedicos, Set csucursals, Set clugarprocesamientos, Set cclientes, Set tpacientes) {
        this.ccodigopostal = ccodigopostal;
        this.cpostal = cpostal;
        this.casentamiento = casentamiento;
        this.sestado = sestado;
        this.sciudad = sciudad;
        this.sdelegacionmunicipio = sdelegacionmunicipio;
        this.sasentamiento = sasentamiento;
        this.scolonia = scolonia;
        this.bregistrosepo = bregistrosepo;
        this.cdireccionmedicos = cdireccionmedicos;
        this.csucursals = csucursals;
        this.clugarprocesamientos = clugarprocesamientos;
        this.cclientes = cclientes;
        this.tpacientes = tpacientes;
    }

    /** default constructor */
    public CCodigoPostal() {
    }

    /** minimal constructor */
    public CCodigoPostal(java.lang.Integer ccodigopostal, Set cdireccionmedicos, Set csucursals, Set clugarprocesamientos, Set cclientes, Set tpacientes) {
        this.ccodigopostal = ccodigopostal;
        this.cdireccionmedicos = cdireccionmedicos;
        this.csucursals = csucursals;
        this.clugarprocesamientos = clugarprocesamientos;
        this.cclientes = cclientes;
        this.tpacientes = tpacientes;
    }

    public java.lang.Integer getCcodigopostal() {
        return this.ccodigopostal;
    }

    public void setCcodigopostal(java.lang.Integer ccodigopostal) {
        this.ccodigopostal = ccodigopostal;
    }

    public java.lang.String getCpostal() {
        return this.cpostal;
    }

    public void setCpostal(java.lang.String cpostal) {
        this.cpostal = cpostal;
    }

    public java.lang.String getCasentamiento() {
        return this.casentamiento;
    }

    public void setCasentamiento(java.lang.String casentamiento) {
        this.casentamiento = casentamiento;
    }

    public java.lang.String getSestado() {
        return this.sestado;
    }

    public void setSestado(java.lang.String sestado) {
        this.sestado = sestado;
    }

    public java.lang.String getSciudad() {
        return this.sciudad;
    }

    public void setSciudad(java.lang.String sciudad) {
        this.sciudad = sciudad;
    }

    public java.lang.String getSdelegacionmunicipio() {
        return this.sdelegacionmunicipio;
    }

    public void setSdelegacionmunicipio(java.lang.String sdelegacionmunicipio) {
        this.sdelegacionmunicipio = sdelegacionmunicipio;
    }

    public java.lang.String getSasentamiento() {
        return this.sasentamiento;
    }

    public void setSasentamiento(java.lang.String sasentamiento) {
        this.sasentamiento = sasentamiento;
    }

    public java.lang.String getScolonia() {
        return this.scolonia;
    }

    public void setScolonia(java.lang.String scolonia) {
        this.scolonia = scolonia;
    }

    public boolean isBregistrosepo() {
        return this.bregistrosepo;
    }

    public void setBregistrosepo(boolean bregistrosepo) {
        this.bregistrosepo = bregistrosepo;
    }

    public java.util.Set getCdireccionmedicos() {
        return this.cdireccionmedicos;
    }

    public void setCdireccionmedicos(java.util.Set cdireccionmedicos) {
        this.cdireccionmedicos = cdireccionmedicos;
    }

    public java.util.Set getCsucursals() {
        return this.csucursals;
    }

    public void setCsucursals(java.util.Set csucursals) {
        this.csucursals = csucursals;
    }

    public java.util.Set getClugarprocesamientos() {
        return this.clugarprocesamientos;
    }

    public void setClugarprocesamientos(java.util.Set clugarprocesamientos) {
        this.clugarprocesamientos = clugarprocesamientos;
    }

    public java.util.Set getCclientes() {
        return this.cclientes;
    }

    public void setCclientes(java.util.Set cclientes) {
        this.cclientes = cclientes;
    }

    public java.util.Set getTpacientes() {
        return this.tpacientes;
    }

    public void setTpacientes(java.util.Set tpacientes) {
        this.tpacientes = tpacientes;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccodigopostal", getCcodigopostal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CCodigoPostal) ) return false;
        CCodigoPostal castOther = (CCodigoPostal) other;
        return new EqualsBuilder()
            .append(this.getCcodigopostal(), castOther.getCcodigopostal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcodigopostal())
            .toHashCode();
    }

}
