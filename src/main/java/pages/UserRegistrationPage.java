package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id="FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id="LastName")
	WebElement lnTxtBox;
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmpasswordTxtBox;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	@FindBy(linkText = "Log in")
	public WebElement loginLink;
	

	public void userRegisteration(String firstName, String lastName, String email, String password) {
		clickButton(genderRdoBtn);
		setTextInElement(fnTxtBox, firstName);
		setTextInElement(lnTxtBox, lastName);
		setTextInElement(emailTxtBox, email);
		setTextInElement(passwordTxtBox, password);
		setTextInElement(confirmpasswordTxtBox, password);
		clickButton(registerBtn);
	}
	
	public void userLogin() {
		clickButton(loginLink);
	}
	
	
}
