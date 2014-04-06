package es.gme.ree.manager.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class PropsImpl {

	public static PropsImpl getInstance() {
		if (_instance == null) {
			_instance = new PropsImpl();
		}

		return _instance;
	}

	public String get(String key) {
		if (!_props.containsKey(key)) {
			throw new IllegalArgumentException("Property is not present");
		}

		return _props.getProperty(key);
	}

	private PropsImpl() {
		try {
			InputStream is = getClass().getResourceAsStream("/ree.properties");

			_props = new Properties();
			_props.load(is);

			is = getClass().getResourceAsStream("/ree-ext.properties");

			_props.load(is);
		}
		catch (IOException ioe) {
			throw new RuntimeException("Configuration file not found on classpath");
		}
	}

	private static PropsImpl _instance;
	private static Properties _props;

}