package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TOrdenExamenSucursalFac implements Serializable {

    /** identifier field */
    private java.lang.Integer kordenexamenfac;

    /** persistent field */
    private int kordenexamensucursal;

    /** nullable persistent field */
    private java.lang.String sexamen;

    /** nullable persistent field */
    private int cperfil;

    /** nullable persistent field */
    private java.lang.String sperfil;

    /** persistent field */
    private java.math.BigDecimal msubtotal;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentopromocion;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentoempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuentomedico;

    /** persistent field */
    private java.math.BigDecimal mfacturaempresa;

    /** nullable persistent field */
    private java.math.BigDecimal mpagopaciente;

    /** nullable persistent field */
    private java.math.BigDecimal miva;

    /** persistent field */
    private int userId;

    /** persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.util.Date dcancelacionfactura;

    /** nullable persistent field */
    private int userIdChange;

    /** persistent field */
    private short uvolumenexamen;
    
    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac tordensucursalfac; 

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura; 

    /** persistent field */
    private int kordensucursal; 

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro; 

    /** full constructor */
    public TOrdenExamenSucursalFac(java.lang.Integer kordenexamenfac, int kordenexamensucursal, java.lang.String sexamen, int cperfil, java.lang.String sperfil, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuentopromocion, java.math.BigDecimal mdescuentoempresa, java.math.BigDecimal mdescuentomedico, java.math.BigDecimal mfacturaempresa, java.math.BigDecimal mpagopaciente, java.math.BigDecimal miva, int userId, java.util.Date dregistro, java.util.Date dcancelacionfactura, int userIdChange, short uvolumenexamen, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac tordensucursalfac, mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura, int kordensucursal, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.kordenexamenfac = kordenexamenfac;
        this.kordenexamensucursal = kordenexamensucursal;
        this.sexamen = sexamen;
        this.cperfil = cperfil;
        this.sperfil = sperfil;
        this.msubtotal = msubtotal;
        this.mdescuentopromocion = mdescuentopromocion;
        this.mdescuentoempresa = mdescuentoempresa;
        this.mdescuentomedico = mdescuentomedico;
        this.mfacturaempresa = mfacturaempresa;
        this.mpagopaciente = mpagopaciente;
        this.miva = miva;
        this.userId = userId;
        this.dregistro = dregistro;
        this.dcancelacionfactura = dcancelacionfactura;
        this.userIdChange = userIdChange;
        this.uvolumenexamen = uvolumenexamen;
        this.cexamen = cexamen;
        this.tordensucursalfac = tordensucursalfac;
        this.tfactura = tfactura;
        this.kordensucursal = kordensucursal;
        this.cestadoregistro = cestadoregistro;
    }

    /** default constructor */
    public TOrdenExamenSucursalFac() {
    }

    /** minimal constructor */
    public TOrdenExamenSucursalFac(java.lang.Integer kordenexamenfac, int kordenexamensucursal, java.math.BigDecimal msubtotal, java.math.BigDecimal mfacturaempresa, int userId, java.util.Date dregistro, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac tordensucursalfac, mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura, int kordensucursal, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.kordenexamenfac = kordenexamenfac;
        this.kordenexamensucursal = kordenexamensucursal;
        this.msubtotal = msubtotal;
        this.mfacturaempresa = mfacturaempresa;
        this.userId = userId;
        this.dregistro = dregistro;
        this.cexamen = cexamen;
        this.tordensucursalfac = tordensucursalfac;
        this.tfactura = tfactura;
        this.kordensucursal = kordensucursal;
        this.cestadoregistro = cestadoregistro;
    }

    public java.lang.Integer getKordenexamenfac() {
        return this.kordenexamenfac;
    }

    public void setKordenexamenfac(java.lang.Integer kordenexamenfac) {
        this.kordenexamenfac = kordenexamenfac;
    }

    public int getKordenexamensucursal() {
        return this.kordenexamensucursal;
    }

    public void setKordenexamensucursal(int kordenexamensucursal) {
        this.kordenexamensucursal = kordenexamensucursal;
    }

    public java.lang.String getSexamen() {
        return this.sexamen;
    }

    public void setSexamen(java.lang.String sexamen) {
        this.sexamen = sexamen;
    }

    public int getCperfil() {
        return this.cperfil;
    }

    public void setCperfil(int cperfil) {
        this.cperfil = cperfil;
    }

    public java.lang.String getSperfil() {
        return this.sperfil;
    }

    public void setSperfil(java.lang.String sperfil) {
        this.sperfil = sperfil;
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

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.util.Date getDcancelacionfactura() {
        return this.dcancelacionfactura;
    }

    public void setDcancelacionfactura(java.util.Date dcancelacionfactura) {
        this.dcancelacionfactura = dcancelacionfactura;
    }

    public int getUserIdChange() {
        return this.userIdChange;
    }

    public void setUserIdChange(int userIdChange) {
        this.userIdChange = userIdChange;
    }

    public short getUvolumenexamen() {
        return this.uvolumenexamen;
    }

    public void setUvolumenexamen(short uvolumenexamen) {
        this.uvolumenexamen = uvolumenexamen;
    }
    
    public mx.com.web2lab.backend.hbm.om.lis.CExamen getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen) {
        this.cexamen = cexamen;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac getTordensucursalfac() {
        return this.tordensucursalfac;
    }

    public void setTordensucursalfac(mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac tordensucursalfac) {
        this.tordensucursalfac = tordensucursalfac;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TFactura getTfactura() {
        return this.tfactura;
    }

    public void setTfactura(mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura) {
        this.tfactura = tfactura;
    }

    public int getKordensucursal() {
        return this.kordensucursal;
    }

    public void setKordensucursal(int kordensucursal) {
        this.kordensucursal = kordensucursal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kordenexamenfac", getKordenexamenfac())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TOrdenExamenSucursalFac) ) return false;
        TOrdenExamenSucursalFac castOther = (TOrdenExamenSucursalFac) other;
        return new EqualsBuilder()
            .append(this.getKordenexamenfac(), castOther.getKordenexamenfac())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordenexamenfac())
            .toHashCode();
    }
}
