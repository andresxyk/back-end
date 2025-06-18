package mx.com.web2lab.backend.dao.ap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import mx.com.web2lab.backend.dao.tools.AdministracionFOP_PDF;
import mx.com.web2lab.backend.hbm.ConfiguracionProperties;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.util.formatos.ConvierteNumeros;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DatosReportesDao {

	private static Log iObjLog = LogFactory.getLog(DatosReportesDao.class);
	    
	private Session iObjSesion = null;
	
	
	public DatosReportesDao(){
//		iObjSesion = HibernateUtil.getSession();
	}

	public String createFOPOrden(int kOrdenSucursal)  throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Statement objStatement = null;
		Statement objStatementExamenes = null;
		ResultSet rst = null;
		ResultSet rstExamenes = null;
		String strSQL = "";		
		AdministracionFOP_PDF objAdministracionFOP_PDF = new AdministracionFOP_PDF();
		String strFOP = "";
		String strExamenesBody = "";
		String strOrdenBody = "";
		String strNomArchivo = "ReporteOrdenFOP" + Calendar.getInstance().getTimeInMillis() + "_" + kOrdenSucursal; 
    	try{
			iObjLog.debug("Entrando DatosReportesDao.createFOPOrden:Entrando...  " + kOrdenSucursal);
			Connection objConn = iObjSesion.connection();
			objStatement = objConn.createStatement();
			objStatementExamenes = objConn.createStatement();
			strSQL = "";
			iObjLog.debug("Entrando DatosReportesDao.createFOPOrden:Consulta...  " + strSQL);
			rst = objStatement.executeQuery(this.SQLFOPOrden(kOrdenSucursal));
			iObjLog.debug("Entrando DatosReportesDao.createFOPOrden:ConsultaOrden...  " + this.SQLFOPOrden(kOrdenSucursal));
			rstExamenes = objStatementExamenes.executeQuery(this.SQLFOPExamenes(kOrdenSucursal));
			iObjLog.debug("Entrando DatosReportesDao.createFOPOrden:ConsultaExamen...  " + this.SQLFOPExamenes(kOrdenSucursal));
			if(rstExamenes != null) {
				while(rstExamenes.next()) {					
					strExamenesBody += this.createFOPExamenes(rstExamenes);
				}
			}					
			
			if(rst != null) {
				while(rst.next()) {					
					strOrdenBody = this.createFOPOrden(rst,strExamenesBody);
					break;
				}
			}					
			strFOP = objAdministracionFOP_PDF.createOrdenFOP(strOrdenBody, strNomArchivo);
			iObjLog.debug("Resultado DatosReportesDao.createFOPOrden:Consulta...  ");		
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosReportesDao.createFOPOrden:: ", aObjExcepcion);
			throw aObjExcepcion;
		} finally{
			if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
			if (rst != null) {
				rst.close();
				rst = null;
			}
			if (objStatementExamenes != null) {
				objStatementExamenes.close();
				objStatementExamenes = null;
			}
			if (rstExamenes != null) {
				rstExamenes.close();
				rstExamenes = null;
			}
        	HibernateUtil.closeSession();
		}				
		return strFOP;
	}

	private String createFOPExamenes(ResultSet objResultSet) throws Exception {
		String strRows = "";
		try {
				strRows  =  "<fo:table-row>																		\n" +     			
							"        <fo:table-cell  >      													\n" +
							"        	<fo:block text-align='left' font-family='sans-serif' font-size='6pt'>  	\n" + 
											" " + objResultSet.getString("cexamen") + "							\n" + 
							"			</fo:block>    															\n" + 		
							"        </fo:table-cell>     														\n" +	
							"        <fo:table-cell >      														\n" +
							"        	<fo:block text-align='left' font-family='sans-serif' font-size='6pt'>	\n" + 
							 					objResultSet.getString("sexamen") + "							\n" + 
							"			</fo:block>    															\n" + 										
							"        </fo:table-cell>     														\n" +	
							"        <fo:table-cell >      														\n" +
							"        	<fo:block text-align='left' font-family='sans-serif' font-size='6pt'>	\n" + 
												objResultSet.getString("ssucursalentrega") + "					\n" + 
							"			</fo:block>    															\n" + 										
							"        </fo:table-cell>     														\n" +	
							"        <fo:table-cell >      														\n" +
							"        	<fo:block text-align='left' font-family='sans-serif' font-size='6pt'>	\n" + 
											"$ " + objResultSet.getString("mfactura") + "						\n"	+ 
							"			</fo:block>    															\n" + 										
							"        </fo:table-cell>     														\n" +	
							"</fo:table-row>     																\n";
		} catch (Exception aObjExcepcion) {
			iObjLog.error("ERROR DatosReportesDao.createFOPExamenes:: ", aObjExcepcion);
		}
		return strRows;
	}
	
	public String createFOPOrden(ResultSet objResultSet,String strRows) throws Exception {
		String strFOP = "";		
		try {	
			double[] TopDouble = {-1.4,-0.85,-0.8,-0.8,-0.4,-0.4,-0.4,0.1,0.4,0.65,1.5,1.5,1.2,1.8,3,8.3,9.27,9.2,9.6,10.3,10.55,10.8,11.1,8.7};		
			strFOP =	"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>			\n" +
						    "<fo:root xmlns:fo=\"http://www.w3.org/1999/XSL/Format\">	\n" +
						    "  <fo:layout-master-set>									\n" +
						    "    <fo:simple-page-master master-name=\"my-page\">		\n" +
						    "      <fo:region-body margin=\"1in\" />					\n" +
						    "    </fo:simple-page-master>								\n" +
						    "  </fo:layout-master-set>									\n" +
						    "<fo:page-sequence master-name=\"my-page\" master-reference=\"my-page\">	\n" +  
							"	<fo:flow flow-name='xsl-region-body'> 					\n" +
									this.createBodyFOPOrden(TopDouble, strRows, objResultSet,true);
							
			for(int inti=0;inti<TopDouble.length;inti++) {
				TopDouble[inti] = (TopDouble[inti] + 14);
			}
			strFOP += this.createBodyFOPOrden(TopDouble, strRows,objResultSet,false);
			strFOP += "        </fo:flow> 		\n" + 
		              "    </fo:page-sequence> 	\n"	+
		              "</fo:root>";	
		} catch (Exception aObjExcepcion) {
			iObjLog.error("ERROR DatosReportesDao.createFOPOrden:: ", aObjExcepcion);
			throw aObjExcepcion;
		}
		return strFOP;
	}
	
	
	private String createBodyFOPOrden(double[] TopDouble, String strRows,ResultSet objResultSet, boolean bolPrintBarCode) throws SQLException {		
		String strTotalLetras = "";				
		String sDecimalLetras = (new ConvierteNumeros(objResultSet.getLong("mtotalo")).getStrNumDec());
		String strDireccionPaciente = objResultSet.getString("sdir") + " " + objResultSet.getString("sdelmun") + " " + objResultSet.getString("sciudad");		
		if (sDecimalLetras == null) {
			sDecimalLetras = "0";
		}
		if (strDireccionPaciente == null) {
			strDireccionPaciente = "";		
		} else if (strDireccionPaciente.trim().length() > 88) {
			strDireccionPaciente = strDireccionPaciente.substring(0,87);
		}
			
		strTotalLetras = "Importe con letra: " + 
				(new ConvierteNumeros(objResultSet.getLong("mtotalo")).getNumLetras()) + 
				" pesos " + 
				sDecimalLetras + 
				"/100 M.N.";		
		
	    String sHttpPathZamora = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenes");	
	    if (objResultSet.getDouble("saldo") <= 0.5) {
	    	sHttpPathZamora = sHttpPathZamora + "Pagado.jpg";
	    }
		
		String strReturn = 	"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[0] + "cm' left='-1.1cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	" + objResultSet.getString("diruni") + " Tel: " + objResultSet.getString("cunitel") + "			\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[1] + "cm' left='-1.1cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times' font-weight='bold' font-size='8pt'> 		\n" +  
							"                         	" + objResultSet.getString("korden") + "														\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[2] + "cm' left='3.4cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times' font-size='8pt'> 							\n" +  
							"                         	" + objResultSet.getDate("dregistro") + "																				\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[3] + "cm' left='6.8cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times' font-weight='bold' font-size='8pt'> 		\n" +  
							"                         	Consecutivo " + objResultSet.getString("strkadmision") + "																				\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[4] + "cm' left='-0.5cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	" + objResultSet.getString("nombrepac") + "																	\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[5] + "cm' left='8cm' position='absolute'> 			\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	" + objResultSet.getString("kpaciente") + "																							\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[6] + "cm' left='9.8cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	Edad: " + objResultSet.getString("edad") + "																					\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[7] + "cm' left='-1.1cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times' font-size='8pt'> 							\n" +  
							"                         " + objResultSet.getInt("clvmedico") + " " + objResultSet.getString("smedico") + "																			\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[8] + "m' left='8cm' position='absolute'> 			\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	" + objResultSet.getString("stelefono") + "																							\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  																
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[9] + "cm' left='-1.1cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         " + strDireccionPaciente + "													\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  												
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[10] + "cm' left='-1.1cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         SUCURSAL " + objResultSet.getString("unidad") + " " + objResultSet.getInt("convenio") + " " + objResultSet.getString("sconvenio") + "																		\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[11] + "cm' left='12.15cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	" + objResultSet.getString("resultado") + "																					\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  																
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[12] + "cm' left='14.8cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	" + objResultSet.getDate("dpromesa") + "																					\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  									
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[13] + "cm' left='10.15cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	Entregar Resultados A: " + objResultSet.getString("sentregaresultadosa") + "																		\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +  																	
							"      <fo:block-container  height='40cm' width='16.4cm' top='" + TopDouble[14] + "cm' left='0.9cm' position='absolute' >   \n" + 
							"			<fo:table height='40cm' border-color='white' border-style=\"solid\" left='-1cm'>   								\n" + 
							"					<fo:table-column column-width='2.2cm'  	/>   															\n" + 
							"				    <fo:table-column column-width='7.8cm' 	/>   															\n" + 
							"					<fo:table-column column-width='4.4cm'  	/>   															\n" + 
							"					<fo:table-column column-width='2cm'  	/>   															\n" + 
							"					<fo:table-header>   																					\n" + 
							"						<fo:table-cell>   																					\n" + 
							"							<fo:block text-align='center' font-size='6pt' ></fo:block>   									\n" + 
							"                        </fo:table-cell>    																				\n" +
							"						<fo:table-cell>   																					\n" + 
							"							<fo:block text-align='center' font-size='6pt' ></fo:block>   									\n" + 
							"                        </fo:table-cell>    																				\n" +
							"                       <fo:table-cell>    																					\n" +
							"                    	    <fo:block text-align='center' font-size='6pt' ></fo:block>    									\n" +
							"                       </fo:table-cell>    																				\n" +
							"                       <fo:table-cell>    																					\n" +
							"                    	    <fo:block text-align='center' font-size='4.85pt' ></fo:block>    								\n" +
							"                       </fo:table-cell>    																				\n" +
							"                   </fo:table-header>    																					\n" +
							"					<fo:table-body   font-family='Times' font-weight='normal' font-size='6pt'>    							\n" +
														strRows +	
							"                </fo:table-body>     																						\n" +
							"       	</fo:table>     																								\n" +
							"	  </fo:block-container>     																							\n" +
				            "			 <fo:block-container border-color='black'  border-width='0.65pt' height='2cm' width='4cm' top='" + TopDouble[15] + "cm' left='13cm' position='absolute' > \n" + 
				            "                               <fo:block  text-align='right' font-family='Times' font-size='8pt'> 							\n" + 
			                "                                   $ " + objResultSet.getDouble("msubtotalo") + "																				\n" +  
			                "                               </fo:block> 																				\n" + 
			                "                               <fo:block text-align='right' font-size='1pt' space-before.optimum='2pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> \n" + 
			                "                               </fo:block> 																				\n" +
			                "                               <fo:block text-align='right' font-family='Times' font-size='8pt'> 							\n" + 
			                "                                   $ " + objResultSet.getDouble("mdescuentoo") + "																				\n" +  
			                "                               </fo:block> 																				\n" +  
			                "                               <fo:block text-align='right' font-size='1pt' space-before.optimum='2pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> \n" + 
			                "                               </fo:block> 																				\n" +
			                "                               <fo:block text-align='right' font-family='Times' font-size='8pt'> 							\n" + 
			                "                                   $ 0.0																					\n" +  
			                "                               </fo:block> 																				\n" + 
			                "                               <fo:block text-align='right' font-size='1pt' space-before.optimum='2pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> \n" + 
			                "                               </fo:block> 																				\n" + 
			                "                               <fo:block text-align='right' font-family='Times' font-size='8pt'> 							\n" + 
			                "                                   $ " + objResultSet.getDouble("mtotalo") + "																				\n" +  
			                "                               </fo:block> 																				\n" +  
				            "            </fo:block-container> 																							\n" +
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[16] + "cm' left='13.7cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	16%																								\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[17] + "cm' left='0.9cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	" + strTotalLetras + "										\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[23] + "cm' left='0.9cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	" + objResultSet.getString("sobservacion") + "																	\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[18] + "cm' left='0.9cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	Total: $ " + objResultSet.getDouble("mtotalo") + "																				\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[18] + "cm' left='5.5cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	A cuenta: $ " + objResultSet.getDouble("pagos") + "																					\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[18] + "cm' left='9.5cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	Adeuda: $ " + (objResultSet.getDouble("mtotalo") - objResultSet.getDouble("pagos")) + "																				\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[19] + "cm' left='13.7cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='8pt'> 							\n" +  
							"                         	Le Atendio: " + objResultSet.getString("usuario") + "																		\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +
							"      <fo:block-container height='4cm' width='14cm' top='" + TopDouble[20] + "cm' left='6.5cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times' font-weight='bold'  font-size='8pt'> 		\n" +  
							"                         	www.facturacionolab.mx contrase&ntilde;a: " + objResultSet.getString("serviciointernet") + "													\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n" +
							"      <fo:block-container height='4cm' width='16cm' top='" + TopDouble[21] + "cm' left='0.9cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='7pt'> 							\n" +  
							"                         	En caso de dudas llamar a los tel&eacute;fonos 40406054 40406044 40406074, en un Horario L-V 7:00-19:00, Sab 7:00-14:00 y Dom 8:00-12:00	\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n"+
							"      <fo:block-container height='4cm' width='16cm' top='" + TopDouble[22] + "cm' left='0.9cm' position='absolute'> 		\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times'  font-size='7pt'> 							\n" +  
							"                         	Usted tiene 20 d&iacute;as naturales a partir de la fecha de emisi&oacute;n de su orden de servicio para liquidarla al 100% y elaborar su factura.\n" +  
							"		    </fo:block> 																									\n" +
							"      </fo:block-container> 																								\n";		
		if (bolPrintBarCode) {
			strReturn +=	"      <fo:block-container  height='40cm' width='16.4cm' top='21cm' left='12cm' position='absolute' >   					\n" + 
							"			<fo:table height='40cm' border-color='white' border-style=\"solid\" left='-1cm'>   								\n" + 
							"					<fo:table-column column-width='16.4cm'  	/>   														\n" + 
							"					<fo:table-header>   																					\n" + 
							"						<fo:table-cell>   																					\n" + 
							"							<fo:block text-align='center' font-size='6pt' ></fo:block>   									\n" + 
							"                        </fo:table-cell>    																				\n" +
							"                   </fo:table-header>    																					\n" +
							"					<fo:table-body   font-family='Times' font-weight='normal' font-size='6pt'>    							\n" +
							"						<fo:table-row>																						\n" +     			
							"        					<fo:table-cell  >      																			\n" +
							"       						<fo:block>																					\n" +	
							"									<fo:instream-foreign-object>															\n" +
							"   									<bc:barcode xmlns:bc=\"http://barcode4j.krysalis.org/ns\" message='" + objResultSet.getString("strkadmision") + "'>		\n" +
							"     										<bc:code39>																		\n" +
							"       										<bc:height>1cm</bc:height>													\n" +
							"												<bc:human-readable>															\n" +
							"													<bc:placement>none</bc:placement>										\n" +
							"												</bc:human-readable>														\n" +
							"     										</bc:code39>																	\n" +
							"   									</bc:barcode>																		\n" +
							" 									</fo:instream-foreign-object>															\n" +	
							"								</fo:block> 																				\n" +					
							"        					</fo:table-cell>     																			\n" +	
							"						</fo:table-row>   					  																\n" +
							"                </fo:table-body>     																						\n" +
							"       	</fo:table>     																								\n" +
							"	  </fo:block-container>     																							\n" +
							"           <fo:block-container  height='100cm' width='100cm' top='7cm' left='11cm' padding='1pt' position='absolute'> \n " +  
							"               <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
							"                   <fo:external-graphic width='100pt' height='100pt' content-width='100pt' content-height='100pt' overflow='hidden' src = '" + sHttpPathZamora + "' />\n" +  
							"               </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      \n" +  
							"           </fo:block-container> \n ";
		}		
		return strReturn;
	}		
	
	
	private String SQLFOPOrden(int kOrdenSucursal) {
		return "SELECT TO_CHAR(NVL(tp.kpaciente,0)) kpaciente, " +
				"  NVL(trim(tp.sapellidopaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.sapellidomaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.snombre),' ') nombrepacf, " +
				"  NVL(trim(tp.sapellidopaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.sapellidomaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.snombre),' ') nombrepac, " +
				"  (NVL(trim(tos.ssucursal),'') " +
				"  || trim(TO_CHAR(NVL(tos.uorden,0),'00000000'))) korden, " +
				"  (NVL(trim(cs.ssucursal),'') " +
				"  || SUBSTR(trim(TO_CHAR(NVL(tos.uorden,0),'00000000')), LENGTH(trim(NVL(cs.ssucursal,''))) +1 )) ordenfmtv1, " +
				"  1 bimprimekorden, " +
				"  NVL(tos.kordensucursal,0) kadmision, " +
				"  TO_CHAR(NVL(tos.kordensucursal,0)) strkadmision, " +
				"  initcap( NVL(tp.sdireccion, ' ') " +
				"  || ' ' " +
				"  || ' ' " +
				"  || NVL(cc.scolonia, ' ')) " +
				"  || ' ' " +
				"  || NVL(tp.ccodigopostal,0 ) sdirf, " +
				"  initcap( NVL(trim(cc.sciudad), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.sestado), ' ')) sciudadf, " +
				"  initcap(NVL(trim(cc.sdelegacionmunicipio),' ')) sdelmunf, " +
				"  NVL(trim(tp.stelefono),' ') stelefonof, " +
				"  initcap ( NVL(tp.sdireccion, 'Sin Direcci&oacute;n ') " +
				"  || ' ' " +
				"  || NVL(ccp.sasentamiento,' ') " +
				"  || ' ' " +
				"  || NVL(ccp.scolonia,' ') ) " +
				"  || ' ' " +
				"  || NVL(ccp.cpostal,0 ) sdir, " +
				"  initcap( NVL(trim(ccp.sciudad), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(ccp.sestado), ' ')) sciudad, " +
				"  initcap( NVL(trim(ccp.sdelegacionmunicipio), ' ') ) sdelmun, " +
				"  NVL(trim(tp.stelefono),' ') stelefono, " +
				"  ' ' srfc, " +
				"  ' ' scurp, " +
				"  NVL(DECODE(tos.cmedico,5228,'A Qui&eacute;n Corresponda', 'Dr(a).' " +
				"  || tos.smedico), 'A Qui&eacute;n Corresponda') smedico, " +
				"  cm.cclave clvmedico, " +
				"  tos.dregistro, " +
				"  TO_CHAR(tos.dregistro,'hh24:mi') dhoracaptura, " +
				"  tos.dresultadoentrega, " +
				"  TO_CHAR(tos.dresultadoentrega,'hh24:mi') dhorapromesa, " +
				"  sysdate dfecha, " +
				"  TO_CHAR(sysdate,'hh24:mi') dhorafecha, " +
				"  (NVL(tos.piva,0)/100) piva, " +
				"  (NVL(tos.msubtotal,0)) msubtotalo, " +
				"  (NVL(tos.mpagopaciente,0)) mtotalo, " +
				"  (NVL(tos.mdescuentopromocion,0)+NVL(tos.mdescuentoempresa,0)+NVL(tos.mdescuentomedico,0) ) mdescuentoo, " +
				"  0 msobrecuotao, " +
				"  0 mfactura, " +
				"  NVL(trim(cs.ssucursal),' ') unidad, " +
				"  ' ' thorario, " +
				"  initcap ( NVL(trim(cs.sdireccion), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.sasentamiento), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.scolonia), ' ') " +
				"  || ' CP ' " +
				"  || NVL(TO_CHAR(cc.cpostal,'00000'),'Desconocido ') " +
				"  || ' ' " +
				"  || NVL(trim(cs.snombresucursal), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.sestado), ' ') ) dirUni, " +
				"  cs.stelefono cunitel, " +
				"  NVL(tpp.manticipo,0)   + NVL(tpp.mpagopacienteparcial,0) pagos, " +
				"  NVL(mpagopacientetotal - (manticipo + mpagopacienteparcial),0) saldo, " +
				"  NVL(trim(cs2.snombresucursal),' ') unidadent, " +
				"  NVL(trim(cs2.sdireccion),' ') sdirent, " +
				"  ' ' thorarioent, " +
				"  cs.csucursal cun, " +
				"  cs2.csucursal cunent, " +
				"  tuser.first_name " +
				"  ||' ' " +
				"  ||tuser.last_name usuario, " +
				"  0 urgentes, " +
				"  cer.cestadoregistro estadoorden, " +
				"  NVL(tos.sobservacion,' ') sobservacion, " +
				"  0 nfactura, " +
				"  tos.dregistro dcaptura, " +
				"  tos.dresultadoentrega dpromesa, " +
				"  tos.cconvenio convenio, " +
				"  ccon.sconvenio sconvenio, " +
				"  ccon.ctipoconvenio tipoconvenio, " +
				"  EXTRACT(YEAR FROM AGE(NOW(),tp.dnacimiento)) " +
				"  ||'A' " +
				"  ||' ' " +
				"  ||EXTRACT(MONTH FROM AGE(NOW(),tp.dnacimiento)) " +
				"  ||'M' " +
				"  ||' ' " +
				"  ||EXTRACT (DAY FROM AGE(NOW(), tp.dnacimiento)) " +
				"  ||'D' edad, " +
				"  ( " +
				"  CASE " +
				"    WHEN TO_CHAR(tos.dresultadoentrega,'D' )='1' " +
				"    THEN '12hrs a 13hrs' " +
				"    WHEN TO_CHAR(tos.dresultadoentrega,'D' )='7' " +
				"    THEN '12hrs a 13hrs' " +
				"    ELSE '17hrs a 18hrs' " +
				"  END) resultado, " +
				"  tos.cestadoregistro, " +
				"  NVL(trim(tos.spassword),' ') serviciointernet, " +
				"  tos.sentregaresultadosa " +
				"FROM t_orden_sucursal tos " +
				"INNER JOIN c_medico cm " +
				"ON tos.cmedico=cm.cmedico " +
				"INNER JOIN c_convenio ccon " +
				"ON tos.cconvenio=ccon.cconvenio " +
				"INNER JOIN c_sucursal cs " +
				"ON cs.csucursal = tos.csucursal " +
				"INNER JOIN c_codigo_postal cc " +
				"ON cc.ccodigopostal = cs.ccodigopostal " +
				"INNER JOIN t_paciente tp " +
				"ON tp.kpaciente = tos.kpaciente " +
				"INNER JOIN c_estado_registro cer " +
				"ON tos.cestadoregistro = cer.cestadoregistro " +
				"LEFT OUTER JOIN c_sucursal cs2 " +
				"ON tos.csucursalentrega = cs2.csucursal " +
				"LEFT OUTER JOIN c_codigo_postal ccp " +
				"ON ccp.ccodigopostal = tp.ccodigopostal " +
				"LEFT JOIN turbine_user tuser " +
				"ON tos.user_id = tuser.user_id " +
				"LEFT JOIN t_pago_paciente tpp " +
				"ON tos.kordensucursal   = tpp.kordensucursal " +
				"WHERE tos.kordensucursal in (" + kOrdenSucursal + ") " +  
				"AND tpp.kpagopaciente  IN " +
				"  (SELECT MAX(kpagopaciente) " +
				"  FROM t_pago_paciente " +
				"  WHERE kordensucursal  IN (" + kOrdenSucursal + ") " +
				"  AND tpp.kpagopaciente IS NOT NULL " +
				"  ) " +
				"UNION ALL " +
				"SELECT TO_CHAR(NVL(tp.kpaciente,0)) kpaciente, " +
				"  NVL(trim(tp.sapellidopaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.sapellidomaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.snombre),' ') nombrepacf, " +
				"  NVL(trim(tp.sapellidopaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.sapellidomaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.snombre),' ') nombrepac, " +
				"  (NVL(trim(tos.ssucursal),'') " +
				"  || trim(TO_CHAR(NVL(tos.uorden,0),'00000000'))) korden, " +
				"  (NVL(trim(cs.ssucursal),'') " +
				"  || SUBSTR(trim(TO_CHAR(NVL(tos.uorden,0),'00000000')), LENGTH(trim(NVL(cs.ssucursal,''))) +1 )) ordenfmtv1, " +
				"  1 bimprimekorden, " +
				"  NVL(tos.kordensucursal,0) kadmision, " +
				"  TO_CHAR(NVL(tos.kordensucursal,0)) strkadmision, " +
				"  initcap( NVL(tp.sdireccion, ' ') " +
				"  || ' ' " +
				"  || ' ' " +
				"  || NVL(cc.scolonia, ' ')) " +
				"  || ' ' " +
				"  || NVL(tp.ccodigopostal,0 ) sdirf, " +
				"  initcap( NVL(trim(cc.sciudad), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.sestado), ' ')) sciudadf, " +
				"  initcap(NVL(trim(cc.sdelegacionmunicipio),' ')) sdelmunf, " +
				"  NVL(trim(tp.stelefono),' ') stelefonof, " +
				"  initcap ( NVL(tp.sdireccion, 'Sin Direcci&oacute;n ') " +
				"  || ' ' " +
				"  || NVL(ccp.sasentamiento,' ') " +
				"  || ' ' " +
				"  || NVL(ccp.scolonia,' ') ) " +
				"  || ' ' " +
				"  || NVL(ccp.cpostal,0 ) sdir, " +
				"  initcap( NVL(trim(ccp.sciudad), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(ccp.sestado), ' ')) sciudad, " +
				"  initcap( NVL(trim(ccp.sdelegacionmunicipio), ' ') ) sdelmun, " +
				"  NVL(trim(tp.stelefono),' ') stelefono, " +
				"  ' ' srfc, " +
				"  ' ' scurp, " +
				"  NVL(DECODE(tos.cmedico,5228,'A Qui&eacute;n Corresponda', 'Dr(a).' " +
				"  || tos.smedico), 'A Qui&eacute;n Corresponda') smedico, " +
				"  cm.cclave clvmedico, " +
				"  tos.dregistro, " +
				"  TO_CHAR(tos.dregistro,'hh24:mi') dhoracaptura, " +
				"  tos.dresultadoentrega, " +
				"  TO_CHAR(tos.dresultadoentrega,'hh24:mi') dhorapromesa, " +
				"  sysdate dfecha, " +
				"  TO_CHAR(sysdate,'hh24:mi') dhorafecha, " +
				"  (NVL(tos.piva,0)/100) piva, " +
				"  (NVL(tos.msubtotal,0)) msubtotalo, " +
				"  (NVL(tos.mpagopaciente,0)) mtotalo, " +
				"  (NVL(tos.mdescuentopromocion,0)+NVL(tos.mdescuentoempresa,0)+NVL(tos.mdescuentomedico,0) ) mdescuentoo, " +
				"  0 msobrecuotao, " +
				"  0 mfactura, " +
				"  NVL(trim(cs.ssucursal),' ') unidad, " +
				"  ' ' thorario, " +
				"  initcap ( NVL(trim(cs.sdireccion), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.sasentamiento), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.scolonia), ' ') " +
				"  || ' CP ' " +
				"  || NVL(TO_CHAR(cc.cpostal,'00000'),'Desconocido ') " +
				"  || ' ' " +
				"  || NVL(trim(cs.snombresucursal), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.sestado), ' ') ) dirUni, " +
				"  cs.stelefono cunitel, " +
				"  NVL(tpp.manticipo,0)   + NVL(tpp.mpagopacienteparcial,0) pagos, " +
				"  NVL(mpagopacientetotal - (manticipo + mpagopacienteparcial),0) saldo, " +
				"  NVL(trim(cs2.snombresucursal),' ') unidadent, " +
				"  NVL(trim(cs2.sdireccion),' ') sdirent, " +
				"  ' ' thorarioent, " +
				"  cs.csucursal cun, " +
				"  cs2.csucursal cunent, " +
				"  tuser.first_name " +
				"  ||' ' " +
				"  ||tuser.last_name usuario, " +
				"  0 urgentes, " +
				"  cer.cestadoregistro estadoorden, " +
				"  NVL(tos.sobservacion,' ') sobservacion, " +
				"  0 nfactura, " +
				"  tos.dregistro dcaptura, " +
				"  tos.dresultadoentrega dpromesa, " +
				"  tos.cconvenio convenio, " +
				"  ccon.sconvenio sconvenio, " +
				"  ccon.ctipoconvenio tipoconvenio, " +
				"  EXTRACT(YEAR FROM AGE(NOW(),tp.dnacimiento)) " +
				"  ||'A' " +
				"  ||' ' " +
				"  ||EXTRACT(MONTH FROM AGE(NOW(),tp.dnacimiento)) " +
				"  ||'M' " +
				"  ||' ' " +
				"  ||EXTRACT (DAY FROM AGE(NOW(), tp.dnacimiento)) " +
				"  ||'D' edad, " +
				"  ( " +
				"  CASE " +
				"    WHEN TO_CHAR(tos.dresultadoentrega,'D' )='1' " +
				"    THEN '12hrs a 13hrs' " +
				"    WHEN TO_CHAR(tos.dresultadoentrega,'D' )='7' " +
				"    THEN '12hrs a 13hrs' " +
				"    ELSE '17hrs a 18hrs' " +
				"  END) resultado, " +
				"  tos.cestadoregistro, " +
				"  NVL(trim(tos.spassword),' ') serviciointernet, " +
				"  tos.sentregaresultadosa " +
				"FROM t_orden_sucursal tos " +
				"INNER JOIN c_medico cm " +
				"ON tos.cmedico=cm.cmedico " +
				"INNER JOIN c_convenio ccon " +
				"ON tos.cconvenio              =ccon.cconvenio " +
				"AND ((ccon.ctipoconvenio NOT IN (22)) " +
				"OR (ccon.ctipoconvenio       IN (22) " +
				"AND tos.mpagopaciente         > 0)) " +
				"INNER JOIN c_sucursal cs " +
				"ON cs.csucursal = tos.csucursal " +
				"INNER JOIN c_codigo_postal cc " +
				"ON cc.ccodigopostal = cs.ccodigopostal " +
				"INNER JOIN t_paciente tp " +
				"ON tp.kpaciente = tos.kpaciente " +
				"INNER JOIN c_estado_registro cer " +
				"ON tos.cestadoregistro = cer.cestadoregistro " +
				"LEFT OUTER JOIN c_sucursal cs2 " +
				"ON tos.csucursalentrega = cs2.csucursal " +
				"LEFT OUTER JOIN c_codigo_postal ccp " +
				"ON ccp.ccodigopostal = tp.ccodigopostal " +
				"LEFT JOIN turbine_user tuser " +
				"ON tos.user_id = tuser.user_id " +
				"LEFT JOIN t_pago_paciente tpp " +
				"ON tos.kordensucursal   = tpp.kordensucursal " +
				"WHERE tos.kordensucursal in (" + kOrdenSucursal + ") " +
				"AND tpp.kpagopaciente  IS NULL " +
				"/*Clientes de Credito pero no se imprime los importes*/ " +
				"UNION ALL " +
				"SELECT TO_CHAR(NVL(tp.kpaciente,0)) kpaciente, " +
				"  NVL(trim(tp.sapellidopaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.sapellidomaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.snombre),' ') nombrepacf, " +
				"  NVL(trim(tp.sapellidopaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.sapellidomaterno),' ') " +
				"  || ' ' " +
				"  || NVL(trim(tp.snombre),' ') nombrepac, " +
				"  (NVL(trim(tos.ssucursal),'') " +
				"  || trim(TO_CHAR(NVL(tos.uorden,0),'00000000'))) korden, " +
				"  (NVL(trim(cs.ssucursal),'') " +
				"  || SUBSTR(trim(TO_CHAR(NVL(tos.uorden,0),'00000000')), LENGTH(trim(NVL(cs.ssucursal,''))) +1 )) ordenfmtv1, " +
				"  1 bimprimekorden, " +
				"  NVL(tos.kordensucursal,0) kadmision, " +
				"  TO_CHAR(NVL(tos.kordensucursal,0)) strkadmision, " +
				"  initcap( NVL(tp.sdireccion, ' ') " +
				"  || ' ' " +
				"  || ' ' " +
				"  || NVL(cc.scolonia, ' ')) " +
				"  || ' ' " +
				"  || NVL(tp.ccodigopostal,0 ) sdirf, " +
				"  initcap( NVL(trim(cc.sciudad), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.sestado), ' ')) sciudadf, " +
				"  initcap(NVL(trim(cc.sdelegacionmunicipio),' ')) sdelmunf, " +
				"  NVL(trim(tp.stelefono),' ') stelefonof, " +
				"  initcap ( NVL(tp.sdireccion, 'Sin Direcci&oacute;n ') " +
				"  || ' ' " +
				"  || NVL(ccp.sasentamiento,' ') " +
				"  || ' ' " +
				"  || NVL(ccp.scolonia,' ') ) " +
				"  || ' ' " +
				"  || NVL(ccp.cpostal,0 ) sdir, " +
				"  initcap( NVL(trim(ccp.sciudad), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(ccp.sestado), ' ')) sciudad, " +
				"  initcap( NVL(trim(ccp.sdelegacionmunicipio), ' ') ) sdelmun, " +
				"  NVL(trim(tp.stelefono),' ') stelefono, " +
				"  ' ' srfc, " +
				"  ' ' scurp, " +
				"  NVL(DECODE(tos.cmedico,5228,'A Qui&eacute;n Corresponda', 'Dr(a).' " +
				"  || tos.smedico), 'A Qui&eacute;n Corresponda') smedico, " +
				"  cm.cclave clvmedico, " +
				"  tos.dregistro, " +
				"  TO_CHAR(tos.dregistro,'hh24:mi') dhoracaptura, " +
				"  tos.dresultadoentrega, " +
				"  TO_CHAR(tos.dresultadoentrega,'hh24:mi') dhorapromesa, " +
				"  sysdate dfecha, " +
				"  TO_CHAR(sysdate,'hh24:mi') dhorafecha, " +
				"  (NVL(tos.piva,0)/100) piva, " +
				"  (NVL(0,0)) msubtotalo, " +
				"  (NVL(0,0)) mtotalo, " +
				"  (NVL(0,0)+NVL(0,0)+NVL(0,0)) mdescuentoo, " +
				"  0 msobrecuotao, " +
				"  0 mfactura, " +
				"  NVL(trim(cs.ssucursal),' ') unidad, " +
				"  ' ' thorario, " +
				"  initcap ( NVL(trim(cs.sdireccion), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.sasentamiento), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.scolonia), ' ') " +
				"  || ' CP ' " +
				"  || NVL(TO_CHAR(cc.cpostal,'00000'),'Desconocido ') " +
				"  || ' ' " +
				"  || NVL(trim(cs.snombresucursal), ' ') " +
				"  || ' ' " +
				"  || NVL(trim(cc.sestado), ' ') ) dirUni, " +
				"  cs.stelefono cunitel, " +
				"  NVL(tpp.manticipo,0)   + NVL(tpp.mpagopacienteparcial,0) pagos, " +
				"  NVL(mpagopacientetotal - (manticipo + mpagopacienteparcial),0) saldo, " +
				"  NVL(trim(cs2.snombresucursal),' ') unidadent, " +
				"  NVL(trim(cs2.sdireccion),' ') sdirent, " +
				"  ' ' thorarioent, " +
				"  cs.csucursal cun, " +
				"  cs2.csucursal cunent, " +
				"  tuser.first_name " +
				"  ||' ' " +
				"  ||tuser.last_name usuario, " +
				"  0 urgentes, " +
				"  cer.cestadoregistro estadoorden, " +
				"  NVL(tos.sobservacion,' ') sobservacion, " +
				"  0 nfactura, " +
				"  tos.dregistro dcaptura, " +
				"  tos.dresultadoentrega dpromesa, " +
				"  tos.cconvenio convenio, " +
				"  ccon.sconvenio sconvenio, " +
				"  ccon.ctipoconvenio tipoconvenio, " +
				"  EXTRACT(YEAR FROM AGE(NOW(),tp.dnacimiento)) " +
				"  ||'A' " +
				"  ||' ' " +
				"  ||EXTRACT(MONTH FROM AGE(NOW(),tp.dnacimiento)) " +
				"  ||'M' " +
				"  ||' ' " +
				"  ||EXTRACT (DAY FROM AGE(NOW(), tp.dnacimiento)) " +
				"  ||'D' edad, " +
				"  ( " +
				"  CASE " +
				"    WHEN TO_CHAR(tos.dresultadoentrega,'D' )='1' " +
				"    THEN '12hrs a 13hrs' " +
				"    WHEN TO_CHAR(tos.dresultadoentrega,'D' )='7' " +
				"    THEN '12hrs a 13hrs' " +
				"    ELSE '17hrs a 18hrs' " +
				"  END) resultado, " +
				"  tos.cestadoregistro, " +
				"  NVL(trim(tos.spassword),' ') serviciointernet, " +
				"  tos.sentregaresultadosa " +
				"FROM t_orden_sucursal tos " +
				"INNER JOIN c_medico cm " +
				"ON tos.cmedico=cm.cmedico " +
				"INNER JOIN c_convenio ccon " +
				"ON tos.cconvenio        =ccon.cconvenio " +
				"AND ccon.ctipoconvenio IN (22) " +
				"AND tos.mpagopaciente   = 0 " +
				"INNER JOIN c_sucursal cs " +
				"ON cs.csucursal = tos.csucursal " +
				"INNER JOIN c_codigo_postal cc " +
				"ON cc.ccodigopostal = cs.ccodigopostal " +
				"INNER JOIN t_paciente tp " +
				"ON tp.kpaciente = tos.kpaciente " +
				"INNER JOIN c_estado_registro cer " +
				"ON tos.cestadoregistro = cer.cestadoregistro " +
				"LEFT OUTER JOIN c_sucursal cs2 " +
				"ON tos.csucursalentrega = cs2.csucursal " +
				"LEFT OUTER JOIN c_codigo_postal ccp " +
				"ON ccp.ccodigopostal = tp.ccodigopostal " +
				"LEFT JOIN turbine_user tuser " +
				"ON tos.user_id = tuser.user_id " +
				"LEFT JOIN t_pago_paciente tpp " +
				"ON tos.kordensucursal   = tpp.kordensucursal " +
				"WHERE tos.kordensucursal in (" + kOrdenSucursal + ") " +
				"AND tpp.kpagopaciente  IS NULL";
	}
	
	private String SQLFOPExamenes(int kOrdenSucursal) {
		return "SELECT 0, " +
				"  TO_CHAR(toes.uvolumenexamen) " +
				"  || ' --> ' " +
				"  || TO_CHAR(toes.cexamen) cexamen, " +
				"  NVL(toes.sexamen,' ') sexamen, " +
				"  NVL(toes.miva,0) msubtotale, " +
				"  NVL(toes.mpagopaciente,0) mfactura, " +
				"  '' ssucursalentrega " +
				"FROM t_orden_sucursal tos " +
				"INNER JOIN t_orden_examen_sucursal toes " +
				"ON tos.kordensucursal = toes.kordensucursal " +
				"AND toes.cperfil      <0 " +
//				"INNER JOIN c_sucursal cs " +
//				"ON cs.csucursal        =toes.csucursalentregaresultado " +
				"AND tos.kordensucursal =" + kOrdenSucursal + " " +
				"UNION ALL " +
				"SELECT DISTINCT (cp.cperfil), " +
				"  '1 --> ' " +
				"  || TO_CHAR(cp.cperfil) cexamen, " +
				"  NVL(cp.sperfil,' ') sexamen, " +
				"  NVL(SUM(toes.miva),0) msubtotale, " +
				"  NVL(SUM(toes.mpagopaciente),0) mfactura, " +
				"  '' ssucursalentrega " +
				"FROM t_orden_sucursal tos " +
				"INNER JOIN t_orden_examen_sucursal toes " +
				"ON tos.kordensucursal  = toes.kordensucursal " +
				"AND tos.kordensucursal in (" + kOrdenSucursal + ") " +
				"INNER JOIN c_perfil cp " +
				"ON toes.cperfil=cp.cperfil " +
				"AND cp.cperfil > 0 " +
				"GROUP BY cp.cperfil, " +
				"  cp.sperfil";
	}
}
