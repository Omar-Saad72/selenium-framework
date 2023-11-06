package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.WishListPage;

public class AddToProductWishListTest extends TestBase {

	SearchProductUsingAutoSuggest searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishlistObject;
	
	@Test(priority = 1)
	public void userSearch() {
		searchObject = new SearchProductUsingAutoSuggest();
		searchObject.UserCanSearchWithAutoSuggest("Apple MacBook Pro 13-inch");
	}
	
	@Test(priority = 2)
	public void UserCanAddProductToWishList() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addWishList();
		wishlistObject = new WishListPage(driver);
		Assert.assertTrue(wishlistObject.wishListTitle.getText().equalsIgnoreCase("Wishlist"));
	}
	
	
	@Test(priority = 3)
	public void UserCanRemoveProductToWishList() {
		wishlistObject = new WishListPage(driver);
		wishlistObject.removeProdcutFromWishList();
		Assert.assertTrue(wishlistObject.emptywishList.getText().equalsIgnoreCase("The wishlist is empty!"));
	}
}
