package es.gme.ree.manager.url;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ReeURLContext {

	public ReeURLContext() {
		this(3, "liquicomun", 11, 2013, "zip", "es", "Publicaciones");
	}

	public ReeURLContext(int month, int year) {
		this(3, "liquicomun", month, year, "zip", "es", "Publicaciones");
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