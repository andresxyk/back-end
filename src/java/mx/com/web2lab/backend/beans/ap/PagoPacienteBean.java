package mx.com.web2lab.backend.beans.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PagoPacienteBean implements Serializable {

    /** identifier field */
    private int kpagopaciente;

    /** nullable persistent field */
    private double mpagopacientetotal;

    /** nullable persistent field */
    private double manticipo;

    /** nullable persistent field */
    private double mpagopacienteparcial;

    /** nullable persistent field */
    private double mdevolucionpaciente;

    /** nullable persistent field */
    private double msaldo;

    /** nullable persistent field */
    private int userid;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int ctipopago;

    /** persistent field */
    private int cestadoregistro;

    /** persistent field */
    private int tordensucursal;

    /** persistent field */
    private int tcortecaja;
    
    private String sdigitos = " ";

	public int getKpagopaciente() {
		return kpagopaciente;
	}

	public void setKpagopaciente(int kpagopaciente) {
		this.kpagopaciente = kpagopaciente;
	}

	public double getMpagopacientetotal() {
		return mpagopacientetotal;
	}

	public void setMpagopacientetotal(double mpagopacientetotal) {
		this.mpagopacientetotal = mpagopacientetotal;
	}

	public double getManticipo() {
		return manticipo;
	}

	public void setManticipo(double manticipo) {
		this.manticipo = manticipo;
	}

	public double getMpagopacienteparcial() {
		return mpagopacienteparcial;
	}

	public void setMpagopacienteparcial(double mpagopacienteparcial) {
		this.mpagopacienteparcial = mpagopacienteparcial;
	}

	public double getMdevolucionpaciente() {
		return mdevolucionpaciente;
	}

	public void setMdevolucionpaciente(double mdevolucionpaciente) {
		this.mdevolucionpaciente = mdevolucionpaciente;
	}

	public double getMsaldo() {
		return msaldo;
	}

	public void setMsaldo(double msaldo) {
		this.msaldo = msaldo;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public java.util.Date getDregistro() {
		return dregistro;
	}

	public void setDregistro(java.util.Date dregistro) {
		this.dregistro = dregistro;
	}

	public int getCtipopago() {
		return ctipopago;
	}

	public void setCtipopago(int ctipopago) {
		this.ctipopago = ctipopago;
	}

	public int getCestadoregistro() {
		return cestadoregistro;
	}

	public void setCestadoregistro(int cestadoregistro) {
		this.cestadoregistro = cestadoregistro;
	}

	public int getTordensucursal() {
		return tordensucursal;
	}

	public void setTordensucursal(int tordensucursal) {
		this.tordensucursal = tordensucursal;
	}

	public int getTcortecaja() {
		return tcortecaja;
	}

	public void setTcortecaja(int tcortecaja) {
		this.tcortecaja = tcortecaja;
	}

	public String getSdigitos() {
		return sdigitos;
	}

	public void setSdigitos(String sdigitos) {
		this.sdigitos = sdigitos;
	}
}
