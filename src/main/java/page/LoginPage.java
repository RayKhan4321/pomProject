package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	//creating a constructore to bridge the driver between loginPage class and loginTest class

	public LoginPage(WebDriver driver) {
		
		this.driver = driver; // to bridge the global webdriver driver
		//to this constructor webDriver driver  
	}
	
	
	
	//Elements list
	//WebElement User_Name_Element1 = driver.findElement(By.xpath("//*[@id=\"username\"]"));
	
	//NOTE: in POM we can not use WebElement or By class.
	// we use @FindBy class method,like @Findby(how = type, using = address) WebElement type name.
	//@FindBy is a WebElement type.
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]") WebElement User_Name_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement Password_Element;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement Signin_Element;
	
	
	
	//Corresponding methods.
	//Best method easy maintenances
	
	public void insertUserName(String username) {
		User_Name_Element.sendKeys(username);
	}

	public void insertPassword(String password) {
		Password_Element.sendKeys(password);
	}
	
	public void clickOnSigninButton() {
		Signin_Element.click();
	}//it was making individual methods for each element
	
	//Below is a different way of combining all the elements function in one method 
	public void login(String username, String password) {
		User_Name_Element.sendKeys(username);
		Password_Element.sendKeys(password);
		Signin_Element.click();
	}
	
}
