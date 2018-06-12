package mx.com.web2lab.backend.beans.puebla;

import java.util.Date;


import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.util.Formatos;


public class CuestionarioPantallaInterpretacionBean {
	private int kcuestionariopacienteinterpretacionpuebla;	
	private int kordensucursal;	
	private String sentidadnacimiento;
	private String sinstitucion;
	private String sentidad;
	private String sclues;
	private int ujurisdiccion;	
	private String smunicipio;
	private String sunidadmedica;
	private String sclaveinstitucional;
	private String scurp;
	private int uderechohabiencia;
	private int uantescedentedemastografia;	
    private java.util.Date dfechaultimamastografia = new Date();
    private String sfechaultimamastografia = "";
    private int uresultadobiradsmastografia;
    private int umodalidadmastografiatamizaje;
    private int umodalidadmastografiadiagnostica;
    private java.util.Date dfechatomamastografia;
    private String sfechatomamastografia = "";
    private int umastografiaadecuada;
    private boolean bolimagenincompleta;
    private boolean bolbajocontraste;
    private boolean bolbajaresolucion;
    private boolean bolartefactos;
    private boolean bolmalposcicionamiento;
    private boolean bolotros;
    private java.util.Date dfechainterpretacionmastografia;
    private String sfechainterpretacionmastografia = "";
    private boolean boltumorderecho;
    private boolean boltumorizquierdo;
    private boolean bolasimetriaderecho;
    private boolean bolasimetriaizquierdo;
    private boolean boldeformidadderecho;
    private boolean boldeformidadizquierdo;
    private boolean bolcalcificacionderecho;
    private boolean bolcalcificacionizquierdo;
    private boolean boldensidadasimetricaderecho;
    private boolean boldensidadasimetricaizquierdo;
    private boolean bolotrosderecho;
    private boolean bolotrosizquierdo;
    private int uresultadobiradsuno;
    private int uresultadobiradsdos;
    private int uresultadobiradstres;
    private String srfcresultadobiradsuno;
    private String srfcresultadobiradsdos;
    private String srfcresultadobiradstres;
    private String sobservaciones;
    private java.util.Date dfechainformeresultado;
    private String sfechainformeresultado = "";
    private boolean bolrepeticionestudio;
    private boolean bolproximadeteccion;
    private boolean bolreferenciaginecologia;
    private String sreferenciaevaluacion;
    private java.util.Date dfechareferencia;
    private String sfechareferencia = "";
    private java.lang.String snombreradiologo;
    private java.lang.String srfcradiologo;
    private String smensajeoperacion = "";
    private String slugarnacimiento = "";
    private OrdenBean objOrdenBean;
    
    
	public int getKcuestionariopacienteinterpretacionpuebla() {
		return kcuestionariopacienteinterpretacionpuebla;
	}
	public void setKcuestionariopacienteinterpretacionpuebla(
			int kcuestionariopacienteinterpretacionpuebla) {
		this.kcuestionariopacienteinterpretacionpuebla = kcuestionariopacienteinterpretacionpuebla;
	}
	public int getKordensucursal() {
		return kordensucursal;
	}
	public void setKordensucursal(int kordensucursal) {
		this.kordensucursal = kordensucursal;
	}
	
