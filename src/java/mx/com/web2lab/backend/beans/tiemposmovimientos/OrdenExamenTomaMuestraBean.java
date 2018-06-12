/**
 * 
 */
package mx.com.web2lab.backend.beans.tiemposmovimientos;

/**
 * @author orubio
 *
 */
public class OrdenExamenTomaMuestraBean {

	private int kadmision;
	
	private int kordenexamensucursal = 0;
	
	private int cexamen;
	
	private String sexamen = "";
	
	private int cperfil;
	
	private String umuestra;
	
	private String strcambiofecha;
		
	private String stomamuestra;
	
	private String snombreexamen;
	
	private String setiqueta;

	public int getCexamen() {
		return cexamen;
	}

	public void setCexamen(int cexamen) {
		this.cexamen = cexamen;
	}

	public int getCperfil() {
		return cperfil;
	}

	public void setCperfil(int cperfil) {
		this.cperfil = cperfil;
	}

	public String getStrcambiofecha() {
		return strcambiofecha;
	}

	public void setStrcambiofecha(String strcambiofecha) {
		this.strcambiofecha = strcambiofecha;
	}

	public String getStomamuestra() {
		return stomamuestra;
	}

	public void setStomamuestra(String stomamuestra) {
		this.stomamuestra = stomamuestra;
	}

	public String getSnombreexamen() {
		return snombreexamen;
	}

	public void setSnombreexamen(String snombreexamen) {
		this.snombreexamen = snombreexamen;
	}

	public String getSetiqueta() {
		return setiqueta;
	}

	public void setSetiqueta(String setiqueta) {
		this.setiqueta = setiqueta;
	}
	
	public String getRowExamenes(OrdenTomaMuestraBean objOrdenTomaMuestraBean,String sclass) {
		String strReturn = "";
		String strExamen = "";
		if (objOrdenTomaMuestraBean.getSloginnameatencion().trim().length() > 2) {
			strExamen = this.getCexamen() + "";
			strReturn = "	<a href=\"javascript:imprimirEtiquetaMuestra(" + objOrdenTomaMuestraBean.getKadmision() + "," + this.getUmuestra() + ");\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
						"		<img alt='Codigo Barras' id=\"imgPDF\" width=\"23\" height=\"18\" border='0' src='/web2labportal/images/icoCodigoBarras.png' />" +
						"	</a>"; 							
		} else {
			if (objOrdenTomaMuestraBean.getSname_atencion().trim().length() > 1) {
				strExamen = this.getCexamen() + "";
				strReturn = "	<a href=\"javascript:null;\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
							"		<img alt='El paciente esta con: " + objOrdenTomaMuestraBean.getSname_atencion() + "' id=\"imgPDF\" width=\"20\" height=\"20\" border='0' src='/web2labportal/images/gabinetes.png' />" +
							"	</a>"; 							
			} else {
				strReturn = "";
				strExamen = "<a href='javascript:doNothing()' onClick='javascript:confirmarTomaExamen(" + this.getKadmision() + "," + this.getCexamen() +");' align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'> " +
								this.getCexamen() + 
							"</a>";				
			}							
		}						
		
		return ("<tr class='" + sclass + "'>" + 
				"	<td align='center'>" + 										
				"	</td>" + 
				"	<td align='center'>" + 
				"		<input type='checkbox' id='chkTomaMuestra" + this.getKordenexamensucursal() + "'  value='" + this.getKordenexamensucursal() + "' onClick='tomaMuestraPendiente(" + this.getKordenexamensucursal() + ",this);'> " +				
				"	</td>" +
				"	<td align='center' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" + 
						this.getStomamuestra() +
				"	</td>" +
				"	<td align='left' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" + 
						strExamen + "&#09;" + this.getSexamen() + 
				"	</td>" +
				"	<td align='center'>" + 
						strReturn +								
				"	</td>" +
				"	<td align='center'>" + 
				"	</td>" +
			 	"</tr>");						

	}

	public String getUmuestra() {
		return umuestra;
	}

	public void setUmuestra(String umuestra) {
		this.umuestra = umuestra;
	}

	public String getSexamen() {
		return sexamen;
	}

	public void setSexamen(String sexamen) {
		this.sexamen = sexamen;
	}

	public int getKadmision() {
		return kadmision;
	}

	public void setKadmision(int kadmision) {
		this.kadmision = kadmision;
	}

	public int getKordenexamensucursal() {
		return kordenexamensucursal;
	}

	public void setKordenexamensucursal(int kordenexamensucursal) {
		this.kordenexamensucursal = kordenexamensucursal;
	}	
}
