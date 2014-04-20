package es.gme.ree.manager.properties;

public class PropsUtil {

	public static String get(String key) {
		return PropsImpl.getInstance().get(key);
	}

	public static String[] getArray(String keys) {
		return PropsImpl.getInstance().getStringArray(keys);
	}

	public static int getInteger(String key) {
		return PropsImpl.getInstance().getInteger(key);
	}

}