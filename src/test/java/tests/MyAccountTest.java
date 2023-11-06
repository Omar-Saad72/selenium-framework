package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	
	String firstName = "Omar";
	String lastName = "Saad";
	String email = "omarsaad95@yahoo.com";
	String oldPassword = "O1234mar";
	String newPassword = "123456";
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, oldPassword);
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogin() {
		registerObject.userLogin();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, oldPassword);
		
		Assert.assertTrue(loginObject.logoutLink.isDisplayed());
		
		loginObject.openMyAccount();
	}

	@Test(dependsOnMethods = {"RegisteredUserCanLogin"})
	public void RegisteredUserCanChangePassword() {
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openChangePasswordPage();
		myAccountObject.changePassword(oldPassword, newPassword);
		
		Assert.assertTrue(myAccountObject.resultOfChange.getText().contains("Password was changed"));
		
	
		myAccountObject.userLogout(driver);

	}
	
	@Test(dependsOnMethods = {"RegisteredUserCanChangePassword"})
	public void RegisteredUserCanLogin2() {
		registerObject.userLogin();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);

		Assert.assertTrue(loginObject.logoutLink.isDisplayed());
	}
}
