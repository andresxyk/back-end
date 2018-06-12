package mx.com.web2lab.backend.util.beans.sistema;

import java.io.Serializable;
import java.util.Set;

public class TurbineGroup implements Serializable {

    /** identifier field */
    private java.math.BigDecimal groupId;

    /** persistent field */
    private java.lang.String groupName;

    /** nullable persistent field */
    private java.lang.Object objectdata;

    /** persistent field */
    private Set turbineUserGroupRoles;
    
    /** lab identifier field */
    private Long cLabDepto;
    
	/** default constructor */
    public TurbineGroup() {
    }

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

    public java.lang.Object getObjectdata() {
        return this.objectdata;
    }

    public void setObjectdata(java.lang.Object objectdata) {
        this.objectdata = objectdata;
    }

    public java.util.Set getTurbineUserGroupRoles() {
        return this.turbineUserGroupRoles;
    }

    public void setTurbineUserGroupRoles(java.util.Set turbineUserGroupRoles) {
        this.turbineUserGroupRoles = turbineUserGroupRoles;
    }

	public Long getCLabDepto() {
		return cLabDepto;
	}

	public void setCLabDepto(Long labDepto) {
		cLabDepto = labDepto;
	}

    
}
