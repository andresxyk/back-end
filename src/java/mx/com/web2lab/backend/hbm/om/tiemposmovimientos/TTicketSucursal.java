package mx.com.web2lab.backend.hbm.om.tiemposmovimientos;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TTicketSucursal implements Serializable {

    /** identifier field */
    private java.lang.Integer kticketsucursal;

    /** persistent field */
    private int csucursal;

    /** persistent field */
    private int uconsecutivoticketsucursal;

    /** nullable persistent field */
    private java.util.Date dinicio;

    /** nullable persistent field */
    private java.util.Date dtermino;

    /** nullable persistent field */
    private java.util.Date dterminorecepcion;

    /** persistent field */
    private int kordensucursal;

    /** persistent field */
    private int kordensucursalcotizacion;

    /** persistent field */
    private int userId;

    /** persistent field */
    private int cestadoregistro;

    /** persistent field */
    private java.lang.String smodulo;

    /** persistent field */
    private java.lang.String snemonicoconsecutivo;

    /** nullable persistent field */
    private java.util.Date dcierreticket;
    
    /** persistent field */
    private int kticketsucursalinicial;
    
    
    /** full constructor */
    public TTicketSucursal(java.lang.Integer kticketsucursal, int csucursal, int uconsecutivoticketsucursal, java.util.Date dinicio, java.util.Date dtermino, java.util.Date dterminorecepcion, int kordensucursal, int kordensucursalcotizacion, int userId, int cestadoregistro, java.lang.String smodulo, java.lang.String snemonicoconsecutivo, java.util.Date dcierreticket, int kticketsucursalinicial) {
        this.kticketsucursal = kticketsucursal;
        this.csucursal = csucursal;
        this.uconsecutivoticketsucursal = uconsecutivoticketsucursal;
        this.dinicio = dinicio;
        this.dtermino = dtermino;
        this.dterminorecepcion = dterminorecepcion;
        this.kordensucursal = kordensucursal;
        this.kordensucursalcotizacion = kordensucursalcotizacion;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.smodulo = smodulo;
        this.snemonicoconsecutivo = snemonicoconsecutivo;
        this.dcierreticket = dcierreticket;
        this.kticketsucursalinicial = kticketsucursalinicial;
    }

    /** default constructor */
    public TTicketSucursal() {
    }

    /** minimal constructor */
    public TTicketSucursal(java.lang.Integer kticketsucursal, int csucursal, int uconsecutivoticketsucursal, int kordensucursal, int kordensucursalcotizacion, int userId, int cestadoregistro, java.lang.String smodulo, java.lang.String snemonicoconsecutivo, java.util.Date dcierreticket, int kticketsucursalinicial) {
        this.kticketsucursal = kticketsucursal;
        this.csucursal = csucursal;
        this.uconsecutivoticketsucursal = uconsecutivoticketsucursal;
        this.kordensucursal = kordensucursal;
        this.kordensucursalcotizacion = kordensucursalcotizacion;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.smodulo = smodulo;
        this.snemonicoconsecutivo = snemonicoconsecutivo;
        this.dcierreticket = dcierreticket;
        this.kticketsucursalinicial = kticketsucursalinicial;
    }

    public java.lang.Integer getKticketsucursal() {
        return this.kticketsucursal;
    }

    public void setKticketsucursal(java.lang.Integer kticketsucursal) {
        this.kticketsucursal = kticketsucursal;
    }


    public int getKticketsucursalinicial() {
        return this.kticketsucursalinicial;
    }

    public void setKticketsucursalinicial(int kticketsucursalinicial) {
        this.kticketsucursalinicial = kticketsucursalinicial;
    }
    
    public int getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(int csucursal) {
        this.csucursal = csucursal;
    }

    public int getUconsecutivoticketsucursal() {
        return this.uconsecutivoticketsucursal;
    }

    public void setUconsecutivoticketsucursal(int uconsecutivoticketsucursal) {
        this.uconsecutivoticketsucursal = uconsecutivoticketsucursal;
    }

    public java.util.Date getDinicio() {
        return this.dinicio;
    }

    public void setDinicio(java.util.Date dinicio) {
        this.dinicio = dinicio;
    }

    public java.util.Date getDtermino() {
        return this.dtermino;
    }

    public void setDtermino(java.util.Date dtermino) {
        this.dtermino = dtermino;
    }

    public java.util.Date getDterminorecepcion() {
        return this.dterminorecepcion;
    }

    public void setDterminorecepcion(java.util.Date dterminorecepcion) {
        this.dterminorecepcion = dterminorecepcion;
    }

    public int getKordensucursal() {
        return this.kordensucursal;
    }

    public void setKordensucursal(int kordensucursal) {
        this.kordensucursal = kordensucursal;
    }

    public int getKordensucursalcotizacion() {
        return this.kordensucursalcotizacion;
    }

    public void setKordensucursalcotizacion(int kordensucursalcotizacion) {
        this.kordensucursalcotizacion = kordensucursalcotizacion;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.lang.String getSmodulo() {
        return this.smodulo;
    }

    public void setSmodulo(java.lang.String smodulo) {
        this.smodulo = smodulo;
    }

    public java.lang.String getSnemonicoconsecutivo() {
        return this.snemonicoconsecutivo;
    }

    public void setSnemonicoconsecutivo(java.lang.String snemonicoconsecutivo) {
        this.snemonicoconsecutivo = snemonicoconsecutivo;
    }
    
    public java.util.Date getDcierreticket() {
        return this.dcierreticket;
    }

    public void setDcierreticket(java.util.Date dcierreticket) {
        this.dcierreticket = dcierreticket;
    }
    

    public String toString() {
        return new ToStringBuilder(this)
            .append("kticketsucursal", getKticketsucursal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TTicketSucursal) ) return false;
        TTicketSucursal castOther = (TTicketSucursal) other;
        return new EqualsBuilder()
            .append(this.getKticketsucursal(), castOther.getKticketsucursal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKticketsucursal())
            .toHashCode();
    }

}
