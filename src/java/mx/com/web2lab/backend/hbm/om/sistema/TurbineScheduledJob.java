package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbineScheduledJob implements Serializable {

    /** identifier field */
    private java.math.BigDecimal jobId;

    /** persistent field */
    private java.math.BigDecimal second;

    /** persistent field */
    private java.math.BigDecimal minute;

    /** persistent field */
    private java.math.BigDecimal hour;

    /** persistent field */
    private java.math.BigDecimal weekDay;

    /** persistent field */
    private java.math.BigDecimal dayOfMonth;

    /** persistent field */
    private java.lang.String task;

    /** nullable persistent field */
    private java.lang.String email;

    /** full constructor */
    public TurbineScheduledJob(java.math.BigDecimal jobId, java.math.BigDecimal second, java.math.BigDecimal minute, java.math.BigDecimal hour, java.math.BigDecimal weekDay, java.math.BigDecimal dayOfMonth, java.lang.String task, java.lang.String email) {
        this.jobId = jobId;
        this.second = second;
        this.minute = minute;
        this.hour = hour;
        this.weekDay = weekDay;
        this.dayOfMonth = dayOfMonth;
        this.task = task;
        this.email = email;
    }

    /** default constructor */
    public TurbineScheduledJob() {
    }

    /** minimal constructor */
    public TurbineScheduledJob(java.math.BigDecimal jobId, java.math.BigDecimal second, java.math.BigDecimal minute, java.math.BigDecimal hour, java.math.BigDecimal weekDay, java.math.BigDecimal dayOfMonth, java.lang.String task) {
        this.jobId = jobId;
        this.second = second;
        this.minute = minute;
        this.hour = hour;
        this.weekDay = weekDay;
        this.dayOfMonth = dayOfMonth;
        this.task = task;
    }

    public java.math.BigDecimal getJobId() {
        return this.jobId;
    }

    public void setJobId(java.math.BigDecimal jobId) {
        this.jobId = jobId;
    }

    public java.math.BigDecimal getSecond() {
        return this.second;
    }

    public void setSecond(java.math.BigDecimal second) {
        this.second = second;
    }

    public java.math.BigDecimal getMinute() {
        return this.minute;
    }

    public void setMinute(java.math.BigDecimal minute) {
        this.minute = minute;
    }

    public java.math.BigDecimal getHour() {
        return this.hour;
    }

    public void setHour(java.math.BigDecimal hour) {
        this.hour = hour;
    }

    public java.math.BigDecimal getWeekDay() {
        return this.weekDay;
    }

    public void setWeekDay(java.math.BigDecimal weekDay) {
        this.weekDay = weekDay;
    }

    public java.math.BigDecimal getDayOfMonth() {
        return this.dayOfMonth;
    }

    public void setDayOfMonth(java.math.BigDecimal dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public java.lang.String getTask() {
        return this.task;
    }

    public void setTask(java.lang.String task) {
        this.task = task;
    }

    public java.lang.String getEmail() {
        return this.email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("jobId", getJobId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbineScheduledJob) ) return false;
        TurbineScheduledJob castOther = (TurbineScheduledJob) other;
        return new EqualsBuilder()
            .append(this.getJobId(), castOther.getJobId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getJobId())
            .toHashCode();
    }

}
