package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (className ="remove-from-cart")
	WebElement removeFromCart;
	
	@FindBy (id ="updatecart")
	WebElement updateCart;
	
	@FindBy (id ="itemquantity11224")
	WebElement quantityTxt;
	
	@FindBy (className ="product-subtotal")
	WebElement totalLabel;
	
	@FindBy (className ="product")
	public WebElement productName;
	
	@FindBy (id ="checkout")
	WebElement checkoutBtn;
	
	@FindBy (id ="termsofservice")
	WebElement agreeFlag;
	
	
	
	public void removeFromCart() {
		clickButton(removeFromCart);
	}
	
	public void updateProductQuantityInCart(String quantity) {
		clearTest(quantityTxt);
		setTextInElement(quantityTxt, quantity);
		clickButton(updateCart);
	}
	
	public void openCheckoutPage() {
		clickButton(agreeFlag);
		clickButton(checkoutBtn);
	}

	
	

}
