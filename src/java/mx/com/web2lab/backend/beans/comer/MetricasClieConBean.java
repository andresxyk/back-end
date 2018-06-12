package mx.com.web2lab.backend.beans.comer;

public class MetricasClieConBean {
	private int intClientesActivos 		= 0;
	private int intClientesNOActivos 	= 0;
	private int intClientesSinConvenio	= 0;
	private int intClientesSinConvenioActivos	= 0;
	private int intConveniosActivos  	= 0;
	private int intConveniosNOActivos	= 0;
	
	public int getIntClientesActivos() {
		return intClientesActivos;
	}
	public void setIntClientesActivos(int intClientesActivos) {
		this.intClientesActivos = intClientesActivos;
	}
	public int getIntClientesNOActivos() {
		return intClientesNOActivos;
	}
	public void setIntClientesNOActivos(int intClientesNOActivos) {
		this.intClientesNOActivos = intClientesNOActivos;
	}
	public int getIntConveniosActivos() {
		return intConveniosActivos;
	}
	public void setIntConveniosActivos(int intConveniosActivos) {
		this.intConveniosActivos = intConveniosActivos;
	}
	public int getIntConveniosNOActivos() {
		return intConveniosNOActivos;
	}
	public void setIntConveniosNOActivos(int intConveniosNOActivos) {
		this.intConveniosNOActivos = intConveniosNOActivos;
	}
	public int getIntClientesSinConvenio() {
		return intClientesSinConvenio;
	}
	public void setIntClientesSinConvenio(int intClientesSinConvenio) {
		this.intClientesSinConvenio = intClientesSinConvenio;
	}
	public int getIntClientesSinConvenioActivos() {
		return intClientesSinConvenioActivos;
	}
	public void setIntClientesSinConvenioActivos(int intClientesSinConvenioActivos) {
		this.intClientesSinConvenioActivos = intClientesSinConvenioActivos;
	}

}
