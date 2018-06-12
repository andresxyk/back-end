package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class GrupoMenu implements Serializable {

    /** identifier field */
    private java.math.BigDecimal idGrupoMenu;

    /** nullable persistent field */
    private java.lang.String descGrupo;

    /** full constructor */
    public GrupoMenu(java.math.BigDecimal idGrupoMenu, java.lang.String descGrupo) {
        this.idGrupoMenu = idGrupoMenu;
        this.descGrupo = descGrupo;
    }

    /** default constructor */
    public GrupoMenu() {
    }

    /** minimal constructor */
    public GrupoMenu(java.math.BigDecimal idGrupoMenu) {
        this.idGrupoMenu = idGrupoMenu;
    }

    public java.math.BigDecimal getIdGrupoMenu() {
        return this.idGrupoMenu;
    }

    public void setIdGrupoMenu(java.math.BigDecimal idGrupoMenu) {
        this.idGrupoMenu = idGrupoMenu;
    }

    public java.lang.String getDescGrupo() {
        return this.descGrupo;
    }

    public void setDescGrupo(java.lang.String descGrupo) {
        this.descGrupo = descGrupo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("idGrupoMenu", getIdGrupoMenu())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof GrupoMenu) ) return false;
        GrupoMenu castOther = (GrupoMenu) other;
        return new EqualsBuilder()
            .append(this.getIdGrupoMenu(), castOther.getIdGrupoMenu())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getIdGrupoMenu())
            .toHashCode();
    }

}
