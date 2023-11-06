package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase{

	String productName ="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void UserCanSearchWithAutoSuggest(String searchTxt) {
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest(searchTxt);
		detailsObject = new ProductDetailsPage(driver);
//		Assert.assertTrue(detailsObject.productName.getText().equalsIgnoreCase(productName));
	}
}
