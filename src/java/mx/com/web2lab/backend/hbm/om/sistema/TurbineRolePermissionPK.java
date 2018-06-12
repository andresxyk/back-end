package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbineRolePermissionPK implements Serializable {

    /** identifier field */
    private mx.com.web2lab.backend.hbm.om.sistema.TurbineRole turbineRole;

    /** identifier field */
    private mx.com.web2lab.backend.hbm.om.sistema.TurbinePermission turbinePermission;

    /** full constructor */
    public TurbineRolePermissionPK(mx.com.web2lab.backend.hbm.om.sistema.TurbineRole turbineRole, mx.com.web2lab.backend.hbm.om.sistema.TurbinePermission turbinePermission) {
        this.turbineRole = turbineRole;
        this.turbinePermission = turbinePermission;
    }

    /** default constructor */
    public TurbineRolePermissionPK() {
    }

    public mx.com.web2lab.backend.hbm.om.sistema.TurbineRole getTurbineRole() {
        return this.turbineRole;
    }

    public void setTurbineRole(mx.com.web2lab.backend.hbm.om.sistema.TurbineRole turbineRole) {
        this.turbineRole = turbineRole;
    }

    public mx.com.web2lab.backend.hbm.om.sistema.TurbinePermission getTurbinePermission() {
        return this.turbinePermission;
    }

    public void setTurbinePermission(mx.com.web2lab.backend.hbm.om.sistema.TurbinePermission turbinePermission) {
        this.turbinePermission = turbinePermission;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("turbineRole", getTurbineRole())
            .append("turbinePermission", getTurbinePermission())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbineRolePermissionPK) ) return false;
        TurbineRolePermissionPK castOther = (TurbineRolePermissionPK) other;
        return new EqualsBuilder()
            .append(this.getTurbineRole(), castOther.getTurbineRole())
            .append(this.getTurbinePermission(), castOther.getTurbinePermission())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTurbineRole())
            .append(getTurbinePermission())
            .toHashCode();
    }

}
