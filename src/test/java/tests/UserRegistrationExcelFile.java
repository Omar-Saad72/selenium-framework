package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationExcelFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
//	String email = "omarsa8678@yahoo.com";
	
	
	@DataProvider(name="ExcelData")
	public Object [][] userRegisterData() throws IOException{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	
	@Test(priority = 1,alwaysRun = true,dataProvider = "ExcelData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password) {
		
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(fname, lname, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		
		registerObject.userLogin();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(loginObject.logoutLink.isDisplayed());
		loginObject.logOut();
		
	}
	
}
