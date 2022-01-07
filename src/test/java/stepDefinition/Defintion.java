package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.cucumber.adactin.BaseClass;

import helper.Manager_Reader;
import io.cucumber.java.en.*;
import poManager.Manager;
//import pageObjectManager.BookingPage;
//import pageObjectManager.LogInPage;
//import pageObjectManager.LogOutPage;
//import pageObjectManager.SearchHotelPage;
//import pageObjectManager.SelectHotelPage;
import testRunner.Runner;

public class Defintion extends BaseClass{
	public static WebDriver driver = Runner.driver;
	Manager m = new Manager(driver);
//	LogInPage lip = new LogInPage(driver);
//	SearchHotelPage shp = new SearchHotelPage(driver);
//	SelectHotelPage slhp = new SelectHotelPage(driver);
//	BookingPage bp = new BookingPage(driver);
//	LogOutPage lop = new LogOutPage(driver);

	@Given("User opens url")
	public void user_opens_url() throws Throwable {
		get(Manager_Reader.getInstance().getInstanceR().getUrl());
		wait("impwait", 5, TimeUnit.SECONDS);
	}

	@When("User enters username {string} with valid credentials")
	public void user_enters_username_with_valid_credentials(String username) {
//		WebElement uname = findElementBy("xpath", "//input[@name='username']");
		type(m.getLip().getUsername(), username);
	}

	@When("User enters password {string} with valid credentials")
	public void user_enters_password_with_valid_credentials(String password) {
//		WebElement pwd = findElementBy("xpath", "//input[@name='password']");
		type(m.getLip().getPassword(), password);
	}

	@Then("User clicks login Button")
	public void user_clicks_login_button() {
//		WebElement login = findElementBy("xpath", "//input[@name='login']");
		click(m.getLip().getLogin());
	}
	
	@Then("Verifying the navigation from homepage to search hotel")
	public void verifying_the_navigation_from_homepage_to_search_hotel() {
		String shttl = driver.getTitle();
		Assert.assertEquals(shttl, "Adactin.com - Search Hotel");
	}

	@Given("User selects location from dropdown {string}")
	public void user_selects_location_from_dropdown(String location) {
		dropdown("xpath", "//select[@name='location']", location);
	}

	@Then("User selects hotel from the list {string}")
	public void user_selects_hotel_from_the_list(String hotel) {
		dropdown("xpath", "//select[@name='hotels']", hotel);
	}

	@Then("User selects room type {string}")
	public void user_selects_room_type(String rt) {
		dropdown("xpath", "//select[@name='room_type']", rt);
	}
	
	@Then("User selects number of rooms {string}")
	public void user_selects_number_of_rooms(String nor) {
		dropdown("xpath", "//select[@name='room_nos']", nor);
	}

	@Then("User selects Adults per room {string}")
	public void user_selects_adults_per_room(String apr) {
		dropdown("xpath", "//select[@name='adult_room']", apr);
	}

	@Then("User selects Children per room {string}")
	public void user_selects_children_per_room(String cpr) {
		dropdown("xpath", "//select[@name='child_room']", cpr);
	}

	@Then("User clicks Search button")
	public void user_clicks_search_button() {
//		WebElement srch = findElementBy("xpath", "//input[@type='submit']");
		click(m.getSh().getSubmit());
	}

	@Then("Verifying the navigation from Search hotel to Select hotel")
	public void verifying_the_navigation_from_search_hotel_to_select_hotel() {
		String shttl = driver.getTitle();
		Assert.assertEquals(shttl, "Adactin.com - Select Hotel");

	}

	@Given("User select a hotel from the list")
	public void user_select_a_hotel_from_the_list() {
//		WebElement btn = findElementBy("xpath", "//input[@type='radio']");
		click(m.getSeh().getRbtn());
	}

	@Given("Clicks continue button")
	public void clicks_continue_button() {
//		WebElement contn = findElementBy("xpath", "//input[@value='Continue']");
		click(m.getSeh().getContn());
	}

	@Then("Verifying the navigation from Select hotel to Book a hotel")
	public void verifying_the_navigation_from_select_hotel_to_book_a_hotel() {
		String bhttl = driver.getTitle();
		Assert.assertEquals(bhttl, "Adactin.com - Book A Hotel");

	}

	@Given("User enters First name {string}")
	public void user_enters_first_name(String fname) {
//		WebElement fname = findElementBy("xpath", "//input[@id='first_name']");
		type(m.getBp().getFname(), fname);
	}

	@Given("User enters last name {string}")
	public void user_enters_last_name(String lname) {
//		WebElement lname = findElementBy("xpath", "//input[@id='last_name']");
		type(m.getBp().getLname(), lname);
	}

	@Then("User enters billing address {string}")
	public void user_enters_billing_address(String address) {
//		WebElement addr = findElementBy("xpath", "//textarea[@id='address']");
		type(m.getBp().getAddrs(), address);
	}

	@Then("Credit card number")
	public void credit_card_number() throws Throwable {
//		WebElement cc = findElementBy("xpath", "//input[@id='cc_num']");
		type(m.getBp().getCc(), Manager_Reader.getInstance().getInstanceR().getCc_num());
	}

	@Then("Credit card type from dropdown")
	public void credit_card_type_from_dropdown() throws Throwable {
		dropdown("xpath", "//select[@name='cc_type']", Manager_Reader.getInstance().getInstanceR().getCc_type());
	}

	@Then("User selects expiry month from dropdown")
	public void user_selects_expiry_month_from_dropdown() throws Throwable {
		dropdown("xpath", "//select[@name='cc_exp_month']", Manager_Reader.getInstance().getInstanceR().getCc_expmt());
	}

	@Then("Selects expiry year from dropdown")
	public void selects_expiry_year_from_dropdown() throws Throwable {
		dropdown("xpath", "//select[@name='cc_exp_year']", Manager_Reader.getInstance().getInstanceR().getCc_expyr());
	}

	@Then("User enters cvv number")
	public void user_enters_cvv_number() throws Throwable {
//		WebElement cvv = findElementBy("xpath", "//input[@id='cc_cvv']");
		type(m.getBp().getCvv(), Manager_Reader.getInstance().getInstanceR().getCvv());
	}

	@Then("User clicks Book Now button")
	public void user_clicks_book_now_button() {
//		WebElement bknow = findElementBy("xpath", "//input[@value='Book Now']");
		click(m.getBp().getBook());
	}

	@Then("Verifying the navigation from Book a  hotel Page to hotel Booking Confirmation Page")
	public void verifying_the_navigation_from_book_a_hotel_page_to_hotel_booking_confirmation_page() throws InterruptedException {
		String cfttl = driver.getTitle();
		Assert.assertEquals(cfttl, "Adactin.com - Book A Hotel");
		Thread.sleep(2000);
	}

	@Given("User takes screenshot of Confirmation Page")
	public void user_takes_screenshot_of_confirmation_page() {
		ss();
	}

	@Given("User clicks logout button")
	public void user_clicks_logout_button() {
//		WebElement logout = findElementBy("xpath", "//input[@value='Logout']");
		click(m.getLop().getLogout());
	}

	@Then("Verifying the navigation from Hotel Booking Confirmation Page to Logout Page")
	public void verifying_the_navigation_from_hotel_booking_confirmation_page_to_logout_page() {
		String lottl = driver.getTitle();
		Assert.assertEquals(lottl, "Adactin.com - Logout");
	}

	@Given("User closes browser")
	public void user_closes_browser() {
		quit();
	}
}
