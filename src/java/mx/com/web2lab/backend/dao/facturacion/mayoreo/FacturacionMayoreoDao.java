package mx.com.web2lab.backend.dao.facturacion.mayoreo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mx.com.web2lab.backend.beans.ap.OrdenExamenBean;
import mx.com.web2lab.backend.beans.comer.ConvenioBean;
import mx.com.web2lab.backend.dao.catalogos.CatalogosPKGCatalogosDao;
import mx.com.web2lab.backend.dao.tools.AdministracionFOP_PDF;
import mx.com.web2lab.backend.dao.tools.ReporteEstadoCuentaCxC;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.CTipoPagoFactura;
import mx.com.web2lab.backend.hbm.om.ap.TFactura;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursalFac;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac;
import mx.com.web2lab.backend.hbm.om.lis.CExamen;
import mx.com.web2lab.backend.hbm.om.reportes.TAntiguedadCxc;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import mx.com.web2lab.backend.util.formatos.Formatos;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FacturacionMayoreoDao {

	private static Log iObjLog = LogFactory.getLog(FacturacionMayoreoDao.class);
	    
	private Session iObjSesion = null;
	
	public FacturacionMayoreoDao(){
		iObjSesion = HibernateUtil.getSession();
	}
		
	public List getOrdenListaFacturarConvenio(int cConvenio) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objRst = null;
		String strQuery = "";
		List lstOrdenes =  new ArrayList();
		iObjLog.debug("Entrando FacturacionMayoreoDao.getOrdenListaFacturarConvenio:...  " + cConvenio);
    	try{            
    		objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	        strQuery = "SELECT kOrdenSucursal 					\n"+
	        		   "FROM T_ORDEN_SUCURSAL_FAC				\n"+
	        		   "WHERE CESTADOREGISTRO IN (37) AND 		\n"+
	        		   "	  CCONVENIO IN (" + cConvenio + ")	\n";  
	        iObjLog.debug("Consulta FacturacionMayoreoDao.getOrdenListaFacturarConvenio:...  " + strQuery);
			objRst = objSta.executeQuery(strQuery);
			while(objRst.next()) {
				lstOrdenes.add(new Integer(objRst.getInt("kOrdenSucursal")));
			}
			iObjLog.debug("Consulta FacturacionMayoreoDao.getOrdenListaFacturarConvenio:...  Ordenes \n " + lstOrdenes.size() + "\n");
			return lstOrdenes;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getOrdenListaFacturarConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objRst = null;
    		strQuery = null;
        }
	}		

	public String agregarExamenOrdenFacturacion(int kOrdenSucursal,List lstExamenes, int User_id, int cConvenio) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		Statement objStaRecalculo = null;
		ResultSet objRst = null;
		String strQuery = "";
		int kOrdenSucursalFac = 0;
		iObjLog.debug("Entrando FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...  " + kOrdenSucursal);
    	try{            
    		objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	        objStaRecalculo = objCon.createStatement();
	        strQuery = "SELECT KORDENSUCURSALFAC												\n" +
					   "FROM T_ORDEN_SUCURSAL_FAC												\n" +
					   "WHERE CESTADOREGISTRO IN (38) AND KORDENSUCURSALFAC IN (				\n" +
					   "						SELECT max(KORDENSUCURSALFAC) 					\n" +
					   "						FROM T_ORDEN_SUCURSAL_FAC 						\n" +
					   "						WHERE KORDENSUCURSAL IN ("+ kOrdenSucursal + ")	\n" +
					   "						) 												\n" +
					   "ORDER BY KORDENSUCURSALFAC												\n";  
	        iObjLog.debug("Consulta FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...  " + strQuery);
			objRst = objSta.executeQuery(strQuery);
			while(objRst.next()) {
				kOrdenSucursalFac = objRst.getInt("KORDENSUCURSALFAC");
			}
			if (kOrdenSucursalFac > 0) {			
				this.persistirExamenOrdenFacturacion(kOrdenSucursalFac, kOrdenSucursal,lstExamenes, User_id, cConvenio);
				objStaRecalculo.execute("begin olab_proc_recalculo_ord_fac.proc_recalcula_orden (" + kOrdenSucursalFac + "); end;");
				iObjLog.debug("Consulta FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...Saliendo");
				return "Existo en la Modificacion";
			} else {
				iObjLog.debug("Consulta FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...Saliendo");
				return "La Orden NO esta RETENIDA";
			}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.agregarExamenOrdenFacturacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
    		objSta = null;
    		objStaRecalculo = null;
    		objRst = null;
    		strQuery = null;
        	HibernateUtil.closeSession();
        }
	}
	
	private void persistirExamenOrdenFacturacion(int kOrdenSucursalFac,int kOrdenSucursal,List lstExamenes,int User_id,int cConvenio) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		short sorVolumen = 1;
		OrdenExamenBean objExamenBean = null;
		TOrdenExamenSucursalFac objOrdenExamenSucursalFac = null;
		iObjLog.debug("Entrando FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...  " + kOrdenSucursal + " Examenes " + lstExamenes.size());
    	try{            
            HibernateUtil.beginTrans();
			CEstadoRegistro objCER = new CEstadoRegistro();
				objCER.setCestadoregistro(new Integer(13));
			TFactura objTFactura = new TFactura();
			objTFactura.setKfactura(new Integer(0));
			TOrdenSucursalFac objTOrdenSucursalFac = new TOrdenSucursalFac();
				objTOrdenSucursalFac.setKordensucursalfac(new Integer(kOrdenSucursalFac));
			for (int i = 0; i < lstExamenes.size() ; i++)
			{
				objOrdenExamenSucursalFac = new TOrdenExamenSucursalFac();
				objExamenBean = ((OrdenExamenBean)lstExamenes.get(i));						
				CExamen objCExamen = new CExamen();
					objCExamen.setCexamen(new Integer(objExamenBean.getCexamen()));
				objOrdenExamenSucursalFac.setTordensucursalfac(objTOrdenSucursalFac);
				objOrdenExamenSucursalFac.setKordenexamensucursal(0);
				objOrdenExamenSucursalFac.setKordensucursal(kOrdenSucursal);
				objOrdenExamenSucursalFac.setCestadoregistro(objCER);
				objOrdenExamenSucursalFac.setCexamen(objCExamen);
				objOrdenExamenSucursalFac.setCperfil(objExamenBean.getCperfil());
				objOrdenExamenSucursalFac.setDcancelacionfactura(new Date());
				objOrdenExamenSucursalFac.setDregistro(new Date());
				objOrdenExamenSucursalFac.setMsubtotal(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMdescuentoempresa(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMdescuentomedico(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMdescuentopromocion(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMfacturaempresa(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMpagopaciente(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMiva(new BigDecimal(0));
				objOrdenExamenSucursalFac.setSexamen(objExamenBean.getSexamen());
				objOrdenExamenSucursalFac.setSperfil(objExamenBean.getSperfil());
				objOrdenExamenSucursalFac.setTfactura(objTFactura);
				objOrdenExamenSucursalFac.setUserId(User_id);
				objOrdenExamenSucursalFac.setUserIdChange(User_id);
				objOrdenExamenSucursalFac.setUvolumenexamen(sorVolumen);
				iObjSesion.save(objOrdenExamenSucursalFac);
				iObjSesion.flush();            					
		 	}
			objCER = null;
		    objTFactura = null;
			objTOrdenSucursalFac = null;
    		iObjLog.debug("Entrando FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...Salir  " + kOrdenSucursal);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.agregarExamenOrdenFacturacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
    		objOrdenExamenSucursalFac = null;
        }
	}		

	public List buscarFacturasAllConveniosHB(String strConvenios) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strConvenios);
			HibernateUtil.beginTrans();
			strQuery = "select bOF 										\n" +					
			   		   "from TFactura bOF 								\n" +	
			           "where bOF.cconvenio in  (" + strConvenios + ") order by kfactura desc";
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.buscarFacturaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
//        	HibernateUtil.closeSession();
    	}		
    	return objListaFactura;
	}		

	
	public List buscarFacturasEmitidasConveniosHB(String strConvenios) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strConvenios);
			HibernateUtil.beginTrans();
			strQuery = "select bOF 											\n" +					
			   		   "from TFactura bOF 									\n" +	
			           "where bOF.cconvenio in  (" + strConvenios + ") and 	\n" +
			           "	  bOF.cestadoregistro = 33 						\n" +
			           "order by kfactura desc";
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.buscarFacturaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
//        	HibernateUtil.closeSession();
    	}		
    	return objListaFactura;
	}		
	

	public List buscarFacturasEmitidasConveniosHBCxC(String strConvenios) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strConvenios);
			HibernateUtil.beginTrans();
			strQuery = "select bOF 											\n" +					
			   		   "from TAntiguedadCxc bOF 							\n" +	
			           "where bOF.cconvenio in  (" + strConvenios + ")  	\n" +
			           "order by dregistro desc";
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.buscarFacturaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
//        	HibernateUtil.closeSession();
    	}		
    	return objListaFactura;
	}		
	
	
	public List buscarFacturasCanceladasConveniosHB(String strConvenios) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strConvenios);
			HibernateUtil.beginTrans();
			strQuery = "select bOF 										\n" +					
			   		   "from TFactura bOF 								\n" +	
			           "where bOF.cconvenio in  (" + strConvenios + ") and bOF.cestadoregistro = 34 order by kfactura desc";
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.buscarFacturaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
//        	HibernateUtil.closeSession();
    	}		
    	return objListaFactura;
	}		
	
	public static String llenaIdFactura(String strNemonico,String intFactura,int MaxLength) {
		String strReturn = "";
		int intTotal = (strNemonico.length() + intFactura.length());
		for(int i = intTotal;i <= MaxLength;i++) {
			strReturn += "0";
		}		
		return strNemonico + strReturn + intFactura;
	}
	
	public static String llenaIdNC(String strNemonico,String intFactura,int MaxLength) {
		String strReturn = "";		
		int intTotal = (intFactura.length());
		for(int i = intTotal;i < MaxLength;i++) {
			strReturn += "0";
		}		
		return strNemonico + strReturn + intFactura;
	}
	
	public static String pathXmlTimbrado(int csucursal){
		String url="";
		switch (csucursal) {
		case 1003:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Olab/XML/FacturacionElectronica_";
			break;
		case 1012:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Azteca/XML/FacturacionElectronica_";
			break;
		case 1013:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Swisslab/XML/FacturacionElectronica_";
			break;
		case 1014:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Jenner/Prado/XML/FacturacionElectronica_";
			break;
		case 1015:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Jenner/Lean/XML/FacturacionElectronica_";
			break;
		case 1017:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Swisslab/XML/FacturacionElectronica_";
			break;
		case 1020:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_FamilyLabs/XML/FacturacionElectronica_";
			break;
		case 1021:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Exakta/XML/FacturacionElectronica_";
			break;
		case 1022:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_AsesoresSur/XML/FacturacionElectronica_";
			break;
		case 1026:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Moreira/XML/FacturacionElectronica_";
			break;
		case 1023:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Polab/XML/FacturacionElectronica_";
			break;
		case 1024:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_BiomedicaReferencia/XML/FacturacionElectronica_";
			break;
		case 1025:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_Promedic/XML/FacturacionElectronica_";
			break;
		case 9999:
			url="/mnt/gda/apache-tomcat/webapps/ROOT/FacturasElectronicas_SwissHospital/XML/FacturacionElectronica_";
			break;
		default:
			break;
		}
		return url;
	}
	
	public static BigDecimal obtenerTotal(String xml){
        BigDecimal total = null;
        String atributoTotal="";
        String exre=" Total=\"[0-9]{1,18}(.[0-9]{1,6})?\"";
        String exreNum="[0-9]{1,18}(.[0-9]{1,6})?";
        Pattern pattern = Pattern.compile(exre, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(xml);
        if (matcher.find()) {
            atributoTotal = matcher.group();
            Pattern pattern2 = Pattern.compile(exreNum, Pattern.CASE_INSENSITIVE);
            Matcher matcher2 = pattern2.matcher(atributoTotal);
            if(matcher2.find()){
                total =new BigDecimal(matcher2.group());
            }            
        }           
        return total;
    }
    
    public static BigDecimal obtenerSubTotal(String xml){
        BigDecimal subTotal = null;
        String atributoTotal="";
        String exre="SubTotal=\"[0-9]{1,18}(.[0-9]{1,6})?\"";
        String exreNum="[0-9]{1,18}(.[0-9]{1,6})?";
        Pattern pattern = Pattern.compile(exre, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(xml);
        if (matcher.find()) {
            atributoTotal = matcher.group();
            Pattern pattern2 = Pattern.compile(exreNum, Pattern.CASE_INSENSITIVE);
            Matcher matcher2 = pattern2.matcher(atributoTotal);
            if(matcher2.find()){
                subTotal =new BigDecimal(matcher2.group());
            }            
        }           
        return subTotal;
    }
	
	public static String xmlString(File file){
        FileInputStream fis = null;
        String str = "";

        try {
            fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                str += (char) content;
            }

            System.out.println("After reading file");
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return str;
    }
	
	public ConvenioBean getFacturasConvenio(ConvenioBean objConvenioBean) throws Exception {
		FacturacionMayoreoDao objFacturacionMayoreoDao = new FacturacionMayoreoDao();
		try {
			List lstFacturas = objFacturacionMayoreoDao.buscarFacturasEmitidasConveniosHB(objConvenioBean.getCconvenio().intValue() + "");
			objConvenioBean.setLstFacturas(lstFacturas);
			objConvenioBean.setStrFacturasGrid(this.showBodyConvenioFacturas(objConvenioBean,false));
		} catch (Exception aObjException) {
    	    iObjLog.error("CuentasxCobrarMayoreoAjax.getFacturasConvenio:Exception....", aObjException);
    	    throw aObjException;
		}
		objFacturacionMayoreoDao = null;
		return objConvenioBean;
	}

	public ConvenioBean getFacturasConvenioCxC(ConvenioBean objConvenioBean,boolean bolReadOnly) throws Exception {
		try {
			List lstFacturas = this.buscarFacturasEmitidasConveniosHBCxC(objConvenioBean.getCconvenio().intValue() + "");
			objConvenioBean.setLstFacturas(lstFacturas);
			objConvenioBean.setStrFacturasGrid(this.showBodyConvenioFacturas(objConvenioBean,bolReadOnly));
		} catch (Exception aObjException) {
    	    iObjLog.error("CuentasxCobrarMayoreoAjax.getFacturasConvenio:Exception....", aObjException);
    	    throw aObjException;
		}
		return objConvenioBean;
	}
	
	public ConvenioBean getFacturasConvenioVentas(ConvenioBean objConvenioBean,boolean bolReadOnly) throws Exception {
		try {
			List lstFacturas = this.buscarFacturasEmitidasConveniosHBCxC(objConvenioBean.getCconvenio().intValue() + "");
			objConvenioBean.setLstFacturas(lstFacturas);
			objConvenioBean.setStrFacturasGrid(this.showBodyConvenioFacturasVentas(objConvenioBean,bolReadOnly));
		} catch (Exception aObjException) {
    	    iObjLog.error("CuentasxCobrarMayoreoAjax.getFacturasConvenio:Exception....", aObjException);
    	    throw aObjException;
		}
		return objConvenioBean;
	}
	
	/*Version 15/05/2013 original Bibiana Yañez
	private String showBodyConvenioFacturas(ConvenioBean objConvenioBean,boolean bolReadOnly) throws Exception
	{		
		TAntiguedadCxc objTAntiguedadCxcHB = new TAntiguedadCxc();
		FormateaFecha objFormatearDate = new FormateaFecha();
		Formatos objFormatos = new Formatos();
		AdministracionFOP_PDF objAdministracionFOP_PDF = new AdministracionFOP_PDF();
		String strReturn = "";		

		double dblTotalFactura = 0.0;
		double dblSaldoActual = 0.0;
		
		double dblTotalPagado = 0.0;
		double dblTotalSaldo = 0.0;
		double dblTotalDentroPlazo= 0.0;
		double dblTotal30= 0.0;
		double dblTotal60= 0.0;
		double dblTotal90= 0.0;
		double dblTotal120= 0.0;
		double dblTotal180= 0.0;
		double dblTotal360= 0.0;
		double dblMas361= 0.0;		
		String strColor = "black";
		String strNombreConvenio = objConvenioBean.getCconvenio() + " " + objConvenioBean.getSconvenio();		
		iObjLog.debug("Entrando a CuentasxCobrarMayoreoAjax.getFacturasConvenio:Entrando... ");
		try {
			 if (objConvenioBean.getLstFacturas() != null) {
				int y = 0; 
				String strReadOnlyNOPagos = "";
				String strReadOnlyNOPago = "";
				for (int i = 0; i < objConvenioBean.getLstFacturas().size() ; i++)
				{
					objTAntiguedadCxcHB = (TAntiguedadCxc)objConvenioBean.getLstFacturas().get(i);						
					y = i + 1;
					if (objTAntiguedadCxcHB.getSserie().trim().substring(0, 2).toString() == "NC") {
						strColor = "green";						
						dblTotalFactura = dblTotalFactura - objTAntiguedadCxcHB.getMtotalfactura().doubleValue();						
						dblSaldoActual = (dblSaldoActual - objTAntiguedadCxcHB.getMtotalfactura().doubleValue());							
					} else {
						strColor = "black";
						dblTotalFactura = dblTotalFactura + objTAntiguedadCxcHB.getMtotalfactura().doubleValue();						
						dblTotalPagado = (dblTotalPagado + objTAntiguedadCxcHB.getMpagado().doubleValue());
						dblTotalSaldo = (dblTotalSaldo + objTAntiguedadCxcHB.getMsaldo().doubleValue());						
						dblSaldoActual = (dblSaldoActual + objTAntiguedadCxcHB.getMsaldo().doubleValue());						
					}

					dblTotalDentroPlazo = dblTotalDentroPlazo 	+ objTAntiguedadCxcHB.getMdentroplazo().doubleValue();										
					dblTotal30 			= dblTotal30 			+ objTAntiguedadCxcHB.getM01a30().doubleValue();
					dblTotal60 			= dblTotal60 			+ objTAntiguedadCxcHB.getM31a60().doubleValue();
					dblTotal90 			= dblTotal90 			+ objTAntiguedadCxcHB.getM61a90().doubleValue();
					dblTotal120 		= dblTotal120 			+ objTAntiguedadCxcHB.getM91a120().doubleValue();
					dblTotal180 		= dblTotal180 			+ objTAntiguedadCxcHB.getM121a180().doubleValue();
					dblTotal360 		= dblTotal360 			+ objTAntiguedadCxcHB.getM181a360().doubleValue();
					dblMas361 		    = dblMas361 			+ objTAntiguedadCxcHB.getMmas361().doubleValue();

					if (bolReadOnly) {
						strReadOnlyNOPagos = "<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											 "		<input type=\"hidden\" name=\"hdnAnticipoSaldo\" value=\"" + objTAntiguedadCxcHB.getMpagado().doubleValue() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnSaldoFactura\"  value=\"" + objTAntiguedadCxcHB.getMsaldo().doubleValue() + "\">" +
											 "		<input type=\"hidden\" name=\"hdnkFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getKfactura() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnsFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getSserie() + "\">" + 
											 "</td>";
						strReadOnlyNOPago =  "<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
												objTAntiguedadCxcHB.getSserie()  +
											 "</td>";
					} else {
						strReadOnlyNOPagos = "<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											 "		<input type=\"checkbox\" name=\"chkPagos\" value=\"" + objTAntiguedadCxcHB.getKfactura() + "\" onClick=\"javascript:aceptaPago('" + objConvenioBean.getCconvenio() + "');\" > " +
											 "		<input type=\"text\"   name=\"txtMontoAPagar\" onChange=\"javascript:aceptaPago('" + objConvenioBean.getCconvenio() + "');\" value=\"" + objTAntiguedadCxcHB.getMsaldo().doubleValue() + "\" size=\"4\" style=\"text-align: right\" >" +
											 "		<input type=\"hidden\" name=\"hdnAnticipoSaldo\" value=\"" + objTAntiguedadCxcHB.getMpagado().doubleValue() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnSaldoFactura\"  value=\"" + objTAntiguedadCxcHB.getMsaldo().doubleValue() + "\">" +
											 "		<input type=\"hidden\" name=\"hdnkFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getKfactura() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnsFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getSserie() + "\">" + 
											 "</td>";
						strReadOnlyNOPago =  "<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick=\"javascript:showSubModalPago(" + objTAntiguedadCxcHB.getKfactura() + ",'" + objTAntiguedadCxcHB.getSserie() +"');\" align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
												objTAntiguedadCxcHB.getSserie()  +
											 "</td>";
					}
					strReturn += ("<tr>" + 
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
										"	<a href=\"javascript:visualizarFactura('http://192.237.150.66:9085/FacturasElectronicas/FacturacionElectronica_" + objTAntiguedadCxcHB.getSserie() + ".pdf');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor + "; font-style: normal; font-variant: normal;'>"  +  
				    		            "		<img alt='Factura - PDF' id=\"imgPDF\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoPdf.png' />" +
										"	</a>" + 													
										"</td>" + strReadOnlyNOPago +
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											objFormatearDate.getFecha(objTAntiguedadCxcHB.getDregistro()) +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											objFormatearDate.getFecha(objTAntiguedadCxcHB.getDvencido()) +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											(int)objTAntiguedadCxcHB.getUdiasvencido() +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMtotalfactura().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMpagado().doubleValue() + "") +
										"</td>" + strReadOnlyNOPagos +											
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMsaldo().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMdentroplazo().doubleValue()  + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getM01a30().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getM31a60().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getM61a90().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero((objTAntiguedadCxcHB.getM91a120().doubleValue() + objTAntiguedadCxcHB.getM121a180().doubleValue() + objTAntiguedadCxcHB.getM181a360().doubleValue() + objTAntiguedadCxcHB.getMmas361().doubleValue())  + "") +
										"</td>" + 
									 "</tr>");
				}
			}
			strColor = "black"; 	
			String strPathFOP90 = "";
			double dblNOFacturado = 0.0;
			if (objConvenioBean.getCconvenio().intValue() >= 309 && objConvenioBean.getCconvenio().intValue() <= 312) {
				dblNOFacturado = this.getMontoNOFacturado("309,310,311,312");
			} else {
				dblNOFacturado = this.getMontoNOFacturado(objConvenioBean.getCconvenio() + "");
			}
			ReporteEstadoCuentaCxC objReporteEstadoCuentaCxC = new ReporteEstadoCuentaCxC(dblNOFacturado,objConvenioBean.getLstFacturas());
			objReporteEstadoCuentaCxC.setCcliente(objConvenioBean.getCcliente());
			objReporteEstadoCuentaCxC.setScliente(objConvenioBean.getScliente());
			objReporteEstadoCuentaCxC.setSrfc(objConvenioBean.getSrfc());
			objReporteEstadoCuentaCxC.setSdireccion(objConvenioBean.getSdireccion());
			objReporteEstadoCuentaCxC.setCconvenio(objConvenioBean.getCconvenio());
			objReporteEstadoCuentaCxC.setSconvenio(objConvenioBean.getSconvenio());
			objReporteEstadoCuentaCxC.LoadTotales();
			iObjSesion = HibernateUtil.getSession();			
            CatalogosPKGCatalogosDao objCatalogosPKGCatalogosDao = new CatalogosPKGCatalogosDao(iObjSesion);
            List retorno = objCatalogosPKGCatalogosDao.obtenAll("TipoPagoFactura",0);
            String strFormaPago = "";
            for( int inti = 0;inti < retorno.size(); inti++) {
            	CTipoPagoFactura objCTipoPagoFactura = (CTipoPagoFactura)retorno.get(inti);
            	strFormaPago  += "<option value='" + objCTipoPagoFactura.getCtipopago() + "'>" + objCTipoPagoFactura.getStipopago() + "</option>";
            }
			if (objReporteEstadoCuentaCxC.getLstRowReporteCxC90().size() > 0) {
				strPathFOP90 = objAdministracionFOP_PDF.createDocument(objReporteEstadoCuentaCxC.generaFile(), "ReporteCxC_90Dias_" + objConvenioBean.getCconvenio());
			}
			strReturn = "<tr>" +
					 		"<table border='0' align='center' style='width: 100%' class='tabla'>" + 
							  "<tr>" + 
								"<td align='left' onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" align='bottom' style='font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;'>Convenio "  +  strNombreConvenio.trim()  +
									"</a>" + 
								"</td>" + 
								"<td align='left' style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:abrirVentana('" + strPathFOP90 + "','SaldoCxC');\" align=\"bottom\" style=\"font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;\">90 Dias  "  +  
									"</a>" + 
								"</td>" + 
							  "</tr>"	+					 
						    "</table>" +	
						"</tr>" +						
						"<tr>" + 
						"<div id='gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "' style='visibility:hidden;display:none;'>" +                
			 			"<table border='0' align='center' style='width: 100%' class='tabla'>" +						
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"SALDO FACTURADO" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblSaldoActual))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"VENDIDO NO FACTURADO" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblNOFacturado))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"SALDO TOTAL" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblSaldoActual + dblNOFacturado))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "</table>" +
						  "<table border='0' align='center' style='width: 100%' class='tabla'>" +						
//							this.getTotalesConvenioFacturas(strColor, dblTotalFactura, dblTotalPagado, dblTotalSaldo, dblTotalDentroPlazo, dblTotal30, dblTotal60, dblTotal90, dblTotal120, dblTotal180, dblTotal360, dblMas361, objFormatos) +
							this.getHeaderConvenioFacturas() +
							strReturn + 
//							this.getHeaderConvenioFacturas() +
							this.getTotalesConvenioFacturas(strColor, dblTotalFactura, dblTotalPagado, dblTotalSaldo, dblTotalDentroPlazo, dblTotal30, dblTotal60, dblTotal90, dblTotal120, dblTotal180, dblTotal360, dblMas361, objFormatos, objConvenioBean.getCconvenio().intValue(),bolReadOnly) +
						"</table>" +	
						"<div id='gridPagoGlobal" + objConvenioBean.getCconvenio() + "' style='visibility:hidden;display:none;'>" +                							
							"<table border='0' align='center' style='width: 100%' class='tabla'>" +						
								"<tr>"+
								  "<td>"+
								  	"<b>Fecha Deposito:</b>"+ 				
								  "</td>"+
								  "<td>"+
									  "<input type='text' id='txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + "' size='12' value='' style='background:#E6E6FA' onKeyup='javascript:agregaDiag(this);' onChange='javascript:this.value=validaFormatoFecha(this.value);validafechafrm(document.frmAdminClientes.txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + ");' onFocus='javascript:validafechafrm(document.frmAdminClientes.txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + ");' />"+		
									  "<a href='javascript:doNothing()' onclick='javascript:setDateField(document.frmAdminClientes.txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + "); top.newWin =  ventanaNormal('/web2labportal/javascript/calendar.html','cal','WIDTH=230,HEIGHT=230')>"+
									  	"<img alt='Seleccione una fecha' id='imgFechaDeposito' border='0' src='/web2labportal/images/icono_calend.gif' />"+
									  "</a>"+	
								  "</td>"+			
							  "</tr>"+
							  "<tr>"+
								  "<td>"+
									  "<b>Institucion Deposito:</b>"+ 				
								  "</td>"+
								  "<td>"+
									  "<select id='selTipoPago" + objConvenioBean.getCconvenio() + "' style='background:#E6E6FA' >"+	strFormaPago +						  
									  "</select>"+	
								  "</td>"+			
							  "</tr>"+
							  "<tr>"+
								  "<td>"+
								  "</td>"+
								  "<td>"+
									  "<input type=\"button\" value=\"Registrar Pago\" name=\"Registrar Pago\" class=\"boton\" onclick=\"pagosFacturas('" + objConvenioBean.getCconvenio() + "');\">"+
								  "</td>"+			
							  "</tr>"+
							"</table>" +	
						"</div>" +
						"</div>" +
						"</tr>" + 
						"<tr></tr>"; 
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("CuentasxCobrarMayoreoAjax.getFacturasConvenio:Exception....", aObjException);
    	    throw aObjException;
		} finally {
			objFormatearDate = null;
		}
	}	
	*/
	/*
	 * Versión 15 de Mayo 2013 
     BY
	 */
	private String showBodyConvenioFacturas(ConvenioBean objConvenioBean,boolean bolReadOnly) throws Exception
	{		
		TAntiguedadCxc objTAntiguedadCxcHB = new TAntiguedadCxc();
		FormateaFecha objFormatearDate = new FormateaFecha();
		Formatos objFormatos = new Formatos();
		AdministracionFOP_PDF objAdministracionFOP_PDF = new AdministracionFOP_PDF();
		String strReturn = "";		

		double dblTotalFactura = 0.0;
		double dblSaldoActual = 0.0;
		
		double dblTotalPagado = 0.0;
		double dblTotalSaldo = 0.0;
		double dblTotalDentroPlazo= 0.0;
		double dblTotal30= 0.0;
		double dblTotal60= 0.0;
		double dblTotal90= 0.0;
		double dblTotal120= 0.0;
		double dblTotal180= 0.0;
		double dblTotal360= 0.0;
		double dblMas361= 0.0;		
		String strColor = "black";
		String strNombreConvenio = objConvenioBean.getCconvenio() + " " + objConvenioBean.getSconvenio();		
		iObjLog.debug("Entrando a CuentasxCobrarMayoreoAjax.getFacturasConvenio:Entrando... ");
		try {
			 if (objConvenioBean.getLstFacturas() != null) {
				int y = 0; 
				String strReadOnlyNOPagos = "";
				String strReadOnlyNOPago = "";
				for (int i = 0; i < objConvenioBean.getLstFacturas().size() ; i++)
				{
					objTAntiguedadCxcHB = (TAntiguedadCxc)objConvenioBean.getLstFacturas().get(i);						
					y = i + 1;
					if (objTAntiguedadCxcHB.getSserie().trim().substring(0, 2).toString() == "NC") {
						strColor = "green";						
						dblTotalFactura = dblTotalFactura - objTAntiguedadCxcHB.getMtotalfactura().doubleValue();						
						dblSaldoActual = (dblSaldoActual - objTAntiguedadCxcHB.getMtotalfactura().doubleValue());							
					} else {
						strColor = "black";
						dblTotalFactura = dblTotalFactura + objTAntiguedadCxcHB.getMtotalfactura().doubleValue();						
						dblTotalPagado = (dblTotalPagado + objTAntiguedadCxcHB.getMpagado().doubleValue());
						dblTotalSaldo = (dblTotalSaldo + objTAntiguedadCxcHB.getMsaldo().doubleValue());						
						dblSaldoActual = (dblSaldoActual + objTAntiguedadCxcHB.getMsaldo().doubleValue());						
					}

					dblTotalDentroPlazo = dblTotalDentroPlazo 	+ objTAntiguedadCxcHB.getMdentroplazo().doubleValue();										
					dblTotal30 			= dblTotal30 			+ objTAntiguedadCxcHB.getM01a30().doubleValue();
					dblTotal60 			= dblTotal60 			+ objTAntiguedadCxcHB.getM31a60().doubleValue();
					dblTotal90 			= dblTotal90 			+ objTAntiguedadCxcHB.getM61a90().doubleValue();
					dblTotal120 		= dblTotal120 			+ objTAntiguedadCxcHB.getM91a120().doubleValue();
					dblTotal180 		= dblTotal180 			+ objTAntiguedadCxcHB.getM121a180().doubleValue();
					dblTotal360 		= dblTotal360 			+ objTAntiguedadCxcHB.getM181a360().doubleValue();
					dblMas361 		    = dblMas361 			+ objTAntiguedadCxcHB.getMmas361().doubleValue();

					if (bolReadOnly) {
						strReadOnlyNOPagos = "<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											 "		<input type=\"hidden\" name=\"hdnAnticipoSaldo\" value=\"" + objTAntiguedadCxcHB.getMpagado().doubleValue() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnSaldoFactura\"  value=\"" + objTAntiguedadCxcHB.getMsaldo().doubleValue() + "\">" +
											 "		<input type=\"hidden\" name=\"hdnkFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getKfactura() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnsFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getSserie() + "\">" +
											 "		<input type=\"hidden\" name=\"hdnsConvenio\" value=\"" + objConvenioBean.getCconvenio() + "\">" +
											 "</td>";
						strReadOnlyNOPago =  "<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
												objTAntiguedadCxcHB.getSserie()  +
											 "</td>";
					} else {
						strReadOnlyNOPagos = "<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											 "		<input type=\"checkbox\" name=\"chkPagos\" value=\"" + objTAntiguedadCxcHB.getKfactura() + "\" onClick=\"javascript:aceptaPago('" + objConvenioBean.getCconvenio() + "');\" > " +
											 "		<input type=\"text\"   name=\"txtMontoAPagar\" onChange=\"javascript:aceptaPago('" + objConvenioBean.getCconvenio() + "');\" value=\"" + objTAntiguedadCxcHB.getMsaldo().doubleValue() + "\" size=\"4\" style=\"text-align: right\" >" +
											 "		<input type=\"hidden\" name=\"hdnAnticipoSaldo\" value=\"" + objTAntiguedadCxcHB.getMpagado().doubleValue() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnSaldoFactura\"  value=\"" + objTAntiguedadCxcHB.getMsaldo().doubleValue() + "\">" +
											 "		<input type=\"hidden\" name=\"hdnkFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getKfactura() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnsFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getSserie() + "\">" +
											 "		<input type=\"hidden\" name=\"hdnsConvenio\" value=\"" + objConvenioBean.getCconvenio() + "\">" +
											 "</td>";
						strReadOnlyNOPago =  "<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick=\"javascript:showSubModalPago(" + objTAntiguedadCxcHB.getKfactura() + ",'" + objTAntiguedadCxcHB.getSserie() +"');\" align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
												objTAntiguedadCxcHB.getSserie()  +
											 "</td>";
					}
					strReturn += ("<tr>" + 
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
										"	<a href=\"javascript:visualizarFactura('http://192.237.150.66:9085/FacturasElectronicas_Olab/XMLTMP/PDF/FacturacionElectronica_" + objTAntiguedadCxcHB.getSserie() + ".pdf');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor + "; font-style: normal; font-variant: normal;'>"  +  
				    		            "		<img alt='Factura - PDF' id=\"imgPDF\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoPdf.png' />" +
										"	</a>" + 													
										"</td>" + strReadOnlyNOPago +
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											objFormatearDate.getFecha(objTAntiguedadCxcHB.getDregistro()) +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											objFormatearDate.getFecha(objTAntiguedadCxcHB.getDvencido()) +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											(int)objTAntiguedadCxcHB.getUdiasvencido() +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMtotalfactura().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMpagado().doubleValue() + "") +
										"</td>" + strReadOnlyNOPagos +											
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMsaldo().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMdentroplazo().doubleValue()  + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getM01a30().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getM31a60().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getM61a90().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero((objTAntiguedadCxcHB.getM91a120().doubleValue() + objTAntiguedadCxcHB.getM121a180().doubleValue() + objTAntiguedadCxcHB.getM181a360().doubleValue() + objTAntiguedadCxcHB.getMmas361().doubleValue())  + "") +
										"</td>" +
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
										"" + objTAntiguedadCxcHB.getSestadoregistro() +
									"</td>" +
									 "</tr>");
				}
			}
			strColor = "black"; 	
			String strPathFOP90 = "";
			double dblNOFacturado = 0.0;
			if (objConvenioBean.getCconvenio().intValue() >= 309 && objConvenioBean.getCconvenio().intValue() <= 312) {
				dblNOFacturado = this.getMontoNOFacturado("309,310,311,312");
			} else {
				dblNOFacturado = this.getMontoNOFacturado(objConvenioBean.getCconvenio() + "");
			}
			ReporteEstadoCuentaCxC objReporteEstadoCuentaCxC = new ReporteEstadoCuentaCxC(dblNOFacturado,objConvenioBean.getLstFacturas());
			objReporteEstadoCuentaCxC.setCcliente(objConvenioBean.getCcliente());
			objReporteEstadoCuentaCxC.setScliente(objConvenioBean.getScliente());
			objReporteEstadoCuentaCxC.setSrfc(objConvenioBean.getSrfc());
			objReporteEstadoCuentaCxC.setSdireccion(objConvenioBean.getSdireccion());
			objReporteEstadoCuentaCxC.setCconvenio(objConvenioBean.getCconvenio());
			objReporteEstadoCuentaCxC.setSconvenio(objConvenioBean.getSconvenio());
			objReporteEstadoCuentaCxC.LoadTotales();
			iObjSesion = HibernateUtil.getSession();			
            CatalogosPKGCatalogosDao objCatalogosPKGCatalogosDao = new CatalogosPKGCatalogosDao(iObjSesion);
            List retorno = objCatalogosPKGCatalogosDao.obtenAll("TipoPagoFactura",0);
            String strFormaPago = "";
            for( int inti = 0;inti < retorno.size(); inti++) {
            	CTipoPagoFactura objCTipoPagoFactura = (CTipoPagoFactura)retorno.get(inti);
            	strFormaPago  += "<option value='" + objCTipoPagoFactura.getCtipopago() + "'>" + objCTipoPagoFactura.getStipopago() + "</option>";
            }
			if (objReporteEstadoCuentaCxC.getLstRowReporteCxC90().size() > 0) {
				strPathFOP90 = objAdministracionFOP_PDF.createDocument(objReporteEstadoCuentaCxC.generaFile(), "ReporteCxC_90Dias_" + objConvenioBean.getCconvenio(),objConvenioBean.getCmarca());
			}
			strReturn = "<tr>" +
					 		"<table border='0' align='center' style='width: 100%' class='tabla'>" + 
							  "<tr>" + 
								"<td align='left' onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" align='bottom' style='font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;'>Convenio "  +  strNombreConvenio.trim()  +
									"</a>" + 
								"</td>" + 
								"<td align='left' style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:abrirVentana('" + strPathFOP90 + "','SaldoCxC');\" align=\"bottom\" style=\"font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;\">90 Dias  "  +  
									"</a>" + 
								"</td>" + 
							  "</tr>"	+					 
						    "</table>" +	
						"</tr>" +						
						"<tr>" + 
						"<div id='gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "' style='visibility:hidden;display:none;'>" +                
			 			"<table border='0' align='center' style='width: 100%' class='tabla'>" +						
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"SALDO FACTURADO" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblSaldoActual))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"VENDIDO NO FACTURADO" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblNOFacturado))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"SALDO TOTAL" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblSaldoActual + dblNOFacturado))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "</table>" +
						  "<table border='0' align='center' style='width: 100%' class='tabla'>" +						
