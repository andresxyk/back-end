package mx.com.web2lab.backend.beans.ap;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** @author Hibernate CodeGenerator */
public class OrdenExamenBean implements Serializable {

	private static Log iObjLog = LogFactory.getLog(OrdenExamenBean.class);
	
    /** identifier field */
    private java.lang.Integer kordenexamensucursal = new Integer(0);

    private java.lang.Integer kconveniodetalle = new Integer(0);
    
    /** nullable persistent field */
    private int cexamen;
    
    /** nullable persistent field */
    private java.lang.String sexamen;

    private short uvolumenexamen;
    
    /** nullable persistent field */
    private double msubtotal = 0.0;

    /** nullable persistent field */
    private double mdescuentopromocion = 0.0;

    /** nullable persistent field */
    private double pdescuentopromocion = 0.0;
    
    /** nullable persistent field */
    private double mdescuentoempresa = 0.0;

    /** nullable persistent field */
    private double pdescuentoempresa = 0.0;    
    
    /** nullable persistent field */
    private double mdescuentomedico = 0.0;

    /** nullable persistent field */
    private double pdescuentomedico = 0.0;
    
    /** nullable persistent field */
    private double mfacturaempresa = 0.0;

    /** nullable persistent field */
    private double mpagopaciente = 0.0;

    /** nullable persistent field */
    private double miva = 0.0;

    /** nullable persistent field */
    private double mtotal = 0.0;

    /** identifier field */
    private int umuestra = 0;    
    
    /** persistent field */
    private double userid = 0.0;

    /** nullable persistent field */
    private java.util.Date dresultadoentrega;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private int kpromocion;

    /** nullable persistent field */
    private java.lang.String smotivocancelacion;

    /** persistent field */
    private int cestadoregistro;

    /** persistent field */
    private int clugarprocesamiento;
    
    private int udiasproceso;

    private String sobservaciones = "";
    
    private int cperfil = 0;
    
    private String sperfil = "";
    
    /** persistent field */
    private int cconvenio = 0;
    
    private int ctipocomercial = 0;
    
    private String stipocomercial = "";

    private int cclasificacioncomercial = 0;

    private String sclasificacioncomercial = "";
    
    private boolean bolnewExamen = false;

    private int csucursal = 0;
    
    private int cindicacionpaciente = 0;
    
    private String sindicacionpaciente = "";
    
    private int ctipomuestra = 0;
    
    private String stipomuestra = "";
    
    private int cinsumo = 0;
    
    private String sinsumo = "";
    
    private int cindicaciontomador = 0;
    
    private String sindicaciontomador = "";
    
    private int ctemperaturamuestra = 0;
    
    private String stemperaturamuestra = "";
    
    private int cmotivorechazo = 0;

    private String smotivorechazo = "";
    
    private int clistapublico = 0;

    private boolean bolListaPublico;

    private java.util.Date dtomamuestrainicio;

    private java.util.Date dtomamuestratermino;
    
    private java.lang.String slogin_name;    
    
    
    public OrdenExamenBean () {
    }    
    
    public OrdenExamenBean (String strExamen) {
    	this.sexamen = strExamen;
    }    
    
	public java.lang.Integer getKordenexamensucursal() {
		return kordenexamensucursal;
	}

	public void setKordenexamensucursal(java.lang.Integer kordenexamensucursal) {
		this.kordenexamensucursal = kordenexamensucursal;
	}

	public int getCexamen() {
		return cexamen;
	}

	public void setCexamen(int cexamen) {
		this.cexamen = cexamen;
	}

	public java.lang.String getSexamen() {
		return sexamen;
	}

	public void setSexamen(java.lang.String sexamen) {
		this.sexamen = sexamen;
	}

	public double getMsubtotal() {
		return msubtotal;
	}

	public void setMsubtotal(double msubtotal) {
		this.msubtotal = msubtotal;
	}

	public double getMdescuentopromocion() {
		return mdescuentopromocion;
	}

	public void setMdescuentopromocion(double mdescuentopromocion) {
		this.mdescuentopromocion = mdescuentopromocion;
	}

	public double getMdescuentoempresa() {
		return mdescuentoempresa;
	}

	public void setMdescuentoempresa(double mdescuentoempresa) {
		this.mdescuentoempresa = mdescuentoempresa;
	}

	public double getMdescuentomedico() {
		return mdescuentomedico;
	}

	public void setMdescuentomedico(double mdescuentomedico) {
		this.mdescuentomedico = mdescuentomedico;
	}

	public double getMfacturaempresa() {
		return mfacturaempresa;
	}

	public void setMfacturaempresa(double mfacturaempresa) {
		this.mfacturaempresa = mfacturaempresa;
	}

	public double getMpagopaciente() {
		return mpagopaciente;
	}

	public void setMpagopaciente(double mpagopaciente) {
		this.mpagopaciente = mpagopaciente;
	}

	public double getMiva() {
		return miva;
	}

	public void setMiva(double miva) {
		this.miva = miva;
	}

