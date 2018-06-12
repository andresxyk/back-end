package mx.com.web2lab.backend.util.beans.codigos;

import java.io.Serializable;

/**
 * 
 *
 * Clase que es utilizada para regresar un objeto de teclas de atajo
 * sin necesidad de obtener un objeto mayor que traera datos no necesarios 
 */
public class TeclasTraduccionBean implements Serializable {
	
	/**
	 * Variable utilizada para contener las teclas de traduccion
	 * correspondientes a un mensaje
	 */
	private String iStrDatajo;
	
	/**
	 * variable utilizada para contener el mensaje de un atajo
	 */
	private String iStrDMensaje;
	
	/**
	 * Variable utilizada para contener el nombre de un mensaje
	 */
	private String iStrDMensamae;
	
	/**
	 * Variable utilizada para contener el nombre de un mensaje
	 */
	private int iIntCMensaje;
	
	/**
	 * variable utilizada para consultar el id del grupo mensaje 
	 */
	private int iIntCGrupoMensaje;
	
	/**
	 * Metodo que obtiene las teclas de atajo  
	 * @return Returns the iStrDatajo.
	 */
	public String getIStrDatajo() {
		return iStrDatajo;
	}
	/**
	 * Metodo que asigna una tecla de atajo
	 * @param aStrDatajo The aStrDatajo to set.
	 */
	public void setIStrDatajo(String aStrDatajo) {
		this.iStrDatajo = aStrDatajo;
	}
	
	/**
	 * Metodo que obtiene un Mensaje de un atajo
	 * @return Returns the iStrDMensaje.
	 */
	public String getIStrDMensaje() {
		return iStrDMensaje;
	}
	/**
	 * Metodo que asigna un mensaje a un atajo
	 * @param aStrDmensaje The aStrDmensaje to set.
	 */
	public void setIStrDMensaje(String aStrDmensaje) {
		this.iStrDMensaje = aStrDmensaje;
	}
	
	/**
	 * Metodo que obtiene el nombre de un mensaje
	 * @return Returns the iStrDMensamae.
	 */
	public String getIStrDMensamae() {
		return iStrDMensamae;
	}
	/**
	 * Mensaje que asigna el nombre de un mensaje
	 * @param aStrDmensamae The aStrDmensamae to set.
	 */
	public void setIStrDMensamae(String aStrDmensamae) {
		this.iStrDMensamae = aStrDmensamae;
	}
	/**
	 * @return Returns the iIntCMensaje.
	 */
	public int getIIntCMensaje() {
		return iIntCMensaje;
	}
	/**
	 * @param aIntCMensaje The aIntCMensaje to set.
	 */
	public void setIIntCMensaje(int aIntCMensaje) {
		this.iIntCMensaje = aIntCMensaje;
	}
	/**
	 * @return Regresa la(s) iIntCGrupoMensaje.
	 */
	public int getIIntCGrupoMensaje() {
		return iIntCGrupoMensaje;
	}
	/**
	 * @param intCGrupoMensaje La iIntCGrupoMensaje a establecer.
	 */
	public void setIIntCGrupoMensaje(int intCGrupoMensaje) {
		iIntCGrupoMensaje = intCGrupoMensaje;
	}
}