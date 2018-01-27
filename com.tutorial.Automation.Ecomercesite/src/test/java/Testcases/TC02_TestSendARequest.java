package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ChildPages.ContactUsPage;
import ChildPages.IndexPage;
import customizedLibrary.EnviromentSetting;
import customizedLibrary.PropertyUtility;

public class TC02_TestSendARequest {
	
	WebDriver driver;	
	IndexPage indexPage;
	ContactUsPage contactUsPage;
	
	
	@BeforeTest
	public void OpenURL() throws IOException {
		EnviromentSetting.setChromeDriverPath();
		driver = new ChromeDriver();
		driver.get(PropertyUtility.getBaseUrl());
		driver.manage().window().maximize();
	}
	
	@Test
	public void sendARequest() {
		System.out.println("test starting ========================");
		indexPage = new IndexPage(driver);
		indexPage.clickOnContactUsLink();
		contactUsPage = new ContactUsPage(driver);
		contactUsPage.sendARequest("Customer service", "user32@gmail.com", "100012", "C:/testing.txt", "testing message");
		Assert.assertTrue(indexPage.sentRequestSuccessfully());
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("test done");
		driver.quit();
	}
	
	
}