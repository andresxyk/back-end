package mx.com.web2lab.backend.util.formatos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.regexp.RE;
import org.apache.regexp.RESyntaxException;

public class Formatos {
	/** constructor default */
	public Formatos(){
	}
	/**log de la aplicaci&oacute;n */
	private static Log iObjLog = LogFactory.getLog(Formatos.class);

	public static String formateaNumero2Digitos(String aStrCantidad)
	throws NumberFormatException {
		String strFormato = null;
		double objDouble = 0;
		try{
			if(aStrCantidad != null && !aStrCantidad.trim().equals("")){
				objDouble = Double.parseDouble(aStrCantidad);
			}else{
				objDouble = Double.parseDouble("00");
			}
			strFormato = new DecimalFormat("00").format(objDouble);
		}catch(NumberFormatException aObjException){
			return ("El valor asignado a la funcion de formateo no es valido");
		}
		return strFormato;
	}
	
	public Date getFecha(String strFecha) throws Exception{
		iObjLog.debug("Fomateando la fecha: " + strFecha);
		String[] arrFechaHora = null; 
		String[] arrFecha = null;
		String[] arrHora = null;
		arrFechaHora = strFecha.split(" ");
		if (arrFechaHora.length<0){
			arrFecha = arrFechaHora[0].split("-");
			arrHora = arrFechaHora[1].split(":");
		}
		else{
			arrFecha = strFecha.split("-");
		}
		if(arrFecha.length<3){
			iObjLog.debug("La fecha no es valida ...");
			return null;
		}
		//iObjLog.debug("arrFecha[0]="+arrFecha[0]+", arrFecha[1]="+arrFecha[1]+", arrFecha[2]="+arrFecha[2]);
		String dia = arrFecha[0];
		String mes = sustituyeNumeroMes(arrFecha[1]);
		String anio = arrFecha[2];
		String hora = "00";
		String mins = "00";
		String segs = "00";
		//iObjLog.debug("dia="+dia+", mes="+mes+", anio="+anio);
		if (arrHora!= null && arrHora.length>0){
			if (arrHora.length==1){
				hora = arrHora[0];
			}
			else if(arrHora.length==2){
				hora = arrHora[0];
				mins = arrHora[1];
			}
			else if(arrHora.length==3){
				hora = arrHora[0];
				mins = arrHora[1];
				segs = arrHora[2];
			}
		}
		
		return getObjFecha(dia+"-"+mes+"-"+anio+" "+hora+":"+mins+":"+segs);
	}
	/**
	 * Este metodo recibe un string con el formato dd-mm-yyyy hh:mm:ss 
	 * y regresa un objeto Date correspondiente al string proporcionado  
	 * @param strFecha Fecha a formatear.
	 * @return Date
	 */
	public Date getObjFecha(String strFecha) throws Exception{
		iObjLog.debug("Formateando la fecha: " + strFecha);
		Calendar objCal = null;
		Date objDate = null;
		boolean isAnioBisiesto = false;
		try{
			String[] arrFecha = strFecha.split(" ")[0].split("-");
			String[] arrHora = strFecha.split(" ")[1].split(":");
			int dia = Integer.parseInt(arrFecha[0]);
			int mes = Integer.parseInt(arrFecha[1])-1;
			int anio = Integer.parseInt(arrFecha[2]);
			int hora = Integer.parseInt(arrHora[0]);
			int min = Integer.parseInt(arrHora[1]);
			int seg = Integer.parseInt(arrHora[2]);
			if(mes<0 || mes>11){
				iObjLog.debug("No es un mes apropiado...");
				return null;
			}
			if (((anio % 4)==0) && ((anio % 100)!=0) || ((anio % 400)==0)) {
				isAnioBisiesto = true;
			}
			if((mes==0 || mes==2 || mes==6 || mes==7 || mes==9 || mes==11) && (dia<1 || dia>31)){
				iObjLog.debug("No es un dia valido ...");
				return null;
			}
			if((mes==1 || mes==3 || mes==5 || mes==8 || mes==10 || mes==12) && (dia<1 || dia>30)){
				iObjLog.debug("No es un dia valido ...");
				return null;
			}
			//TODO OMRR 13/07/2006 - (Formatos.java) Eliminamos la rutina por que no guardaba la fecha de nacimiento para Febrero						
/*			
			if ((mes==1 && isAnioBisiesto && dia!=29) || (mes==1 && !isAnioBisiesto && dia!=28)){
				iObjLog.debug("No es un dia valido para el mes de febrero...");
				return null;
			}
*/			
			objCal = new GregorianCalendar();
			objCal.set(anio,mes,dia,hora,min,seg);
			objDate = objCal.getTime();
			objCal = null;
		}
		catch(Exception aError){
			throw aError;
		}
		return objDate;
	}
	/**
	 * Este metodo regresa la fecha de hoy en el formato dd'-'MMM'-'yyyy
	 * algo como 12-jun-2004
	 * @param aObjFecha Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFecha(Date aObjFecha) throws Exception{
		//String strDia = new SimpleDateFormat("dd").format(aObjFecha);
		//String strMes = this.sustituyeNumeroMes(aObjFecha);
		//String strAnio = new SimpleDateFormat("yyyy").format(aObjFecha);
		String strFecha = new SimpleDateFormat("dd-MMM-yyyy",this.getLocale()).format(aObjFecha);
		//String strFecha = strDia + strMes + strAnio;
	 	strFecha = strFecha.toUpperCase();
	 	iObjLog.debug(" > strFecha: " + strFecha);
		return strFecha;
	}
	/**
	 * Este metodo regresa la fecha de hoy en el formato dd'-'MMM'-'yyyy
	 * algo como 12-jun-2004, si la bandera flagHoraMin esta en 1 se incluye 
	 * horas y minutos 
	 * @param aObjFecha Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFecha(Date aObjFecha, int flagHoraMin ) throws Exception{
		//String strFecha = "";
		//if (flagHoraMin == 0) return getFecha(aObjFecha) ;	
		//String strDia = new SimpleDateFormat("dd").format(aObjFecha);
		//String strMes = this.sustituyeNumeroMes(aObjFecha);
		//String strAnio = new SimpleDateFormat("yyyy").format(aObjFecha);
		//String strHHmm = new SimpleDateFormat("HH:mm").format(aObjFecha);
		//strFecha = strDia + strMes + strAnio + " " + strHHmm;
	 	//strFecha = sustituyeMesCorto(strFecha).toUpperCase();
		String strFmt = (flagHoraMin == 1?"dd-MMM-yyyy HH:mm":"dd-MMM-yyyy");
		String strFecha = new SimpleDateFormat(strFmt,this.getLocale()).format(aObjFecha).toUpperCase();
	 	iObjLog.debug(" > strFecha: " + strFecha);
		return strFecha;
	}
	/**
	 * Este metodo regresa la fecha de hoy en el formato
	 * indicado por aStrFormato 
	 * algo como 12-jun-2004
	 * @param aObjFecha Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFecha(Date aObjFecha, String aStrFormato) throws Exception{
		if (aStrFormato==null || aStrFormato.trim().equals("")) return getFecha(aObjFecha);
		//SimpleDateFormat objFormato = new SimpleDateFormat(aStrFormato,this.getLoc());
		String strFecha = new SimpleDateFormat(aStrFormato,this.getLocale()).format(aObjFecha).toUpperCase();
	 	iObjLog.debug(" > strFecha: "+strFecha);
	 	strFecha = sustituyeMesCorto(strFecha).toUpperCase();
	 	return strFecha;
	}
	/**
	 * Este metodo regresa la fecha enviada en  
	 * aObjFecha en la forma "EEEEE, d ' de ' MMM ' del ' yyyy" 
	 * algo como "Lunes, 17 de Junio del 2004"
	 * @param aObjFecha Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFechaLarga(Date aObjFecha) throws Exception{
		String strFecha = new SimpleDateFormat("EEE, d ' de ' MMM ' del ' yyyy", this.getLocale()).format(aObjFecha).toUpperCase();
		//strFecha = this.sustituyeDia(strFecha).toUpperCase();
		//strFecha = this.sustituyeMesLargo(strFecha).toUpperCase();
	 	iObjLog.debug(" > strFecha: " + strFecha);
		return strFecha;
	}
	/**
	 * Este metodo regresa la fecha de hoy en la forma dd-MM-yyyy
	 * algo como 12-06-2004
	 * @param aObjFecha Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFechaNumeros(Date aObjFecha){
		//String strFormato = "dd-MM-yyyy";
		//SimpleDateFormat objFormato = new SimpleDateFormat(strFormato,this.getLoc());
		String strFecha = new SimpleDateFormat("dd-MM-yyyy",this.getLocale()).format(aObjFecha);
	 	iObjLog.debug(" > strFecha: "+strFecha);
		return strFecha;
	}
	/**
	 * Este metodo regresa la fecha de hoy en la forma dd-MM-yyyy
	 * algo como 12-06-2004
	 * @param aObjFecha Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFechaNumeros(Date aObjFecha, String aStrFormato){
		if (aStrFormato==null || aStrFormato.trim().equals("")) return getFechaNumeros(aObjFecha);
		//SimpleDateFormat objFormato = new SimpleDateFormat(aStrFormato);
		String strFecha = new SimpleDateFormat(aStrFormato,this.getLocale()).format(aObjFecha);
	 	iObjLog.debug(" > strFecha: "+strFecha);
		return strFecha;
	}
	/**
	 * Este metodo regresa la fecha enviada en  
	 * aObjFecha en la forma "EEE, d ' de ' MMM ' del ' yyyy" 
	 * algo como "Lunes, 17 de Junio del 2004"
	 * @param aObjFecha Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFechaLetras(Date aObjFecha) throws Exception{
		String strFormato = "EEE, d ' de ' MMM ' del ' yyyy";
		//SimpleDateFormat objFormato = new SimpleDateFormat(strFormato,this.getLoc());
		String strFecha = new SimpleDateFormat(strFormato,this.getLocale()).format(aObjFecha).toUpperCase();
	 	iObjLog.debug(" > strFecha: "+strFecha);
	 	//strFecha = sustituyeMesCorto(strFecha).toUpperCase();
		return strFecha;
	}
	/**
	 * Este metodo regresa la fecha enviada en  
	 * aObjFecha en la forma "EEE, d 'de' MMM 'del' yyyy" 
	 * algo como "Lunes, 17 de Junio del 2004"
	 * @param aObjFecha Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFechaLetras(Date aObjFecha, String aStrFormato) throws Exception{
		if (aStrFormato==null || aStrFormato.trim().equals("")) return getFechaLetras(aObjFecha);
		//SimpleDateFormat objFormato = new SimpleDateFormat(aStrFormato);
		String strFecha = new SimpleDateFormat(aStrFormato,this.getLocale()).format(aObjFecha).toUpperCase();
	 	iObjLog.debug(" > strFecha: "+strFecha);
	 	//strFecha = sustituyeDia(strFecha).toUpperCase();
	 	//strFecha = sustituyeMesCorto(strFecha).toUpperCase();
		return strFecha;
	}
	/**
	 * Este metodo obtiene la hora y los minutos
	 * @param aObjFecha Fecha a formatear.
	 * @return String
	 */
	public String getHoraMin(Date aObjFecha){
		return new SimpleDateFormat("HH:mm",this.getLocale()).format(aObjFecha);
/*		// get the supported ids for GMT-08:00 (Pacific Standard Time)
		String strHora = "";
		String[] objIds = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
		iObjLog.debug(">>>>>>>>>>>>>OBTENIENDO ids : ");
		// if no ids were returned, something is wrong. get out.
		if (objIds.length == 0)
		     return strHora;
		// create a Pacific Standard Time time zone
		SimpleTimeZone objSimTiZone = new SimpleTimeZone(-8 * 60 * 60 * 1000, objIds[0]);
		// set up rules for daylight savings time
		objSimTiZone.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		objSimTiZone.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		// create a GregorianCalendar with the Pacific Daylight time zone
		// and the current date and time
		Calendar objCalendario = new GregorianCalendar(objSimTiZone);
		objCalendario.setTime(aObjFecha);
		if(objCalendario.get(Calendar.MINUTE)<10){
		 	strHora = " " + objCalendario.get(Calendar.HOUR_OF_DAY) + ":0" + objCalendario.get((Calendar.MINUTE)) + " ";
		 	return strHora;
		}
		else{
		 	strHora = " " + objCalendario.get(Calendar.HOUR_OF_DAY) + ":" + objCalendario.get((Calendar.MINUTE)) + " ";
		 	return strHora;
		}
*/	}
	/**
	 * Este metodo regresa la cantidad mencionada en 
	 * aObjNumero con letras 
	 * P.ej: 256.68 (dos cientos cincuenta y seis (68/100) )
	 * @param aObjNumero - Numero a formatear
	 * @return retStr - String con el numero formateado
	 */
	public String getStringNumeros(BigDecimal aObjNumero){
		String retStr = "";
		return retStr;
	}
	/**
	 * Este metodo regresa la cantidad mencionada en 
	 * aObjNumero con letras y con el formato de moneda
	 * P.ej: 256.68 (Son dos cientos cincuenta y seis pesos 68/100 M.N.)
	 * @param aObjNumero 
	 * @return strFechaValida
	 */
	public String getStringMoneda(BigDecimal aObjNumero){
		String retStr = "";
		return retStr;
	}
	
