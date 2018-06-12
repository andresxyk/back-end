package mx.com.web2lab.backend.util.beans.codigos;

import java.io.Serializable;

public class LoincBean implements Serializable{
	
	String strShortName = null;
	String strScaleTyp = null;
	String strMethodTyp = null;
	String strProperty = null;
	String strLoincNum = null;
	Integer objIntIdLoinc = null;
	String strLoincParser = null;
	
	
		
	
	/**
	 * @return Returns the strLoincParser.
	 */
	public String getStrLoincParser() {
		return strLoincParser;
	}
	/**
	 * @param strLoincParser The strLoincParser to set.
	 */
	public void setStrLoincParser(String strLoincParser) {
		this.strLoincParser = strLoincParser;
	}
	/**
	 * @return Returns the objIntIdLoinc.
	 */
	public Integer getObjIntIdLoinc() {
		return objIntIdLoinc;
	}
	/**
	 * @param objIntIdLoinc The objIntIdLoinc to set.
	 */
	public void setObjIntIdLoinc(Integer objIntIdLoinc) {
		this.objIntIdLoinc = objIntIdLoinc;
	}
	/**
	 * @return Returns the strLoincNum.
	 */
	public String getStrLoincNum() {
		return strLoincNum;
	}
	/**
	 * @param strLoincNum The strLoincNum to set.
	 */
	public void setStrLoincNum(String strLoincNum) {
		this.strLoincNum = strLoincNum;
	}
	/**
	 * @return Returns the strMethodTyp.
	 */
	public String getStrMethodTyp() {
		return strMethodTyp;
	}
	/**
	 * @param strMethodTyp The strMethodTyp to set.
	 */
	public void setStrMethodTyp(String strMethodTyp) {
		this.strMethodTyp = strMethodTyp;
	}
	/**
	 * @return Returns the strProperty.
	 */
	public String getStrProperty() {
		return strProperty;
	}
	/**
	 * @param strProperty The strProperty to set.
	 */
	public void setStrProperty(String strProperty) {
		this.strProperty = strProperty;
	}
	/**
	 * @return Returns the strScaleTyp.
	 */
	public String getStrScaleTyp() {
		return strScaleTyp;
	}
	/**
	 * @param strScaleTyp The strScaleTyp to set.
	 */
	public void setStrScaleTyp(String strScaleTyp) {
		this.strScaleTyp = strScaleTyp;
	}
	/**
	 * @return Returns the strShortName.
	 */
	public String getStrShortName() {
		return strShortName;
	}
	/**
	 * @param strShortName The strShortName to set.
	 */
	public void setStrShortName(String strShortName) {
		this.strShortName = strShortName;
	}
}