package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	By signIn = By.cssSelector("a[href*='sign_in']"); 
	By titleFC = By.cssSelector(".text-center>h2");
	By navBar = By.cssSelector(".navbar-collapse.collapse");
	By popUp = By.cssSelector(".listbuilder-popup-scale");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}



	public WebElement getLogin() {
		return driver.findElement(signIn);
	}
	
	public WebElement getTitle() {
		return driver.findElement(titleFC);
	}
	
	public WebElement navigationBar(){
		return driver.findElement(navBar);
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popUp);
	}
}