	/**
	 * 
	 * @param aObjNum
	 * @return
	 * @throws NumberFormatException
	 */
	public String formateaNumero(String aStrCantidad)
	throws NumberFormatException {
		String strFormato = null;
		double objDouble = 0;
		try{
			if(aStrCantidad != null && !aStrCantidad.trim().equals("")){
				objDouble = Double.parseDouble(aStrCantidad);
			}else{
				objDouble = Double.parseDouble("0");
			}
			strFormato = new DecimalFormat("###,###,###,###,##0.00").format(objDouble);
		}catch(NumberFormatException aObjException){
			return ("El valor asignado a la funcion de formateo no es valido");
		}
		return strFormato;
	}

	/**
	 * 
	 * @param aObjNum
	 * @return
	 * @throws NumberFormatException
	 */
	public String formateaNumeroLetra(String aStrCantidad)
	throws NumberFormatException {
		String strFormato = null;
		double objDouble = 0;
		try{
			if(aStrCantidad != null && !aStrCantidad.trim().equals("")){
				objDouble = Double.parseDouble(aStrCantidad);
			}else{
				objDouble = Double.parseDouble("0");
			}
			strFormato = new DecimalFormat("##############0.00").format(objDouble);
		}catch(NumberFormatException aObjException){
			return ("El valor asignado a la funcion de formateo no es valido");
		}
		return strFormato;
	}
	
	
	/**
	 * M&eacute;todo que regresa una cadena que representa el objeto 
	 * que se pasa, dicho objeto puede ser una subclase de Number
	 * o un String  
	 * @param aObjNum Object
	 * @return
	 * @throws Exception
	 */
	public String formateaNumero(Object aObjNum)
	throws Exception {
		Number objNumber = null;
		String strRes = "0.00";
		if ((aObjNum instanceof Number)){
			if (aObjNum==null) return strRes; 
			objNumber = (Number)aObjNum;
			try{
				strRes = new DecimalFormat("###,###,###,###,##0.00").format(objNumber.longValue());
			}
			catch(Exception aError){
				iObjLog.error("----->>>>> Formatos.formateaNumero(arg0) Error al formatear el objeto: " + aObjNum, aError);				
			}
		}
		else if ((aObjNum instanceof String)){
			try{
				if (aObjNum==null) return strRes;
				String strNum = (String)aObjNum;
				//se valida que la cadena sea un numero valido
				if (!(esNumero(strNum))){
					iObjLog.debug("----->>>>> Formatos.formateaNumero(arg0) El String no es numerico: " + aObjNum);
					return strRes;
				}
				Long objLong = new Long(strNum);
				strRes = new DecimalFormat("###,###,###,###,##0.00").format(objLong.longValue());
			}
			catch(Exception aError){
				iObjLog.error("----->>>>> Formatos.formateaNumero(arg0) Error al formatear el String: " + aObjNum, aError);
			}
		}
		else{
			iObjLog.debug("----->>>>> Formatos.formateaNumero(arg0) La clase del objeto fue: " + aObjNum.getClass().toString());
		}
		return strRes;
	}
	
