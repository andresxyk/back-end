package mx.com.web2lab.backend.dao.facturacion.electronica.security;

import mx.com.web2lab.backend.beans.facturacion.electronica.FacturaElectronicaBean;
import mx.com.web2lab.backend.hbm.ConfiguracionProperties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.ssl.PKCS8Key;

import java.security.PrivateKey; 
import java.security.Signature; 
import java.security.GeneralSecurityException; 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.io.InputStream; 
import java.io.UnsupportedEncodingException; 


public class SelloDigitalDao {
	private static Log iObjLog = LogFactory.getLog(SelloDigitalDao.class);

	
	public FacturaElectronicaBean sellaFacturaDigitalmente(FacturaElectronicaBean objFacturaBean) throws FileNotFoundException,UnsupportedEncodingException,GeneralSecurityException,Exception { 
//		String strPassword = "CLINICS21";
//		String strPassword = "Vascodequiroga11800";
//		try {
//			String sSelloPath = ConfiguracionProperties.getPropiedad("reporte.ruta.sellosread");		
////			FileInputStream archivoClavePrivada = new FileInputStream(sSelloPath + "ecd741021qa5_1010211006s.key");
//			FileInputStream archivoClavePrivada = new FileInputStream(sSelloPath + "ecd741021qa5_1210291141s.key");
//			byte[] clavePrivada = getBytes(archivoClavePrivada); 
//			PKCS8Key pkcs8 = new PKCS8Key(clavePrivada, strPassword.toCharArray()); 
//			PrivateKey pk = pkcs8.getPrivateKey(); 
//			Signature firma = Signature.getInstance("SHA1withRSA"); 
//			firma.initSign(pk);
//			firma.update(objFacturaBean.getScadenaoriginal().getBytes("UTF-8")); 
//			Base64 b64 = new Base64(); 
//			String strselloDigital = null;
//			strselloDigital = b64.encodeToString(firma.sign());
//			iObjLog.debug("Consulta SelloDigitalDao.getSelloDigital:Sellada " + strselloDigital + "\n");
//			objFacturaBean.setSsellodigital(strselloDigital);
//		} catch (FileNotFoundException aObjFileNotFoundExcepcion) {
//			iObjLog.error("ERROR SelloDigitalDao.getSelloDigital: ", aObjFileNotFoundExcepcion);
//	 		throw aObjFileNotFoundExcepcion;
//		} catch (UnsupportedEncodingException aObjEncodingExcepcion) { 
//			iObjLog.error("ERROR SelloDigitalDao.getSelloDigital: ", aObjEncodingExcepcion);
//	 		throw aObjEncodingExcepcion;
//		} catch (GeneralSecurityException aObjGeneralSecurityExcepcion) { 
//			iObjLog.error("ERROR SelloDigitalDao.getSelloDigital: ", aObjGeneralSecurityExcepcion);
//	 		throw aObjGeneralSecurityExcepcion;
//        } catch(Exception aObjExcepcion){
//			iObjLog.error("ERROR SelloDigitalDao.getSelloDigital: ", aObjExcepcion);
//	 		throw aObjExcepcion;
//        }
		return objFacturaBean; 
	}

    private byte[] getBytes(InputStream is) { 
		int totalBytes = 714; 
		byte[] buffer = null; 
		try { 
			buffer = new byte[totalBytes]; 
			is.read(buffer, 0, totalBytes); 
			is.close(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
		return buffer; 
    } 
}
