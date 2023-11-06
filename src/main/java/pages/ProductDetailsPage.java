package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className ="product-name")
	public WebElement productName;
	
	@FindBy(css="button.button-2.email-a-friend-button")
	public WebElement emailBtn;
	
	@FindBy(id="price-value-4")
	public WebElement productPriceLabel;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addTowishListBtn;
	
	@FindBy(linkText = "wishlist")
	WebElement wishListBtn;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement compareBtn;
	
	@FindBy(className = "close")
	WebElement closeBtn;
	
	@FindBy(linkText = "product comparison")
	WebElement comparePage;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCartBtn;
	
	@FindBy(linkText = "shopping cart")
	WebElement openCartBtn;
	
	
	
	public void openSendEmail() {
		clickButton(emailBtn);
	}

	public void openAddReview() {
		clickButton(addReviewLink);
	}
	
	public void addWishList() {
		clickButton(addTowishListBtn);
		clickButton(wishListBtn);
	}
	
	public void addToCompare() {
		clickButton(compareBtn);
		clickButton(closeBtn);
	}
	
	public void goToCompare() {
		clickButton(comparePage);
	}
	
	public void addToCart() {
		clickButton(addToCartBtn);
		clickButton(openCartBtn);
	}
	

}
