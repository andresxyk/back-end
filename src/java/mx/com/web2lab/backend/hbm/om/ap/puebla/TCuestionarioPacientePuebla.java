package mx.com.web2lab.backend.hbm.om.ap.puebla;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TCuestionarioPacientePuebla implements Serializable {

    /** identifier field */
    private java.lang.Integer kcuestionariopacientepuebla;

    /** persistent field */
    private int kpaciente;

    /** persistent field */
    private int uedadprimeramestruacion;

    /** persistent field */
    private int uhijos;

    /** persistent field */
    private int uabortos;

    /** persistent field */
    private boolean bolembarazada;

    /** persistent field */
    private java.lang.String sembarazada;

    /** persistent field */
    private boolean bolmastografiaanterior;

    /** persistent field */
    private java.lang.String smastografiacuando;

    /** persistent field */
    private boolean bolatenidocancer;

    /** persistent field */
    private java.lang.String scancercuando;

    /** persistent field */
    private java.lang.String sultimamestruacion;

    /** persistent field */
    private java.lang.String smadre;

    /** persistent field */
    private java.lang.String sedadmadre;

    /** persistent field */
    private java.lang.String stias;

    /** persistent field */
    private java.lang.String sedadtias;

    /** persistent field */
    private java.lang.String sabuelas;

    /** persistent field */
    private java.lang.String sedadabuelas;

    /** persistent field */
    private boolean bolanticonceptivo;

    /** persistent field */
    private java.lang.String scualesanticonceptivo;

    /** persistent field */
    private java.lang.String stiempoanticonceptivo;

    /** persistent field */
    private boolean bolcirugia;

    /** persistent field */
    private java.lang.String scirugiatipo;

    /** persistent field */
    private java.lang.String scirugiacuando;

    /** persistent field */
    private java.lang.String scirugiadonde;

    /** persistent field */
    private boolean bolsenamama;

    /** persistent field */
    private java.lang.String ssenadonde;

    /** persistent field */
    private java.lang.String ssenatipo;

    /** persistent field */
    private java.lang.String smotivoestudio;

    /** persistent field */
    private boolean bollesion;

    /** persistent field */
    private java.lang.String slesionubicacion;

    /** persistent field */
    private boolean bolfuma;

    /** persistent field */
    private java.lang.String sfumadesde;

    /** persistent field */
    private java.lang.String spadecimiento;

    /** full constructor */
    public TCuestionarioPacientePuebla(java.lang.Integer kcuestionariopacientepuebla, int kpaciente, int uedadprimeramestruacion, int uhijos, int uabortos, boolean bolembarazada, java.lang.String sembarazada, boolean bolmastografiaanterior, java.lang.String smastografiacuando, boolean bolatenidocancer, java.lang.String scancercuando, java.lang.String sultimamestruacion, java.lang.String smadre, java.lang.String sedadmadre, java.lang.String stias, java.lang.String sedadtias, java.lang.String sabuelas, java.lang.String sedadabuelas, boolean bolanticonceptivo, java.lang.String scualesanticonceptivo, java.lang.String stiempoanticonceptivo, boolean bolcirugia, java.lang.String scirugiatipo, java.lang.String scirugiacuando, java.lang.String scirugiadonde, boolean bolsenamama, java.lang.String ssenadonde, java.lang.String ssenatipo, java.lang.String smotivoestudio, boolean bollesion, java.lang.String slesionubicacion, boolean bolfuma, java.lang.String sfumadesde, java.lang.String spadecimiento) {
        this.kcuestionariopacientepuebla = kcuestionariopacientepuebla;
        this.kpaciente = kpaciente;
        this.uedadprimeramestruacion = uedadprimeramestruacion;
        this.uhijos = uhijos;
        this.uabortos = uabortos;
        this.bolembarazada = bolembarazada;
        this.sembarazada = sembarazada;
        this.bolmastografiaanterior = bolmastografiaanterior;
        this.smastografiacuando = smastografiacuando;
        this.bolatenidocancer = bolatenidocancer;
        this.scancercuando = scancercuando;
        this.sultimamestruacion = sultimamestruacion;
        this.smadre = smadre;
        this.sedadmadre = sedadmadre;
        this.stias = stias;
        this.sedadtias = sedadtias;
        this.sabuelas = sabuelas;
        this.sedadabuelas = sedadabuelas;
        this.bolanticonceptivo = bolanticonceptivo;
        this.scualesanticonceptivo = scualesanticonceptivo;
        this.stiempoanticonceptivo = stiempoanticonceptivo;
        this.bolcirugia = bolcirugia;
        this.scirugiatipo = scirugiatipo;
        this.scirugiacuando = scirugiacuando;
        this.scirugiadonde = scirugiadonde;
        this.bolsenamama = bolsenamama;
        this.ssenadonde = ssenadonde;
        this.ssenatipo = ssenatipo;
        this.smotivoestudio = smotivoestudio;
        this.bollesion = bollesion;
        this.slesionubicacion = slesionubicacion;
        this.bolfuma = bolfuma;
        this.sfumadesde = sfumadesde;
        this.spadecimiento = spadecimiento;
    }

    /** default constructor */
    public TCuestionarioPacientePuebla() {
    }

    public java.lang.Integer getKcuestionariopacientepuebla() {
        return this.kcuestionariopacientepuebla;
    }

    public void setKcuestionariopacientepuebla(java.lang.Integer kcuestionariopacientepuebla) {
        this.kcuestionariopacientepuebla = kcuestionariopacientepuebla;
    }

    public int getKpaciente() {
        return this.kpaciente;
    }

    public void setKpaciente(int kpaciente) {
        this.kpaciente = kpaciente;
    }

    public int getUedadprimeramestruacion() {
        return this.uedadprimeramestruacion;
    }

    public void setUedadprimeramestruacion(int uedadprimeramestruacion) {
        this.uedadprimeramestruacion = uedadprimeramestruacion;
    }

    public int getUhijos() {
        return this.uhijos;
    }

    public void setUhijos(int uhijos) {
        this.uhijos = uhijos;
    }

    public int getUabortos() {
        return this.uabortos;
    }

    public void setUabortos(int uabortos) {
        this.uabortos = uabortos;
    }

    public boolean isBolembarazada() {
        return this.bolembarazada;
    }

    public void setBolembarazada(boolean bolembarazada) {
        this.bolembarazada = bolembarazada;
    }

    public java.lang.String getSembarazada() {
        return this.sembarazada;
    }

    public void setSembarazada(java.lang.String sembarazada) {
        this.sembarazada = sembarazada;
    }

    public boolean isBolmastografiaanterior() {
        return this.bolmastografiaanterior;
    }

    public void setBolmastografiaanterior(boolean bolmastografiaanterior) {
        this.bolmastografiaanterior = bolmastografiaanterior;
    }

    public java.lang.String getSmastografiacuando() {
        return this.smastografiacuando;
    }

    public void setSmastografiacuando(java.lang.String smastografiacuando) {
        this.smastografiacuando = smastografiacuando;
    }

    public boolean isBolatenidocancer() {
        return this.bolatenidocancer;
    }

    public void setBolatenidocancer(boolean bolatenidocancer) {
        this.bolatenidocancer = bolatenidocancer;
    }

    public java.lang.String getScancercuando() {
        return this.scancercuando;
    }

    public void setScancercuando(java.lang.String scancercuando) {
        this.scancercuando = scancercuando;
    }

    public java.lang.String getSultimamestruacion() {
        return this.sultimamestruacion;
    }

    public void setSultimamestruacion(java.lang.String sultimamestruacion) {
        this.sultimamestruacion = sultimamestruacion;
    }

    public java.lang.String getSmadre() {
        return this.smadre;
    }

    public void setSmadre(java.lang.String smadre) {
        this.smadre = smadre;
    }

    public java.lang.String getSedadmadre() {
        return this.sedadmadre;
    }

    public void setSedadmadre(java.lang.String sedadmadre) {
        this.sedadmadre = sedadmadre;
    }

    public java.lang.String getStias() {
        return this.stias;
    }

    public void setStias(java.lang.String stias) {
        this.stias = stias;
    }

    public java.lang.String getSedadtias() {
        return this.sedadtias;
    }

    public void setSedadtias(java.lang.String sedadtias) {
        this.sedadtias = sedadtias;
    }

    public java.lang.String getSabuelas() {
        return this.sabuelas;
    }

    public void setSabuelas(java.lang.String sabuelas) {
        this.sabuelas = sabuelas;
    }

    public java.lang.String getSedadabuelas() {
        return this.sedadabuelas;
    }

    public void setSedadabuelas(java.lang.String sedadabuelas) {
        this.sedadabuelas = sedadabuelas;
    }

    public boolean isBolanticonceptivo() {
        return this.bolanticonceptivo;
    }

    public void setBolanticonceptivo(boolean bolanticonceptivo) {
        this.bolanticonceptivo = bolanticonceptivo;
    }

    public java.lang.String getScualesanticonceptivo() {
        return this.scualesanticonceptivo;
    }

    public void setScualesanticonceptivo(java.lang.String scualesanticonceptivo) {
        this.scualesanticonceptivo = scualesanticonceptivo;
    }

    public java.lang.String getStiempoanticonceptivo() {
        return this.stiempoanticonceptivo;
    }

    public void setStiempoanticonceptivo(java.lang.String stiempoanticonceptivo) {
        this.stiempoanticonceptivo = stiempoanticonceptivo;
    }

    public boolean isBolcirugia() {
        return this.bolcirugia;
    }

    public void setBolcirugia(boolean bolcirugia) {
        this.bolcirugia = bolcirugia;
    }

    public java.lang.String getScirugiatipo() {
        return this.scirugiatipo;
    }

    public void setScirugiatipo(java.lang.String scirugiatipo) {
        this.scirugiatipo = scirugiatipo;
    }

    public java.lang.String getScirugiacuando() {
        return this.scirugiacuando;
    }

    public void setScirugiacuando(java.lang.String scirugiacuando) {
        this.scirugiacuando = scirugiacuando;
    }

    public java.lang.String getScirugiadonde() {
        return this.scirugiadonde;
    }

    public void setScirugiadonde(java.lang.String scirugiadonde) {
        this.scirugiadonde = scirugiadonde;
    }

    public boolean isBolsenamama() {
        return this.bolsenamama;
    }

    public void setBolsenamama(boolean bolsenamama) {
        this.bolsenamama = bolsenamama;
    }

    public java.lang.String getSsenadonde() {
        return this.ssenadonde;
    }

    public void setSsenadonde(java.lang.String ssenadonde) {
        this.ssenadonde = ssenadonde;
    }

    public java.lang.String getSsenatipo() {
        return this.ssenatipo;
    }

    public void setSsenatipo(java.lang.String ssenatipo) {
        this.ssenatipo = ssenatipo;
    }

    public java.lang.String getSmotivoestudio() {
        return this.smotivoestudio;
    }

    public void setSmotivoestudio(java.lang.String smotivoestudio) {
        this.smotivoestudio = smotivoestudio;
    }

    public boolean isBollesion() {
        return this.bollesion;
    }

    public void setBollesion(boolean bollesion) {
        this.bollesion = bollesion;
    }

    public java.lang.String getSlesionubicacion() {
        return this.slesionubicacion;
    }

    public void setSlesionubicacion(java.lang.String slesionubicacion) {
        this.slesionubicacion = slesionubicacion;
    }

    public boolean isBolfuma() {
        return this.bolfuma;
    }

    public void setBolfuma(boolean bolfuma) {
        this.bolfuma = bolfuma;
    }

    public java.lang.String getSfumadesde() {
        return this.sfumadesde;
    }

    public void setSfumadesde(java.lang.String sfumadesde) {
        this.sfumadesde = sfumadesde;
    }

    public java.lang.String getSpadecimiento() {
        return this.spadecimiento;
    }

    public void setSpadecimiento(java.lang.String spadecimiento) {
        this.spadecimiento = spadecimiento;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kcuestionariopacientepuebla", getKcuestionariopacientepuebla())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TCuestionarioPacientePuebla) ) return false;
        TCuestionarioPacientePuebla castOther = (TCuestionarioPacientePuebla) other;
        return new EqualsBuilder()
            .append(this.getKcuestionariopacientepuebla(), castOther.getKcuestionariopacientepuebla())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKcuestionariopacientepuebla())
            .toHashCode();
    }

}
