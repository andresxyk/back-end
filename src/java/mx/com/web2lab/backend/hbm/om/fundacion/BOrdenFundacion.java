package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BOrdenFundacion implements Serializable {

    /** identifier field */
    private java.lang.Long kordenfundacion;

    /** persistent field */
    private long kadmision;

    /** persistent field */
    private int cordenfundacion;

    /** nullable persistent field */
    private java.lang.String sordenfundacion;

    /** nullable persistent field */
    private java.math.BigDecimal msubtotal;

    /** nullable persistent field */
    private java.math.BigDecimal mdescuento;

    /** nullable persistent field */
    private java.math.BigDecimal miva;

    /** nullable persistent field */
    private java.math.BigDecimal mtotal;

    /** nullable persistent field */
    private java.math.BigDecimal macuenta;

    /** nullable persistent field */
    private java.math.BigDecimal madeuda;

    /** nullable persistent field */
    private long nfactura;

    /** nullable persistent field */
    private java.lang.String sobservacion;

    /** nullable persistent field */
    private java.util.Date dpromesa;

    /** nullable persistent field */
    private java.util.Date dentregaresultado;

    /** nullable persistent field */
    private int cestado;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private int cusuario;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion bpacientefundacion;

    /** persistent field */
    private Set bordenexamenfundacions;

    /** persistent field */
    private Set bpagofundacions;

    /** persistent field */
    private Set bordendiagfundacions;

    /** full constructor */
    public BOrdenFundacion(long kadmision, int cordenfundacion, java.lang.String sordenfundacion, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuento, java.math.BigDecimal miva, java.math.BigDecimal mtotal, java.math.BigDecimal macuenta, java.math.BigDecimal madeuda, long nfactura, java.lang.String sobservacion, java.util.Date dpromesa, java.util.Date dentregaresultado, int cestado, boolean bregistroactivo, int cusuario, java.util.Date dregistro, mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion bpacientefundacion, Set bordenexamenfundacions, Set bpagofundacions, Set bordendiagfundacions) {
        this.kadmision = kadmision;
        this.cordenfundacion = cordenfundacion;
        this.sordenfundacion = sordenfundacion;
        this.msubtotal = msubtotal;
        this.mdescuento = mdescuento;
        this.miva = miva;
        this.mtotal = mtotal;
        this.macuenta = macuenta;
        this.madeuda = madeuda;
        this.nfactura = nfactura;
        this.sobservacion = sobservacion;
        this.dpromesa = dpromesa;
        this.dentregaresultado = dentregaresultado;
        this.cestado = cestado;
        this.bregistroactivo = bregistroactivo;
        this.cusuario = cusuario;
        this.dregistro = dregistro;
        this.bpacientefundacion = bpacientefundacion;
        this.bordenexamenfundacions = bordenexamenfundacions;
        this.bpagofundacions = bpagofundacions;
        this.bordendiagfundacions = bordendiagfundacions;
    }

    /** default constructor */
    public BOrdenFundacion() {
    }

    /** minimal constructor */
    public BOrdenFundacion(long kadmision, int cordenfundacion, int cusuario, mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion bpacientefundacion, Set bordenexamenfundacions, Set bpagofundacions, Set bordendiagfundacions) {
        this.kadmision = kadmision;
        this.cordenfundacion = cordenfundacion;
        this.cusuario = cusuario;
        this.bpacientefundacion = bpacientefundacion;
        this.bordenexamenfundacions = bordenexamenfundacions;
        this.bpagofundacions = bpagofundacions;
        this.bordendiagfundacions = bordendiagfundacions;
    }

    public java.lang.Long getKordenfundacion() {
        return this.kordenfundacion;
    }

    public void setKordenfundacion(java.lang.Long kordenfundacion) {
        this.kordenfundacion = kordenfundacion;
    }

    public long getKadmision() {
        return this.kadmision;
    }

    public void setKadmision(long kadmision) {
        this.kadmision = kadmision;
    }

    public int getCordenfundacion() {
        return this.cordenfundacion;
    }

    public void setCordenfundacion(int cordenfundacion) {
        this.cordenfundacion = cordenfundacion;
    }

    public java.lang.String getSordenfundacion() {
        return this.sordenfundacion;
    }

    public void setSordenfundacion(java.lang.String sordenfundacion) {
        this.sordenfundacion = sordenfundacion;
    }

    public java.math.BigDecimal getMsubtotal() {
        return this.msubtotal;
    }

    public void setMsubtotal(java.math.BigDecimal msubtotal) {
        this.msubtotal = msubtotal;
    }

    public java.math.BigDecimal getMdescuento() {
        return this.mdescuento;
    }

    public void setMdescuento(java.math.BigDecimal mdescuento) {
        this.mdescuento = mdescuento;
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

    public java.math.BigDecimal getMacuenta() {
        return this.macuenta;
    }

    public void setMacuenta(java.math.BigDecimal macuenta) {
        this.macuenta = macuenta;
    }

    public java.math.BigDecimal getMadeuda() {
        return this.madeuda;
    }

    public void setMadeuda(java.math.BigDecimal madeuda) {
        this.madeuda = madeuda;
    }

    public long getNfactura() {
        return this.nfactura;
    }

    public void setNfactura(long nfactura) {
        this.nfactura = nfactura;
    }

    public java.lang.String getSobservacion() {
        return this.sobservacion;
    }

    public void setSobservacion(java.lang.String sobservacion) {
        this.sobservacion = sobservacion;
    }

    public java.util.Date getDpromesa() {
        return this.dpromesa;
    }

    public void setDpromesa(java.util.Date dpromesa) {
        this.dpromesa = dpromesa;
    }

    public java.util.Date getDentregaresultado() {
        return this.dentregaresultado;
    }

    public void setDentregaresultado(java.util.Date dentregaresultado) {
        this.dentregaresultado = dentregaresultado;
    }

    public int getCestado() {
        return this.cestado;
    }

    public void setCestado(int cestado) {
        this.cestado = cestado;
    }

    public boolean isBregistroactivo() {
        return this.bregistroactivo;
    }

    public void setBregistroactivo(boolean bregistroactivo) {
        this.bregistroactivo = bregistroactivo;
    }

    public int getCusuario() {
        return this.cusuario;
    }

    public void setCusuario(int cusuario) {
        this.cusuario = cusuario;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion getBpacientefundacion() {
        return this.bpacientefundacion;
    }

    public void setBpacientefundacion(mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion bpacientefundacion) {
        this.bpacientefundacion = bpacientefundacion;
    }

    public java.util.Set getBordenexamenfundacions() {
        return this.bordenexamenfundacions;
    }

    public void setBordenexamenfundacions(java.util.Set bordenexamenfundacions) {
        this.bordenexamenfundacions = bordenexamenfundacions;
    }

    public java.util.Set getBpagofundacions() {
        return this.bpagofundacions;
    }

    public void setBpagofundacions(java.util.Set bpagofundacions) {
        this.bpagofundacions = bpagofundacions;
    }

    public java.util.Set getBordendiagfundacions() {
        return this.bordendiagfundacions;
    }

    public void setBordendiagfundacions(java.util.Set bordendiagfundacions) {
        this.bordendiagfundacions = bordendiagfundacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kordenfundacion", getKordenfundacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BOrdenFundacion) ) return false;
        BOrdenFundacion castOther = (BOrdenFundacion) other;
        return new EqualsBuilder()
            .append(this.getKordenfundacion(), castOther.getKordenfundacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordenfundacion())
            .toHashCode();
    }

}
