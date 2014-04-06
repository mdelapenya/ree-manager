package es.gme.ree.manager.url;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ReeURLBuilderImpl implements ReeURLBuilder {

	public ReeURLBuilderImpl() {
		this(new ReeURLContext());
	}

	public ReeURLBuilderImpl(int month, int year) {
		this(new ReeURLContext(month, year));
	}

	public ReeURLBuilderImpl(ReeURLContext reeURLContext) {
		_reeURLContext = reeURLContext;
	}

	public String getURL(int month, int year) throws IllegalArgumentException {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("An invalid month has been introduced.");
		}

		String fullUrl =
			_getWebURL() + _getApplicationURL() + _getFileName() + _getFileType() + _getLanguage() +
			_getRequestType();

		return fullUrl;
	}

	private String _getApplicationURL() {
		return "Solicitar";
	}

	private String _getFileName() {
		String strMonth = "";

		int month = _reeURLContext.getMonth();

		if (month < 10) {
			strMonth += "0";
		}

		strMonth += month;

		StringBuilder sb = new StringBuilder();

		sb.append("?fileName=");
		sb.append("C");
		sb.append(_reeURLContext.getcType());
		sb.append("_");
		sb.append(_reeURLContext.getFileName());
		sb.append("_");
		sb.append(_reeURLContext.getYear());
		sb.append(strMonth);

		return sb.toString();
	}

	private String _getFileType() {
		return "&fileType=" + _reeURLContext.getFileType();
	}

	private String _getLanguage() {
		return "&idioma=" + _reeURLContext.getLanguage();
	}

	private String _getRequestType() {
		return "&tipoSolicitar=" + _reeURLContext.getRequestType();
	}

	private String _getWebURL() {
		return "http://www.esios.ree.es/";
	}

	private ReeURLContext _reeURLContext;

}