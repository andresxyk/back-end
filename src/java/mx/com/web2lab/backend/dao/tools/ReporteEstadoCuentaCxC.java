package mx.com.web2lab.backend.dao.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.hbm.ConfiguracionProperties;
import mx.com.web2lab.backend.hbm.om.reportes.TAntiguedadCxc;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import mx.com.web2lab.backend.util.formatos.Formatos;

public class ReporteEstadoCuentaCxC {

  /*******************************Reporte Estado de Cuenta CxC **************************************************/
  private double dblTotalFactura = 0.0;
  private double dblSaldoActual = 0.0;		
  private double dblTotalPagado = 0.0;
  private double dblTotalSaldo = 0.0;
  private double dblTotalDentroPlazo= 0.0;
  private double dblTotal30= 0.0;
  private double dblTotal60= 0.0;
  private double dblTotal90= 0.0;
  private double dblTotal120= 0.0;
  private double dblTotal180= 0.0;
  private double dblTotal360= 0.0;
  private double dblMas361= 0.0;		
//  private List lstRowReporteCxC360 = new ArrayList();
  private List lstRowReporteCxC90 = new ArrayList();
  private int consRowsxPage = 45;
  private java.lang.Integer cconvenio;
  private java.lang.String sconvenio;
  private int ccliente;
  private String scliente;
  private String srfc;
  private String sdireccion;
  private List lstFacturas = new ArrayList();	
  private String sHttpPath = ConfiguracionProperties.getPropiedad("reporte.ruta.imagenes");
  private FormateaFecha objFormatearDate = new FormateaFecha();
  private Formatos objFormatos =  new Formatos();  
  private double dblNoFacturado;
  /*******************************Reporte Estado de Cuenta CxC **************************************************/
		
    public ReporteEstadoCuentaCxC(double dblNoFacturado,List lstFacturas)
    {
    	this.dblNoFacturado = dblNoFacturado;
    	this.lstFacturas = lstFacturas;
    }
    
    private String headerPage() {
		String strHeader = "";
		strHeader = "<fo:page-sequence  master-name=\"detalle\" master-reference=\"detalle\">"+" \n"+
						" <fo:static-content flow-name=\"xsl-region-before\">"+
						"      <fo:block-container  height='15cm' width='9cm' top='-1.15cm' left='4cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"			<fo:block font-size=\"13pt\" text-align=\"center\" font-weight=\"bold\" color=\"rgb(255,165,0 )\">"+" \n"+
						" 				Reporte Cuentas por Cobrar"+"\n"+
						"			</fo:block>"+"\n"+
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container  height='15cm' width='6cm' top='-1.19cm' left='14.5cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +
						"			<fo:block font-size=\"9pt\" text-align=\"center\" >"+" \n"+
						" 				P&#225;gina: <fo:page-number/>"+"\n"+
						"			</fo:block>"+"\n"+
						"      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
						"      <fo:block-container height='3cm' width='3cm' top='0.4cm' left='-2.2cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
		                "                       <fo:external-graphic width='588pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
		                "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='3cm' top='2.84cm' left='-2.2cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "                    <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
		                "                       <fo:external-graphic width='588pt' height='100pt' content-width='800pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "Line2.jpg' />                                      \n" +  
		                "                    </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +  
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +     	                        
		                "      <fo:block-container height='3cm' width='4.5cm' top='-1.9cm' left='-1.5cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "            <fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       \n" +  
		                "                <fo:external-graphic width='180pt' height='100pt' content-width='150pt' content-height='150pt' overflow='hidden' src = '" + sHttpPath + "OlabSmall.jpg' />                                      \n" +  
		                "            </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='4.5cm' top='0.7cm' left='-2.2cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" font-weight=\"bold\">"+" \n"+  
		                "                CLIENTE:                                      \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='4.5cm' top='1cm' left='-2.2cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" font-weight=\"bold\">"+" \n"+  
		                "                    RFC:                                      \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='4.5cm' top='1.28cm' left='-2.2cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" font-weight=\"bold\">"+" \n"+  
		                "                    DIRECCION:                                      \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='8cm' top='0.1cm' left='12.5cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" font-weight=\"bold\">"+" \n"+  
		                "                FECHA DE IMPRESI&#211;N: "+      objFormatearDate.getFecha(new Date()) + "   \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +	                       
		                "      <fo:block-container height='3cm' width='4.5cm' top='1.78cm' left='-2.2cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" font-weight=\"bold\">"+" \n"+  
		                "                CONVENIO:                                      \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='4.5cm' top='2.06cm' left='-2.2cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" font-weight=\"bold\">"+" \n"+  
		                "                SALDO FACTURADO:  		                                    \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='4.5cm' top='2.34cm' left='-2.2cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" font-weight=\"bold\">"+" \n"+  
		                "                VENDIDO NO FACTURADO:                                    \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='4.5cm' top='2.62cm' left='-2.2cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" font-weight=\"bold\">"+" \n"+  
		                "                SALDO TOTAL:     		                                 \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='23cm' top='0.7cm' left='1.3cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" >"+" \n"+  
		                "                " + this.getCcliente() + " - " +  this.getScliente() + "                                      \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='23cm' top='1cm' left='1.3cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" >"+" \n"+  
		                "                " + this.getSrfc()  +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='23cm' top='1.28cm' left='1.3cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" >"+" \n"+  
		                "                " + this.getSdireccion()  +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container height='3cm' width='23cm' top='1.78cm' left='1.3cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"left\" >"+" \n"+  
		                "                " + this.getCconvenio() + " - " + this.getSconvenio() + "    \n" +  
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container  border-width='0.65pt' height='0.29cm' width='1.3cm' top='2.06cm' left='2.4cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"right\" >"+" \n"+  
		                				"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotalFactura))) + 
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container  border-width='0.65pt' height='0.29cm' width='1.3cm' top='2.34cm' left='2.4cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"right\" >"+" \n"+  
		                				"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblNoFacturado))) + 
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                "      <fo:block-container  border-width='0.65pt' height='0.29cm' width='1.3cm' top='2.62cm' left='2.4cm' position='absolute'>                                                                                                                                                                                                                                                                                                \n" +  
		                "           <fo:block font-size=\"7.5pt\" text-align=\"right\" >"+" \n"+  
		                				"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblNoFacturado + this.dblTotalSaldo))) + 
		                "           </fo:block>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     \n" +
		                "      </fo:block-container>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \n" +
		                " </fo:static-content> \n";
		return strHeader;
	}

