package check;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Click {

	@Test
	public void clickTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tooltip-and-double-click/");
		WebElement doubleClick;
		WebElement rightClick;
		doubleClick = driver.findElement(By.id("doubleClickBtn"));
		rightClick = driver.findElement(By.id("rightClickBtn"));
		Actions a = new Actions(driver);
		a.doubleClick(doubleClick).build().perform();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		a.contextClick(rightClick).build().perform();
		a.click(driver.findElement(By.xpath("//div[contains(text(),'Edit')]"))).build().perform();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		driver=null;
	}
}