	public String getSinstitucion() {
		return sinstitucion;
	}
	public void setSinstitucion(String sinstitucion) {
		this.sinstitucion = sinstitucion;
	}
	public String getSentidad() {
		return sentidad;
	}
	public void setSentidad(String sentidad) {
		this.sentidad = sentidad;
	}
	public String getSclues() {
		return sclues;
	}
	public void setSclues(String sclues) {
		this.sclues = sclues;
	}
	public int getUjurisdiccion() {		
		return ujurisdiccion;
	}
	public String getsjuridiccion() {
		String sJuridiccion = "";
		switch (this.ujurisdiccion) {
			case 0: {
				sJuridiccion = "NO INDICADO";
				break;
			}
			case 1: {
				sJuridiccion = "01 HUAUCHINANGO";
				break;
			}
			case 2: {
				sJuridiccion = "02 CHIGNAUAPAN";
				break;
			}
			case 3: {
				sJuridiccion = "03 ZACAPOAXTLA";
				break;
			}
			case 4: {
				sJuridiccion = "04 LIBRES";
				break;
			}
			case 5: {
				sJuridiccion = "05 CHOLULA";
				break;
			}
			case 6: {
				sJuridiccion = "06 PUEBLA";
				break;
			}
			case 7: {
				sJuridiccion = "07 IZUCAR";
				break;
			}
			case 8: {
				sJuridiccion = "08 ACATLAN";
				break;
			}
			case 9: {
				sJuridiccion = "09 TEPEACA";
				break;
			}
			case 10: {
				sJuridiccion = "10 TEHUACAN";
				break;
			}
		}
		return sJuridiccion;
	}
	public void setUjurisdiccion(int ujurisdiccion) {
		this.ujurisdiccion = ujurisdiccion;
	}
	public String getSmunicipio() {
		return smunicipio;
	}
	public void setSmunicipio(String smunicipio) {
		this.smunicipio = smunicipio;
	}
	public String getSunidadmedica() {
		return sunidadmedica;
	}
	public void setSunidadmedica(String sunidadmedica) {
		this.sunidadmedica = sunidadmedica;
	}
	public String getSclaveinstitucional() {
		return sclaveinstitucional;
	}
	public void setSclaveinstitucional(String sclaveinstitucional) {
		this.sclaveinstitucional = sclaveinstitucional;
	}
	public String getScurp() {
		return scurp;
	}
	public void setScurp(String scurp) {
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
	public void setUresultadobiradsmastografia(int uresultadobiradsmastografia) {
		this.uresultadobiradsmastografia = uresultadobiradsmastografia;
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
	public boolean isBolmalposcicionamiento() {
		return bolmalposcicionamiento;
	}
	public void setBolmalposcicionamiento(boolean bolmalposcicionamiento) {
		this.bolmalposcicionamiento = bolmalposcicionamiento;
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
	public void setBoldensidadasimetricaizquierdo(
			boolean boldensidadasimetricaizquierdo) {
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
	public String getSrfcresultadobiradsuno() {
		return srfcresultadobiradsuno;
	}
	public void setSrfcresultadobiradsuno(String srfcresultadobiradsuno) {
		this.srfcresultadobiradsuno = srfcresultadobiradsuno;
	}
	public String getSrfcresultadobiradsdos() {
		return srfcresultadobiradsdos;
	}
	public void setSrfcresultadobiradsdos(String srfcresultadobiradsdos) {
		this.srfcresultadobiradsdos = srfcresultadobiradsdos;
	}
	public String getSrfcresultadobiradstres() {
		return srfcresultadobiradstres;
	}
	public void setSrfcresultadobiradstres(String srfcresultadobiradstres) {
		this.srfcresultadobiradstres = srfcresultadobiradstres;
	}
	public String getSobservaciones() {
		return sobservaciones;
	}
	public void setSobservaciones(String sobservaciones) {
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
	public String getSreferenciaevaluacion() {
		return sreferenciaevaluacion;
	}
	public void setSreferenciaevaluacion(String sreferenciaevaluacion) {
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
	public String getSentidadnacimiento() {
		return sentidadnacimiento;
	}
	public void setSentidadnacimiento(String sentidadnacimiento) {
		this.sentidadnacimiento = sentidadnacimiento;
	}
	public String getSfechaultimamastografia() {
		return sfechaultimamastografia;
	}
	public void setSfechaultimamastografia(String sfechaultimamastografia) {
		this.sfechaultimamastografia = sfechaultimamastografia;
	}
	public String getSfechatomamastografia() {
		return sfechatomamastografia;
	}
	public void setSfechatomamastografia(String sfechatomamastografia) {
		this.sfechatomamastografia = sfechatomamastografia;
	}
	public String getSfechainterpretacionmastografia() {
		return sfechainterpretacionmastografia;
	}
	public void setSfechainterpretacionmastografia(
			String sfechainterpretacionmastografia) {
		this.sfechainterpretacionmastografia = sfechainterpretacionmastografia;
	}
	public String getSfechainformeresultado() {
		return sfechainformeresultado;
	}
	public void setSfechainformeresultado(String sfechainformeresultado) {
		this.sfechainformeresultado = sfechainformeresultado;
	}
	public String getSfechareferencia() {
		return sfechareferencia;
	}
	public void setSfechareferencia(String sfechareferencia) {
		this.sfechareferencia = sfechareferencia;
	}

	public String resultFOPValidaBoolean(boolean bolValidar, String strLeft_AND_TOP) {
		String strReturn = "";
		if (bolValidar) {
			strReturn = "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='0.44cm' " + strLeft_AND_TOP + " position='absolute'>  \n"+
						"			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">	 																										\n"+
						"				X						  																																\n"+
						"			</fo:block>																																					\n"+
						"      </fo:block-container> 																																			\n" ;
		} else {
			strReturn = "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='0.44cm' " + strLeft_AND_TOP + " position='absolute'> 	\n"+
					    "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">																											\n"+
					   	"			 																																							\n"+
					    "			</fo:block>																																					\n"+
					    "      </fo:block-container> 																																			\n" ;
		}
		return strReturn;
	}
	
	public String resultFOPValidaBooleanHallazgo(boolean bolValidar,String strheight, String strLeft_AND_TOP) {
		String strReturn = "";
		if (bolValidar) {
			strReturn = "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt'"+strheight+ " width='0.88cm' " + strLeft_AND_TOP + " position='absolute'>  \n"+
						"			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">	 																										\n"+
						"				X						  																																\n"+
						"			</fo:block>																																					\n"+
						"      </fo:block-container> 																																			\n" ;
		} else {
			strReturn = "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' "+strheight+ " width='0.88cm' " + strLeft_AND_TOP + " position='absolute'> 	\n"+
					    "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">																											\n"+
					   	"			 																																							\n"+
					    "			</fo:block>																																					\n"+
					    "      </fo:block-container> 																																			\n" ;
		}
		return strReturn;
	}

	public String resultFOPValidaNumeric(boolean bolValidar, String strLeft_AND_TOP) {
		String strReturn = "";
		if (bolValidar) {
			strReturn = "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='0.55cm' " + strLeft_AND_TOP + " position='absolute'>  \n"+
						"			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">	 																										\n"+
						"				1						  																																\n"+
						"			</fo:block>																																					\n"+
						"      </fo:block-container> 																																			\n" ;
		} else {
			strReturn = "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='0.55cm' " + strLeft_AND_TOP + " position='absolute'> 	\n"+
					    "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">																											\n"+
					   	"			 	2																																						\n"+
					    "			</fo:block>																																					\n"+
					    "      </fo:block-container> 																																			\n" ;
		}
		return strReturn;
	}
		
	public String resultFOPValidaSIvsNO(int intValor, String strLeft_AND_TOP) {
		String strReturn = "";
		if (intValor <= 0) {
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='1cm' " + strLeft_AND_TOP + " position='absolute'>	\n"+
						"			<fo:block font-size=\"7pt\"  font-weight=\"bold\">																											\n"+
						  					" 																																					\n"+
						"			</fo:block>																																					\n"+
						"      </fo:block-container> 																																			\n" ;		
		} else {
			strReturn = "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='1cm' " + strLeft_AND_TOP + " position='absolute'>   \n"+
					"			<fo:block font-size=\"7pt\"  text-align='center' font-weight=\"bold\">"+" \n"+
					    				intValor+"																																				\n"+
					    "			</fo:block>																																					\n"+
					    "      </fo:block-container>																																			\n" ;
		}
		return strReturn;
	}
	
	public String resultFOPValidaBirads(int intValor, String strHeight_Width_Left_AND_TOP) {
		String strReturn = "";
		if (intValor < 0) {
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt'  " + strHeight_Width_Left_AND_TOP + " position='absolute'>	\n"+
						"			<fo:block font-size=\"7pt\"  font-weight=\"bold\">																											\n"+
						  					" 																																					\n"+
						"			</fo:block>																																					\n"+
						"      </fo:block-container> 																																			\n" ;		
		} else {
			strReturn = "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt'  " + strHeight_Width_Left_AND_TOP + " position='absolute'>   \n"+
					"			<fo:block font-size=\"7pt\"  text-align='center' font-weight=\"bold\">"+" \n"+
					    				intValor+"																																				\n"+
					    "			</fo:block>																																					\n"+
					    "      </fo:block-container>																																			\n" ;
		}
		return strReturn;
	}
	
	public String resultFirma( String strRFC,String sHttpPath) {
		String strReturn = "";
		if (strRFC.equals("VIAY661001")) {
			strReturn =	"	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='4cm' width='20.4cm' top='21.73cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                        "                       <fo:external-graphic width='100pt' height='80pt' content-width='100pt' content-height='100pt' overflow='hidden' src = '" + sHttpPath + "DraYennys002-Line03.jpg' />                                      \n" +  
                        "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
			        		
		} else if(strRFC.equals("PERL680510")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='4cm' width='20.4cm' top='21.43cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                        "                       <fo:external-graphic width='90pt' height='40pt' content-width='60pt' content-height='50pt' overflow='hidden' src = '" + sHttpPath + "DrLuisPeraza002-line06.jpg' />                                      \n" +  
                        "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
			        
		}else if(strRFC.equals("AASA700616")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.12cm' left='14.9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
	                    "                       <fo:external-graphic width='80pt' height='38pt' content-width='63pt' content-height='39pt' overflow='hidden' src = '" + sHttpPath + "DrAlbrant001-Line03.jpg' />                                      \n" +  
	                    "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
	                    "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
			
		} else if(strRFC.equals("AESJ680905")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='4cm' width='20.4cm' top='21.22cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                        "                       <fo:external-graphic width='90pt' height='40pt' content-width='60pt' content-height='55pt' overflow='hidden' src = '" + sHttpPath + "DrJorgeArrellano001-line01.jpg' />                                      \n" +  
                        "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
		} else if(strRFC.equals("ROSC540105")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='200pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='4cm' width='20.4cm' top='21.56cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                        "                       <fo:external-graphic width='95pt' height='45pt' content-width='70pt' content-height='60pt' overflow='hidden' src = '" + sHttpPath + "DrCarlosRosas001-line01.jpg' />                                      \n" +  
                        "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
			        
		} else if(strRFC.equals("COCE740211")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='20.15cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='4cm' width='20.4cm' top='21.21cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                        "                       <fo:external-graphic width='95pt' height='42pt' content-width='65pt' content-height='42pt' overflow='hidden' src = '" + sHttpPath + "DrEdgarContreras001-line01.jpg' />                                      \n" +  
                        "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
		} else if(strRFC.equals("VEGL680928")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='4cm' width='20.4cm' top='21.43cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                        "                       <fo:external-graphic width='90pt' height='40pt' content-width='65pt' content-height='55pt' overflow='hidden' src = '" + sHttpPath + "DrLuisVega001-line01.jpg' />                                      \n" +  
                        "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
		} else if(strRFC.equals("MOMM610702")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='150pt' height='100pt' content-width='500pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='30pt' height='100pt' content-width='500pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='4cm' width='20.4cm' top='21.12cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                        "                       <fo:external-graphic width='90pt' height='50pt' content-width='75pt' content-height='65pt' overflow='hidden' src = '" + sHttpPath + "DrMarthaMorales001-line01.jpg' />                                      \n" +  
                        "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
		} else if(strRFC.equals("GURC561122")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.57cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='150pt' height='100pt' content-width='500pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='30pt' height='100pt' content-width='500pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='4cm' width='20.4cm' top='21.15cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                        "                       <fo:external-graphic width='90pt' height='50pt' content-width='75pt' content-height='63pt' overflow='hidden' src = '" + sHttpPath + "DrCecilioGuzman001-Line02.jpg' />                                      \n" +  
                        "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;	        	        
		} else if(strRFC.equals("RULR631020")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='19.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
						"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
						"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='4cm' width='20.4cm' top='21.23cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                        "                       <fo:external-graphic width='90pt' height='40pt' content-width='65pt' content-height='55pt' overflow='hidden' src = '" + sHttpPath + "DraIleanaRuiz001-Line01.jpg' />                                      \n" +  
                        "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;	
		} else if(strRFC.equals("MESH461205")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='19.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
					"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
					"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
					"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
					"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
					"      <fo:block-container  height='4cm' width='20.4cm' top='21.56cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                    "                       <fo:external-graphic width='100pt' height='80pt' content-width='100pt' content-height='100pt' overflow='hidden' src = '" + sHttpPath + "DrHectorMendoza002-Line01.jpg' />                                      \n" +  
                    "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;	
		} else if(strRFC.equals("SAHP780907")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='19.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
					"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
					"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
					"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
					"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
					"      <fo:block-container  height='4cm' width='20.4cm' top='21.56cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                    "                       <fo:external-graphic width='100pt' height='80pt' content-width='100pt' content-height='100pt' overflow='hidden' src = '" + sHttpPath + "DrPerlaSanchez001-Line01.jpg' />                                      \n" +  
                    "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;	
		} else if(strRFC.equals("GAHG650903")) {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='19.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
					"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
					"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
					"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
					"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
					"      <fo:block-container  height='4cm' width='20.4cm' top='21.56cm' left='14.6cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                    "                       <fo:external-graphic width='100pt' height='80pt' content-width='100pt' content-height='100pt' overflow='hidden' src = '" + sHttpPath + "DrGerardoGarcia001-Line01.jpg' />                                      \n" +  
                    "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;	
		} else  {
			strReturn = "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21.55cm' left='9cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"           <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
					"                <fo:external-graphic width='210pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  "	   <fo:block-container  height='0.35cm' width='0.55cm' top='21cm' left='16.15cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
					"                       <fo:external-graphic width='40pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
					"                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
					"          </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
					"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
					"	   <fo:block-container  height='0.35cm' width='0.55cm' top='22.23cm' left='14.3cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					"                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
                    "                       <fo:external-graphic width='60pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
                    "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
                    "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
	        
		}
	
			return strReturn;
	}	
	

	
	public String resultFOPValidaTamizajeDiagnostica(int intValor, String strLeft_AND_TOP) {
		String strReturn = "";
		if (intValor <= 0) {
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1cm' " + strLeft_AND_TOP + " position='absolute'>	\n"+
						"			<fo:block font-size=\"7pt\"  font-weight=\"bold\">																											\n"+
						  					" 																																					\n"+
						"			</fo:block>																																					\n"+
						"      </fo:block-container> 																																			\n" ;		
		} else {
			strReturn = "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1cm' " + strLeft_AND_TOP + " position='absolute'>   \n"+
					"			<fo:block font-size=\"7pt\"  text-align='center' font-weight=\"bold\">"+" \n"+
					    				intValor+"																																				\n"+
					    "			</fo:block>																																					\n"+
					    "      </fo:block-container>																																			\n" ;
		}
		return strReturn;
	}
	
	public String resultFOPValidaFecha(Date objDate,Formatos objFormatos,String strLeft[], String strTop) {
		String strReturn = "";
		if(objDate.getYear()==81) {
			strReturn =   "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1.5cm' " + strTop + " " + strLeft[0] + " position='absolute'>	\n"+
						  "			<fo:block font-size=\"6pt\"  font-weight=\"bold\">																														\n"+
						  				" 																																									\n"+
						  "			</fo:block>																																								\n"+
						  "      </fo:block-container>																																						\n"+
						  "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1.5cm' " + strTop + " " + strLeft[1] + " position='absolute'>	\n"+
						  "			<fo:block font-size=\"6pt\"  font-weight=\"bold\">																														\n"+
						  				" 																																									\n"+
						  "			</fo:block>																																								\n"+
						  "      </fo:block-container>																																						\n"+
						  "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1.5cm' " + strTop + " " + strLeft[2] + " position='absolute'>	\n"+
						  "			<fo:block font-size=\"6pt\"  font-weight=\"bold\">																														\n"+
						  				" 																																									\n"+
						  "			</fo:block>																																								\n"+
						  "    </fo:block-container>																																						\n";
			
		} else {
			strReturn=	  "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1.5cm' " + strTop + " " + strLeft[0] + " position='absolute'>				\n"+
									  "			<fo:block font-size=\"6pt\" text-align='center' font-weight=\"bold\">																														\n"+
									  					objFormatos.getFechaNumeros(objDate).substring(0,2)+"																											\n"+
									  "			</fo:block>																																								\n"+
									  "      </fo:block-container>																																						\n"+
									  "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1.5cm' " + strTop + " " + strLeft[1] + " position='absolute'>	\n"+
									  "			<fo:block font-size=\"6pt\" text-align='center' font-weight=\"bold\">																														\n"+
														objFormatos.getFechaNumeros(objDate).substring(3,5)+"																											\n"+
									  "			</fo:block>																																								\n"+
									  "      </fo:block-container>																																						\n"+
									  "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1.5cm'  " + strTop + " " + strLeft[2] + " position='absolute'>	\n"+
									  "			<fo:block font-size=\"6pt\" text-align='center' font-weight=\"bold\">																														\n"+
														objFormatos.getFechaNumeros(objDate).substring(6,10)+"																											\n"+
									  "			</fo:block>																																								\n"+
									  "      </fo:block-container>																																						\n";
		}
		return strReturn;
	}
	

	public String resultFOPValidaDatoDF(int intValor, String strTop) {
		String strReturn = "";
		if (intValor <= 0) {
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' "+strTop +" left='15.26cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
										" "+"\n"+
						"			</fo:block>"+"\n"+
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
			
		} else {
			strReturn ="	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' "+strTop +" left='15.26cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					   "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
					   				intValor+"\n"+
					   "			</fo:block>"+"\n"+
					   "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
	
		}
		return strReturn;
	}
	
	public String resultFOPValidaDatoOtrosDF(boolean bValor, String strTop) {
		String strReturn = "";
		if (bValor) {
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' "+strTop +" left='15.26cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
									"1 "+"\n"+
						"			</fo:block>"+"\n"+
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
			
		} else if(!bValor) {
			strReturn ="	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' "+strTop +" left='15.26cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					   "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
					   " 			2"+"\n"+
					   "			</fo:block>"+"\n"+
					   "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
			
		} else {strReturn ="	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' "+strTop +" left='15.26cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					   	   "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
					   	   " 			"+"\n"+
					   	   "			</fo:block>"+"\n"+
					   	   "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
				
		}
		return strReturn;
	}
	
	public String resultFOPValidaMastoAdecuadaDF(CuestionarioPantallaInterpretacionBean objCuestionarioPantallaInterpretacion) {
		String strReturn = "";
		if (objCuestionarioPantallaInterpretacion.isBolimagenincompleta()) {
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' top='10.09cm' left='16.68cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
					    "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
					    " 				1 "+"\n"+
					    "			</fo:block>"+"\n"+
					    "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;

			
		} else if(objCuestionarioPantallaInterpretacion.isBolbajocontraste()){
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' top='10.09cm' left='16.68cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
				        "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
				        " 				2 "+"\n"+
				        "			</fo:block>"+"\n"+
				        "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;

		} else if(objCuestionarioPantallaInterpretacion.isBolbajaresolucion()){
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' top='10.09cm' left='16.68cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
				        "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
				        " 				3 "+"\n"+
				        "			</fo:block>"+"\n"+
				        "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;

		} else if(objCuestionarioPantallaInterpretacion.isBolartefactos()){
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' top='10.09cm' left='16.68cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
				        "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
				        " 				4 "+"\n"+
				        "			</fo:block>"+"\n"+
				        "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
		} else if(objCuestionarioPantallaInterpretacion.isBolmalposcicionamiento()){
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' top='10.09cm'  left='16.68cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
				        "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
				        " 				5 "+"\n"+
				        "			</fo:block>"+"\n"+
				        "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;

		} else if(objCuestionarioPantallaInterpretacion.isBolotros()){
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' top='10.09cm'  left='16.68cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
				        "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
				        " 				6 "+"\n"+
				        "			</fo:block>"+"\n"+
				        "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;

		} else {
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' top='10.09cm'  left='16.68cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
			        "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
			        " 				 "+"\n"+
			        "			</fo:block>"+"\n"+
			        "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;

			
		}
	
		return strReturn;
	}
	
	public String resultFOPValidaTamizajeDiagnosticaDF(int intValorTamizaje, int intValorDiagnostica) {
		String strReturn = "";
		if (intValorTamizaje > 0) {
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' top='8.13cm' left='15.26cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
										intValorTamizaje+"\n"+
						"			</fo:block>"+"\n"+
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
			
		} else {
			strReturn =	"	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.46cm' width='0.88cm' top='8.13cm' left='15.26cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
										intValorDiagnostica+"\n"+
						"			</fo:block>"+"\n"+
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
	}
		return strReturn;
	}
	
	public String resultFOPValidaFechaDF(Date objDate,Formatos objFormatos,String strLeft[], String strTop) {
		String strReturn = "";
		if(objDate.getYear()==81) {
			strReturn =   "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1cm' " + strTop + " " + strLeft[0] + " position='absolute'>	\n"+
						  "			<fo:block font-size=\"6pt\"  font-weight=\"bold\">																														\n"+
						  				" 																																									\n"+
						  "			</fo:block>																																								\n"+
						  "      </fo:block-container>																																						\n"+
						  "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1cm' " + strTop + " " + strLeft[1] + " position='absolute'>	\n"+
						  "			<fo:block font-size=\"6pt\"  font-weight=\"bold\">																														\n"+
						  				" 																																									\n"+
						  "			</fo:block>																																								\n"+
						  "      </fo:block-container>																																						\n"+
						  "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='0.9cm' " + strTop + " " + strLeft[2] + " position='absolute'>	\n"+
						  "			<fo:block font-size=\"6pt\"  font-weight=\"bold\">																														\n"+
						  				" 																																									\n"+
						  "			</fo:block>																																								\n"+
						  "    </fo:block-container>																																						\n";
			
		} else {
			strReturn=	 "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1cm' " +  strTop + " " + strLeft[0] + " position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						 "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
						 				objFormatos.getFechaNumeros(objDate).substring(0, 2)+"\n"+
						 "			</fo:block>"+"\n"+
						 "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						 "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='1cm' "+  strTop + " " + strLeft[1] + " position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						 "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
						 				objFormatos.getFechaNumeros(objDate).substring(3, 5)+"\n"+
						 "			</fo:block>"+"\n"+
						 "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						 "	   <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.45cm' width='0.9cm' "+  strTop + " " + strLeft[2] + " position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						 "			<fo:block font-size=\"7pt\" text-align='center' font-weight=\"bold\">"+" \n"+
						 				objFormatos.getFechaNumeros(objDate).substring(8, 10)+"\n"+
						 "			</fo:block>"+"\n"+
						 "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" ;
		}
		return strReturn;
	}
	

	public String getSlugarnacimiento() {
		return slugarnacimiento;
	}
	public void setSlugarnacimiento(String slugarnacimiento) {
		this.slugarnacimiento = slugarnacimiento;
	}
	
}
