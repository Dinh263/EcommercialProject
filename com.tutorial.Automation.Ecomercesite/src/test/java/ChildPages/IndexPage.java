package ChildPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class IndexPage extends BasePage {

	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
	
	@FindBy(xpath="//a[@title='Log in to your customer account']")
	WebElement lnkSignIn;
	
	@FindBy(name="search_query")
	WebElement txtSearch;
	
	
	@FindBy(name="submit_search")
	WebElement btnSubmitSearch;
	
	
	public IndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickOnContactUsLink() {
		clickOnElement(lnkContactUs);
	}
	
	
	public void clickOnSignInLink() {
		clickOnElement(lnkSignIn);
	}
	
	public void searchItem(String searchItem) {
		enterTextOnElement(txtSearch, searchItem);
		clickOnElement(btnSubmitSearch);
	}
	
	
	
	public boolean sentRequestSuccessfully() {
		return pageShouldContainsText("Your message has been successfully sent to our team.");
	}
	
	
	

}
