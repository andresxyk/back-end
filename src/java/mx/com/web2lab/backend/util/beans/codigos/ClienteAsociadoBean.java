package mx.com.web2lab.backend.util.beans.codigos;

import java.io.Serializable;

public class ClienteAsociadoBean implements Serializable {
	
	private String iStrNomCliente;
	
    private boolean iBolActualiza;
	
	
	/**
     * Constructor
     *
     */
    public ClienteAsociadoBean(){
        
    }
    
	/**
	 * @return Returns the iStrNomCliente.
	 */
	public String getIStrNomCliente() {
		return iStrNomCliente;
	}
	/**
	 * @param strNomCliente The iStrNomCliente to set.
	 */
	public void setIStrNomCliente(String strNomCliente) {
		iStrNomCliente = strNomCliente;
	}
	/**
	 * @return Returns the iBolActualiza.
	 */
	public boolean isIBolActualiza() {
		return iBolActualiza;
	}
	/**
	 * @param bolActualiza The iBolActualiza to set.
	 */
	public void setIBolActualiza(boolean bolActualiza) {
		iBolActualiza = bolActualiza;
	}
}