package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ChildPages.IndexPage;
import ChildPages.SignInPage;

public class TestLogin {
	WebDriver driver;	
	IndexPage indexPage;
	SignInPage signInpage;
	
	
	@BeforeTest
	public void OpenURL() {
		setConfigurationEnv();
		driver.get("http://automationpractice.com/index.php");
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
		//driver.quit();
	}
	
	private void setConfigurationEnv() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/chromedriver.exe" );
		driver = new ChromeDriver();
	}
}
