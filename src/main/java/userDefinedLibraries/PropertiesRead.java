package userDefinedLibraries;

import java.util.Properties;


public class PropertiesRead {

	public static Properties prop= PropertiesLoad.readPropertiesFile();
    
	public static  String getUrl() {
		return prop.getProperty("url");
	}
	
	public static String getBrowser() {
		return prop.getProperty("browser");
	}
	
}