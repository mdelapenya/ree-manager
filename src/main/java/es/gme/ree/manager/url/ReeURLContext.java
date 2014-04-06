package es.gme.ree.manager.url;

import es.gme.ree.manager.properties.PropsValues;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ReeURLContext {

	public ReeURLContext() {
		this(
			PropsValues.REE_APPLICATION_CTYPE_VALUE, PropsValues.REE_APPLICATION_FILENAME_VALUE, 11, 2013,
			PropsValues.REE_APPLICATION_FILETYPE_VALUE, PropsValues.REE_APPLICATION_LANGUAGE_VALUE,
			PropsValues.REE_APPLICATION_REQUESTTYPE_VALUE);
	}

	public ReeURLContext(int month, int year) {
		this(
			PropsValues.REE_APPLICATION_CTYPE_VALUE, PropsValues.REE_APPLICATION_FILENAME_VALUE, month, year,
			PropsValues.REE_APPLICATION_FILETYPE_VALUE, PropsValues.REE_APPLICATION_LANGUAGE_VALUE,
			PropsValues.REE_APPLICATION_REQUESTTYPE_VALUE);
	}

	public ReeURLContext(
		int cType, String fileName, int month, int year, String fileType, String language, String requestType) {

		this.cType = cType;
		this.fileName = fileName;
		this.fileType = fileType;
		this.language = language;
		this.month = month;
		this.requestType = requestType;
		this.year = year;
	}

	/**
	 * @return the cType
	 */
	public int getcType() {
		return cType;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	private int cType;
	private String fileName;
	private String fileType;
	private String language;
	private int month;
	private String requestType;
	private int year;

}