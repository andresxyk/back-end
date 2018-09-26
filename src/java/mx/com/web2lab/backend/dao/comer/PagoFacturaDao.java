package mx.com.web2lab.backend.dao.comer;

import java.io.File;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.comer.PagoFacturaBean;
import mx.com.web2lab.backend.dao.facturacion.mayoreo.FacturacionMayoreoDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CTipoPagoFactura;
import mx.com.web2lab.backend.hbm.om.ap.TFactura;
import mx.com.web2lab.backend.hbm.om.ap.TPagoFactura;
import mx.com.web2lab.backend.util.Consumo;
import mx.com.web2lab.backend.util.Formatos;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PagoFacturaDao {

	private static Log iObjLog = LogFactory.getLog(PagoFacturaDao.class);
	    
	private Session iObjSesion = null;
	
	private Formatos objFormatos = new Formatos();
	
	public PagoFacturaDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	
	public int pago(PagoFacturaBean objPagoFacturaBean,double monto, String formaPago, int marca,
			String rfcBanco, String nomBanco, String cuentaClabe) throws Exception{

		iObjLog.debug("Entrando PagoFacturaDao.pago:Entrando...  " + objPagoFacturaBean.getKfactura()+"  "+marca+"   "+formaPago);
		int kpago=0;
		Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;
		Query objQuery = null;
		String strQuery = "";
		String strSQL = "";
		int keycontrolfolio=0;
		if(marca==1){
			keycontrolfolio=161;
		}else if(marca==4){
			keycontrolfolio=161;
		}else if(marca==5){
			keycontrolfolio=161;
		}else if(marca==7){
			keycontrolfolio=161;
		}else if(marca==8){
			keycontrolfolio=161;
		}
		String forPago="";
		if(formaPago.length()==1){
			forPago="0"+formaPago;
		}else{
			forPago=formaPago;
		}
		
		String camposopcionales="";
		String datosopcionales="";
		if(rfcBanco.length()>0){
			camposopcionales+=", srfcbanco";
			datosopcionales+=",'"+rfcBanco+"'";
		}
		if(nomBanco.length()>0){
			camposopcionales+=", snombrebanco";
			datosopcionales+=",'"+nomBanco+"'";
		}
		if(cuentaClabe.length()>0){
			camposopcionales+=", snumerocuentaclabe";
			datosopcionales+=",'"+cuentaClabe+"'";
		}
		
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String fechaActual= hourFormat.format(date);
			
		strQuery="insert into t_pago_complemento(mmonto, cformapago, dfechapago, smoneda, ccontrolfolio, dfecharegistro"+camposopcionales+") "
				+ "VALUES ("+monto+",'"+forPago+"','"+objPagoFacturaBean.getDfechapago()+"', 'MXN',"+keycontrolfolio+",'"+fechaActual+"'"+datosopcionales+")";	
		
		strSQL="select kpagocomplemento from t_pago_complemento where mmonto="+monto+" and dfechapago ='"+objPagoFacturaBean.getDfechapago()+"' and dfecharegistro ='"+fechaActual+"'";
		try{
			iObjLog.debug("Entrando PagoFacturaDao.pago:Entrando...  " + strQuery);
			
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			objStatement.execute(strQuery);	
			
			
			rst = objStatement.executeQuery(strSQL);
			strSQL = "";
			if(rst != null) {
				while(rst.next()) {
					kpago=rst.getInt("kpagocomplemento");
					break;
				}				
				rst.close();
			}
			
		}catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.pago: ", aObjExcepcion);
			throw aObjExcepcion;			
    	}finally{
    		if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
    	}
		return kpago;
			
	}
	
	public int pagoMulti(Date fechaPago,double monto, String formaPago, int convenio, String kfactura,
			String rfcBanco, String nomBanco, String cuentaClabe) throws Exception{

		iObjLog.debug("Entrando PagoFacturaDao.pago:Entrando...  " + kfactura+"  "+convenio+"   "+formaPago);
		iObjSesion = HibernateUtil.getSession();
		int kpago=0;
		Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;
		ResultSet rstcons = null;
		Query objQuery = null;
		String strQuery = "";
		String strQueryCons = "";
		String strSQL = "";
		int cantiRegis=0;
		
		String forPago="";
		if(formaPago.length()==1){
			forPago="0"+formaPago;
		}else{
			forPago=formaPago;
		}
		
		int keycontrolfolio=0;
		
		int marca =convenio;
		//marca = getMarcarConvenio(convenio);
		if(marca==1){
			keycontrolfolio=161;
		}else if(marca==4){
			keycontrolfolio=161;
		}else if(marca==5){
			keycontrolfolio=161;
		}else if(marca==7){
			keycontrolfolio=161;
		}else if(marca==8){
			keycontrolfolio=161;
		}
		String camposopcionales="";
		String datosopcionales="";
		if(rfcBanco.length()>0){
			camposopcionales+=", srfcbanco";
			datosopcionales+=",'"+rfcBanco+"'";
		}
		if(nomBanco.length()>0){
			camposopcionales+=", snombrebanco";
			datosopcionales+=",'"+nomBanco+"'";
		}
		if(cuentaClabe.length()>0){
			camposopcionales+=", snumerocuentaclabe";
			datosopcionales+=",'"+cuentaClabe+"'";
		}
		
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String fechaActual= hourFormat.format(date);
		strQueryCons="select * from t_pago_factura where kfactura in ("+kfactura+") and cestadoregistro = 52";
		
		strQuery="insert into t_pago_complemento(mmonto, cformapago, dfechapago, smoneda, ccontrolfolio, dfecharegistro"+camposopcionales+") "
				+ "VALUES ("+monto+",'"+forPago+"','"+fechaPago+"', 'MXN',"+keycontrolfolio+",'"+fechaActual+"'"+datosopcionales+")";	
		
		strSQL="select kpagocomplemento from t_pago_complemento where mmonto="+monto+" and dfechapago ='"+fechaPago+"' and dfecharegistro ='"+fechaActual+"'";		
		
		try{
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			iObjLog.debug("Entrando PagoFacturaDao.pago:Query...  " + strQueryCons);
			rstcons = objStatement.executeQuery(strQueryCons);
			if(rstcons != null) {
				while(rstcons.next()) {
					cantiRegis++;
				}
				rstcons.close();
			}
			
			String [] cantFac = kfactura.split(",");
			if(cantiRegis<cantFac.length){
				
				iObjLog.debug("Entrando PagoFacturaDao.pago:Query...  " + strQuery);
				objStatement.execute(strQuery);					
				iObjLog.debug("Entrando PagoFacturaDao.pago:Query...  " + strSQL);
				rst = objStatement.executeQuery(strSQL);
				strSQL = "";
				if(rst != null) {
					while(rst.next()) {
						kpago=rst.getInt("kpagocomplemento");
						break;
					}				
					rst.close();
				}
			}
		}catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.pago: ", aObjExcepcion);
			throw aObjExcepcion;			
    	}finally{    		
			    		
    		if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
			if (rst != null) {
				rst.close();
				rst = null;
			}
	    	HibernateUtil.closeSession();
    	}
		return kpago;			
	}
	
	
	public int getMarcarConvenio(int convenio) throws Exception{
		int marca=0;
		String strSQL = "";
		Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;		
		strSQL="select cmarca from e_convenio where cconvenio ="+convenio;
		try{
			iObjLog.debug("Entrando PagoFacturaDao.getMarcarConvenio:Entrando...  " + strSQL);			
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();	
			rst = objStatement.executeQuery(strSQL);
			strSQL = "";
			if(rst != null) {
				while(rst.next()) {
					marca=rst.getInt("cmarca");
					break;
				}				
				rst.close();
			}			
		}catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.getMarcarConvenio: ", aObjExcepcion);
			throw aObjExcepcion;			
    	}finally{
    		if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
    	}		
		return marca;
	}
	
	public void updatePagoFactura(int keypago , int kfactura) throws Exception{
		iObjLog.debug("Entrando PagoFacturaDao.updatePagoFactura:Entrando...  " + keypago+"  "+kfactura);
		
		Connection objConn 	   = null;
		Statement objStatement = null;
		String strQuery = "";	
		
		strQuery = "update t_pago_factura set kpago = "+keypago+" where kfactura = "+kfactura+" and cestadoregistro = 52";
				
		try{
			iObjLog.debug("Entrando PagoFacturaDao.updatePagoFactura:Entrando...  " + strQuery);
			
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			if(keypago>0){
				objStatement.execute(strQuery);					
			}
			
		}catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.updatePagoFactura: ", aObjExcepcion);
			throw aObjExcepcion;			
    	}finally{
    		if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
    	}
	}
	
	public void insertPagoFactura(TPagoFactura objTPagoFactura ,int keypago) throws Exception{
		iObjLog.debug("Entrando PagoFacturaDao.updatePagoFactura:Entrando...  " + keypago+"  "+objTPagoFactura.getKpagofactura());		
		Connection objConn 	   = null;
		Statement objStatement = null;
		String strQuery = "";			
		strQuery = "INSERT INTO t_pago_factura("+
            "kpagofactura, kfactura, mtotalfactura, manticipo, mpago, msaldo, ctipopago, user_id, cestadoregistro, dregistro, dfechapago, ugrupopago,"+ 
            "knotacredito, kpago) VALUES (nextval('t_pago_factura_sequence'::regclass),"+objTPagoFactura.getTfactura().getKfactura()+
            ", "+objTPagoFactura.getMtotalfactura()+", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";				
		try{
			iObjLog.debug("Entrando PagoFacturaDao.updatePagoFactura:Entrando...  " + strQuery);			
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			if(keypago>0){
				objStatement.execute(strQuery);					
			}			
		}catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.updatePagoFactura: ", aObjExcepcion);
			throw aObjExcepcion;			
    	}finally{
    		if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
    	}
	}
	
	public void updateMontosTFactura(int kfactura, BigDecimal total, BigDecimal subtotal)throws Exception{
		iObjLog.debug("Entrando PagoFacturaDao.updateMontosTFactura:Entrando...  "+kfactura+"      " + total+"  "+subtotal);
		Connection objConn 	   = null;
		Statement objStatement = null;
		String strQuery = "UPDATE T_FACTURA SET mtotal = "+total+", msubtotal = "+subtotal+", miva = "+(total.subtract(subtotal))+" "
				+ "where kfactura = "+kfactura;
		try{
			iObjLog.debug("Entrando PagoFacturaDao.updatePagoFactura:Entrando...  " + strQuery);			
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			if(kfactura>0){
				objStatement.execute(strQuery);					
			}			
		}catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.updatePagoFactura: ", aObjExcepcion);
			throw aObjExcepcion;			
    	}finally{
    		if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
    	}
	}
		

	public PagoFacturaBean pagoFactura(PagoFacturaBean objPagoFacturaBean, int keypago) throws Exception {
		iObjSesion = HibernateUtil.getSession();
				
		List objListaFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		TFactura objTFactura = null;
		TPagoFactura objTPagoFactura = new TPagoFactura();
		CTipoPagoFactura objTipoPagoFactura =  new CTipoPagoFactura();
		
    	try{
			iObjLog.debug("Entrando PagoFacturaDao.pagoFactura:Entrando...  " + objPagoFacturaBean.getKfactura()+"     "+keypago);
			 HibernateUtil.beginTrans(); 
			
			strQuery = "select bOF 															\n" +					
			   		   "from TFactura bOF 													\n" +	
			           "where bOF.kfactura in  (" + objPagoFacturaBean.getKfactura() + ") 	\n" +
			           "order by kfactura desc";
			iObjLog.debug("Entrando PagoFacturaDao.pagoFactura:Entrando...  " + strQuery);
			 objQuery = iObjSesion.createQuery(strQuery);                   
             objListaFactura = objQuery.list();
			if (objListaFactura != null) {
				if (objListaFactura.size() >0) {
					objTFactura = (TFactura)objListaFactura.get(0);
					
					PagoFacturaBean objPagoFacturaBeanActual = this.getDatosPagoFactura(objPagoFacturaBean.getKfactura(), false);
					
					objTipoPagoFactura.setCtipopago(new Integer(objPagoFacturaBean.getCtipopago()));
					/* Creacion de un nuevo Pago de la Factura */	
					objTPagoFactura.setCtipopago(objTipoPagoFactura);
					objTPagoFactura.setDfechapago(objPagoFacturaBean.getDfechapago());
					objTPagoFactura.setDregistro(objPagoFacturaBean.getDregistro());
					objTPagoFactura.setManticipo(objPagoFacturaBean.getManticipo());
					objTPagoFactura.setMpago(objPagoFacturaBean.getMpago());
					objTPagoFactura.setMtotalfactura(objTFactura.getMtotal());
					objTPagoFactura.setMsaldo(new BigDecimal(objPagoFacturaBean.getMsaldo().doubleValue() - objPagoFacturaBean.getMpago().doubleValue()));					
					objTPagoFactura.setTfactura(objTFactura);
					objTPagoFactura.setUserId(objPagoFacturaBean.getUserId());
					objTPagoFactura.setCestadoregistro(objPagoFacturaBean.getCestadoregistro());
					objTPagoFactura.setUgrupopago(objPagoFacturaBean.getUgrupopago());
					objTPagoFactura.setKnotacredito(new Integer(0));
					objTPagoFactura.setKpagocomplemento(new Integer(keypago));
					
					if (objPagoFacturaBeanActual.getMsaldo().doubleValue() >= objPagoFacturaBean.getMpago().doubleValue()) {
						iObjSesion.save(objTPagoFactura);					
						iObjSesion.flush(); 
						objPagoFacturaBean.setMsaldo(objTPagoFactura.getMsaldo());
						if (objTPagoFactura.getMsaldo().doubleValue() <= 0.0) {
							objTFactura.setCestadoregistro(51);
							iObjSesion.update(objTFactura);
							iObjSesion.flush();            					
						}						 
						objPagoFacturaBean.setSmensaje("Exito en el registro del Pago");
						objPagoFacturaBean.setKeypago(keypago);
					} else {
						objPagoFacturaBean.setSmensaje("Existe un error en el Sistema comunicarse con Gerencia de TI");
					}					
				}
			}
			iObjLog.debug("Entrando PagoFacturaDao.pagoFactura:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.pagoFactura: ", aObjExcepcion);
			throw aObjExcepcion;			
    	} finally{
    		objQuery = null;
            objListaFactura = null;
            objTPagoFactura = null;
	    	HibernateUtil.closeSession();
    	}		
    	return objPagoFacturaBean;
	}			

	/**
     * Versión 25 de Marzo 2013 
     BY Tomar en cuenta el registro 
     */
       public PagoFacturaBean getDatosPagoFactura(int kFactura, boolean bolcloseConection) throws Exception {
             List objListaFactura = null;
             iObjSesion = HibernateUtil.getSession();
             Query objQuery = null;
             Query objQuerySecond = null;
             String strQuery = "";
             TPagoFactura objTPagoFactura = new TPagoFactura();
             PagoFacturaBean objPagoFacturaBean = new PagoFacturaBean();
             TFactura objTFactura = null;
             String strFolioFactura = "";
             boolean bolExistenPagos = false;
       try{
                    iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Entrando...  " + kFactura);
                    HibernateUtil.beginTrans();                    
                    strQuery = "select bOF                                                                        \n" +                             
                                    "from TPagoFactura bOF                                                 \n" +  
                               "where bOF.tfactura.kfactura in  (" + kFactura + ") and bOF.cestadoregistro=52     \n" +
                                    "order by bOF.kpagofactura asc                                    ";
                    iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Entrando...  " + strQuery);
                    objQuery = iObjSesion.createQuery(strQuery);
                    objListaFactura = new ArrayList();                    
                    objListaFactura = objQuery.list();
                    if (objListaFactura != null) {
                           if (objListaFactura.size()>0) {
                                  bolExistenPagos = true;
                                  objPagoFacturaBean.setSgridpagos("");
                                  for (int inti= 0;inti< objListaFactura.size();inti++) {
                                        objTPagoFactura = (TPagoFactura)objListaFactura.get(inti);                             
                                        iObjLog.debug("Consulta FacturacionMayoreoDao.getDatosPagoFactura:Consulta...1  " + objTPagoFactura.getKpagofactura() + " Total " + objTPagoFactura.getMtotalfactura().doubleValue());
                                         objPagoFacturaBean.setCestadoregistro(objTPagoFactura.getCestadoregistro());
                                         objPagoFacturaBean.setCtipopago(objTPagoFactura.getCtipopago().getCtipopago().intValue());
                                        objPagoFacturaBean.setDfechapago(objTPagoFactura.getDfechapago());
                                        objPagoFacturaBean.setDregistro(objTPagoFactura.getDregistro());
                                         objPagoFacturaBean.setKfactura(objTPagoFactura.getTfactura().getKfactura().intValue());
                                         objPagoFacturaBean.setKpagofactura(objTPagoFactura.getKpagofactura());
                                        objPagoFacturaBean.setManticipo(new BigDecimal(objTPagoFactura.getManticipo().doubleValue() + objTPagoFactura.getMpago().doubleValue()));
                                        objPagoFacturaBean.setMpago(objTPagoFactura.getMpago());
                                        objPagoFacturaBean.setMsaldo(objTPagoFactura.getMsaldo());
                                         objPagoFacturaBean.setMtotalfactura(objTPagoFactura.getMtotalfactura());
                                        objPagoFacturaBean.setUserId(objTPagoFactura.getUserId());
                                         objPagoFacturaBean.setSformatofactura(FacturacionMayoreoDao.llenaIdFactura(objTPagoFactura.getTfactura().getSserie(), objTPagoFactura.getTfactura().getUfoliofactura() + "", 8));
                                         objPagoFacturaBean.setSgridpagos(objPagoFacturaBean.getSgridpagos() + this.getBodyPagos(objTPagoFactura));                                             
                                        strFolioFactura = "DETALLE PAGOS - FACTURA: " + FacturacionMayoreoDao.llenaIdFactura(objTPagoFactura.getTfactura().getSserie(), objTPagoFactura.getTfactura().getUfoliofactura() + "", 8) + " MONTO: $" + objTPagoFactura.getMtotalfactura();
                                  }
                                  objPagoFacturaBean.setSgridpagos(this.getEncabezadoPagos(strFolioFactura) + objPagoFacturaBean.getSgridpagos() + "</table>");
                           }
                    }
                    if (bolExistenPagos == false) {
                    	
                           objListaFactura.clear();
                           objListaFactura = null;
                           objListaFactura = new ArrayList();
                           strQuery = "select bOF                                                                                                   \n" +                             
                                           "from TFactura bOF                                                                                      \n" +  
                                      "where bOF.kfactura = (" + kFactura + ")   \n" +
                                      "order by kfactura";
                           iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Entrando...  " + strQuery);
                           objQuerySecond = iObjSesion.createQuery(strQuery);
                           objListaFactura = objQuerySecond.list();
                           if (objListaFactura != null) {
                                  if (objListaFactura.size()>0) {
                                        objTFactura = (TFactura)objListaFactura.get(0);
                                        iObjLog.debug("Consulta FacturacionMayoreoDao.getDatosPagoFactura:Consulta...2  " + objTFactura.getKfactura() + " " + objTFactura.getMtotal().doubleValue());
                                        objPagoFacturaBean.setSformatofactura(FacturacionMayoreoDao.llenaIdFactura(objTFactura.getSserie(), objTFactura.getUfoliofactura() + "", 8));
                                        if(objTFactura.getScadenaoriginal()!=null && !objTFactura.getScadenaoriginal().trim().equals("")){
	                                        String [] cadena=objTFactura.getScadenaoriginal().split("\\|");
	                                        if( (objTFactura.getMtotal().compareTo(new BigDecimal(cadena[11]))!=0) ){
	                                        	this.updateMontosTFactura(objTFactura.getKfactura().intValue(),new BigDecimal(cadena[11]), new BigDecimal(cadena[8]));
	                                        	objTFactura.setMtotal(new BigDecimal(cadena[11]));
	                                        }
                                       }else{                                    	   
                                    	   String rutaXML = FacturacionMayoreoDao.pathXmlTimbrado(objTFactura.getCsucursal())+objPagoFacturaBean.getSformatofactura()+".xml";
                                    	   File af = new File(rutaXML);
                                    	   if(af.exists()){
                                    		   String str =FacturacionMayoreoDao.xmlString(af);
                                    		   BigDecimal total = FacturacionMayoreoDao.obtenerTotal(str);
                                    		   BigDecimal subTotal = FacturacionMayoreoDao.obtenerSubTotal(str);
                                    		   if( (objTFactura.getMtotal().compareTo(total)!=0) ){
   	                                        	this.updateMontosTFactura(objTFactura.getKfactura().intValue(),total,subTotal);
   	                                        	objTFactura.setMtotal(total);
   	                                        }
                                    	   }                                    	   
                                       }
                                       objPagoFacturaBean.setMsaldo(objTFactura.getMtotal());
                                       objPagoFacturaBean.setMtotalfactura(objTFactura.getMtotal());
                                        objPagoFacturaBean.setManticipo(new BigDecimal(0));
                                        objPagoFacturaBean.setMpago(new BigDecimal(0));                                        
                                         
                                         objPagoFacturaBean.setKfactura(objTFactura.getKfactura().intValue());
                                        objPagoFacturaBean.setSgridpagos("");
                                  }
                           }
                    }
                    iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Saliendo...  ");
       } catch (Exception aObjExcepcion) { 
                    iObjLog.error("ERROR FacturacionMayoreoDao.getDatosPagoFactura: ", aObjExcepcion);
                    throw aObjExcepcion;                    
       } finally{
             objQuery = null;
             objQuerySecond = null;
             objListaFactura = null;
             objTPagoFactura = null;
             if (bolcloseConection) {
                    HibernateUtil.closeSession();
             }
       }            
       return objPagoFacturaBean;
       }      


	
	/**
     * Versión 11 de Junio 2013 
     BY Mostrar cuando esta cancelada una orden 
     */
	public PagoFacturaBean getDatosFacturaCancelada(int kFactura, boolean bolcloseConection) throws Exception {
		List objListaFactura = null;
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		Query objQuerySecond = null;
		String strQuery = "";
		TPagoFactura objTPagoFactura = new TPagoFactura();
		PagoFacturaBean objPagoFacturaBean = new PagoFacturaBean();
		TFactura objTFactura = null;
		String strFolioFactura = "";
		boolean bolExistenPagos = false;
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosFacturaCancelada:Entrando...  " + kFactura);
			HibernateUtil.beginTrans();			
			strQuery = "select bOF 											\n" +					
			   		   "from TPagoFactura bOF 								\n" +	
			           "where bOF.tfactura.kfactura in  (" + kFactura + ") and bOF.cestadoregistro=52	\n" +
			   		   "order by bOF.kpagofactura asc						  ";
			iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosFacturaCancelada:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = new ArrayList();			
			objListaFactura = objQuery.list();
			if (objListaFactura != null) {
				if (objListaFactura.size()>0) {
					bolExistenPagos = true;
					objPagoFacturaBean.setSgridpagos("");
					for (int inti= 0;inti< objListaFactura.size();inti++) {
						objTPagoFactura = (TPagoFactura)objListaFactura.get(inti);					
						iObjLog.debug("Consulta FacturacionMayoreoDao.getDatosFacturaCancelada:Consulta...1  " + objTPagoFactura.getKpagofactura() + " Total " + objTPagoFactura.getMtotalfactura().doubleValue());
						objPagoFacturaBean.setCestadoregistro(objTPagoFactura.getCestadoregistro());
						objPagoFacturaBean.setCtipopago(objTPagoFactura.getCtipopago().getCtipopago().intValue());
						objPagoFacturaBean.setDfechapago(objTPagoFactura.getDfechapago());
						objPagoFacturaBean.setDregistro(objTPagoFactura.getDregistro());
						objPagoFacturaBean.setKfactura(objTPagoFactura.getTfactura().getKfactura().intValue());
						objPagoFacturaBean.setKpagofactura(objTPagoFactura.getKpagofactura());
						objPagoFacturaBean.setManticipo(new BigDecimal(objTPagoFactura.getManticipo().doubleValue() + objTPagoFactura.getMpago().doubleValue()));
						objPagoFacturaBean.setMpago(objTPagoFactura.getMpago());
						objPagoFacturaBean.setMsaldo(objTPagoFactura.getMsaldo());
						objPagoFacturaBean.setMtotalfactura(objTPagoFactura.getMtotalfactura());
						objPagoFacturaBean.setUserId(objTPagoFactura.getUserId());
						objPagoFacturaBean.setSformatofactura(FacturacionMayoreoDao.llenaIdFactura(objTPagoFactura.getTfactura().getSserie(), objTPagoFactura.getTfactura().getUfoliofactura() + "", 8));
						objPagoFacturaBean.setSgridpagos(objPagoFacturaBean.getSgridpagos() + this.getBodyPagos(objTPagoFactura));							
						strFolioFactura = "DETALLE PAGOS - FACTURA: " + FacturacionMayoreoDao.llenaIdFactura(objTPagoFactura.getTfactura().getSserie(), objTPagoFactura.getTfactura().getUfoliofactura() + "", 8) + " MONTO: $" + objTPagoFactura.getMtotalfactura();
					}
					objPagoFacturaBean.setSgridpagos(this.getEncabezadoPagosCancelacion(strFolioFactura) + objPagoFacturaBean.getSgridpagos() + "</table>");
				}
			}
			if (bolExistenPagos == false) {
				objListaFactura.clear();
				objListaFactura = null;
				objListaFactura = new ArrayList();
				strQuery = "select bOF 															\n" +					
				   		   "from TFactura bOF 													\n" +	
				           "where bOF.kfactura = (" + kFactura + ") 	\n" +
				           "order by kfactura";
				iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Entrando...  " + strQuery);
				objQuerySecond = iObjSesion.createQuery(strQuery);
				objListaFactura = objQuerySecond.list();
				if (objListaFactura != null) {
					if (objListaFactura.size()>0) {
						objTFactura = (TFactura)objListaFactura.get(0);
						iObjLog.debug("Consulta FacturacionMayoreoDao.getDatosPagoFactura:Consulta...2  " + objTFactura.getKfactura() + " " + objTFactura.getMtotal().doubleValue());
						objPagoFacturaBean.setManticipo(new BigDecimal(0));
						objPagoFacturaBean.setMpago(new BigDecimal(0));
						objPagoFacturaBean.setMsaldo(objTFactura.getMtotal());
						objPagoFacturaBean.setCestadoregistro(objTFactura.getCestadoregistro());
						objPagoFacturaBean.setMtotalfactura(objTFactura.getMtotal());
						objPagoFacturaBean.setSformatofactura(FacturacionMayoreoDao.llenaIdFactura(objTFactura.getSserie(), objTFactura.getUfoliofactura() + "", 8));
						objPagoFacturaBean.setKfactura(objTFactura.getKfactura().intValue());
						objPagoFacturaBean.setSgridpagos(this.getEncabezadoCancelacion(strFolioFactura) + "</table>");
					}
				}
			}
			objPagoFacturaBean.setSmensaje("CANCELADA");
			iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getDatosPagoFactura: ", aObjExcepcion);
			throw aObjExcepcion;			
    	} finally{
    		objQuery = null;
    		objQuerySecond = null;
    		objListaFactura = null;
    		objTPagoFactura = null;
    		if (bolcloseConection) {
    			HibernateUtil.closeSession();
    		}
    	}		
    	return objPagoFacturaBean;
	}
    	
	
    /**
     * Versión 11 de Junio 2013 BY
     */
    private String getEncabezadoCancelacion(String strTitulo) {
          return ("<table width=\"100%\" class=\"tabla\">" + 
                  "<tr>" + 
                  "<th colspan='8'>" +
                  "   <center>" +
                  "       <b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>" + strTitulo + "</b>" +
                  "    </center>" +
                  "</th>     " +
                  "</tr>" +
                  "<tr>" + 
                  "<th colspan='8'>" +
                  "   <center>" +
                  "       <b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>C A N C E L A D A</b>" +
                  "    </center>" +
                  "</th>     " +
                  "</tr>");    
          }      


	/**
	* Versión 11 de Junio 2013 BY
	*/
	private String getEncabezadoPagosCancelacion(String strTitulo) {
		 return ("<table width=\"100%\" class=\"tabla\">" + 
				 "<tr>" + 
				 "<th colspan='8'>" +
				 "   <center>" +
				 "       <b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>" + strTitulo + "</b>" +
				 "    </center>" +
				 "</th>     " +
				 "</tr>" +
				 "<tr>" + 
				 "<th colspan='8'>" +
				 "   <center>" +
				 "       <b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>C A N C E L A D A</b>" +
				 "    </center>" +
				 "</th>     " +
				 "</tr>" + 
				 "<tr>" + 
				 "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				 "	<b><font color='black'>CUENTA" + 
				 "	</font></b>" +
				 "</th>" + 
				 "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				 "	<b><font color='black'>FECHA" + 
				 "</th>" + 
				 "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				 "	<b><font color='black'>$ PAGO" + 
				 "	</font></b>" +
				 "</th>" + 
				 "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				 "	<b><font color='black'>$ SALDO" + 
				 "	</font></b>" +
				 "</th>" + 
				 "</tr>");	
	}	

	
	private String getBodyOrdenes(ResultSet objResultSet) throws Exception {
		String strQuery = "";
		try {
			if (objResultSet != null) {					
				iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  1");
				while(objResultSet.next()) {
					iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  2");
					strQuery = strQuery + ("<tr>" + 
											"   <td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:registrarPago(" + objResultSet.getString("admision") + "," + objResultSet.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
													objResultSet.getString("admision") + 
											"	</td>" + 
											"	<td align='center'>" + 
													objResultSet.getString("korden") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("captura") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("promesa") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("spaciente") + 
											"	</td>" +
											"	<td align='center'>" + 
													"$" + objResultSet.getString("pagopaciente") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("convenio") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("capturo") + 
											"	</td>" +
										 	"</tr>");
				}					
			}
			strQuery = strQuery + "</table>";										
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
		}
		return strQuery;
	}

	private String getBodyPagos(TPagoFactura objPagoFacturaBean) throws Exception {
		String strReturn = "";
		iObjLog.debug("Consulta PagoFacturaDao.getBodyPagos:...  ");
		strReturn = ("<tr>" + 
					"	<td align='center'>" + 
							objPagoFacturaBean.getCtipopago().getStipopago() + 
					"	</td>" + 
					"	<td align='center'>" + 
						objFormatos.getFechaCompleta(objPagoFacturaBean.getDfechapago()) + 
					"	</td>" +
					"	<td align='center'>" + 
							"$" + objPagoFacturaBean.getMpago() + 
					"	</td>" +
					"	<td align='center'>" + 
							"$" + objPagoFacturaBean.getMsaldo() + 
					"	</td>" +
				 	"</tr>");
		return strReturn;
	}
	
	/**
     * Versión 25 de Marzo 2013 
     BY
     */
	private String getEncabezadoPagos(String strTitulo) {
		return ("<table width=\"100%\" class=\"tabla\">" + 
				"<tr>" + 
				"<th colspan='8'>" +
				"   <center>" +
				"       <b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>" + strTitulo + "</b>" +
				"    </center>" +
				"</th>     " +
				"</tr>" +
				"<tr>"+
				"	<input type=\"button\" value=\"Reversar Pago\" name=\"Reversar Pago\" class=\"boton\" onclick=\"reversarPago();\">"+
				"</tr>"+
				"<tr>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>CUENTA" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>FECHA" + 
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>$ PAGO" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>$ SALDO" + 
				"	</font></b>" +
				"</th>" + 
				"</tr>");	
		}	

	/**
     * Versión 25 de Marzo 2013 
     BY Tomar en cuenta el registro
     */
	
	public PagoFacturaBean getDatosPagoFacturaCxC(int kFactura) throws Exception {
		List objListaFactura = null;
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		Query objQuerySecond = null;
		String strQuery = "";
		TPagoFactura objTPagoFactura = new TPagoFactura();
		PagoFacturaBean objPagoFacturaBean = new PagoFacturaBean();
		TFactura objTFactura = null;
		boolean bolExistenPagos = false;
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Entrando...  " + kFactura);
			HibernateUtil.beginTrans();			
			strQuery = "select bOF 											\n" +					
			   		   "from TPagoFactura bOF 								\n" +	
			           "where bOF.tfactura.kfactura in  (" + kFactura + ") and bOF.cestadoregistro=52	\n" +
			   		   "order by bOF.kpagofactura desc							  ";
			iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = new ArrayList();			
			objListaFactura = objQuery.list();
			if (objListaFactura != null) {
				if (objListaFactura.size()>0) {
					bolExistenPagos = true;
					objTPagoFactura = (TPagoFactura)objListaFactura.get(0);					
					iObjLog.debug("Consulta FacturacionMayoreoDao.getDatosPagoFactura:Consulta...1  " + objTPagoFactura.getKpagofactura() + " Total " + objTPagoFactura.getMtotalfactura().doubleValue());
					objPagoFacturaBean.setCestadoregistro(objTPagoFactura.getCestadoregistro());
					objPagoFacturaBean.setCtipopago(objTPagoFactura.getCtipopago().getCtipopago().intValue());
					objPagoFacturaBean.setDfechapago(objTPagoFactura.getDfechapago());
					objPagoFacturaBean.setDregistro(objTPagoFactura.getDregistro());
					objPagoFacturaBean.setKfactura(objTPagoFactura.getTfactura().getKfactura().intValue());
					objPagoFacturaBean.setKpagofactura(objTPagoFactura.getKpagofactura());
					objPagoFacturaBean.setManticipo(new BigDecimal(objTPagoFactura.getManticipo().doubleValue() + objTPagoFactura.getMpago().doubleValue()));
					objPagoFacturaBean.setMpago(objTPagoFactura.getMpago());
					objPagoFacturaBean.setMsaldo(objTPagoFactura.getMsaldo());
					objPagoFacturaBean.setMtotalfactura(objTPagoFactura.getMtotalfactura());
					objPagoFacturaBean.setUserId(objTPagoFactura.getUserId());
				}
			}
			if (bolExistenPagos == false) {
				objListaFactura.clear();
				objListaFactura = null;
				objListaFactura = new ArrayList();
				strQuery = "select bOF 															\n" +					
				   		   "from TFactura bOF 													\n" +	
				           "where bOF.kfactura = (" + kFactura + ") 	\n" +
				           "order by kfactura";
				iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Entrando...  " + strQuery);
				objQuerySecond = iObjSesion.createQuery(strQuery);
				objListaFactura = objQuerySecond.list();
				if (objListaFactura != null) {
					if (objListaFactura.size()>0) {
						objTFactura = (TFactura)objListaFactura.get(0);
						iObjLog.debug("Consulta FacturacionMayoreoDao.getDatosPagoFactura:Consulta...2  " + objTFactura.getKfactura() + " " + objTFactura.getMtotal().doubleValue());
						objPagoFacturaBean.setManticipo(new BigDecimal(0));
						objPagoFacturaBean.setMpago(new BigDecimal(0));
						objPagoFacturaBean.setMsaldo(objTFactura.getMtotal());
						objPagoFacturaBean.setMtotalfactura(objTFactura.getMtotal());
					}
				}
			}
			iObjLog.debug("Entrando FacturacionMayoreoDao.getDatosPagoFactura:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getDatosPagoFactura: ", aObjExcepcion);
			throw aObjExcepcion;			
    	} finally{
    		objQuery = null;
    		objQuerySecond = null;
    		objListaFactura = null;
    		objTPagoFactura = null;
//        	HibernateUtil.closeSession();
    	}		
    	return objPagoFacturaBean;
	}				
	
	public String getAntiguedadCxC() throws Exception {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String strQuery = "";
		String strReturn = "";
    	try{
			iObjLog.debug("Entrando PagoFacturaDao.getAntiguedadCxC:Entrando...  ");
            HibernateUtil.beginTrans();	            
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();	            
			strQuery =  "SELECT 	   tac.sserie as serie,															\n" +
						"	       tac.ccliente as cliente,															\n" +
						"   cc.srazonsocial as razonsocial,															\n" +
						"        tac.cconvenio as convenio,															\n" +
						"          ccc.sconvenio as nombre,															\n" +
						"        tac.dregistro as registro,															\n" +
						"          tac.dvencido as vencido,															\n" +
						"  tac.udiasvencido as diasvencido,															\n" +
						"tac.mtotalfactura as totalfactura,															\n" +
						"            tac.mpagado as pagado,															\n" +
						"              tac.msaldo as saldo,															\n" +
						"  tac.mdentroplazo as dentroplazo,															\n" +
						"             tac.m01a30 as m01a30,															\n" +
						"             tac.m31a60 as m31a60,															\n" +
						"             tac.m61a90 as m61a90,															\n" +
						"(tac.m91a120 + tac.m121a180 + tac.m181a360 + tac.mmas361) as Mas90,						\n" +
						"tac.sestadoregistro as estado                                                                       \n" +
						"FROM reportes.t_antiguedad_cxc tac inner join c_cliente cc on tac.ccliente=cc.ccliente		\n" +
						"				   inner join c_convenio ccc on tac.cconvenio=ccc.cconvenio					\n" +
						"ORDER BY cliente,convenio,registro	"	;
			iObjLog.debug("Entrando PacientesDao.buscarPacientes:Consulta...  " + strQuery);
			objRst = objStmt.executeQuery(strQuery);
			int inti = 1;
			while (objRst.next()) {
				strReturn += 	"<tr bgcolor=\"lightblue\">" +
								"<td align=\"center\">" + inti 															+ "</td>" +
								"<td align=\"center\">" + objRst.getString("serie") 									+ "</td>" +
								"<td align=\"center\">" + objRst.getString("cliente") 									+ "</td>" +
								"<td align=\"center\">" + objRst.getString("razonsocial") 								+ "</td>" +
								"<td align=\"center\">" + objRst.getString("convenio") 									+ "</td>" +
								"<td align=\"center\">" + objRst.getString("nombre") 									+ "</td>" +
								"<td align=\"center\">" + objFormatos.getFechaCompleta(objRst.getDate("registro"))		+ "</td>" +
								"<td align=\"center\">" + objFormatos.getFechaCompleta(objRst.getDate("vencido")) 		+ "</td>" +
								"<td align=\"center\">" + objRst.getString("diasvencido") 								+ "</td>" +
								"<td align=\"center\">$" + objFormatos.formateaNumero(objRst.getString("totalfactura")) + "</td>" +
								"<td align=\"center\">$" + objFormatos.formateaNumero(objRst.getString("pagado")) 		+ "</td>" +
								"<td align=\"center\">$" + objFormatos.formateaNumero(objRst.getString("saldo")) 		+ "</td>" +
								"<td align=\"center\">$" + objFormatos.formateaNumero(objRst.getString("dentroplazo")) 	+ "</td>" +
								"<td align=\"center\">$" + objFormatos.formateaNumero(objRst.getString("m01a30")) 		+ "</td>" +
								"<td align=\"center\">$" + objFormatos.formateaNumero(objRst.getString("m31a60")) 		+ "</td>" +
								"<td align=\"center\">$" + objFormatos.formateaNumero(objRst.getString("m61a90")) 		+ "</td>" +
								"<td align=\"center\">$" + objFormatos.formateaNumero(objRst.getString("Mas90")) 		+ "</td>" +
								"<td align=\"center\">" + objRst.getString("estado") + "</td>" +								
								"</tr>";
				inti++;
			}
			iObjLog.debug("Saliendo PagoFacturaDao.getAntiguedadCxC:Saliendo...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.getAntiguedadCxC: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}		
		return strReturn;
   	}
	
	/**
     * Versión 25 de Marzo 2013 
     BY
     */
	
	public String reversarPago(int kFactura, int idUsuario) throws Exception {
		List objListaFactura = null;
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		Query objQuerySecond = null;
		String strQuery = "";
		TPagoFactura objTPagoFactura = new TPagoFactura();
		PagoFacturaBean objPagoFacturaBean = new PagoFacturaBean();
		TFactura objTFactura = null;
		String strFolioFactura = "";
		String strReturn=null;
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.reversarPago:Entrando...  " + kFactura);
			HibernateUtil.beginTrans();			
			strQuery = "select bOF 											\n" +					
			   		   "from TPagoFactura bOF 								\n" +	
			           "where bOF.tfactura.kfactura in  (" + kFactura + ") and bOF.knotacredito = 0	\n" +
			   		   "order by bOF.kpagofactura desc						  ";
			iObjLog.debug("Entrando FacturacionMayoreoDao.reversarPago:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = new ArrayList();			
			objListaFactura = objQuery.list();
			if (objListaFactura != null) {
				if (objListaFactura.size()>0) {
					objPagoFacturaBean.setSgridpagos("");
					for (int inti= 0;inti< objListaFactura.size();inti++) {
						objTPagoFactura = (TPagoFactura)objListaFactura.get(inti);					
						iObjLog.debug("Consulta FacturacionMayoreoDao.reversarPago:Consulta...1  " + objTPagoFactura.getKpagofactura() + " Total " + objTPagoFactura.getMtotalfactura().doubleValue());
						objPagoFacturaBean.setCestadoregistro(objTPagoFactura.getCestadoregistro());
						objPagoFacturaBean.setCtipopago(objTPagoFactura.getCtipopago().getCtipopago().intValue());
						objPagoFacturaBean.setDfechapago(objTPagoFactura.getDfechapago());
						objPagoFacturaBean.setDregistro(objTPagoFactura.getDregistro());
						objPagoFacturaBean.setKfactura(objTPagoFactura.getTfactura().getKfactura().intValue());
						objPagoFacturaBean.setKpagofactura(objTPagoFactura.getKpagofactura());
						objPagoFacturaBean.setManticipo(new BigDecimal(objTPagoFactura.getManticipo().doubleValue() + objTPagoFactura.getMpago().doubleValue()));
						objPagoFacturaBean.setMpago(objTPagoFactura.getMpago());
						objPagoFacturaBean.setMsaldo(objTPagoFactura.getMsaldo());
						objPagoFacturaBean.setMtotalfactura(objTPagoFactura.getMtotalfactura());
						objPagoFacturaBean.setUserId(objTPagoFactura.getUserId());
						objPagoFacturaBean.setSformatofactura(FacturacionMayoreoDao.llenaIdFactura(objTPagoFactura.getTfactura().getSserie(), objTPagoFactura.getTfactura().getUfoliofactura() + "", 8));
						objPagoFacturaBean.setSgridpagos("");							
						strFolioFactura =  FacturacionMayoreoDao.llenaIdFactura(objTPagoFactura.getTfactura().getSserie(), objTPagoFactura.getTfactura().getUfoliofactura() + "", 8);
						objTPagoFactura.setCestadoregistro(53);
						objTPagoFactura.setUserId(idUsuario);
						iObjSesion.update(objTPagoFactura);
						iObjSesion.flush();
						break;
					}
					objPagoFacturaBean.setSgridpagos("");
				}
			}
			
			iObjLog.debug("Entrando FacturacionMayoreoDao.reversarPago:Saldo...  " + objPagoFacturaBean.getMsaldo());
			
				objListaFactura.clear();
				objListaFactura = null;
				objListaFactura = new ArrayList();
				strQuery = "select bOF 															\n" +					
				   		   "from TFactura bOF 													\n" +	
				           "where bOF.kfactura = (" + kFactura + ") 	\n" +
				           "order by kfactura";
				iObjLog.debug("Entrando FacturacionMayoreoDao.reversarPago:Entrando...  " + strQuery);
				objQuerySecond = iObjSesion.createQuery(strQuery);
				objListaFactura = objQuerySecond.list();
				if (objListaFactura != null) {
					if (objListaFactura.size()>0) {
						objTFactura = (TFactura)objListaFactura.get(0);
						iObjLog.debug("Consulta FacturacionMayoreoDao.reversarPago:Consulta...2  " + objTFactura.getKfactura() + " " + objTFactura.getMtotal().doubleValue());
						if(objTFactura.getCestadoregistro() == 51){
							objTFactura.setCestadoregistro(33);
							objTFactura.setUserIdChange(idUsuario);
							iObjSesion.update(objTFactura);
							iObjSesion.flush();
						}
					}
				}
			strReturn="El pago de la factura "+strFolioFactura+" por $"+objFormatos.formateaNumero(objPagoFacturaBean.getMpago())+ " ha sido eliminado";
			iObjLog.debug("Entrando FacturacionMayoreoDao.reversarPago:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.reversarPago: ", aObjExcepcion);
			throw aObjExcepcion;			
    	} finally{
    		objQuery = null;
    		objQuerySecond = null;
    		objListaFactura = null;
    		objTPagoFactura = null;
    		HibernateUtil.closeSession();
    	}		
    	return strReturn;
	}
	
	/**
     * Versión 25 de Marzo 2013 
     BY
     */

	public String actualizarFactura(int kFactura, int idUsuario,int opcion) throws Exception {
		List objListaFactura = null;
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		TFactura objTFactura = null;
		String strFolioFactura = "";
		String strReturn=null;
    	try{
			
			HibernateUtil.beginTrans();			
			iObjLog.debug("Entrando FacturacionMayoreoDao.actualizarEstadoFacturaSaldo...  " + opcion);
				strQuery = "select bOF 															\n" +					
				   		   "from TFactura bOF 													\n" +	
				           "where bOF.kfactura = (" + kFactura + ") 	\n" +
				           "order by kfactura";
				iObjLog.debug("Entrando FacturacionMayoreoDao.actualizarEstadoFactura:Entrando...  " + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objListaFactura = objQuery.list();
				if (objListaFactura != null) {
					if (objListaFactura.size()>0) {
						objTFactura = (TFactura)objListaFactura.get(0);
						iObjLog.debug("Consulta FacturacionMayoreoDao.actualizarEstadoFactura:Consulta...2  " + objTFactura.getKfactura() + " " + objTFactura.getMtotal().doubleValue());
						if(opcion==66){
							objTFactura.setCestadoregistro(66);
							objTFactura.setUserIdChange(idUsuario);
						}else{
							objTFactura.setCestadoregistro(67);
							objTFactura.setUserIdChange(idUsuario);	
						}
						iObjSesion.update(objTFactura);
						iObjSesion.flush();
					}
				}
			strReturn="Se ha actualizado el estado de la factura "+FacturacionMayoreoDao.llenaIdFactura(objTFactura.getSserie(), objTFactura.getUfoliofactura() + "", 8);
			iObjLog.debug("Entrando FacturacionMayoreoDao.actualizarEstadoFactura:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.actualizarEstadoFactura: ", aObjExcepcion);
			throw aObjExcepcion;			
    	} finally{
    		objQuery = null;
    		objListaFactura = null;
    		HibernateUtil.closeSession();
    	}		
    	return strReturn;
	}
	
	/**
     * Versión 25 de Marzo 2013 
     BY
     */
	public int getCcliente(int iCconvenio) throws Exception {
		iObjLog.debug("Entrando PagoFacturaDao.getCcliente:" + iCconvenio);
		iObjSesion = HibernateUtil.getSession();
		String strQuery = "";
		int icCliente = 0;
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
    	try{
            HibernateUtil.beginTrans();
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            if (iCconvenio > 0) {
        		strQuery =  "select cc.* " +					
							" from  C_Convenio cc " +					
							" where cc.cconvenio = " +  iCconvenio;
            } 
            if (strQuery != "") {
            	objRst = objStmt.executeQuery(strQuery);
            	while (objRst.next()) {
            		icCliente = objRst.getInt("ccliente");            		
            	}
            }
			iObjLog.debug("Saliendo PagoFacturaDao.getCcliente...  " + icCliente);
			return icCliente;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.getCcliente: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}
	
	
}
