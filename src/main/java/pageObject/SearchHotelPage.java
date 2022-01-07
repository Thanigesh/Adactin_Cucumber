package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {
	public static WebDriver driver;
	
	@FindBy(xpath = "//select[@name='location']")
	private WebElement location;
	
	@FindBy(xpath = "//select[@name='hotels']")
	private WebElement hotel;
	
	@FindBy(xpath = "//select[@name='room_type']")
	private WebElement roomtype;
	
	@FindBy(xpath = "//select[@name='room_nos']")
	private WebElement roomnos;
	
	@FindBy(xpath = "//select[@name='adult_room']")
	private WebElement adultroom;
	
	@FindBy(xpath = "//select[@name='child_room']")
	private WebElement childRoom;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;

	public SearchHotelPage(WebDriver shdriver) {
		this.driver = shdriver;
		PageFactory.initElements(shdriver, this);
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomtype() {
		return roomtype;
	}

	public WebElement getRoomnos() {
		return roomnos;
	}

	public WebElement getAdultroom() {
		return adultroom;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}

	public WebElement getSubmit() {
		return submit;
	}
}