	/**
	 * 
	 * @param aObjNum
	 * @param aStrFmt
	 * @return
	 * @throws Exception
	 */
	public String formateaNumero(BigDecimal aObjNum, String aStrFmt)
	throws Exception {
		String strRes = "";
		try{
			if(aStrFmt==null||aStrFmt.trim().equals(""))return formateaNumero(aObjNum);
			strRes = new DecimalFormat(aStrFmt).format(aObjNum.longValue());
		}
		catch(Exception aError){
			iObjLog.debug("----->>>>> Formatos.formateaNumero(arg0,arg1) Error al formatear: " + aObjNum);
		}
		return strRes;
	}
	
	/**
	 * Metodo que formatea una fecha de tipo  1978-11-16 02:00:05.0
	 * para mostrarla en 16-NOV-1978
	 * @param aStrFecAFor
	 * @return
	 */
	public String formateaFechaDB(String aStrFecAFor){
	    if( aStrFecAFor.length() < 12 ){
	        return aStrFecAFor;
	    }
		Map objMeses = new HashMap();
		objMeses.put("01", "Ene");
		objMeses.put("02", "Feb");
		objMeses.put("03", "Mar");
		objMeses.put("04", "Abr");
		objMeses.put("05", "May");
		objMeses.put("06", "Jun");
		objMeses.put("07", "Jul");
		objMeses.put("08", "Ago");
		objMeses.put("09", "Sep");
		objMeses.put("10", "Oct");
		objMeses.put("11", "Nov");
		objMeses.put("12", "Dic");
		String strFecFormat = null;
		//1978-11-16 02:00:05.0
		String strAnio = aStrFecAFor.substring(0,4);
		String strMes = objMeses.get(aStrFecAFor.substring(5,7))+"";
		String strDia = aStrFecAFor.substring(8,10);
		strFecFormat = strDia+"-"+strMes+"-"+strAnio;
		return strFecFormat;
	}
	
