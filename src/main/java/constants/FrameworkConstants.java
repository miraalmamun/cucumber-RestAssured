package constants;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	

	private static final String USERDIR = System.getProperty("user.home");
	private static final String CONFIG_TEST_PROPERTY = USERDIR + "/src/test/resources/config.properties";
	private static final String LOGGING = "logging.txt";
	
	
	
	public static String getConfigTestProperty() {
		return CONFIG_TEST_PROPERTY;
	}



	public static String getLogging() {
		return LOGGING;
	}
	
	
	
	
	
}
