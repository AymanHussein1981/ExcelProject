 package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class AddCustomerPage extends BasePage{
	
	
	WebDriver driver;
	

	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong") WebElement addCustomerHeaderElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[1]/div/input") WebElement FullNameElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[2]/div/select") WebElement CompanyDropDownElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[3]/div/input") WebElement EmailElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"phone\"]") WebElement PhoneElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[6]/div/input") WebElement CityElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"port\"]") WebElement ZipElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[8]/div[1]/select") WebElement CountryElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"save_btn\"]") WebElement SaveButtonElement;
	
	
	public void validateAddCustomerPage(String addCustomerHeaderText) {
		
		Assert.assertEquals(addCustomerHeaderElement.getText(), addCustomerHeaderText, "addCustomer page did not found");
	}
	
	public void insertFullNAme(String fullName) {
		String insertedName = fullName + generateRandomNum(999);
		FullNameElement.sendKeys(insertedName);
	}
	
	
	public void selectCompany(String visibleText) {
		selectFromDropdown(CompanyDropDownElement, visibleText);
	}
	
	
	public void insertEmail(String email) {
		EmailElement.sendKeys(generateRandomNum(999)+email);
	}
	
	public void insertPhone(String phone) {
		PhoneElement.sendKeys(phone+generateRandomNum(999));
	}
	
	
	public void insertCity(String city) {
		CityElement.sendKeys(city);
	}
	
	public void insertZip(String zip) {
		ZipElement.sendKeys(zip);
	}
	
	public void selectCountry(String country) {
		selectFromDropdown(CountryElement, country);
	}
	
	public void clickSaveButton() {
	SaveButtonElement.click();	
	}
	
	
	
	
	

	


}
