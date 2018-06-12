package mx.com.web2lab.backend.beans.puebla;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.ap.PacienteBean;

public class CuestionarioPantallaBean {
    private int kcuestionariopacientepuebla;	
	private int kPaciente;	
	private int uedadprimeramestruacion;	
	private int uhijos;	
	private int uabortos;	
	private boolean bolembarazada;	
	private String sembarazada;	
	private boolean bolmastografiaanterior;	
	private String smastografiacuando;	
	private boolean bolatenidocancer;	
	private String scancercuando;	
	private String sultimamestruacion;	
	private String smadre;	
	private String sedadmadre;	
	private String stias;	
	private String sedadtias;
	private String sabuelas;	
	private String sedadabuelas;
	private boolean bolanticonceptivo;	
	private String scualesanticonceptivo;	
	private String stiempoanticonceptivo;
	private boolean bolcirugia;	
	private String scirugiatipo;	
	private String scirugiacuando;
	private String scirugiadonde;
	private boolean bolsenamama;	
	private String ssenadonde;	
	private String ssenatipo;	
	private String smotivoestudio;	
	private boolean bollesion;	
	private String slesionubicacion;	
	private boolean bolfuma;	
	private String sfumadesde;	
	private String spadecimiento;
	private String smensajeoperacion = "";
	private PacienteBean objPacienteBean;
	private OrdenBean objOrdenBean;