	/**
	 * M&eacute;todo que sustituye un string (searchString) 
	 * por otro string (replaceString), dentro de 
	 * una tercera cadena (evaluateString) y regresa 
	 * el resultado de la operaci&oacute;n, la sustituci&oacute;n es 
	 * no es sensible a may&uacute;sculas o min&uacute;sculas 
	 * @param searchString
	 * @param replaceString
	 * @param evaluateString
	 * @return String 
	 */
	public static String replaceString(String evaluateString, String searchString, String replaceString)
	throws Exception {
		String str = "";
		try{
			RE objRE = new RE("([" + searchString + "])",RE.MATCH_CASEINDEPENDENT);
			str = objRE.subst(evaluateString, replaceString, RE.REPLACE_ALL);
		}
		catch(Exception aError){
			iObjLog.debug("Ocurrio un error al reemplazar el string: ", aError);
			throw aError;
		}
		return str;
	}
	
	/**
	 * Metodo que sustituye los meses en ingles por su equivalente en español
	 * (JAN - ENERO ...) 
	 * @param aStrFecha
	 * @return
	 * @throws Exception
	 */
	public String sustituyeMesLargo(String aStrFecha) 
	throws Exception{
		String strFecha = aStrFecha;
	 	strFecha = replaceString(strFecha,"JAN","ENERO");
	 	strFecha = replaceString(strFecha,"FEB","FEBRERO");
	 	strFecha = replaceString(strFecha,"MAR","MARZO");
	 	strFecha = replaceString(strFecha,"APR","ABRIL");
	 	strFecha = replaceString(strFecha,"MAY","MAYO");
	 	strFecha = replaceString(strFecha,"JUN","JUNIO");
	 	strFecha = replaceString(strFecha,"JUL","JULIO");
	 	strFecha = replaceString(strFecha,"AUG","AGOSTO");
	 	strFecha = replaceString(strFecha,"SEP","SEPTIEMBRE");
	 	strFecha = replaceString(strFecha,"OCT","OCTUBRE");
	 	strFecha = replaceString(strFecha,"NOV","NOVIEMBRE");
	 	strFecha = replaceString(strFecha,"DEC","DICIEMBRE");
	 	return strFecha;
	}
	/**
	 * Metodo que sustituye los meses en ingles por su equivalente en español
	 * (JAN - ENE ...) 
	 * @param aStrFecha
	 * @return
	 * @throws Exception
	 */
	public String sustituyeMesCorto(String aStrFecha)
	throws Exception{
		String strFecha = aStrFecha;
	 	strFecha = replaceString(strFecha,"JAN","ENE");
	 	strFecha = replaceString(strFecha,"FEB","FEB");
	 	strFecha = replaceString(strFecha,"MAR","MAR");
	 	strFecha = replaceString(strFecha,"APR","ABR");
	 	strFecha = replaceString(strFecha,"MAY","MAY");
	 	strFecha = replaceString(strFecha,"JUN","JUN");
	 	strFecha = replaceString(strFecha,"JUL","JUL");
	 	strFecha = replaceString(strFecha,"AUG","AGO");
	 	strFecha = replaceString(strFecha,"SEP","SEP");
	 	strFecha = replaceString(strFecha,"OCT","OCT");
	 	strFecha = replaceString(strFecha,"NOV","NOV");
	 	strFecha = replaceString(strFecha,"DEC","DIC");
	 	return strFecha;
	}
	/**
	 * Metodo que sustituye el numero de mes en ingles por su equivalente en español
	 * (01 - ENE, 02 - FEB,  ...) 
	 * @param aStrFecha
	 * @return
	 * @throws Exception
	 */
	public String sustituyeNumeroMes(Date aObjFecha)
	throws Exception{
		String strFecha = new SimpleDateFormat("MM").format(aObjFecha);
	 	strFecha = replaceString(strFecha,"01","ENE");
	 	strFecha = replaceString(strFecha,"02","FEB");
	 	strFecha = replaceString(strFecha,"03","MAR");
	 	strFecha = replaceString(strFecha,"04","ABR");
	 	strFecha = replaceString(strFecha,"05","MAY");
	 	strFecha = replaceString(strFecha,"06","JUN");
	 	strFecha = replaceString(strFecha,"07","JUL");
	 	strFecha = replaceString(strFecha,"08","AGO");
	 	strFecha = replaceString(strFecha,"09","SEP");
	 	strFecha = replaceString(strFecha,"10","OCT");
	 	strFecha = replaceString(strFecha,"11","NOV");
	 	strFecha = replaceString(strFecha,"12","DIC");
	 	return strFecha;
	}
	/**
	 * Metodo que sustituye el numero de mes en ingles por su equivalente en español
	 * (ENE - 01, FEB - 02,  ...) 
	 * @param aObjFecha - Date
	 * @return String 
	 * @throws Exception
	 */
	public String sustituyeNumeroMes(String aStrFecha)
	throws Exception{
		String strFecha = aStrFecha.trim();
		if(strFecha.equalsIgnoreCase("ENE"))strFecha = "01";
		if(strFecha.equalsIgnoreCase("FEB"))strFecha = "02";
		if(strFecha.equalsIgnoreCase("MAR"))strFecha = "03";
		if(strFecha.equalsIgnoreCase("ABR"))strFecha = "04";
		if(strFecha.equalsIgnoreCase("MAY"))strFecha = "05";
		if(strFecha.equalsIgnoreCase("JUN"))strFecha = "06";
		if(strFecha.equalsIgnoreCase("JUL"))strFecha = "07";
		if(strFecha.equalsIgnoreCase("AGO"))strFecha = "08";
		if(strFecha.equalsIgnoreCase("SEP"))strFecha = "09";
		if(strFecha.equalsIgnoreCase("OCT"))strFecha = "10";
		if(strFecha.equalsIgnoreCase("NOV"))strFecha = "11";
		if(strFecha.equalsIgnoreCase("DIC"))strFecha = "12";
	 	return strFecha;
	}
	
