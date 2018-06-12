/**
 * 
 */
package mx.com.web2lab.backend.beans.tiemposmovimientos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.dao.laboratorio.TomaMuestrasDao;

/**
 * @author orubio
 *
 */
public class OrdenTomaMuestraBean {
	
	private String strSize = "22";
	
	private int kadmision;
	
	private int uLaboratorio;
	
	private int uorden;
	
	private String snemonicosucursal;	
	
	private String strOrden;
	
	private String sfechacaptura;
	
	private String stomamuestra;
		
	private String stiempoespera;
			
	private double dblMinutos;
		
	private String slogin_name_atencion;
	
	private String sname_atencion;
	
	private String sname_atencion_other;
	
	private int uTipoOrden;

	private String snamePaciente;
	
	private List lstExamenes = new ArrayList();

	public int getUorden() {
		return uorden;
	}

	public void setUorden(int uorden) {
		this.uorden = uorden;
	}

	public String getSnemonicosucursal() {
		return snemonicosucursal;
	}

	public void setSnemonicosucursal(String snemonicosucursal) {
		this.snemonicosucursal = snemonicosucursal;
	}

	public String getStrOrden() {
		String strReturn = "";
		if ((this.slogin_name_atencion.trim().length() > 2) || (this.sname_atencion_other.trim().length() > 1)) {
			strReturn = "   <td align='center'> " + 
								this.strOrden + 
						 "	</td>";
		} else {
			strReturn = "   <td align='center'> <a href='javascript:doNothing()' onClick='javascript:confirmarToma(" + this.kadmision + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
								this.strOrden + 
						"	</td>"; 
		}
		return strReturn;
	}

	public void setStrOrden(String strOrden) {
		this.strOrden = strOrden;
	}

	public String getSfechacaptura() {
		return sfechacaptura;
	}

	public void setSfechacaptura(String sfechacaptura) {
		this.sfechacaptura = sfechacaptura;
	}

	public String getStomamuestra() {
		return stomamuestra;
	}

	public void setStomamuestra(String stomamuestra) {
		this.stomamuestra = stomamuestra;
	}

	public String getStiempoespera() {
		if (this.slogin_name_atencion.trim().length() > 2) {
			return this.sname_atencion;
		} else if (this.sname_atencion_other.trim().length() > 1) {
			return this.sname_atencion_other;
		} else {
			return this.stiempoespera;
		}
	}

	public void setStiempoespera(String stiempoespera) {
		this.stiempoespera = stiempoespera;
	}

	public List getLstExamenes() {
		return lstExamenes;
	}

	public void setLstExamenes(List lstExamenes) {
		this.lstExamenes = lstExamenes;
	}

	public int getKadmision() {
		return kadmision;
	}

	public void setKadmision(int kadmision) {
		this.kadmision = kadmision;
	}

	public double getDblMinutos() {
		return dblMinutos;
	}

	public void setDblMinutos(double dblMinutos) {
		this.dblMinutos = dblMinutos;
	}

	public String getSloginnameatencion() {
		return slogin_name_atencion;
	}

	public void setSloginnameatencion(String slogin_name_atencion) {
		this.slogin_name_atencion = slogin_name_atencion;
	}
	
	public int getuLaboratorio() {
		return uLaboratorio;
	}

	public void setuLaboratorio(int uLaboratorio) {
		this.uLaboratorio = uLaboratorio;
	}

	public String getSname_atencion() {
		return sname_atencion;
	}

	public void setSname_atencion(String sname_atencion) {
		this.sname_atencion = sname_atencion;
	}	
		
	public void addExamen(ResultSet objResultSet) throws Exception {
		OrdenExamenTomaMuestraBean objOrdenExamenTomaMuestraBean = new OrdenExamenTomaMuestraBean();
		try {
			objOrdenExamenTomaMuestraBean.setKordenexamensucursal(objResultSet.getInt("kordenexamensucursal"));
			objOrdenExamenTomaMuestraBean.setCexamen(objResultSet.getInt("cexamen"));
			objOrdenExamenTomaMuestraBean.setCperfil(objResultSet.getInt("cexamen"));
			objOrdenExamenTomaMuestraBean.setSnombreexamen(objResultSet.getString("cexamen") + " " + objResultSet.getString("sexamen").trim());
			objOrdenExamenTomaMuestraBean.setSexamen(objResultSet.getString("sexamen").trim());
			objOrdenExamenTomaMuestraBean.setKadmision(objResultSet.getInt("admision"));
			objOrdenExamenTomaMuestraBean.setStomamuestra(objResultSet.getString("fechatomamuestra"));
			objOrdenExamenTomaMuestraBean.setUmuestra(objResultSet.getString("umuestra"));
			lstExamenes.add(objOrdenExamenTomaMuestraBean);
		} catch (Exception exp) {
			throw exp;
		}
	}	
	
	public void calculaestusOrden() {
		
	}
	
	private String calculaHumorPaciente() {		
		String strEspera = "";
		try {
			if (this.dblMinutos < 9.0) {								
				strEspera = "<img alt='HumorPaciente' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/happy.png' />";
			} else if (this.dblMinutos < 20.0) {
				strEspera = "<img alt='HumorPaciente' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/serious.png' />";
			} else {
				strEspera = "<img alt='HumorPaciente' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/sad.png' />";
			}							
			if (this.slogin_name_atencion.trim().length() > 2) {
				strEspera = "	<a href=\"javascript:terminoToma(" + this.kadmision + ");\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
							"		<img alt='Atendida' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/atendida.png' />" +
							"	</a>"; 													
			   strEspera += "	<a href=\"javascript:imprimeEtiquetas(" + this.kadmision + ");\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
							"		<img alt='Codigo Barras' id=\"imgPDF\" width=\"27\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/icoCodigoBarras.png' />" +
							"	</a>"; 													
			   this.stiempoespera = this.sname_atencion;
			} else {
				if (this.sname_atencion_other.trim().length() > 1) {
					strEspera = "	<a href=\"javascript:null;\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
								"		<img alt='El paciente esta con: " + sname_atencion_other + "' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/gabinetes.png' />" +
								"	</a>"; 													
					this.sname_atencion = this.sname_atencion_other;
				} else {
	
				}
			}
		} catch (Exception exp) {
			exp.getStackTrace();
		}
		return strEspera;
	}
	
	public String getRowOrden(String sclass) {
		return ("<tr class='" + sclass + "'>" + 
						this.getStrOrden() +
				"	<td align='center'>" + 
						this.getSfechacaptura() + 
				"	</td>" +
				"	<td align='center'>" + 
				"	</td>" +
				"	<td align='center' style='color: blue;'>" + 
//						strPaciente + 
				"	</td>" +
				"	<td align='center'>" + 
						this.getStiempoespera() + 
				"	</td>" +
				"	<td align='center'>" + 
						this.calculaHumorPaciente() +
				"	</td>" +
			 	"</tr>");
	}

	public String getSname_atencion_other() {
		return sname_atencion_other;
	}

	public void setSname_atencion_other(String sname_atencion_other) {
		this.sname_atencion_other = sname_atencion_other;
	}

	public int getuTipoOrden() {
		return uTipoOrden;
	}

	public void setuTipoOrden(int uTipoOrden) {
		this.uTipoOrden = uTipoOrden;
	}

	public String getSnamePaciente() {
		return snamePaciente;
	}

	public void setSnamePaciente(String snamePaciente) {
		this.snamePaciente = snamePaciente;
	}

	public String getStrSize() {
		return strSize;
	}

	public void setStrSize(String strSize) {
		this.strSize = strSize;
	}
}
