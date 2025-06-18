package mx.com.web2lab.backend.util.formatos;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;
import java.util.TimeZone;

import mx.com.web2lab.backend.util.DateDiff;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class FormateaFecha{
	
	 /**
     * Log de la aplicaci&oacute;n
     */
	private static Log iObjLog = LogFactory.getLog(FormateaFecha.class);
	
	/**
     * Este metodo esta encagardo de formatear una fecha del tipo dd-MMM-aaaa a
     * un tipo String del tipo yyyy/mm/dd. 
     * 
     * @param aStrFecha
     *            Fecha sin Formato dd-MMM-aaaa
     * @return Date Fecha Formateada yyyy/mm/dd
     */
    public String getFechaFormateada(String aStrFecha, String aStrControl) {
        String aStrHora = " 00:00:00";
        String strMeses[] = new String[] { "Ene", "Feb", "Mar", "Abr", "May",
                "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic", "ENE", "FEB",
                "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV",
                "DIC" };
        String lStrDia = aStrFecha.substring(0, 2);
        String lStrMes = aStrFecha.substring(3, 6);
        String lStrAnio = aStrFecha.substring(7, 11);
        int lIntMes = 0;
        for (int i = 0; i < strMeses.length; i++) {
            if (i <= 11) {
                if (strMeses[i].equals(lStrMes)) {
                    lIntMes = i + 1;
                }
            }
            if (i > 11) {
                if (strMeses[i].equals(lStrMes)) {
                    lIntMes = i - 11;
                }
            }
        }
        if (aStrControl.equals("F")) {
            aStrHora = " 23:59:59";
        }
        iObjLog.debug(">>>>>Fecha Retornada|" + lStrAnio + "/" + lIntMes + "/"
                + lStrDia + aStrHora + "|");
        return lStrAnio + "/" + lIntMes + "/" + lStrDia + aStrHora;
    }
    
	/**
     * Este metodo esta encagardo de formatear una fecha del tipo dd-MMM-aaaa a
     * un tipo String del tipo yyyy/mm/dd. 
	 * @param strFecha Fecha con Formato dd-MMM-aaaa
	 * @param strControl Fecha Formateada yyyy/mm/dd
	 * @return
	 */
    public String getFecha4y2m2dhhmmss(String strFecha, String strControl) {
    	iObjLog.debug("FormateaFecha:getFecha4y2m2dhhmmss:Entrando:Fecha|Control" + strFecha + "|"+ strControl);
        String strFechaNueva = "";
        String strMeses[] = new String[] { "ENE", "FEB", "MAR", "ABR", "MAY",
                "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"};
        String strNumMeses[] = new String[] { "01", "02", "03", "04", "05",
                "06", "07", "08", "09", "10", "11", "12"};
        String anio = "0";
        String mes = "0";
        String nMes = "0";
        String dia = "0";
        String[] strDatosFecha = strFecha.split("-");
        if(strDatosFecha!=null && strDatosFecha.length>0){
            anio = strDatosFecha[2];
            mes = strDatosFecha[1].toUpperCase().trim();
            dia = strDatosFecha[0];
            iObjLog.debug("FormateaFecha:getFecha4y2m2dhhmmss:anio|mes:nmes|dia:" + anio + "|" + mes + ":" + nMes + "|" + dia);
            for (int i = 0; i < strMeses.length; i++) {
            	if(strMeses[i].equals(mes)){
            		iObjLog.debug("FormateaFecha:getFecha4y2m2dhhmmss:nMes:" + strNumMeses[i]);
            		nMes = strNumMeses[i];
            	}
            }
            strFechaNueva = anio+"/" +nMes+"/"+dia; 
        }
        if (strControl.trim().equals("I")) {
        	strFechaNueva += " 00:00:00";
        }else{
        	strFechaNueva += " 23:59:59";
        }
        iObjLog.debug("FormateaFecha:getFecha4y2m2dhhmmss:FechaRetornada|" + strFechaNueva);
        return strFechaNueva;
    }
    
	/**
     * Este metodo esta encagardo de formatear una fecha del tipo dd-MMM-aaaa a
     * un String del tipo yyyy/mm/dd. 
	 * @param strFecha Fecha con Formato dd-MMM-aaaa
	 * @param strControl Fecha Formateada yyyy/mm/dd
	 * @return
	 */
    public String getFecha4ymmdd(String strFecha) {
    	iObjLog.debug("FormateaFecha:getFecha4y2m2dhhmmss:Entrando:Fecha:" + strFecha);
        String strFechaNueva = "";
        String strMeses[] = new String[] { "ENE", "FEB", "MAR", "ABR", "MAY",
                "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"};
        String strNumMeses[] = new String[] { "01", "02", "03", "04", "05",
                "06", "07", "08", "09", "10", "11", "12"};
        String anio = "0";
        String mes = "0";
        String nMes = "0";
        String dia = "0";
        String[] strDatosFecha = strFecha.split("-");
        if(strDatosFecha!=null && strDatosFecha.length>0){
            anio = strDatosFecha[2];
            mes = strDatosFecha[1].toUpperCase().trim();
            dia = strDatosFecha[0];
            iObjLog.debug("FormateaFecha:getFecha4y2m2dhhmmss:anio|mes:nmes|dia:" + anio + "|" + mes + ":" + nMes + "|" + dia);
            for (int i = 0; i < strMeses.length; i++) {
            	if(strMeses[i].equals(mes)){
            		iObjLog.debug("FormateaFecha:getFecha4y2m2dhhmmss:nMes:" + strNumMeses[i]);
            		nMes = strNumMeses[i];
            	}
            }
            strFechaNueva = anio+"/" +nMes+"/"+dia; 
        }
        iObjLog.debug("FormateaFecha:getFecha4y2m2dhhmmss:FechaRetornada|" + strFechaNueva);
        return strFechaNueva;
    }
    
    /**
     * Este metodo esta encagardo de formatear una fecha del tipo dd-MMM-aaaa a
     * un tipo String del tipo yyyy/mm/dd. Se requiere hacer esta conversion
     * para realizar la busqueda en la BD oracle
     * @param aStrFecha. Fecha sin Formato dd-MMM-aaaa
     * @return Date. Fecha Formateada yyyy/mm/dd
     */
    public String getFechaFormateadaSinHora(String aStrFecha) {
        String strMeses[] = new String[] { "Ene", "Feb", "Mar", "Abr", "May",
                "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic", "ENE", "FEB",
                "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV",
                "DIC" };
        String lStrDia = aStrFecha.substring(0, 2);
        String lStrMes = aStrFecha.substring(3, 6);
        String lStrAnio = aStrFecha.substring(7, 11);
        int lIntMes = 0;
        String strMes = "";
        for (int i = 0; i < strMeses.length; i++) {
            if (i <= 11) {
                if (strMeses[i].equals(lStrMes)) {
                    lIntMes = i + 1;
                    strMes = ""+lIntMes+"";      //
                    if(lIntMes < 10){
                    	strMes = "0"+lIntMes+"";   //
                    }
                }
            }
            if (i > 11) {
                if (strMeses[i].equals(lStrMes)) {
                    lIntMes = i - 11;
                    strMes = ""+lIntMes+"";
                }
            }
        }
        iObjLog.debug(">>>>>Fecha Retornada|" + lStrAnio + "/" + strMes + "/"
                + lStrDia + "|");
        return lStrAnio + "/" + strMes + "/" + lStrDia;
    }
    
    /**
     * Este metodo recibe una fecha del tipo String dd/mm/yyyy, y
     * regresa un calendar con esa fecha.
     * @param aFecha
     * @return Calendar
     */
    public Calendar Fechador(String aFecha){
		 String[] objIds = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
		 iObjLog.debug(">>>>>>>>>>>>>OBTENIENDO ids : ");
		 if (objIds.length == 0){
		     return null;
		 }	
		 SimpleTimeZone objSimTiZone = new SimpleTimeZone(-8 * 60 * 60 * 1000, objIds[0]);
		 objSimTiZone.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		 objSimTiZone.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		 Calendar objCalendario = new GregorianCalendar(objSimTiZone);
		 Date objTrialTime = new Date();
		 objCalendario.setTime(objTrialTime);		 		
		 int intDia = new Integer(aFecha.substring(0,2)).intValue();
		 int intMes = new Integer(aFecha.substring(3,5)).intValue();
		 int intAnio = new Integer(aFecha.substring(6,10)).intValue();
		 objCalendario.set(intAnio, (intMes-1), intDia);
		return objCalendario;
    }
    
    /**
     * Este metodo recibe una fecha del tipo Date, y
     * regresa un calendar con esa fecha.
     * @param aFecha
     * @return Calendar
     */
    public Calendar FechadorDate(Date aDteFecha, String aStrControl){
    String[] objIds = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
	 iObjLog.debug(">>>>>>>>>>>>>OBTENIENDO ids : ");
	 if (objIds.length == 0){
	     return null;
	 }	
	 SimpleTimeZone objSimTiZone = new SimpleTimeZone(-8 * 60 * 60 * 1000, objIds[0]);
	 objSimTiZone.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
	 objSimTiZone.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
	 Calendar objCalendario = new GregorianCalendar(objSimTiZone);
	 Date objTrialTime = new Date();
	 objCalendario.setTime(objTrialTime);	
	 String strFecha = aDteFecha.toString();
	 iObjLog.debug("FechadorDate strFecha:"+strFecha);
	 if(!aStrControl.equals("hoy")){
		 int intAnio = new Integer(strFecha.substring(0,4)).intValue();
		 int intMes = new Integer(strFecha.substring(5,7)).intValue();
		 int intDia = new Integer(strFecha.substring(8,10)).intValue();
		 int intHora = new Integer(strFecha.substring(11,13)).intValue();
		 int intMin = new Integer(strFecha.substring(14,16)).intValue();
		 iObjLog.debug("FechadorDate año:"+intAnio+",mes:"+intMes+",d&iacute;a:"+intDia+",hora:"+intHora+",Min:"+intMin);
		 objCalendario.set(intAnio, (intMes-1), intDia, intHora, intMin);
	 }
	 return objCalendario;	 
    }
    
    /**
     * Este metodo recibe una fecha del tipo String dd-MMM-aaaa HH:mm , y
     * regresa un objeto Date con esa fecha.
     * @param aFecha. Fecha Formateada dd-MMM-aaaa HH:mm.
     * @return Date.
     */
    public Date getDate(String aStrFecha){
		String[] objIds = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
		if (objIds.length == 0){
		    return null;
		}	
		SimpleTimeZone objSimTiZone = new SimpleTimeZone(-8 * 60 * 60 * 1000, objIds[0]);
		objSimTiZone.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		objSimTiZone.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		Calendar objCalendario = new GregorianCalendar(objSimTiZone);
		Date objTrialTime = new Date();
		objCalendario.setTime(objTrialTime);
		
        String strMeses[] = new String[] { "Ene", "Feb", "Mar", "Abr", "May",
                "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic", "ENE", "FEB",
                "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV",
                "DIC" };
        StringTokenizer st = new StringTokenizer(aStrFecha.trim(), " ");
        String lStrDma = null;
        String lStrMes = "0";
        int intDia = 0;
        int intMes = 0;
        int intAnio = 0;
        if(st.hasMoreTokens()) {
            lStrDma = st.nextToken();
            StringTokenizer stDma = new StringTokenizer(lStrDma, "-");
            intDia = Integer.parseInt(stDma.nextToken().trim());
            lStrMes = stDma.nextToken().trim();
            intAnio = Integer.parseInt(stDma.nextToken().trim());
        }
        int intHrs = 0;
        int intMin = 0;
        String lStrHm = null;
        if(st.hasMoreTokens()) {
        	lStrHm = st.nextToken();
        	StringTokenizer stHm = new StringTokenizer(lStrHm, ":");
        	intHrs = Integer.parseInt(stHm.nextToken().trim());
        	intMin = Integer.parseInt(stHm.nextToken().trim());
        }
        for (int i = 0; i < strMeses.length; i++) {
            if (i > 11) {
                if (strMeses[i].equals(lStrMes)) {
                    intMes = i - 11;
                }
            }
        }
		objCalendario.set(intAnio, (intMes-1), intDia, intHrs, intMin);		
		return objCalendario.getTime();
    }
    
    /**
	 * Este metodo regresa la fecha de hoy en el formato yyyy'-'MM'-'dd
	 * 11-19-2009
	 * @param Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFecha4ymmdd(Date aObjFecha){
		SimpleDateFormat objFormato = new SimpleDateFormat("yyyy'-'MM'-'dd");
		String strFecha = objFormato.format(aObjFecha);
	 	iObjLog.debug(" > strFecha: "+strFecha);
		return strFecha;
	}
	
    /**
	 * Este metodo regresa la fecha de hoy en el formato dd'-'MMM'-'yyyy
	 * 19-nov-2009
	 * @param Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFechaddmm4y(Date aObjFecha){
		SimpleDateFormat objFormato = new SimpleDateFormat("dd'-'MM'-'yyyy");
		String strFecha = objFormato.format(aObjFecha);
	 	iObjLog.debug(" > strFecha: "+strFecha);
		return strFecha;
	}
    /**
	 * Este metodo regresa la fecha de hoy en el formato dd'-'MMM'-'yyyy
	 * 19-nov-2009
	 * @param Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFechaddmm2y(Date aObjFecha){
		SimpleDateFormat objFormato = new SimpleDateFormat("dd'-'MM'-'yy");
		String strFecha = objFormato.format(aObjFecha);
	 	iObjLog.debug(" > strFecha: "+strFecha);
		return strFecha;
	}

	/**
	 * Este metodo regresa la fecha de hoy en el formato dd'-'MMM'-'yyyy
	 * 19-nov-2009
	 * @param Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFecha(Date aObjFecha){
		SimpleDateFormat objFormato = new SimpleDateFormat("dd'-'MMM'-'yyyy");
		String strFecha = objFormato.format(aObjFecha);
	 	iObjLog.debug(" > strFecha: "+strFecha);
		return strFecha;
	}
	/**
	 * Este metodo regresa la fecha de hoy en el formato yyyy'-'mm'-'dd
	 * 19-nov-2009
	 * @param Fecha a formatear.
	 * @return strFechaValida
	 */
	public String getFechaNumerica(Date aObjFecha){
		SimpleDateFormat objFormato = new SimpleDateFormat("yyyy'-'MM'-'dd");
		String strFecha = objFormato.format(aObjFecha);
	 	iObjLog.debug(" > strFecha: "+strFecha);
		return strFecha;
	}
	 
	
	public int getEdadAnios(Date objFechaNac, Date objFechaBase){
		return new DateDiff().getDateDiff(Calendar.YEAR, objFechaNac, objFechaBase);
	}
		
	public int getEdadMeses(Date objFechaNac, Date objFechaBase) {
		return new DateDiff().getDateDiff(Calendar.MONTH, objFechaNac, objFechaBase);
	}
	
	public int getEdadDias(Date objFechaNac, Date objFechaBase){
		return new DateDiff().getDateDiff(Calendar.DAY_OF_MONTH, objFechaNac, objFechaBase);
	}
	
	/**
	 * Obtiene la edad
	 * @param objDteNacimiento con el formato yyyy-mm-dd
	 * @return edad
	 * @throws Exception
	 */
	public int getEdadAnios(Date objDteNacimiento) 
	throws Exception{
		return new DateDiff().getDateDiff(Calendar.YEAR, objDteNacimiento, new Date());
	}
	
	/**
	 * obtiene la edad en meses
	 * @param objDteNacimiento con el formato yyyy-mm-dd
	 * @return edad en meses
	 * @throws Exception
	 */
	public int getEdadMeses(Date objDteNacimiento) 
	throws Exception{
		return new DateDiff().getDateDiff(Calendar.MONTH, objDteNacimiento, new Date());
	}
	
	/**
	 * obtiene la edad en dias
	 * @param ldteNacimiento con el formato yyyy-mm-dd
	 * @return edad en dias
	 * @throws Exception
	 */
	public int getEdadDias(Date objDteNacimiento) 
	throws Exception {
		return new DateDiff().getDateDiff(Calendar.DAY_OF_MONTH, objDteNacimiento, new Date());
	}

	/**
	 * Metodo para formatear una fecha a fecha corta
     * formatea la fecha en español
     * 
	 *	@param date fecha a a formatear
	 *	@param String mascara el estilo de la fecha ejemplo "dd-MMM-yyyy";
	 *	@return String que representa la fecha formateada.
	 */
	public static String getFecha(Date date, String mascara) 
    {
        Locale objPais   = new Locale("es","ES"); 
        String strPatron = mascara;
        SimpleDateFormat formato = new SimpleDateFormat(strPatron,objPais);
        String strFecha = "";
        if(date!=null){
        	strFecha = formato.format(date);
            return strFecha;
        }
        else return null;
	}
	
	public String getFechaFormateada(Calendar aObjCal){
		HashMap objMeses = new HashMap();
		objMeses.put("0", "Ene");
		objMeses.put("1", "Feb");
		objMeses.put("2", "Mar");
		objMeses.put("3", "Abr");
		objMeses.put("4", "May");
		objMeses.put("5", "Jun");
		objMeses.put("6", "Jul");
		objMeses.put("7", "Ago");
		objMeses.put("8", "Sep");
		objMeses.put("9", "Oct");
		objMeses.put("10", "Nov");
		objMeses.put("11", "Dic");
		
		String strFecha = "0"+aObjCal.get(Calendar.DATE)+"";
		if(strFecha != null && strFecha.length()>2){
			strFecha = strFecha.substring(1,3);
		}
		strFecha += "-"+objMeses.get(aObjCal.get(Calendar.MONTH)+"")+"-";
		strFecha += aObjCal.get(Calendar.YEAR);
		return strFecha;
	}
}