	public double getMtotal() {
		return mtotal;
	}

	public void setMtotal(double mtotal) {
		this.mtotal = mtotal;
	}

	public int getUmuestra() {
		return umuestra;
	}

	public void setUmuestra(int umuestra) {
		this.umuestra = umuestra;
	}

	public double getUserid() {
		return userid;
	}

	public void setUserid(double userid) {
		this.userid = userid;
	}

	public void calculaFechaPromesa(int intDays) {
		this.dresultadoentrega = this.calculafechapromesa(intDays);
	}
	
	public java.util.Date getDresultadoentrega() {
		return dresultadoentrega;
	}

	public void setDresultadoentrega(java.util.Date dresultadoentrega) {
		this.dresultadoentrega = dresultadoentrega;
	}

	public java.util.Date getDregistro() {
		return dregistro;
	}

	public void setDregistro(java.util.Date dregistro) {
		this.dregistro = dregistro;
	}

	public int getKpromocion() {
		return kpromocion;
	}

	public void setKpromocion(int kpromocion) {
		this.kpromocion = kpromocion;
	}

	public java.lang.String getSmotivocancelacion() {
		return smotivocancelacion;
	}

	public void setSmotivocancelacion(java.lang.String smotivocancelacion) {
		this.smotivocancelacion = smotivocancelacion;
	}

	public int getCestadoregistro() {
		return cestadoregistro;
	}

	public void setCestadoregistro(int cestadoregistro) {
		this.cestadoregistro = cestadoregistro;
	}

	public int getClugarprocesamiento() {
		return clugarprocesamiento;
	}

	public void setClugarprocesamiento(int clugarprocesamiento) {
		this.clugarprocesamiento = clugarprocesamiento;
	}

	public int getCconvenio() {
		return cconvenio;
	}

	public void setCconvenio(int cconvenio) {
		this.cconvenio = cconvenio;
	}

	public String getSobservaciones() {
		return sobservaciones;
	}

	public void setSobservaciones(String sobservaciones) {
		this.sobservaciones = sobservaciones;
	}
	
	private Date calculafechapromesa(int intTipoPaciente) {
		Calendar now = Calendar.getInstance(); 
		int DaySum = 0;
		iObjLog.debug("Entrando a DatosExamenAjax.calculafechapromesa:Entrando... " + intTipoPaciente);	
		iObjLog.debug("Fecha Actual : " + (now.get(Calendar.MONTH) + 1)                        
										 + "-"                        
										 + now.get(Calendar.DATE)                        
										 + "-"                        
										 + now.get(Calendar.YEAR));     
		String[] strDays = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thusday","Friday","Saturday"};
		String[] strSub = new String[]{"12","11","10","14","13","12","11"};
		String[] strPri = new String[]{"13","12","11","10","14","13","12"};
		if (intTipoPaciente == 1) {
			DaySum = Integer.parseInt(strPri[now.get(Calendar.DAY_OF_WEEK) - 1]);
			iObjLog.debug("Sumar dias strPri : " + DaySum);			
		} else if (intTipoPaciente == 2) {
			DaySum = Integer.parseInt(strSub[now.get(Calendar.DAY_OF_WEEK) - 1]);
			iObjLog.debug("Sumar dias SUB : " + DaySum);			
		}
		iObjLog.debug("El dia de la semana es : " + strDays[now.get(Calendar.DAY_OF_WEEK) - 1]);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int date = now.get(Calendar.DATE) + DaySum;		
		now.clear();		
		now.set(Calendar.YEAR, year);
		now.set(Calendar.MONTH, month);
		now.set(Calendar.DATE, date);		
		iObjLog.debug("Fecha de Entrega : " + (now.get(Calendar.MONTH) + 1)                        
											 + "-"                        
											 + now.get(Calendar.DATE)                        
											 + "-"                        
											 + now.get(Calendar.YEAR));     
		return now.getTime();		
	}

	public int getCperfil() {
		return cperfil;
	}

	public void setCperfil(int cperfil) {
		this.cperfil = cperfil;
	}

	public int getCtipocomercial() {
		return ctipocomercial;
	}

	public void setCtipocomercial(int ctipocomercial) {
		this.ctipocomercial = ctipocomercial;
	}

	public String getStipocomercial() {
		return stipocomercial;
	}

	public void setStipocomercial(String stipocomercial) {
		this.stipocomercial = stipocomercial;
	}

	public boolean isBolnewExamen() {
		return bolnewExamen;
	}

	public void setBolnewExamen(boolean bolnewExamen) {
		this.bolnewExamen = bolnewExamen;
	}

	public String getSperfil() {
		return sperfil;
	}

	public void setSperfil(String sperfil) {
		this.sperfil = sperfil;
	}

	public int getCsucursal() {
		return csucursal;
	}

	public void setCsucursal(int csucursal) {
		this.csucursal = csucursal;
	}

	public int getUdiasproceso() {
		return udiasproceso;
	}

