package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationJavaFaker extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String fname = fakeData.name().firstName();
	String lname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	
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






