package mx.com.web2lab.backend.dao.facturacion.mayoreo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.comer.ConvenioBean;
import mx.com.web2lab.backend.beans.facturacion.DatosAdicionalesBean;
import mx.com.web2lab.backend.beans.facturacion.TdatoAdicionalBean;
import mx.com.web2lab.backend.dao.comer.ClientesNewDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CDatoAdicional;
import mx.com.web2lab.backend.hbm.om.ap.TDatoAdicional;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.util.formatos.Formatos;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.HibernateException;


public class DatosAdicionalesDao {
	
private static Log iObjLog = LogFactory.getLog(FacturacionPrevioDao.class);
	
	private Session iObjSesion = null;
	
	public DatosAdicionalesDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	
	public TOrdenSucursalFac getOrdenSucursalFacListasParaFacturar(int intKordenSucursal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaOrdenes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		TOrdenSucursalFac objOrdenSucursalFac = new TOrdenSucursalFac();
    	try{
			iObjLog.debug("Entrando DatosAdicionalesDao.getOrdenSucursalFacListasParaFacturar:Entrando...  " + intKordenSucursal);
			HibernateUtil.beginTrans();
			if (intKordenSucursal>0) {
				strQuery = "select bOF " +					
				   		   "from TOrdenSucursalFac bOF " +	
				           "where bOF.kordensucursal =  " + intKordenSucursal + " and bOEF.cestadoregistro.cestadoregistro  in (37) " +
				           "order by kordensucursalfac ";
			} 
			
			iObjLog.debug("Entrando DatosAdicionalesDao.getOrdenSucursalFacListasParaFacturar:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaOrdenes = objQuery.list();
			iObjLog.debug("Resultado DatosAdicionalesDao.getOrdenSucursalFacListasParaFacturar:Consulta...  " + objListaOrdenes.size());			
			if (objListaOrdenes.isEmpty() == false) {
				for (int inti=0;inti<objListaOrdenes.size();inti++) {
					objOrdenSucursalFac = null;
					objOrdenSucursalFac = (TOrdenSucursalFac)objListaOrdenes.get(inti);									
				}
				return objOrdenSucursalFac;
			} else {
				return null;
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosAdicionalesDao.buscarOrdenOnlyLocal(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		HibernateUtil.closeSession();
    		objOrdenSucursalFac = null;
    	}	

	}
	
	public String getDatosAdicionales(OrdenBean objOrdenBean){
		String strReturn=null;
		String strnameniveldatoadicional=null;
		String strniveldatoadicional=null;
		String strscript = "";
		String strReturnExistente="";
		String strReturndatosOrden="";
		
		
		Integer strtipobusqueda = null;
		boolean bmostrarsniveldatoadicional=false;
		
		ClientesNewDao objClientesNewDAO = new ClientesNewDao();
		
		try {
			iObjLog.debug("Entrando DatosAdicionalesDao.getDatosAdicionales:Orden...  " + objOrdenBean.getKadmision());
				List lstDatosAdicionales = this.getDatoAdicional(objOrdenBean.getCconvenio());
				
				strReturn="<table border='0' align='center' style='width: 883px' class='tabla'>" + 
										"<tr>" + 
											"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
											"	<b><font color='black'>Consecutivo de Orden" + 
											"	</font></b>" +
											"</th>" +
											"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
											"	<b><font color='black'>Orden" + 
											"	</font></b>" +
											"</th>" + 
											"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
											"	<b><font color='black'>Fecha Orden" + 
											"</th>" + 
											"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
											"	<b><font color='black'>Convenio" + 
											"</th>" +
										"</tr>" +
										"<tr>"+
											"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												objOrdenBean.getKadmision() + 
											"</a></td>" +
											"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												this.llenaIdFactura(objOrdenBean.getSordenfundacion().trim(),String.valueOf(objOrdenBean.getCordenfundacion()),8) + 
											"</a></td>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												new Formatos().getFechaNumeros(objOrdenBean.getDregistro()) + 
											"</a></td>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>"+
												objOrdenBean.getCconvenio()+ "-"+this.getNombreConvenio(objOrdenBean.getCconvenio())+
											"</td>" +
										"</tr>";
											 
			if( (lstDatosAdicionales != null) &&(lstDatosAdicionales.size()>0)){
					iObjLog.debug("Existen Datos Adicionales"+lstDatosAdicionales.size());
					strReturn +="<tr >"+
								"  <th colspan='4'>"+
								"     <b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>Ingrese los datos adicionales</b>"+
								"  </th>"+
								"</tr>"+
								"<tr>";
					for(int i = 0; i < lstDatosAdicionales.size() ; i++) {
						DatosAdicionalesBean objDatosAdicionalesBean  = (DatosAdicionalesBean)lstDatosAdicionales.get(i);
						if(!bmostrarsniveldatoadicional){
							bmostrarsniveldatoadicional=true;
							if(objDatosAdicionalesBean.getSniveldatoadicional().equals("ORDEN")){
								strtipobusqueda= new Integer((int)(long) objOrdenBean.getKadmision());
								strniveldatoadicional="CONSECUTIVO DE LA ORDEN";
								strnameniveldatoadicional="00";
							}else{
								strtipobusqueda=objOrdenBean.getBpacientebean().getKpacientefundacion();
								strniveldatoadicional="ID PACIENTE";
								strnameniveldatoadicional="01";
							}
							strReturn+="<tr>"+
									   "</tr>"+
										"<tr>"+
											"<td>" + 
											"	<b><font color='black'>" + strniveldatoadicional+
											"	</font></b>" +
											"</td>"+
											"<td>"+
											" <input type=\"text\" name=\""+strnameniveldatoadicional+"\" onKeyPress=\"numero();\" value='"+strtipobusqueda+"' readOnly='True' size=\"12\" >"+
											"	</font></b>" +
											"</td>"+
										"</tr>";
							strReturnExistente=this.existeDatoAdicional(strtipobusqueda,strnameniveldatoadicional);
							if(!strReturnExistente.equals("")){
								iObjLog.debug("Existen Datos Adicionales previos");
								strReturn+=strReturnExistente;
								break;
							}
						}
						if(objDatosAdicionalesBean.getStipodatoadicional().equals("VARCHAR")){
							strscript="onKeyPress=\"mayuscula();\"";	
						}else if(objDatosAdicionalesBean.getStipodatoadicional().equals("NUMERICO")) {
							strscript="onKeyPress=\"numero();\"";
						}else if(objDatosAdicionalesBean.getStipodatoadicional().equals("DATE")) {
							strscript="onKeyPress=\"javascript:agregaDiag(this);\" onChange=\"javascript:this.value=validaFormatoFecha(this.value);\"";
						}
						System.out.println("objDatosAdicionalesBean.getSdatoadicional():"+objDatosAdicionalesBean.getSdatoadicional());
						String strValue = "";
						if(strnameniveldatoadicional.equals("00")){
							System.err.println("entra aqui en 00");
							if(objDatosAdicionalesBean.getSdatoadicional().equals("FECHA ENTREGA")){
								System.err.println("es FECHA ENTREGA");
								strscript+=" readOnly='True' ";
								strValue = getFechaPromesaResultado(strtipobusqueda);
							}							
						}
						strReturn+= "<tr>"+
									"</tr>"+
									"<tr>"+ 
									"<td>" + 
									"	<b><font color='black'>" + objDatosAdicionalesBean.getSdatoadicional()+
									"	</font></b>" +
									"</td>"+
									"<td>"+
									" <input type=\"text\" name=\""+objDatosAdicionalesBean.getCdatoadicional()+"\" "+strscript+" value='"+strValue+"' size=\"12\" >"+
									"	</font></b>" +
									"</td>"+
									"</tr>"; 
					}
				strReturn+= "<tr>"+ 
							"</tr>"+
						    "	<tr colspan='2'>"+
							"		<td>" + 
						  	"			<input type='button' id='idGuardarDatos' name='idGudardarDatos' value='Guardar' onClick='javascript:guardaDatos();' class='boton'>"+
						  	"		</td>" +
						  	"		<td>" + 
						  	"			<input type='button' id='idLimpiarDatos' name='idLimpiarDatos' value='Limpiar' onClick='javascript:limpiarDatos();' class='boton'>"+
						  	"		</td>" +
						  	"	</tr>"+
						  	"</table>";
				iObjLog.debug("TAG"+strReturn);	
			}else{
				strReturn ="<tr >"+
							"  <th colspan='2'>"+
							"     <b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>No existen datos Adicionales para este convenio</b>"+
							"  </th>"+
							"</tr>"+
							"<tr>"+
						"</table>";
				
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return strReturn;
		
	}
	
	public String existeDatoAdicional(Integer itipobusqueda,String strtipobusqueda )throws Exception{
	  	iObjSesion = HibernateUtil.getSession();
		List objListaTDatosAdicionales = new ArrayList();
		List objListareturn = new ArrayList();
		TdatoAdicionalBean objTDatosAdicionalesBean = null;
		Query objQuery = null;
		String strQuery = "";
		String strTipoBusqueda="";
		String strReturn="";
		
		Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;
		
 try{
		iObjLog.debug("Entrando DatosAdicionalesDao.existeDatoAdicional:Entrando...  " + itipobusqueda);
	    HibernateUtil.beginTrans();
	    
	    if(strtipobusqueda.equals("00")){
	    	strTipoBusqueda="and tDA.kordensucursal in("+itipobusqueda+") order by tDA.cdatoadicional desc";
	    }else{
	    	strTipoBusqueda="and tDA.kpaciente in("+itipobusqueda+") order by tDA.cdatoadicional desc";
	    }
		strQuery = "SELECT tDA.kdatoadicional,tDA.kordensucursal,tDA.cdatoadicional,cDA.sdatoadicional,cDA.stipodatoadicional,tDA.svalor,tDA.kpaciente,tDA.kfactura										\n" +					
				   "FROM T_DATO_ADICIONAL tDA,C_DATO_ADICIONAL cDA 								\n" +
				   "WHERE tDA.cdatoadicional=cDA.cdatoadicional 								\n" +
				   strTipoBusqueda;
		
		iObjLog.debug("Entrando DatosAdicionalesDao.existeDatoAdicional:Entrando...  " + strQuery);
		
		objConn = iObjSesion.connection();				
		objStatement = objConn.createStatement();
		rst = objStatement.executeQuery(strQuery);
		
		
		if(rst != null) {
			while(rst.next()){		
				objTDatosAdicionalesBean = new TdatoAdicionalBean();
				objTDatosAdicionalesBean.setKdatoadicional(new Integer(rst.getInt("kdatoadicional")));
				objTDatosAdicionalesBean.setKordensucursal(new Integer(rst.getInt("kordensucursal")));
				objTDatosAdicionalesBean.setKfactura(new Integer(rst.getInt("kfactura")));
				objTDatosAdicionalesBean.setCdatoadicional(new Integer(rst.getInt("cdatoadicional")));
				objTDatosAdicionalesBean.setSdatoadicional(rst.getString("sdatoadicional"));
				objTDatosAdicionalesBean.setStipodatoadicional(rst.getString("stipodatoadicional"));
				objTDatosAdicionalesBean.setSvalor(rst.getString("svalor"));
				objTDatosAdicionalesBean.setKpaciente(new Integer(rst.getInt("kpaciente")));
				objListareturn.add(objTDatosAdicionalesBean);
			}
		}
		strReturn=this.pintarDatosAdicionalesExistentes(objListareturn);
		iObjLog.debug("Entrando FacturacionPrevioDao.getDatoAdicional:Saliendo...  "+objListareturn.size());
		return strReturn;	
	} catch (Exception aObjExcepcion) { 
		iObjLog.error("ERROR FacturacionPrevioDao.getDatoAdicional: ", aObjExcepcion);
		throw aObjExcepcion;
	} finally{
		objListaTDatosAdicionales.clear();
    	objQuery = null;
    	HibernateUtil.closeSession();
	}		   		 	   
  }
	
	public String pintarDatosAdicionalesExistentes(List objListaDatosExistentes){
		String strReturn="";
		String strscript="";
		TdatoAdicionalBean objTDatosAdicionalesBean = null;
		
		for(int i = 0; i < objListaDatosExistentes.size() ; i++) {
			objTDatosAdicionalesBean  = (TdatoAdicionalBean)objListaDatosExistentes.get(i);
			if(objTDatosAdicionalesBean.getStipodatoadicional().equals("VARCHAR")){
				strscript="onKeyPress=\"mayuscula();\"";	
			}else if(objTDatosAdicionalesBean.getStipodatoadicional().equals("NUMERICO")) {
				strscript="onKeyPress=\"numero();\"";
			}else if(objTDatosAdicionalesBean.getStipodatoadicional().equals("DATE")) {
				strscript="onKeyPress=\"javascript:agregaDiag(this);\" onChange=\"javascript:this.value=validaFormatoFecha(this.value);\"";
			}
			strReturn+=	"<tr>"+
						"<td>" + 
						"	<b><font color='black'>" + objTDatosAdicionalesBean.getSdatoadicional()+
						"	</font></b>" +
						"</td>"+
						"<td>"+
						" <input type=\"text\" name=\""+objTDatosAdicionalesBean.getCdatoadicional()+"\" "+strscript+" size=\"12\" value='"+objTDatosAdicionalesBean.getSvalor()+"'>"+
						"	</font></b>" +
						"</td>"+
					"</tr>"; 
		}
		return strReturn;
	}
	
	
	public List getDatoAdicional(int cconvenio) throws Exception{
	  	iObjSesion = HibernateUtil.getSession();
		List objListaDatosAdicionales = new ArrayList();
		List objListareturn = new ArrayList();
		DatosAdicionalesBean objDatosAdicionalesBean = null;
		CDatoAdicional objDatoAdicional = null;
		Query objQuery = null;
		String strQuery = "";
 try{
		iObjLog.debug("Entrando FacturacionPrevioDao.getDatoAdicional:Entrando...  " + cconvenio);
	    HibernateUtil.beginTrans();
		strQuery = "select cDA 										\n" +					
				   "from CDatoAdicional cDA 								\n" +	
				   "where cDA.cconvenio in  (" + cconvenio + ") order by cDA.cdatoadicional desc";
		
		iObjLog.debug("Entrando FacturacionPrevioDao.getDatoAdicional:Entrando...  " + strQuery);
		
		objQuery = iObjSesion.createQuery(strQuery);
		objListaDatosAdicionales = objQuery.list();
		if (objListaDatosAdicionales.isEmpty() == false) {
			for (int inti=0;inti<objListaDatosAdicionales.size();inti++){
				objDatosAdicionalesBean = new DatosAdicionalesBean();
				objDatoAdicional = (CDatoAdicional)objListaDatosAdicionales.get(inti);
				objDatosAdicionalesBean.setCdatoadicional(objDatoAdicional.getCdatoadicional());
				objDatosAdicionalesBean.setCconvenio(objDatoAdicional.getCconvenio().intValue());
				objDatosAdicionalesBean.setStipodatoadicional(objDatoAdicional.getStipodatoadicional());
				objDatosAdicionalesBean.setSdatoadicional(objDatoAdicional.getSdatoadicional());
				objDatosAdicionalesBean.setSniveldatoadicional(objDatoAdicional.getSniveldatoadicional());
				objDatosAdicionalesBean.setBobligatorio(objDatoAdicional.isBobligatorio());
				objListareturn.add(objDatosAdicionalesBean);
			}
		}
		iObjLog.debug("Entrando FacturacionPrevioDao.getDatoAdicional:Saliendo...  "+objListareturn.size());
		return objListareturn;	
	} catch (Exception aObjExcepcion) { 
		iObjLog.error("ERROR FacturacionPrevioDao.getDatoAdicional: ", aObjExcepcion);
		throw aObjExcepcion;
	} finally{
		objListaDatosAdicionales.clear();
    	objQuery = null;
    	objDatoAdicional = null;
    	HibernateUtil.closeSession();
	}		   		 	   
  }

	 public String persistirDatoAdicional(String strDatosAdicionales,boolean bactualizacion) throws  Exception{
		   String strmensaje="";
		   String strDatoAdicional ="'";
		   String[] arrayDatos = strDatosAdicionales.split(";");
		   String[] arrayDato;
		   String cdatoadicional;
		   String sdatoadicional;
		   String strSQL="";
		   int kordensucursal = 0;
		   int kpaciente = 0;
		   Query objQuery = null;
		   String strQuery = "";
		   List objListaDatos = new ArrayList();
		   TdatoAdicionalBean objTDatoAdicionalBean = new TdatoAdicionalBean();
		  try {   
			  		
				   iObjLog.debug("Entrando DatosAdicionalesAjax.persistirDatoAdicional:..." + strDatosAdicionales+"\n");  
				   for (int i = 0; i < arrayDatos.length; i++) {
					   if(!arrayDatos[i].equals("")) {
						   strDatoAdicional =arrayDatos[i];
						   arrayDato=strDatoAdicional.split(",");
						   cdatoadicional=arrayDato[0];
						   sdatoadicional=arrayDato[1];
						   if(i==0){   
								if(cdatoadicional.equals("00")){
									kordensucursal=new Integer(sdatoadicional).intValue();
									kpaciente=0;
								 }else if(cdatoadicional.equals("01")){
									kordensucursal=0;
									kpaciente=new Integer(sdatoadicional).intValue();;
								 }
							}else if(i>0){
								 iObjLog.debug("Insertando:..." + sdatoadicional+"\n");
						          if (kpaciente>0) {	
						        	  iObjLog.debug("Entrando FacturacionPrevioDao.setkpaciente:..." + strDatosAdicionales+"\n");
						        		strQuery =  "select tda " +					
													" from TDatoAdicional tda " +					
													" where tda.kpaciente = "+kpaciente;
						        		
						        		
						    			iObjLog.debug("Consulta FacturacionPrevioDao.persistirDatoAdicional:..." + strQuery);
						    			
						        	}else if(kordensucursal>0){
						        		iObjLog.debug("Entrando FacturacionPrevioDao.setkordensucursal:..." + strDatosAdicionales+"\n");
						        		strQuery ="select tda " +					
												" from TDatoAdicional tda " +					
												" where tda.kordensucursal = "+kordensucursal;
						        		
						    			iObjLog.debug("Consulta FacturacionPrevioDao.persistirDatoAdicional:..." + strQuery);
						        	}
						          	HibernateUtil.beginTrans();
						          	objQuery = iObjSesion.createQuery(strQuery);
									objListaDatos = objQuery.list();
									iObjLog.debug("DatosLista FacturacionPrevioDao.persistirDatoAdicional:..." + objListaDatos.size());
									if(objListaDatos != null) {
										if (objListaDatos.size() > 0) {
												strmensaje="Existente";
												if(bactualizacion){
													iObjLog.debug("Actualizando FacturacionPrevioDao.persistirDatoAdicional:..." + strQuery);
													strmensaje="";
													if(kordensucursal>0){
														objTDatoAdicionalBean.setKordensucursal(new Integer(kordensucursal));
														objTDatoAdicionalBean.setKfactura(new Integer(0));
														objTDatoAdicionalBean.setCdatoadicional(new Integer(cdatoadicional));
														objTDatoAdicionalBean.setSvalor(sdatoadicional);
														objTDatoAdicionalBean.setKpaciente(new Integer(kpaciente));
														strSQL +="UPDATE T_DATO_ADICIONAL SET SVALOR='"+objTDatoAdicionalBean.getSvalor()+"' WHERE CDATOADICIONAL="+objTDatoAdicionalBean.getCdatoadicional()+" AND KORDENSUCURSAL="+ objTDatoAdicionalBean.getKordensucursal()+" AND KFACTURA=0;";
													}else{
														objTDatoAdicionalBean.setKordensucursal(new Integer(kordensucursal));
														objTDatoAdicionalBean.setKfactura(new Integer(0));
														objTDatoAdicionalBean.setCdatoadicional(new Integer(cdatoadicional));
														objTDatoAdicionalBean.setSvalor(sdatoadicional);
														objTDatoAdicionalBean.setKpaciente(new Integer(kpaciente));
														strSQL +="UPDATE T_DATO_ADICIONAL SET SVALOR='"+objTDatoAdicionalBean.getSvalor()+"' WHERE CDATOADICIONAL="+objTDatoAdicionalBean.getCdatoadicional()+" AND KPACIENTE="+ objTDatoAdicionalBean.getKpaciente()+" AND KFACTURA=0;";
													}
												}
										}else{
											objTDatoAdicionalBean.setKordensucursal(new Integer(kordensucursal));
											objTDatoAdicionalBean.setKfactura(new Integer(0));
											objTDatoAdicionalBean.setCdatoadicional(new Integer(cdatoadicional));
											objTDatoAdicionalBean.setSvalor(sdatoadicional);
											objTDatoAdicionalBean.setKpaciente(new Integer(kpaciente));
											strSQL +="INSERT INTO T_DATO_ADICIONAL VALUES (t_dato_adicional_sequence.NEXTVAL," + objTDatoAdicionalBean.getKordensucursal() + ",0," + objTDatoAdicionalBean.getCdatoadicional() + ",'" + objTDatoAdicionalBean.getSvalor() + "',"+objTDatoAdicionalBean.getKpaciente()+");";
										}				
						        	}	
							}  	 	  
					   }
				    
				   }
				   if(!strSQL.equals("")){
					   iObjLog.debug("Consulta FacturacionPrevioDao.para insertar:..." + strSQL);
					   this.ejecutarConsulta(strSQL);
				   }
		   } catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR FacturacionPrevioDao.persistirDatoAdicional: ", aObjExcepcion);
				throw aObjExcepcion;
	       } finally{
	    	   objListaDatos.clear();
	    	   objListaDatos = null;
	    	   strQuery = null;
	    	   HibernateUtil.closeSession();
			}		
	     return strmensaje;
	  	}
	 
	 static String llenaIdFactura(String strNemonico,String intFactura,int MaxLength) {
			String strReturn = "";
			int intTotal = (strNemonico.length() + intFactura.length());
			for(int i = intTotal;i <= MaxLength;i++) {
				strReturn += "0";
			}		
			return strNemonico + strReturn+intFactura;
		}
	 
	 public void ejecutarConsulta(String strSQL) throws Exception {
			Connection objConn 	   = null;
			Statement objStatement = null;	
			iObjSesion = HibernateUtil.getSession();
		    iObjLog.debug("Entrando FacturaPrevioDao.ejecutarConsulta:....   " + strSQL);
		try{
				objConn = iObjSesion.connection();				
				objStatement = objConn.createStatement();
				iObjLog.debug("FacturaPrevioDao.ejecutarConsulta:Consulta......." + strSQL);
				objStatement.execute(strSQL);
				objStatement.execute("COMMIT;");
			} catch (Exception aObjExcepcion) { 
		    iObjLog.error("FacturaPrevioDao.ejecutarConsulta:Exception....", aObjExcepcion);
		    throw aObjExcepcion;
			} finally{
				if (objStatement != null) {
					objStatement.close();
					objStatement = null;
				}
		    	//HibernateUtil.closeSession();
			}		
		    iObjLog.debug("Saliendo FacturaPrevioDao.guardarDatosAdicionales:....   " + strSQL);
		}
	 
	 
	 public String getNombreConvenio(int iCconvenio) throws Exception {
			iObjLog.debug("Entrando DatosAdicionalesDao.getNombreConvenio:" + iCconvenio);
			iObjSesion = HibernateUtil.getSession();
			String strQuery = "";
			String strReturn = "";
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
						strReturn =  objRst.getString("sconvenio");            		
	            	}
	            }
				iObjLog.debug("Saliendo DatosAdicionalesDao.getNombreConvenio...  " + strReturn);
				return strReturn;
			} catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR DatosAdicionalesDao.getNombreConvenio: ", aObjExcepcion);
				throw aObjExcepcion;
	        } finally{
	    		objRst = null;
	    		objStmt = null;
	        	HibernateUtil.closeSession();
			}		
		}
	 
	 public String getFechaPromesaResultado(Integer kordensucursal) throws Exception {
			iObjLog.debug("Entrando DatosAdicionalesDao.getFechaPromesaResultado:" + kordensucursal);
			iObjSesion = HibernateUtil.getSession();
			String strQuery = "";
			String strFechaReturn = "";
			Date strReturn = null;
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
	    	try{
	            HibernateUtil.beginTrans();
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
        		strQuery =  "select dresultadoentrega from t_orden_sucursal \r\n" +
        					"where kordensucursal = " +  kordensucursal;
	            if (strQuery != "") {
	            	objRst = objStmt.executeQuery(strQuery);
	            	while (objRst.next()) {
						strReturn =  objRst.getDate("dresultadoentrega");            		
	            	}
	            }
				iObjLog.debug("Saliendo DatosAdicionalesDao.getFechaPromesaResultado...  " + strReturn);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				strFechaReturn = sdf.format(strReturn);
				return strFechaReturn;
			} catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR DatosAdicionalesDao.getFechaPromesaResultado: ", aObjExcepcion);
				throw aObjExcepcion;
	        } finally{
	    		objRst = null;
	    		objStmt = null;
	        	HibernateUtil.closeSession();
			}		
		}
}
