package mx.com.web2lab.backend.beans.facturacion.electronica;

import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.tools.SucursalBean;

public class DesgloceFacturaExamenBean {
	private String cantidad;
    private String codigo;
    private String unidad;
    private String concepto;
    private String preciounitario;
    private String importe;
    
    public DesgloceFacturaExamenBean(String cantidad, String codigo, String unidad,String concepto,String preciounitario,String importe) {
        this.setCantidad(cantidad);
        this.setCodigo(codigo);
        this.setUnidad(unidad);
        this.setConcepto(concepto);
        this.setPreciounitario(preciounitario);
        this.setImporte(importe);
    }
    
    public DesgloceFacturaExamenBean(){
    	
    }
    
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getPreciounitario() {
		return preciounitario;
	}
	public void setPreciounitario(String preciounitario) {
		this.preciounitario = preciounitario;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	
    }
