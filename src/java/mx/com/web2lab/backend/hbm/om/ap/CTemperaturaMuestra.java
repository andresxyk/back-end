package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTemperaturaMuestra implements Serializable {

    /** identifier field */
    private java.lang.Integer ctemperaturamuestra;

    /** nullable persistent field */
    private java.lang.String stemperaturamuestra;

    /** full constructor */
    public CTemperaturaMuestra(java.lang.Integer ctemperaturamuestra, java.lang.String stemperaturamuestra) {
        this.ctemperaturamuestra = ctemperaturamuestra;
        this.stemperaturamuestra = stemperaturamuestra;
    }

    /** default constructor */
    public CTemperaturaMuestra() {
    }

    /** minimal constructor */
    public CTemperaturaMuestra(java.lang.Integer ctemperaturamuestra) {
        this.ctemperaturamuestra = ctemperaturamuestra;
    }

    public java.lang.Integer getCtemperaturamuestra() {
        return this.ctemperaturamuestra;
    }

    public void setCtemperaturamuestra(java.lang.Integer ctemperaturamuestra) {
        this.ctemperaturamuestra = ctemperaturamuestra;
    }

    public java.lang.String getStemperaturamuestra() {
        return this.stemperaturamuestra;
    }

    public void setStemperaturamuestra(java.lang.String stemperaturamuestra) {
        this.stemperaturamuestra = stemperaturamuestra;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctemperaturamuestra", getCtemperaturamuestra())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTemperaturaMuestra) ) return false;
        CTemperaturaMuestra castOther = (CTemperaturaMuestra) other;
        return new EqualsBuilder()
            .append(this.getCtemperaturamuestra(), castOther.getCtemperaturamuestra())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtemperaturamuestra())
            .toHashCode();
    }

}
