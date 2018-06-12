package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbineCalendar implements Serializable {

    /** identifier field */
    private long kcalendar;

    /** nullable persistent field */
    private long groupId;

    /** nullable persistent field */
    private long roleId;

    /** nullable persistent field */
    private long groupIdNew;

    /** nullable persistent field */
    private long roleIdNew;

    /** nullable persistent field */
    private java.util.Date dfirst;

    /** nullable persistent field */
    private java.util.Date dlast;

    /** nullable persistent field */
    private long cusuariomodi;

    /** nullable persistent field */
    private java.util.Date dmodificacion;

    /** nullable persistent field */
    private int cestado;

    /** nullable persistent field */
    private long userId;

    /** full constructor */
    public TurbineCalendar(long kcalendar, long groupId, long roleId, long groupIdNew, long roleIdNew, java.util.Date dfirst, java.util.Date dlast, long cusuariomodi, java.util.Date dmodificacion, int cestado, long userId) {
        this.kcalendar = kcalendar;
        this.groupId = groupId;
        this.roleId = roleId;
        this.groupIdNew = groupIdNew;
        this.roleIdNew = roleIdNew;
        this.dfirst = dfirst;
        this.dlast = dlast;
        this.cusuariomodi = cusuariomodi;
        this.dmodificacion = dmodificacion;
        this.cestado = cestado;
        this.userId = userId;
    }

    /** default constructor */
    public TurbineCalendar() {
    }

    /** minimal constructor */
    public TurbineCalendar(long kcalendar) {
        this.kcalendar = kcalendar;
    }

    public long getKcalendar() {
        return this.kcalendar;
    }

    public void setKcalendar(long kcalendar) {
        this.kcalendar = kcalendar;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getGroupIdNew() {
        return this.groupIdNew;
    }

    public void setGroupIdNew(long groupIdNew) {
        this.groupIdNew = groupIdNew;
    }

    public long getRoleIdNew() {
        return this.roleIdNew;
    }

    public void setRoleIdNew(long roleIdNew) {
        this.roleIdNew = roleIdNew;
    }

    public java.util.Date getDfirst() {
        return this.dfirst;
    }

    public void setDfirst(java.util.Date dfirst) {
        this.dfirst = dfirst;
    }

    public java.util.Date getDlast() {
        return this.dlast;
    }

    public void setDlast(java.util.Date dlast) {
        this.dlast = dlast;
    }

    public long getCusuariomodi() {
        return this.cusuariomodi;
    }

    public void setCusuariomodi(long cusuariomodi) {
        this.cusuariomodi = cusuariomodi;
    }

    public java.util.Date getDmodificacion() {
        return this.dmodificacion;
    }

    public void setDmodificacion(java.util.Date dmodificacion) {
        this.dmodificacion = dmodificacion;
    }

    public int getCestado() {
        return this.cestado;
    }

    public void setCestado(int cestado) {
        this.cestado = cestado;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kcalendar", getKcalendar())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbineCalendar) ) return false;
        TurbineCalendar castOther = (TurbineCalendar) other;
        return new EqualsBuilder()
            .append(this.getKcalendar(), castOther.getKcalendar())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKcalendar())
            .toHashCode();
    }

}
