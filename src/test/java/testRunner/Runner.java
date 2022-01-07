package testRunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.adactin.BaseClass;

import helper.Manager_Reader;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//features//Adactin.feature", 
				 glue = "stepDefinition", 
				 dryRun = false, 
				 monochrome = true, 
				 plugin = {"pretty", "html:test-output.html" })
public class Runner {
	public static WebDriver driver;

	@BeforeClass
	public static void set_Up() throws Throwable {
		String browser = Manager_Reader.getInstance().getInstanceR().getBrowser();
		driver = BaseClass.browser(browser);
	}
}