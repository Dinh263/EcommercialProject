package Testcases;

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

public class TestSignUpAnAccount  {
	WebDriver driver;	
	IndexPage indexPage;
	SignUpAnAccount signUpAccountPage;
	SignUpAccountDetail signUpDetailPage;
	MyAccountPage myAccountPage;
	
	
	@BeforeTest
	public void OpenURL() {
		setConfigurationEnv();
		driver.get("http://automationpractice.com/index.php");
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
	
	private void setConfigurationEnv() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/chromedriver.exe" );
		driver = new ChromeDriver();
	}
}
