package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.ProductReviewPage;

public class AddProductReviewTest extends TestBase {
	
	//1.Registration
	@Test(priority = 1)
	public void registerUser() {
		UserRegistrationTest register = new UserRegistrationTest();
		register.UserCanRegisterSuccessfully();
		register.RegisteredUserCanLogin();
	}
	//2.Search for product
	@Test(priority = 2)
	public void searchProduct() {
		SearchProductUsingAutoSuggest search = new SearchProductUsingAutoSuggest();
		search.UserCanSearchWithAutoSuggest("Apple MacBook Pro 13-inch");
	}
	//3.Email to friend
	@Test(priority = 3)
	public void addReview() {
		ProductDetailsPage detailsObject = new ProductDetailsPage(driver);
		detailsObject.openAddReview();;
		ProductReviewPage reviewObject = new ProductReviewPage(driver);
		reviewObject.addProductReview("Omar Review", "This product is very Bad.");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("successfully added"));
	}

}
