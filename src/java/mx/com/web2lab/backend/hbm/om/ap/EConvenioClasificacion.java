package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EConvenioClasificacion implements Serializable {

    /** identifier field */
    private java.lang.Integer kconvenioclasificaion;

    /** nullable persistent field */
    private java.math.BigDecimal pdescuento;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial cclasificacioncomercial;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio;

    /** full constructor */
    public EConvenioClasificacion(java.lang.Integer kconvenioclasificaion, java.math.BigDecimal pdescuento, mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial cclasificacioncomercial, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.kconvenioclasificaion = kconvenioclasificaion;
        this.pdescuento = pdescuento;
        this.cclasificacioncomercial = cclasificacioncomercial;
        this.cconvenio = cconvenio;
    }

    /** default constructor */
    public EConvenioClasificacion() {
    }

    /** minimal constructor */
    public EConvenioClasificacion(java.lang.Integer kconvenioclasificaion, mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial cclasificacioncomercial, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.kconvenioclasificaion = kconvenioclasificaion;
        this.cclasificacioncomercial = cclasificacioncomercial;
        this.cconvenio = cconvenio;
    }

    public java.lang.Integer getKconvenioclasificaion() {
        return this.kconvenioclasificaion;
    }

    public void setKconvenioclasificaion(java.lang.Integer kconvenioclasificaion) {
        this.kconvenioclasificaion = kconvenioclasificaion;
    }

    public java.math.BigDecimal getPdescuento() {
        return this.pdescuento;
    }

    public void setPdescuento(java.math.BigDecimal pdescuento) {
        this.pdescuento = pdescuento;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial getCclasificacioncomercial() {
        return this.cclasificacioncomercial;
    }

    public void setCclasificacioncomercial(mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial cclasificacioncomercial) {
        this.cclasificacioncomercial = cclasificacioncomercial;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CConvenio getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.cconvenio = cconvenio;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kconvenioclasificaion", getKconvenioclasificaion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EConvenioClasificacion) ) return false;
        EConvenioClasificacion castOther = (EConvenioClasificacion) other;
        return new EqualsBuilder()
            .append(this.getKconvenioclasificaion(), castOther.getKconvenioclasificaion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKconvenioclasificaion())
            .toHashCode();
    }

}
