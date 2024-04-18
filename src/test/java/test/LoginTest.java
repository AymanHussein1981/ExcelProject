package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	

	ExcelReader exlReader = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
//	ExcelReader exlReader = new ExcelReader("\\testData\\TF_TestData.xlsx");
	
	
	String userName=exlReader.getCellData("LoginInfo", "UserName", 2);
	String password=exlReader.getCellData("LoginInfo", "Password", 2);
	
	String dashboardHeaderText=exlReader.getCellData("DashboardInfo","DashboardHeader", 2);
	
	String userNameAlertMsg=exlReader.getCellData("LoginInfo", "alertUserValidationText", 2);
	String passwordAlertMsg=exlReader.getCellData("LoginInfo", "alertPasswordValidationText", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin()  {
		
		driver=BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clicSigninButton();
		
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardHeaderText);
		
//		Assert.assertEquals(dashboardPage.validateDashboardPageText(), dashboardHeaderText, "Dashboard page did not found");
		
		BrowserFactory.tearDown();

	}
	
	
	@Test
	public void validateAlertMsg() {
		
		driver=BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clicSigninButton();
		loginPage.validateUserErrorMsg(userNameAlertMsg);
		
		loginPage.insertUserName(userName);
		loginPage.clicSigninButton();
		loginPage.validatePasswordErrorMsg(passwordAlertMsg);
		
		BrowserFactory.tearDown();
	} 
	
	

}
