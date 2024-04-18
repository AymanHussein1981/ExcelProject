package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	

	ExcelReader exlReader = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
//	ExcelReader exlReader = new ExcelReader("\\testData\\TF_TestData.xlsx");
	
	
	String userName=exlReader.getCellData("LoginInfo", "UserName", 2);
	String password=exlReader.getCellData("LoginInfo", "Password", 2);
	
	String dashboardHeaderText=exlReader.getCellData("DashboardInfo","DashboardHeader", 2);
	
	String addCustomerHeaderText=exlReader.getCellData("AddContactInfo","AddContactValidationText", 2);
	String fullName=exlReader.getCellData("AddContactInfo","FullName", 2);
	String company=exlReader.getCellData("AddContactInfo","CompanyName", 2);
	String email=exlReader.getCellData("AddContactInfo","Email", 2);
	String phone=exlReader.getCellData("AddContactInfo","Phone", 2);
	String city=exlReader.getCellData("AddContactInfo","City", 2);
	String zip=exlReader.getCellData("AddContactInfo","Zip", 2);
	String country=exlReader.getCellData("AddContactInfo","Country", 2);

	 
	
	@Test
	public void UserShouldBeAbleToAddCustomer()  {
		
		driver=BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clicSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardHeaderText);
		
		
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();
		
		
		AddCustomerPage addcustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerPage.validateAddCustomerPage(addCustomerHeaderText);
		addcustomerPage.insertFullNAme(fullName);
		addcustomerPage.selectCompany(company);
		addcustomerPage.insertEmail(email);
		addcustomerPage.insertPhone(phone);
		addcustomerPage.insertCity(city);
		addcustomerPage.insertZip(zip);
		addcustomerPage.selectCountry(country);
		addcustomerPage.clickSaveButton();
		
		
		
	
		
	
	}
	


}