	public void setUdiasproceso(int udiasproceso) {
		this.udiasproceso = udiasproceso;
	}

	public double getPdescuentopromocion() {
		return pdescuentopromocion;
	}

	public void setPdescuentopromocion(double pdescuentopromocion) {
		this.pdescuentopromocion = pdescuentopromocion;
	}

	public double getPdescuentoempresa() {
		return pdescuentoempresa;
	}

	public void setPdescuentoempresa(double pdescuentoempresa) {
		this.pdescuentoempresa = pdescuentoempresa;
	}

	public double getPdescuentomedico() {
		return pdescuentomedico;
	}

	public void setPdescuentomedico(double pdescuentomedico) {
		this.pdescuentomedico = pdescuentomedico;
	}

	public int getCclasificacioncomercial() {
		return cclasificacioncomercial;
	}

	public void setCclasificacioncomercial(int cclasificacioncomercial) {
		this.cclasificacioncomercial = cclasificacioncomercial;
	}

	public String getSclasificacioncomercial() {
		return sclasificacioncomercial;
	}

	public void setSclasificacioncomercial(String sclasificacioncomercial) {
		this.sclasificacioncomercial = sclasificacioncomercial;
	}

	public int getCindicacionpaciente() {
		return cindicacionpaciente;
	}

	public void setCindicacionpaciente(int cindicacionpaciente) {
		this.cindicacionpaciente = cindicacionpaciente;
	}

	public String getSindicacionpaciente() {
		return sindicacionpaciente;
	}

	public void setSindicacionpaciente(String sindicacionpaciente) {
		this.sindicacionpaciente = sindicacionpaciente;
	}

	public int getCtipomuestra() {
		return ctipomuestra;
	}

	public void setCtipomuestra(int ctipomuestra) {
		this.ctipomuestra = ctipomuestra;
	}

	public String getStipomuestra() {
		return stipomuestra;
	}

	public void setStipomuestra(String stipomuestra) {
		this.stipomuestra = stipomuestra;
	}

	public int getCinsumo() {
		return cinsumo;
	}

	public void setCinsumo(int cinsumo) {
		this.cinsumo = cinsumo;
	}

	public String getSinsumo() {
		return sinsumo;
	}

	public void setSinsumo(String sinsumo) {
		this.sinsumo = sinsumo;
	}

	public int getCindicaciontomador() {
		return cindicaciontomador;
	}

	public void setCindicaciontomador(int cindicaciontomador) {
		this.cindicaciontomador = cindicaciontomador;
	}

	public String getSindicaciontomador() {
		return sindicaciontomador;
	}

	public void setSindicaciontomador(String sindicaciontomador) {
		this.sindicaciontomador = sindicaciontomador;
	}

	public int getCtemperaturamuestra() {
		return ctemperaturamuestra;
	}

	public void setCtemperaturamuestra(int ctemperaturamuestra) {
		this.ctemperaturamuestra = ctemperaturamuestra;
	}

	public String getStemperaturamuestra() {
		return stemperaturamuestra;
	}

	public void setStemperaturamuestra(String stemperaturamuestra) {
		this.stemperaturamuestra = stemperaturamuestra;
	}

	public int getCmotivorechazo() {
		return cmotivorechazo;
	}

	public void setCmotivorechazo(int cmotivorechazo) {
		this.cmotivorechazo = cmotivorechazo;
	}

	public String getSmotivorechazo() {
		return smotivorechazo;
	}

	public void setSmotivorechazo(String smotivorechazo) {
		this.smotivorechazo = smotivorechazo;
	}

	public java.lang.Integer getKconveniodetalle() {
		return kconveniodetalle;
	}

	public void setKconveniodetalle(java.lang.Integer kconveniodetalle) {
		this.kconveniodetalle = kconveniodetalle;
	}

	public void setClistapublico(int clistapublico) {
		this.clistapublico = clistapublico;
	}

	public int getClistapublico() {
		return clistapublico;
	}

	public void setBolListaPublico(boolean bolListaPublico) {
		this.bolListaPublico = bolListaPublico;
	}

	public boolean isBolListaPublico() {
		return this.bolListaPublico;
	}

	public void setUvolumenexamen(short uvolumenexamen) {
		this.uvolumenexamen = uvolumenexamen;
	}

	public short getUvolumenexamen() {
		return uvolumenexamen;
	}

	public java.util.Date getDtomamuestrainicio() {
		return dtomamuestrainicio;
	}

	public void setDtomamuestrainicio(java.util.Date dtomamuestrainicio) {
		this.dtomamuestrainicio = dtomamuestrainicio;
	}

	public java.util.Date getDtomamuestratermino() {
		return dtomamuestratermino;
	}

	public void setDtomamuestratermino(java.util.Date dtomamuestratermino) {
		this.dtomamuestratermino = dtomamuestratermino;
	}

	public java.lang.String getSlogin_name() {
		return slogin_name;
	}

	public void setSlogin_name(java.lang.String slogin_name) {
		this.slogin_name = slogin_name;
	}

}
