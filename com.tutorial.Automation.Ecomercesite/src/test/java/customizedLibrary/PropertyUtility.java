package customizedLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtility {
	
	private static Properties getProperty() throws IOException{
		Properties prop= new Properties();
		String fileName = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		InputStream inputStr=new FileInputStream(fileName);
		prop.load(inputStr);
		return prop;
	}
	
	/**
	 * this function is used for getting the value GeckoDriverPath in the property file.
	 * @return
	 * @throws IOException
	 */
	public static String getGeckoDriverPath() throws IOException{
		Properties prop=PropertyUtility.getProperty();
		return System.getProperty("user.dir")+prop.getProperty("GeckoDriverPath");
	}
	
	public static String getChromeDriverPath() throws IOException{
		Properties prop=PropertyUtility.getProperty();
		return System.getProperty("user.dir")+prop.getProperty("ChromeDriverPath");
	}
	
	/**
	 * this function is used for gettign the value user.dir in the property file
	 * @return
	 * @throws IOException
	 */
	public static String getDataFileNameWithPath() throws IOException{
		Properties prop=PropertyUtility.getProperty();
		return System.getProperty("user.dir")+prop.getProperty("DataFileName");
	}
	
	public static String getBaseUrl() throws IOException {
		Properties prop=PropertyUtility.getProperty();
		return prop.getProperty("baseUrl");
	}

}