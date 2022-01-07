package stepDefinition;

import com.cucumber.adactin.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Hooks extends BaseClass {
	@Before
	public void beforeHooks(Scenario scene) {
		String title = scene.getName();
		System.out.println("Scenario Title is: " + title);
	}

	@After
	public void afterHooks(Scenario scene) {
		Status status = scene.getStatus();
		System.out.println("Scenario Status is: " + status);
		if (scene.isFailed()) {
			ss();
		}
	}
}