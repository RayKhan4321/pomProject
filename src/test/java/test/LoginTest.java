package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init(); // bridging the driver in init method.\
		// to driver in this class.
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		//PageFactory is able to transfer the driver from this LoginTest class
		//to loginPage class
		loginPage.insertUserName("demo@techfios.com");
		
		loginPage.insertPassword("abc123");
		loginPage.clickOnSigninButton();
		
		//creating page object model object. by using PageFactory class
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifiedDashboardPage("Dashboard");
		
		BrowserFactory.tearDown();
		
	}
}
