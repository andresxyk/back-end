package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class IdTable implements Serializable {

    /** identifier field */
    private java.math.BigDecimal idTableId;

    /** persistent field */
    private java.lang.String tableName;

    /** nullable persistent field */
    private java.math.BigDecimal nextId;

    /** nullable persistent field */
    private java.math.BigDecimal quantity;

    /** full constructor */
    public IdTable(java.math.BigDecimal idTableId, java.lang.String tableName, java.math.BigDecimal nextId, java.math.BigDecimal quantity) {
        this.idTableId = idTableId;
        this.tableName = tableName;
        this.nextId = nextId;
        this.quantity = quantity;
    }

    /** default constructor */
    public IdTable() {
    }

    /** minimal constructor */
    public IdTable(java.math.BigDecimal idTableId, java.lang.String tableName) {
        this.idTableId = idTableId;
        this.tableName = tableName;
    }

    public java.math.BigDecimal getIdTableId() {
        return this.idTableId;
    }

    public void setIdTableId(java.math.BigDecimal idTableId) {
        this.idTableId = idTableId;
    }

    public java.lang.String getTableName() {
        return this.tableName;
    }

    public void setTableName(java.lang.String tableName) {
        this.tableName = tableName;
    }

    public java.math.BigDecimal getNextId() {
        return this.nextId;
    }

    public void setNextId(java.math.BigDecimal nextId) {
        this.nextId = nextId;
    }

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("idTableId", getIdTableId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof IdTable) ) return false;
        IdTable castOther = (IdTable) other;
        return new EqualsBuilder()
            .append(this.getIdTableId(), castOther.getIdTableId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getIdTableId())
            .toHashCode();
    }

}
