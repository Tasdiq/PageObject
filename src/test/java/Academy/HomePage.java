package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger logging = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();

	}

	@Test(dataProvider = "getData")
	public void baseNavigate(String username, String password, String text) throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		logging.info("navigated to homepage");

		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ESCAPE).build().perform();

		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		logging.info("clicked on login button link on HomePage");

		LoginPage log = new LoginPage(driver);
		log.getEmail().sendKeys(username);
		log.getPwd().sendKeys(password);
		log.submitBtn().click();
		logging.info("entered credentials and submitted ");

		// System.out.println(text);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "email@email.com";
		data[0][1] = "password";
		data[0][2] = "restricted";

		data[1][0] = "non-restricted@restrict.com";
		data[1][1] = "password24";
		data[1][2] = "non-restricted";

		return data;
	}

}
