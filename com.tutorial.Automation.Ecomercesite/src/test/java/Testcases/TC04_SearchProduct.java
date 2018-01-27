package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ChildPages.IndexPage;
import ChildPages.ResultSearchPage;
import ChildPages.SignInPage;
import DataMapping.DataTC01_TestLogin;
import customizedLibrary.EnviromentSetting;
import customizedLibrary.PropertyUtility;

public class TC04_SearchProduct {
	WebDriver driver;	
	IndexPage indexPage;
	ResultSearchPage resultSearchPage;
	
	
	
	
	String emailLogin;
	String passwordLogin;
	
	
	@BeforeTest
	public void OpenURL() throws IOException {
		EnviromentSetting.setChromeDriverPath();
		driver = new ChromeDriver();
		driver.get(PropertyUtility.getBaseUrl());
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void searchAProduct() {
		System.out.println("test starting ========================");
		indexPage = new IndexPage(driver);
		indexPage.searchItem("Blouse");
		resultSearchPage= new ResultSearchPage(driver);
		Assert.assertTrue(resultSearchPage.itemIsFound(driver, "Blouse", "http://automationpractice.com/img/p/7/7-home_default.jpg", "$27.00"));
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("test done");
		//driver.quit();
	}
	
	public void initialDataForTest() throws IOException {
		
	}
	
}
