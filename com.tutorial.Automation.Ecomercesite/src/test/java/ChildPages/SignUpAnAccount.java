package ChildPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ChildPages.IndexPage;

public class SignUpAnAccount extends IndexPage {

	@FindBy(name="email_create")
	WebElement txtEmailSignUp;
	
	@FindBy(id="SubmitCreate")
	WebElement btnSubmit;
	
	
	
	
	public SignUpAnAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void createNewAccount(String emailRegister) {
		enterTextOnElement(txtEmailSignUp, emailRegister);
		clickOnElement(btnSubmit);
	}
	
	
	
	
	
}
