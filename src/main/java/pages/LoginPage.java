package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(css="button.button-1.login-button")
	WebElement loginBtn;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;
	
	
	public void UserLogin(String email, String password) 
	{
		setTextInElement(emailTxtBox, email);
		setTextInElement(passwordTxtBox, password);
		clickButton(loginBtn);
	}
	
	public void openMyAccount() {
		clickButton(myAccountLink);
	}
	
	public void logOut() {
		clickButton(logoutLink);
	}

}
