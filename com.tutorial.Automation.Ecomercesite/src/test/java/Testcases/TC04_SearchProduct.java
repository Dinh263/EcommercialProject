package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ChildPages.IndexPage;
import ChildPages.ResultSearchPage;
import DataMapping.DataTC04_SearchProduct;
import TestBase.TestBase;
import customizedLibrary.EnviromentSetting;
import customizedLibrary.PropertyUtility;

public class TC04_SearchProduct extends TestBase {

	IndexPage indexPage;
	ResultSearchPage resultSearchPage;
	
	DataTC04_SearchProduct data;
	
	String itemSearch;
	String sourceImage;
	String itemPrice;
	
	
	@BeforeTest
	public void OpenURL() throws IOException {
		EnviromentSetting.setChromeDriverPath();
		driver = new ChromeDriver();
		driver.get(PropertyUtility.getBaseUrl());
		driver.manage().window().maximize();
		initialDataForTest();
	}
	
	@Test
	public void searchAProduct() {
		System.out.println("test starting ========================");
		indexPage = new IndexPage(driver);
		indexPage.searchItem(itemSearch);
		resultSearchPage= new ResultSearchPage(driver);
		Assert.assertTrue(resultSearchPage.itemIsFound(driver, itemSearch, sourceImage, itemPrice));
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("test done");
		driver.quit();
	}
	
	public void initialDataForTest() throws IOException {
		data= new DataTC04_SearchProduct(PropertyUtility.getDataFileNameWithPath());
		itemSearch = data.getItemSearchName();
		sourceImage = data.getItemImageSource();
		itemPrice = data.getItemPrice();
		
	}
	
}