//							this.getTotalesConvenioFacturas(strColor, dblTotalFactura, dblTotalPagado, dblTotalSaldo, dblTotalDentroPlazo, dblTotal30, dblTotal60, dblTotal90, dblTotal120, dblTotal180, dblTotal360, dblMas361, objFormatos) +
							this.getHeaderConvenioFacturas() +
							strReturn + 
//							this.getHeaderConvenioFacturas() +
							this.getTotalesConvenioFacturas(strColor, dblTotalFactura, dblTotalPagado, dblTotalSaldo, dblTotalDentroPlazo, dblTotal30, dblTotal60, dblTotal90, dblTotal120, dblTotal180, dblTotal360, dblMas361, objFormatos, objConvenioBean.getCconvenio().intValue(),bolReadOnly) +
						"</table>" +	
						"<div id='gridPagoGlobal" + objConvenioBean.getCconvenio() + "' style='visibility:hidden;display:none;'>" +                							
							"<table border='0' align='center' style='width: 100%' class='tabla'>" +						
								"<tr>"+
								  "<td>"+
								  	"<b>Fecha Deposito:</b>"+ 				
								  "</td>"+
								  "<td>"+
									  "<input type='text' id='txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + "' size='12' value='' style='background:#E6E6FA' onKeyup='javascript:agregaDiag(this);' onChange='javascript:this.value=validaFormatoFecha(this.value);validafechafrm(document.frmAdminClientes.txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + ");' onFocus='javascript:validafechafrm(document.frmAdminClientes.txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + ");'/>"+		
									  "<a href='javascript:doNothing()' onclick='javascript:setDateField(document.frmAdminClientes.txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + "); top.newWin =  ventanaNormal('/web2labportal/javascript/calendar.html','cal','WIDTH=230,HEIGHT=230')>"+
									  	"<img alt='Seleccione una fecha' id='imgFechaDeposito' border='0' src='/web2labportal/images/icono_calend.gif' />"+
									  "</a>"+	
								  "</td>"+			
							  "</tr>"+
								  
								"<tr>"+
									"<td>"+
										  "<b>Hora Deposito:</b>"+ 				
									"</td>"+
									"<td>"+
										  	"<select id='selhora" + objConvenioBean.getCconvenio() + "' style='background:#E6E6FA'></select>"+
											"<b>:</b>"+
											"<select id='selminutos" + objConvenioBean.getCconvenio() + "' style='background:#E6E6FA'></select>"+
											"<b>:</b>"+
											"<select id='selsegundos" + objConvenioBean.getCconvenio() + "' style='background:#E6E6FA'></select>"+
									"</td>"+			
								"</tr>"+
							  
							  "<tr>"+
								  "<td>"+
									  "<b>Institucion Deposito:</b>"+ 				
								  "</td>"+
								  "<td>"+
									  "<select id='selTipoPago" + objConvenioBean.getCconvenio() + "' style='background:#E6E6FA' >"+	strFormaPago +						  
									  "</select>"+	
								  "</td>"+			
							  "</tr>"+
								  
								"<tr>"+
								"<td>"+
									"<b>Forma de Pago:</b>"+
								"</td>"+
								"<td>"+
									"<select id='selFormaPago" + objConvenioBean.getCconvenio() + "' style='width: 120px' style='background:#E6E6FA' align='up'>"+
												"<option value='0'>Seleccionar</option>"+
											    "<option value='1'>01 - Efectivo</option>"+
											    "<option value='2'>02 - Cheque nominativo</option>"+
											   	"<option value='3'>03 - Transferencia electrónica de fondos</option>"+
											   	"<option value='4'>04 - Tarjeta de crédito</option>"+
											   	"<option value='5'>05 - Monedero electrónico</option>"+ 
											   	"<option value='6'>06 - Dinero electrónico</option>"+
											    "<option value='8'>08 - Vales de despensa</option>"+
											   	"<option value='12'>12 - Dación en pago</option>"+
											   	"<option value='13'>13 - Pago por subrogación</option>"+
											   	"<option value='14'>14 - Pago por consignación</option>"+ 
											   	"<option value='15'>15 - Condonación</option>"+
											    "<option value='17'>17 - Compensación</option>"+
											   	"<option value='23'>23 - Novación</option>"+
											   	"<option value='24'>24 - Confusión</option>"+
											   	"<option value='25'>25 - Remisión de deuda</option>"+
											   	"<option value='26'>26 - Prescripción o caducidad</option>"+
											   	"<option value='27'>27 - A satisfacción del acreedor</option>"+
											   	"<option value='28'>28 - Tarjeta de débito</option>"+
											   	"<option value='29'>29 - Tarjeta de servicios</option>"+
											   	"<option value='30'>30 - Aplicación de anticipos</option>"+
											   	"<option value='31'>31 - Intermediario pagos</option>"+
											   	"<option value='99'>99 - Por definir</option>"+
								     "</select>"+
								"</td>"+
								"</tr>"+
								
								"<tr>"+
									"<td>"+
									"</td>"+
									"<td>"+
										"<input type='checkbox' id='chkCrearComplento" + objConvenioBean.getCconvenio() + "' checked>Crear Complemento de Pago"+
									"</td>"+
								"</tr>"+
							  "<tr>"+
								  "<td>"+
								  "</td>"+
								  "<td>"+
									  "<input type=\"button\" value=\"Registrar Pago\" name=\"Registrar Pago\" class=\"boton\" onclick=\"pagosFacturas('" + objConvenioBean.getCconvenio() + "');\">"+
								  "</td>"+			
							  "</tr>"+
							"</table>" +	
						"</div>" +
						"</div>" +
						"</tr>" + 
						"<tr></tr>"; 
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("CuentasxCobrarMayoreoAjax.getFacturasConvenio:Exception....", aObjException);
    	    throw aObjException;
		} finally {
			objFormatearDate = null;
		}
	}	
	
	private String showBodyConvenioFacturasVentas(ConvenioBean objConvenioBean,boolean bolReadOnly) throws Exception
	{		
		TAntiguedadCxc objTAntiguedadCxcHB = new TAntiguedadCxc();
		FormateaFecha objFormatearDate = new FormateaFecha();
		Formatos objFormatos = new Formatos();
		AdministracionFOP_PDF objAdministracionFOP_PDF = new AdministracionFOP_PDF();
		String strReturn = "";		

		double dblTotalFactura = 0.0;
		double dblSaldoActual = 0.0;
		
		double dblTotalPagado = 0.0;
		double dblTotalSaldo = 0.0;
		double dblTotalDentroPlazo= 0.0;
		double dblTotal30= 0.0;
		double dblTotal60= 0.0;
		double dblTotal90= 0.0;
		double dblTotal120= 0.0;
		double dblTotal180= 0.0;
		double dblTotal360= 0.0;
		double dblMas361= 0.0;		
		String strColor = "black";
		String strNombreConvenio = objConvenioBean.getCconvenio() + " " + objConvenioBean.getSconvenio();		
		iObjLog.debug("Entrando a CuentasxCobrarMayoreoAjax.getFacturasConvenio:Entrando... ");
		try {
			 if (objConvenioBean.getLstFacturas() != null) {
				int y = 0; 
				String strReadOnlyNOPagos = "";
				String strReadOnlyNOPago = "";
				for (int i = 0; i < objConvenioBean.getLstFacturas().size() ; i++)
				{
					objTAntiguedadCxcHB = (TAntiguedadCxc)objConvenioBean.getLstFacturas().get(i);						
					y = i + 1;
					if (objTAntiguedadCxcHB.getSserie().trim().substring(0, 2).toString() == "NC") {
						strColor = "green";						
						dblTotalFactura = dblTotalFactura - objTAntiguedadCxcHB.getMtotalfactura().doubleValue();						
						dblSaldoActual = (dblSaldoActual - objTAntiguedadCxcHB.getMtotalfactura().doubleValue());							
					} else {
						strColor = "black";
						dblTotalFactura = dblTotalFactura + objTAntiguedadCxcHB.getMtotalfactura().doubleValue();						
						dblTotalPagado = (dblTotalPagado + objTAntiguedadCxcHB.getMpagado().doubleValue());
						dblTotalSaldo = (dblTotalSaldo + objTAntiguedadCxcHB.getMsaldo().doubleValue());						
						dblSaldoActual = (dblSaldoActual + objTAntiguedadCxcHB.getMsaldo().doubleValue());						
					}

					dblTotalDentroPlazo = dblTotalDentroPlazo 	+ objTAntiguedadCxcHB.getMdentroplazo().doubleValue();										
					dblTotal30 			= dblTotal30 			+ objTAntiguedadCxcHB.getM01a30().doubleValue();
					dblTotal60 			= dblTotal60 			+ objTAntiguedadCxcHB.getM31a60().doubleValue();
					dblTotal90 			= dblTotal90 			+ objTAntiguedadCxcHB.getM61a90().doubleValue();
					dblTotal120 		= dblTotal120 			+ objTAntiguedadCxcHB.getM91a120().doubleValue();
					dblTotal180 		= dblTotal180 			+ objTAntiguedadCxcHB.getM121a180().doubleValue();
					dblTotal360 		= dblTotal360 			+ objTAntiguedadCxcHB.getM181a360().doubleValue();
					dblMas361 		    = dblMas361 			+ objTAntiguedadCxcHB.getMmas361().doubleValue();

					if (bolReadOnly) {
						strReadOnlyNOPagos = "<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											 "		<input type=\"hidden\" name=\"hdnAnticipoSaldo\" value=\"" + objTAntiguedadCxcHB.getMpagado().doubleValue() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnSaldoFactura\"  value=\"" + objTAntiguedadCxcHB.getMsaldo().doubleValue() + "\">" +
											 "		<input type=\"hidden\" name=\"hdnkFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getKfactura() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnsFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getSserie() + "\">" + 
											 "</td>";
						strReadOnlyNOPago =  "<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
												objTAntiguedadCxcHB.getSserie()  +
											 "</td>";
					} else {
						/*strReadOnlyNOPagos = "<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											 "		<input type=\"checkbox\" name=\"chkPagos\" value=\"" + objTAntiguedadCxcHB.getKfactura() + "\" onClick=\"javascript:aceptaPago('" + objConvenioBean.getCconvenio() + "');\" disabled> " +
											 "		<input type=\"text\"   name=\"txtMontoAPagar\" onChange=\"javascript:aceptaPago('" + objConvenioBean.getCconvenio() + "');\" value=\"" + objTAntiguedadCxcHB.getMsaldo().doubleValue() + "\" size=\"4\" style=\"text-align: right\" >" +
											 "		<input type=\"hidden\" name=\"hdnAnticipoSaldo\" value=\"" + objTAntiguedadCxcHB.getMpagado().doubleValue() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnSaldoFactura\"  value=\"" + objTAntiguedadCxcHB.getMsaldo().doubleValue() + "\">" +
											 "		<input type=\"hidden\" name=\"hdnkFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getKfactura() + "\">" + 
											 "		<input type=\"hidden\" name=\"hdnsFacturaSaldo\" value=\"" + objTAntiguedadCxcHB.getSserie() + "\">" + 
											 "</td>";
						*/
						strReadOnlyNOPagos = "";
						strReadOnlyNOPago =  "<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick=\"javascript:showSubModalPago(" + objTAntiguedadCxcHB.getKfactura() + ",'" + objTAntiguedadCxcHB.getSserie() +"');\" align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
												objTAntiguedadCxcHB.getSserie()  +
											 "</td>";
					}
					strReturn += ("<tr>" + 
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
										"	<a href=\"javascript:visualizarFactura('http://192.237.150.66:9085/FacturasElectronicas_Olab/XMLTMP/PDF/FacturacionElectronica_" + objTAntiguedadCxcHB.getSserie() + ".pdf');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor + "; font-style: normal; font-variant: normal;'>"  +  
				    		            "		<img alt='Factura - PDF' id=\"imgPDF\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoPdf.png' />" +
										"	</a>" + 													
										"</td>" + strReadOnlyNOPago +
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											objFormatearDate.getFecha(objTAntiguedadCxcHB.getDregistro()) +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											objFormatearDate.getFecha(objTAntiguedadCxcHB.getDvencido()) +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											(int)objTAntiguedadCxcHB.getUdiasvencido() +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMtotalfactura().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMpagado().doubleValue() + "") +
										"</td>" + strReadOnlyNOPagos +											
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMsaldo().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getMdentroplazo().doubleValue()  + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getM01a30().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getM31a60().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(objTAntiguedadCxcHB.getM61a90().doubleValue() + "") +
										"</td>" + 
										"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero((objTAntiguedadCxcHB.getM91a120().doubleValue() + objTAntiguedadCxcHB.getM121a180().doubleValue() + objTAntiguedadCxcHB.getM181a360().doubleValue() + objTAntiguedadCxcHB.getMmas361().doubleValue())  + "") +
										"</td>" + 
									 "</tr>");
				}
			}
			strColor = "black"; 	
			String strPathFOP90 = "";
			double dblNOFacturado = 0.0;
			if (objConvenioBean.getCconvenio().intValue() >= 309 && objConvenioBean.getCconvenio().intValue() <= 312) {
				dblNOFacturado = this.getMontoNOFacturado("309,310,311,312");
			} else {
				dblNOFacturado = this.getMontoNOFacturado(objConvenioBean.getCconvenio() + "");
			}
			ReporteEstadoCuentaCxC objReporteEstadoCuentaCxC = new ReporteEstadoCuentaCxC(dblNOFacturado,objConvenioBean.getLstFacturas());
			objReporteEstadoCuentaCxC.setCcliente(objConvenioBean.getCcliente());
			objReporteEstadoCuentaCxC.setScliente(objConvenioBean.getScliente());
			objReporteEstadoCuentaCxC.setSrfc(objConvenioBean.getSrfc());
			objReporteEstadoCuentaCxC.setSdireccion(objConvenioBean.getSdireccion());
			objReporteEstadoCuentaCxC.setCconvenio(objConvenioBean.getCconvenio());
			objReporteEstadoCuentaCxC.setSconvenio(objConvenioBean.getSconvenio());
			objReporteEstadoCuentaCxC.LoadTotales();
			iObjSesion = HibernateUtil.getSession();			
            CatalogosPKGCatalogosDao objCatalogosPKGCatalogosDao = new CatalogosPKGCatalogosDao(iObjSesion);
            List retorno = objCatalogosPKGCatalogosDao.obtenAll("TipoPagoFactura",0);
            String strFormaPago = "";
            for( int inti = 0;inti < retorno.size(); inti++) {
            	CTipoPagoFactura objCTipoPagoFactura = (CTipoPagoFactura)retorno.get(inti);
            	strFormaPago  += "<option value='" + objCTipoPagoFactura.getCtipopago() + "'>" + objCTipoPagoFactura.getStipopago() + "</option>";
            }
			if (objReporteEstadoCuentaCxC.getLstRowReporteCxC90().size() > 0) {
				strPathFOP90 = objAdministracionFOP_PDF.createDocument(objReporteEstadoCuentaCxC.generaFile(), "ReporteCxC_90Dias_" + objConvenioBean.getCconvenio(),objConvenioBean.getCmarca());
			}
			strReturn = "<tr>" +
					 		"<table border='0' align='center' style='width: 100%' class='tabla'>" + 
							  "<tr>" + 
								"<td align='left' onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" align='bottom' style='font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;'>Convenio "  +  strNombreConvenio.trim()  +
									"</a>" + 
								"</td>" + 
								"<td align='left' style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:abrirVentana('" + strPathFOP90 + "','SaldoCxC');\" align=\"bottom\" style=\"font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;\">90 Dias  "  +  
									"</a>" + 
								"</td>" + 
							  "</tr>"	+					 
						    "</table>" +	
						"</tr>" +						
						"<tr>" + 
						"<div id='gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "' style='visibility:hidden;display:none;'>" +                
			 			"<table border='0' align='center' style='width: 100%' class='tabla'>" +						
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"SALDO FACTURADO" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblSaldoActual))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"VENDIDO NO FACTURADO" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblNOFacturado))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"SALDO TOTAL" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblSaldoActual + dblNOFacturado))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "</table>" +
						  "<table border='0' align='center' style='width: 100%' class='tabla'>" +						
