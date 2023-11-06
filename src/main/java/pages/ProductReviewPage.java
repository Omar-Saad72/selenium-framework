package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewText;
	
	@FindBy(id="addproductrating_1")
	WebElement ratingRdoBtn;
	
	@FindBy(css="button.button-1.write-product-review-button")
	WebElement submitBtn;
	
	@FindBy(css="div.result")
	public WebElement reviewNotification;
	
	public void addProductReview(String reviewTitle, String reviewMessage) {
		setTextInElement(reviewTitleTxt, reviewTitle);
		setTextInElement(reviewText, reviewMessage);
		clickButton(ratingRdoBtn);
		clickButton(submitBtn);
	}
}
