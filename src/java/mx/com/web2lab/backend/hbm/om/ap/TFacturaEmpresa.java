package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TFacturaEmpresa implements Serializable {

    /** identifier field */
    private java.lang.Integer kfactura;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int userid;

    /** nullable persistent field */
    private java.math.BigDecimal msubtotal;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentoempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mpagopaciente;

    /** nullable persistent field */
    private java.math.BigDecimal miva;

    /** nullable persistent field */
    private java.math.BigDecimal mtotalfactura;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.EConvenio econvenio;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private Set tfacturaempresadetalles;

    /** full constructor */
    public TFacturaEmpresa(java.lang.Integer kfactura, java.util.Date dregistro, int userid, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuentoempresa, java.math.BigDecimal mpagopaciente, java.math.BigDecimal miva, java.math.BigDecimal mtotalfactura, mx.com.web2lab.backend.hbm.om.ap.EConvenio econvenio, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, Set tfacturaempresadetalles) {
        this.kfactura = kfactura;
        this.dregistro = dregistro;
        this.userid = userid;
        this.msubtotal = msubtotal;
        this.mdescuentoempresa = mdescuentoempresa;
        this.mpagopaciente = mpagopaciente;
        this.miva = miva;
        this.mtotalfactura = mtotalfactura;
        this.econvenio = econvenio;
        this.cestadoregistro = cestadoregistro;
        this.tfacturaempresadetalles = tfacturaempresadetalles;
    }

    /** default constructor */
    public TFacturaEmpresa() {
    }

    /** minimal constructor */
    public TFacturaEmpresa(java.lang.Integer kfactura, int userid, mx.com.web2lab.backend.hbm.om.ap.EConvenio econvenio, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, Set tfacturaempresadetalles) {
        this.kfactura = kfactura;
        this.userid = userid;
        this.econvenio = econvenio;
        this.cestadoregistro = cestadoregistro;
        this.tfacturaempresadetalles = tfacturaempresadetalles;
    }

    public java.lang.Integer getKfactura() {
        return this.kfactura;
    }

    public void setKfactura(java.lang.Integer kfactura) {
        this.kfactura = kfactura;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public java.math.BigDecimal getMsubtotal() {
        return this.msubtotal;
    }

    public void setMsubtotal(java.math.BigDecimal msubtotal) {
        this.msubtotal = msubtotal;
    }

    public java.math.BigDecimal getMdescuentoempresa() {
        return this.mdescuentoempresa;
    }

    public void setMdescuentoempresa(java.math.BigDecimal mdescuentoempresa) {
        this.mdescuentoempresa = mdescuentoempresa;
    }

    public java.math.BigDecimal getMpagopaciente() {
        return this.mpagopaciente;
    }

    public void setMpagopaciente(java.math.BigDecimal mpagopaciente) {
        this.mpagopaciente = mpagopaciente;
    }

    public java.math.BigDecimal getMiva() {
        return this.miva;
    }

    public void setMiva(java.math.BigDecimal miva) {
        this.miva = miva;
    }

    public java.math.BigDecimal getMtotalfactura() {
        return this.mtotalfactura;
    }

    public void setMtotalfactura(java.math.BigDecimal mtotalfactura) {
        this.mtotalfactura = mtotalfactura;
    }

    public mx.com.web2lab.backend.hbm.om.ap.EConvenio getEconvenio() {
        return this.econvenio;
    }

    public void setEconvenio(mx.com.web2lab.backend.hbm.om.ap.EConvenio econvenio) {
        this.econvenio = econvenio;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.util.Set getTfacturaempresadetalles() {
        return this.tfacturaempresadetalles;
    }

    public void setTfacturaempresadetalles(java.util.Set tfacturaempresadetalles) {
        this.tfacturaempresadetalles = tfacturaempresadetalles;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kfactura", getKfactura())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TFacturaEmpresa) ) return false;
        TFacturaEmpresa castOther = (TFacturaEmpresa) other;
        return new EqualsBuilder()
            .append(this.getKfactura(), castOther.getKfactura())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKfactura())
            .toHashCode();
    }

}
