package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import constants.FrameworkConstants;
import enums.ConfigProperties;

public final class PropertyUtils {
	
	/**
	 *  Hashtable is little slow but thread safe
	   Here Converting a property to HashMap
	   Please use getValueFromMap(String key) method rather then
	   getValueFromProperty(String key) Because HashMap is faster the Hashtable
	
	 */

	private PropertyUtils() {

	}

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {

		FileInputStream fis;
		try {
			fis = new FileInputStream(FrameworkConstants.getConfigTestProperty());
			property.load(fis);

			property.entrySet().forEach(
					entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));

		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}

	
	public static String getValueFromPropertyMap(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new NullPointerException("Property name " + key + " is not found. Please check config property file");
		}

		return CONFIGMAP.get(key.name().toLowerCase());
	}

	public static String getValueFromProperty(String key) {

		if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new NullPointerException("Property name " + key + " is not found. Please check config property file");
		}

		return property.getProperty(key);
	}

}
