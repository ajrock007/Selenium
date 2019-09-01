package check;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SingtelCart {
	
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void reachCart() throws InterruptedException {
		driver.get("https://www.singtel.com/personal/products-services/mobile/postpaid-plans");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1000,1000)");
		By comboPlan  = By.xpath("//div[contains(text(),'Combo Plans')]");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(comboPlan));
		driver.findElement(comboPlan).click();
		driver.findElement(By.xpath("//span[contains(text(),'$68.90')]")).click();
		Thread.sleep(10000);
	}
	
	@Test(dependsOnMethods="reachCart")
	public void asumCart() {
		
		driver.navigate().to("https://www.singtel.com/personal/products-services/shopping-cart");
		WebElement upperSummary = driver.findElement(By.xpath("//div[@class='ux-summary-accordion']"));
		List <WebElement> oneTimeCharges = upperSummary.findElements(By.xpath(".//div[@class='medium-2 one-time-price columns']/div"));
		float sum =0;
		System.out.println(oneTimeCharges.size());
		for(int i=0;i<oneTimeCharges.size();i++) {
			String charge = oneTimeCharges.get(i).getText();
			System.out.println(charge);
			float lCharge = Float.parseFloat(charge.substring(1));
			sum = sum + lCharge;
			
		}
		
		WebElement TotalCharge = upperSummary.findElement(By.xpath("//div[@class='row subtotal-row v-large-top']/div[2]/div"));
		float total = Float.parseFloat(TotalCharge.getText().substring(1));
		Assert.assertEquals(total,sum);
		
		
	}

}
