package ChildPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ResultSearchPage extends IndexPage{
	
	

	public ResultSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean itemIsFound(WebDriver driver, String itemName, String itemImage, String itemPrice) {
		List<WebElement> ls= new ArrayList<WebElement>();
		ls.add(driver.findElement(By.linkText(itemName)));
		ls.add(driver.findElement(By.xpath("//img[@src='"+itemImage+"']")));
		ls.add(driver.findElement(By.xpath("//span[text()='"+itemPrice+"']")));
		return pageShouldContainsElements(ls);
		
	}

}
