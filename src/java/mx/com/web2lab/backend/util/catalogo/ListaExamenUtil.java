package mx.com.web2lab.backend.util.catalogo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.josql.Query;
import org.josql.QueryResults;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

import mx.com.web2lab.backend.beans.ap.OrdenExamenBean;
import mx.com.web2lab.backend.beans.comer.ConvenioBean;
import mx.com.web2lab.backend.beans.tools.CatalogosBean;
import mx.com.web2lab.backend.dao.ap.ExamenesDao;
import mx.com.web2lab.backend.dao.comer.ClientesNewDao;
import mx.com.web2lab.backend.hbm.om.ap.CExamenConvenioSinonimo;

public class ListaExamenUtil {

	private static Log iObjLog = LogFactory.getLog(ListaExamenUtil.class);
			
	public int size() {
		return CatalogosBean.lstExamenes.size();
	}
	
	public void LoadExamenes() throws Exception {
		iObjLog.debug("Entrando ListaExamenUtil.LoadExamenes()");
		try {
			if (CatalogosBean.lstExamenes.size() < 1) {
				ExamenesDao objExamenDao = new ExamenesDao();
//				List lstReturn = (List)objExamenDao.getExamenesPerfilesCorporativa();
//				List lstLocal = new ArrayList();
//				lstLocal = (List)lstReturn.get(0);
//				CatalogosBean.lstExamenes 	= lstLocal;
//				lstLocal = (List)lstReturn.get(1);
//				CatalogosBean.lstPerfiles 	= lstLocal;
//				lstLocal = (List)lstReturn.get(2);
//				CatalogosBean.lstProductos 	= lstLocal;
				iObjLog.debug("Cargando ExamenesStatic.LoadExamenes Examenes " + CatalogosBean.lstExamenes.size() + " Productos " + CatalogosBean.lstProductos.size());
			}		
			iObjLog.debug("Saliendo ExamenesStatic.LoadExamenes...." + CatalogosBean.lstExamenes.size());
		} catch (Exception exp) {
			iObjLog.error("Consulta ExamenesStatic.LoadExamenes(int kCodigoPostal).....Exception ",exp);				
			throw exp;			
		}
	}
		
