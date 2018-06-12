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
public class PacienteTomaMuestraBean {
	
	private int kpaciente;
	
	private String spaciente;
	
	private int uorden = 0;
	
	private String satencionotherarea = "";
	
	private int uanos = 0;
	
	private int utipopaciente = 0;
	
	private List lstOrdenes = new ArrayList();;

	public int getKpaciente() {
		return kpaciente;
	}

	public void setKpaciente(int kpaciente) {
		this.kpaciente = kpaciente;
	}

	public String getSpaciente() {
		return spaciente;
	}

	public void setSpaciente(String spaciente) {
		this.spaciente = spaciente;
	}

	public List getLstOrdenes() {
		return lstOrdenes;
	}

	public void setLstOrdenes(List lstOrdenes) {
		this.lstOrdenes = lstOrdenes;
	}	
	
	public void addPaciente(ResultSet objResultSet,int uLaboratorio) throws Exception {
		try {
			this.setKpaciente(objResultSet.getInt("kpaciente"));
			this.setSpaciente(objResultSet.getString("spaciente"));
			this.setUanos(objResultSet.getInt("anos"));
			this.setUtipopaciente(objResultSet.getInt("utipopaciente"));
			this.addOrden(objResultSet,uLaboratorio);
		} catch (Exception exp) {
			throw exp;
		}
	}
	
	public void addOrden(ResultSet objResultSet,int uLaboratorio) throws Exception {
		OrdenTomaMuestraBean objOrdenTomaMuestraBean = new OrdenTomaMuestraBean();
		TomaMuestrasDao objTomaMuestrasDao = new TomaMuestrasDao();
		try {
			objOrdenTomaMuestraBean.setKadmision(objResultSet.getInt("admision"));
			objOrdenTomaMuestraBean.setStrOrden(objResultSet.getString("korden").trim());			
			objOrdenTomaMuestraBean.setSfechacaptura(objResultSet.getString("captura").trim());
			objOrdenTomaMuestraBean.setSnamePaciente(objResultSet.getString("spaciente"));
			objOrdenTomaMuestraBean.setDblMinutos(objResultSet.getDouble("minutos"));
			objOrdenTomaMuestraBean.setStiempoespera(objResultSet.getString("tiempoespera").trim());
			objOrdenTomaMuestraBean.setSloginnameatencion(objResultSet.getString("slogin_name").trim());
			objOrdenTomaMuestraBean.setSname_atencion(objResultSet.getString("tomador").trim());
			objOrdenTomaMuestraBean.setuLaboratorio(uLaboratorio);			
			objOrdenTomaMuestraBean.setSname_atencion_other(objTomaMuestrasDao.validaAtencionPacienteOtraArea(objOrdenTomaMuestraBean.getKadmision(),uLaboratorio).trim());			
			objOrdenTomaMuestraBean.addExamen(objResultSet);
			this.lstOrdenes.add(objOrdenTomaMuestraBean);
		} catch (Exception exp) {
			throw exp;
		} finally {
			objTomaMuestrasDao = null;
		}
	}
	
	public String getRowPaciente(String sclass) {
		String strNombre = "";
		String strOrdenes = "0";
		OrdenTomaMuestraBean objOrdenTomaMuestraBean = null;
		
		if (this.getUanos() < 5) {
			strNombre = this.spaciente + "	<img alt='' id=\"imgPDF\" width=\"25\" height=\"25\" border='0' src='/web2labportal/images/icobebe.png' />";
		} else if (this.getUanos() > 70) {
			strNombre = this.spaciente + "	<img alt='' id=\"imgPDF\" width=\"25\" height=\"25\" border='0' src='/web2labportal/images/icoAbuelito.png' />";
		} else if (this.utipopaciente > 0) {
			strNombre = this.spaciente + "	<img alt='' id=\"imgPDF\" width=\"25\" height=\"25\" border='0' src='/web2labportal/images/icodiscapacitados.png' />";
		} else {
			strNombre = this.spaciente;
		}
		
		for (int inty = 0;inty<this.getLstOrdenes().size();inty++) {
			objOrdenTomaMuestraBean = (OrdenTomaMuestraBean)this.getLstOrdenes().get(inty);
			strOrdenes = strOrdenes + "," + objOrdenTomaMuestraBean.getKadmision();
			if (objOrdenTomaMuestraBean.getSloginnameatencion().trim().length() > 2) {
				strOrdenes = "";
				break;
			} else if (objOrdenTomaMuestraBean.getSname_atencion_other().length() > 1) {
				strOrdenes = "";
				break;
			}						
		}		
		if (strOrdenes.trim().length() > 1) {
			strOrdenes = "<td align=\"center\" style=\"color: blue;\"> <a href=\"javascript:doNothing()\" onClick=\"javascript:confirmarTomaPaciente('" + strOrdenes + "');\" align=\"bottom\" style=\"font-weight: normal; color: blue; font-size: small; font-style: normal; font-variant: normal;\"> " + 
							strNombre +
						 "</a></td>";
		} else {
			strOrdenes = "<td align='center' style=\"font-weight: normal; color: blue; font-size: small; font-style: normal; font-variant: normal;\" > " + 
							strNombre +
						 "</td>";
		}
		
		return ("<tr class='" + sclass + "'>" + 
				"	<td align='center'>" + 
				"	</td>" +
				"	<td align='center'>" + 
				"	</td>" +
				"	<td align='center'>" + 
				"	</td>" + strOrdenes +
				"	<td align='center'>" + 
				"	</td>" +
				"	<td align='center'>" + 
				"	</td>" +
			 	"</tr>");
	}

	public int getUorden() {
		return uorden;
	}

	public void setUorden(int uorden) {
		this.uorden = uorden;
	}
	
	public int getPrintPosicion() {
		OrdenTomaMuestraBean objOrdenTomaMuestraBean = null;
		String strOtherProcesos = "";
		int uReturn = -1;
		
		for (int inty = 0;inty<this.getLstOrdenes().size();inty++) {
			objOrdenTomaMuestraBean = (OrdenTomaMuestraBean)this.getLstOrdenes().get(inty);
			if (objOrdenTomaMuestraBean.getSname_atencion_other().trim().length() > 0) {
				strOtherProcesos = objOrdenTomaMuestraBean.getSname_atencion_other().trim();
			}
			if ((objOrdenTomaMuestraBean.getSloginnameatencion().trim().length() > 2) || (this.uanos < 5) || (this.uanos > 70) || (this.utipopaciente > 0)) {
				uReturn =  0;
				break;
			} else if (objOrdenTomaMuestraBean.getSname_atencion_other().length() > 1) {
				uReturn =  1;
			}			
		}		
		if (uReturn == -1) {
			uReturn = 2;
		}
		if (strOtherProcesos.trim().length() > 0) {
			for (int inty = 0;inty<this.getLstOrdenes().size();inty++) {
				objOrdenTomaMuestraBean = (OrdenTomaMuestraBean)this.getLstOrdenes().get(inty);
				objOrdenTomaMuestraBean.setSname_atencion_other(strOtherProcesos.trim());
			}		
		}		
		return uReturn;			
	}

	public int getUanos() {
		return uanos;
	}

	public void setUanos(int uanos) {
		this.uanos = uanos;
	}

	public int getUtipopaciente() {
		return utipopaciente;
	}

	public void setUtipopaciente(int utipopaciente) {
		this.utipopaciente = utipopaciente;
	}	
	
	
}