//							this.getTotalesConvenioFacturas(strColor, dblTotalFactura, dblTotalPagado, dblTotalSaldo, dblTotalDentroPlazo, dblTotal30, dblTotal60, dblTotal90, dblTotal120, dblTotal180, dblTotal360, dblMas361, objFormatos) +
							this.getHeaderConvenioFacturasVentas() +
							strReturn + 
//							this.getHeaderConvenioFacturas() +
							this.getTotalesConvenioFacturasVentas(strColor, dblTotalFactura, dblTotalPagado, dblTotalSaldo, dblTotalDentroPlazo, dblTotal30, dblTotal60, dblTotal90, dblTotal120, dblTotal180, dblTotal360, dblMas361, objFormatos, objConvenioBean.getCconvenio().intValue(),bolReadOnly) +
						"</table>" +	
						"<div id='gridPagoGlobal" + objConvenioBean.getCconvenio() + "' style='visibility:hidden;display:none;'>" +                							
							"<table border='0' align='center' style='width: 100%' class='tabla'>" +						
								"<tr>"+
								  "<td>"+
								  	"<b>Fecha Deposito:</b>"+ 				
								  "</td>"+
								  "<td>"+
									  "<input type='text' id='txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + "' size='12' value='' style='background:#E6E6FA' onKeyup='javascript:agregaDiag(this);' onChange='javascript:this.value=validaFormatoFecha(this.value);validafechafrm(document.frmAdminClientes.txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + ");' onFocus='javascript:validafechafrm(document.frmAdminClientes.txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + ");' />"+		
									  "<a href='javascript:doNothing()' onclick='javascript:setDateField(document.frmAdminClientes.txtFechaDepositoGlobal" + objConvenioBean.getCconvenio() + "); top.newWin =  ventanaNormal('/web2labportal/javascript/calendar.html','cal','WIDTH=230,HEIGHT=230')>"+
									  	"<img alt='Seleccione una fecha' id='imgFechaDeposito' border='0' src='/web2labportal/images/icono_calend.gif' />"+
									  "</a>"+	
								  "</td>"+			
								"</tr>"+
								"<tr>"+
								  "<td>"+
									  "<b>Hora Deposito:</b>"+ 				
								  "</td>"+
								  "<td>"+
									  	"<select id='selhora" + objConvenioBean.getCconvenio() + "' style='background:#E6E6FA'></select>"+
										"<b>:</b>"+
										"<select id='selminutos" + objConvenioBean.getCconvenio() + "' style='background:#E6E6FA'></select>"+
										"<b>:</b>"+
										"<select id='selsegundos" + objConvenioBean.getCconvenio() + "' style='background:#E6E6FA'></select>"+
								  "</td>"+			
							  "</tr>"+
							  "<tr>"+
								  "<td>"+
									  "<b>Institucion Deposito:</b>"+ 				
								  "</td>"+
								  "<td>"+
									  "<select id='selTipoPago" + objConvenioBean.getCconvenio() + "' style='background:#E6E6FA' >"+	strFormaPago +						  
									  "</select>"+	
								  "</td>"+			
							  "</tr>"+								
							"<tr>"+
								"<td>"+
									"<b>Forma de Pago:</b>"+
								"</td>"+
								"<td>"+
									"<select id='selFormaPago" + objConvenioBean.getCconvenio() + "' style='width: 120px' style='background:#E6E6FA' align='up'>"+
										"<option value='1'>01 - Efectivo</option>"+
									    "<option value='2'>02 - Cheque nominativo</option>"+
									   	"<option value='3'>03 - Transferencia electrónica de fondos</option>"+
									   	"<option value='4'>04 - Tarjeta de crédito</option>"+
									   	"<option value='5'>05 - Monedero electrónico</option>"+ 
									   	"<option value='6'>06 - Dinero electrónico</option>"+
									    "<option value='8'>08 - Vales de despensa</option>"+
									   	"<option value='12'>12 - Dación en pago</option>"+
									   	"<option value='13'>13 - Pago por subrogación</option>"+
									   	"<option value='14'>14 - Pago por consignación</option>"+ 
									   	"<option value='15'>15 - Condonación</option>"+
									    "<option value='17'>17 - Compensación</option>"+
									   	"<option value='23'>23 - Novación</option>"+
									   	"<option value='24'>24 - Confusión</option>"+
									   	"<option value='25'>25 - Remisión de deuda</option>"+
									   	"<option value='26'>26 - Prescripción o caducidad</option>"+
									   	"<option value='27'>27 - A satisfacción del acreedor</option>"+
									   	"<option value='28'>28 - Tarjeta de débito</option>"+
									   	"<option value='29'>29 - Tarjeta de servicios</option>"+
									   	"<option value='30'>30 - Aplicación de anticipos</option>"+
									   	"<option value='31'>31 - Intermediario pagos</option>"+
									   	"<option value='99'>99 - Por definir</option>"+
								     "</select>"+
								"</td>"+
							"</tr>"+								
							"<tr>"+
								"<td>"+
								"</td>"+
								"<td>"+
									"<input type='checkbox' id='chkCrearComplento" + objConvenioBean.getCconvenio() + "' checked>Crear Complemento de Pago"+
								"</td>"+
							"</tr>"+
							  
							  "<tr>"+
								  "<td>"+
								  "</td>"+
								  "<td>"+
									  "<input type=\"button\" value=\"Registrar Pago\" name=\"Registrar Pago\" class=\"boton\" onclick=\"pagosFacturas('" + objConvenioBean.getCconvenio() + "');\">"+
								  "</td>"+			
							  "</tr>"+
							"</table>" +	
						"</div>" +
						"</div>" +
						"</tr>" + 
						"<tr></tr>"; 
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("CuentasxCobrarMayoreoAjax.getFacturasConvenio:Exception....", aObjException);
    	    throw aObjException;
		} finally {
			objFormatearDate = null;
		}
	}
	
	
	private String getHeaderConvenioFacturas() {
		return ("<tr>" + 
					"<th  style='width: 3%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>#" + 
					"	</font></b>" +
					"</th>" + 
					"<th  style='width: 8%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Folio" + 
					"	</font></b>" +
					"</th>" + 
					"<th  style='width: 8%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Fecha" + 
					"</th>" + 
					"<th  style='width: 8%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Vencido" + 
					"</th>" + 
					"<th  style='width: 2.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Dias" + 
					"</th>" +
					"<th  style='width: 8%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Total" + 
					"</th>" +					
					"<th  style='width: 7%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Pagado" + 
					"</th>" +
					"<th  style='width: 9%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>A Pagar" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Saldo" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Dentro" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>01 a 30" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>31 a 60" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>61 a 90" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Mas 90" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Status Factura" + 
					"</th>" +
				"</tr>");
	}
	
	private String getHeaderConvenioFacturasVentas() {
		return ("<tr>" + 
					"<th  style='width: 3%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>#" + 
					"	</font></b>" +
					"</th>" + 
					"<th  style='width: 8%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Folio" + 
					"	</font></b>" +
					"</th>" + 
					"<th  style='width: 8%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Fecha" + 
					"</th>" + 
					"<th  style='width: 8%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Vencido" + 
					"</th>" + 
					"<th  style='width: 2.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Dias" + 
					"</th>" +
					"<th  style='width: 8%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Total" + 
					"</th>" +					
					"<th  style='width: 7%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Pagado" + 
					"</th>" +
					//"<th  style='width: 9%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					//"	<b><font color='black'>A Pagar" + 
					//"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Saldo" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Dentro" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>01 a 30" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>31 a 60" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>61 a 90" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Mas 90" + 
					"</th>" +
					"<th  style='width: 8.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Status Factura" + 
					"</th>" +
				"</tr>");
	}
	
	
	private String getTotalesConvenioFacturas(String strColor,
											  double dblTotalFactura,
											  double dblTotalPagado,
											  double dblTotalSaldo,
											  double dblTotalDentroPlazo,
											  double dblTotal30,
											  double dblTotal60,
											  double dblTotal90,
											  double dblTotal120,
											  double dblTotal180,
											  double dblTotal360,
											  double dblMas361,											  
											  Formatos objFormatos,
											  int cConvenio,
											  boolean bolReadOnly) {
		String strReadOnly = "";
		if (bolReadOnly) {
			strReadOnly = "";
		} else {
			strReadOnly = "	<input type=\"text\" id=\"txtMontoAPagarTotal" + cConvenio + "\" value=\"0\" size=\"6\" style=\"text-align: right\">";
		}
		return	("<tr>" + 
					"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
					"</td>" + 
					"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
					"</td>" + 
					"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
					"</td>" + 
					"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
					"	<b style='font-weight: bold; font-size: xx-small; color: black; font-style: normal; font-variant: normal'>Totales</b>" +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
//						"	<b style='font-weight: bold; font-size: xx-small; color: black; font-style: normal; font-variant: normal'>Totales</b>" +
					"</td>" + 
					"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalFactura))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalPagado))) +
					"</td>" + 
					"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						strReadOnly + 
					"</td>" + 
					"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalSaldo))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalDentroPlazo))) +
					"</td>" + 
					"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal30))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal60))) +
					"</td>" + 
					"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal90))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal120 + dblTotal180 + dblTotal360 + dblMas361))) +
					"</td>" + 
				"</tr>");		
	}
	
	private String getTotalesConvenioFacturasVentas(String strColor,
			double dblTotalFactura,
			double dblTotalPagado,
			double dblTotalSaldo,
			double dblTotalDentroPlazo,
			double dblTotal30,
			double dblTotal60,
			double dblTotal90,
			double dblTotal120,
			double dblTotal180,
			double dblTotal360,
			double dblMas361,											  
			Formatos objFormatos,
			int cConvenio,
			boolean bolReadOnly) {
String strReadOnly = "";
if (bolReadOnly) {
strReadOnly = "";
} else {
strReadOnly = "	<input type=\"text\" id=\"txtMontoAPagarTotal" + cConvenio + "\" value=\"0\" size=\"6\" style=\"text-align: right\">";
}
return("<tr>" + 
"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
"</td>" + 
"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
"</td>" + 
"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
"</td>" + 
"<td align='center' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
"	<b style='font-weight: bold; font-size: xx-small; color: black; font-style: normal; font-variant: normal'>Totales</b>" +
"</td>" + 
"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
//"	<b style='font-weight: bold; font-size: xx-small; color: black; font-style: normal; font-variant: normal'>Totales</b>" +
"</td>" + 
"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalFactura))) +
"</td>" + 
"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalPagado))) +
"</td>" + 
//"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
//strReadOnly + 
//"</td>" + 
"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalSaldo))) +
"</td>" + 
"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalDentroPlazo))) +
"</td>" + 
"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal30))) +
"</td>" + 
"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal60))) +
"</td>" + 
"<td align='right' style='font-weight: bold; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal90))) +
"</td>" + 
"<td align='right' style='font-weight: normal; font-size: xx-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal120 + dblTotal180 + dblTotal360 + dblMas361))) +
"</td>" + 
"</tr>");		
}
				
	private double getMontoNOFacturado(String cConvenios) throws Exception {
		iObjLog.debug("Entrando PagoFacturaDao.getMontoNOFacturado:  " + cConvenios);
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		double dblReturn = 0.0;
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
    		strQuery =  "SELECT sum(tosf.mfacturaempresa) as mNOFacturado												\n" +																								
			    		"FROM t_orden_sucursal_fac tosf      															\n" +
			    		"WHERE kordensucursalfac = (SELECT get_max_t_orden_suc_fac (kordensucursal)) and 				\n" +
			    		"      tosf.cestadoregistro not in (35,48,39)    					and 						\n" +                                												
			    		"      kordensucursal in (SELECT tos.kordensucursal                     						\n" +              																
			    		"			 FROM t_orden_sucursal tos INNER JOIN t_orden_sucursal_fac tosf 					\n" +
			    		"					ON tos.kordensucursal=tosf.kordensucursal 		and							\n" +			
			    		"				tosf.cconvenio IN (" +  cConvenios + ")			    and 						\n" +
			    		"				tosf.cestadoregistro not in (35,48,39)   										\n" +
			    		"			 WHERE tos.cestadoregistro not in (17) and 											\n" +
			    		"				(tos.dregistro between (sysdate)-60											 	\n" +
			    		"				 and sysdate))		  															\n";
				iObjLog.debug("Consulta PagoFacturaDao.getMontoNOFacturado...  " + strQuery);
				objRst = objStmt.executeQuery(strQuery);
				while (objRst.next()) {
					dblReturn = objRst.getDouble("mNOFacturado");
				}
				objRst.close();
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.getMontoNOFacturado: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
//        	HibernateUtil.closeSession();
		}		
		return dblReturn;
	}			

	public double getMontoNOFacturadoCliente(String cCliente) throws Exception {
		iObjLog.debug("Entrando PagoFacturaDao.getMontoNOFacturado:  " + cCliente);
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		double dblReturn = 0.0;
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
    		strQuery =  "SELECT sum(tosf.mfacturaempresa) as mNOFacturado												\n" +																								
			    		"FROM t_orden_sucursal_fac tosf 														     	\n" +
			    		"WHERE kordensucursalfac = (SELECT get_max_t_orden_suc_fac (kordensucursal)) and 				\n" +
			    		"      tosf.cestadoregistro not in (35,48,39)    					and 						\n" +                                												
			    		"      kordensucursal in (SELECT tos.kordensucursal                     						\n" +              																
			    		"			 FROM t_orden_sucursal tos INNER JOIN t_orden_sucursal_fac tosf 					\n" +
			    		"					ON tos.kordensucursal=tosf.kordensucursal  and 								\n" +
			    		"				tosf.cestadoregistro not in (35,48,39)   										\n" +
			    		"					inner join c_convenio cc on tos.cconvenio=cc.cconvenio	and					\n" +		
			    		"				cc.ccliente IN (" +  cCliente + ")			    	 							\n" +
			    		"			 WHERE tos.cestadoregistro not in (17) and 											\n" +
			    		"				(tos.dregistro between (sysdate)-60 											\n" +
			    		"				 and sysdate))		  															\n";
				iObjLog.debug("Consulta PagoFacturaDao.getMontoNOFacturado...  " + strQuery);
				objRst = objStmt.executeQuery(strQuery);
				while (objRst.next()) {
					dblReturn = objRst.getDouble("mNOFacturado");
				}
				objRst.close();
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.getMontoNOFacturado: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
//        	HibernateUtil.closeSession();
		}		
		return dblReturn;
	}			

	public String getClientesAntiguedadCxC() throws Exception {
		iObjLog.debug("Entrando FacturacionMayoreoDao.getClientesAntiguedadCxC:  ");
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		String strReturn = "-1";
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
    		strQuery =  "SELECT distinct ccliente as ccliente	\n" +
    					"FROM reportes.t_antiguedad_cxc	  		\n" +
    					"ORDER BY ccliente						\n";
				iObjLog.debug("Consulta FacturacionMayoreoDao.getClientesAntiguedadCxC...  " + strQuery);
				objRst = objStmt.executeQuery(strQuery);
				while (objRst.next()) {
					strReturn += "," + (objRst.getInt("ccliente"));
				}
				objRst.close();
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getClientesAntiguedadCxC: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
//        	HibernateUtil.closeSession();
		}		
		return strReturn;
	}			
	
	
	
    private double redodedoDouble(double nD) {
		return Math.round(nD*Math.pow(10,2))/Math.pow(10,2);      	
    }		
    
    private long diferenciaDates(Date dblFechaComparar) {
    	java.util.Date hoy = new Date();  
        GregorianCalendar date1 = new GregorianCalendar();
        date1.setTime(dblFechaComparar); 
        GregorianCalendar date2 = new GregorianCalendar();
        date2.setTime(hoy); 
        long dias = 0;       
        if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
            dias =  date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR);
        } else {
            int diasAnyo = date1.isLeapYear(date1.get(Calendar.YEAR)) ? 366 : 365;
            int rangoAnyos = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);
            dias = (rangoAnyos * diasAnyo) + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR));
        }
    	return dias;
    }
}
