package mx.com.web2lab.backend.hbm.om.catalogos;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CTextoInterpretacion implements Serializable {

    /** identifier field */
    private java.lang.Integer ctextointerpretacion;

    /** nullable persistent field */
    private java.lang.String stextointerpretacion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.catalogos.CTipoTexto ctipotexto;

    /** persistent field */
    private Set ctextoexamens;

    /** persistent field */
    private Set bresultadointerpretacions;

    /** full constructor */
    public CTextoInterpretacion(java.lang.Integer ctextointerpretacion, java.lang.String stextointerpretacion, mx.com.web2lab.backend.hbm.om.catalogos.CTipoTexto ctipotexto, Set ctextoexamens, Set bresultadointerpretacions) {
        this.ctextointerpretacion = ctextointerpretacion;
        this.stextointerpretacion = stextointerpretacion;
        this.ctipotexto = ctipotexto;
        this.ctextoexamens = ctextoexamens;
        this.bresultadointerpretacions = bresultadointerpretacions;
    }

    /** default constructor */
    public CTextoInterpretacion() {
    }

    /** minimal constructor */
    public CTextoInterpretacion(java.lang.Integer ctextointerpretacion, mx.com.web2lab.backend.hbm.om.catalogos.CTipoTexto ctipotexto, Set ctextoexamens, Set bresultadointerpretacions) {
        this.ctextointerpretacion = ctextointerpretacion;
        this.ctipotexto = ctipotexto;
        this.ctextoexamens = ctextoexamens;
        this.bresultadointerpretacions = bresultadointerpretacions;
    }

    public java.lang.Integer getCtextointerpretacion() {
        return this.ctextointerpretacion;
    }

    public void setCtextointerpretacion(java.lang.Integer ctextointerpretacion) {
        this.ctextointerpretacion = ctextointerpretacion;
    }

    public java.lang.String getStextointerpretacion() {
        return this.stextointerpretacion;
    }

    public void setStextointerpretacion(java.lang.String stextointerpretacion) {
        this.stextointerpretacion = stextointerpretacion;
    }

    public mx.com.web2lab.backend.hbm.om.catalogos.CTipoTexto getCtipotexto() {
        return this.ctipotexto;
    }

    public void setCtipotexto(mx.com.web2lab.backend.hbm.om.catalogos.CTipoTexto ctipotexto) {
        this.ctipotexto = ctipotexto;
    }

    public java.util.Set getCtextoexamens() {
        return this.ctextoexamens;
    }

    public void setCtextoexamens(java.util.Set ctextoexamens) {
        this.ctextoexamens = ctextoexamens;
    }

    public java.util.Set getBresultadointerpretacions() {
        return this.bresultadointerpretacions;
    }

    public void setBresultadointerpretacions(java.util.Set bresultadointerpretacions) {
        this.bresultadointerpretacions = bresultadointerpretacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctextointerpretacion", getCtextointerpretacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTextoInterpretacion) ) return false;
        CTextoInterpretacion castOther = (CTextoInterpretacion) other;
        return new EqualsBuilder()
            .append(this.getCtextointerpretacion(), castOther.getCtextointerpretacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtextointerpretacion())
            .toHashCode();
    }

}
