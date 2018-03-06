package customizedLibrary;

import java.io.IOException;

public class EnviromentSetting {
	
	public static void setGeckoDriverPath() throws IOException {
		System.setProperty("webdriver.gecko.driver", PropertyUtility.getGeckoDriverPath());
	}
	
	public static void setChromeDriverPath() throws IOException {
		System.setProperty("webdriver.chrome.driver", PropertyUtility.getChromeDriverPath());
	}
	
	
}
