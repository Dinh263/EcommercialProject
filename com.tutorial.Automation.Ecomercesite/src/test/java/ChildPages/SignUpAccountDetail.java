package ChildPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpAccountDetail extends IndexPage {
	
	@FindBy(id="id_gender1")
	WebElement rdioMale;

	@FindBy(id="id_gender2")
	WebElement rdioFemale;
	
	@FindBy(name="customer_firstname")
	WebElement txtFirstName;
	
	@FindBy(name="customer_lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="passwd")
	WebElement txtPassword;
	
	@FindBy(name="days")
	WebElement ddListDays;
	
	@FindBy(name="months")
	WebElement ddListMonths;
	
	@FindBy(name="years")
	WebElement ddListYears;
	
	@FindBy(xpath="//div[@id='uniform-newsletter']/span/input")
	WebElement chkboxNewLetter;
	
	@FindBy(id="optin")
	WebElement chkboxOffer;
	
	@FindBy(name="firstname")
	WebElement txtAddressFirstName;
	
	@FindBy(name="lastname")
	WebElement txtAddressLastName;
	
	@FindBy(name="company")
	WebElement txtCompanyName;
	
	@FindBy(name="address1")
	WebElement txtAdress1;
	
	@FindBy(name="address2")
	WebElement txtAdress2;
	
	@FindBy(id="city")
	WebElement txtCity;
	
	
	@FindBy(id="id_state")
	WebElement ddListState;
	
	@FindBy(id="postcode")
	WebElement txtPostcode;
	
	@FindBy(id="id_country")
	WebElement ddListCountry;
	
	@FindBy(id="other")
	WebElement txtOther;
	
	@FindBy(id="phone")
	WebElement txtHomePhone;
	
	@FindBy(name="phone_mobile")
	WebElement txtMobilePhone;
	
	
	@FindBy(id="alias")
	WebElement txtAddressAlias;
	
	@FindBy(id="submitAccount")
	WebElement btnSubmitAccount;
	
	public SignUpAccountDetail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	private void inputPersonalInformation(boolean gender, 
			String personalFirstName, 
			String personalLastName, 
			String password,
			String day,
			String month,
			String year,
			boolean newletter,
			boolean receiveoffer
			) {
		if(gender==true) {
			clickOnElement(rdioMale);
		}
		else {
			clickOnElement(rdioFemale);
		}
		
		enterTextOnElement(txtFirstName, personalFirstName);
		enterTextOnElement(txtLastName, personalLastName);
		enterTextOnElement(txtPassword, password);
		selectValueFromDropDown(ddListDays, day);
		selectValueFromDropDown(ddListMonths, month);
		selectValueFromDropDown(ddListYears, year);
		if(newletter==true) {
			clickOnElementWithoutWait(chkboxNewLetter);
		}
		if(receiveoffer==true) {
			clickOnElementWithoutWait(chkboxOffer);
		}
	}
	
	private void inputPersonalAddress(String addFirstName, 
			String addLastName, String company, 
			String address1,
			String address2,
			String city,
			String state,
			String zipcode,
			String country,
			String additionalInfo,
			String phone,
			String mobilephone,
			String aliasEmail) {
		enterTextOnElement(txtAddressFirstName, addFirstName);
		enterTextOnElement(txtAddressLastName, addLastName);
		enterTextOnElement(txtCompanyName, company);
		enterTextOnElement(txtAdress1, address1);
		enterTextOnElement(txtAdress2, address2);
		enterTextOnElement(txtCity, city);
		selectValueFromDropDown(ddListState, state);
		enterTextOnElement(txtPostcode, zipcode);
		selectTextFromDropDown(ddListCountry, country);
		enterTextOnElement(txtOther, additionalInfo);
		enterTextOnElement(txtHomePhone, phone);
		enterTextOnElement(txtMobilePhone, mobilephone);
		enterTextOnElement(txtAddressAlias, aliasEmail);
		clickOnElement(btnSubmitAccount);
	}
	
	public void createAnAccount(boolean gender, 
			String personalFirstName, 
			String personalLastName, 
			String password,
			String day,
			String month,
			String year,
			boolean newletter,
			boolean receiveoffer,
			String addFirstName, 
			String addLastName,
			String company,
			String address1,
			String address2,
			String city,
			String state,
			String zipcode,
			String country,
			String additionalInfo,
			String phone,
			String mobilephone,
			String aliasEmail) {
		inputPersonalInformation(gender, personalFirstName, personalLastName, password, day, month, year, newletter, receiveoffer);
		//inputPersonalAddress(addFirstName, addLastName, company, address1, address2, city, state, zipcode, country, additionalInfo, phone, mobilephone, aliasEmail);
	}
	
	public void signuptesting() {
		chkboxNewLetter.click();
	}
	
	

}
