package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	public static WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement login;

	public LogInPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
}