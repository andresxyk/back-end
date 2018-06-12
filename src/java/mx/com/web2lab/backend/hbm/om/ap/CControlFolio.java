package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CControlFolio implements Serializable {

    /** identifier field */
    private java.lang.Integer ccontrolfolio;
	
    /** identifier field */
    private java.lang.Integer csucursal;

    /** identifier field */
    private java.lang.Integer ufolioactual;

    /** identifier field */
    private java.lang.Integer naprobacion;
    
    /** identifier field */
    private java.lang.Integer nanoprobacion;

    /** nullable persistent field */
    private java.lang.String sserie;

    /** persistent field */
    private int cestadoregistro;

    /** full constructor */
    public CControlFolio(java.lang.Integer ccontrolfolio, java.lang.Integer csucursal, java.lang.Integer ufolioactual, java.lang.Integer naprobacion, java.lang.Integer nanoprobacion, java.lang.String sserie, int cestadoregistro) {
        this.ccontrolfolio = ccontrolfolio;
        this.csucursal = csucursal;
        this.ufolioactual = ufolioactual;
        this.naprobacion = naprobacion;
        this.nanoprobacion = nanoprobacion;
        this.sserie = sserie;
        this.cestadoregistro = cestadoregistro;
    }

    /** default constructor */
    public CControlFolio() {
    }

    /** minimal constructor */
    public CControlFolio(java.lang.Integer ccontrolfolio, java.lang.Integer csucursal, int cestadoregistro) {
        this.ccontrolfolio = ccontrolfolio;
        this.csucursal = csucursal;
        this.cestadoregistro = cestadoregistro;
    }

    public java.lang.Integer getCcontrolfolio() {
        return this.ccontrolfolio;
    }

    public void setCcontrolfolio(java.lang.Integer ccontrolfolio) {
        this.ccontrolfolio = ccontrolfolio;
    }

    public java.lang.Integer getUfolioactual() {
        return this.ufolioactual;
    }

    public void setUfolioactual(java.lang.Integer ufolioactual) {
        this.ufolioactual = ufolioactual;
    }

    public java.lang.Integer getNaprobacion() {
        return this.naprobacion;
    }

    public void setNaprobacion(java.lang.Integer naprobacion) {
        this.naprobacion = naprobacion;
    }

    public java.lang.Integer getNanoprobacion() {
        return this.nanoprobacion;
    }

    public void setNanoprobacion(java.lang.Integer nanoprobacion) {
        this.nanoprobacion = nanoprobacion;
    }
    
    public java.lang.Integer getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(java.lang.Integer csucursal) {
        this.csucursal = csucursal;
    }

    public java.lang.String getSserie() {
        return this.sserie;
    }

    public void setSserie(java.lang.String sserie) {
        this.sserie = sserie;
    }

    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("ccontrolfolio", getCcontrolfolio())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CControlFolio) ) return false;
        CControlFolio castOther = (CControlFolio) other;
        return new EqualsBuilder()
            .append(this.getCcontrolfolio(), castOther.getCcontrolfolio())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcontrolfolio())
            .toHashCode();
    }

}
