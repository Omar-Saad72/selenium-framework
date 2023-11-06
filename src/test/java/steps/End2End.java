package steps;

import org.testng.Assert;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class End2End extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	CartPage cartObject;
	CheckoutPage checkoutObject;
	
	Faker fakeData = new Faker();
	String fname = fakeData.name().firstName();
	String lname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	
	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(fname, lname, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		registerObject.userLogin();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(loginObject.logoutLink.isDisplayed());
	}
	@When("he search for {string}")
	public void he_search_for(String productName) {
		searchObject = new SearchPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetails();
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productName.getText().equalsIgnoreCase(productName));
	}
	@When("choose to buy two items")
	public void choose_to_buy_two_items()  {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addToCart();
	}
	@When("move to checkout cart and enter personal details on checkout page and place order")
	public void move_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_order() throws InterruptedException {
		cartObject = new CartPage(driver);
		cartObject.openCheckoutPage();
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.registeredUserCheckoutProduct("Egypt", "Cairo", "1112", "011123","Cairo");
		checkoutObject.confirmOrder();
		Thread.sleep(3000);
		Assert.assertTrue(checkoutObject.successNotification.getText().contains("successfully"));

	}
	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() {
//		checkoutObject = new CheckoutPage(driver);
//		checkoutObject.goToPrintOrder();
//		OrderDetailsPage orderObject = new OrderDetailsPage(driver);
//		orderObject.downloadInvoice();
//		orderObject.printOrderDetails();
	}

}
