package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TOrdenExamenSucursalCotizacion implements Serializable {

    /** identifier field */
    private java.lang.Integer kordenexamensucursalcotizacion;

    /** persistent field */
    private int cexamen;

    /** nullable persistent field */
    private java.lang.String sexamen;

    /** nullable persistent field */
    private java.math.BigDecimal msubtotal;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentopromocion;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentoempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentomedico;

    /** nullable persistent field */
    private java.math.BigDecimal mfacturaempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mpagopaciente;

    /** nullable persistent field */
    private java.math.BigDecimal miva;

    /** nullable persistent field */
    private java.math.BigDecimal mtotal;

    /** persistent field */
    private java.math.BigDecimal userId;

    /** persistent field */
    private int cestadoregistro;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int cconvenio;

    /** nullable persistent field */
    private java.lang.String smotivocancelacion;

    /** nullable persistent field */
    private int cperfil;

    /** persistent field */
    private short uvolumenexamen;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalCotizacion tordensucursalcotizacion;

    /** full constructor */
    public TOrdenExamenSucursalCotizacion(java.lang.Integer kordenexamensucursalcotizacion, int cexamen, java.lang.String sexamen, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuentopromocion, java.math.BigDecimal mdescuentoempresa, java.math.BigDecimal mdescuentomedico, java.math.BigDecimal mfacturaempresa, java.math.BigDecimal mpagopaciente, java.math.BigDecimal miva, java.math.BigDecimal mtotal, java.math.BigDecimal userId, int cestadoregistro, java.util.Date dregistro, int cconvenio, java.lang.String smotivocancelacion, int cperfil, short uvolumenexamen, mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalCotizacion tordensucursalcotizacion) {
        this.kordenexamensucursalcotizacion = kordenexamensucursalcotizacion;
        this.cexamen = cexamen;
        this.sexamen = sexamen;
        this.msubtotal = msubtotal;
        this.mdescuentopromocion = mdescuentopromocion;
        this.mdescuentoempresa = mdescuentoempresa;
        this.mdescuentomedico = mdescuentomedico;
        this.mfacturaempresa = mfacturaempresa;
        this.mpagopaciente = mpagopaciente;
        this.miva = miva;
        this.mtotal = mtotal;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.dregistro = dregistro;
        this.cconvenio = cconvenio;
        this.smotivocancelacion = smotivocancelacion;
        this.cperfil = cperfil;
        this.uvolumenexamen = uvolumenexamen;
        this.tordensucursalcotizacion = tordensucursalcotizacion;
    }

    /** default constructor */
    public TOrdenExamenSucursalCotizacion() {
    }

    /** minimal constructor */
    public TOrdenExamenSucursalCotizacion(java.lang.Integer kordenexamensucursalcotizacion, int cexamen, java.math.BigDecimal userId, int cestadoregistro, int cconvenio, short uvolumenexamen, mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalCotizacion tordensucursalcotizacion) {
        this.kordenexamensucursalcotizacion = kordenexamensucursalcotizacion;
        this.cexamen = cexamen;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.cconvenio = cconvenio;
        this.uvolumenexamen = uvolumenexamen;
        this.tordensucursalcotizacion = tordensucursalcotizacion;
    }

    public java.lang.Integer getKordenexamensucursalcotizacion() {
        return this.kordenexamensucursalcotizacion;
    }

    public void setKordenexamensucursalcotizacion(java.lang.Integer kordenexamensucursalcotizacion) {
        this.kordenexamensucursalcotizacion = kordenexamensucursalcotizacion;
    }

    public int getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(int cexamen) {
        this.cexamen = cexamen;
    }

    public java.lang.String getSexamen() {
        return this.sexamen;
    }

    public void setSexamen(java.lang.String sexamen) {
        this.sexamen = sexamen;
    }

    public java.math.BigDecimal getMsubtotal() {
        return this.msubtotal;
    }

    public void setMsubtotal(java.math.BigDecimal msubtotal) {
        this.msubtotal = msubtotal;
    }

    public java.math.BigDecimal getMdescuentopromocion() {
        return this.mdescuentopromocion;
    }

    public void setMdescuentopromocion(java.math.BigDecimal mdescuentopromocion) {
        this.mdescuentopromocion = mdescuentopromocion;
    }

    public java.math.BigDecimal getMdescuentoempresa() {
        return this.mdescuentoempresa;
    }

    public void setMdescuentoempresa(java.math.BigDecimal mdescuentoempresa) {
        this.mdescuentoempresa = mdescuentoempresa;
    }

    public java.math.BigDecimal getMdescuentomedico() {
        return this.mdescuentomedico;
    }

    public void setMdescuentomedico(java.math.BigDecimal mdescuentomedico) {
        this.mdescuentomedico = mdescuentomedico;
    }

    public java.math.BigDecimal getMfacturaempresa() {
        return this.mfacturaempresa;
    }

    public void setMfacturaempresa(java.math.BigDecimal mfacturaempresa) {
        this.mfacturaempresa = mfacturaempresa;
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

    public java.math.BigDecimal getMtotal() {
        return this.mtotal;
    }

    public void setMtotal(java.math.BigDecimal mtotal) {
        this.mtotal = mtotal;
    }

    public java.math.BigDecimal getUserId() {
        return this.userId;
    }

    public void setUserId(java.math.BigDecimal userId) {
        this.userId = userId;
    }

    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(int cconvenio) {
        this.cconvenio = cconvenio;
    }

    public java.lang.String getSmotivocancelacion() {
        return this.smotivocancelacion;
    }

    public void setSmotivocancelacion(java.lang.String smotivocancelacion) {
        this.smotivocancelacion = smotivocancelacion;
    }

    public int getCperfil() {
        return this.cperfil;
    }

    public void setCperfil(int cperfil) {
        this.cperfil = cperfil;
    }

    public short getUvolumenexamen() {
        return this.uvolumenexamen;
    }

    public void setUvolumenexamen(short uvolumenexamen) {
        this.uvolumenexamen = uvolumenexamen;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalCotizacion getTordensucursalcotizacion() {
        return this.tordensucursalcotizacion;
    }

    public void setTordensucursalcotizacion(mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalCotizacion tordensucursalcotizacion) {
        this.tordensucursalcotizacion = tordensucursalcotizacion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kordenexamensucursalcotizacion", getKordenexamensucursalcotizacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TOrdenExamenSucursalCotizacion) ) return false;
        TOrdenExamenSucursalCotizacion castOther = (TOrdenExamenSucursalCotizacion) other;
        return new EqualsBuilder()
            .append(this.getKordenexamensucursalcotizacion(), castOther.getKordenexamensucursalcotizacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordenexamensucursalcotizacion())
            .toHashCode();
    }

}
