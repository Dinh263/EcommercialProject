package ChildPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends IndexPage {
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="email")
	WebElement txtEmailLogin;
	
	@FindBy(name="passwd")
	WebElement txtPassword;
	
	@FindBy(name="SubmitLogin")
	WebElement btnLogin;
	
	
	public void signInAccount(String email, String password) {
		enterTextOnElement(txtEmailLogin, email);
		enterTextOnElement(txtPassword, password);
		clickOnElement(btnLogin);
	}
	
	public boolean isLoginSuccessful() {
		return true;
	}
}
