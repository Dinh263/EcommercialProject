package ChildPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends IndexPage {

	@FindBy(xpath="//select[@id='id_contact']")
	WebElement ddownSubjectHeader;
	
	@FindBy(id="email")
	WebElement txtEmail;
	
	
	@FindBy(id="id_order")
	WebElement txtOrderId;
	
	@FindBy(id="fileUpload")
	WebElement upload;
	
	@FindBy(id="message")
	WebElement txtMessage;
	
	@FindBy(id="submitMessage")
	WebElement btnSubmit;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private void selectSubjectHeader(String subject) {
		selectTextFromDropDown(ddownSubjectHeader, subject);
	}
	
	private void inputEmail(String email) {
		enterTextOnElement(txtEmail, email);
	}
	
	private void inputOrderId(String orderId) {
		enterTextOnElement(txtOrderId, orderId);
	}
	
	private void attachFile(String fileName) {
		uploadFile(upload, fileName);
	}
	
	private void inputMessaage(String message) {
		enterTextOnElement(txtMessage, message);
	}
	
	private void clickSubmitButton() {
		clickOnElement(btnSubmit);
	}
	
	public void sendARequest(String subject, String email, String orderId, String fileName, String message)
	{
		selectSubjectHeader(subject);
		inputEmail(email);
		inputOrderId(orderId);
		attachFile(fileName);
		inputMessaage(message);
		clickSubmitButton();		
	}
	
	public void sendARequest(String subject, String email, String orderId, String message)
	{
		selectSubjectHeader(subject);
		inputEmail(email);
		inputOrderId(orderId);
		inputMessaage(message);
		clickSubmitButton();		
	}
	
	
	
	
	

}
