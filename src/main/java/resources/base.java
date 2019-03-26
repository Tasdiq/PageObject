package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

public class base {
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\TQ\\framework\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\TQ\\Documents\\Workspace\\Drivers\\ChromeDriver\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\TQ\\Documents\\Workspace\\Drivers\\geckodriver\\geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\TQ\\Documents\\Workspace\\Drivers\\IEDriver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenShot(String result) throws Exception {
		
		System.out.println("May day may day");
		
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("C:\\Users\\TQ\\Documents\\Workspace\\SeleniumScreenshots\\"+result+"Screenshot.jpeg"));
		 
	}

}
