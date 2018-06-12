package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbinePermission implements Serializable {

    /** identifier field */
    private java.math.BigDecimal permissionId;

    /** persistent field */
    private java.lang.String permissionName;

    /** persistent field */
    private Set turbineRolePermissions;

    /** full constructor */
    public TurbinePermission(java.math.BigDecimal permissionId, java.lang.String permissionName, Set turbineRolePermissions) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.turbineRolePermissions = turbineRolePermissions;
    }

    /** default constructor */
    public TurbinePermission() {
    }

    public java.math.BigDecimal getPermissionId() {
        return this.permissionId;
    }

    public void setPermissionId(java.math.BigDecimal permissionId) {
        this.permissionId = permissionId;
    }

    public java.lang.String getPermissionName() {
        return this.permissionName;
    }

    public void setPermissionName(java.lang.String permissionName) {
        this.permissionName = permissionName;
    }

    public java.util.Set getTurbineRolePermissions() {
        return this.turbineRolePermissions;
    }

    public void setTurbineRolePermissions(java.util.Set turbineRolePermissions) {
        this.turbineRolePermissions = turbineRolePermissions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("permissionId", getPermissionId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbinePermission) ) return false;
        TurbinePermission castOther = (TurbinePermission) other;
        return new EqualsBuilder()
            .append(this.getPermissionId(), castOther.getPermissionId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPermissionId())
            .toHashCode();
    }

}
