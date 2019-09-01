package check;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scroll {
	
	@Test
	public void ScrollTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.guru99.com/scroll-up-down-selenium-webdriver.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement summary = driver.findElement(By.xpath("//h2[contains(text(),'Summary')]"));
		js.executeScript("arguments[0].scrollIntoView();", summary);
		Thread.sleep(50000);
		driver.findElement(By.cssSelector("#scrollToTop")).click();
		Thread.sleep(50000);
		Long y = (Long) js.executeScript("return window.pageYOffset");
		Assert.assertTrue(y==0,"Not reached top of screen");
		Assert.assertFalse(driver.findElement(By.cssSelector("#scrollToTop")).isDisplayed());
		
		
	}

}
