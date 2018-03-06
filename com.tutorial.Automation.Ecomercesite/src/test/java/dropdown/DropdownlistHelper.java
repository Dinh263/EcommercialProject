package dropdown;



import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownlistHelper {
	private WebDriver driver;
	public DropdownlistHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectUsingVisibleText(WebElement element, String visibleText) {
		Select select = new Select (element);
		select.selectByVisibleText(visibleText);
	}
	
	public void selectUsingValuex(WebElement element, String value) {
		Select select = new Select (element);
		select.selectByValue(value);;
	}
	
	public String getSelectedValue(WebElement element) {
		Select select = new Select (element);
		return select.getFirstSelectedOption().getText();
	}
	
	
	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select (element);
		select.selectByIndex(index);
	}
	
	public List<String> getAllDropDownValues(WebElement element){
		Select select = new Select (element);
		List<WebElement> elementlist = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for(WebElement element:elementlist) {
			valueList.add(element.getText());
		}
		return valueList;
	}
	
	
	
	
	
	
}
