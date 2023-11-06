package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className = "clear-list")
	WebElement clearListLink;
	
	@FindBy(className = "no-data")
	public WebElement noDataLabel;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	public List<WebElement> allColumns;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement firstProductName;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement secondProductName;
	
	public void clearCompareTable() {
		clickButton(clearListLink);
	}
	
	public void compareProducts() {
//		System.out.println(allRows.size());
		
		for (WebElement row : allRows) {
			System.out.println(row.getText()+"\t");
//			for (WebElement column : allColumns) {
//				System.out.println(column.getText()+"\t");
//			}
		}
	}

}
