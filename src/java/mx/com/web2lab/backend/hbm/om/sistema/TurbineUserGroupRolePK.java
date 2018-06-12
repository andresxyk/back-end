package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbineUserGroupRolePK implements Serializable {

    /** identifier field */
    private mx.com.web2lab.backend.hbm.om.sistema.TurbineRole turbineRole;

    /** identifier field */
    private mx.com.web2lab.backend.hbm.om.sistema.TurbineUser turbineUser;

    /** identifier field */
    private mx.com.web2lab.backend.hbm.om.sistema.TurbineGroup turbineGroup;

    /** full constructor */
    public TurbineUserGroupRolePK(mx.com.web2lab.backend.hbm.om.sistema.TurbineRole turbineRole, mx.com.web2lab.backend.hbm.om.sistema.TurbineUser turbineUser, mx.com.web2lab.backend.hbm.om.sistema.TurbineGroup turbineGroup) {
        this.turbineRole = turbineRole;
        this.turbineUser = turbineUser;
        this.turbineGroup = turbineGroup;
    }

    /** default constructor */
    public TurbineUserGroupRolePK() {
    }

    public mx.com.web2lab.backend.hbm.om.sistema.TurbineRole getTurbineRole() {
        return this.turbineRole;
    }

    public void setTurbineRole(mx.com.web2lab.backend.hbm.om.sistema.TurbineRole turbineRole) {
        this.turbineRole = turbineRole;
    }

    public mx.com.web2lab.backend.hbm.om.sistema.TurbineUser getTurbineUser() {
        return this.turbineUser;
    }

    public void setTurbineUser(mx.com.web2lab.backend.hbm.om.sistema.TurbineUser turbineUser) {
        this.turbineUser = turbineUser;
    }

    public mx.com.web2lab.backend.hbm.om.sistema.TurbineGroup getTurbineGroup() {
        return this.turbineGroup;
    }

    public void setTurbineGroup(mx.com.web2lab.backend.hbm.om.sistema.TurbineGroup turbineGroup) {
        this.turbineGroup = turbineGroup;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("turbineRole", getTurbineRole())
            .append("turbineUser", getTurbineUser())
            .append("turbineGroup", getTurbineGroup())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbineUserGroupRolePK) ) return false;
        TurbineUserGroupRolePK castOther = (TurbineUserGroupRolePK) other;
        return new EqualsBuilder()
            .append(this.getTurbineRole(), castOther.getTurbineRole())
            .append(this.getTurbineUser(), castOther.getTurbineUser())
            .append(this.getTurbineGroup(), castOther.getTurbineGroup())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTurbineRole())
            .append(getTurbineUser())
            .append(getTurbineGroup())
            .toHashCode();
    }

}
