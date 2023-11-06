
package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationJSON extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws IOException, ParseException {
		
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(jsonReader.fname, jsonReader.lname, jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		
		registerObject.userLogin();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(loginObject.logoutLink.isDisplayed());
		loginObject.logOut();
	}
	
	
}


