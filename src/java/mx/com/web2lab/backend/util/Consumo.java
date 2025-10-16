package mx.com.web2lab.backend.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Consumo {
	private static Log iObjLog = LogFactory.getLog(Consumo.class);
	private String targetURL="http://10.20.26.6:8192/facturas/complemento-pagos/1";
	
	public void consumirWS(){
		iObjLog.debug("Entrando Consumo.consumirWS:Entrando... "+targetURL);
		try {
			URL restServiceURL = new URL(targetURL);
			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Accept", "application/json");
			iObjLog.debug("Entrando Consumo.consumirWS:  "+httpConnection.getResponseCode());
			if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "+ httpConnection.getResponseCode());
            }
			httpConnection.disconnect();
			iObjLog.debug("Saliendo Consumo.consumirWS:Saliendo... ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