	public  List getExamenes(OrdenExamenBean objExamenBean, int intSucursal,int cListaPrecio,int CConvenio) throws Exception {
		iObjLog.debug("Entrando ExamenesStatic.getExamenes " + objExamenBean.getSexamen() + " " + intSucursal + " " + cListaPrecio + " " + CConvenio);
		List lstResult = new ArrayList();
		Query objQuery = new Query();
		QueryResults objQueryResult = null;				
		boolean bolExamenes = true;
		try {
			this.LoadExamenes();
			String strSQL = "SELECT * FROM mx.com.web2lab.backend.beans.ap.OrdenExamenBean WHERE clistapublico = " + cListaPrecio + " ";
			String strWhere = "";
			if (objExamenBean.getSexamen().trim() != "" && objExamenBean.getSexamen().trim().length() > 1) {
				iObjLog.debug("Entrando ExamenesStatic.getExamenes" + objExamenBean.getSexamen().substring(0, 2));				
				if (objExamenBean.getSexamen().substring(0, 2).equals("P.")) {
					strWhere += " and sperfil like '%" + objExamenBean.getSexamen().substring(2).trim() + "%' and cperfil>-1 ";
					bolExamenes = false;
				} else if (objExamenBean.getSexamen().substring(0, 2).equals("S.")) {
					ExamenesDao objExamenDAO =  new ExamenesDao();
					List lstExamenesSinonimo = objExamenDAO.buscarExamenSinonimoConvenio(CConvenio, objExamenBean.getSexamen().substring(2).trim());
					for(int inti=0;inti<lstExamenesSinonimo.size();inti++) {
						CExamenConvenioSinonimo objExamen = (CExamenConvenioSinonimo)lstExamenesSinonimo.get(inti);
						strWhere += " and cexamen in (" + objExamen.getCexamen() + ") and cperfil=-1 ";
					}
					objExamenDAO = null;
					lstExamenesSinonimo.clear();
					lstExamenesSinonimo = null;
				} else {
					strWhere += " and sexamen like '%" + objExamenBean.getSexamen() + "%' and cperfil=-1 ";
					bolExamenes = true;
				}
			}
			if (objExamenBean.getStipocomercial().trim() != "" && objExamenBean.getStipocomercial().trim().length() > 1) {
				strWhere += " and stipocomercial like '" + objExamenBean.getStipocomercial() + "%'";
			}
			if (objExamenBean.getCclasificacioncomercial() > 0) {
				iObjLog.debug("Entrando ExamenesStatic.getExamenes.....Por Clasificacion " + objExamenBean.getCclasificacioncomercial());				
				strWhere += " and cclasificacioncomercial = " + objExamenBean.getCclasificacioncomercial() + " and cperfil = -1 ";
			}
			iObjLog.debug("Consulta ExamenesStatic.getExamenes...." + strSQL + strWhere);
			if (strWhere.trim().length() > 0) {
				objQuery.parse(strSQL + strWhere);			
				if (bolExamenes) {
					objQueryResult = objQuery.execute(CatalogosBean.lstExamenes);					
				} else {
					objQueryResult = objQuery.execute(CatalogosBean.lstPerfiles);					
				}
				lstResult = this.loadExamenes(objQueryResult.getResults());				
				if (lstResult != null) {
					iObjLog.debug("Consulta ExamenesStatic.getExamenes....." + lstResult.size());
				} else {
					iObjLog.debug("Consulta ExamenesStatic.getExamenes.....VACIO");				
				}				
				iObjLog.debug("Saliendo ExamenesStatic.getExamenes");
			}
			return lstResult;
		} catch (QueryParseException qpe) {
			iObjLog.error("Consulta ExamenesStatic.getExamenes.....QueryParseException ",qpe);				
			throw qpe;
		} catch (QueryExecutionException qee) {
			iObjLog.error("Consulta ExamenesStatic.getExamenes.....QueryExecutionException ",qee);				
			throw qee;
		} catch (Exception exp) {
			iObjLog.error("Consulta ExamenesStatic.getExamenes.....Exception ",exp);				
			throw exp;
		} finally {
			objQuery = null;
			objQueryResult = null;
		}
	}	

	public  List cotizarProductos(String strQuery, int intSucursal, int intListaPrecios,int CConvenio) throws Exception {
		iObjLog.debug("Entrando ExamenesStatic.getExamenes " + strQuery);
		Query objQuery = new Query();
		QueryResults objQueryResult = null;
		List lstResult = new ArrayList();
		String strWhere  = "";
		try {
			this.LoadExamenes();
			String strSQL;
			if (strQuery.trim() != "") {
				strSQL = "SELECT * FROM mx.com.web2lab.backend.beans.ap.OrdenExamenBean WHERE cexamen=cexamen ";
				iObjLog.debug("Consultando ExamenesStatic.getExamenes Sininimo " + strQuery.substring(0, 2).equals("S."));
				if (strQuery.substring(0, 2).equals("S.")) {
					ExamenesDao objExamenDAO =  new ExamenesDao();
					List lstExamenesSinonimo = objExamenDAO.buscarExamenSinonimoConvenio(CConvenio, strQuery.substring(2).trim());
					String strExamenes = "";
					for(int inti=0;inti<lstExamenesSinonimo.size();inti++) {
						CExamenConvenioSinonimo objExamen = (CExamenConvenioSinonimo)lstExamenesSinonimo.get(inti);
						strExamenes +=  objExamen.getCexamen() + ",";
					}					
					strWhere += " and cexamen in (" + strExamenes + "0" + ") and cperfil=-1 and clistapublico in (" + intListaPrecios + ")";
					objExamenDAO = null;
					lstExamenesSinonimo.clear();
					lstExamenesSinonimo = null;
				} else {
					strWhere = " and (((cexamen in (" + strQuery + ") and cperfil=-1) or (cperfil in (" + strQuery + "))) and (clistapublico = " + intListaPrecios + "))";
				}
				strSQL = (strSQL + strWhere);
				iObjLog.debug("Consulta ExamenesStatic.getExamenes...." + strSQL);
				iObjLog.debug("Consulta ExamenesStatic.getExamenes....Productos " + CatalogosBean.lstProductos.size());
				objQuery.parse(strSQL);			
				objQueryResult = objQuery.execute(CatalogosBean.lstProductos);
				lstResult = this.loadExamenes(objQueryResult.getResults());							
				if (lstResult != null) {
					iObjLog.debug("Consulta ExamenesStatic.getExamenes....." + lstResult.size());
				} else {
					iObjLog.debug("Consulta ExamenesStatic.getExamenes.....VACIO");				
				}				
				iObjLog.debug("Saliendo ExamenesStatic.getExamenes");
			}
			return lstResult;
		} catch (QueryParseException qpe) {
			iObjLog.error("Consulta ExamenesStatic.getExamenes.....QueryParseException ",qpe);				
			throw qpe;
		} catch (QueryExecutionException qee) {
			iObjLog.error("Consulta ExamenesStatic.getExamenes.....QueryExecutionException ",qee);				
			throw qee;
		} catch (Exception exp) {
			iObjLog.error("Consulta ExamenesStatic.getExamenes.....Exception ",exp);				
			throw exp;
		} finally {
			objQuery = null;
			objQueryResult = null;
		}
	}	

