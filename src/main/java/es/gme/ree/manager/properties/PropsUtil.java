package es.gme.ree.manager.properties;

public class PropsUtil {

	public static String get(String key) {
		return PropsImpl.getInstance().get(key);
	}

	public static int getInteger(String key) {
		return PropsImpl.getInstance().getInteger(key);
	}

}