package ChildPages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends IndexPage {
	
	

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isCreateAccountSuccessfully() {
		return pageShouldContainsText("Welcome to your account. Here you can manage all of your personal information and orders.");
	}
	
	public boolean isLoginInSuccessfully() {
		return pageShouldContainsText("Welcome to your account. Here you can manage all of your personal information and orders.");
	}

}
