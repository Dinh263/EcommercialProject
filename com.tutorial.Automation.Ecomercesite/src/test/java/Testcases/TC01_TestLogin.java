package Testcases;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ChildPages.IndexPage;
import ChildPages.SignInPage;
import DataMapping.DataTC01_TestLogin;
import TestBase.TestBase;
import customizedLibrary.EnviromentSetting;
import customizedLibrary.PropertyUtility;

public class TC01_TestLogin extends TestBase {
	
	IndexPage indexPage;
	SignInPage signInpage;
	
	
	DataTC01_TestLogin data;
	
	
	String emailLogin;
	String passwordLogin;
	
	
	@BeforeTest
	public void OpenURL() throws IOException {
		EnviromentSetting.setChromeDriverPath();
		driver = new ChromeDriver();
		driver.get(PropertyUtility.getBaseUrl());
		driver.manage().window().maximize();
		initialDataForTest();
	}
	
	@Test
	public void loginToAccount() {
		System.out.println("test starting ========================");
		indexPage = new IndexPage(driver);
		indexPage.clickOnSignInLink();
		signInpage = new SignInPage(driver);
		signInpage.signInAccount(emailLogin,passwordLogin);
		Assert.assertTrue(signInpage.isLoginSuccessful());
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("test done");
		driver.quit();
	}
	
	public void initialDataForTest() throws IOException {
		data = new DataTC01_TestLogin(PropertyUtility.getDataFileNameWithPath());
		emailLogin=data.getEmailLogin();
		passwordLogin=data.getPasswordLogin();
	}
	
	
}
