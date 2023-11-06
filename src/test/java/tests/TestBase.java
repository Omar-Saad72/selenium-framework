package tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional ("chrome") String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("autofill.profile_enabled", false);
			prefs.put("download.default_directory",System.getProperty("user.dir")+"\\Downloads");
			prefs.put("download.prompt_for_download", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("chrome-headless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920,1080");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!!");
			System.out.println("Taking Screenshot ..");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
	
	
	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
	
}