	private String footerPage() {
		return "</fo:page-sequence> \n ";
	}

	private String totalesFile90() {
		String strRowsTable = "";
		strRowsTable =	"				<fo:table-row>																				\n" +     			
						"        				<fo:table-cell  padding='1pt'>      												\n" +
						"        					<fo:block text-align='center' font-family='sans-serif' font-size='6pt'>  	    \n" + 
														" " 													+
						"							</fo:block>    																	\n" + 		
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='left' font-family='sans-serif' font-size='6pt'>			\n" + 
														" " 													+ 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='center' font-weight='bold' font-family='sans-serif' font-size='6pt'>			\n" + 
														" " 													+ 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														" " 													+ 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														"TOTALES " 													+ 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotalFactura))) + 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotalPagado))) +
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotalSaldo))) + 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotalDentroPlazo))) + 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal30))) + 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal60))) + 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal90))) + 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"        				<fo:table-cell padding='1pt'>      												\n" +
						"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
														"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal120 + this.dblTotal180 + this.dblTotal360 + this.dblMas361))) + 
						"							</fo:block>    																	\n" + 										
						"        				</fo:table-cell>     																\n" +	
						"				</fo:table-row>     																		\n";		
		return strRowsTable;
	}

	public void LoadTotales() {
		TAntiguedadCxc objTAntiguedadCxcHB = null;
		for(int i=0;i<this.getLstFacturas().size();i++) {
			objTAntiguedadCxcHB = (TAntiguedadCxc)this.getLstFacturas().get(i);						
			this.dblTotalFactura 		= this.dblTotalFactura 		+ objTAntiguedadCxcHB.getMtotalfactura().doubleValue();						
			this.dblTotalPagado 		= (this.dblTotalPagado 		+ objTAntiguedadCxcHB.getMpagado().doubleValue());
			this.dblTotalSaldo 			= (this.dblTotalSaldo 		+ objTAntiguedadCxcHB.getMsaldo().doubleValue());						
			this.dblSaldoActual 		= (this.dblSaldoActual 		+ objTAntiguedadCxcHB.getMsaldo().doubleValue());						
			this.dblTotalDentroPlazo 	= this.dblTotalDentroPlazo 	+ objTAntiguedadCxcHB.getMdentroplazo().doubleValue();										
			this.dblTotal30 			= this.dblTotal30 			+ objTAntiguedadCxcHB.getM01a30().doubleValue();
			this.dblTotal60 			= this.dblTotal60 			+ objTAntiguedadCxcHB.getM31a60().doubleValue();
			this.dblTotal90 			= this.dblTotal90 			+ objTAntiguedadCxcHB.getM61a90().doubleValue();
			this.dblTotal120 			= this.dblTotal120 			+ objTAntiguedadCxcHB.getM91a120().doubleValue();
			this.dblTotal180 			= this.dblTotal180 			+ objTAntiguedadCxcHB.getM121a180().doubleValue();
			this.dblTotal360 			= this.dblTotal360 			+ objTAntiguedadCxcHB.getM181a360().doubleValue();
			this.dblMas361 		    	= this.dblMas361 			+ objTAntiguedadCxcHB.getMmas361().doubleValue();			
//			String strRowsTable360 = objTAntiguedadCxcHB.getrowTableFOP360(objFormatearDate, objFormatos, sHttpPath);
//			this.lstRowReporteCxC360.add(strRowsTable360);
			String strRowsTable90 = objTAntiguedadCxcHB.getrowTableFOP90(objFormatearDate, objFormatos, sHttpPath);
			this.lstRowReporteCxC90.add(strRowsTable90);
		}
//		this.lstRowReporteCxC360.add(this.totalesFile360(objFormatos));
		this.lstRowReporteCxC90.add(this.totalesFile90());
	}
	
	private double redodedoDouble(double nD) {
		return Math.round(nD*Math.pow(10,2))/Math.pow(10,2);      	
    }
	
	public List getLstRowReporteCxC90() {
		return lstRowReporteCxC90;
	}
	
	/*
	 * BY Incidencia doble hoja 20052013
	 */
	/*
	private String getPagesReporteCxC90() {
		String strReturn = "";
		String strRowsPage = "";
		int inty = 0;
		if (this.lstRowReporteCxC90.size() < this.consRowsxPage) {
			this.consRowsxPage = this.lstRowReporteCxC90.size();
		}
		for (int inti=0;inti < this.lstRowReporteCxC90.size();inti++) {
			if ((inty + 1) >= this.consRowsxPage) {
				strRowsPage += (String)this.lstRowReporteCxC90.get(inti);				
				strReturn += this.headerPage() + this.getTablePageReporteCxC90(strRowsPage) + this.footerPage();
				inty = 0;
				strRowsPage = "";
			}
			strRowsPage += (String)this.lstRowReporteCxC90.get(inti);				
			inty++;
		}
		if (strRowsPage.trim().length() > 0) {
			strReturn += this.headerPage() + this.getTablePageReporteCxC90(strRowsPage) + this.footerPage();
		}
		return strReturn;
	}
	
*/
	private String getPagesReporteCxC90() {
		String strReturn = "";
		String strRowsPage = "";
		int inty = 0;
		
		if (this.lstRowReporteCxC90.size() < this.consRowsxPage) {
			this.consRowsxPage = this.lstRowReporteCxC90.size();
		}
		
		for (int inti=0;inti < this.lstRowReporteCxC90.size();inti++) {
			if ((inty + 1) >= this.consRowsxPage) {
				strRowsPage += (String)this.lstRowReporteCxC90.get(inti);
				strReturn += this.headerPage() + this.getTablePageReporteCxC90(strRowsPage) + this.footerPage();
				inty = 0;
				strRowsPage = "";
			} else {
				strRowsPage += (String)this.lstRowReporteCxC90.get(inti);				
				inty++;
			}
		}
		
		if (strRowsPage.trim().length() > 0) {
			strReturn += this.headerPage() + this.getTablePageReporteCxC90(strRowsPage) + this.footerPage();
//			strReturn += this.getTablePageReporteCxC90(strRowsPage) + this.footerPage();			
		}
		return strReturn;
	}
	
	/*
	 * BY Incidencia doble hoja 20052013
	 */
	/*

	private String getTablePageReporteCxC90(String strRows) {
		return 	" <fo:flow flow-name=\"xsl-region-body\">"+ "\n"+
				"      <fo:block-container  height='27cm' width='27cm' top='0.5cm' left='-2.2cm' position='absolute' padding='1pt'>   \n" +  
				"			<fo:table  left='-0.4cm'>   \n" + 
				"					<fo:table-column column-width='1.0cm'  	/>   \n" + 
				"				    <fo:table-column column-width='1.8cm'  	/>   \n" + 
				"					<fo:table-column column-width='1.3cm'	/>   \n" +
				"					<fo:table-column column-width='1.3cm'	/>   \n" +
				"					<fo:table-column column-width='0.8cm'	/>   \n" +
				"					<fo:table-column column-width='1.75cm'  />   \n" + 
				"					<fo:table-column column-width='1.75cm'  />   \n" + 
				"					<fo:table-column column-width='1.75cm'  />   \n" + 
				"					<fo:table-column column-width='1.75cm'  />   \n" + 
				"					<fo:table-column column-width='1.75cm'  />   \n" + 
				"					<fo:table-column column-width='1.75cm'  />   \n" + 
				"					<fo:table-column column-width='1.75cm'  />   \n" + 
				"					<fo:table-column column-width='1.75cm'  />   \n" + 
				"					<fo:table-header>      \n" + 
				"						<fo:table-cell>    \n" + 
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								File     \n" +
				"							</fo:block>    \n" + 
				"                        </fo:table-cell>    \n" +
				"                       <fo:table-cell>    \n" +
				"                    	    <fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								Folio \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								Emisi&#243;n  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								Vencido  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								  Dias \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								Total  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								Pagado  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								Saldo  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								Dentro  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								01 a 30  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								31 a 60  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								61 a 90  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"						<fo:table-cell>    \n" +
				"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
				"								Mas 90  \n" +
				"							</fo:block>    \n" +
				"                       </fo:table-cell>    \n" +
				"           </fo:table-header>    \n" +
				"			<fo:table-body   font-family='Times' font-weight='normal' font-size='7pt'>    \n" +
										strRows +
				"           </fo:table-body>     										\n" +
				"       </fo:table>     												\n" +
				"	  </fo:block-container>     											\n" +
				" </fo:flow> \n ";
	}
	*/
	private String getTablePageReporteCxC90(String strRows) {
		if(strRows!=" ") {
			return 	" <fo:flow flow-name=\"xsl-region-body\">"+ "\n"+
					"      <fo:block-container  height='27cm' width='27cm' top='0.5cm' left='-2.2cm' position='absolute' padding='1pt'>   \n" +  
					"			<fo:table  left='-0.4cm'>   \n" + 
					"					<fo:table-column column-width='1.0cm'  	/>   \n" + 
					"				    <fo:table-column column-width='1.8cm'  	/>   \n" + 
					"					<fo:table-column column-width='1.3cm'	/>   \n" +
					"					<fo:table-column column-width='1.3cm'	/>   \n" +
					"					<fo:table-column column-width='0.8cm'	/>   \n" +
					"					<fo:table-column column-width='1.75cm'  />   \n" + 
					"					<fo:table-column column-width='1.75cm'  />   \n" + 
					"					<fo:table-column column-width='1.75cm'  />   \n" + 
					"					<fo:table-column column-width='1.75cm'  />   \n" + 
					"					<fo:table-column column-width='1.75cm'  />   \n" + 
					"					<fo:table-column column-width='1.75cm'  />   \n" + 
					"					<fo:table-column column-width='1.75cm'  />   \n" + 
					"					<fo:table-column column-width='1.75cm'  />   \n" + 
					"					<fo:table-header>      \n" + 
					"						<fo:table-cell>    \n" + 
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								File     \n" +
					"							</fo:block>    \n" + 
					"                        </fo:table-cell>    \n" +
					"                       <fo:table-cell>    \n" +
					"                    	    <fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								Folio \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								Emisi&#243;n  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								Vencido  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								  Dias \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								Total  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								Pagado  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								Saldo  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								Dentro  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								01 a 30  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								31 a 60  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								61 a 90  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"						<fo:table-cell>    \n" +
					"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
					"								Mas 90  \n" +
					"							</fo:block>    \n" +
					"                       </fo:table-cell>    \n" +
					"           </fo:table-header>    \n" +
					"			<fo:table-body   font-family='Times' font-weight='normal' font-size='7pt'>    \n" +
											strRows +
					"           </fo:table-body>     										\n" +
					"       </fo:table>     												\n" +
					"	  </fo:block-container>     											\n" +
					" </fo:flow> \n ";
		} else {
			return "";
		}
	}
	
	private String startFile() {
		return  "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"+"\n"+
				"<fo:root xmlns:fo=\"http://www.w3.org/1999/XSL/Format\">"+"\n"+
				"	<fo:layout-master-set>"+"\n"+
				"		<fo:simple-page-master master-name=\"detalle\" page-height=\"11in\"  page-width=\"8.5in\" margin-top=\"1in\" margin-bottom=\"1in\" margin-left=\"1in\" margin-right=\"1in\">"+"\n"+
				"			<fo:region-body margin-top=\"1in\" margin-bottom=\".5in\"/>"+"\n"+
				"			<fo:region-before extent=\".5in\" margin-bottom=\".5in\"/>"+"\n"+
				"		</fo:simple-page-master>"+" \n"+
				"	</fo:layout-master-set>"+" \n";
	}

	public static String startFileStatic() {
		return  "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"+"\n"+
				"<fo:root xmlns:fo=\"http://www.w3.org/1999/XSL/Format\">"+"\n"+
				"	<fo:layout-master-set>"+"\n"+
				"		<fo:simple-page-master master-name=\"detalle\" page-height=\"11in\"  page-width=\"8.5in\" margin-top=\"1in\" margin-bottom=\"1in\" margin-left=\"1in\" margin-right=\"1in\">"+"\n"+
				"			<fo:region-body margin-top=\"1in\" margin-bottom=\".5in\"/>"+"\n"+
				"			<fo:region-before extent=\".5in\" margin-bottom=\".5in\"/>"+"\n"+
				"		</fo:simple-page-master>"+" \n"+
				"	</fo:layout-master-set>"+" \n";
	}
	
	public static String endFileStatic() {
		return "</fo:root>";
	}
	
	private String endFile() {
		return "</fo:root>";
	}
	
	public String generaFile() {
		return (this.startFile() + this.getPagesReporteCxC90() + this.endFile());
//		++
	}
	
	public String generaPagesforClient() {
		return this.getPagesReporteCxC90();
	}
	
	public java.lang.Integer getCconvenio() {
		return cconvenio;
	}

	public void setCconvenio(java.lang.Integer cconvenio) {
		this.cconvenio = cconvenio;
	}

	public java.lang.String getSconvenio() {
		return sconvenio;
	}

	public void setSconvenio(java.lang.String sconvenio) {
		this.sconvenio = sconvenio;
	}

	public int getCcliente() {
		return ccliente;
	}

	public void setCcliente(int ccliente) {
		this.ccliente = ccliente;
	}

	public String getSdireccion() {
		return sdireccion;
	}

	public void setSdireccion(String sdireccion) {
		this.sdireccion = sdireccion;
	}

	public String getScliente() {
		return scliente;
	}

	public void setScliente(String scliente) {
		this.scliente = scliente;
	}

	public String getSrfc() {
		return srfc;
	}

	public void setSrfc(String srfc) {
		this.srfc = srfc;
	}

	public List getLstFacturas() {
		return lstFacturas;
	}

	public void setLstFacturas(List lstFacturas) {
		this.lstFacturas = lstFacturas;
	}

	public double getDblNoFacturado() {
		return dblNoFacturado;
	}

	public void setDblNoFacturado(double dblNoFacturado) {
		this.dblNoFacturado = dblNoFacturado;
	}

}



