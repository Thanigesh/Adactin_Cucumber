package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	public static WebDriver driver;
	
	@FindBy(xpath = "//input[@value='Logout']")
	private WebElement logout;

	public LogOutPage(WebDriver lopdriver) {
		this.driver = lopdriver;
		PageFactory.initElements(lopdriver, this);
	}

	public WebElement getLogout() {
		return logout;
	}
}