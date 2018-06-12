package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbineRole implements Serializable {

    /** identifier field */
    private java.math.BigDecimal roleId;

    /** persistent field */
    private java.lang.String roleName;

    /** persistent field */
    private Set turbineRolePermissions;

    /** persistent field */
    private Set turbineUserGroupRoles;

    /** full constructor */
    public TurbineRole(java.math.BigDecimal roleId, java.lang.String roleName, Set turbineRolePermissions, Set turbineUserGroupRoles) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.turbineRolePermissions = turbineRolePermissions;
        this.turbineUserGroupRoles = turbineUserGroupRoles;
    }

    /** default constructor */
    public TurbineRole() {
    }

    public java.math.BigDecimal getRoleId() {
        return this.roleId;
    }

    public void setRoleId(java.math.BigDecimal roleId) {
        this.roleId = roleId;
    }

    public java.lang.String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(java.lang.String roleName) {
        this.roleName = roleName;
    }

    public java.util.Set getTurbineRolePermissions() {
        return this.turbineRolePermissions;
    }

    public void setTurbineRolePermissions(java.util.Set turbineRolePermissions) {
        this.turbineRolePermissions = turbineRolePermissions;
    }

    public java.util.Set getTurbineUserGroupRoles() {
        return this.turbineUserGroupRoles;
    }

    public void setTurbineUserGroupRoles(java.util.Set turbineUserGroupRoles) {
        this.turbineUserGroupRoles = turbineUserGroupRoles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("roleId", getRoleId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbineRole) ) return false;
        TurbineRole castOther = (TurbineRole) other;
        return new EqualsBuilder()
            .append(this.getRoleId(), castOther.getRoleId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRoleId())
            .toHashCode();
    }

}
