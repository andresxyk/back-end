package mx.com.web2lab.backend.beans.facturacion.electronica;

public class BodyFacturaElectronicaBean {

	private String strCodigo = "";
	
	private int intCantidad = 0;
	
	private String strDescripcion = "";
		
	private String strUnidad = "";
	
	private double dblValorUnitario = 0.0;
	
	private double dblImporte = 0.0;
	
    private boolean bolredondear;

	public boolean isBolredondear() {
		return bolredondear;
	}

	public void setBolredondear(boolean bolredondear) {
		this.bolredondear = bolredondear;
	}

	public String getStrCodigo() {
		return strCodigo;
	}

	public void setStrCodigo(String strCodigo) {
		this.strCodigo = strCodigo;
	}

	public int getIntCantidad() {
		return intCantidad;
	}

	public void setIntCantidad(int intCantidad) {
		this.intCantidad = intCantidad;
	}

	public String getStrDescripcion() {
		return strDescripcion;
	}

	public void setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
	}

	public String getStrUnidad() {
		return strUnidad;
	}

	public void setStrUnidad(String strUnidad) {
		this.strUnidad = strUnidad;
	}

	public double getDblValorUnitario() {
		if (this.bolredondear) {
			return this.redodedoDouble(dblValorUnitario);
		} else {
			return dblValorUnitario;
		}
	}

	public void setDblValorUnitario(double dblValorUnitario) {
		this.dblValorUnitario = dblValorUnitario;
	}

	public double getDblImporte() {
		if (this.bolredondear) {
//			return this.redodedoDouble(dblImporte);
			return dblImporte;
		} else {
			return dblImporte;
		}
	}

	public void setDblImporte(double dblImporte) {
//		this.dblImporte = this.redodedoDouble(dblImporte);
		this.dblImporte = dblImporte;
	}	
	
    private double redodedoDouble(double nD) {
		return Math.round(nD*Math.pow(10,2))/Math.pow(10,2);      	
    }	
}
