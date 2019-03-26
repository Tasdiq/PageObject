package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

//@Listeners(Academy.Listeners.class)
public class validateTitle extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver initialized");

	}

	@Test
	public void validateTitles() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("navigated to homepage");

		LandingPage lp = new LandingPage(driver);

		String title = driver.getTitle();
		String fcTitle = lp.getTitle().getText();

		Assert.assertTrue(title.contains("QA Click Academy"));
		log.info("validated page title");

		Assert.assertEquals(fcTitle, "FEATURED COURSES");
		log.info("Validated feature courses title");

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver = null;
	}

}
