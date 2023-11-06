package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class ChangeCurrencyTest extends TestBase{
	
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchProductUsingAutoSuggest searchTest;
	
	@Test
	public void UserCanChangeCurrency() {
		
		homeObject = new HomePage(driver);
		homeObject.chagneCurrency("Euro");
		
		searchTest = new SearchProductUsingAutoSuggest();
		searchTest.UserCanSearchWithAutoSuggest("Apple MacBook Pro 13-inch");
		
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productPriceLabel.getText().contains("€"));
		
		
	}

}
