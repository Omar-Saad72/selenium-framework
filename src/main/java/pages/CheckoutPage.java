package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id="BillingNewAddress_FirstName")
	WebElement fnTxt;
	
	@FindBy (id="BillingNewAddress_LastName")
	WebElement lnTxt;
	
	@FindBy (id="BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy (id="BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy (id="BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy (id="BillingNewAddress_Address1")
	WebElement addressTxt1;
	
	@FindBy (id="BillingNewAddress_ZipPostalCode")
	WebElement zipTxt;
	
	@FindBy (id="BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;
	
	@FindBy (id="ShipToSameAddress")
	WebElement sameAddressFlag;
	
	@FindBy (css="button.button-1.new-address-next-step-button")
	WebElement continueBtn;
	
	@FindBy (id="shippingoption_0")
	WebElement shippingMethodFlag;
	
	@FindBy (css="button.button-1.shipping-method-next-step-button")
	WebElement continueBtn2;
	
	@FindBy (id="paymentmethod_0")
	WebElement paymentMethodFlag;
	
	@FindBy (css="button.button-1.payment-method-next-step-button")
	WebElement continueBtn3;
	
	@FindBy (css="button.button-1.payment-info-next-step-button")
	WebElement continueBtn4;
	
	@FindBy (css="button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy (className ="title")
	public WebElement successNotification;

	@FindBy(partialLinkText = "order details.")
	WebElement orderDetailsBtn;
	
	
	public void registeredUserCheckoutProduct(String country, String address, String postCode, String mobile, String city) {
		
		select = new Select(countryList);
		select.selectByVisibleText(country);
		
		setTextInElement(addressTxt1, address);
		setTextInElement(zipTxt, postCode);
		setTextInElement(phoneTxt, mobile);
		setTextInElement(cityTxt, city);
//		clickButton(sameAddressFlag);
		clickButton(continueBtn);
		
		clickButton(shippingMethodFlag);
		clickButton(continueBtn2);
		
		clickButton(paymentMethodFlag);
		clickButton(continueBtn3);
		
		clickButton(continueBtn4);
	}
	
	public void confirmOrder() {
		clickButton(confirmBtn);
	}

	
	public void goToPrintOrder() {
		clickButton(orderDetailsBtn);
	}


}
