package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CIncidenciaFacturacion implements Serializable {

    /** identifier field */
    private int cincidenciafacturacion;

    /** identifier field */
    private java.lang.String sincidenciafacturacion;

    /** identifier field */
    private boolean bincidenciaorden;

    /** identifier field */
    private int uproceso;

    /** persistent field */
    private Set aincidenciafacturacions;

    /** full constructor */
    public CIncidenciaFacturacion(int cincidenciafacturacion, java.lang.String sincidenciafacturacion, boolean bincidenciaorden, int uproceso, Set aincidenciafacturacions) {
        this.cincidenciafacturacion = cincidenciafacturacion;
        this.sincidenciafacturacion = sincidenciafacturacion;
        this.bincidenciaorden = bincidenciaorden;
        this.uproceso = uproceso;
        this.aincidenciafacturacions = aincidenciafacturacions;
    }

    /** default constructor */
    public CIncidenciaFacturacion() {
    }

    public int getCincidenciafacturacion() {
        return this.cincidenciafacturacion;
    }

    public void setCincidenciafacturacion(int cincidenciafacturacion) {
        this.cincidenciafacturacion = cincidenciafacturacion;
    }

    public java.lang.String getSincidenciafacturacion() {
        return this.sincidenciafacturacion;
    }

    public void setSincidenciafacturacion(java.lang.String sincidenciafacturacion) {
        this.sincidenciafacturacion = sincidenciafacturacion;
    }

    public boolean isBincidenciaorden() {
        return this.bincidenciaorden;
    }

    public void setBincidenciaorden(boolean bincidenciaorden) {
        this.bincidenciaorden = bincidenciaorden;
    }

    public int getUproceso() {
        return this.uproceso;
    }

    public void setUproceso(int uproceso) {
        this.uproceso = uproceso;
    }

    public java.util.Set getAincidenciafacturacions() {
        return this.aincidenciafacturacions;
    }

    public void setAincidenciafacturacions(java.util.Set aincidenciafacturacions) {
        this.aincidenciafacturacions = aincidenciafacturacions;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("cincidenciafacturacion", getCincidenciafacturacion())
            .append("sincidenciafacturacion", getSincidenciafacturacion())
            .append("bincidenciaorden", isBincidenciaorden())
            .append("uproceso", getUproceso())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CIncidenciaFacturacion) ) return false;
        CIncidenciaFacturacion castOther = (CIncidenciaFacturacion) other;
        return new EqualsBuilder()
            .append(this.getCincidenciafacturacion(), castOther.getCincidenciafacturacion())
            .append(this.getSincidenciafacturacion(), castOther.getSincidenciafacturacion())
            .append(this.isBincidenciaorden(), castOther.isBincidenciaorden())
            .append(this.getUproceso(), castOther.getUproceso())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCincidenciafacturacion())
            .append(getSincidenciafacturacion())
            .append(isBincidenciaorden())
            .append(getUproceso())
            .toHashCode();
    }

}
