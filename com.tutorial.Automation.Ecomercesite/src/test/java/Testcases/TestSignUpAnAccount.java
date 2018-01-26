package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ChildPages.ContactUsPage;
import ChildPages.IndexPage;
import ChildPages.SignUpAnAccount;

public class TestSignUpAnAccount  {
	WebDriver driver;	
	IndexPage indexPage;
	SignUpAnAccount signUpAccountPage;
	
	
	
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
		signUpAccountPage.createNewAccount("user10001@gmail.com");
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
