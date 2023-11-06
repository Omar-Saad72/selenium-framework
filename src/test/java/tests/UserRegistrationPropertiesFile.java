package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationPropertiesFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
//	String email = "omarsa8678@yahoo.com";
	
	String fname = LoadProperties.userData.getProperty("firstname");
	String lname = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(fname, lname, email, password);
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogin() {
		registerObject.userLogin();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		
		Assert.assertTrue(loginObject.logoutLink.isDisplayed());
	}
	
}
