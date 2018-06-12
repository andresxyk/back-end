package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EConvenioDetalle implements Serializable {

    /** identifier field */
    private java.lang.Integer kconveniodetalle;

    /** nullable persistent field */
    private java.math.BigDecimal pdescuento;

    /** nullable persistent field */
    private java.math.BigDecimal mpreciofacturarsiniva;

    /** nullable persistent field */
    private java.math.BigDecimal mpreciofacturarconiva;

    /** identifier field */
    private java.lang.Integer ctipodescuento;
    
    /** identifier field */
    private int cestadoregistro;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio;    
    
    /** full constructor */
    public EConvenioDetalle(java.lang.Integer kconveniodetalle, java.math.BigDecimal pdescuento, java.math.BigDecimal mpreciofacturarsiniva, java.math.BigDecimal mpreciofacturarconiva, java.lang.Integer ctipodescuento, int cestadoregistro, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.kconveniodetalle = kconveniodetalle;
        this.pdescuento = pdescuento;
        this.cexamen = cexamen;
        this.mpreciofacturarsiniva = mpreciofacturarsiniva;
        this.mpreciofacturarconiva = mpreciofacturarconiva;
        this.cestadoregistro = cestadoregistro;
        this.cconvenio = cconvenio;
        this.ctipodescuento = ctipodescuento;
    }

    /** default constructor */
    public EConvenioDetalle() {
    }

    /** minimal constructor */
    public EConvenioDetalle(java.lang.Integer kconveniodetalle, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.kconveniodetalle = kconveniodetalle;
        this.cexamen = cexamen;
        this.cconvenio = cconvenio;
    }

    public java.lang.Integer getKconveniodetalle() {
        return this.kconveniodetalle;
    }

    public void setKconveniodetalle(java.lang.Integer kconveniodetalle) {
        this.kconveniodetalle = kconveniodetalle;
    }

    public java.lang.Integer getCtipodescuento() {
        return this.ctipodescuento;
    }

    public void setCtipodescuento(java.lang.Integer ctipodescuento) {
        this.ctipodescuento = ctipodescuento;
    }
    
    public java.math.BigDecimal getPdescuento() {
        return this.pdescuento;
    }

    public void setPdescuento(java.math.BigDecimal pdescuento) {
        this.pdescuento = pdescuento;
    }

    public java.math.BigDecimal getMpreciofacturarsiniva() {
        return this.mpreciofacturarsiniva;
    }

    public void setMpreciofacturarsiniva(java.math.BigDecimal mpreciofacturarsiniva) {
        this.mpreciofacturarsiniva = mpreciofacturarsiniva;
    }

    public java.math.BigDecimal getMpreciofacturarconiva() {
        return this.mpreciofacturarconiva;
    }

    public void setMpreciofacturarconiva(java.math.BigDecimal mpreciofacturarconiva) {
        this.mpreciofacturarconiva = mpreciofacturarconiva;
    }
    
    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }
    
    public mx.com.web2lab.backend.hbm.om.lis.CExamen getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen) {
        this.cexamen = cexamen;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CConvenio getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(mx.com.web2lab.backend.hbm.om.ap.CConvenio cconvenio) {
        this.cconvenio = cconvenio;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kconveniodetalle", getKconveniodetalle())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EConvenioDetalle) ) return false;
        EConvenioDetalle castOther = (EConvenioDetalle) other;
        return new EqualsBuilder()
            .append(this.getKconveniodetalle(), castOther.getKconveniodetalle())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKconveniodetalle())
            .toHashCode();
    }

}
