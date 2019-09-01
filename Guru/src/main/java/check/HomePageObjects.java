package check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
	public WebDriver driver;
	
	By username = By.xpath("//input[@name='uid']");
	By password = By.cssSelector("input[name='password']");
	By loginButton = By.cssSelector("input[name='btnLogin']");
	
	HomePageObjects(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
}
