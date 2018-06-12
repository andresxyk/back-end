package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbineUser implements Serializable {

    /** identifier field */
    private java.math.BigDecimal userId;

    /** persistent field */
    private java.lang.String loginName;

    /** persistent field */
    private java.lang.String passwordValue;

    /** persistent field */
    private java.lang.String firstName;

    /** persistent field */
    private java.lang.String lastName;

    /** nullable persistent field */
    private java.lang.String email;

    /** nullable persistent field */
    private java.lang.String confirmValue;

    /** nullable persistent field */
    private java.util.Date modified;

    /** nullable persistent field */
    private java.util.Date created;

    /** nullable persistent field */
    private java.util.Date lastLogin;

    /** persistent field */
    private Set turbineUserGroupRoles;

    /** full constructor */
    public TurbineUser(java.math.BigDecimal userId, java.lang.String loginName, java.lang.String passwordValue, java.lang.String firstName, java.lang.String lastName, java.lang.String email, java.lang.String confirmValue, java.util.Date modified, java.util.Date created, java.util.Date lastLogin, Set turbineUserGroupRoles) {
        this.userId = userId;
        this.loginName = loginName;
        this.passwordValue = passwordValue;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.confirmValue = confirmValue;
        this.modified = modified;
        this.created = created;
        this.lastLogin = lastLogin;
        this.turbineUserGroupRoles = turbineUserGroupRoles;
    }

    /** default constructor */
    public TurbineUser() {
    }

    /** minimal constructor */
    public TurbineUser(java.math.BigDecimal userId, java.lang.String loginName, java.lang.String passwordValue, java.lang.String firstName, java.lang.String lastName, Set turbineUserGroupRoles) {
        this.userId = userId;
        this.loginName = loginName;
        this.passwordValue = passwordValue;
        this.firstName = firstName;
        this.lastName = lastName;
        this.turbineUserGroupRoles = turbineUserGroupRoles;
    }

    public java.math.BigDecimal getUserId() {
        return this.userId;
    }

    public void setUserId(java.math.BigDecimal userId) {
        this.userId = userId;
    }

    public java.lang.String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(java.lang.String loginName) {
        this.loginName = loginName;
    }

    public java.lang.String getPasswordValue() {
        return this.passwordValue;
    }

    public void setPasswordValue(java.lang.String passwordValue) {
        this.passwordValue = passwordValue;
    }

    public java.lang.String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return this.lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public java.lang.String getEmail() {
        return this.email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getConfirmValue() {
        return this.confirmValue;
    }

    public void setConfirmValue(java.lang.String confirmValue) {
        this.confirmValue = confirmValue;
    }

    public java.util.Date getModified() {
        return this.modified;
    }

    public void setModified(java.util.Date modified) {
        this.modified = modified;
    }

    public java.util.Date getCreated() {
        return this.created;
    }

    public void setCreated(java.util.Date created) {
        this.created = created;
    }

    public java.util.Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(java.util.Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public java.util.Set getTurbineUserGroupRoles() {
        return this.turbineUserGroupRoles;
    }

    public void setTurbineUserGroupRoles(java.util.Set turbineUserGroupRoles) {
        this.turbineUserGroupRoles = turbineUserGroupRoles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("userId", getUserId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbineUser) ) return false;
        TurbineUser castOther = (TurbineUser) other;
        return new EqualsBuilder()
            .append(this.getUserId(), castOther.getUserId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getUserId())
            .toHashCode();
    }

}
