package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
public WebDriver driver;
	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By submit = By.cssSelector("input[type ='submit']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver; 
	}



	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPwd() {
		return driver.findElement(password);
	}
	
	public WebElement submitBtn() {
		return driver.findElement(submit);
	}
}
