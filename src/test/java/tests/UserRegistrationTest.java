package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String email = "omarsa861278@yahoo.com";
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration("Omar", "Saad", email, "O1234mar");
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogin() {
		registerObject.userLogin();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, "O1234mar");
		
		Assert.assertTrue(loginObject.logoutLink.isDisplayed());
	}
	
}






