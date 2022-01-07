package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {
	public static WebDriver driver;

	@FindBy(xpath = "//input[@type='radio']")
	private WebElement rbtn;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement contn;

	public SelectHotelPage(WebDriver selhpdriver) {
		this.driver = selhpdriver;
		PageFactory.initElements(selhpdriver, this);
	}

	public WebElement getRbtn() {
		return rbtn;
	}

	public WebElement getContn() {
		return contn;
	}
}