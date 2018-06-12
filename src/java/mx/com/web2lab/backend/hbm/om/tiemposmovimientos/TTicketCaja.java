package mx.com.web2lab.backend.hbm.om.tiemposmovimientos;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TTicketCaja implements Serializable {

    /** identifier field */
    private java.lang.Integer kticketcaja;

    /** persistent field */
    private int csucursal;

    /** persistent field */
    private int uconsecutivoticketsucursal;

    /** nullable persistent field */
    private java.util.Date dinicio;

    /** nullable persistent field */
    private java.util.Date dtermino;

    /** persistent field */
    private int kordensucursal;

    /** persistent field */
    private int userId;

    /** persistent field */
    private int cestadoregistro;

    /** persistent field */
    private java.lang.String smodulo;

    /** persistent field */
    private java.lang.String snemonicoconsecutivo;

    /** full constructor */
    public TTicketCaja(java.lang.Integer kticketcaja, int csucursal, int uconsecutivoticketsucursal, java.util.Date dinicio, java.util.Date dtermino, int kordensucursal, int userId, int cestadoregistro, java.lang.String smodulo, java.lang.String snemonicoconsecutivo) {
        this.kticketcaja = kticketcaja;
        this.csucursal = csucursal;
        this.uconsecutivoticketsucursal = uconsecutivoticketsucursal;
        this.dinicio = dinicio;
        this.dtermino = dtermino;
        this.kordensucursal = kordensucursal;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.smodulo = smodulo;
        this.snemonicoconsecutivo = snemonicoconsecutivo;
    }

    /** default constructor */
    public TTicketCaja() {
    }

    /** minimal constructor */
    public TTicketCaja(java.lang.Integer kticketcaja, int csucursal, int uconsecutivoticketsucursal, int kordensucursal, int userId, int cestadoregistro, java.lang.String smodulo, java.lang.String snemonicoconsecutivo) {
        this.kticketcaja = kticketcaja;
        this.csucursal = csucursal;
        this.uconsecutivoticketsucursal = uconsecutivoticketsucursal;
        this.kordensucursal = kordensucursal;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.smodulo = smodulo;
        this.snemonicoconsecutivo = snemonicoconsecutivo;
    }

    public java.lang.Integer getKticketcaja() {
        return this.kticketcaja;
    }

    public void setKticketcaja(java.lang.Integer kticketcaja) {
        this.kticketcaja = kticketcaja;
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

    public int getKordensucursal() {
        return this.kordensucursal;
    }

    public void setKordensucursal(int kordensucursal) {
        this.kordensucursal = kordensucursal;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("kticketcaja", getKticketcaja())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TTicketCaja) ) return false;
        TTicketCaja castOther = (TTicketCaja) other;
        return new EqualsBuilder()
            .append(this.getKticketcaja(), castOther.getKticketcaja())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKticketcaja())
            .toHashCode();
    }

}
