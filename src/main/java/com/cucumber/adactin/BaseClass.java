package com.cucumber.adactin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static WebElement element;
	public static Robot r;
	public static Actions ac;
	public static TakesScreenshot ss;
	public static Select s;

//															Browser launch()
	public static WebDriver browser(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}

			else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			
			else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty(("user.dir") + "\\Driver\\chromedriver.exe"));
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			}

			else {
				System.out.println("Invalid Condition");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}
//                                                              Locators
	public static WebElement findElementBy(String locator, String value) {
		try {
			switch (locator) {
			case "id":
				return driver.findElement(By.id(value));
			case "name":
				return driver.findElement(By.name(value));
			case "className":
				return driver.findElement(By.className(value));
			case "tagName":
				return driver.findElement(By.tagName(value));
			case "xpath":
				return driver.findElement(By.xpath(value));
			case "cssSelector":
				return driver.findElement(By.cssSelector(value));
			case "linkText":
				return driver.findElement(By.linkText(value));
			case "partialLinkText":
				return driver.findElement(By.partialLinkText(value));
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
//	                                                            Close() (Driver Methods)
	public static void close() {
		driver.close();
	}
//                                                             	Quit() (Driver Methods)
	public static void quit() {
		driver.quit();
	}
//                                                          	Navigate to (Driver Methods)
	public static void navto(String value) {
		driver.navigate().to(value);
	}
//                                                             	Navigate back (Driver Methods)
	public static void navback() {
		driver.navigate().back();
	}
//                                                             	Navigate forward (Driver Methods)
	public static void navfor() {
		driver.navigate().forward();
	}
//                                                             	Navigate refresh (Driver Methods)
	public static void navref() {
		driver.navigate().refresh();
	}
//	                                                            Get 
	public static void get(String url) {
		driver.get(url);
	}
//                                                             	Alert
	public static void alert(String alertType) {
		if (alertType.equalsIgnoreCase("alertok")) {
			driver.switchTo().alert().accept();
		}else if (alertType.equalsIgnoreCase("alertnotok")) {
			driver.switchTo().alert().dismiss();
		}else {
			System.out.println("Invalid");
		}
	}
//	                                                            Action
	public static void act(String meth , String valu) {
		if (meth.equalsIgnoreCase("move")) {
			WebElement element = driver.findElement(By.xpath(valu));
			ac = new Actions(driver);
			ac.moveToElement(element).perform();
		} else if (meth.equalsIgnoreCase("click")) {
			WebElement element = driver.findElement(By.xpath(valu));
			ac = new Actions(driver);
			ac.click(element).perform();
		}else if (meth.equalsIgnoreCase("rclick")) {
			WebElement element = driver.findElement(By.xpath(valu));
			ac = new Actions(driver);
			ac.contextClick(element).perform();
		}else {
			System.out.println("Invalid");
		}
	}
//	                                                            Frames
	public static void frame(String frm, String Value) {
		if (frm.equalsIgnoreCase("frameIn")) {
			WebElement findElement = driver.findElement(By.xpath(Value));
			driver.switchTo().frame(findElement);
		}else if (frm.equalsIgnoreCase("frameOut")) {
			driver.switchTo().defaultContent();
		}else {
			System.out.println("Invalid Condition");
		}
	}
//                                                          	Robot
	public static void robot(String movPos) throws AWTException {
		r = new Robot();
		try {
			if (movPos.equalsIgnoreCase("down")) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}else if (movPos.equalsIgnoreCase("Up")) {
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
			}else if (movPos.equalsIgnoreCase("Select")) {
				r.keyPress(KeyEvent.VK_ENTER);
			}else {
				System.out.println("Invalid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	                                                           Window handles
	public static void handle() {
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}
	public static void handles() {
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
	}
	public static void shandle(String id) {
		driver.switchTo().window(id);
	}
//                                                            	Drop down 
	public static void dropdown(String locator, String path, String data) {
		if (locator.equalsIgnoreCase("xpath")) {
			WebElement drop = driver.findElement(By.xpath(path));
			s = new Select(drop);
			s.selectByValue(data);
		}else if (locator.equalsIgnoreCase("id")) {
			WebElement drop = driver.findElement(By.id(path));
			s = new Select(drop);
			s.selectByValue(data);
		}else {
			System.out.println("Invalid");
		}
		
	}
//                                                          	Is enable
	public static void ison() {
		element.isEnabled();
	}
//                                                            	Is displayed
	public static void visible() {
		element.isDisplayed();
	}
//                                                            	Is selected
	public static void sel() {
		element.isSelected();
	}
//	                                                            Get options 
//                                                           	Get title
	public static void gettitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
//	                                                            Get current URL 
	public static void geturl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
//	                                                            Get text 
	public static void gettxt() {
		element.getText();
	}
//	                                                            Get attribute
	public static void getattri(String val) {
		element.getAttribute(val);
	}
//                                                             	Wait(3)
	@SuppressWarnings({ "deprecation"})
	public static void wait(String waitName, long value, TimeUnit unit) {
		try {
			if (waitName.equalsIgnoreCase("impwait")) {
				driver.manage().timeouts().implicitlyWait(value, unit);
			}else if (waitName.equalsIgnoreCase("expwait")) {
				WebDriverWait wait = new WebDriverWait(driver, value);
				wait.until(ExpectedConditions.visibilityOf(element));
			}else {
				System.out.println("Invalid Condition");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	                                                            Take screenshot
	public static void ss() {
		try {
			ss = (TakesScreenshot) driver;
			File source = ss.getScreenshotAs(OutputType.FILE);
			File desh = new File("C:\\Users\\thani\\eclipse-workspace\\Adactin\\ScreenShot");
			FileUtils.copyFileToDirectory(source, desh);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	                                                            Scroll up and down
	public static void scroll(String scrollType, String scrolldown, String scrollup) {
		if (scrollType.equalsIgnoreCase("Scrollup")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", scrollup);
		}else if (scrollType.equalsIgnoreCase("Scrolldown")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", scrolldown);
		}else {
			System.out.println("Invalid");
		}
	}
//                                                              Send-keys
	public static void type(WebElement element, String input) {
		element.sendKeys(input);
	}
//                                                             	Get first selected options()
//                                                          	Get all selected options()
//	                                                            Is multiple()
//	                                                            Click()   
	public static void click(WebElement element) {
		element.click();
	}
}