	/**
	 * Metodo que sustituye el dia en ingles por su equivalente en español
	 * (SUN - DOMINGO, MON - LUNES,  ...) 
	 * @param aStrFecha
	 * @return
	 * @throws Exception
	 */
	public String sustituyeDia(String aStrFecha)
	throws Exception{
		String strFecha = aStrFecha;
	 	strFecha = replaceString(strFecha,"SUN","DOMINGO");
	 	strFecha = replaceString(strFecha,"MON","LUNES");
	 	strFecha = replaceString(strFecha,"TUE","MARTES");
	 	strFecha = replaceString(strFecha,"THU","MIERCOLES");
	 	strFecha = replaceString(strFecha,"WED","JUEVES");
	 	strFecha = replaceString(strFecha,"FRI","VIERNES");
	 	strFecha = replaceString(strFecha,"SAT","SABADO");
	 	return strFecha;
	}
	
	/**
	 * Metodo que obtiene la localidad (Locale) para crear los formatos de fecha
	 * si no se encuentra para idioma español se crea uno con el default del jvm 
	 * @return Locale 
	 */
	public Locale getLocale() {
		Locale objLoc = new Locale("es");
		iObjLog.debug("creando Locale 'es': " + objLoc);
		if (objLoc == null){
			objLoc = Locale.getDefault();
			iObjLog.debug("no encontro 'es', default del jvm: " + objLoc);
		}
		return objLoc; 
	}
	
