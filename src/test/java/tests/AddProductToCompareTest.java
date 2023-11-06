 package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class AddProductToCompareTest extends TestBase{
	
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	ComparePage compareObject;
	SearchProductUsingAutoSuggest searchObject;
	

	@Test(priority = 1)
	public void UserCanCompareProducts() {
		searchObject = new SearchProductUsingAutoSuggest();
		searchObject.UserCanSearchWithAutoSuggest(firstProductName);
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productName.getText().equalsIgnoreCase(firstProductName));
		detailsObject.addToCompare();
		
		searchObject.UserCanSearchWithAutoSuggest(secondProductName);
		Assert.assertTrue(detailsObject.productName.getText().equalsIgnoreCase(secondProductName));
		detailsObject.addToCompare();
		detailsObject.goToCompare();
		
		
		compareObject = new ComparePage(driver);
		Assert.assertTrue(compareObject.firstProductName.isDisplayed());
		Assert.assertTrue(compareObject.secondProductName.isDisplayed());
		compareObject.compareProducts();
	}

	@Test(priority = 2)
	public void UserCanClearCompareList() {
		compareObject.clearCompareTable();
		Assert.assertTrue(compareObject.noDataLabel.getText().contains("no items"));
	}
}
	
