package es.gme.ree.manager.url;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ReeURLBuilderImpl implements ReeURLBuilder {

	public String getURL(int month, int year) throws IllegalArgumentException {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("An invalid month has been introduced.");
		}

		String fullUrl =
			_getWebURL() + _getApplicationURL() + _getFileName(month, year) + _getFileType() + _getLanguage() +
			_getRequestType();

		return fullUrl;
	}

	private String _getApplicationURL() {
		return "Solicitar";
	}

	private String _getFileName(int month, int year) {
		String strMonth = "";

		if (month < 10) {
			strMonth += "0";
		}

		strMonth += month;

		return "?fileName=C3_liquicomun_" + year + strMonth;
	}

	private String _getFileType() {
		return "&fileType=zip";
	}

	private String _getLanguage() {
		return "&idioma=es";
	}

	private String _getRequestType() {
		return "&tipoSolicitar=Publicaciones";
	}

	private String _getWebURL() {
		return "http://www.esios.ree.es/";
	}

}