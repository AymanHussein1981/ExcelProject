 package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage extends BasePage{
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Atributes
	
	@FindBy(how = How.XPATH, using="//*[@id=\"user_name\"]") WebElement userNameElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"password\"]") WebElement passwordElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"login_submit\"]") WebElement signinButtonElement;
	
	
	
	//Methods
	
	//Indiviual
	public void insertUserName(String userName) {
		userNameElement.sendKeys(userName);
	}
	
	
	public void insertPassword(String password) {
		passwordElement.sendKeys(password);
	}


	public void clicSigninButton() {
		signinButtonElement.click();
	}
	
	
	public void validateUserErrorMsg(String expectedAlertMsg) {
		String actualAlertMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertMsg, expectedAlertMsg, "username error msg do not match");
		driver.switchTo().alert().accept();
	}
	
	
	public void validatePasswordErrorMsg(String expectedAlertMsg) {
		String actualAlertMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(actualAlertMsg, expectedAlertMsg, "password error msg do not match");
		driver.switchTo().alert().accept();
	}


}
