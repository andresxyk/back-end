package mx.com.web2lab.backend.util.beans.sistema;

import java.io.Serializable;
import java.util.Date;

public class UsuarioBean implements Serializable {

    /** nombre del usuario */
    private String iStrObjNombre;
    /** apellido del usuario */
    private String iStrObjApellido;
    /** correo del usuario */
    private String iStrObjEmail;
    /** fecha de modificacion del password */
    private Date iDteObjFecMod;
    /** numero del usuario */
    private int iIntIdUsuario;
    /** login del usuario */
    private String iStrObjLogin; 
    
    
    /**
     * Constructor
     */
    public UsuarioBean() {
    }
    
    /**
     * @return Regresa la(s) iStrObjApellido.
     */
    public String getIStrObjApellido() {
        return iStrObjApellido;
    }
    /**
     * @param aStrObjApellido La iStrObjApellido a establecer.
     */
    public void setIStrObjApellido(String aStrObjApellido) {
        this.iStrObjApellido = aStrObjApellido;
    }
    /**
     * @return Regresa la(s) iStrObjEmail.
     */
    public String getIStrObjEmail() {
        return iStrObjEmail;
    }
    /**
     * @param aStrObjEmail La iStrObjEmail a establecer.
     */
    public void setIStrObjEmail(String aStrObjEmail) {
        this.iStrObjEmail = aStrObjEmail;
    }
    /**
     * @return Regresa la(s) iStrObjNombre.
     */
    public String getIStrObjNombre() {
        return iStrObjNombre;
    }
    /**
     * @param aStrObjNombre La iStrObjNombre a establecer.
     */
    public void setIStrObjNombre(String aStrObjNombre) {
        this.iStrObjNombre = aStrObjNombre;
    }
	/**
	 * @return Regresa la(s) iDteObjFecMod.
	 */
	public Date getIDteObjFecMod() {
		return iDteObjFecMod;
	}
	/**
	 * @param dteObjFecMod La iDteObjFecMod a establecer.
	 */
	public void setIDteObjFecMod(Date dteObjFecMod) {
		iDteObjFecMod = dteObjFecMod;
	}
	/**
	 * @return Regresa la(s) iIntIdUsuario.
	 */
	public int getIIntIdUsuario() {
		return iIntIdUsuario;
	}
	/**
	 * @param intIdUsuario La iIntIdUsuario a establecer.
	 */
	public void setIIntIdUsuario(int intIdUsuario) {
		iIntIdUsuario = intIdUsuario;
	}
	/**
	 * @return Regresa la(s) iStrObjLogin.
	 */
	public String getIStrObjLogin() {
		return iStrObjLogin;
	}
	/**
	 * @param strObjLogin La iStrObjLogin a establecer.
	 */
	public void setIStrObjLogin(String strObjLogin) {
		iStrObjLogin = strObjLogin;
	}
}