	/**
	 * M&eacute;todo que evalua que una cadena contenga un valor 
	 * num&eacute;rico, la cadena siempre debe contener la parte entera, 
	 * el punto y la parte decimal son opcionales 
	 * @param evaluateString
	 * @return boolean 
	 */
	public boolean esNumero(String strNumero) 
	throws RESyntaxException, Exception {
		boolean retValue = false; 
		if (strNumero==null && strNumero.trim().equals("")){
			iObjLog.debug("Formatos:esNumero:la cadena es null o vacia se regresa false : " + strNumero);
			return retValue;
		}
		try{
			retValue = new RE("^[+-]?\\d+(\\.\\d+)?$").match(strNumero);
		}
		catch(RESyntaxException aError){
			iObjLog.error("Formatos:esNumero:Error de sintaxis al crear la expresion regular :" + strNumero + " " + aError.toString());
			throw aError;
		}
		catch(Exception aError){
			iObjLog.error("Formatos:esNumero:Ocurrio un error al validar la cadena a numero : " + strNumero + " " + aError.toString());
			throw aError;
		}
		return retValue; 
	}	
	
	/**
	 * Este metodo recibe un string con el formato dd-MMM-yyyy (10-OCT-2004)
	 * o con el formato dd-MMM-yyyy hh:mm:ss (10-OCT-2004 13:55:20) 
	 * y regresa un objeto Date correspondiente del string proporcionado. 
	 * La parte de la hora, minuto y segundo es opcional  
	 * @param strFecha (String) Fecha a formatear.
	 * @return java.util.Date
	 */
	public  Date getFechaJava(String strFecha) throws Exception{
		iObjLog.debug("Fomateando la fecha: " + strFecha);
		String[] arrFechaHora = null; 
		String[] arrFecha = null;
		String[] arrHora = "00:00:00".split(":");
		arrFechaHora = strFecha.split(" ");
		iObjLog.debug("NUMEROSPLIT:|"+arrFechaHora.length+"|");
		if (arrFechaHora.length>0){
			//LA FECHA PUEDE O NO VENIR CON HORA
			arrFecha = arrFechaHora[0].split("-");
			if (arrFechaHora.length>1){
				//LA FECHA TRAE HORA
				arrHora = arrFechaHora[1].split(":");
			}else{
				//SOLO TRAE LA FECHA
				arrFecha = strFecha.split("-");
			}
		}		
		if(arrFecha.length<3){
			iObjLog.debug("La fecha no es valida ...");
			return null;
		}
		String dia = arrFecha[0];
		String mes = sustituyeNumeroMesJava(arrFecha[1]);
		iObjLog.debug("MES:|"+mes+"|");
		String anio = arrFecha[2];
		String hora = "0";
		String mins = "0";
		String segs = "0";
		if (arrHora.length>0){
			if (arrHora.length==1){
				hora = arrHora[0];
			}
			else if(arrHora.length==2){
				hora = arrHora[0];
				mins = arrHora[1];
			}
			else if(arrHora.length==3){
				hora = arrHora[0];
				mins = arrHora[1];
				segs = arrHora[2];
			}
		}
		iObjLog.debug("DATOSDELAFECHA:|"+dia+"-"+mes+"-"+anio+" "+hora+":"+mins+":"+segs+"|");
		iObjLog.debug("DATERETORNADA:|"+getObjFechaJava(dia+"-"+mes+"-"+anio+" "+hora+":"+mins+":"+segs)+"|");
		return getObjFechaJava(dia+"-"+mes+"-"+anio+" "+hora+":"+mins+":"+segs);
	}
	
