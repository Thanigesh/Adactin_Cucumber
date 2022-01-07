package poManager;

import org.openqa.selenium.WebDriver;

import pageObject.BookingPage;
import pageObject.LogInPage;
import pageObject.LogOutPage;
import pageObject.SearchHotelPage;
import pageObject.SelectHotelPage;

public class Manager {

	public static WebDriver driver;
	private LogInPage lip;
	private SearchHotelPage sh;
	private SelectHotelPage seh;
	private BookingPage bp;
	private LogOutPage lop;

	public Manager(WebDriver pmdriver) {
		this.driver = pmdriver;
	}

	public LogInPage getLip() {
		lip = new LogInPage(driver);
		return lip;
	}

	public SearchHotelPage getSh() {
		sh = new SearchHotelPage(driver);
		return sh;
	}

	public SelectHotelPage getSeh() {
		seh = new SelectHotelPage(driver);
		return seh;
	}

	public BookingPage getBp() {
		bp = new BookingPage(driver);
		return bp;
	}

	public LogOutPage getLop() {
		lop = new LogOutPage(driver);
		return lop;
	}
}