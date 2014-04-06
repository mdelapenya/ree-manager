package es.gme.ree.manager.url;

import es.gme.ree.manager.properties.PropsValues;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ReeURLBuilderImpl implements ReeURLBuilder {

	public ReeURLBuilderImpl(int month, int year) {
		this(new ReeURLContext(month, year));
	}

	public ReeURLBuilderImpl(ReeURLContext reeURLContext) {
		_reeURLContext = reeURLContext;
	}

	public String getURL() throws IllegalArgumentException {
		_validateContext();

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

		sb.append("?");
		sb.append(PropsValues.REE_APPLICATION_FILENAME_PARAM);
		sb.append("=C");
		sb.append(_reeURLContext.getcType());
		sb.append("_");
		sb.append(_reeURLContext.getFileName());
		sb.append("_");
		sb.append(_reeURLContext.getYear());
		sb.append(strMonth);

		return sb.toString();
	}

	private String _getFileType() {
		return "&" + PropsValues.REE_APPLICATION_FILETYPE_PARAM + "=" + _reeURLContext.getFileType();
	}

	private String _getLanguage() {
		return "&" + PropsValues.REE_APPLICATION_LANGUAGE_PARAM + "=" + _reeURLContext.getLanguage();
	}

	private String _getRequestType() {
		return "&" + PropsValues.REE_APPLICATION_REQUESTTYPE_PARAM + "=" + _reeURLContext.getRequestType();
	}

	private String _getWebURL() {
		return PropsValues.REE_URL_BASE;
	}

	private void _validateContext() {
		if ((_reeURLContext.getMonth() < 1) || (_reeURLContext.getMonth() > 12)) {
			throw new IllegalArgumentException("An invalid month has been introduced.");
		}
	}

	private ReeURLContext _reeURLContext;

}