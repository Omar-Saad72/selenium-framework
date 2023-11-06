package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver); 
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id="customerCurrency")
	WebElement currencyList;
	
	@FindBy(linkText = "Computers")
	WebElement computerMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement noteBookMenu;
	
	public void openRegisterationPage() {
//		registerLink.click();
		clickButton(registerLink);
	}
	
	public void openLoginPage() {
		clickButton(loginLink);
	}

	public void openContactUsPage() {
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	public void chagneCurrency(String currency) {
		select = new Select(currencyList);
		select.selectByVisibleText(currency);
	}

	public void selectNotebooksMenu() {
//		 action.moveToElement(computerMenu).moveToElement(noteBookMenu).click().build().perform();
		 action.moveToElement(computerMenu).build().perform();
		 action.moveToElement(noteBookMenu).click().build().perform();
//		 clickButton(noteBookMenu);
	}
}
