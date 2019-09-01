package check;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDowns {
	
	@Test
	public void dropDownTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		WebElement dropdown = driver.findElement(By.cssSelector("select[name='country']"));
		Select s = new Select(dropdown);
		Actions a = new Actions(driver);
		try {
		a.moveToElement(dropdown).build().perform();
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByValue("INDIA");
		String firstValue = s.getFirstSelectedOption().getText();
		
		System.out.println(firstValue);
		}
		catch(Exception e) {
			
			System.out.println("Got Exception "+e+" Aborting");
			driver.close();
		
			
		}
		
	}

}
