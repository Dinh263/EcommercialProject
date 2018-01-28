package Testcases;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestBase.TestBase;
import customizedLibrary.EnviromentSetting;
import customizedLibrary.PropertyUtility;



public class testcase extends TestBase {
	@BeforeTest
	public void OpenURL() throws IOException {
		EnviromentSetting.setChromeDriverPath();
		driver = new ChromeDriver();
		driver.get(PropertyUtility.getBaseUrl());
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testFaile() {
		Assert.assertTrue(false);
	}
	
	
}
