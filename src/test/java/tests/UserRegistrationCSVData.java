package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationCSVData extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	CSVReader reader ;
	
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException {
		
		String cvsPath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(cvsPath));
		String [] csvCell;
		while((csvCell = reader.readNext()) != null) 
		{
			String fname = csvCell[0];
			String lname = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
			
			homeObject = new HomePage(driver);
			homeObject.openRegisterationPage();
			registerObject = new UserRegistrationPage(driver);
			registerObject.userRegisteration(fname, lname, email, password);
			Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
			
			registerObject.userLogin();
			loginObject = new LoginPage(driver);
			loginObject.UserLogin(email, password);
			Assert.assertTrue(loginObject.logoutLink.isDisplayed());
			loginObject.logOut();
			
		}
		
	}
	
}
