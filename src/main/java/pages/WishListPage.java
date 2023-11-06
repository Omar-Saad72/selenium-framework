package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className = "product-name")
	WebElement productName;
	
	@FindBy(className = "page-title")
	public WebElement wishListTitle;
	
	@FindBy(className = "remove-btn")
	WebElement removeBtn;
	
	@FindBy(id = "updatecart")
	WebElement updateBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement emptywishList;
	
	public void removeProdcutFromWishList() {
		clickButton(removeBtn);
//		clickButton(updateBtn);
	}
	

}