	public  List cotizarProductosConvenio(String strQuery, int intSucursal,int intConvenio) throws Exception {
		iObjLog.debug("Entrando ListaExamenUtil.cotizarProductosConvenio " + strQuery);
		List lstResult = new ArrayList();		
		List lstReturn = new ArrayList();		
		ClientesNewDao objConvenioDao = new ClientesNewDao();
		ConvenioBean objConvenioBean = new ConvenioBean();
		try {
			objConvenioBean.setCconvenio(new Integer(intConvenio));
			int cListaPrecio = objConvenioDao.ListaPreciosConvenio(objConvenioBean);
			lstResult = this.cotizarProductos(strQuery, intSucursal,cListaPrecio,intConvenio);
			lstReturn = objConvenioDao.cotizarConvenio(objConvenioBean,lstResult,false);
			iObjLog.debug("Consulta ListaExamenUtil.cotizarProductosConvenio..... 1 " + lstReturn.size());
			if (intSucursal == 999 && lstReturn.size() == 0) {
				iObjLog.debug("Consulta ListaExamenUtil.cotizarProductosConvenio..... 2 " + lstReturn.size());
				lstResult.clear();
				List lstResultNuevoExamen = new ArrayList();		
				lstResultNuevoExamen = this.cotizarProductos(strQuery, intSucursal,cListaPrecio,intConvenio);
				iObjLog.debug("Consulta ListaExamenUtil.cotizarProductosConvenio..... 3 " + lstReturn.size());
				return lstResultNuevoExamen;
			}
			if (lstReturn != null) {
				iObjLog.debug("Consulta ListaExamenUtil.cotizarProductosConvenio....." + lstReturn.size());
			} else {
				iObjLog.debug("Consulta ListaExamenUtil.cotizarProductosConvenio.....VACIO");				
			}				
			iObjLog.debug("Saliendo ListaExamenUtil.cotizarProductosConvenio");
			return lstReturn;
		} catch (Exception exp) {
			iObjLog.error("Consulta ListaExamenUtil.cotizarProductosConvenio.....Exception ",exp);				
			throw exp;
		} finally {
			objConvenioDao = null;
			objConvenioBean = null;
			lstResult.clear();
			lstResult = null;
		}
	}		

	
	public  List cotizarNombreProductosConvenio(String strQuery, int intSucursal,int intConvenio) throws Exception {
		iObjLog.debug("Entrando ExamenesStatic.getExamenes");
		List lstResult = new ArrayList();		
		List lstReturn = new ArrayList();		
		ClientesNewDao objConvenioDao = new ClientesNewDao();
		ConvenioBean objConvenioBean = new ConvenioBean();
		try {
//			lstResult = this.cotizarProductos(strQuery, intSucursal);
			objConvenioBean.setCconvenio(new Integer(intConvenio));
			int intCListaPrecio =  objConvenioDao.ListaPreciosConvenio(objConvenioBean);
			OrdenExamenBean objExamenBean = new OrdenExamenBean();
			objExamenBean.setSexamen(strQuery);
			lstResult = this.getExamenes(objExamenBean, intSucursal,intCListaPrecio,intConvenio);
			objExamenBean = null;
			lstReturn = objConvenioDao.cotizarConvenio(objConvenioBean,lstResult,false);
			if (lstReturn != null) {
				iObjLog.debug("Consulta ExamenesStatic.getExamenes....." + lstReturn.size());
			} else {
				iObjLog.debug("Consulta ExamenesStatic.getExamenes.....VACIO");				
			}				
			iObjLog.debug("Saliendo ExamenesStatic.getExamenes");
			return lstReturn;
		} catch (Exception exp) {
			iObjLog.error("Consulta ExamenesStatic.getExamenes.....Exception ",exp);				
			throw exp;
		} finally {
			objConvenioDao = null;
			objConvenioBean = null;
			lstResult.clear();
			lstResult = null;
		}
	}		

	
	public  List cotizarProductosConvenioAdministrador(String strQuery,int intConvenio) throws Exception {
		iObjLog.debug("Entrando ListaExamenUtil.cotizarProductosConvenio " + strQuery);
		List lstResult = new ArrayList();		
		List lstReturn = new ArrayList();		
		List lstReturn1 = new ArrayList();
		List lstReturn2 = new ArrayList();		
		ClientesNewDao objConvenioDao = new ClientesNewDao();
		ConvenioBean objConvenioBean = new ConvenioBean();
		OrdenExamenBean objExamenBean = new OrdenExamenBean();
		List lstResultNuevoExamen = new ArrayList();		
		int intSucursal = 0;
		try {
			objConvenioBean.setCconvenio(new Integer(intConvenio));
			int cListaPrecio = objConvenioDao.ListaPreciosConvenio(objConvenioBean);			
			iObjLog.debug("Consulta por Numero ClientesDao.buscarConvenio...Numero de Examenes  " + strQuery);				
				try { 
					Integer.parseInt(strQuery); 
					intSucursal = 999;
					iObjLog.debug("Consulta por Numero ClientesDao.buscarConvenio...Numero de Examenes  " + strQuery + " Numero");				
					lstReturn1 = this.cotizarProductos(strQuery, intSucursal,cListaPrecio,intConvenio);
					iObjLog.debug("Consulta por Numero ListaExamenUtil.cotizarProductosConvenioAdministrador...CotizarProductos " + strQuery + " lstReturn1..Numero: " + lstReturn1.size());				
					lstReturn2 = objConvenioDao.cotizarConvenio(objConvenioBean,lstReturn1,false);
					iObjLog.debug("Consulta por Numero ListaExamenUtil.cotizarProductosConvenioAdministrador...CotizarConvenio " + strQuery + " lstReturn2..Numero: " + lstReturn2.size());									
					if (intSucursal == 999 && lstReturn.size() == 0) {
						lstResult.clear();
						lstResultNuevoExamen = this.cotizarProductos(strQuery, intSucursal,cListaPrecio,intConvenio);
						return lstResultNuevoExamen;
					}							
				} catch (NumberFormatException exc) { 
					iObjLog.debug("Consulta por Numero ClientesDao.buscarConvenio...Nombre de Examenes  " + strQuery + " Nombre");				
					intSucursal = 1;
					objExamenBean.setSexamen(strQuery);
					lstReturn1 = this.getExamenes(objExamenBean, intSucursal,cListaPrecio,intConvenio);
					iObjLog.debug("Consulta por Nombre ListaExamenUtil.cotizarProductosConvenioAdministrador...CotizarProductos " + strQuery + " lstReturn1..Nombre: " + lstReturn1.size());				
					lstReturn2 = objConvenioDao.cotizarConvenio(objConvenioBean,lstReturn1,false);
					iObjLog.debug("Consulta por Nombre ListaExamenUtil.cotizarProductosConvenioAdministrador...CotizarConvenio " + strQuery + " lstReturn2..Nombre: " + lstReturn2.size());									
				}			
			iObjLog.debug("Saliendo ListaExamenUtil.cotizarProductosConvenio");			
			lstReturn.add(lstReturn1);
			lstReturn.add(lstReturn2);
			return lstReturn;
		} catch (Exception exp) {
			iObjLog.error("Consulta ListaExamenUtil.cotizarProductosConvenio.....Exception ",exp);				
			throw exp;
		} finally {
			objConvenioDao = null;
			objConvenioBean = null;
			objExamenBean = null;
			lstResult.clear();
			lstResult = null;
		}
	}		
	
	
	private List loadExamenes(List lstLoad) throws Exception {
		List lstResult = new ArrayList();
		try {			
			if (lstLoad != null) {
				if (lstLoad.size()>0) {
					for(int inti=0;inti<lstLoad.size();inti++){
						OrdenExamenBean objExamenBean = new OrdenExamenBean();
						OrdenExamenBean objExamenCatalogo = new OrdenExamenBean();
						objExamenCatalogo = (OrdenExamenBean)lstLoad.get(inti);
						objExamenBean.setBolnewExamen(objExamenCatalogo.isBolnewExamen());
						objExamenBean.setCconvenio(objExamenCatalogo.getCconvenio());
						objExamenBean.setClugarprocesamiento(objExamenCatalogo.getClugarprocesamiento());
						objExamenBean.setDresultadoentrega(objExamenCatalogo.getDresultadoentrega());
						objExamenBean.setKordenexamensucursal(objExamenCatalogo.getKordenexamensucursal());
						objExamenBean.setKpromocion(objExamenCatalogo.getKpromocion());
						objExamenBean.setSmotivocancelacion(objExamenCatalogo.getSmotivocancelacion());
						objExamenBean.setSobservaciones(objExamenCatalogo.getSobservaciones());
						objExamenBean.setUmuestra(objExamenCatalogo.getUmuestra());						
						objExamenBean.setCestadoregistro(objExamenCatalogo.getCestadoregistro());
						objExamenBean.setCexamen(objExamenCatalogo.getCexamen());
						objExamenBean.setCsucursal(objExamenCatalogo.getCsucursal());
						objExamenBean.setUserid(objExamenCatalogo.getUserid());
						objExamenBean.setDregistro(objExamenCatalogo.getDregistro());
						objExamenBean.setMsubtotal(objExamenCatalogo.getMsubtotal());
						objExamenBean.setMdescuentoempresa(objExamenCatalogo.getMdescuentoempresa());
						objExamenBean.setMdescuentomedico(objExamenCatalogo.getMdescuentomedico());
						objExamenBean.setMdescuentopromocion(objExamenCatalogo.getMdescuentopromocion());
						objExamenBean.setMfacturaempresa(objExamenCatalogo.getMfacturaempresa());
						objExamenBean.setMiva(objExamenCatalogo.getMiva());
						objExamenBean.setMpagopaciente(objExamenCatalogo.getMpagopaciente());
						objExamenBean.setMtotal(objExamenCatalogo.getMtotal());
						objExamenBean.setSexamen(objExamenCatalogo.getSexamen());
						objExamenBean.setCtipocomercial(objExamenCatalogo.getCtipocomercial());
						objExamenBean.setStipocomercial(objExamenCatalogo.getStipocomercial());
						objExamenBean.setCclasificacioncomercial(objExamenCatalogo.getCclasificacioncomercial());
						objExamenBean.setSclasificacioncomercial(objExamenCatalogo.getSclasificacioncomercial());
						objExamenBean.setUdiasproceso(objExamenCatalogo.getUdiasproceso());
						objExamenBean.setCperfil(objExamenCatalogo.getCperfil());
						objExamenBean.setSperfil(objExamenCatalogo.getSperfil());					
						objExamenBean.setClistapublico(objExamenCatalogo.getClistapublico());
						objExamenBean.setBolListaPublico(objExamenCatalogo.isBolListaPublico());
						objExamenBean.setUvolumenexamen(objExamenCatalogo.getUvolumenexamen());
						lstResult.add(objExamenBean);
						objExamenCatalogo = null;
						objExamenBean = null;
					}
				}
			}		
		} catch (Exception exp) {
			iObjLog.error("Consulta ExamenesStatic.loadExamenes..... ",exp);				
			throw exp;			
		} finally {
			lstLoad.clear();
			lstLoad = null;
		}
		return lstResult;
	}	
}
