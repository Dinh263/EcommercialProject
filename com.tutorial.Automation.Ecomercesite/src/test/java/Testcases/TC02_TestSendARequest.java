package Testcases;

import java.io.IOException;
import java.time.temporal.IsoFields;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ChildPages.ContactUsPage;
import ChildPages.IndexPage;
import DataMapping.DataTC02_TestSendARequest;
import TestBase.TestBase;
import customizedLibrary.EnviromentSetting;
import customizedLibrary.PropertyUtility;

public class TC02_TestSendARequest extends TestBase {
	

	IndexPage indexPage;
	ContactUsPage contactUsPage;
	
	DataTC02_TestSendARequest data;
	
	String subject;
	String email;
	String orderId;
	boolean isFileAttached;
	String fileName;
	String message;
	
	
	@BeforeTest
	public void OpenURL() throws IOException {
		initiateDataForTesting();
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
		if(isFileAttached) {
			contactUsPage.sendARequest(subject, email, orderId, fileName, message);
		}
		else {
			contactUsPage.sendARequest(subject, email, orderId, message);
		}
		Assert.assertTrue(indexPage.sentRequestSuccessfully());
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("test done");
		driver.quit();
	}
	
	public void initiateDataForTesting() throws IOException {
		data = new DataTC02_TestSendARequest(PropertyUtility.getDataFileNameWithPath());
		subject = data.getSubject();
		email = data.getEmail();
		orderId = data.getOrderID();
		isFileAttached = data.getAttacheFile().equals("Yes")? true:false;
		if(isFileAttached) {
			fileName = data.getFileNameAttached();
		}else {
			fileName= " ";
		}
		message = data.getMessage();
		
	}
	
}
