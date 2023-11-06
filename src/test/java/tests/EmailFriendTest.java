package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.ProductDetailsPage;

public class EmailFriendTest extends TestBase{

	//1.Registration
	@Test(priority = 1)
	public void registerUser() {
		UserRegistrationTest register = new UserRegistrationTest();
		register.UserCanRegisterSuccessfully();
//		register.RegisteredUserCanLogin();
	}
	//2.Search for product
	@Test(priority = 2)
	public void searchProduct() {
		SearchProductUsingAutoSuggest search = new SearchProductUsingAutoSuggest();
		search.UserCanSearchWithAutoSuggest("Apple MacBook Pro 13-inch");
	}
	//3.Email to friend
	@Test(priority = 3)
	public void sendEmail() {
		ProductDetailsPage detailsObject = new ProductDetailsPage(driver);
		detailsObject.openSendEmail();
		EmailPage emailObject = new EmailPage(driver);
		emailObject.sendEmailToFriend("Ahmed@test.com", "Hello, My Friend");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("has been sent"));
	}
}
