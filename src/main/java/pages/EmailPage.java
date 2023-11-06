package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id="FriendEmail")
	WebElement emailFriend;
	
	@FindBy (id="YourEmailAddress")
	WebElement personalEmail;
	
	@FindBy (id="PersonalMessage")
	WebElement messageSent;
	
	@FindBy (css="button.button-1.send-email-a-friend-button")
	WebElement submitBtn;
	
	@FindBy (css="div.result")
	public WebElement messageNotification;
	
	public void sendEmailToFriend(String email, String message)
	{
		setTextInElement(emailFriend, email);
		setTextInElement(messageSent, message);
		clickButton(submitBtn);
		
	}

}
