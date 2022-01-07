package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
	public static WebDriver driver;
	
	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement fname;

	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement lname;

	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addrs;

	@FindBy(xpath = "//input[@id='cc_num']")
	private WebElement cc;

	@FindBy(xpath = "//select[@name='cc_type']")
	private WebElement cctype;

	@FindBy(xpath = "//select[@name='cc_exp_month']")
	private WebElement expmnt;

	@FindBy(xpath = "//select[@name='cc_exp_year']")
	private WebElement expyr;

	@FindBy(xpath = "//input[@id='cc_cvv']")
	private WebElement cvv;

	@FindBy(xpath = "//input[@value='Book Now']")
	private WebElement book;

	public BookingPage(WebDriver bpdriver) {
		this.driver = bpdriver;
		PageFactory.initElements(bpdriver, this);
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getAddrs() {
		return addrs;
	}

	public WebElement getCc() {
		return cc;
	}

	public WebElement getCctype() {
		return cctype;
	}

	public WebElement getExpmnt() {
		return expmnt;
	}

	public WebElement getExpyr() {
		return expyr;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBook() {
		return book;
	}

}
