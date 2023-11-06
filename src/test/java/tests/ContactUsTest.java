package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage homeObject;
	ContactUsPage contactUsObject;
	
	String fullName = "Test User"; 
	String email = "test@test.com";
	String enquiry = "Hello, This is for Test only.";
	
	@Test
	public void UserCanUseContactUs() {
		homeObject = new HomePage(driver);
		homeObject.openContactUsPage();
		contactUsObject = new ContactUsPage(driver);
		contactUsObject.contactUs(fullName, email, enquiry);
		Assert.assertTrue(contactUsObject.successMessage.getText().contains("has been successfully"));
	}
}
