package check;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {
	public static WebDriver driver;
	
	public WebDriver initializeDriver() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Toshiba\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.setCapability("marionette", false);
		driver = new FirefoxDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
