package check;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButton {
	
	WebDriver driver ;
	
	@Test(priority=0)
	public void iniatialize() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/radio.html");
		
	}
	
	@Test(priority=1)
	public void radioButtonTest() {
		
		List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
		for(int i=0; i< radioButtons.size();i++) {
			System.out.println("Selecting of option "+(i+1));
			radioButtons.get(i).click();
			for(int j=0;j<radioButtons.size();j++) {
				if(j==i) {
					Assert.assertEquals(true, radioButtons.get(j).isSelected());
				}
				else {
					Assert.assertEquals(false, radioButtons.get(j).isSelected());
				}
			}
		}
		System.out.println("Radio Buttons working fine");
	}
	
	@Test(priority=2)
	public void checkboxTest() {
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("CheckBoxes size= "+checkBoxes.size());
		for(int i =0;i<checkBoxes.size();i++) {
			System.out.println("Selection of Checkbox "+(i+1));
			checkBoxes.get(i).click();
			for(int j=0;j<checkBoxes.size();j++) {
				if(j<=i) {
					Assert.assertEquals(true,checkBoxes.get(j).isSelected());
				}
				else {
					Assert.assertEquals(false, checkBoxes.get(j).isSelected());
				}
			}
		}
		System.out.println("Checkboxes are working fine");
		
	}
	
	@Test(priority=3,enabled=true)
	public void teardown() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver);
		//wait.withTimeout(Duration (TimeUnit.)10);
		Thread.sleep(5000);
		driver.close();
		driver=null;
	}
}
