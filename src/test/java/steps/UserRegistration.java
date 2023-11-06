package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase
{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	@Given("The User is in the Home Page")
	public void the_user_is_in_the_home_page() {
		loginObject = new LoginPage(driver);
		loginObject.logOut();
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
	}
	@When("I click on regsiter Link")
	public void i_click_on_regsiter_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
	@When("I entered {string}, {string}, {string}, {string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, password);
	}
	
//	@When("I entered the User Data")
//	public void i_entered_the_user_data() {
//		registerObject = new UserRegistrationPage(driver);
//		registerObject.userRegisteration("Omar", "Saad", "omar123saad@gmail.com", "123456");
//	}
	
	@Then("The registration page displayed successfully and user login with {string}, {string}")
	public void the_registration_page_displayed_successfully(String email, String password) {
//		Assert.assertTrue(registerObject.loginLink.isDisplayed());
		Assert.assertTrue(registerObject.successMessage.isDisplayed());
		loginObject = new LoginPage(driver);
		registerObject = new UserRegistrationPage(driver);
		registerObject.userLogin();
		loginObject.UserLogin(email, password);
		
	}
}
