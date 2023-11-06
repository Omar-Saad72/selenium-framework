package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationDataProvider extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String email = "omarsa8678@yahoo.com";
	
	@DataProvider(name="TestData")
	public static Object [][] userData(){
		return new Object [][] {
			{"Omar","Saad","testxxx6@gmail.com","123456"},
			{"Omar","Saad","testxxx7@gmail.com","123456"}
			};
	}
	
	@Test(priority = 1,alwaysRun = true,dataProvider = "TestData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String mail, String password) {
		
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(fname,lname,mail,password);
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		registerObject.userLogin();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(mail, password);
		Assert.assertTrue(loginObject.logoutLink.isDisplayed());
		loginObject.logOut();
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"},enabled=false)
	public void RegisteredUserCanLogin() {
		registerObject.userLogin();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, "O1234mar");
		
		Assert.assertTrue(loginObject.logoutLink.isDisplayed());
	}
	
}