	/**
	 * Este metodo recibe un string con el formato dd-mm-yyyy hh:mm:ss 
	 * y regresa un objeto Date correspondiente al string proporcionado  
	 * @param strFecha Fecha a formatear.
	 * @return Date
	 */
	public  Date getObjFechaJava(String strFecha) throws Exception{
		iObjLog.debug("Formateando la fecha: " + strFecha);
		Calendar objCal = null;
		Date objDate = null;
		boolean isAnioBisiesto = false;
		try{
			String[] arrFecha = strFecha.split(" ")[0].split("-");
			String[] arrHora = strFecha.split(" ")[1].split(":");
			int dia = Integer.parseInt(arrFecha[0]);
			int mes = Integer.parseInt(arrFecha[1])-1;
			int anio = Integer.parseInt(arrFecha[2]);
			int hora = Integer.parseInt(arrHora[0]);
			int min = Integer.parseInt(arrHora[1]);
			int seg = Integer.parseInt(arrHora[2]);
			if(mes<0 || mes>11){
				iObjLog.debug("No es un mes apropiado...");
				return null;
			}
			if (((anio % 4)==0) && ((anio % 100)!=0) || ((anio % 400)==0)) {
				isAnioBisiesto = true;
			}
			if((mes==0 || mes==2 || mes==6 || mes==7 || mes==9 || mes==11) && (dia<1 || dia>31)){
				iObjLog.debug("No es un dia valido ...");
				return null;
			}
			if((mes==1 || mes==3 || mes==5 || mes==8 || mes==10 || mes==12) && (dia<1 || dia>30)){
				iObjLog.debug("No es un dia valido ...");
				return null;
			}
			if ((mes==1 && isAnioBisiesto && dia >29) || (mes==1 && !isAnioBisiesto && dia>28)){
				iObjLog.debug("No es un dia valido para el mes de febrero...");
				return null;
			}
			objCal = new GregorianCalendar();
			objCal.set(anio,mes,dia,hora,min,seg);
			objDate = objCal.getTime();
			objCal = null;
		}
		catch(Exception aError){
			throw aError;
		}
		return objDate;
	}
	
