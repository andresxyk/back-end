package mx.com.web2lab.backend.hbm.om.reportes;

import java.io.Serializable;

import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import mx.com.web2lab.backend.util.formatos.Formatos;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TAntiguedadCxc implements Serializable {

    /** identifier field */
    private int kfactura;

    /** identifier field */
    private java.lang.String sserie;

    /** identifier field */
    private int ccliente;

    /** identifier field */
    private int cconvenio;

    /** identifier field */
    private java.util.Date dregistro;

    /** identifier field */
    private java.util.Date dvencido;
    
    /** identifier field */
    private java.math.BigDecimal mtotalfactura;

    /** identifier field */
    private java.math.BigDecimal mpagado;

    /** identifier field */
    private java.math.BigDecimal msaldo;

    /** identifier field */
    private java.math.BigDecimal mdentroplazo;

    /** identifier field */
    private java.math.BigDecimal m01a30;

    /** identifier field */
    private java.math.BigDecimal m31a60;

    /** identifier field */
    private java.math.BigDecimal m61a90;

    /** identifier field */
    private java.math.BigDecimal m91a120;
    
    /** identifier field */
    private java.math.BigDecimal m121a180;
    
    /** identifier field */
    private java.math.BigDecimal m181a360;
    
    /** identifier field */
    private java.math.BigDecimal mmas361;

    /** identifier field */
    private double udiasvencido;
    
    /** identifier field */
    private java.lang.String sestadoregistro;


    /** full constructor */
    public TAntiguedadCxc(int kfactura, java.lang.String sserie, int ccliente, int cconvenio, java.util.Date dregistro, java.util.Date dvencido, java.math.BigDecimal mtotalfactura, java.math.BigDecimal mpagado, java.math.BigDecimal msaldo, java.math.BigDecimal mdentroplazo, java.math.BigDecimal m01a30, java.math.BigDecimal m31a60, java.math.BigDecimal m61a90, java.math.BigDecimal m91a120, java.math.BigDecimal m121a180, java.math.BigDecimal m181a360, java.math.BigDecimal mmas361, double udiasvencido,java.lang.String sestadoregistro) {
        this.kfactura = kfactura;
        this.sserie = sserie;
        this.ccliente = ccliente;
        this.cconvenio = cconvenio;
        this.dregistro = dregistro;
        this.dvencido = dvencido;
        this.mtotalfactura = mtotalfactura;
        this.mpagado = mpagado;
        this.msaldo = msaldo;
        this.mdentroplazo = mdentroplazo;
        this.m01a30 = m01a30;
        this.m31a60 = m31a60;
        this.m61a90 = m61a90;
        this.m91a120 = m91a120;
        this.m121a180 = m121a180;
        this.m181a360 = m181a360;
        this.mmas361 = mmas361;
        this.udiasvencido = udiasvencido;
        this.sestadoregistro = sestadoregistro;
    }

    /** default constructor */
    public TAntiguedadCxc() {
    }

    public int getKfactura() {
        return this.kfactura;
    }

    public void setKfactura(int kfactura) {
        this.kfactura = kfactura;
    }

    public java.lang.String getSserie() {
        return this.sserie;
    }

    public void setSserie(java.lang.String sserie) {
        this.sserie = sserie;
    }

    public int getCcliente() {
        return this.ccliente;
    }

    public void setCcliente(int ccliente) {
        this.ccliente = ccliente;
    }

    public int getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(int cconvenio) {
        this.cconvenio = cconvenio;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.util.Date getDvencido() {
        return this.dvencido;
    }

    public void setDvencido(java.util.Date dvencido) {
        this.dvencido = dvencido;
    }

    public java.math.BigDecimal getMtotalfactura() {
        return this.mtotalfactura;
    }

    public void setMtotalfactura(java.math.BigDecimal mtotalfactura) {
        this.mtotalfactura = mtotalfactura;
    }

    public java.math.BigDecimal getMpagado() {
        return this.mpagado;
    }

    public void setMpagado(java.math.BigDecimal mpagado) {
        this.mpagado = mpagado;
    }

    public java.math.BigDecimal getMsaldo() {
        return this.msaldo;
    }

    public void setMsaldo(java.math.BigDecimal msaldo) {
        this.msaldo = msaldo;
    }

    public java.math.BigDecimal getMdentroplazo() {
        return this.mdentroplazo;
    }

    public void setMdentroplazo(java.math.BigDecimal mdentroplazo) {
        this.mdentroplazo = mdentroplazo;
    }

    public java.math.BigDecimal getM01a30() {
        return this.m01a30;
    }

    public void setM01a30(java.math.BigDecimal m01a30) {
        this.m01a30 = m01a30;
    }

    public java.math.BigDecimal getM31a60() {
        return this.m31a60;
    }

    public void setM31a60(java.math.BigDecimal m31a60) {
        this.m31a60 = m31a60;
    }

    public java.math.BigDecimal getM61a90() {
        return this.m61a90;
    }

    public void setM61a90(java.math.BigDecimal m61a90) {
        this.m61a90 = m61a90;
    }

    public java.math.BigDecimal getM91a120() {
        return this.m91a120;
    }

    public void setM91a120(java.math.BigDecimal m91a120) {
        this.m91a120 = m91a120;
    }

    public java.math.BigDecimal getM121a180() {
        return this.m121a180;
    }

    public void setM121a180(java.math.BigDecimal m121a180) {
        this.m121a180 = m121a180;
    }

    public java.math.BigDecimal getM181a360() {
        return this.m181a360;
    }

    public void setM181a360(java.math.BigDecimal m181a360) {
        this.m181a360 = m181a360;
    }

    public java.math.BigDecimal getMmas361() {
        return this.mmas361;
    }

    public void setMmas361(java.math.BigDecimal mmas361) {
        this.mmas361 = mmas361;
    }
    
    
    public double getUdiasvencido() {
        return this.udiasvencido;
    }

    public void setUdiasvencido(double udiasvencido) {
        this.udiasvencido = udiasvencido;
    }
    
    public java.lang.String getSestadoregistro() {
		return sestadoregistro;
	}

	public void setSestadoregistro(java.lang.String sestadoregistro) {
		this.sestadoregistro = sestadoregistro;
	}

    public String getrowTableFOP360(FormateaFecha objFormatearDate, Formatos objFormatos, String sHttpPath) {
    	return 	"				<fo:table-row>																				\n" +     			
				"        				<fo:table-cell  padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>  	    \n" + 
				"				       			<fo:basic-link external-destination=\"url('http://192.237.150.66:9085/FacturasElectronicas_Olab/PDF/FacturacionElectronica_" + this.getSserie() + ".pdf')\" font-family='sans-serif' font-size='7pt' text-decoration=\"underline\"> 			\n" + 
                "                       			<fo:external-graphic width='8pt' height='8pt' content-width='8pt' content-height='8pt' overflow='hidden' src = '" + sHttpPath + "icoPdf.png' /> \n" +  
				"				       			</fo:basic-link>															\n" +
				"							</fo:block>    																	\n" + 		
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												this.getSserie()	+   												
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												objFormatearDate.getFechaddmm2y(this.getDregistro()) 						+ 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getMtotalfactura().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getMpagado().doubleValue() + "") 	+ 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getMsaldo().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +								
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getMdentroplazo().doubleValue()  + "")	+ 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM01a30().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM31a60().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM61a90().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM91a120().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM121a180().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM181a360().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getMmas361().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												this.getSestadoregistro()	+   												
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +
				"				</fo:table-row>     																		\n";						
    }    

    public String getrowTableFOP90(FormateaFecha objFormatearDate, Formatos objFormatos, String sHttpPath) {
    	return 	"				<fo:table-row>																				\n" +     			
				"        				<fo:table-cell  padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>  	    \n" + 
				"				       			<fo:basic-link external-destination=\"url('http://192.237.150.66:9085/FacturasElectronicas_Olab/PDF/FacturacionElectronica_" + this.getSserie() + ".pdf')\" font-family='sans-serif' font-size='7pt' text-decoration=\"underline\"> 			\n" + 
                "                       			<fo:external-graphic width='8pt' height='8pt' content-width='8pt' content-height='8pt' overflow='hidden' src = '" + sHttpPath + "icoPdf.png' /> \n" +  
				"				       			</fo:basic-link>															\n" +
				"							</fo:block>    																	\n" + 		
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												this.getSserie()	+   												
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												objFormatearDate.getFechaddmm2y(this.getDregistro()) 						+ 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												objFormatearDate.getFechaddmm2y(this.getDvencido()) 						+ 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
												(int)this.udiasvencido 													+ 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getMtotalfactura().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getMpagado().doubleValue() + "") 	+ 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getMsaldo().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getMdentroplazo().doubleValue()  + "")	+ 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM01a30().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM31a60().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM61a90().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='right' font-family='sans-serif' font-size='7pt'>			\n" + 
												"$" + objFormatos.formateaNumero(this.getM91a120().doubleValue() + this.getM121a180().doubleValue() + this.getM181a360().doubleValue() + this.getMmas361().doubleValue() + "") + 
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +
				"        				<fo:table-cell padding='1pt'>      												\n" +
				"        					<fo:block text-align='center' font-family='sans-serif' font-size='7pt'>			\n" + 
