package mx.com.web2lab.backend.dao.caja;

import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.comer.ConvenioBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.ap.TDatoFactura;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DatosFacturaDao {

	private static Log iObjLog = LogFactory.getLog(DatosFacturaDao.class);
	    
	private Session iObjSesion = null;
	
	public DatosFacturaDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public TDatoFactura newDatosFactura(TDatoFactura objDatoFacturaHB) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		List lstDatosFactura = new ArrayList();
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta DatosFacturaDao.newDatosFactura:...RFC   " + objDatoFacturaHB.getSrfc() + " Razon Social " + objDatoFacturaHB.getSrazonsocial());
    		strQuery =  "select tDF " +					
						" from TDatoFactura tDF " +					
						" where tDF.srfc in (' " + objDatoFacturaHB.getSrfc() + "')";
			objQuery = iObjSesion.createQuery(strQuery);
			lstDatosFactura = objQuery.list();
			if(lstDatosFactura != null) {
				if (lstDatosFactura.size() > 0) {
					objDatoFacturaHB = (TDatoFactura)lstDatosFactura.get(0);
				} else {		
	        		iObjSesion.save(objDatoFacturaHB);
	        	} 
			} else {		
        		iObjSesion.save(objDatoFacturaHB);
        	} 
    		iObjSesion.flush();            	
//            HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo DatosFacturaDao.newDatosFactura:...RFC  " + objDatoFacturaHB.toString());
			return objDatoFacturaHB;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFacturaDao.newDatosFactura: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
			
	private String showConvenios(List lstConvenios) throws Exception
	{		
		ConvenioBean objConvenio = new ConvenioBean();
		String strReturn = "";		
		String strContadorHelp = "";
		int intConvenio = 0;
		iObjLog.debug("Entrando a ClientesDao.showConvenios:Entrando... ");
		try {
			 if (lstConvenios != null) {
				 intConvenio = lstConvenios.size();
			 }
			 if (intConvenio > 50 ) {
				 strContadorHelp = ", PERO SOLO SE PRESENTAN 50 (PON MAS DATOS PARA FILTRAR) ";
			 }
			 
			 strReturn = ("<table border='0' align='center' style='width: 883px' class='tabla'>" + 
					 		"<tr>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Total de Convenios " + intConvenio + strContadorHelp +
								"	</font></b>" +
								"</th>"  + 
							"</tr>" +
						 "</table>" +	
						 "<table border='0' align='center' style='width: 883px' class='tabla'>" +
							"<tr>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>#" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Clave" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Nombre del Convenio" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Tipo Convenio" + 
								"</th>" + 
							"</tr>");			    
			 if (lstConvenios != null) {
				int y = 0; 
				for (int i = 0; i < lstConvenios.size() ; i++)
				{
					if (y >= 50) {
						break;
					}
					objConvenio = (ConvenioBean)lstConvenios.get(i);						
					y = i + 1;
					strReturn += ("<tr>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:convenioAceptado(" + objConvenio.getCconvenio().intValue() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											y + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:convenioAceptado(" + objConvenio.getCconvenio().intValue() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objConvenio.getCconvenio().intValue() + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:convenioAceptado(" + objConvenio.getCconvenio().intValue() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objConvenio.getSconvenio() +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:convenioAceptado(" + objConvenio.getCconvenio().intValue() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objConvenio.getStipoconvenio() +
										"</a></td>" + 
									 "</tr>");
				}
			}
			strReturn += ("<tr>");
			strReturn += ("		<td>");
			strReturn += ("			<input type='button' id='idNuevoConvenio' value='Nuevo Convenio' onClick='crearNuevoConvenio();' class='boton'>");
			strReturn += ("		</td>");
			strReturn += ("</tr>");
			strReturn += ("</table>");
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("DatosMedicoAjax.consultaMedicosGrid:Exception....", aObjException);
    	    throw aObjException;
		} 
	}	
	
//	public List cotizarConvenioOMRR31052011(ConvenioBean objConvenioBean,List OrdenExamenesBeans) throws Exception {
//		iObjLog.debug("Entrando ClientesDao.buscarConvenio:" + objConvenioBean.getCconvenio());
//			iObjSesion = HibernateUtil.getSession();
//			List lstConvenios = new ArrayList();
//			Query objQuery = null;
//			String strQuery = "";
//			CConvenio objInstanciaConvenio = new CConvenio();
//			EConvenio objInstanciaEConvenio = new EConvenio();
//			EConvenioDetalle objConvenioDetalle = null;
//			EConvenioPerfil objConvenioPerfil = null;
//			List lstExamenReturn = new ArrayList();
//			boolean bolConvenioCreditoTotal = false;
//	    	try{
//	            HibernateUtil.beginTrans();
//        		strQuery =  "select bPF " +					
//							" from EConvenio bPF " +					
//							" where bPF.cconvenio.cconvenio = " +  objConvenioBean.getCconvenio().intValue();
//	            
////        		strQuery =  "select cC " +					
////							" from CConvenio cC  " +					
////							" where cC.cconvenio = " +  objConvenioBean.getCconvenio().intValue() ;
//	            if (strQuery != "") {
//					objQuery = iObjSesion.createQuery(strQuery);
//					lstConvenios = objQuery.list();
//					if(lstConvenios != null) {
//						for(int inti=0;inti<lstConvenios.size();inti++) {
//							objInstanciaEConvenio = (EConvenio)lstConvenios.get(inti);
//							objInstanciaConvenio = objInstanciaEConvenio.getCconvenio();
//						}
//						objConvenioBean.setKconvenio(objInstanciaConvenio.getCconvenio());
//						objConvenioBean.setCcliente(objInstanciaConvenio.getCcliente().getCcliente().intValue());
//						objConvenioBean.setScliente(objInstanciaConvenio.getCcliente().getSrazonsocial());
//						objConvenioBean.setCconvenio(objInstanciaConvenio.getCconvenio());
//						objConvenioBean.setSconvenio(objInstanciaConvenio.getSconvenio());
////						objConvenioBean.setClistacorporativa(objInstanciaConvenio.getClistacorporativa().getClistacorporativa().intValue());
//						objConvenioBean.setCtipoconvenio(objInstanciaConvenio.getCtipoconvenio().getCtipoconvenio().intValue());
////						objConvenioBean.setCvigencia(objInstanciaConvenio.getCvigencia().getCvigencia().intValue());											
//						if (objConvenioBean.getCtipoconvenio() == 22) {
//							bolConvenioCreditoTotal = true;
//						}
//						Set objMapaExamenes = (Set) objInstanciaConvenio.getEconveniodetalles();
//						Set objMapaPerfiles = (Set) objInstanciaConvenio.getEconvenioperfils();
//						iObjLog.debug("Consulta ClientesDao.buscarConvenio:... el mapa tiene examenes " + objMapaExamenes.size());
//						iObjLog.debug("Consulta ClientesDao.buscarConvenio:... el mapa tiene perfiles " + objMapaPerfiles.size());
//						for(int inti=0;inti<OrdenExamenesBeans.size();inti++) {
//							OrdenExamenBean objExamenBean = new OrdenExamenBean();
//							objExamenBean = (OrdenExamenBean)OrdenExamenesBeans.get(inti);
//							Iterator objInteratorExamenes = objMapaExamenes.iterator();	
//							while (objInteratorExamenes.hasNext()) {
//								objConvenioDetalle = (EConvenioDetalle)objInteratorExamenes.next();
//								iObjLog.debug("Consulta ClientesDao.buscarConvenio:... Examen " + objConvenioDetalle.getCexamen().getCexamen().intValue() + " Convenio " + objConvenioDetalle.getCconvenio().getCconvenio().intValue());								
//								if ((objConvenioDetalle.getCexamen().getCexamen().intValue() == objExamenBean.getCexamen()) && 
//									(objConvenioDetalle.getCconvenio().getCconvenio().intValue() == objConvenioBean.getCconvenio().intValue()) && (objExamenBean.getCperfil() == -1 )) {
////									objExamenBean.setMsubtotal(new BigDecimal(dblPrecioPerfil));
//									objExamenBean.setCconvenio(objConvenioDetalle.getCconvenio().getCconvenio().intValue());
//									if (objConvenioBean.getCtipoconvenio() == 21) {
//										/*****************COPAGO*******************/
//										iObjLog.debug("Consulta DatosFacturaDao.cotizarConvenio:... Copago " + objInstanciaEConvenio.getMcopago() + " " + objInstanciaEConvenio.getPcopago() + " " + objInstanciaEConvenio.isBcopagopaciente() + " " + objInstanciaConvenio.getCconvenio());								
////										objExamenBean.setMfacturaempresa(new BigDecimal(0));
////										objExamenBean.setMiva(new BigDecimal(dblPrecioPerfil - (dblPrecioPerfil / 1.16)));
////										objExamenBean.setMpagopaciente(new BigDecimal(dblPrecioPerfil));
////										objExamenBean.setMtotal(new BigDecimal(dblPrecioPerfil));							
//									} else if (objConvenioBean.getCtipoconvenio() == 22) {
//										/*****************CREDITO TOTAL*******************/
//										objExamenBean.setMdescuentoempresa(objExamenBean.getMsubtotal() - objConvenioDetalle.getMpreciofacturarconiva().doubleValue());
//										objExamenBean.setMdescuentomedico(0.0);
//										objExamenBean.setMdescuentopromocion(0.0);
//										objExamenBean.setMfacturaempresa(objConvenioDetalle.getMpreciofacturarconiva().doubleValue());
//										objExamenBean.setMiva(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() - objConvenioDetalle.getMpreciofacturarsiniva().doubleValue());
//										objExamenBean.setMpagopaciente(0.0);
//										objExamenBean.setMtotal(objConvenioDetalle.getMpreciofacturarconiva().doubleValue());							
//									} else if ((objConvenioBean.getCtipoconvenio() == 23) || (objConvenioBean.getCtipoconvenio() == 24)) {
//										/*****************PAGO DE CONTADO CONVENIO Y PROMOCION*******************/
//										double valor = ((objExamenBean.getMsubtotal() * objConvenioDetalle.getPdescuento().doubleValue())/100);
//										int numero = (int)(valor * 100); 
//										valor = numero/100.0; 
//										objExamenBean.setMdescuentomedico(0.0);
//										objExamenBean.setMfacturaempresa(0.0);
//										switch (objConvenioBean.getCtipoconvenio()) {
//											case 23: {
//												objExamenBean.setMdescuentoempresa(valor);
//												objExamenBean.setMdescuentopromocion(0.0);
//												break;
//											}
//											case 24: {
//												objExamenBean.setMdescuentoempresa(0.0);
//												objExamenBean.setMdescuentopromocion(valor);
//												break;
//											}
//										}
//										double valorTotal = (objExamenBean.getMsubtotal() - (objExamenBean.getMdescuentoempresa() + objExamenBean.getMdescuentopromocion()));
//										int numeroTotal = (int)(valorTotal * 100); 
//										valorTotal = numeroTotal/100; 
////										valorTotal = numeroTotal/100.0; Si quiero 2 decimales
//										objExamenBean.setMpagopaciente(valorTotal);
//										objExamenBean.setMtotal(objExamenBean.getMpagopaciente());							
//										objExamenBean.setMiva((objExamenBean.getMpagopaciente() - (objExamenBean.getMpagopaciente() / 1.16)));										
//										if (objExamenBean.getCconvenio() == 0) {
//											objExamenBean.setMdescuentoempresa(0.0);
//											objExamenBean.setMdescuentopromocion(0.0);
//											objExamenBean.setMsubtotal(objExamenBean.getMpagopaciente());
//										}										
//									}
//									lstExamenReturn.add(objExamenBean);								
//									break;
//								}								
//							}
//							objInteratorExamenes = null;
//
//							if (objExamenBean.getCperfil() > -1) {
//								Iterator objInteratorPerfiles = objMapaPerfiles.iterator();	
//								while (objInteratorPerfiles.hasNext()) {
//									objConvenioPerfil = (EConvenioPerfil)objInteratorPerfiles.next();
//									iObjLog.debug("Consulta ClientesDao.buscarConvenio:... Perfil " + objConvenioPerfil.getCperfil().getCperfil().intValue() + " Convenio " + objConvenioDetalle.getCconvenio().getCconvenio().intValue());								
//									if ((objConvenioPerfil.getCperfil().getCperfil().intValue() == objExamenBean.getCperfil()) && 
//										(objConvenioPerfil.getCconvenio().getCconvenio().intValue() == objConvenioBean.getCconvenio().intValue()) && (objExamenBean.getCperfil() > -1 )) {
//	//									objExamenBean.setMsubtotal(new BigDecimal(dblPrecioPerfil));
//										objExamenBean.setCconvenio(objConvenioPerfil.getCconvenio().getCconvenio().intValue());
//										if (objConvenioBean.getCtipoconvenio() == 22) {
//											/*****************CREDITO TOTAL*******************/
//											objExamenBean.setMdescuentoempresa(0.0);
//											objExamenBean.setMdescuentomedico(0.0);
//											objExamenBean.setMdescuentopromocion(0.0);
//											objExamenBean.setMfacturaempresa((objExamenBean.getMsubtotal() - objExamenBean.getMdescuentoempresa()));
//											objExamenBean.setMiva(0.0);
//											objExamenBean.setMpagopaciente(0.0);
//											objExamenBean.setMtotal(objExamenBean.getMfacturaempresa());							
//										} 
//										lstExamenReturn.add(objExamenBean);								
//										break;
//									}								
//								}
//								objInteratorPerfiles = null;
//							}														
//							objExamenBean = null;
//						}
//					}			
//	            }
//			iObjLog.debug("Saliendo ClientesDao.buscarConvenio...  " + lstConvenios.size());
//			return lstExamenReturn;
//		} catch (Exception aObjExcepcion) { 
//			iObjLog.error("ERROR ClientesDao.buscarConvenio: ", aObjExcepcion);
//			throw aObjExcepcion;
//        } finally{
//        	lstConvenios.clear();
//        	lstConvenios = null;
//        	objQuery = null;
//        	objInstanciaConvenio = null;
//        	HibernateUtil.closeSession();
//		}		
//	}			
}
