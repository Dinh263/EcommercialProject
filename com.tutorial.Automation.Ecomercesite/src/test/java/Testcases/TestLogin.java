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
import customizedLibrary.EnviromentSetting;
import customizedLibrary.PropertyUtility;

public class TestLogin {
	WebDriver driver;	
	IndexPage indexPage;
	SignInPage signInpage;
	
	
	@BeforeTest
	public void OpenURL() throws IOException {
		EnviromentSetting.setChromeDriverPath();
		driver = new ChromeDriver();
		driver.get(PropertyUtility.getBaseUrl());
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginToAccount() {
		System.out.println("test starting ========================");
		indexPage = new IndexPage(driver);
		indexPage.clickOnSignInLink();
		signInpage = new SignInPage(driver);
		signInpage.signInAccount("user10011@gmail.com", "123456789");
		Assert.assertTrue(signInpage.isLoginSuccessful());
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("test done");
		driver.quit();
	}
	
	
}
