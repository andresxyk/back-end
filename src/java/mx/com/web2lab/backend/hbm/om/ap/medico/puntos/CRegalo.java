package mx.com.web2lab.backend.hbm.om.ap.medico.puntos;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CRegalo implements Serializable {

    /** identifier field */
    private java.lang.Integer cregalo;

    /** nullable persistent field */
    private java.lang.String sregalo;

    /** nullable persistent field */
    private int uvalorpuntos;

    /** nullable persistent field */
    private int ucategoriamedico;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int cestadoregistro;

    /** persistent field */
    private Set tregalomedicos;

    /** full constructor */
    public CRegalo(java.lang.Integer cregalo, java.lang.String sregalo, int uvalorpuntos, int ucategoriamedico, java.util.Date dregistro, int cestadoregistro, Set tregalomedicos) {
        this.cregalo = cregalo;
        this.sregalo = sregalo;
        this.uvalorpuntos = uvalorpuntos;
        this.ucategoriamedico = ucategoriamedico;
        this.dregistro = dregistro;
        this.cestadoregistro = cestadoregistro;
        this.tregalomedicos = tregalomedicos;
    }

    /** default constructor */
    public CRegalo() {
    }

    /** minimal constructor */
    public CRegalo(java.lang.Integer cregalo, int cestadoregistro, Set tregalomedicos) {
        this.cregalo = cregalo;
        this.cestadoregistro = cestadoregistro;
        this.tregalomedicos = tregalomedicos;
    }

    public java.lang.Integer getCregalo() {
        return this.cregalo;
    }

    public void setCregalo(java.lang.Integer cregalo) {
        this.cregalo = cregalo;
    }

    public java.lang.String getSregalo() {
        return this.sregalo;
    }

    public void setSregalo(java.lang.String sregalo) {
        this.sregalo = sregalo;
    }

    public int getUvalorpuntos() {
        return this.uvalorpuntos;
    }

    public void setUvalorpuntos(int uvalorpuntos) {
        this.uvalorpuntos = uvalorpuntos;
    }

    public int getUcategoriamedico() {
        return this.ucategoriamedico;
    }

    public void setUcategoriamedico(int ucategoriamedico) {
        this.ucategoriamedico = ucategoriamedico;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.util.Set getTregalomedicos() {
        return this.tregalomedicos;
    }

    public void setTregalomedicos(java.util.Set tregalomedicos) {
        this.tregalomedicos = tregalomedicos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cregalo", getCregalo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CRegalo) ) return false;
        CRegalo castOther = (CRegalo) other;
        return new EqualsBuilder()
            .append(this.getCregalo(), castOther.getCregalo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCregalo())
            .toHashCode();
    }

}
