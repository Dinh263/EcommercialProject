package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ChildPages.IndexPage;
import ChildPages.MyAccountPage;
import ChildPages.SignUpAccountDetail;
import ChildPages.SignUpAnAccount;
import customizedLibrary.EnviromentSetting;
import customizedLibrary.PropertyUtility;

public class TC03_TestSignUpAnAccount  {
	WebDriver driver;	
	IndexPage indexPage;
	SignUpAnAccount signUpAccountPage;
	SignUpAccountDetail signUpDetailPage;
	MyAccountPage myAccountPage;
	
	
	@BeforeTest
	public void OpenURL() throws IOException {
		EnviromentSetting.setChromeDriverPath();
		driver = new ChromeDriver();
		driver.get(PropertyUtility.getBaseUrl());
		driver.manage().window().maximize();
	}
	
	@Test
	public void signUpNewAccount() {
		System.out.println("test starting ========================");
		indexPage = new IndexPage(driver);
		indexPage.clickOnSignInLink();
		signUpAccountPage = new SignUpAnAccount(driver);
		signUpAccountPage.createNewAccount("user10011@gmail.com");
		signUpDetailPage = new SignUpAccountDetail(driver);
		signUpDetailPage.createAnAccount(true, "Dinh", "Nguyen", "123456789", "10", "3", "1995", false, false, "David", "Smart", "Amdocs", "12 cong quynh", "36 le lai", "Ho chi minh", "2", "66006", "United States", "testing", "8572073900", "09876876876", "user11@gmail.com");
		myAccountPage= new MyAccountPage(driver);
		Assert.assertTrue(myAccountPage.isCreateAccountSuccessfully());
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("test done");
		driver.quit();
	}
	
	
}
