package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;

public class RegisteredUserCheckoutProdcutTest extends TestBase {
	
	String productName = "Apple MacBook Pro 13-inch";
	
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
		search.UserCanSearchWithAutoSuggest(productName);
	}
	
	//3.Add To Cart and Checkout
	@Test(priority = 3)
	public void addToCartandCheckout() throws InterruptedException {
		ProductDetailsPage detailsObject = new ProductDetailsPage(driver);
		detailsObject.addToCart();
		CartPage cartObject = new CartPage(driver);
//		Assert.assertTrue(cartObject.productName.getText().contains(productName));
		cartObject.openCheckoutPage();
		CheckoutPage checkoutObject = new CheckoutPage(driver);
		checkoutObject.registeredUserCheckoutProduct("Egypt", "Cairo", "1112", "011123","Cairo");
		checkoutObject.confirmOrder();
		Thread.sleep(3000);
		Assert.assertTrue(checkoutObject.successNotification.getText().contains("successfully"));
		checkoutObject.goToPrintOrder();
		OrderDetailsPage orderObject = new OrderDetailsPage(driver);
		orderObject.downloadInvoice();
		orderObject.printOrderDetails();
		Thread.sleep(3000);
	}

}
