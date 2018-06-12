package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbineGroup implements Serializable {

    /** identifier field */
    private java.math.BigDecimal groupId;

    /** persistent field */
    private java.lang.String groupName;

    /** nullable persistent field */
//    private mx.com.web2lab.backend.hbm.om.sistema.TurbineGrupoDepartamento turbineGrupoDepartamento;

    /** persistent field */
    private Set turbineUserGroupRoles;
//  mx.com.web2lab.backend.hbm.om.sistema.TurbineGrupoDepartamento turbineGrupoDepartamento,
    
    /** full constructor */
    public TurbineGroup(java.math.BigDecimal groupId, java.lang.String groupName, Set turbineUserGroupRoles) {
        this.groupId = groupId;
        this.groupName = groupName;
//        this.turbineGrupoDepartamento = turbineGrupoDepartamento;
        this.turbineUserGroupRoles = turbineUserGroupRoles;
    }

    /** default constructor */
    public TurbineGroup() {
    }

    
    /** minimal constructor */
    /*
    public TurbineGroup(java.math.BigDecimal groupId, java.lang.String groupName, Set turbineUserGroupRoles) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.turbineUserGroupRoles = turbineUserGroupRoles;
    }
*/
    public java.math.BigDecimal getGroupId() {
        return this.groupId;
    }

    public void setGroupId(java.math.BigDecimal groupId) {
        this.groupId = groupId;
    }

    public java.lang.String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(java.lang.String groupName) {
        this.groupName = groupName;
    }
/*
    public mx.com.web2lab.backend.hbm.om.sistema.TurbineGrupoDepartamento getTurbineGrupoDepartamento() {
        return this.turbineGrupoDepartamento;
    }

    public void setTurbineGrupoDepartamento(mx.com.web2lab.backend.hbm.om.sistema.TurbineGrupoDepartamento turbineGrupoDepartamento) {
        this.turbineGrupoDepartamento = turbineGrupoDepartamento;
    }
*/
    public java.util.Set getTurbineUserGroupRoles() {
        return this.turbineUserGroupRoles;
    }

    public void setTurbineUserGroupRoles(java.util.Set turbineUserGroupRoles) {
        this.turbineUserGroupRoles = turbineUserGroupRoles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("groupId", getGroupId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbineGroup) ) return false;
        TurbineGroup castOther = (TurbineGroup) other;
        return new EqualsBuilder()
            .append(this.getGroupId(), castOther.getGroupId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGroupId())
            .toHashCode();
    }

}
