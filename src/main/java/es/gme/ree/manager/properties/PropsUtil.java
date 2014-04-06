package es.gme.ree.manager.properties;

public class PropsUtil {

	public static String get(String key) {
		return PropsImpl.getInstance().get(key);
	}

}