//												this.getSestadoregistro()	+
												this.getSestadoregistro().charAt (0) +
				"							</fo:block>    																	\n" + 										
				"        				</fo:table-cell>     																\n" +	
				
				"				</fo:table-row>     																		\n";						
    }    
    
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("kfactura", getKfactura())
            .append("sserie", getSserie())
            .append("ccliente", getCcliente())
            .append("cconvenio", getCconvenio())
            .append("dregistro", getDregistro())
            .append("mtotalfactura", getMtotalfactura())
            .append("mpagado", getMpagado())
            .append("msaldo", getMsaldo())
            .append("mdentroplazo", getMdentroplazo())
            .append("m01a30", getM01a30())
            .append("m31a60", getM31a60())
            .append("m61a90", getM61a90())
            .append("m91a120", getM91a120())
            .append("m121a180", getM121a180())
            .append("m181a360", getM181a360())
            .append("mmas361", getMmas361())
            .append("udiasvencido", getUdiasvencido())
            .append("estado", getSestadoregistro())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TAntiguedadCxc) ) return false;
        TAntiguedadCxc castOther = (TAntiguedadCxc) other;
        return new EqualsBuilder()
            .append(this.getKfactura(), castOther.getKfactura())
            .append(this.getSserie(), castOther.getSserie())
            .append(this.getCcliente(), castOther.getCcliente())
            .append(this.getCconvenio(), castOther.getCconvenio())
            .append(this.getDregistro(), castOther.getDregistro())
            .append(this.getMtotalfactura(), castOther.getMtotalfactura())
            .append(this.getMpagado(), castOther.getMpagado())
            .append(this.getMsaldo(), castOther.getMsaldo())
            .append(this.getMdentroplazo(), castOther.getMdentroplazo())
            .append(this.getM01a30(), castOther.getM01a30())
            .append(this.getM31a60(), castOther.getM31a60())
            .append(this.getM61a90(), castOther.getM61a90())
            .append(this.getM91a120(), castOther.getM91a120())
            .append(this.getM121a180(), castOther.getM121a180())
            .append(this.getM181a360(), castOther.getM181a360())
            .append(this.getMmas361(), castOther.getMmas361())
            .append(this.getUdiasvencido(), castOther.getUdiasvencido())
            .append(this.getSestadoregistro(), castOther.getSestadoregistro())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKfactura())
            .append(getSserie())
            .append(getCcliente())
            .append(getCconvenio())
            .append(getDregistro())
            .append(getMtotalfactura())
            .append(getMpagado())
            .append(getMsaldo())
            .append(getMdentroplazo())
            .append(getM01a30())
            .append(getM31a60())
            .append(getM61a90())
            .append(getM91a120())
            .append(getM121a180())
            .append(getM181a360())
            .append(getMmas361())
            .append(getUdiasvencido())
            .append(getSestadoregistro())
            .toHashCode();
    }


}
