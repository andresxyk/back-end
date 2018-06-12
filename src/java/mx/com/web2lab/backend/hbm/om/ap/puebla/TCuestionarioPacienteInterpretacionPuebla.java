package mx.com.web2lab.backend.hbm.om.ap.puebla;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TCuestionarioPacienteInterpretacionPuebla implements Serializable {

	/** identifier field */
    private java.lang.Integer kcuestionariopacienteinterpretacionpuebla;

    /** identifier field */
    private java.lang.Integer kordensucursal;

    /** persistent field */
    private java.lang.String sinstitucion;
    
    /** persistent field */
    private java.lang.String sentidad;
    
    /** persistent field */
    private java.lang.String sclues;

    /** persistent field */
    private int ujurisdiccion;
    
    /** persistent field */
    private java.lang.String smunicipio;
    
    /** persistent field */
    private java.lang.String sunidadmedica;
    
    /** persistent field */
    private java.lang.String sclaveinstitucional;
    
    /** persistent field */
    private java.lang.String scurp;

    /** persistent field */
    private java.lang.String slugarnacimiento;
    
    
    /** persistent field */
    private int uderechohabiencia;
    
    /** persistent field */
    private int uantescedentedemastografia;
    
    /** nullable persistent field */
    private java.util.Date dfechaultimamastografia;

    /** persistent field */
    private int uresultadobiradsmastografia;
   
    /** persistent field */
    private int umodalidadmastografiatamizaje;
    
    /** persistent field */
    private int umodalidadmastografiadiagnostica;
  
    /** nullable persistent field */
    private java.util.Date dfechatomamastografia;

    /** persistent field */
    private int umastografiaadecuada;
      
    /** persistent field */
    private boolean bolimagenincompleta;

    /** persistent field */
    private boolean bolbajocontraste;
    
    /** persistent field */
    private boolean bolbajaresolucion;
    
    /** persistent field */
    private boolean bolartefactos;
    
    /** persistent field */
    private boolean bolmalposicionamiento;
   
    /** persistent field */
    private boolean bolotros;
   
    /** nullable persistent field */
    private java.util.Date dfechainterpretacionmastografia;

     /** persistent field */
    private boolean boltumorderecho;

    /** persistent field */
    private boolean boltumorizquierdo;
    
    /** persistent field */
    private boolean bolasimetriaderecho;

    /** persistent field */
    private boolean bolasimetriaizquierdo;
    
    /** persistent field */
    private boolean boldeformidadderecho;
    
    /** persistent field */
    private boolean boldeformidadizquierdo;
    
    /** persistent field */
    private boolean bolcalcificacionderecho;
    
    /** persistent field */
    private boolean bolcalcificacionizquierdo;
    
    /** persistent field */
    private boolean boldensidadasimetricaderecho;
    
    /** persistent field */
    private boolean boldensidadasimetricaizquierdo;
    
    /** persistent field */
    private boolean bolotrosderecho;
    
    /** persistent field */
    private boolean bolotrosizquierdo;
    
    /** persistent field */
    private int uresultadobiradsuno;
  
    /** persistent field */
    private int uresultadobiradsdos;
    
    /** persistent field */
    private int uresultadobiradstres;
    
    /** persistent field */
    private java.lang.String srfcresultadobiradsuno;
   
    /** persistent field */
    private java.lang.String srfcresultadobiradsdos;
    
    /** persistent field */
    private java.lang.String srfcresultadobiradstres;
  
    /** persistent field */
    private java.lang.String sobservaciones;
  
    /** nullable persistent field */
    private java.util.Date dfechainformeresultado;

    /** persistent field */
    private boolean bolrepeticionestudio;

    /** persistent field */
    private boolean bolproximadeteccion;

    /** persistent field */
    private boolean bolreferenciaginecologia;

    /** persistent field */
    private java.lang.String sreferenciaevaluacion;
    
    /** nullable persistent field */
    private java.util.Date dfechareferencia;

    /** persistent field */
    private java.lang.String snombreradiologo;
    
    /** persistent field */
    private java.lang.String srfcradiologo;


    /** full constructor 
     * @param kcuestionariopacienteinterpretacionpuebla 
     * @param sinstitucion 
     * @param sentidad */
    public TCuestionarioPacienteInterpretacionPuebla( java.lang.Integer kcuestionariopacienteinterpretacionpuebla,java.lang.Integer kordensucursal, java.lang.String sinstitucion, java.lang.String sentidad, java.lang.String sclues,int ujurisdiccion,java.lang.String slugarnacimiento ,java.lang.String smunicipio,java.lang.String sunidadmedica,java.lang.String sclaveinstitucional,java.lang.String scurp,int uderechohabiencia,int uantescedentedemastografia,java.util.Date dfechaultimamastografia, int uresultadobiradsmastografia,int umodalidadmastografiatamizaje,int umodalidadmastografiadiagnostica,java.util.Date dfechatomamastografia, int umastografiaadecuada,boolean bolimagenincompleta,boolean bolbajocontraste,boolean bolbajaresolucion,boolean bolartefactos,boolean bolmalposicionamiento,boolean bolotros,java.util.Date dfechainterpretacionmastografia, boolean boltumorderecho, boolean boltumorizquierdo, boolean bolasimetriaderecho, boolean bolasimetriaizquierdo, boolean boldeformidadderecho,boolean boldeformidadizquierdo, boolean bolcalcificacionderecho,boolean bolcalcificacionizquierdo,boolean boldensidadasimetricaderecho,boolean boldensidadasimetricaizquierdo,boolean bolotrosderecho,boolean bolotrosizquierdo,int uresultadobiradsuno,int uresultadobiradsdos,int uresultadobiradstres,java.lang.String srfcresultadobiradsuno,java.lang.String srfcresultadobiradsdos,java.lang.String srfcresultadobiradstres,java.lang.String sobservaciones, java.util.Date dfechainformeresultado, boolean bolrepeticionestudio,boolean bolproximadeteccion,boolean bolreferenciaginecologia,java.lang.String sreferenciaevaluacion, java.util.Date dfechareferencia, java.lang.String snombreradiologo, java.lang.String srfcradiologo ) {
    	this.kcuestionariopacienteinterpretacionpuebla = kcuestionariopacienteinterpretacionpuebla;
        this.kordensucursal = kordensucursal;
        this.sinstitucion = sinstitucion;
        this.sentidad = sentidad;
        this.sclues = sclues;
        this.ujurisdiccion=ujurisdiccion;
        this.smunicipio = smunicipio;
        this.sunidadmedica = sunidadmedica;
        this.slugarnacimiento = slugarnacimiento;
        this.sclaveinstitucional = sclaveinstitucional;
        this.scurp = scurp;
        this.uderechohabiencia =uderechohabiencia;
        this.uantescedentedemastografia = uantescedentedemastografia;
        this.dfechaultimamastografia = dfechaultimamastografia;
        this.uresultadobiradsmastografia = uresultadobiradsmastografia ;
        this.umodalidadmastografiatamizaje = umodalidadmastografiatamizaje;
        this.umodalidadmastografiadiagnostica = umodalidadmastografiadiagnostica;
        this.dfechatomamastografia = dfechatomamastografia;
        this.umastografiaadecuada = umastografiaadecuada;
        this.bolimagenincompleta = bolimagenincompleta;
        this.bolbajocontraste = bolbajocontraste;
        this.bolbajaresolucion = bolbajaresolucion;
        this.bolartefactos = bolartefactos;
        this.bolotros = bolotros;
        this.dfechainterpretacionmastografia = dfechainterpretacionmastografia ;
        this.boltumorderecho = boltumorderecho;
        this.boltumorizquierdo = boltumorizquierdo;
        this.bolasimetriaderecho = bolasimetriaderecho;
        this.bolasimetriaizquierdo = bolasimetriaizquierdo;
        this.boldeformidadderecho = boldeformidadderecho;
        this.boldeformidadizquierdo = boldeformidadizquierdo;
        this.bolcalcificacionderecho = bolcalcificacionderecho;
        this.bolcalcificacionizquierdo = bolcalcificacionizquierdo;
        this.boldensidadasimetricaderecho = boldensidadasimetricaderecho;
        this.boldensidadasimetricaizquierdo = boldensidadasimetricaizquierdo;
        this.bolotrosderecho = bolotrosderecho;
        this.bolotrosizquierdo = bolotrosizquierdo;
        this.uresultadobiradsuno = uresultadobiradsuno;
        this.uresultadobiradsdos = uresultadobiradsdos;
        this.uresultadobiradstres = uresultadobiradstres;
        this.srfcresultadobiradsuno= srfcresultadobiradsuno;
        this.srfcresultadobiradsdos= srfcresultadobiradsdos;
        this.srfcresultadobiradstres= srfcresultadobiradstres;
        this.sobservaciones = sobservaciones;
        this.dfechainformeresultado = dfechainformeresultado;
        this.bolrepeticionestudio = bolrepeticionestudio;
        this.bolrepeticionestudio = bolrepeticionestudio;
        this.bolproximadeteccion = bolproximadeteccion;
        this.bolreferenciaginecologia = bolreferenciaginecologia;
        this.sreferenciaevaluacion = sreferenciaevaluacion;
        this.dfechareferencia = dfechareferencia;
        this.snombreradiologo= snombreradiologo;
        this.srfcradiologo= srfcradiologo;   
        
     }

    /** default constructor */
    public TCuestionarioPacienteInterpretacionPuebla() {
    }

    public java.lang.Integer getKcuestionariopacienteinterpretacionpuebla() {
        return this.kcuestionariopacienteinterpretacionpuebla;
    }

    public void setKcuestionariopacienteinterpretacionpuebla(java.lang.Integer kcuestionariopacienteinterpretacionpuebla) {
        this.kcuestionariopacienteinterpretacionpuebla = kcuestionariopacienteinterpretacionpuebla;
    }

   
    public java.lang.Integer getKordensucursal() {
        return this.kordensucursal;
    }

    public void setKordensucursal(java.lang.Integer kordensucursal) {
        this.kordensucursal = kordensucursal;
    }
    
    public java.lang.String getSinstitucion() {
		return sinstitucion;
	}

	public void setSinstitucion(java.lang.String sinstitucion) {
		this.sinstitucion = sinstitucion;
	}

    public java.lang.String getSlugarnacimiento() {
		return slugarnacimiento;
	}

	public void setSlugarnacimiento(java.lang.String slugarnacimiento) {
		this.slugarnacimiento = slugarnacimiento;
	}

	
	
	public java.lang.String getSentidad() {
		return sentidad;
	}

	public void setSentidad(java.lang.String sentidad) {
		this.sentidad = sentidad;
	}

	public java.lang.String getSclues() {
		return sclues;
	}

	public void setSclues(java.lang.String sclues) {
		this.sclues = sclues;
	}

	public int getUjurisdiccion() {
		return ujurisdiccion;
	}

	public void setUjurisdiccion(int ujurisdiccion) {
		this.ujurisdiccion = ujurisdiccion;
	}

	public java.lang.String getSmunicipio() {
		return smunicipio;
	}

	public void setSmunicipio(java.lang.String smunicipio) {
		this.smunicipio = smunicipio;
	}

	public java.lang.String getSunidadmedica() {
		return sunidadmedica;
	}

	public void setSunidadmedica(java.lang.String sunidadmedica) {
		this.sunidadmedica = sunidadmedica;
	}

	public java.lang.String getSclaveinstitucional() {
		return sclaveinstitucional;
	}

	public void setSclaveinstitucional(java.lang.String sclaveinstitucional) {
		this.sclaveinstitucional = sclaveinstitucional;
	}

	public java.lang.String getScurp() {
		return scurp;
	}

	public void setScurp(java.lang.String scurp) {
		this.scurp = scurp;
	}

	public int getUderechohabiencia() {
		return uderechohabiencia;
	}

	public void setUderechohabiencia(int uderechohabiencia) {
		this.uderechohabiencia = uderechohabiencia;
	}

	public int getUantescedentedemastografia() {
		return uantescedentedemastografia;
	}

	public void setUantescedentedemastografia(int uantescedentedemastografia) {
		this.uantescedentedemastografia = uantescedentedemastografia;
	}

	public java.util.Date getDfechaultimamastografia() {
		return dfechaultimamastografia;
	}

	public void setDfechaultimamastografia(java.util.Date dfechaultimamastografia) {
		this.dfechaultimamastografia = dfechaultimamastografia;
	}

	public int getUresultadobiradsmastografia() {
		return uresultadobiradsmastografia;
	}

	public int getUmodalidadmastografiatamizaje() {
		return umodalidadmastografiatamizaje;
	}

	public void setUmodalidadmastografiatamizaje(
			int umodalidadmastografiatamizaje) {
		this.umodalidadmastografiatamizaje = umodalidadmastografiatamizaje;
	}

	public int getUmodalidadmastografiadiagnostica() {
		return umodalidadmastografiadiagnostica;
	}

	public void setUmodalidadmastografiadiagnostica(
			int umodalidadmastografiadiagnostica) {
		this.umodalidadmastografiadiagnostica = umodalidadmastografiadiagnostica;
	}

	public void setUresultadobiradsmastografia(int uresultadobiradsmastografia) {
		this.uresultadobiradsmastografia = uresultadobiradsmastografia;
	}


	public java.util.Date getDfechatomamastografia() {
		return dfechatomamastografia;
	}

	public void setDfechatomamastografia(java.util.Date dfechatomamastografia) {
		this.dfechatomamastografia = dfechatomamastografia;
	}

	public int getUmastografiaadecuada() {
		return umastografiaadecuada;
	}

	public void setUmastografiaadecuada(int umastografiaadecuada) {
		this.umastografiaadecuada = umastografiaadecuada;
	}

	public boolean isBolimagenincompleta() {
		return bolimagenincompleta;
	}

	public void setBolimagenincompleta(boolean bolimagenincompleta) {
		this.bolimagenincompleta = bolimagenincompleta;
	}

	public boolean isBolbajocontraste() {
		return bolbajocontraste;
	}

	public void setBolbajocontraste(boolean bolbajocontraste) {
		this.bolbajocontraste = bolbajocontraste;
	}

	public boolean isBolbajaresolucion() {
		return bolbajaresolucion;
	}

	public void setBolbajaresolucion(boolean bolbajaresolucion) {
		this.bolbajaresolucion = bolbajaresolucion;
	}

	public boolean isBolartefactos() {
		return bolartefactos;
	}

	public void setBolartefactos(boolean bolartefactos) {
		this.bolartefactos = bolartefactos;
	}

	public boolean isBolmalposicionamiento() {
		return bolmalposicionamiento;
	}

	public void setBolmalposicionamiento(boolean bolmalposicionamiento) {
		this.bolmalposicionamiento = bolmalposicionamiento;
	}

	public boolean isBolotros() {
		return bolotros;
	}

	public void setBolotros(boolean bolotros) {
		this.bolotros = bolotros;
	}

	public java.util.Date getDfechainterpretacionmastografia() {
		return dfechainterpretacionmastografia;
	}

	public void setDfechainterpretacionmastografia(
			java.util.Date dfechainterpretacionmastografia) {
		this.dfechainterpretacionmastografia = dfechainterpretacionmastografia;
	}

	public boolean isBoltumorderecho() {
		return boltumorderecho;
	}

	public void setBoltumorderecho(boolean boltumorderecho) {
		this.boltumorderecho = boltumorderecho;
	}

	public boolean isBoltumorizquierdo() {
		return boltumorizquierdo;
	}

	public void setBoltumorizquierdo(boolean boltumorizquierdo) {
		this.boltumorizquierdo = boltumorizquierdo;
	}

	public boolean isBolasimetriaderecho() {
		return bolasimetriaderecho;
	}

	public void setBolasimetriaderecho(boolean bolasimetriaderecho) {
		this.bolasimetriaderecho = bolasimetriaderecho;
	}

	public boolean isBolasimetriaizquierdo() {
		return bolasimetriaizquierdo;
	}

	public void setBolasimetriaizquierdo(boolean bolasimetriaizquierdo) {
		this.bolasimetriaizquierdo = bolasimetriaizquierdo;
	}

	public boolean isBoldeformidadderecho() {
		return boldeformidadderecho;
	}

	public void setBoldeformidadderecho(boolean boldeformidadderecho) {
		this.boldeformidadderecho = boldeformidadderecho;
	}

	public boolean isBoldeformidadizquierdo() {
		return boldeformidadizquierdo;
	}

	public void setBoldeformidadizquierdo(boolean boldeformidadizquierdo) {
		this.boldeformidadizquierdo = boldeformidadizquierdo;
	}

	public boolean isBolcalcificacionderecho() {
		return bolcalcificacionderecho;
	}

	public void setBolcalcificacionderecho(boolean bolcalcificacionderecho) {
		this.bolcalcificacionderecho = bolcalcificacionderecho;
	}

	public boolean isBolcalcificacionizquierdo() {
		return bolcalcificacionizquierdo;
	}

	public void setBolcalcificacionizquierdo(boolean bolcalcificacionizquierdo) {
		this.bolcalcificacionizquierdo = bolcalcificacionizquierdo;
	}

	public boolean isBoldensidadasimetricaderecho() {
		return boldensidadasimetricaderecho;
	}

	public void setBoldensidadasimetricaderecho(boolean boldensidadasimetricaderecho) {
		this.boldensidadasimetricaderecho = boldensidadasimetricaderecho;
	}

	public boolean isBoldensidadasimetricaizquierdo() {
		return boldensidadasimetricaizquierdo;
	}

	public void setBoldensidadasimetricaizquierdo(boolean boldensidadasimetricaizquierdo) {
		this.boldensidadasimetricaizquierdo = boldensidadasimetricaizquierdo;
	}

	public boolean isBolotrosderecho() {
		return bolotrosderecho;
	}

	public void setBolotrosderecho(boolean bolotrosderecho) {
		this.bolotrosderecho = bolotrosderecho;
	}

	public boolean isBolotrosizquierdo() {
		return bolotrosizquierdo;
	}

	public void setBolotrosizquierdo(boolean bolotrosizquierdo) {
		this.bolotrosizquierdo = bolotrosizquierdo;
	}

	public int getUresultadobiradsuno() {
		return uresultadobiradsuno;
	}

	public void setUresultadobiradsuno(int uresultadobiradsuno) {
		this.uresultadobiradsuno = uresultadobiradsuno;
	}

	public int getUresultadobiradsdos() {
		return uresultadobiradsdos;
	}

	public void setUresultadobiradsdos(int uresultadobiradsdos) {
		this.uresultadobiradsdos = uresultadobiradsdos;
	}

	public int getUresultadobiradstres() {
		return uresultadobiradstres;
	}

	public void setUresultadobiradstres(int uresultadobiradstres) {
		this.uresultadobiradstres = uresultadobiradstres;
	}

	public java.lang.String getSrfcresultadobiradsuno() {
		return srfcresultadobiradsuno;
	}

	public void setSrfcresultadobiradsuno(java.lang.String srfcresultadobiradsuno) {
		this.srfcresultadobiradsuno = srfcresultadobiradsuno;
	}

	public java.lang.String getSrfcresultadobiradsdos() {
		return srfcresultadobiradsdos;
	}

	public void setSrfcresultadobiradsdos(java.lang.String srfcresultadobiradsdos) {
		this.srfcresultadobiradsdos = srfcresultadobiradsdos;
	}

	public java.lang.String getSrfcresultadobiradstres() {
		return srfcresultadobiradstres;
	}

	public void setSrfcresultadobiradstres(java.lang.String srfcresultadobiradstres) {
		this.srfcresultadobiradstres = srfcresultadobiradstres;
	}

	public java.lang.String getSobservaciones() {
		return sobservaciones;
	}

	public void setSobservaciones(java.lang.String sobservaciones) {
		this.sobservaciones = sobservaciones;
	}

	public java.util.Date getDfechainformeresultado() {
		return dfechainformeresultado;
	}

	public void setDfechainformeresultado(java.util.Date dfechainformeresultado) {
		this.dfechainformeresultado = dfechainformeresultado;
	}

	public boolean isBolrepeticionestudio() {
		return bolrepeticionestudio;
	}

	public void setBolrepeticionestudio(boolean bolrepeticionestudio) {
		this.bolrepeticionestudio = bolrepeticionestudio;
	}

	public boolean isBolproximadeteccion() {
		return bolproximadeteccion;
	}

	public void setBolproximadeteccion(boolean bolproximadeteccion) {
		this.bolproximadeteccion = bolproximadeteccion;
	}

	public boolean isBolreferenciaginecologia() {
		return bolreferenciaginecologia;
	}

	public void setBolreferenciaginecologia(boolean bolreferenciaginecologia) {
		this.bolreferenciaginecologia = bolreferenciaginecologia;
	}

	public java.lang.String getSreferenciaevaluacion() {
		return sreferenciaevaluacion;
	}

	public void setSreferenciaevaluacion(java.lang.String sreferenciaevaluacion) {
		this.sreferenciaevaluacion = sreferenciaevaluacion;
	}

	public java.util.Date getDfechareferencia() {
		return dfechareferencia;
	}

	public void setDfechareferencia(java.util.Date dfechareferencia) {
		this.dfechareferencia = dfechareferencia;
	}

	public java.lang.String getSnombreradiologo() {
		return snombreradiologo;
	}

	public void setSnombreradiologo(java.lang.String snombreradiologo) {
		this.snombreradiologo = snombreradiologo;
	}

	public java.lang.String getSrfcradiologo() {
		return srfcradiologo;
	}

	public void setSrfcradiologo(java.lang.String srfcradiologo) {
		this.srfcradiologo = srfcradiologo;
	}

  
    public String toString() {
        return new ToStringBuilder(this)
            .append("kcuestionariopacienteinterpretacionpuebla", getKcuestionariopacienteinterpretacionpuebla())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TCuestionarioPacienteInterpretacionPuebla) ) return false;
        TCuestionarioPacienteInterpretacionPuebla castOther = (TCuestionarioPacienteInterpretacionPuebla) other;
        return new EqualsBuilder()
            .append(this.getKcuestionariopacienteinterpretacionpuebla(), castOther.getKcuestionariopacienteinterpretacionpuebla())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKcuestionariopacienteinterpretacionpuebla())
            .toHashCode();
    }

		
}
