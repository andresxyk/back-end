package mx.com.web2lab.backend.util.xmltool;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ToolXML {

	private static Log iObjLog = LogFactory.getLog(ToolXML.class);
	
	private static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData().trim().toString();
		}
		return "";
	}	
	
	public static String getValueNode(Element element, String strNameNode)  throws Exception {	
		NodeList objNodeList = null;
		Element objElement = null;	
		String strReturn = "";
		try  {
			iObjLog.debug("Entrando ToolXML.getValueNode:Entrando... " + element.toString() + "..." + strNameNode);		
			objNodeList = element.getElementsByTagName(strNameNode);
			objElement = (Element) objNodeList.item(0);
			strReturn = getCharacterDataFromElement(objElement);
			iObjLog.debug("Saliendo ToolXML.getValueNode:Saliendo... " + strReturn);		
		} catch (Exception aObjException){
			iObjLog.error("Error ToolXML.getValueNode:Exception....", aObjException);
			throw aObjException;
		}
		return strReturn;
	}

	public static Document parserString(String strString)  throws Exception {	
	    DocumentBuilder db = null;
	    InputSource is = null;
	    Document doc = null;
		try  {
			iObjLog.debug("Entrando ToolXML.parserString:Entrando... " + strString);		
		    db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    is = new InputSource();
		    is.setCharacterStream(new StringReader(strString));
		    doc = db.parse(is);
			iObjLog.debug("Saliendo ToolXML.parserString:Saliendo... " + doc.toString());		
		} catch (Exception aObjException){
			iObjLog.error("Error ToolXML.parserString:Exception....", aObjException);
			throw aObjException;
		}
		return doc;
	}

}