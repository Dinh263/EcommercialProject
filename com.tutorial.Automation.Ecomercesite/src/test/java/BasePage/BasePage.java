package BasePage;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 120);
	}
	protected void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	protected void enterTextOnElement(WebElement element, String text) {
		//waitForElement(element);
		element.clear();
		element.sendKeys(text);
	}
	
	protected void clickOnElement(WebElement element) {
		waitForElement(element);
		element.click();
	}
	
	protected void clickOnElementWithoutWait(WebElement element) {
		element.click();
	}
	
	protected void selectTextFromDropDown(WebElement element, String text) {
		//waitForElement(element);
		Select ddownList = new Select(element);
		ddownList.selectByVisibleText(text);
	}
	
	protected void selectValueFromDropDown(WebElement element, String value) {
		//waitForElement(element);
		Select ddownList = new Select(element);
		ddownList.selectByValue(value);
	}
	
	protected void uploadFile(WebElement element, String fileName) {
		//enterTextOnElement(element, fileName);
		element.sendKeys(fileName);
	}
	
	protected boolean pageShouldContainsText(String text) {
		return driver.getPageSource().contains(text);
	}
	
	protected boolean pageShouldContainsElement(WebElement element) {
		boolean exist = false;
		try {
			waitForElement(element);
			exist=true;
		}catch(NoSuchElementException e) {
			System.out.println("Element not found");
		}
		return exist;
	}
	
	protected boolean pageShouldContainsElements(List<WebElement> elements) {
		boolean exist = false;
		try {
			for(WebElement e : elements) {
				waitForElement(e);
			}
			exist=true;
		}catch(NoSuchElementException e) {
			System.out.println("Element not found");
		}
		return exist;
	}

}