//private String getTablePageReporteCxC360(String strRows) {
//	return 	" <fo:flow flow-name=\"xsl-region-body\">"+ "\n"+
//			"      <fo:block-container  height='27cm' width='27cm' top='0.5cm' left='-2.2cm' position='absolute' padding='1pt'>   \n" +  
//			"			<fo:table  left='-0.4cm'>   \n" + 
//			"					<fo:table-column column-width='0.4cm'  	/>   \n" + 
//			"				    <fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-column column-width='1.3cm'	/>   \n" +
//			"					<fo:table-column column-width='1.6cm'	/>   \n" +
//			"					<fo:table-column column-width='1.4cm'	/>   \n" +
//			"					<fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-column column-width='1.6cm'  	/>   \n" + 
//			"					<fo:table-header>      \n" + 
//			"						<fo:table-cell>    \n" + 
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								      \n" +
//			"							</fo:block>    \n" + 
//			"                        </fo:table-cell>    \n" +
//			"                       <fo:table-cell>    \n" +
//			"                    	    <fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								Folio \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								Emisi&#243;n  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								Total  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								Pagado \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								Saldo \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								Dentro  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								01 a 30  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								31 a 60  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								61 a 90  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								91 a 120  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								121 a 180  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								181 a 360  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"						<fo:table-cell>    \n" +
//			"							<fo:block border-color='black' background-color='rgb(255,165,0)' border-style='solid' border-width='0.67pt' text-align='center' font-size='7pt' font-weight='bold'>  \n" +
//			"								Mas 360  \n" +
//			"							</fo:block>    \n" +
//			"                       </fo:table-cell>    \n" +
//			"           </fo:table-header>    \n" +
//			"			<fo:table-body   font-family='Times' font-weight='normal' font-size='7pt'>    \n" +
//									strRows +
//			"           </fo:table-body>     										\n" +
//			"       </fo:table>     												\n" +
//			"	  </fo:block-container>     											\n" +
//			" </fo:flow> \n ";
//}


