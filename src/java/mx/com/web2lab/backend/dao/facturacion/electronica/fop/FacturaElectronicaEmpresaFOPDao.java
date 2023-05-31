package mx.com.web2lab.backend.dao.facturacion.electronica.fop;

import java.text.DecimalFormat;

import mx.com.web2lab.backend.beans.facturacion.DatosFiscalesBean;
import mx.com.web2lab.backend.beans.facturacion.electronica.BodyFacturaElectronicaBean;
import mx.com.web2lab.backend.beans.facturacion.electronica.FacturaElectronicaBean;
import mx.com.web2lab.backend.dao.facturacion.tool.DatosFiscalesDao;
import mx.com.web2lab.backend.hbm.ConfiguracionProperties;
import mx.com.web2lab.backend.util.ConvierteNumeros;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class FacturaElectronicaEmpresaFOPDao {
	
	private static Log iObjLog = LogFactory.getLog(FacturaElectronicaEmpresaFOPDao.class);	

    public String createFactura(FacturaElectronicaBean objFactura) throws Exception{
 		iObjLog.debug("Entrando FacturaElectronicaFOPDao.createFactura..... " + objFactura.toString());    	
        String strFileFop="";
        String strRows = "";
        String strMoneda = "MXP";
        String sHttpQRPath = "";
        String strLogoFactura = "";
        String strRFC = "";
        String strDebemos = "";
        DatosFiscalesDao objDatosFiscalesDao = new DatosFiscalesDao();
        DatosFiscalesBean objDatosFiscalesBean = null;
        String sHttpPath = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenes");
        if (objFactura.getCmarca() == 1) {
	        sHttpQRPath = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenesqr_Olab");
        } else if (objFactura.getCmarca() == 4) {
            sHttpQRPath = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenesqr_Azteca");
        }  else if (objFactura.getCmarca() == 5 || objFactura.getCmarca() == 15) {
            sHttpQRPath = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenesqr_Swisslab");
        }  else if (objFactura.getCmarca() == 7) {
        	if(objFactura.getSserie().equals("AJP")){
        		sHttpQRPath = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenesqr_JennerPrado");
        	}else if(objFactura.getSserie().equals("AJL")){
        		sHttpQRPath = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenesqr_JennerLean");
        	}
        } else if (objFactura.getCmarca() == 19){
        	 sHttpQRPath = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenesqr_FamilyLabs");
        } else if (objFactura.getCmarca() == 20){
       	 sHttpQRPath = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenesqr_Exakta");
       }
        
        if (objFactura.getCmarca() == 1) {
        	strLogoFactura = "OlabSmall.jpg";
        	strRFC = "RFCTJOriardFactura.jpg";
        	strDebemos = "DEBO(EMOS) Y PAGARE(MOS) INCODICIONALMENTE A LA ORDEN DE ESTUDIOS CLINICOS TJ ORIARD,S.A. DE C.V. EN DONDE SE ME REQUIERA A LA VISTA LA CANTIDAD DE $";
        } else if(objFactura.getCmarca() == 5 || objFactura.getCmarca() == 15){
        	strLogoFactura = "AztecaSmall.jpg";
        	strRFC = "RFCTAztecaFactura.jpg";
        	strDebemos = "DEBO(EMOS) Y PAGARE(MOS) INCODICIONALMENTE A LA ORDEN DE LABORATORIO QUIMICO CLINICO AZTECA S.A.P.I. DE C.V. EN DONDE SE ME REQUIERA A LA VISTA LA CANTIDAD DE $";
        } else if(objFactura.getCmarca() == 4){
        	strLogoFactura = "AztecaSmall.jpg";
        	strRFC = "RFCTAztecaFactura.jpg";
        	strDebemos = "DEBO(EMOS) Y PAGARE(MOS) INCODICIONALMENTE A LA ORDEN DE LABORATORIO QUIMICO CLINICO AZTECA S.A.P.I. DE C.V. EN DONDE SE ME REQUIERA A LA VISTA LA CANTIDAD DE $";
        } else if(objFactura.getCmarca() == 7){
        	strLogoFactura = "AztecaSmall.jpg";
        	strRFC = "RFCTAztecaFactura.jpg";
        	strDebemos = "DEBO(EMOS) Y PAGARE(MOS) INCODICIONALMENTE A LA ORDEN DE LABORATORIO QUIMICO CLINICO AZTECA S.A.P.I. DE C.V. EN DONDE SE ME REQUIERA A LA VISTA LA CANTIDAD DE $";
        } else if(objFactura.getCmarca() == 19){
        	strLogoFactura = "FamilyLabsSmall.jpg";
        	strRFC = "RFCTFamilyLabsFactura.jpg";
        	strDebemos = "DEBO(EMOS) Y PAGARE(MOS) INCODICIONALMENTE A LA ORDEN DE FAMILYLABS EN DONDE SE ME REQUIERA A LA VISTA LA CANTIDAD DE $";
        } else if(objFactura.getCmarca() == 20){
        	strLogoFactura = "ExaktaSmall.jpg";
        	strRFC = "RFCTExaktaFactura.jpg";
        	strDebemos = "DEBO(EMOS) Y PAGARE(MOS) INCODICIONALMENTE A LA ORDEN DE EXAKTA EN DONDE SE ME REQUIERA A LA VISTA LA CANTIDAD DE $";
        }
        
        
        BodyFacturaElectronicaBean objBody = null;        
		try
        {
			for(int inti = 0;inti < objFactura.sizeBodys();inti++) {		
				objBody = objFactura.getBody(inti);
				if (objBody.getIntCantidad() == 0) {
					strRows +=  "<fo:table-row>																				\n" +     			
								"        <fo:table-cell  padding='1pt'>      												\n" +
								"        	<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>  	    \n" + 
												objBody.getStrCodigo() 															+ 
								"			</fo:block>    																	\n" + 		
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>      												\n" +
								"        	<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												"  "	 																		+ 
								"			</fo:block>    																	\n" + 										
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>      												\n" +
								"        	<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												"  "	 																		+ 
								"			</fo:block>    																	\n" + 										
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>														\n" +
								"        	<fo:block text-align='left' font-family='sans-serif' font-size='7pt'>			\n" + 
												objBody.getStrDescripcion() 													+ 
								"			</fo:block>    																	\n" + 										
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>														\n" +
								"        	<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" +
												"	"						 													+ 
								"			</fo:block>    																	\n" + 										
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>      												\n" +	
								"        	<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"   "																			+ 
								"			</fo:block>    																	\n" + 		
								"        </fo:table-cell>     																\n" +
								"</fo:table-row>     																		\n";
				} else {					
					strRows +=  "<fo:table-row>																				\n" +     			
								"        <fo:table-cell  padding='1pt'>      												\n" +
								"        	<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>  	    \n" + 
												objBody.getStrCodigo() 															+ 
								"			</fo:block>    																	\n" + 		
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>      												\n" +
								"        	<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												objBody.getIntCantidad() 														+ 
								"			</fo:block>    																	\n" + 										
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>      												\n" +
								"        	<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												"NO APLICA" 																	+ 
								"			</fo:block>    																	\n" + 										
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>														\n" +
								"        	<fo:block text-align='left' font-family='sans-serif' font-size='7pt'>			\n" + 
												objBody.getStrDescripcion()														+ 
								"			</fo:block>    																	\n" + 										
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>														\n" +
								"        	<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" +
								"	$"	+		new DecimalFormat("###,###.00").format(objBody.getDblValorUnitario()) 													+ 
								"			</fo:block>    																	\n" + 										
								"        </fo:table-cell>     																\n" +	
								"        <fo:table-cell padding='1pt'>      												\n" +	
								"        	<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
								"	$"	+		new DecimalFormat("###,###.00").format(objBody.getDblImporte())															+ 
								"			</fo:block>    																	\n" + 		
								"        </fo:table-cell>     																\n" +
								"</fo:table-row>     																		\n";
				}
			}
			
		        
				String strTipoCuentaPago = "";
				String strDigitos = "";
				
		        objDatosFiscalesBean = objDatosFiscalesDao.buscarDatosFiscalesConvenio(objFactura.getCconvenio());
		        if (objFactura.getcTipoPago() == 0) {
			        if (objDatosFiscalesBean != null) {
						strTipoCuentaPago = "METODO DE PAGO: " + objDatosFiscalesBean.getStipopago().trim() + "";
						if (objDatosFiscalesBean.getSdigitoscuenta().trim() != "") {
							strDigitos = " NUMERO CUENTA PAGO: " + objDatosFiscalesBean.getSdigitoscuenta().trim() + "";
						}
			        } else {
						strTipoCuentaPago = "METODO DE PAGO: 99";
			        }
		        } else {
					strTipoCuentaPago = "METODO DE PAGO: " + objFactura.getsTipoPago().trim();
		        	if (objFactura.getsUltimosDigitos().trim() != "") {
						strDigitos = " NUMERO CUENTA PAGO: " + objFactura.getsUltimosDigitos().trim();
		        	}
		        }							        	
		        		        
		        if((objFactura.getCconvenio() == 850) ||(objFactura.getCconvenio() == 392)||(objFactura.getCconvenio() == 948)){
		        	strMoneda = "MXN";
		        }
				strFileFop ="<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
						    "<fo:root xmlns:fo=\"http://www.w3.org/1999/XSL/Format\">																															\n" +
						    "  <fo:layout-master-set>																																							\n" +
						    "    <fo:simple-page-master master-name=\"my-page\">																																\n" +
						    "      <fo:region-body margin=\"1in\" />																																			\n" +
						    "    </fo:simple-page-master>																																						\n" +
						    "  </fo:layout-master-set>																																							\n" +
						    "<fo:page-sequence master-name=\"my-page\" master-reference=\"my-page\"> 																											\n" +  
							"	<fo:flow flow-name='xsl-region-body'> 																																			\n" +
							"      <fo:block-container height='4cm' width='14cm' top='-1cm' left='4cm' position='absolute'> 																					\n" +  
							"       	<fo:block text-align='start' line-height='18pt' font-family='Times' font-weight='bold' font-size='6pt'> 																\n" +  
							"                         	Este documento es una representacion impresa de un CFDI																				\n" +  
							"		    </fo:block> 																																							\n" +
							"      </fo:block-container> 																																						\n" +  									
							"      <fo:block-container height='3cm' width='4.5cm' top='0cm' left='11.2cm' position='absolute'> 																					\n" +  
							"	      <fo:block> 																																								\n" +  
							"	         <fo:external-graphic width='180pt' height='100pt' content-width='150pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + strLogoFactura + "' /> 			\n" +  
							"	      </fo:block> 																																								\n" +  
							"      </fo:block-container> 																																						\n" +  	
							"      <fo:block-container height='4cm' width='6.5cm' top='0.2cm' left='4cm' position='absolute'> \n" +
							"      		<fo:block text-align='center' line-height='8.9pt' font-family='Currier new' font-size='5pt'>" +  
												objFactura.getSrazonsocialemisor()+" "+objFactura.getSrfcemisor()+
							"			</fo:block> \n" +  
							"      		<fo:block text-align='center' line-height='8.9pt' font-family='Currier new' font-size='5pt'> \n" +  
												objFactura.getScalleemisor()+" "+objFactura.getScoloniaemisor()+" "+objFactura.getScodigopostalemisor()+
							" "					+objFactura.getSciudademisor()+" "+objFactura.getSmunicipioemisor()+", "+objFactura.getSpaisreceptor()+
							"			</fo:block> \n" + 
							"			<fo:block text-align='center' space-after.optimum='1pt' line-height='8.9pt' font-family='Times' font-size='5pt'> \n " +  
				            "                                                COMPROBANTE EMITIDO EN:"+objFactura.getScallesuc()+" "+objFactura.getScoloniasuc()+" "+objFactura.getScodigopostalsuc()+" "+objFactura.getSciudadsuc()+" , MEXICO" +  
				            "           </fo:block> \n " +
							"			<fo:block text-align='center' space-after.optimum='1pt' line-height='8.9pt' font-family='Times' font-size='4.5pt'> \n " +  
				            "                                                REGIMEN FISCAL: REGIMEN GENERAL DE LEY PERSONAS MORALES" +  
				            "           </fo:block> \n " +
							"			<fo:block text-align='center' space-after.optimum='1pt' line-height='8.9pt' font-family='Times' font-size='6pt'> \n " +  
				            "                                                FOLIO FISCAL " + objFactura.getCFDIUUID() +  
				            "           </fo:block> \n " +
							"      </fo:block-container> \n" +  
							"	  <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='2cm' top='0cm' left='-1cm' padding='1.5pt' position='absolute'> \n" +  
							"	      	<fo:block text-align='center' space-after.optimum='3pt' line-height='15pt' font-family='Times' font-size='6pt' font-weight='bold'> \n" +  
							"							FACTURA \n" +  
							"			</fo:block> \n" +  
							"	  </fo:block-container> \n" +  
							"	  <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='2cm' top='0cm' left='1.16cm' padding='1.5pt' position='absolute'>  \n" + 
							"      		<fo:block text-align='center' space-after.optimum='3pt' color='black' line-height='15pt' font-family='Times' font-size='6pt' font-weight='bold'>   \n" +
							"						" + objFactura.getSseriofoliocompleto() + " \n" +
							"			</fo:block>   \n" +
							"      </fo:block-container>   \n" +
							"      <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='2cm' top='0.48cm' left='-1cm' padding='1.5pt' position='absolute'>  \n" + 
							"           <fo:block text-align='center' space-after.optimum='3pt' line-height='15pt' font-family='Times' font-size='6pt' font-weight='bold'>   \n" +
							"           					FECHA  \n" +
							"           </fo:block>   \n" +
							"      </fo:block-container>  \n" +
							"      <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='2cm' top='0.48cm' left='1.16cm' padding='1.5pt' position='absolute'>  \n" + 
							"           <fo:block text-align='center' line-height='15pt' font-family='Times' font-size='5.5pt' font-weight='bold'>   \n" +
							"							" + objFactura.getFecha() + " \n" +
							"           </fo:block>   \n" +
							"      </fo:block-container>  \n" +
							"      <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='4.15cm' top='0.99cm' left='-1cm' padding='1.5pt' position='absolute'>  \n" + 
							"           <fo:block text-align='center' space-after.optimum='3pt' line-height='15pt' font-family='Times' font-size='6pt' font-weight='bold'>   \n" +
							"           					FECHA Y HORA DE CERTIFICACION  \n" +
							"           </fo:block>   \n" +
							"      </fo:block-container>  \n" +
							"      <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.35cm' width='4.15cm' top='1.46cm' left='-1cm' padding='1.5pt' position='absolute'>  \n" + 
							"           <fo:block text-align='center' space-after.optimum='3pt' line-height='15pt' font-family='Times' font-size='6pt' font-weight='bold'>   \n" +
							"							" + objFactura.getCFDIFechaTimbrado() + " \n" +
							"           </fo:block>   \n" +
							"      </fo:block-container>  \n" +
							"      <fo:block-container border-color='white' border-style='solid' border-width='0.65pt' height='0.35cm' width='2cm' top='1.92cm' left='-1cm' padding='1.5pt' position='absolute'>  \n" + 
							"           <fo:block text-align='center' line-height='15pt' font-family='Times' font-size='6pt' font-weight='bold'>   \n" +
//							"           					CERTIFICADO  \n" +
							"           </fo:block>   \n" +
							"      </fo:block-container>  \n" +
							"      <fo:block-container border-color='white' border-style='solid' border-width='0.65pt' height='0.35cm' width='2cm' top='1.92cm' left='1.16cm' padding='1.5pt' position='absolute'>  \n" + 
							"           <fo:block text-align='center' line-height='15pt' font-family='Times' font-size='6pt' font-weight='bold'>   \n" +
//							"							" + objFactura.getSncertificado() + " \n" +
							"           </fo:block>   \n" +
							"      </fo:block-container>  \n" +
							"      <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.55cm' width='18.5cm' top='2.7cm' left='-1cm' padding='2pt' position='absolute'>   \n" +
							"           <fo:block text-align='left' line-height='15pt' font-family='Times' font-size='7.3pt' font-weight='bold'>   \n" +
							"                           DATOS DEL CLIENTE   \n" +
							"           </fo:block>   \n" +
							"      </fo:block-container>   \n" +
							"      <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='1.7cm' width='18.5cm' top='3.45cm' left='-1cm' padding='2pt' position='absolute'>   \n" +
			//				"      		<fo:block text-align='star' font-size='8pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'>   \n" +
							"      		<fo:block text-align='star' font-size='7.3pt' space-before.optimum='0pt' white-space-collapse='false' linefeed-treatment='preserve'>   \n" +
			//				"                          " + objFactura.getSDatosFiscales() + "  \n" + 
							"                          <![CDATA[" +objFactura.getSrazonsocialreceptor() +"\n"+
							" "+objFactura.getScallereceptor()+" "+"COL."+objFactura.getScoloniareceptor()+"\n C.P."+objFactura.getScodigopostalreceptor()+" "+objFactura.getSciudadreceptor()+" "+objFactura.getSmunicipioreceptor()+", "+objFactura.getSpaisreceptor()+"\n RFC."+objFactura.getSrfcreceptor()+
							" Cliente:"+   objFactura.getSclientecompleto() + "]]> \n" + 
							"           </fo:block>   \n" +
							"      </fo:block-container>  \n" +
							"      <fo:block-container border-color='black' border-style='solid' border-width='0.67pt' height='9.75cm' width='18.45cm' top='5.88cm' left='-0.92cm' position='absolute' padding='2pt'>   \n" +
							"                <fo:block text-align='center' space-after.optimum='3pt' line-height='15pt' font-family='Times' font-size='7pt'> " + 
				            "                               " + 
				            "                    </fo:block> " + 
							"      </fo:block-container>     											\n"+
							"      <fo:block-container  height='10cm' width='18.5cm' top='5.5cm' left='-1cm' position='absolute' padding='2pt'>   \n" + 
			//				"			<fo:table border-color='black' border-style='solid' height='17cm' border-width='0.65pt'>   \n" + 
							"			<fo:table height='80cm' left='-1cm'>   \n" + 
							"					<fo:table-column column-width='2cm'  	/>   \n" + 
							"				    <fo:table-column column-width='1.7cm' 	/>   \n" + 
							"				    <fo:table-column column-width='1.7cm' 	/>   \n" + 
							"					<fo:table-column column-width='9.3cm'	/>   \n" + 
							"					<fo:table-column column-width='1.98cm'  />   \n" + 
							"					<fo:table-column column-width='1.9cm'  	/>   \n" + 
							"					<fo:table-header>   \n" + 
							"						<fo:table-cell>   \n" + 
							"							<fo:block border-color='black' border-style='solid' border-width='0.67pt' text-align='center' font-size='6pt' font-weight='bold'>CODIGO</fo:block>   \n" + 
							"                        </fo:table-cell>    \n" +
							"                       <fo:table-cell>    \n" +
							"                    	    <fo:block border-color='black' border-style='solid' border-width='0.67pt' text-align='center' font-size='6pt' font-weight='bold'>CANTIDAD</fo:block>    \n" +
							"                       </fo:table-cell>    \n" +
							"                       <fo:table-cell>    \n" +
							"                    	    <fo:block border-color='black' border-style='solid' border-width='0.67pt' text-align='center' font-size='4.85pt' font-weight='bold'>UNIDAD DE MEDIDA</fo:block>    \n" +
							"                       </fo:table-cell>    \n" +
							"						<fo:table-cell>    \n" +
							"							<fo:block border-color='black' border-style='solid' border-width='0.67pt' text-align='center' font-size='6pt' font-weight='bold'>CONCEPTO</fo:block>    \n" +
							"                       </fo:table-cell>    \n" +
							"						<fo:table-cell>    \n" +
							"							<fo:block border-color='black' border-style='solid' border-width='0.67pt' text-align='center' font-size='6pt' font-weight='bold'>PRECIO UNITARIO</fo:block>    \n" +
							"                       </fo:table-cell>    \n" +
							"						<fo:table-cell>    \n" +
							"							<fo:block border-color='black' border-style='solid' border-width='0.67pt' text-align='center' font-size='6pt' font-weight='bold'>IMPORTE</fo:block>    \n" +
							"                       </fo:table-cell>    \n" +
							"                   </fo:table-header>    \n" +
							"					<fo:table-body   font-family='Times' font-weight='normal' font-size='6pt'>    \n" +
														strRows +	
							"                </fo:table-body>     										\n" +
							"       	</fo:table>     												\n" +
							"	  </fo:block-container>     											\n" +
				        	"            <fo:block-container border-color='black' border-style='solid'  border-width='0.65pt' height='0.4cm' width='14.45cm' top='16cm' left='-1cm' position='absolute'> " + 						        	
				            "                <fo:block text-align='center' space-after.optimum='3pt' line-height='15pt' font-family='Times' font-size='7pt'> " + 
				            "                                OBSERVACIONES " + 
				            "                    </fo:block> " + 
				            "            </fo:block-container> " + 
				            "            <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='2cm' width='14.45cm' top='16cm' left='-1cm' position='absolute'> " + 
				            "            	<fo:block text-align='center' font-size='3pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> " + 
				            "               </fo:block> " + 
				            "            	<fo:block text-align='center' font-size='3pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> " + 
				            "               </fo:block> " + 
				            "               <fo:block text-align='left' space-after.optimum='3pt' line-height='15pt' font-family='Times' font-size='8pt'> " + 
				            					objFactura.getSobservaciones() 	+
				            "               </fo:block> " + 
				            "            </fo:block-container> " + 
				            "            <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.4cm' width='11cm' top='18cm' left='-1cm' position='absolute'> " + 
				            "                <fo:block text-align='center' space-after.optimum='3pt' line-height='15pt' font-family='Times' font-size='7pt'> " + 
				            "                                IMPORTE CON LETRA " + 
				            "                    </fo:block> " + 
				            "            </fo:block-container> " + 
				            "            <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='0.55cm' width='11cm' top='18.45cm' left='-1cm' position='absolute'> " + 
				            "                <fo:block text-align='center' font-size='3pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> " + 
				            "                </fo:block> " + 
				            "                <fo:block text-align='left' space-after.optimum='3pt' line-height='15pt' font-family='Times' font-size='7pt'> " + 
				            					(new ConvierteNumeros(new Double(objFactura.getMtotal())).getNumLetras()).toUpperCase() + 
				            					" PESOS " + 
				            					(new ConvierteNumeros(new Double(objFactura.getMtotal())).getStrNumDec()).toUpperCase() + 
				            					"/100 M.N." + 
				            "                </fo:block> " + 
				            "            </fo:block-container> " +            
				            "			 <fo:block-container height='2cm' width='4cm' top='16cm' left='13.5cm' position='absolute' > " + 
				            "                               <fo:block background-color='#D8D8D8' text-align='left' font-family='Times' font-size='6pt' text-indent='1.5mm'> " + 
                            "                                   Descuento" + 
                            "                               </fo:block> " + 
                            "                               <fo:block text-align='left' font-size='3pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> " + 
                            "                               </fo:block> " + 
                            "                               <fo:block background-color='#D8D8D8' text-align='left' font-family='Times' font-size='6pt' text-indent='1.5mm'> " + 
                            "                                   Subtotal " + 
                            "                               </fo:block> " + "COPAGO TITULO" +
                            "                               <fo:block text-align='left' font-size='3pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> " + 
                            "                               </fo:block> " + 
                            "                               <fo:block background-color='#D8D8D8' text-align='left' font-family='Times' font-size='6pt' text-indent='1.5mm'> " + 
                            "                                   IVA (16%) " + 
                            "                               </fo:block> " + 
                            "                               <fo:block text-align='left' font-size='3pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> " + 
                            "                               </fo:block> " + 
                            "                               <fo:block background-color='#D8D8D8' text-align='left' font-family='Times' font-size='6pt' text-indent='1.5mm'> " + 
                            "                                   Total " + 
                            "                               </fo:block> " +  
				            "            </fo:block-container> " +             						            
				            "			 <fo:block-container border-color='black' border-style='solid' border-width='0.65pt' height='2cm' width='4cm' top='16cm' left='13.5cm' position='absolute' > " + 
				            "                               <fo:block  text-align='right' font-family='Times' font-size='6pt'> " + 
                            "                                   $ " + "0.0" + " " + 
                            "                               </fo:block> " + 
                            "                               <fo:block text-align='right' font-size='3pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> " + 
                            "                               </fo:block> " +
                            "                               <fo:block text-align='right' font-family='Times' font-size='6pt'> " + 
                            "                                   $ " + new DecimalFormat("###,###.00").format(objFactura.getMsubtotal()) + " " +  
                            "                               </fo:block> " + "COPAGO" + 
                            "                               <fo:block text-align='right' font-size='3pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> " + 
                            "                               </fo:block> " +
                            "                               <fo:block text-align='right' font-family='Times' font-size='6pt'> " + 
                            "                                   $ " + new DecimalFormat("###,###.00").format(objFactura.getMiva()) + " " +  
                            "                               </fo:block> " + 
                            "                               <fo:block text-align='right' font-size='3pt' space-before.optimum='5pt' white-space-collapse='false' linefeed-treatment='preserve' white-space-treatment='preserve' wrap-option='no-wrap'> " + 
                            "                               </fo:block> " + 
                            "                               <fo:block text-align='right' font-family='Times' font-size='6pt'> " + 
                            "                                   $ " + new DecimalFormat("###,###.00").format(objFactura.getMtotal()) + " " +  
                            "                               </fo:block> " +  
				            "            </fo:block-container> " + 
				            "      <fo:block-container height='3.5cm' width='3.5cm' top='19cm' left='-1cm' position='absolute'> 																				\n" +  	
							"	      <fo:block  text-align='center'> 				" +
							"	         <fo:external-graphic width='4.1cm' height='4.1cm' content-width='4.1cm' content-height='4.1cm' overflow='hidden' src = '" + sHttpQRPath + "FacturacionElectronica_" +  objFactura.getSseriofoliocompleto() + ".xml.png' /> 			\n" +  
							"	      </fo:block> \n" +  
							"      </fo:block-container> \n" +  			
				            "            <fo:block-container border-width='0pt' height='2cm' width='15cm' top='19cm' left='3cm' padding='0pt' position='absolute'> \n " +		 
				            "            	<fo:block text-align='left'  line-height='8.9pt' font-family='Times' font-size='6pt'> \n " + 															 
				            						strDebemos + ""+   				 
				            "               </fo:block> \n " + 						            
				            "            	<fo:block text-align='left' line-height='8.9pt' font-family='Times' font-size='6pt'> \n " + 															 
				            "                                  ________(_____________________________________________________________)" +																						 
				            "            	</fo:block> \n " +
				            "				<fo:block text-align='left' line-height='8.9pt' font-family='Times' font-size='6pt'> \n " + 															 
				            "                                  DE NO VERIFICARSE EL PAGO DE LA CANTIDAD QUE ESTE PAGARE EXPRESA EL DIA DE SU VENCIMIENTO ABONARE EL _____%" +																						 
				            "            	</fo:block> \n " + 
				            "				<fo:block text-align='left' line-height='8.9pt' font-family='Times' font-size='6pt'> \n " + 															 
				            "                                  MENSUAL POR EL TIEMPO QUE ESTE INSOLUTO SIN PERJUICIO AL COBRO, MAS LOS GASTOS QUE SE ORIGINEN" +																						 
				            "            	</fo:block> \n " +
				            "				<fo:block text-align='rigth' line-height='8.9pt' font-family='Times' font-size='6pt'> \n " + 															 
				            "                                 &#160;" +																						 
				            "            	</fo:block> \n " +
				            "				<fo:block text-align='left' line-height='8.9pt' font-family='Times' font-size='6pt'> \n " + 															 
				            					strTipoCuentaPago + 
				            "            	</fo:block> \n " +
				            "				<fo:block text-align='left' line-height='8.9pt' font-family='Times' font-size='6pt'> \n " + 															 
				            					strDigitos + 
				            "            	</fo:block> \n " +
				            "            </fo:block-container> \n " + 																																								 
				            "            <fo:block-container height='10cm' width='10cm' top='21cm' left='13.5cm' position='absolute'> \n " +
							"	      		<fo:block> 																																							\n" +  
							"	         		<fo:external-graphic width='4cm' height='4.5cm' content-width='4cm' content-height='4.5cm' overflow='hidden' src = '" + sHttpPath + strRFC + "' /> 			\n" +  
							"	      		</fo:block> \n" +  
				            "            </fo:block-container> \n " +  						          						            
				            "            <fo:block-container border-width='0pt' height='2.5cm' width='19cm' top='22cm' left='0cm' padding='1pt' position='absolute'> \n " +  
				            "                        <fo:block text-align='center' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='6pt' font-weight='bold' > \n " +  
				            "                                   _____________________" +
				            "                        </fo:block> \n " +  
				            "                        <fo:block text-align='center' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='6pt' font-weight='bold' > \n " +  
				            "                                   FIRMA" +
				            "                        </fo:block> \n " +  
				            "                        <fo:block text-align='center' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='6pt' font-weight='bold' > \n " +  
				            "                                                FORMA DE PAGO: PAGO EN UNA SOLA EXHIBICI&#211;N" +    
				            "                        </fo:block> \n " +  
				            "                        <fo:block text-align='center' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='6pt' font-weight='bold' > \n " +  
				            "                                                MONEDA: " + strMoneda +    
				            "                        </fo:block> \n " +  
				            "                        <fo:block text-align='center' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='6pt' font-weight='bold' > \n " +  
				            "                                                EFECTOS FISCALES AL PAGO \n " +    
				            "                        </fo:block> \n " +  
				            "                        <fo:block text-align='center' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='6pt'> \n " +  
				            "                                                LA REPRODUCCION NO AUTORIZADA DE ESTE COMPROBANTE CONSTITUYE UN DELITO EN LOS TERMINOS DE LAS DISPOSICIONES FISCALES \n " +  
				            "                        </fo:block> \n " +                 
				            "            </fo:block-container> \n " +
				            "            <fo:block-container border-width='0pt' height='2.5cm' width='19cm' top='23.7cm' left='-1cm' padding='1pt' position='absolute'> \n " +  
				            "            			 <fo:block text-align='left' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='5pt'> \n " +  
				            "                                                CADENA ORIGINAL DEL COMPLEMENTO DE CERTIFICACION DIGITAL SAT: ||1.0|" + objFactura.getCFDIUUID() + "|" + objFactura.getCFDIFechaTimbrado() + "|" + objFactura.getCFDIselloCFD() + "|" + objFactura.getCFDInoCertificadoSAT() +"||  " +
				            "            			 </fo:block> \n " +             
				            "            			 <fo:block text-align='left' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='5pt'> \n " +  
				            "                                                SELLO DEL SAT: " +objFactura.getCFDIselloSAT() +  
				            "            			 </fo:block> \n " +             
				            "            			 <fo:block text-align='left' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='5pt'> \n " +  
				            "                                                SELLO DIGITAL: "+ objFactura.getSsellodigital()+" \n " +  
				            "            			 </fo:block> \n " +             
				            "            			 <fo:block text-align='left' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='5pt'> \n " +  
				            "                                                NO CERTIFICADO DEL SAT: "+ objFactura.getCFDInoCertificadoSAT()+" \n " +  
				            "            			 </fo:block> \n " +             
				            "            			 <fo:block text-align='left' space-after.optimum='1pt' line-height='7pt' font-family='Times' font-size='5pt'> \n " +  
				            "                                                NO CERTIFICADO DEL CSD: "+ objFactura.getSncertificado()+" \n " +  
				            "            			 </fo:block> \n " +             
				            "            </fo:block-container> \n " +
				            "        </fo:flow> \n " + 
				            "    </fo:page-sequence> \n "+
				            "</fo:root>";	
	    		iObjLog.debug("Saliendo FacturaElectronicaFOPDao.createFactura:... " + strFileFop);			    
        } catch(Exception aErrorException) {
	 		iObjLog.error("ERROR FacturaElectronicaFOPDao.createXML", aErrorException);
	 		throw aErrorException;
        } 
        return strFileFop;
    }    
}
