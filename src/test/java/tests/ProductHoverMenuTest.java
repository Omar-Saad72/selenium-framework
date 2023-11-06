package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {

	HomePage homeObject;
	
	@Test
	public void UserCanSelectSubCategory() {
		homeObject = new HomePage(driver);
		homeObject.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
