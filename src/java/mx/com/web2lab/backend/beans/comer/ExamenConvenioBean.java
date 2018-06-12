package mx.com.web2lab.backend.beans.comer;

import java.io.Serializable;

public class ExamenConvenioBean implements Comparable,Serializable {

	private int kexamenconvenio = 0;
	
	private int cexamen = 0;
	
	private String sexamen = "";
	
	private int pdescuento;
	
	private int cclasificacioncomercial = 0;
	
	private String sclasificacioncomercial = "";

	public int getKexamenconvenio() {
		return kexamenconvenio;
	}

	public void setKexamenconvenio(int kexamenconvenio) {
		this.kexamenconvenio = kexamenconvenio;
	}

	public int getCexamen() {
		return cexamen;
	}

	public void setCexamen(int cexamen) {
		this.cexamen = cexamen;
	}

	public String getSexamen() {
		return sexamen;
	}

	public void setSexamen(String sexamen) {
		this.sexamen = sexamen;
	}

	public int getPdescuento() {
		return pdescuento;
	}

	public void setPdescuento(int pdescuento) {
		this.pdescuento = pdescuento;
	}

	public int getCclasificacioncomercial() {
		return cclasificacioncomercial;
	}

	public void setCclasificacioncomercial(int cclasificacioncomercial) {
		this.cclasificacioncomercial = cclasificacioncomercial;
	}

	public String getSclasificacioncomercial() {
		return sclasificacioncomercial;
	}

	public void setSclasificacioncomercial(String sclasificacioncomercial) {
		this.sclasificacioncomercial = sclasificacioncomercial;
	}
	
	 public int compareTo(Object o) {
		 ExamenConvenioBean otroExamen = (ExamenConvenioBean) o;
		 return this.sexamen.compareTo(otroExamen.getSexamen());
	}	
}
