package org.projectredcap.main;

public class Config
{
	
	String API_URL = "";
	String API_TOKEN = "";
	String API_CONTENT = "";
	String API_FORMAT = "";
	String API_TYPE = "";
	String API_OVERWRITE_BEHAVIOR = "";
	String API_FORCE_AUTO_NUMBER = "";
	String API_DATE_FORMAT = ""; 
	String API_RAWORLABEL = "";
	String API_FIELDS = "";
	Integer API_REPORT_ID = 0;
	
	
	
	public Config(String aPI_URL, String aPI_TOKEN, String aPI_CONTENT,
			String aPI_FORMAT, String aPI_TYPE, String aPI_OVERWRITE_BEHAVIOR, String aPI_FORCE_AUTO_NUMBER, String aPI_DATE_FORMAT, String aPI_RAWORLABEL,
			String aPI_FIELDS, Integer aPI_REPORT_ID) {
		super();
		API_URL = aPI_URL;
		API_TOKEN = aPI_TOKEN;
		API_CONTENT = aPI_CONTENT;
		API_FORMAT = aPI_FORMAT;
		API_TYPE = aPI_TYPE;
		API_OVERWRITE_BEHAVIOR = aPI_OVERWRITE_BEHAVIOR;
		API_FORCE_AUTO_NUMBER = aPI_FORCE_AUTO_NUMBER;
		API_DATE_FORMAT = aPI_DATE_FORMAT;
		API_RAWORLABEL = aPI_RAWORLABEL;
		API_FIELDS = aPI_FIELDS;
		API_REPORT_ID = aPI_REPORT_ID;
	}
	
	public String getAPI_TOKEN() {
		return API_TOKEN;
	}
	
	public void setAPI_TOKEN(String aPI_TOKEN) {
		API_TOKEN = aPI_TOKEN;
	}
	
	public String getAPI_URL() {
		return API_URL;
	}
	
	public void setAPI_URL(String aPI_URL) {
		API_URL = aPI_URL;
	}

	public String getAPI_TYPE() {
		return API_TYPE;
	}

	public void setAPI_TYPE(String aPI_TYPE) {
		API_TYPE = aPI_TYPE;
	}

	/**
	 * @return the aPI_OVERWRITE_BEHAVIOR
	 */
	public String getAPI_OVERWRITE_BEHAVIOR() {
		return API_OVERWRITE_BEHAVIOR;
	}

	/**
	 * @param aPI_OVERWRITE_BEHAVIOR the aPI_OVERWRITE_BEHAVIOR to set
	 */
	public void setAPI_OVERWRITE_BEHAVIOR(String aPI_OVERWRITE_BEHAVIOR) {
		API_OVERWRITE_BEHAVIOR = aPI_OVERWRITE_BEHAVIOR;
	}

	/**
	 * @return the aPI_FORCE_AUTO_NUMBER
	 */
	public String getAPI_FORCE_AUTO_NUMBER() {
		return API_FORCE_AUTO_NUMBER;
	}

	/**
	 * @param aPI_FORCE_AUTO_NUMBER the aPI_FORCE_AUTO_NUMBER to set
	 */
	public void setAPI_FORCE_AUTO_NUMBER(String aPI_FORCE_AUTO_NUMBER) {
		API_FORCE_AUTO_NUMBER = aPI_FORCE_AUTO_NUMBER;
	}

	/**
	 * @return the aPI_DATE_FORMAT
	 */
	public String getAPI_DATE_FORMAT() {
		return API_DATE_FORMAT;
	}

	/**
	 * @param aPI_DATE_FORMAT the aPI_DATE_FORMAT to set
	 */
	public void setAPI_DATE_FORMAT(String aPI_DATE_FORMAT) {
		API_DATE_FORMAT = aPI_DATE_FORMAT;
	}

	public String getAPI_FORMAT() {
		return API_FORMAT;
	}

	public void setAPI_FORMAT(String aPI_FORMAT) {
		API_FORMAT = aPI_FORMAT;
	}

	public String getAPI_CONTENT() {
		return API_CONTENT;
	}

	public void setAPI_CONTENT(String aPI_CONTENT) {
		API_CONTENT = aPI_CONTENT;
	}

	public String getAPI_RAWORLABEL() {
		return API_RAWORLABEL;
	}

	public void setAPI_RAWORLABEL(String aPI_RAWORLABEL) {
		API_RAWORLABEL = aPI_RAWORLABEL;
	}

	public String getAPI_FIELDS() {
		return API_FIELDS;
	}

	public void setAPI_FIELDS(String aPI_FIELDS) {
		API_FIELDS = aPI_FIELDS;
	}

	public Integer getAPI_REPORT_ID() {
		return API_REPORT_ID;
	}

	public void setAPI_REPORT_ID(Integer aPI_REPORT_ID) {
		API_REPORT_ID = aPI_REPORT_ID;
	}		
}