//public String getPagesReporteCxC360(Formatos objFormatos,FormateaFecha objFormatearDate,String sHttpPath, double dblNoFacturado) {
//	String strReturn = "";
//	String strRowsPage = "";
//	int inty = 0;
//	if (this.lstRowReporteCxC360.size() < this.consRowsxPage) {
//		this.consRowsxPage = this.lstRowReporteCxC360.size();
//	}
//	for (int inti=0;inti < this.lstRowReporteCxC360.size();inti++) {
//		if ((inty + 1) >= this.consRowsxPage) {
//			strRowsPage += (String)this.lstRowReporteCxC360.get(inti);				
//			strReturn += this.headerPage(dblNoFacturado, sHttpPath, objFormatearDate, objFormatos) + this.getTablePageReporteCxC360(strRowsPage) + this.footerPage();
//			inty = 0;
//			strRowsPage = "";
//		}
//		strRowsPage += (String)this.lstRowReporteCxC360.get(inti);				
//		inty++;
//	}
//	if (strRowsPage.trim().length() > 0) {
//		strReturn += this.headerPage(dblNoFacturado, sHttpPath, objFormatearDate, objFormatos) + this.getTablePageReporteCxC360(strRowsPage) + this.footerPage();
//	}
//	return strReturn;
//}


