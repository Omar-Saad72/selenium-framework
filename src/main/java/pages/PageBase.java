package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	protected WebDriver drvier;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;

	//Create Constructor
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton(WebElement button) {
		button.click();
	}
	
	protected static void setTextInElement(WebElement textElement, String Text) {
		textElement.sendKeys(Text);
	}
	
	public void scrollToBottom() {
		jse.executeScript("scrollBy(0,2500)");
	}
	
	public void clearTest(WebElement element) {
		element.clear();
	}
}
