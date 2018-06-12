package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbineRolePermission implements Serializable {

    /** identifier field */
    private mx.com.web2lab.backend.hbm.om.sistema.TurbineRolePermissionPK comp_id;

    /** full constructor */
    public TurbineRolePermission(mx.com.web2lab.backend.hbm.om.sistema.TurbineRolePermissionPK comp_id) {
        this.comp_id = comp_id;
    }

    /** default constructor */
    public TurbineRolePermission() {
    }

    public mx.com.web2lab.backend.hbm.om.sistema.TurbineRolePermissionPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(mx.com.web2lab.backend.hbm.om.sistema.TurbineRolePermissionPK comp_id) {
        this.comp_id = comp_id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbineRolePermission) ) return false;
        TurbineRolePermission castOther = (TurbineRolePermission) other;
        return new EqualsBuilder()
            .append(this.getComp_id(), castOther.getComp_id())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComp_id())
            .toHashCode();
    }

}