	public int getkPaciente() {
		return kPaciente;
	}
	public void setkPaciente(int kPaciente) {
		this.kPaciente = kPaciente;
	}
	public int getUedadprimeramestruacion() {
		return uedadprimeramestruacion;
	}
	public void setUedadprimeramestruacion(int uedadprimeramestruacion) {
		this.uedadprimeramestruacion = uedadprimeramestruacion;
	}
	public int getUhijos() {
		return uhijos;
	}
	public void setUhijos(int uhijos) {
		this.uhijos = uhijos;
	}
	public int getUabortos() {
		return uabortos;
	}
	public void setUabortos(int uabortos) {
		this.uabortos = uabortos;
	}
	public boolean isBolembarazada() {
		return bolembarazada;
	}
	public void setBolembarazada(boolean bolembarazada) {
		this.bolembarazada = bolembarazada;
	}
	public String getSembarazada() {
		return sembarazada;
	}
	public void setSembarazada(String sembarazada) {
		this.sembarazada = sembarazada;
	}
	public boolean isBolmastografiaanterior() {
		return bolmastografiaanterior;
	}
	public void setBolmastografiaanterior(boolean bolmastografiaanterior) {
		this.bolmastografiaanterior = bolmastografiaanterior;
	}
	public String getSmastografiacuando() {
		return smastografiacuando;
	}
	public void setSmastografiacuando(String smastografiacuando) {
		this.smastografiacuando = smastografiacuando;
	}
	public boolean isBolatenidocancer() {
		return bolatenidocancer;
	}
	public void setBolatenidocancer(boolean bolatenidocancer) {
		this.bolatenidocancer = bolatenidocancer;
	}
	public String getScancercuando() {
		return scancercuando;
	}
	public void setScancercuando(String scancercuando) {
		this.scancercuando = scancercuando;
	}
	public String getSultimamestruacion() {
		return sultimamestruacion;
	}
	public void setSultimamestruacion(String sultimamestruacion) {
		this.sultimamestruacion = sultimamestruacion;
	}
	public String getSmadre() {
		return smadre;
	}
	public void setSmadre(String smadre) {
		this.smadre = smadre;
	}
	public String getSedadmadre() {
		return sedadmadre;
	}
	public void setSedadmadre(String sedadmadre) {
		this.sedadmadre = sedadmadre;
	}
	public String getStias() {
		return stias;
	}
	public void setStias(String stias) {
		this.stias = stias;
	}
	public String getSedadtias() {
		return sedadtias;
	}
	public void setSedadtias(String sedadtias) {
		this.sedadtias = sedadtias;
	}
	public String getSabuelas() {
		return sabuelas;
	}
	public void setSabuelas(String sabuelas) {
		this.sabuelas = sabuelas;
	}
	public String getSedadabuelas() {
		return sedadabuelas;
	}
	public void setSedadabuelas(String sedadabuelas) {
		this.sedadabuelas = sedadabuelas;
	}
	public boolean isBolanticonceptivo() {
		return bolanticonceptivo;
	}
	public void setBolanticonceptivo(boolean bolanticonceptivo) {
		this.bolanticonceptivo = bolanticonceptivo;
	}
	public String getScualesanticonceptivo() {
		return scualesanticonceptivo;
	}
	public void setScualesanticonceptivo(String scualesanticonceptivo) {
		this.scualesanticonceptivo = scualesanticonceptivo;
	}
	public String getStiempoanticonceptivo() {
		return stiempoanticonceptivo;
	}
	public void setStiempoanticonceptivo(String stiempoanticonceptivo) {
		this.stiempoanticonceptivo = stiempoanticonceptivo;
	}
	public boolean isBolcirugia() {
		return bolcirugia;
	}
	public void setBolcirugia(boolean bolcirugia) {
		this.bolcirugia = bolcirugia;
	}
	public String getScirugiatipo() {
		return scirugiatipo;
	}
	public void setScirugiatipo(String scirugiatipo) {
		this.scirugiatipo = scirugiatipo;
	}
	public String getScirugiacuando() {
		return scirugiacuando;
	}
	public void setScirugiacuando(String scirugiacuando) {
		this.scirugiacuando = scirugiacuando;
	}
	public String getScirugiadonde() {
		return scirugiadonde;
	}
	public void setScirugiadonde(String scirugiadonde) {
		this.scirugiadonde = scirugiadonde;
	}
	public boolean isBolsenamama() {
		return bolsenamama;
	}
	public void setBolsenamama(boolean bolsenamama) {
		this.bolsenamama = bolsenamama;
	}
	public String getSsenadonde() {
		return ssenadonde;
	}
	public void setSsenadonde(String ssenadonde) {
		this.ssenadonde = ssenadonde;
	}
	public String getSsenatipo() {
		return ssenatipo;
	}
	public void setSsenatipo(String ssenatipo) {
		this.ssenatipo = ssenatipo;
	}
	public String getSmotivoestudio() {
		return smotivoestudio;
	}
	public void setSmotivoestudio(String smotivoestudio) {
		this.smotivoestudio = smotivoestudio;
	}
	public boolean isBollesion() {
		return bollesion;
	}
	public void setBollesion(boolean bollesion) {
		this.bollesion = bollesion;
	}
	public String getSlesionubicacion() {
		return slesionubicacion;
	}
	public void setSlesionubicacion(String slesionubicacion) {
		this.slesionubicacion = slesionubicacion;
	}
	public boolean isBolfuma() {
		return bolfuma;
	}
	public void setBolfuma(boolean bolfuma) {
		this.bolfuma = bolfuma;
	}
	public String getSfumadesde() {
		return sfumadesde;
	}
	public void setSfumadesde(String sfumadesde) {
		this.sfumadesde = sfumadesde;
	}
	public String getSpadecimiento() {
		return spadecimiento;
	}
	public void setSpadecimiento(String spadecimiento) {
		this.spadecimiento = spadecimiento;
	}
	public int getKcuestionariopacientepuebla() {
		return kcuestionariopacientepuebla;
	}
	public void setKcuestionariopacientepuebla(
			int kcuestionariopacientepuebla) {
		this.kcuestionariopacientepuebla = kcuestionariopacientepuebla;
	}
	public PacienteBean getObjPacienteBean() {
		return objPacienteBean;
	}
	public void setObjPacienteBean(PacienteBean objPacienteBean) {
		this.objPacienteBean = objPacienteBean;
	}
	public OrdenBean getObjOrdenBean() {
		return objOrdenBean;
	}
	public void setObjOrdenBean(OrdenBean objOrdenBean) {
		this.objOrdenBean = objOrdenBean;
	}
	public String getSmensajeoperacion() {
		return smensajeoperacion;
	}
	public void setSmensajeoperacion(String smensajeoperacion) {
		this.smensajeoperacion = smensajeoperacion;
	}	
}
