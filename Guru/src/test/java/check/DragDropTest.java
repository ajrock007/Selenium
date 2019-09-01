package check;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDropTest {
	
	@Test
	public void dragdrop() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='button button-orange']"));
		int count = elements.size();
		for(int i=0;i<count;i++) {
			
			Actions a = new Actions(driver);
			WebElement source= elements.get(i);
			a.clickAndHold(source).moveByOffset(10, 10).build().perform();
			//Thread.sleep(2000);
			int check= driver.findElements(By.xpath("//ol[contains(@class,'active')]")).size();
			if(check>0) {
				int visited = driver.findElements(By.xpath("//ol[contains(@class,'active')]/li[@data-id='2']")).size();
				WebElement target = driver.findElements(By.xpath("//ol[contains(@class,'active')]")).get(visited);
				a.release(source).perform();
				a.dragAndDrop(source, target).build().perform();
			}
			else {
				a.release(source).perform();
			}
			
			
		}
		
	}

}
