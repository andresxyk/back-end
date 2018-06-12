package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VwResultado implements Serializable {

    /** identifier field */
    private long kadmision;

    /** identifier field */
    private long korden;

    /** identifier field */
    private long kpaciente;

    /** identifier field */
    private int claboratorioexamen;

    /** identifier field */
    private java.util.Date dcapturaexamen;

    /** identifier field */
    private long cexamen;

    /** identifier field */
    private java.lang.String sexamen;

    /** identifier field */
    private int ctipoestudio;

    /** identifier field */
    private java.lang.String stipoestudio;

    /** identifier field */
    private long kordenexamen;

    /** identifier field */
    private java.lang.Integer gorden;

    /** identifier field */
    private int corden;

    /** identifier field */
    private java.lang.String escala;

    /** identifier field */
    private java.lang.String grupo;

    /** identifier field */
    private java.lang.String codigo;

    /** identifier field */
    private java.lang.String resultado;

    /** identifier field */
    private java.lang.String tipo;

    /** identifier field */
    private java.lang.String limites;

    /** identifier field */
    private java.lang.String medida;

    /** identifier field */
    private java.lang.String notaCodigo;

    /** full constructor */
    public VwResultado(long kadmision, long korden, long kpaciente, int claboratorioexamen, java.util.Date dcapturaexamen, long cexamen, java.lang.String sexamen, int ctipoestudio, java.lang.String stipoestudio, long kordenexamen, java.lang.Integer gorden, int corden, java.lang.String escala, java.lang.String grupo, java.lang.String codigo, java.lang.String resultado, java.lang.String tipo, java.lang.String limites, java.lang.String medida, java.lang.String notaCodigo) {
        this.kadmision = kadmision;
        this.korden = korden;
        this.kpaciente = kpaciente;
        this.claboratorioexamen = claboratorioexamen;
        this.dcapturaexamen = dcapturaexamen;
        this.cexamen = cexamen;
        this.sexamen = sexamen;
        this.ctipoestudio = ctipoestudio;
        this.stipoestudio = stipoestudio;
        this.kordenexamen = kordenexamen;
        this.gorden = gorden;
        this.corden = corden;
        this.escala = escala;
        this.grupo = grupo;
        this.codigo = codigo;
        this.resultado = resultado;
        this.tipo = tipo;
        this.limites = limites;
        this.medida = medida;
        this.notaCodigo = notaCodigo;
    }

    /** default constructor */
    public VwResultado() {
    }

    public long getKadmision() {
        return this.kadmision;
    }

    public void setKadmision(long kadmision) {
        this.kadmision = kadmision;
    }

    public long getKorden() {
        return this.korden;
    }

    public void setKorden(long korden) {
        this.korden = korden;
    }

    public long getKpaciente() {
        return this.kpaciente;
    }

    public void setKpaciente(long kpaciente) {
        this.kpaciente = kpaciente;
    }

    public int getClaboratorioexamen() {
        return this.claboratorioexamen;
    }

    public void setClaboratorioexamen(int claboratorioexamen) {
        this.claboratorioexamen = claboratorioexamen;
    }

    public java.util.Date getDcapturaexamen() {
        return this.dcapturaexamen;
    }

    public void setDcapturaexamen(java.util.Date dcapturaexamen) {
        this.dcapturaexamen = dcapturaexamen;
    }

    public long getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(long cexamen) {
        this.cexamen = cexamen;
    }

    public java.lang.String getSexamen() {
        return this.sexamen;
    }

    public void setSexamen(java.lang.String sexamen) {
        this.sexamen = sexamen;
    }

    public int getCtipoestudio() {
        return this.ctipoestudio;
    }

    public void setCtipoestudio(int ctipoestudio) {
        this.ctipoestudio = ctipoestudio;
    }

    public java.lang.String getStipoestudio() {
        return this.stipoestudio;
    }

    public void setStipoestudio(java.lang.String stipoestudio) {
        this.stipoestudio = stipoestudio;
    }

    public long getKordenexamen() {
        return this.kordenexamen;
    }

    public void setKordenexamen(long kordenexamen) {
        this.kordenexamen = kordenexamen;
    }

    public java.lang.Integer getGorden() {
        return this.gorden;
    }

    public void setGorden(java.lang.Integer gorden) {
        this.gorden = gorden;
    }

    public int getCorden() {
        return this.corden;
    }

    public void setCorden(int corden) {
        this.corden = corden;
    }

    public java.lang.String getEscala() {
        return this.escala;
    }

    public void setEscala(java.lang.String escala) {
        this.escala = escala;
    }

    public java.lang.String getGrupo() {
        return this.grupo;
    }

    public void setGrupo(java.lang.String grupo) {
        this.grupo = grupo;
    }

    public java.lang.String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }

    public java.lang.String getResultado() {
        return this.resultado;
    }

    public void setResultado(java.lang.String resultado) {
        this.resultado = resultado;
    }

    public java.lang.String getTipo() {
        return this.tipo;
    }

    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }

    public java.lang.String getLimites() {
        return this.limites;
    }

    public void setLimites(java.lang.String limites) {
        this.limites = limites;
    }

    public java.lang.String getMedida() {
        return this.medida;
    }

    public void setMedida(java.lang.String medida) {
        this.medida = medida;
    }

    public java.lang.String getNotaCodigo() {
        return this.notaCodigo;
    }

    public void setNotaCodigo(java.lang.String notaCodigo) {
        this.notaCodigo = notaCodigo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kadmision", getKadmision())
            .append("korden", getKorden())
            .append("kpaciente", getKpaciente())
            .append("claboratorioexamen", getClaboratorioexamen())
            .append("dcapturaexamen", getDcapturaexamen())
            .append("cexamen", getCexamen())
            .append("sexamen", getSexamen())
            .append("ctipoestudio", getCtipoestudio())
            .append("stipoestudio", getStipoestudio())
            .append("kordenexamen", getKordenexamen())
            .append("gorden", getGorden())
            .append("corden", getCorden())
            .append("escala", getEscala())
            .append("grupo", getGrupo())
            .append("codigo", getCodigo())
            .append("resultado", getResultado())
            .append("tipo", getTipo())
            .append("limites", getLimites())
            .append("medida", getMedida())
            .append("notaCodigo", getNotaCodigo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VwResultado) ) return false;
        VwResultado castOther = (VwResultado) other;
        return new EqualsBuilder()
            .append(this.getKadmision(), castOther.getKadmision())
            .append(this.getKorden(), castOther.getKorden())
            .append(this.getKpaciente(), castOther.getKpaciente())
            .append(this.getClaboratorioexamen(), castOther.getClaboratorioexamen())
            .append(this.getDcapturaexamen(), castOther.getDcapturaexamen())
            .append(this.getCexamen(), castOther.getCexamen())
            .append(this.getSexamen(), castOther.getSexamen())
            .append(this.getCtipoestudio(), castOther.getCtipoestudio())
            .append(this.getStipoestudio(), castOther.getStipoestudio())
            .append(this.getKordenexamen(), castOther.getKordenexamen())
            .append(this.getGorden(), castOther.getGorden())
            .append(this.getCorden(), castOther.getCorden())
            .append(this.getEscala(), castOther.getEscala())
            .append(this.getGrupo(), castOther.getGrupo())
            .append(this.getCodigo(), castOther.getCodigo())
            .append(this.getResultado(), castOther.getResultado())
            .append(this.getTipo(), castOther.getTipo())
            .append(this.getLimites(), castOther.getLimites())
            .append(this.getMedida(), castOther.getMedida())
            .append(this.getNotaCodigo(), castOther.getNotaCodigo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKadmision())
            .append(getKorden())
            .append(getKpaciente())
            .append(getClaboratorioexamen())
            .append(getDcapturaexamen())
            .append(getCexamen())
            .append(getSexamen())
            .append(getCtipoestudio())
            .append(getStipoestudio())
            .append(getKordenexamen())
            .append(getGorden())
            .append(getCorden())
            .append(getEscala())
            .append(getGrupo())
            .append(getCodigo())
            .append(getResultado())
            .append(getTipo())
            .append(getLimites())
            .append(getMedida())
            .append(getNotaCodigo())
            .toHashCode();
    }

}
