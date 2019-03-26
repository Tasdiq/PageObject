package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;
import org.testng.annotations.Listeners;

@Listeners(Academy.Listeners.class)
public class validateNavBar extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();

	}

	@Test
	public void validateNav() throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);

		//Assert.assertTrue(lp.navigationBar().isDisplayed());
		
		Assert.assertTrue(lp.navigationBar().isDisplayed());
		log.info("navigation bar displayed");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}