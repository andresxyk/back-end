package mx.com.web2lab.backend.beans.cotizaciones;

import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalCotizacion;

public class CotizacionBean {

	private TOrdenSucursalCotizacion objtordensucursalcotizacion = new TOrdenSucursalCotizacion();

	private List lstexamenesOrdenexamensucursalcotizacion = new ArrayList();
	
	private OrdenBean objordenbean = null;

	public TOrdenSucursalCotizacion getObjtordensucursalcotizacion() {
		return objtordensucursalcotizacion;
	}

	public void setObjtordensucursalcotizacion(
			TOrdenSucursalCotizacion objtordensucursalcotizacion) {
		this.objtordensucursalcotizacion = objtordensucursalcotizacion;
	}

	public List getLstexamenesOrdenexamensucursalcotizacion() {
		return lstexamenesOrdenexamensucursalcotizacion;
	}

	public void setLstexamenesOrdenexamensucursalcotizacion(
			List lstexamenesOrdenexamensucursalcotizacion) {
		this.lstexamenesOrdenexamensucursalcotizacion = lstexamenesOrdenexamensucursalcotizacion;
	}

	public OrdenBean getObjordenbean() {
		return objordenbean;
	}

	public void setObjordenbean(OrdenBean objordenbean) {
		this.objordenbean = objordenbean;
	}
	
}
