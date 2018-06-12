package mx.com.web2lab.backend.dao.ap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GeneracionPasswordDao {

	private static Log iObjLog = LogFactory.getLog(GeneracionPasswordDao.class);

	public String getPassword() {  
		iObjLog.debug("Entrando a GeneracionPasswordDao.getPassword...");
//		final String base = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";	
		final String base = "ABCDEFGHJKLMNOPQRSTUVWXYZ";	
		iObjLog.debug("Consulta GeneracionPasswordDao.getPassword...Cadena...." + base);
		int LargoContrasena=Integer.parseInt("10");
		String strPassword = "";
		int longitud = base.length();
		for(int i=0; i<LargoContrasena;i++){ 
			int numero = (int)(Math.random()*(longitud));
			String caracter=base.substring(numero, numero+1); 
			strPassword=strPassword+caracter; //4
		}	 		
		iObjLog.debug("Salida GeneracionPasswordDao.getPassword...Password...." + strPassword);
		return strPassword;
	}	
}
