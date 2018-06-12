package mx.com.web2lab.backend.util;

import java.io.File;

import mx.com.web2lab.backend.hbm.ConfiguracionProperties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Se le pasa una máscara de nombre de ficheros en formato regex de java
 * y busca, recursivamente o no, todos los ficheros que cumplen dicha máscara.
 * 
 */
public class ToolArchivosSO {

	private static Log iObjLog = LogFactory.getLog(ToolArchivosSO.class);

	public String getPathRetultadoInBody(String strAdmision, String strColor) {
		String strPath = "";
		ToolArchivosSO objToolArchivosSO = new ToolArchivosSO();
		if (objToolArchivosSO.processFile(ConfiguracionProperties.getPropiedad("reporte.ruta.resultadoinbodywrite") + strAdmision + ".pdf")) {
			strPath = "	 -	<a href=\"javascript:visualizarFactura('" + ConfiguracionProperties.getPropiedad("reporte.ruta.resultadoinbodyread") + strAdmision + ".pdf" + "');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor + "; font-style: normal; font-variant: normal;'> InBody "  +  
					  "		</a>";
		}
		return strPath;
	}

	public String getPathRetultadoToxi(String strAdmision, String strColor) {
		String strPath = "";
		ToolArchivosSO objToolArchivosSO = new ToolArchivosSO();
		if (objToolArchivosSO.processFile(ConfiguracionProperties.getPropiedad("reporte.ruta.resultadotoxiwrite") + strAdmision + ".pdf")) {
			strPath = "	 -	<a href=\"javascript:visualizarFactura('" + ConfiguracionProperties.getPropiedad("reporte.ruta.resultadotoxiread") + strAdmision + ".pdf" + "');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor + "; font-style: normal; font-variant: normal;'> Toxi "  +  
					  "		</a>";
		}
		return strPath;
	}
	

	public String getPathRetultadoElectro(String strAdmision, String strColor) {
		String strPath = "";
		ToolArchivosSO objToolArchivosSO = new ToolArchivosSO();
		if (objToolArchivosSO.processFile(ConfiguracionProperties.getPropiedad("reporte.ruta.resultadoelectrowrite") + strAdmision + "-I.pdf")) {
			strPath = "	 -	<a href=\"javascript:visualizarFactura('" + ConfiguracionProperties.getPropiedad("reporte.ruta.resultadoelectroread") + strAdmision + "-I.pdf" + "');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor + "; font-style: normal; font-variant: normal;'> Electro "  +  
					  "		</a>";
		}
		return strPath;
	}

	public String getPathRetultadoLumbar(String strAdmision, String strColor) {
		String strPath = "";
		ToolArchivosSO objToolArchivosSO = new ToolArchivosSO();
		if (objToolArchivosSO.processFile(ConfiguracionProperties.getPropiedad("reporte.ruta.resultadolumbarwrite") + strAdmision + "-L.pdf")) {
			strPath = "	 -	<a href=\"javascript:visualizarFactura('" + ConfiguracionProperties.getPropiedad("reporte.ruta.resultadolumbarread") + strAdmision + "-L.pdf" + "');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor + "; font-style: normal; font-variant: normal;'> Lumbar "  +  
					  "		</a>";
		}
		return strPath;
	}

	public String getPathRetultadoTorax(String strAdmision, String strColor) {
		String strPath = "";
		ToolArchivosSO objToolArchivosSO = new ToolArchivosSO();
		if (objToolArchivosSO.processFile(ConfiguracionProperties.getPropiedad("reporte.ruta.resultadotoraxwrite") + strAdmision + ".pdf")) {
			strPath = "	 -	<a href=\"javascript:visualizarFactura('" + ConfiguracionProperties.getPropiedad("reporte.ruta.resultadotoraxread") + strAdmision + ".pdf" + "');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor + "; font-style: normal; font-variant: normal;'> Torax "  +  
					  "		</a>";
		}
		return strPath;
	}

	
	public String getPathRetultadoConclusiones(String strAdmision, String strColor) {
		String strPath = "";
		ToolArchivosSO objToolArchivosSO = new ToolArchivosSO();
		if (objToolArchivosSO.processFile(ConfiguracionProperties.getPropiedad("reporte.ruta.resultadoconclusioneswrite") + strAdmision + ".pdf")) {
			strPath = "	 -	<a href=\"javascript:visualizarFactura('" + ConfiguracionProperties.getPropiedad("reporte.ruta.resultadoconclusionesread") + strAdmision + ".pdf" + "');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor + "; font-style: normal; font-variant: normal;'> Conclusion "  +  
					  "		</a>";
		}
		return strPath;
	}
	
	private boolean processFile(String strFile) {
		boolean bolReturn = false;
		File fichero=new File(strFile);		
		if(fichero.exists()) {
			bolReturn = true;
			System.out.println("Nombre del archivo "+fichero.getName());
			System.out.println("Camino             "+fichero.getPath());
			System.out.println("Camino absoluto    "+fichero.getAbsolutePath());
			System.out.println("Se puede escribir  "+fichero.canRead());
			System.out.println("Se puede leer      "+fichero.canWrite());
			System.out.println("Tamaño             "+fichero.length());
		}
		return bolReturn;
	}	  

	private void processFilter(String strPath,String strExt) {
		System.out.println(" ******* lista de los archivos de este directorio *******");
		File fichero=new File(strPath);
		if(fichero.exists()) {
			String[] listaArchivos=fichero.list();
			for(int i=0; i<listaArchivos.length; i++){
				System.out.println(listaArchivos[i]);
			}
			System.out.println(" ******* lista de los archivos con filtro *******");
			listaArchivos=fichero.list(new Filtro(strExt));
			for(int i=0; i<listaArchivos.length; i++){
				System.out.println(listaArchivos[i]);
			}
		}
	}	  
}
