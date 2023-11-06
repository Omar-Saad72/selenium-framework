package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.ProductDetailsPage;

public class AddProductToShoppingCartTest extends TestBase{
	
	ProductDetailsPage detailsObject;
	SearchProductUsingAutoSuggest searchObject;
	CartPage cartObject;
	String firstProductName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void addToCart() {
		searchObject = new SearchProductUsingAutoSuggest();
		searchObject.UserCanSearchWithAutoSuggest(firstProductName);
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productName.getText().equalsIgnoreCase(firstProductName));
		detailsObject.addToCart();
		cartObject = new CartPage(driver);
		Assert.assertTrue(cartObject.productName.getText().equalsIgnoreCase(firstProductName));
	}
	
	@Test(priority = 2)
	public void removeFromCart() {
		cartObject = new CartPage(driver);
		cartObject.removeFromCart();
	}

}
