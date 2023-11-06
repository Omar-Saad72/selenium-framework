package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordTxt;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmedPasswordTxt;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(className = "content")
	public WebElement resultOfChange;
	
	@FindBy(linkText = "Log out")
	WebElement logoutLink;
	
	@FindBy(className = "close")
	public WebElement closeNotification;
	
	public void openChangePasswordPage() {
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldpassword, String newpassword) {
		setTextInElement(oldPasswordTxt, oldpassword);
		setTextInElement(newPasswordTxt, newpassword);
		setTextInElement(confirmedPasswordTxt, newpassword);
		clickButton(changePasswordBtn);
	}
	
	public void userLogout(WebDriver driver) {
		
		clickButton(closeNotification);
		
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("close")));
        
		clickButton(logoutLink);
	}

}
