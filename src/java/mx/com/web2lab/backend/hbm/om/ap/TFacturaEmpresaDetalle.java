package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TFacturaEmpresaDetalle implements Serializable {

    /** identifier field */
    private java.lang.Integer kfacturaempresadetalle;

    /** nullable persistent field */
    private java.math.BigDecimal mfacturar;

    /** nullable persistent field */
    private java.lang.String sexamencliente;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.EConvenio econvenio;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TFacturaEmpresa tfacturaempresa;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursal tordenexamensucursal;

    /** full constructor */
    public TFacturaEmpresaDetalle(java.lang.Integer kfacturaempresadetalle, java.math.BigDecimal mfacturar, java.lang.String sexamencliente, boolean bregistroactivo, mx.com.web2lab.backend.hbm.om.ap.EConvenio econvenio, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.TFacturaEmpresa tfacturaempresa, mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursal tordenexamensucursal) {
        this.kfacturaempresadetalle = kfacturaempresadetalle;
        this.mfacturar = mfacturar;
        this.sexamencliente = sexamencliente;
        this.bregistroactivo = bregistroactivo;
        this.econvenio = econvenio;
        this.cexamen = cexamen;
        this.cestadoregistro = cestadoregistro;
        this.tfacturaempresa = tfacturaempresa;
        this.tordenexamensucursal = tordenexamensucursal;
    }

    /** default constructor */
    public TFacturaEmpresaDetalle() {
    }

    /** minimal constructor */
    public TFacturaEmpresaDetalle(java.lang.Integer kfacturaempresadetalle, mx.com.web2lab.backend.hbm.om.ap.EConvenio econvenio, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.TFacturaEmpresa tfacturaempresa, mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursal tordenexamensucursal) {
        this.kfacturaempresadetalle = kfacturaempresadetalle;
        this.econvenio = econvenio;
        this.cexamen = cexamen;
        this.cestadoregistro = cestadoregistro;
        this.tfacturaempresa = tfacturaempresa;
        this.tordenexamensucursal = tordenexamensucursal;
    }

    public java.lang.Integer getKfacturaempresadetalle() {
        return this.kfacturaempresadetalle;
    }

    public void setKfacturaempresadetalle(java.lang.Integer kfacturaempresadetalle) {
        this.kfacturaempresadetalle = kfacturaempresadetalle;
    }

    public java.math.BigDecimal getMfacturar() {
        return this.mfacturar;
    }

    public void setMfacturar(java.math.BigDecimal mfacturar) {
        this.mfacturar = mfacturar;
    }

    public java.lang.String getSexamencliente() {
        return this.sexamencliente;
    }

    public void setSexamencliente(java.lang.String sexamencliente) {
        this.sexamencliente = sexamencliente;
    }

    public boolean isBregistroactivo() {
        return this.bregistroactivo;
    }

    public void setBregistroactivo(boolean bregistroactivo) {
        this.bregistroactivo = bregistroactivo;
    }

    public mx.com.web2lab.backend.hbm.om.ap.EConvenio getEconvenio() {
        return this.econvenio;
    }

    public void setEconvenio(mx.com.web2lab.backend.hbm.om.ap.EConvenio econvenio) {
        this.econvenio = econvenio;
    }

    public mx.com.web2lab.backend.hbm.om.lis.CExamen getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen) {
        this.cexamen = cexamen;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TFacturaEmpresa getTfacturaempresa() {
        return this.tfacturaempresa;
    }

    public void setTfacturaempresa(mx.com.web2lab.backend.hbm.om.ap.TFacturaEmpresa tfacturaempresa) {
        this.tfacturaempresa = tfacturaempresa;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursal getTordenexamensucursal() {
        return this.tordenexamensucursal;
    }

    public void setTordenexamensucursal(mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursal tordenexamensucursal) {
        this.tordenexamensucursal = tordenexamensucursal;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kfacturaempresadetalle", getKfacturaempresadetalle())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TFacturaEmpresaDetalle) ) return false;
        TFacturaEmpresaDetalle castOther = (TFacturaEmpresaDetalle) other;
        return new EqualsBuilder()
            .append(this.getKfacturaempresadetalle(), castOther.getKfacturaempresadetalle())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKfacturaempresadetalle())
            .toHashCode();
    }

}
