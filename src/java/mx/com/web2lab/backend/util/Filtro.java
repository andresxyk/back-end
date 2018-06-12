package mx.com.web2lab.backend.util;

import java.io.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Filtro implements FilenameFilter{

	private static Log iObjLog = LogFactory.getLog(Filtro.class);
	
	private String extension;

	Filtro(String extension){
		iObjLog.debug("Entrando a Filtro(...:Entrando... " + extension);		
        this.extension=extension;
    }
    
	public boolean accept(File dir, String strname){
		iObjLog.debug("Entrando a Filtro.accept:Entrando... " + strname + " " + dir);		
        return strname.endsWith(extension);
    }
}