//public List getLstRowReporteCxC360() {
//	return lstRowReporteCxC360;
//}
//
//public String getRowsReporteCxC360(int intBodyPage) {
//	String strReturn = "";
//	int intEnd = (intBodyPage * consRowsxPage);
//	int intStart = (intEnd - consRowsxPage);
//	if (intEnd > this.lstRowReporteCxC360.size()) {
//		intEnd = this.lstRowReporteCxC360.size();
//	}
//	for (int inti=intStart;inti < intEnd;inti++) {
//		strReturn += (String)this.lstRowReporteCxC360.get(inti);
//	}
//	return strReturn;
//}		

//public String totalesFile360(Formatos objFormatos) {
//String strRowsTable = "";
//strRowsTable =	"				<fo:table-row>																				\n" +     			
//				"        				<fo:table-cell  padding='1pt'>      												\n" +
//				"        					<fo:block text-align='center' font-family='sans-serif' font-size='6pt'>  	    \n" + 
//												" " 													+
//				"							</fo:block>    																	\n" + 		
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='left' font-family='sans-serif' font-size='6pt'>			\n" + 
//												" " 													+ 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='center' font-weight='bold' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"TOTALES " 													+ 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotalFactura))) +
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotalPagado))) +
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotalSaldo))) + 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotalDentroPlazo))) + 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal30))) +
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal60))) + 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal90))) + 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal120))) + 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal180))) + 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblTotal360))) + 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"        				<fo:table-cell padding='1pt'>      												\n" +
//				"        					<fo:block text-align='right' font-family='sans-serif' font-size='6pt'>			\n" + 
//												"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(this.dblMas361))) + 
//				"							</fo:block>    																	\n" + 										
//				"        				</fo:table-cell>     																\n" +	
//				"				</fo:table-row>     																		\n";		
//return strRowsTable;
//}