	/**
	 * Metodo que sustituye el numero de mes en ingles por su equivalente en español
	 * (ENE - 01, FEB - 02,  ...) 
	 * @param aObjFecha - Date
	 * @return String 
	 * @throws Exception
	 */
	public  String sustituyeNumeroMesJava(String aStrFecha)
	throws Exception{		
		iObjLog.debug("SUSTITUIYENUM:|"+aStrFecha+"|");
		String strFechaMayus = aStrFecha.toUpperCase();
		iObjLog.debug("SUSTITUIYENUMMAYUS:|"+strFechaMayus+"|");
		String strFecha = "";
		if(strFechaMayus.equals("ENE")){
			strFecha+="1";
		}else if(strFechaMayus.equals("FEB")){
			strFecha+="2";
		}else if(strFechaMayus.equals("MAR")){
			strFecha+="3";
		}else if(strFechaMayus.equals("ABR")){
			strFecha+="4";
		}else if(strFechaMayus.equals("MAY")){
			strFecha+="5";
		}else if(strFechaMayus.equals("JUN")){
			strFecha+="6";
		}else if(strFechaMayus.equals("JUL")){
			strFecha+="7";
		}else if(strFechaMayus.equals("AGO")){
			strFecha+="8";
		}else if(strFechaMayus.equals("SEP")){
			strFecha+="9";
		}else if(strFechaMayus.equals("OCT")){
			strFecha+="10";
		}else if(strFechaMayus.equals("NOV")){
			strFecha+="11";
		}else if(strFechaMayus.equals("DIC")){
			strFecha+="12";
		}	
		iObjLog.debug("SUSTITUIYENUMRET:|"+strFecha+"|");
		return strFecha;
	}	
	
	/**
	 * Metodo que concatena el nemonico y la oren 
	 * dejando un formato de 9 caracteres donde el nemonico 
	 * se deja tal como viene de la Base de datos y la orden 
	 * se completa con ceros a la izquierda (para completar los 9) 
	 * @param nem String 
	 * @param ord Long 
	 * @return String 
	 */
	public String fmtOrden(String nem, long lngord){
		String retStr = "";
		Long ord = new Long(lngord); 
		if (nem == null || nem.trim().equals("") || ord == null){
			iObjLog.error("Error en FormateaOrden nemonico nulo o en blanco");
			return "";
		}
		String strOrd = new DecimalFormat("0000000000").format(ord.longValue());
		retStr = nem + strOrd.substring(nem.length());
		iObjLog.debug("fmtOrden Orden formateada:"+retStr);
		return retStr;
	}
	/**
	 * Metodo que acompleta la orden que no tiene nemonico a 8 digitos
	 * @param lngord
	 * @return
	 */
	public String fmtOrdenSinNemo(long lngord){
		Long ord = new Long(lngord); 		
		String strOrd = new DecimalFormat("00000000").format(ord.longValue());		
		iObjLog.debug("fmtOrdenSinNemo Orden formateada:"+strOrd);
		return strOrd;
	}
	/**
	 * Metodo que acompleta con ceros un numero
	 * @param num long
	 * @param pos int
	 * @return String
	 */
	public String fmtNPosiciones(long num, int pos, char car){
		//String numero = new String(num+"");
		StringBuffer ceros = new StringBuffer();
		Long numero = new Long (num);
		for (int i=1;i<=pos;i++){
			ceros.append(car);
		}
		String formateado = new DecimalFormat(ceros.toString()).format(numero.longValue());	
		return formateado;
	}
	

	public static Date getFechaLimite(String fechaPago){
		Date fechaLimite = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strfechaLimite="10-";
		try {
			String[] splitFecha = fechaPago.split(" ");
			String[] sFecha = splitFecha[0].split("-");
			if(Integer.parseInt(sFecha[1])<12){
				strfechaLimite+=(Integer.parseInt(sFecha[1])+1)+"-"+sFecha[2];
			}else{
				strfechaLimite+="01-"+sFecha[2]+1;
			}
			fechaLimite=formatter.parse(strfechaLimite);
			
		}catch (Exception e) {
            e.printStackTrace();
        }
		return fechaLimite;
	}
	
}

