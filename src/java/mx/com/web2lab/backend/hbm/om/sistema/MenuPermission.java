package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MenuPermission implements Serializable {

    /** identifier field */
    private java.math.BigDecimal idMenuPermission;

    /** persistent field */
    private java.math.BigDecimal permissionId;

    /** persistent field */
    private java.math.BigDecimal idGrupoMenu;

    /** nullable persistent field */
    private java.lang.String menuLink;

    /** full constructor */
    public MenuPermission(java.math.BigDecimal idMenuPermission, java.math.BigDecimal permissionId, java.math.BigDecimal idGrupoMenu, java.lang.String menuLink) {
        this.idMenuPermission = idMenuPermission;
        this.permissionId = permissionId;
        this.idGrupoMenu = idGrupoMenu;
        this.menuLink = menuLink;
    }

    /** default constructor */
    public MenuPermission() {
    }

    /** minimal constructor */
    public MenuPermission(java.math.BigDecimal idMenuPermission, java.math.BigDecimal permissionId, java.math.BigDecimal idGrupoMenu) {
        this.idMenuPermission = idMenuPermission;
        this.permissionId = permissionId;
        this.idGrupoMenu = idGrupoMenu;
    }

    public java.math.BigDecimal getIdMenuPermission() {
        return this.idMenuPermission;
    }

    public void setIdMenuPermission(java.math.BigDecimal idMenuPermission) {
        this.idMenuPermission = idMenuPermission;
    }

    public java.math.BigDecimal getPermissionId() {
        return this.permissionId;
    }

    public void setPermissionId(java.math.BigDecimal permissionId) {
        this.permissionId = permissionId;
    }

    public java.math.BigDecimal getIdGrupoMenu() {
        return this.idGrupoMenu;
    }

    public void setIdGrupoMenu(java.math.BigDecimal idGrupoMenu) {
        this.idGrupoMenu = idGrupoMenu;
    }

    public java.lang.String getMenuLink() {
        return this.menuLink;
    }

    public void setMenuLink(java.lang.String menuLink) {
        this.menuLink = menuLink;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("idMenuPermission", getIdMenuPermission())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MenuPermission) ) return false;
        MenuPermission castOther = (MenuPermission) other;
        return new EqualsBuilder()
            .append(this.getIdMenuPermission(), castOther.getIdMenuPermission())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getIdMenuPermission())
            .toHashCode();
    }

}
